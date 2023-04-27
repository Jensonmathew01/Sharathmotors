package com.example.SharathMotors.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @Column(name="CARID")
    private Integer carid;
    @NotBlank(message="column name should not be null")
    @Column(name="CARNAME")
    private String carname;
    @Column(name="CARPRICE")
    private String carprice;
    @Column(name="BRAND")
    private String brand;
    @Column(name="COLOUR")
    private String colour;
    @Column(name="NOOFSEATS")
    private Integer noofseats;
    @Column(name="PARTICULARDATE")
    private String particulardate;

    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", carname='" + carname + '\'' +
                ", carprice='" + carprice + '\'' +
                ", brand='" + brand + '\'' +
                ", colour='" + colour + '\'' +
                ", noofseats=" + noofseats +
                ", particulardate='" + particulardate + '\'' +
                '}';
    }
}
