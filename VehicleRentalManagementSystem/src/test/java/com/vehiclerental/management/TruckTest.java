package com.vehiclerental.management;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TruckTest {

    @Test
    public void testCalculateRentalCost() {
        Truck truck = new Truck("T001", "Ford", "F150", 2020, 70.0, 10000, 4, true);
        assertEquals(280.0, truck.calculateRentalCost(4)); // 4 days at ₵70/day
    }

    @Test
    public void testIsAvailableForRental() {
        Truck truck = new Truck("T002", "Chevy", "Silverado", 2019, 80.0, 12000, 3, false);
        assertFalse((boolean) truck.isAvailableForRental());
    }

    @Test
    public void testToString() {
        Truck truck = new Truck("T003", "Ram", "1500", 2021, 75.0, 15000, 5, true);
        assertEquals("Truck{vehicleId='T003', model='Ram', baseRentalRate=75.0, isAvailable=true}", truck.toString());
    }
}