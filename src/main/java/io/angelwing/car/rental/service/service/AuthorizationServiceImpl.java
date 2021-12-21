package io.angelwing.car.rental.service.service;

import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.oauth2.sdk.AuthorizationCode;
import com.nimbusds.oauth2.sdk.AuthorizationCodeGrant;
import com.nimbusds.oauth2.sdk.TokenRequest;
import com.nimbusds.oauth2.sdk.TokenResponse;
import com.nimbusds.oauth2.sdk.auth.ClientSecretBasic;
import com.nimbusds.oauth2.sdk.auth.Secret;
import com.nimbusds.oauth2.sdk.http.HTTPResponse;
import com.nimbusds.oauth2.sdk.id.ClientID;
import com.nimbusds.openid.connect.sdk.OIDCAccessTokenResponse;
import com.nimbusds.openid.connect.sdk.OIDCTokenResponseParser;
import io.angelwing.car.rental.service.exception.UserAuthenticationException;
import io.angelwing.car.rental.service.model.User;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final JSONParser jsonParser = new JSONParser(JSONParser.MODE_PERMISSIVE);

    private final Environment environment;
    private final UserService userService;

    @Autowired
    public AuthorizationServiceImpl(final Environment environment, final UserService userService) {
        this.environment = environment;
        this.userService = userService;
    }

    @Override
    public String authorize(final String provider, final String code) {
        try {
            final ClientID clientID = new ClientID(formatProperty("car-rental-service.oauth.{provider}.client.id", provider));
            final Secret secret = new Secret(formatProperty("car-rental-service.oauth.{provider}.client.secret", provider));
            final ClientSecretBasic clientSecretBasic = new ClientSecretBasic(clientID, secret);
            final URI tokenEndpoint = new URI(formatProperty("car-rental-service.oauth.{provider}.token.endpoint", provider));
            final URI callbackEndpoint = new URI(formatProperty("car-rental-service.oauth.{provider}.callback.endpoint", provider));

            final AuthorizationCodeGrant codeGrant = new AuthorizationCodeGrant(
                    new AuthorizationCode(code), callbackEndpoint, clientID);

            final TokenRequest tokenRequest = new TokenRequest(tokenEndpoint, clientSecretBasic, codeGrant);

            final String email;
            final String givenName;
            final String familyName;

            final HTTPResponse response = tokenRequest.toHTTPRequest().send();
            final TokenResponse tokenResponse = OIDCTokenResponseParser
                    .parse(jsonParser.parse(response.getContent(), JSONObject.class));

            if (tokenResponse instanceof OIDCAccessTokenResponse) {
                final OIDCAccessTokenResponse oidcTokenResponse = (OIDCAccessTokenResponse) tokenResponse;

                final JWTClaimsSet jwtClaimsSet = oidcTokenResponse.getIDToken().getJWTClaimsSet();

                email = jwtClaimsSet.getStringClaim("email");
                givenName = jwtClaimsSet.getStringClaim("given_name");
                familyName = jwtClaimsSet.getStringClaim("family_name");

                final User user = User.builder()
                        .withEmail(email)
                        .withFirstName(givenName)
                        .withLasName(familyName)
                        .build();

                if (!userService.exists(email)) {
                    userService.save(user);
                }

                return oidcTokenResponse.getIDTokenString();
            }
        } catch (Exception e) {
            throw new UserAuthenticationException();
        }

        throw new UserAuthenticationException();
    }

    private String formatProperty(final String property, final String provider) {
        return environment.getProperty(property.replace("{provider}", provider));
    }

}
