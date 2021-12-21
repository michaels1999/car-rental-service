package io.angelwing.car.rental.service.controller;

import io.angelwing.car.rental.service.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class CallbackController {

    private final AuthorizationService authorizationService;

    @Autowired
    public CallbackController(final AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @GetMapping("{provider}/callback")
    public RedirectView callback(@PathVariable("provider") final String provider, @RequestParam("code") final String code) {
        final String idToken = authorizationService.authorize(provider, code);

        System.out.println(idToken);
        // TODO: send idToken to UI
        return new RedirectView("http://localhost:3000");
    }

}
