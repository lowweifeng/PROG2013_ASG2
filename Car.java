public class Car extends Vehicle {
    private int numDoors;

    public Car(String vehicleNumber, String manufacturer, String model, double rentalRatePerDay, int numDoors) {
        super(vehicleNumber, manufacturer, model, rentalRatePerDay);
        this.numDoors = numDoors;
    }

    // Getter and Setter for numDoors attribute
    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    // Override the toString() method to include Car-specific attributes
    @Override
    public String toString() {
        return super.toString() + ", Number of Doors: " + numDoors;
    }

    // Override the calculateRentalCost method to add RM35 per day for cars with more than two doors
    @Override
    public double calculateRentalCost(int numberOfDays) {
        double rentalCost = super.calculateRentalCost(numberOfDays);
        if (numDoors > 2) {
            rentalCost += (35 * numberOfDays);
        }
        return rentalCost;
    }
}
