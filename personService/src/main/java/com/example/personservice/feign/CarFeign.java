package com.example.personservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "/car")
public interface CarFeign {

    @GetMapping("/car")


    @PutMapping("/car")
    void addCar();
}
