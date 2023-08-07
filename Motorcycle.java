public class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String vehicleNumber, String manufacturer, String model, double rentalRatePerDay, int engineCapacity) {
        super(vehicleNumber, manufacturer, model, rentalRatePerDay);
        this.engineCapacity = engineCapacity;
    }

    // Getter and Setter for engineCapacity attribute
    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    // Method to calculate and return the top speed of the motorcycle based on engine capacity
    public int calculateTopSpeed() {
        return engineCapacity /100 * 50;
    }

    // Override the toString() method to include Motorcycle-specific attributes
    @Override
    public String toString() {
        return super.toString() + ", Engine Capacity: " + engineCapacity;
    }

    // Override the calculateRentalCost method to add RM150 for motorcycles with top speed of at least 300
    @Override
    public double calculateRentalCost(int numberOfDays) {
        double rentalCost = super.calculateRentalCost(numberOfDays);
        if (calculateTopSpeed() >= 300) {
            rentalCost += 150;
        }
        return rentalCost;
    }
}
