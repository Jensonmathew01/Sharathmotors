package com.example.SharathMotors.Service;

import com.example.SharathMotors.Model.Car;
import com.example.SharathMotors.Repo.Sharathrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SharathserviceImpl implements Sharathservice {
    @Autowired
    private Sharathrepo sharathrepo;

    @Override
    public Car addCar(Car car) {
        return sharathrepo.save(car);
    }

    @Override
    public List<Car> getAllCar() {
        return sharathrepo.findAll();
    }

    @Override
    public Car getCarByParticulardate(String particulardate) {
        Optional<Car> s=sharathrepo.findByParticulardate(particulardate);
        return s.get();
    }
}
