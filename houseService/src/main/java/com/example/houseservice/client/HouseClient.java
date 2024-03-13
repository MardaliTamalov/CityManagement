package com.example.houseservice.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "houseClient", url = "http://localhost:8082")
public interface HouseClient {
}
