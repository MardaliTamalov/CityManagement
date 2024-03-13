package com.example.carservice.client;


import com.example.api.carService.api.person.PersonController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "personClient", url = "http://localhost:8083")
public interface PersonClient extends PersonController {

}
