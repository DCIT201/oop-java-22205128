package com.vehiclerental.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class RentalAgencyTest {

    private RentalAgency rentalAgency;
    private Vehicle testVehicle;
    private Customer testCustomer;


    @Test
    void testAddVehicle() {
        Vehicle newVehicle = new Motorcycle("V002", "Yamaha R15", "Sport", 2021, 12000.0, false, "Gasoline"); // Adjust to actual Bike constructor
        rentalAgency.addVehicle(newVehicle);

        assertNotNull(rentalAgency.rentVehicle("V002", "C001", 5)); // Ensure the vehicle is available for rent
    }

    @Test
    void testAddCustomer() {
        Customer newCustomer = new Customer("C002", "Bob Brown", "0987654321", "bob@example.com");
        rentalAgency.addCustomer(newCustomer);

        assertTrue(rentalAgency.rentVehicle("V001", "C002", 3)); // Ensure the customer can rent vehicles
    }

    @Test
    void testRentVehicleSuccessful() {
        boolean rentResult = rentalAgency.rentVehicle("V001", "C001", 7);

        assertTrue(rentResult);
        assertTrue(testVehicle.isRented()); // Verify the vehicle is marked as rented
        assertEquals(1, testCustomer.getRentalHistory().size()); // Verify transaction is added to customer
    }

    @Test
    void testRentVehicleFailsForUnavailableVehicle() {
        rentalAgency.rentVehicle("V001", "C001", 7); // First rental

        boolean secondRentResult = rentalAgency.rentVehicle("V001", "C001", 3); // Attempt second rental

        assertFalse(secondRentResult); // Second rental should fail
    }

    @Test
    void testRentVehicleFailsForInvalidIds() {
        assertFalse(rentalAgency.rentVehicle("InvalidVehicle", "C001", 5)); // Invalid vehicle
        assertFalse(rentalAgency.rentVehicle("V001", "InvalidCustomer", 5)); // Invalid customer
    }

    @Test
    void testReturnVehicleSuccessful() {
        rentalAgency.rentVehicle("V001", "C001", 7);

        boolean returnResult = rentalAgency.returnVehicle("V001");

        assertTrue(returnResult);
        assertFalse(testVehicle.isRented()); // Verify the vehicle is marked as not rented
    }

    @Test
    void testReturnVehicleFailsForInvalidOrNonRentedVehicle() {
        assertFalse(rentalAgency.returnVehicle("InvalidVehicle")); // Invalid vehicle
        assertFalse(rentalAgency.returnVehicle("V001")); // Not rented
    }

    @Test
    void testFindVehicleById() {
        Vehicle foundVehicle = rentalAgency.findVehicleById("V001");

        assertNotNull(foundVehicle);
        assertEquals("V001", foundVehicle.getVehicleId());
    }

    @Test
    void testFindCustomerById() {
        Customer foundCustomer = rentalAgency.findCustomerById("C001");

        assertNotNull(foundCustomer);
        assertEquals("C001", foundCustomer.getCustomerId());
    }
}
