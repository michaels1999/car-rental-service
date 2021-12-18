package io.angelwing.car.rental.service.controller;

import io.angelwing.car.rental.service.exception.CarMakeNotFoundException;
import io.angelwing.car.rental.service.model.BodyType;
import io.angelwing.car.rental.service.model.CarMake;
import io.angelwing.car.rental.service.service.CarMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
public class CarMakeController {

    private final CarMakeService carMakeService;

    @Autowired
    public CarMakeController(final CarMakeService carMakeService) {
        this.carMakeService = carMakeService;
    }

    @GetMapping("car-makes")
    public Collection<CarMake> findAll(@RequestParam(value = "bodyType", required = false) final BodyType bodyType) {
        if (bodyType != null) {
            return carMakeService.findByBodyType(bodyType);
        }
        return carMakeService.findAll();
    }

    @GetMapping("car-makes/{id}")
    public CarMake findById(@PathVariable final UUID id) {
        return carMakeService.findById(id)
                .orElseThrow(CarMakeNotFoundException::new);
    }

    @PostMapping("car-makes")
    public CarMake save(@RequestBody final CarMake carMake) {
        return carMakeService.save(carMake);
    }
}
