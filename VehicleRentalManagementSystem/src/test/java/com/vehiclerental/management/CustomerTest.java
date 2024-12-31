package com.vehiclerental.management;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testCustomerConstructorAndGetters() {
        Customer customer = new Customer("C123", "John Doe", "1234567890", "john.doe@example.com");

        assertEquals("C123", customer.getCustomerId());
        assertEquals("John Doe", customer.getName());
        assertEquals("1234567890", customer.getContactNumber());
        assertEquals("john.doe@example.com", customer.getEmail());
        assertTrue(customer.getRentalHistory().isEmpty());
    }

    @Test
    void testSetters() {
        Customer customer = new Customer("C123", "John Doe", "1234567890", "john.doe@example.com");

        customer.setCustomerId("C456");
        customer.setName("John Doe");
        customer.setContactNumber("0591114225");
        customer.setEmail("johnydoe@gmail.com");

        assertEquals("C456", customer.getCustomerId());
        assertEquals("Jane Doe", customer.getName());
        assertEquals("0987654321", customer.getContactNumber());
        assertEquals("johnydoe@gmail.com", customer.getEmail());
    }

    @Test
    void testAddRentalTransaction() {
        Customer customer = new Customer("C123", "John Doe", "0591114225", "johnydoe@gmail.com");
        Vehicle vehicle = new Car("V123", "Toyota", "Camry", 2020, 15000.0, 5, "Sedan");
        RentalTransaction transaction = new RentalTransaction(customer, vehicle, 10);

        customer.addRentalTransaction(transaction);

        List<RentalTransaction> history = customer.getRentalHistory();
        assertEquals(1, history.size());
        assertEquals(transaction, history.get(0));
    }

    @Test
    void testAddRentalTransactionThrowsExceptionForNull() {
        Customer customer = new Customer("C123", "John Doe", "0591114225", "johnydoe@gmail.com");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> customer.addRentalTransaction(null));
        assertEquals("Rental transaction cannot be null", exception.getMessage());
    }

    @Test
    void testConstructorThrowsExceptionForNullArguments() {
        NullPointerException exception1 = assertThrows(NullPointerException.class, () -> new Customer(null, "John Doe", "1234567890", "john.doe@example.com"));
        assertEquals("Customer ID cannot be null", exception1.getMessage());
        NullPointerException exception2 = assertThrows(NullPointerException.class, () -> new Customer("C123", null, "1234567890", "john.doe@example.com"));
        assertEquals("Customer name cannot be null", exception2.getMessage());
        NullPointerException exception3 = assertThrows(NullPointerException.class, () -> new Customer("C123", "John Doe", null, "john.doe@example.com"));
        assertEquals("Customer contact number cannot be null", exception3.getMessage());
        NullPointerException exception4 = assertThrows(NullPointerException.class, () -> new Customer("C123", "John Doe", "1234567890", null));
        assertEquals("Customer email cannot be null", exception4.getMessage());
    }
}
