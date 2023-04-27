package com.example.SharathMotors;

import com.example.SharathMotors.Controller.Sharathcontroller;
import com.example.SharathMotors.Model.Car;
import com.example.SharathMotors.Service.Sharathservice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@WebMvcTest(Sharathcontroller.class)
public class Carcontrollertest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private Sharathservice sharathservice;
    private Car car;
    @BeforeEach
    void setup(){
        car=new Car(1,"BMW","10000000","ABC","black",6,"2022-10-08");
    }
    @Test
    void testGetAllCars() throws Exception{

        final List<Car> car = List.of(new Car(1,"BMW","10000000","ABC","black",6,"2022-10-08"));
        when(sharathservice.getAllCar()).thenReturn(car);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sharathcars/cars")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }





    @Test
    void testGetStudentByName() throws Exception {
        // Setup
        // Configure StudentService.getStudentByName(...).
        final List<Car> car = List.of(new Car(1, "BMW","10000000","ABC","black",6,"2022-10-08"));
        when(sharathservice.getCarByParticulardate("car-particulardate")).thenReturn((Car) car);

        // Run the test
        final MockHttpServletResponse response = mockMvc.perform(get("/sharathcars/{car-particulardate}", "particulardate")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        // Verify the results
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
//        assertThat(response.getContentAsString()).isEqualTo("expectedResponse");
    }


    }

