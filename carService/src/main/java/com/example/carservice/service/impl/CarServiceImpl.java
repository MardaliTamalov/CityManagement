package com.example.carservice.service.impl;

import com.example.api.kafka.CitizenDeleteDto;
import com.example.carservice.client.PersonClient;
import com.example.carservice.entity.Car;
import com.example.carservice.enums.Status;
import com.example.carservice.kafka.CarDeleteProducer;
import com.example.carservice.kafka.HouseDeleteProducer;
import com.example.carservice.repository.CarRepository;
import com.example.carservice.service.CarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final PersonClient personClient;
    private final CarDeleteProducer carDeleteProducer;
    private final KafkaProperties kafkaProperties;
    private final HouseDeleteProducer houseDeleteProducer;

    @Override
    public List<Car> getAllCar() {
        return carRepository.getAllCar();
    }

    @Override
    public Car getById(int id) {
        return carRepository.findById(id).orElseThrow();
    }

    @Override
    public Car addOwner(int id) {
        return carRepository.findCarByPersonId(id);
    }

    @Override
    public Car create(Car car) {
        car.setStatus(Status.ACTIVE);
        return carRepository.save(car);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        if (carRepository.findById(id).isPresent()) {
//            carRepository.deleteById(id);
            carRepository.setStatusDelete(id);
        }
    }

    @Override
    @Transactional
    public void deleteByPersonId(int id) {
        log.info("начал удалять машины по id жителя " + id);
        try {
            carRepository.setStatusDelete(id);
            houseDeleteProducer.sendDeleteHouse(new CitizenDeleteDto(id));
//          throw new RuntimeException();
        } catch (Exception e) {
            log.error("удаление жителя по id завершилась с ошибкой " + id);
            carDeleteProducer.rollbackDeleteCar(new CitizenDeleteDto(id));
            activeByPersonId(id);
        }
    }

    @Override
    @Transactional
    public void activeByPersonId(int id) {
        try {
            carRepository.setStatusActive(id);
        } catch (Exception e) {

        }
    }


}
