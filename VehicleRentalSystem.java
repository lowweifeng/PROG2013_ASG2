public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create an array of Vehicle objects containing a mix of cars and motorcycles
        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Car("C001", "Toyota", "Corolla", 80, 4);
        vehicles[1] = new Car("C002", "Honda", "Civic", 100, 2);
        vehicles[2] = new Motorcycle("M001", "Yamaha", "MT-07", 50, 500);
        vehicles[3] = new Motorcycle("M002", "Kawasaki", "Ninja 400", 70, 400);

        // Print the header for the table
        System.out.printf("%-10s %-15s %-15s %-10s %-15s %-15s %-15s%n",
                "Type", "Vehicle No", "Manufacturer", "Model", "Rental Rate", "Rental Cost", "Top Speed");

        // Traverse through the array and print the details of each vehicle
        for (Vehicle vehicle : vehicles) {
            String type = vehicle instanceof Car ? "Car" : "Motorcycle";
            String vehicleNo = vehicle.getVehicleNumber();
            String manufacturer = vehicle.getManufacturer();
            String model = vehicle.getModel();
            double rentalRate = vehicle.getRentalRatePerDay();

            // Calculate the rental cost for 7 days
            int numberOfDays = 7;
            double rentalCost = vehicle.calculateRentalCost(numberOfDays);

            String rentalCostString = String.format("RM %.2f", rentalCost);
            String topSpeedString = "";

            // Check if the vehicle is a Motorcycle and calculate the top speed if applicable
            if (vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                int topSpeed = motorcycle.calculateTopSpeed();
                topSpeedString = topSpeed + " km/h";
            }

            // Print the details for each vehicle
            System.out.printf("%-10s %-15s %-15s %-10s %-15.2f %-15s %-15s%n",
                    type, vehicleNo, manufacturer, model, rentalRate, rentalCostString, topSpeedString);
        }
    }
}
