package io.angelwing.car.rental.service.controller;

import io.angelwing.car.rental.service.exception.VinCodeNotFoundException;
import io.angelwing.car.rental.service.model.VinCode;
import io.angelwing.car.rental.service.service.VinCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class VinCodeController {

    private final VinCodeService vinCodeService;

    @Autowired
    public VinCodeController(final VinCodeService vinCodeService) {
        this.vinCodeService = vinCodeService;
    }

    @GetMapping("vin-codes")
    public Collection<VinCode> findAll() {
        return vinCodeService.findAll();
    }

    @GetMapping("vin-codes/{id}")
    public VinCode findById(@PathVariable final String id) {
        return vinCodeService.findById(id)
                .orElseThrow(() -> new VinCodeNotFoundException(id));
    }

    @PostMapping("vin-codes")
    public VinCode save(@RequestBody final VinCode vinCode) {
        return vinCodeService.save(vinCode);
    }
}
