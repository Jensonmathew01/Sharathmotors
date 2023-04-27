package com.example.SharathMotors.Service;

import com.example.SharathMotors.Model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Sharathservice {


    Car addCar(Car car);

    List<Car> getAllCar();

    Car getCarByParticulardate(String particulardate);


}
