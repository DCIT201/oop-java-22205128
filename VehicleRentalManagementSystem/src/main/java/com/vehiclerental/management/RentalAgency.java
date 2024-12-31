package com.vehiclerental.management;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    // Private fields for the rental agency
    private final String agencyName;                     // Name of the rental agency
    private final List<Vehicle> vehicles;                 // List of vehicles available for rent
    private final List<Customer> customers;               // List of customers
    private final List<RentalTransaction> rentalTransactions; // List of rental transactions

    // Constructor
    public RentalAgency(String agencyName) {
        this.agencyName = agencyName;
        this.vehicles = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentalTransactions = new ArrayList<>();
    }

    // Method to add a vehicle to the fleet
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    // Method to add a customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Method to rent a vehicle to a customer
    public boolean rentVehicle(String vehicleId, String customerId, int rentalDays) {
        Vehicle vehicle = findVehicleById(vehicleId);
        Customer customer = findCustomerById(customerId);

        if (vehicle != null && customer != null && !vehicle.isRented()) {
            boolean rentalSuccess = vehicle.rent(); // Rent the vehicle
            if (rentalSuccess) {
                RentalTransaction transaction = new RentalTransaction(customer, vehicle, rentalDays);
                rentalTransactions.add(transaction);
                customer.addRentalTransaction(transaction); // Add transaction to customer's history
                return true; // Rental successful
            }
        }
        return false; // Rental failed
    }

    // Method to return a rented vehicle
    public boolean returnVehicle(String vehicleId) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle != null && vehicle.isRented()) {
            vehicle.returnVehicle(); // Return the vehicle
            return true; // Return successful
        }
        return false; // Return failed
    }

    // Method to find a vehicle by its ID
    public Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null; // Vehicle not found
    }

    // Method to find a customer by their ID
    public Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null; // Customer not found
    }

    // Method to display all vehicles
    public void displayAllVehicles() {
        System.out.println("Available Vehicles:");
        for (Vehicle vehicle : vehicles) {
            vehicle.displayDetails(); // Assuming each vehicle has a displayDetails method
            System.out.println();
        }
    }

    // Method to display all customers
    public void displayAllCustomers() {
        System.out.println("Registered Customers:");
        for (Customer customer : customers) {
            customer.displayCustomerDetails(); // Assuming each customer has a displayCustomerDetails method
            System.out.println();
        }
    }

    // Getters
    public String getAgencyName() {
        return agencyName;
    }
}