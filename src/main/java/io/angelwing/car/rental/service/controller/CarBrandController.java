package io.angelwing.car.rental.service.controller;

import io.angelwing.car.rental.service.exception.CarBrandNotFoundException;
import io.angelwing.car.rental.service.model.CarBrand;
import io.angelwing.car.rental.service.service.CarBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
public class CarBrandController {

    private final CarBrandService carBrandService;

    @Autowired
    public CarBrandController(final CarBrandService carBrandService) {
        this.carBrandService = carBrandService;
    }

    @GetMapping("car-brands")
    public Collection<CarBrand> findAll() {
        return carBrandService.findAll();
    }

    @GetMapping("car-brands/{id}")
    public CarBrand findById(@PathVariable final UUID id) {
        return carBrandService.findById(id)
                .orElseThrow(() -> new CarBrandNotFoundException(id));
    }

    @PostMapping("car-brands")
    public CarBrand save(@RequestBody final CarBrand carBrand) {
        return carBrandService.save(carBrand);
    }

}
