package com.vehiclerental.management;

public abstract class Vehicle implements Rentable {
    // Private fields for vehicle properties
    private String vehicleId;      // Unique identifier for the vehicle
    private String make;           // Manufacturer of the vehicle
    private String model;          // Model of the vehicle
    private int year;              // Year of manufacture
    private double rentalPrice;     // Rental price per day
    private boolean isRented;       // Rental status of the vehicle

    // Constructor
    public Vehicle(String vehicleId, String make, String model, int year, double rentalPrice) {
        this.vehicleId = vehicleId;
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
        this.isRented = false; // Initially, the vehicle is not rented
    }

    // Getters and Setters
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public boolean isAvailable() {
         return !isRented();
    }

    @Override
    public boolean isRented() {
        return isRented;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    // Abstract method to be implemented by subclasses
    public abstract void displayDetails();

    // Method to calculate rental cost based on days rented
    public double calculateRentalCost(int days) {
        return rentalPrice * days;
    }

    // Implementation of Rentable interface methods
    @Override
    public boolean rent() {
        if (!isRented) {
            isRented = true;
            return true; // Rental successful
        }
        return false; // Rental failed, already rented
    }

    @Override
    public void returnVehicle() {
        isRented = false; // Mark the vehicle as not rented
    }
}