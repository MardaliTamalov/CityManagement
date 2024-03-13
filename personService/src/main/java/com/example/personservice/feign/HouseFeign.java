package com.example.personservice.feign;

import com.example.personservice.dto.HouseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "house")
public interface HouseFeign {
    @GetMapping("/house")
    HouseDto getHouse(int id);

    @PutMapping("/house")
    void addHouse(HouseDto houseDto);

}
