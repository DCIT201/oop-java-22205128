package com.vehiclerental.management;

public class Motorcycle extends Vehicle {
    // Additional fields specific to Motorcycle
    private boolean hasSidecar; // Indicates if the motorcycle has a sidecar
    private String engineType;   // Type of engine (e.g., 2-stroke, 4-stroke)

    // Constructor
    public Motorcycle(String vehicleId, String make, String model, int year, double rentalPrice, boolean hasSidecar, String engineType) {
        super(vehicleId, make, model, year, rentalPrice); // Call to the parent class constructor
        this.hasSidecar = hasSidecar;
        this.engineType = engineType;
    }

    // Getters and Setters for additional fields
    public boolean hasSidecar() {
        return hasSidecar;
    }

    public void setHasSidecar(boolean hasSidecar) {
        this.hasSidecar = hasSidecar;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    // Implementation of the abstract method from Vehicle class
    @Override
    public void displayDetails() {
        System.out.println("Motorcycle Details:");
        System.out.println("Vehicle ID: " + getVehicleId());
        System.out.println("Make: " + getMake());
        System.out.println("Model: " + getModel());
        System.out.println("Year: " + getYear());
        System.out.println("Rental Price: ₵" + getRentalPrice() + " per day");
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Engine Type: " + engineType);
        System.out.println("Currently Rented: " + (isRented() ? "Yes" : "No"));
    }

    public boolean isAvailableForRental() {
        return !isRented();
    }
}