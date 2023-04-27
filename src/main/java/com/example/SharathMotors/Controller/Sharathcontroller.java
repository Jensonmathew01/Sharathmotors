package com.example.SharathMotors.Controller;

import com.example.SharathMotors.Model.Car;
import com.example.SharathMotors.Service.Sharathservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/sharathcars/cars")
public class Sharathcontroller {
    private final Logger LOGGER= LoggerFactory.getLogger(Sharathcontroller.class);
    @Autowired
    private Sharathservice sharathservice;
    @PostMapping
    public Car addCar(@Valid @RequestBody Car car){
        LOGGER.info("Inside SharathController addCar method requestBody:{}",car);
        return sharathservice.addCar(car);

    }
    @GetMapping("/get")
    public List<Car> getAllCar(){
        return sharathservice.getAllCar();
    }
    @GetMapping("/sharathcars/{car-particulardate}")
    public Car getCarByParticulardate(@PathVariable("car-particulardate")String particulardate){
        return sharathservice.getCarByParticulardate(particulardate);
    }

}
