package io.angelwing.car.rental.service.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Reservation {

    private UUID id;

    private VinCode vinCode;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    public Reservation(UUID id, VinCode vinCode, LocalDateTime startDate, LocalDateTime endDate) {
        this.id = id;
        this.vinCode = vinCode;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
