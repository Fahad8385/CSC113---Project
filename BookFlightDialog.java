import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BookFlightDialog {
    private JDialog dialog;
    private JTextField flightNumberField;
    private JButton submitButton, returnButton;
    private LoyaltyProgram loyaltyProgram;
    private Member member;

    public BookFlightDialog(LoyaltyProgram loyaltyProgram, Member member) {
//        this.loyaltyProgram = loyaltyProgram;
//        this.member = member;

        dialog = new JDialog();
        dialog.setTitle("Book Flight");
        dialog.setSize(400, 300);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Show list of available flights
        JLabel availableFlightsLabel = new JLabel("Available Flights:");
        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(availableFlightsLabel, gbc);

        // Use the listFlights() method to get the formatted string of available flights
        String flightList = loyaltyProgram.listFlights();  // Get the list of flights as a string

        // Display the list of flights in the dialog
        JLabel flightsLabel = new JLabel("<html>" + flightList.replace("\n", "<br>") + "</html>");  // Replace newlines with <br> for HTML
        gbc.gridx = 0; gbc.gridy = 1;
        dialog.add(flightsLabel, gbc);

        // Input field for flight number
        JLabel flightNumberLabel = new JLabel("Enter Flight Number:");
        gbc.gridx = 0; gbc.gridy = 2;
        dialog.add(flightNumberLabel, gbc);

        flightNumberField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 2;
        dialog.add(flightNumberField, gbc);

        // Submit button
        submitButton = new JButton("Submit");
        gbc.gridx = 1; gbc.gridy = 3;
        dialog.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String flightNumber = flightNumberField.getText().toUpperCase();
            boolean flightFound = false;

            // Check if the entered flight number exists in the available flights
            for (Flight flight : loyaltyProgram.getFlights()) {
                if (flight != null && flight.getFlightNum().equals(flightNumber)) {
                    // Book the flight
                    loyaltyProgram.bookFlight(member, flight);  // Book the flight using the loyalty program
                    JOptionPane.showMessageDialog(dialog, "Flight booked successfully!");
                    flightFound = true;
                    break;
                }
            }

            if (!flightFound) {
                JOptionPane.showMessageDialog(dialog, "This flight does not exist.");
            }
        });

        // Return to main menu button
        returnButton = new JButton("Return to Main Menu");
        gbc.gridx = 1; gbc.gridy = 4;
        dialog.add(returnButton, gbc);

        returnButton.addActionListener(e -> dialog.setVisible(false));  // Close dialog

        dialog.setVisible(true);
    }
}