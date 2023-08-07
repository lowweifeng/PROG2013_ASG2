// Car class (subclass of Vehicle)
public class Car extends Vehicle {
    private int numDoors;

    public Car(String vehicleNumber, String manufacturer, String model, double rentalRatePerDay, int numDoors) {
        super(vehicleNumber, manufacturer, model, rentalRatePerDay);
        this.numDoors = numDoors;
    }

    // Getter and setter for numDoors
    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    // Override toString method to provide a string representation of the car, including numDoors
    @Override
    public String toString() {
        return super.toString() + "\nNumber of Doors: " + numDoors;
    }

    // Override calculateRentalCost method to add RM35 per day for cars with more than two doors
    @Override
    public double calculateRentalCost(int numberOfDays) {
        double baseCost = super.calculateRentalCost(numberOfDays);
        if (numDoors > 2) {
            return baseCost + (35 * numberOfDays);
        }
        return baseCost;
    }
}