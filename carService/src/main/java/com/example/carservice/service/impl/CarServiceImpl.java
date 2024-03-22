package com.example.carservice.service.impl;

import com.example.carservice.client.PersonClient;
import com.example.carservice.entity.Car;
import com.example.carservice.kafka.TestProducer;
import com.example.carservice.repository.CarRepository;
import com.example.carservice.service.CarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PersonClient personClient;
    private final TestProducer testProducer;
    private final KafkaProperties kafkaProperties;

    @Override
    public List<Car> getAllCar() {
        kafkaProperties.getBootstrapServers();
        testProducer.testSendMessage();
        return carRepository.getAllCar();
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @Override
    public Car addOwner(int id) {
        return carRepository.findCarByPersonId(id); }

    @Override
    public Car create(Car car) {
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        if (carRepository.findById(id).isPresent())
            carRepository.deleteById(id);
    }

    @Override
    public void deleteByPersonId(int id) {
        carRepository.deleteAllByPersonId(id);
    }
}
