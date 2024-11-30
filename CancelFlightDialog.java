import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CancelFlightDialog {
    private JDialog dialog;
    private JTextField flightNumberField;
    private JButton submitButton, returnButton;

    public CancelFlightDialog(LoyaltyProgram loyaltyProgram, Member member) {
        dialog = new JDialog();
        dialog.setTitle("Cancel Flight");
        dialog.setSize(400, 300);
        dialog.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Show list of booked flights
        JLabel bookedFlightsLabel = new JLabel("Booked Flights:");
        gbc.gridx = 0; gbc.gridy = 0;
        dialog.add(bookedFlightsLabel, gbc);

        // List booked flights
        StringBuilder bookedFlightList = new StringBuilder("<html>");
        if (member.getFlightsCounter() > 0) {
            for (Flight bookedFlight : member.getBookedFlights()) {
                if (bookedFlight != null) {
                    bookedFlightList.append("Flight Number: ").append(bookedFlight.getFlightNum())
                            .append(" | From: ").append(bookedFlight.getDeparture())
                            .append(" | To: ").append(bookedFlight.getDestination())
                            .append("<br>");
                }
            }
        } else {
            bookedFlightList.append("No flights booked.");
        }
        bookedFlightList.append("</html>");

        // Display the list of booked flights in the dialog
        JLabel flightsLabel = new JLabel(bookedFlightList.toString());
        gbc.gridx = 0; gbc.gridy = 1;
        dialog.add(flightsLabel, gbc);

        // Input field for flight number
        JLabel flightNumberLabel = new JLabel("Enter Flight Number to Cancel:");
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

            // Check if the flight is booked
            for (Flight bookedFlight : member.getBookedFlights()) {
                if (bookedFlight != null && bookedFlight.getFlightNum().equals(flightNumber)) {
                    // Cancel the flight
                    member.removeFlight(bookedFlight);
                    bookedFlight.removePassenger(member);
                    JOptionPane.showMessageDialog(dialog, "Flight canceled successfully!");
                    flightFound = true;
                    break;
                }
            }

            if (!flightFound) {
                JOptionPane.showMessageDialog(dialog, "This flight is not in your bookings.");
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
