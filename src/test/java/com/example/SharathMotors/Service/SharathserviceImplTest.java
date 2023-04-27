package com.example.SharathMotors.Service;

import com.example.SharathMotors.Model.Car;
import com.example.SharathMotors.Repo.Sharathrepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SharathserviceImplTest {

    @Mock
    private Sharathrepo mockSharathrepo;

    @InjectMocks
    private SharathserviceImpl sharathserviceImplUnderTest;

    @Test
    void testAddCar() {
        // Setup
        final Car car = new Car(0, "carname", "carprice", "brand", "colour", 0, "particulardate");
        final Car expectedResult = new Car(0, "carname", "carprice", "brand", "colour", 0, "particulardate");

        // Configure Sharathrepo.save(...).
        final Car car1 = new Car(0, "carname", "carprice", "brand", "colour", 0, "particulardate");
        when(mockSharathrepo.save(
                new Car(0, "carname", "carprice", "brand", "colour", 0, "particulardate"))).thenReturn(car1);

        // Run the test
        final Car result = sharathserviceImplUnderTest.addCar(car);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllCar() {
        // Setup
        final List<Car> expectedResult = List.of(
                new Car(0, "carname", "carprice", "brand", "colour", 0, "particulardate"));

        // Configure Sharathrepo.findAll(...).
        final List<Car> cars = List.of(new Car(0, "carname", "carprice", "brand", "colour", 0, "particulardate"));
        when(mockSharathrepo.findAll()).thenReturn(cars);

        // Run the test
        final List<Car> result = sharathserviceImplUnderTest.getAllCar();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllCar_SharathrepoReturnsNoItems() {
        // Setup
        when(mockSharathrepo.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Car> result = sharathserviceImplUnderTest.getAllCar();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testGetCarByParticulardate() {
        // Setup
        final Car expectedResult = new Car(0, "carname", "carprice", "brand", "colour", 0, "particulardate");

        // Configure Sharathrepo.findByParticulardate(...).
        final Optional<Car> car = Optional.of(
                new Car(0, "carname", "carprice", "brand", "colour", 0, "particulardate"));
        when(mockSharathrepo.findByParticulardate("particulardate")).thenReturn(car);

        // Run the test
        final Car result = sharathserviceImplUnderTest.getCarByParticulardate("particulardate");

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetCarByParticulardate_SharathrepoReturnsAbsent() {
        // Setup
        when(mockSharathrepo.findByParticulardate("particulardate")).thenReturn(Optional.empty());

        // Run the test
        assertThatThrownBy(() -> sharathserviceImplUnderTest.getCarByParticulardate("particulardate"))
                .isInstanceOf(NoSuchElementException.class);
    }
}
