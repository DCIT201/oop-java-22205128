package com.vehiclerental.management;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class RentalTransactionTest {

    @Test
    void testCalculateTotalCost() {
        Customer customer = new Customer("John Doe", "123 Main St", "john.doe@example.com", "555-1234");
        Vehicle vehicle = new Motorcycle("Motorcycle", "Brand", "Model", 2021, 50.0, true, "Color"); // Assuming Motorcycle is a subclass of Vehicle with type and cost per day
        int rentalDays = 5;

        RentalTransaction transaction = new RentalTransaction(customer, vehicle, rentalDays);
        double expectedTotalCost = 250.0; // 50.0 * 5

        assertEquals(expectedTotalCost, transaction.calculateTotalCost(), 0.01);
    }

    @Test
    void testGetCustomer() {
        Customer customer = new Customer("John Doe", "123 Main St", "john.doe@example.com", "555-1234");
        Vehicle vehicle = new Motorcycle("Motorcycle", "Brand", "Model", 2021, 50.0, true, "Color");
        int rentalDays = 5;

        RentalTransaction transaction = new RentalTransaction(customer, vehicle, rentalDays);

        assertEquals(customer, transaction.getCustomer());
    }

    @Test
    void testGetVehicle() {
        Customer customer = new Customer("John Doe", "123 Main St", "john.doe@example.com", "555-1234");
        Vehicle vehicle = new Motorcycle("Motorcycle", "Brand", "Model", 2021, 50.0, true, "Color");
        int rentalDays = 5;

        RentalTransaction transaction = new RentalTransaction(customer, vehicle, rentalDays);

        assertEquals(vehicle, transaction.getVehicle());
    }
}