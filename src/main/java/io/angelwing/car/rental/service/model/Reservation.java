package io.angelwing.car.rental.service.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "uuid-char")
    @Column(name = "reservation_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vin_code_id")
    private VinCode vinCode;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    public Reservation() {
        // NOOP
    }

    public UUID getId() {
        return id;
    }

    public VinCode getVinCode() {
        return vinCode;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private UUID id;

        private VinCode vinCode;

        private LocalDateTime startDate;

        private LocalDateTime endDate;

        private Builder() {
            // NOOP
        }

        public Builder withId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder withVinCode(VinCode vinCode) {
            this.vinCode = vinCode;
            return this;
        }

        public Builder withStartDate(LocalDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(LocalDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public Reservation build() {
            Reservation reservation = new Reservation();
            reservation.id = id;
            reservation.vinCode = vinCode;
            reservation.startDate = startDate;
            reservation.endDate = endDate;
            return reservation;
        }
    }
}
