package com.vehiclerental.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer {
    // Private fields for customer properties
    private String customerId;      // Unique identifier for the customer
    private String name;             // Name of the customer
    private String contactNumber;    // Contact number of the customer
    private String email;            // Email address of the customer
    private final List<RentalTransaction> rentalHistory; // List to store rental transactions

    // Constructor with input validation
    public Customer(String customerId, String name, String contactNumber, String email) {
        this.customerId = Objects.requireNonNull(customerId, "Customer ID cannot be null");
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.contactNumber = Objects.requireNonNull(contactNumber, "Contact number cannot be null");
        this.email = Objects.requireNonNull(email, "Email cannot be null");
        this.rentalHistory = new ArrayList<>(); // Initialize the rental history list
    }

    // Getters and Setters with input validation
    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = Objects.requireNonNull(customerId, "Customer ID cannot be null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Name cannot be null");
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = Objects.requireNonNull(contactNumber, "Contact number cannot be null");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Objects.requireNonNull(email, "Email cannot be null");
    }

    public List<RentalTransaction> getRentalHistory() {
        return new ArrayList<>(rentalHistory); // Return a copy to prevent external modification
    }

    // Method to add a rental transaction to the history with null check
    public void addRentalTransaction(RentalTransaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Rental transaction cannot be null");
        }
        rentalHistory.add(transaction);
    }

    // Method to display customer details
    public void displayCustomerDetails() {
        System.out.println("Customer Details:");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Contact Number: " + contactNumber);
        System.out.println("Email: " + email);
        System.out.println("Rental History:");
        if (rentalHistory.isEmpty()) {
            System.out.println("No rental transactions found.");
        } else {
            for (RentalTransaction transaction : rentalHistory) {
                System.out.println(transaction); // Assuming RentalTransaction has a proper toString() method
            }
        }
    }
}