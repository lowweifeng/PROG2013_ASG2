// Vehicle class
public class Vehicle {
    private String vehicleNumber;
    private String manufacturer;
    private String model;
    private double rentalRatePerDay;

    public Vehicle(String vehicleNumber, String manufacturer, String model, double rentalRatePerDay) {
        this.vehicleNumber = vehicleNumber;
        this.manufacturer = manufacturer;
        this.model = model;
        this.rentalRatePerDay = rentalRatePerDay;
    }

    // Getters and setters for all attributes
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getRentalRatePerDay() {
        return rentalRatePerDay;
    }

    public void setRentalRatePerDay(double rentalRatePerDay) {
        this.rentalRatePerDay = rentalRatePerDay;
    }

    // Method to calculate and return the total rental cost for the specified number of days
    public double calculateRentalCost(int numberOfDays) {
        return rentalRatePerDay * numberOfDays;
    }

    // toString method to provide a string representation of the vehicle
    @Override
    public String toString() {
        return "Vehicle Number: " + vehicleNumber + "\nManufacturer: " + manufacturer
                + "\nModel: " + model + "\nRental Rate per Day: RM " + rentalRatePerDay;
    }
}

