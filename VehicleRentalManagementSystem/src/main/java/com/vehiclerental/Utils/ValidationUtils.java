package com.vehiclerental.Utils;

public class ValidationUtils {

    // Method to validate vehicle ID format
    public static boolean isValidVehicleId(String vehicleId) {
        // Example validation: Vehicle ID should not be null or empty and should follow a specific pattern
        return vehicleId != null && !vehicleId.trim().isEmpty();
    }

    // Method to validate customer ID format
    public static boolean isValidCustomerId(String customerId) {
        // Example validation: Customer ID should not be null or empty
        return customerId != null && !customerId.trim().isEmpty();
    }

    // Method to validate rental days
    public static boolean isValidRentalDays(int rentalDays) {
        // Rental days should be a positive integer
        return rentalDays > 0;
    }

    // Method to validate email format
    public static boolean isValidEmail(String email) {
        // Simple regex for email validation
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email != null && email.matches(emailRegex);
    }

    // Method to validate contact number format
    public static boolean isValidContactNumber(String contactNumber) {
        // Example validation: Contact number should be numeric and of a certain length
        return contactNumber != null && contactNumber.matches("\\d{10}"); // Assuming a 10-digit number
    }

    // Method to validate vehicle make and model
    public static boolean isValidMakeAndModel(String make, String model) {
        return (make != null && !make.trim().isEmpty()) && (model != null && !model.trim().isEmpty());
    }
}