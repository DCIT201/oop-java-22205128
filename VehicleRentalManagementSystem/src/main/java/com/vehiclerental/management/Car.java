package com.vehiclerental.management;

public class Car extends Vehicle {
    // Additional fields specific to Car
    private int numberOfDoors; // Number of doors in the car
    private String fuelType;    // Type of fuel used (e.g., petrol, diesel, electric)

    // Constructor
    public Car(String vehicleId, String make, String model, int year, double rentalPrice, int numberOfDoors, String fuelType) {
        super(vehicleId, make, model, year, rentalPrice); // Call to the parent class constructor
        this.numberOfDoors = numberOfDoors;
        this.fuelType = fuelType;
    }

    // Getters and Setters for additional fields
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    // Implementation of the abstract method from Vehicle class
    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        System.out.println("Vehicle ID: " + getVehicleId());
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Rental Price:₵" + getRentalPrice() + " per day");
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Fuel Type: " + fuelType);
        System.out.println("Currently Rented: " + (isRented() ? "Yes" : "No"));
    }
}