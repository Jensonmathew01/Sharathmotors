package com.example.SharathMotors.Repo;

import com.example.SharathMotors.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Sharathrepo extends JpaRepository<Car,Integer> {
    Optional<Car> findByParticulardate(String particulardate);
}
