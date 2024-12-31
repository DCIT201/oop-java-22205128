package com.vehiclerental.management;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    private Vehicle vehicle;

    @BeforeEach
    public void setUp() {
        vehicle = new Car("V001", "Toyota", "Camry", 2020, 50.0, 4, "Petrol");
    }

    @Test
    public void testVehicleCreation() {
        assertNotNull(vehicle);
    }

    @Test
    public void testGetVehicleId() {
        assertEquals("V001", vehicle.getVehicleId());
    }

    @Test
    public void testGetMake() {
        assertEquals("Toyota", vehicle.getMake());
    }

    @Test
    public void testCalculateRentalCost() {
        double cost = vehicle.calculateRentalCost(3); // Renting for 3 days
        assertEquals(150.0, cost); // 50.0 * 3 days
    }

    @Test
    public void testRentVehicle() {
        assertFalse(vehicle.isRented());
        vehicle.rent();
        assertTrue(vehicle.isRented());
    }

    @Test
    public void testReturnVehicle() {
        vehicle.rent();
        assertTrue(vehicle.isRented());
        vehicle.returnVehicle();
        assertFalse(vehicle.isRented());
    }

    @Test
    public void testDisplayDetails() {
        // This would typically be tested by checking console output, 
        // but for simplicity, we can just call the method.
        vehicle.displayDetails();
    }
}