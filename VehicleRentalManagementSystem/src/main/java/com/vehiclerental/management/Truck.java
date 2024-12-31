package com.vehiclerental.management;

public class Truck extends Vehicle {
    // Additional fields specific to Truck
    private double loadCapacity; // Load capacity of the truck in tons
    private int numberOfAxles;   // Number of axles on the truck

    // Constructor
    public Truck(String vehicleId, String make, String model, int year, double rentalPrice, double loadCapacity, int numberOfAxles) {
        super(vehicleId, make, model, year, rentalPrice); // Call to the parent class constructor
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
    }

    public Truck(String vehicleId, String make, String model, int year, double rentalPrice, double loadCapacity, int numberOfAxles, boolean isRented) {
        super(vehicleId, make, model, year, rentalPrice); // Call to the parent class constructor
        this.loadCapacity = loadCapacity;
        this.numberOfAxles = numberOfAxles;
        setRented(isRented); 
    }
    
    public boolean isAvailableForRental() {
        return this.isAvailable();
    }

    // Getters and Setters for additional fields
    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    public void setNumberOfAxles(int numberOfAxles) {
        this.numberOfAxles = numberOfAxles;
    }

    // Implementation of the abstract method from Vehicle class
    @Override
    public void displayDetails() {
        System.out.println("Truck Details:");
        System.out.println("Vehicle ID: " + getVehicleId());
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Rental Price: ₵" + getRentalPrice() + " per day");
        System.out.println("Load Capacity: " + loadCapacity + " tons");
        System.out.println("Number of Axles: " + numberOfAxles);
        System.out.println("Currently Rented: " + (isRented() ? "Yes" : "No"));
    }

    }