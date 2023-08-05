import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class VehicleRentalSystem extends JFrame {
    private JLabel vehicleNumberLabel = new JLabel("Vehicle Number:");
    private JTextField vehicleNumberTF = new JTextField(20);

    private JLabel manufacturerLabel = new JLabel("Manufacturer:");
    private JTextField manufacturerTF = new JTextField(20);

    private JLabel modelLabel = new JLabel("Model:");
    private JTextField modelTF = new JTextField(20);

    private JLabel rentalRateLabel = new JLabel("Rental Rate (RM per day):");
    private JTextField rentalRateTF = new JTextField(10);

    private JRadioButton carRadioButton = new JRadioButton("Car");
    private JRadioButton motorcycleRadioButton = new JRadioButton("Motorcycle");
    private ButtonGroup vehicleTypeButtonGroup = new ButtonGroup();

    private JLabel numDoorsLabel = new JLabel("Number of Doors:");
    private JTextField numDoorsTF = new JTextField(5);

    private JLabel engineCapacityLabel = new JLabel("Engine Capacity:");
    private JTextField engineCapacityTF = new JTextField(5);

    private JButton calculateCostButton = new JButton("Calculate Rental Cost");
    private JTextArea resultTextArea = new JTextArea(10, 30);

    public VehicleRentalSystem() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vehicle Rental System");

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JPanel vehiclePanel = new JPanel();
        vehiclePanel.add(vehicleNumberLabel);
        vehiclePanel.add(vehicleNumberTF);
        vehiclePanel.add(manufacturerLabel);
        vehiclePanel.add(manufacturerTF);
        vehiclePanel.add(modelLabel);
        vehiclePanel.add(modelTF);
        vehiclePanel.add(rentalRateLabel);
        vehiclePanel.add(rentalRateTF);

        JPanel vehicleTypePanel = new JPanel();
        vehicleTypePanel.add(carRadioButton);
        vehicleTypePanel.add(motorcycleRadioButton);
        vehicleTypeButtonGroup.add(carRadioButton);
        vehicleTypeButtonGroup.add(motorcycleRadioButton);

        JPanel carPanel = new JPanel();
        carPanel.add(numDoorsLabel);
        carPanel.add(numDoorsTF);

        JPanel motorcyclePanel = new JPanel();
        motorcyclePanel.add(engineCapacityLabel);
        motorcyclePanel.add(engineCapacityTF);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(calculateCostButton);

        mainPanel.add(vehiclePanel);
        mainPanel.add(vehicleTypePanel);
        mainPanel.add(carPanel);
        mainPanel.add(motorcyclePanel);
        mainPanel.add(buttonPanel);
        mainPanel.add(new JScrollPane(resultTextArea));

        // Add action listeners for radio buttons
        carRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                numDoorsTF.setEnabled(true);
                engineCapacityTF.setEnabled(false);
            }
        });

        motorcycleRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                numDoorsTF.setEnabled(false);
                engineCapacityTF.setEnabled(true);
            }
        });

        // Add action listener for calculateCostButton
        calculateCostButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                calculateCostButtonActionPerformed(evt);
            }
        });

        getContentPane().add(mainPanel);
        pack();
    }

    private void calculateCostButtonActionPerformed(ActionEvent evt) {
        String vehicleNumber = vehicleNumberTF.getText();
        String manufacturer = manufacturerTF.getText();
        String model = modelTF.getText();
        double rentalRatePerDay = Double.parseDouble(rentalRateTF.getText());

        if (carRadioButton.isSelected()) {
            int numDoors = Integer.parseInt(numDoorsTF.getText());
            Car car = new Car(vehicleNumber, manufacturer, model, rentalRatePerDay, numDoors);
            resultTextArea.setText(car.toString() + "\nRental Cost for 7 days: RM " + car.calculateRentalCost(7));
        } else if (motorcycleRadioButton.isSelected()) {
            int engineCapacity = Integer.parseInt(engineCapacityTF.getText());
            Motorcycle motorcycle = new Motorcycle(vehicleNumber, manufacturer, model, rentalRatePerDay, engineCapacity);
            resultTextArea.setText(motorcycle.toString() + "\nRental Cost for 7 days: RM " + motorcycle.calculateRentalCost(7));
        } else {
            // No vehicle type selected
            resultTextArea.setText("Please select a vehicle type (Car or Motorcycle).");
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame screen = new VehicleRentalSystem();
                screen.setVisible(true);
            }
        });
    }
}
