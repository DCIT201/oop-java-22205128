package com.vehiclerental.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car("C001", "Honda", "Civic", 2021, 60.0, 4, "Petrol");
    }

    @Test
    public void testCarCreation() {
        assertNotNull(car);
    }

    @Test
    public void testGetNumberOfDoors() {
        assertEquals(4, car.getNumberOfDoors());
    }

    @Test
    public void testGetFuelType() {
        assertEquals("Petrol", car.getFuelType());
    }

    @Test
    public void testDisplayDetails() {
        car.displayDetails();  }
}
