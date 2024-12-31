package com.vehiclerental.management;

public final class RentalTransaction {
    // Private fields for rental transaction properties
    private final Customer customer;      // The customer who rented the vehicle
    private final Vehicle vehicle;        // The vehicle that was rented
    private final int rentalDays;         // Number of days the vehicle is rented
    private final double totalCost;       // Total cost of the rental

    // Constructor
    public RentalTransaction(Customer customer, Vehicle vehicle, int rentalDays)    {    
        this.customer = customer;
        this.vehicle = vehicle;
        this.rentalDays = rentalDays;
        this.totalCost = calculateTotalCost(); // Calculate total cost upon creation
        }
    
        // Method to calculate total cost of the rental
        double calculateTotalCost() {
            return vehicle.calculateRentalCost(rentalDays);
    }

    // Getters
    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getRentalDays() {
        return rentalDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    // Method to display transaction details
    public void displayTransactionDetails() {
        System.out.println("Rental Transaction Details:");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Vehicle: " + vehicle.getMake() + " " + vehicle.getModel());
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: ₵" + totalCost);
    }
}