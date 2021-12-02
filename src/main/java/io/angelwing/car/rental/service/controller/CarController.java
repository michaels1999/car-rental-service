package io.angelwing.car.rental.service.controller;

import io.angelwing.car.rental.service.exception.CarNotFoundException;
import io.angelwing.car.rental.service.model.Car;
import io.angelwing.car.rental.service.service.CarService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("cars")
    public Collection<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("cars/{id}")
    public Car findById(@PathVariable UUID id){
        return carService.findById(id)
                .orElseThrow(()->new CarNotFoundException(id));
    }

}
