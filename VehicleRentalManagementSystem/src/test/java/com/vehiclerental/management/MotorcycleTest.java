package com.vehiclerental.management;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MotorcycleTest {

    @SuppressWarnings("deprecation")
    @Test
    public void testCalculateRentalCost() {
        Motorcycle motorcycle = new Motorcycle("M001", "Harley", "Cruiser", 2021, 30.0, true, "Black");
        assertEquals(90.0, motorcycle.calculateRentalCost(3)); // 3 days at ₵30/day
    }

    @Test
    public void testIsAvailableForRental() {
        Motorcycle motorcycle = new Motorcycle("M002", "Ducati", "Sport", 2021, 40.0, true, "Red");
        assertTrue(motorcycle.isAvailableForRental());
    }

    @Test
    public void testToString() {
        Motorcycle motorcycle = new Motorcycle("M003", "Kawasaki", "Ninja", 2021, 35.0, true, "Green");
        assertEquals("Motorcycle{vehicleId='M003', model='Kawasaki', baseRentalRate=35.0, isAvailable=true}", motorcycle.toString());
    }
}