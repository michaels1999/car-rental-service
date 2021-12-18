package io.angelwing.car.rental.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Email(message = "Email format is wrong")
    @NotNull(message = "Email is missing")
    private String email;

    @NotBlank(message = "First name is missing")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is missing")
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Reservation> reservations;


    public User() {
        // NOOP
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public Collection<Reservation> getReservations() {
        return reservations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String firstName;

        private String lastName;

        private String email;

        private final Collection<Reservation> reservations = new ArrayList<>();

        private Builder() {
            // NOOP
        }


        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLasName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withReservation(Reservation reservation) {
            this.reservations.add(reservation);
            return this;
        }

        public User build() {
            User user = new User();
            user.firstName = firstName;
            user.lastName = lastName;
            user.email = email;
            user.reservations = reservations;
            return user;
        }
    }
}
