package com.vehiclerental.management;

public interface Rentable {
    // Method to rent the vehicle
    boolean rent();

    // Method to return the vehicle
    void returnVehicle();

    // Method to check if the vehicle is currently rented
    boolean isRented();
}