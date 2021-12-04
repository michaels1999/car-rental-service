package io.angelwing.car.rental.service.model;

import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "car_make")
public class CarMake {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue(generator = "UUID")
    @Column(name = "car_make_id")
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_brand_id")
    private CarBrand carBrand;

    private String name;

    private Integer year;

    @Column(name = "engine_volume")
    private Double engineVolume;

    @Enumerated(EnumType.STRING)
    @Column(name = "body_type")
    private BodyType bodyType;

    @Enumerated(EnumType.STRING)
    @Column(name = "combustion_type")
    private CombustionType combustionType;

    public CarMake() {
        // NOOP
    }

    public CarMake(UUID id, CarBrand carBrand, String name, Integer year, Double engineVolume, BodyType bodyType, CombustionType combustionType) {
        this.id = id;
        this.carBrand = carBrand;
        this.name = name;
        this.year = year;
        this.engineVolume = engineVolume;
        this.bodyType = bodyType;
        this.combustionType = combustionType;
    }

    public UUID getId() {
        return id;
    }

    public CarBrand getCarBrand() {
        return carBrand;
    }

    public String getName() {
        return name;
    }

    public Integer getYear() {
        return year;
    }

    public Double getEngineVolume() {
        return engineVolume;
    }

    public BodyType getBodyType() {
        return bodyType;
    }

    public CombustionType getCombustionType() {
        return combustionType;
    }
}
