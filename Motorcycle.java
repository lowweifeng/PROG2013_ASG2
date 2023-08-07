// Motorcycle class (subclass of Vehicle)
public class Motorcycle extends Vehicle {
    private int engineCapacity;

    public Motorcycle(String vehicleNumber, String manufacturer, String model,
                      double rentalRatePerDay, int engineCapacity) {
        super(vehicleNumber, manufacturer, model, rentalRatePerDay);
        this.engineCapacity = engineCapacity;
    }

    // Getter and setter for engineCapacity
    public int getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(int engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    // Additional method to calculate and return the top speed of the motorcycle
    public int calculateTopSpeed() {
        return engineCapacity * 50;
    }

    // Override toString method to provide a string representation of the motorcycle, including engineCapacity
    @Override
    public String toString() {
        return super.toString() + "\nEngine Capacity: " + engineCapacity;
    }

    // Override calculateRentalCost method to add RM150 for motorcycles with a top speed of at least 300
    @Override
    public double calculateRentalCost(int numberOfDays) {
        double baseCost = super.calculateRentalCost(numberOfDays);
        int topSpeed = calculateTopSpeed();
        if (topSpeed >= 300) {
            return baseCost + (150 * numberOfDays);
        }
        return baseCost;
    }
}
