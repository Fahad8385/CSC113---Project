import javax.swing.*;
import java.awt.*;

public class CancelFlightDialog {
    private JDialog cancelDialog;
    private JTextField flightNumberField;
    private JButton submitButton, returnButton;

    public CancelFlightDialog(LoyaltyProgramGUI loyaltyProgramGUI, Member member) {
        cancelDialog = new JDialog();
        cancelDialog.setTitle("Cancel Flight");
        cancelDialog.setSize(500, 400);
        cancelDialog.setLayout(new GridBagLayout());
        cancelDialog.setResizable(false);
        GridBagConstraints gbc = new GridBagConstraints();
        cancelDialog.setLocationRelativeTo(null);

        JLabel bookedFlightsLabel = new JLabel("Booked Flights:");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;
        cancelDialog.add(bookedFlightsLabel, gbc);

        // Booked flights list in a scroll pane
        StringBuilder bookedFlightList = new StringBuilder();
        if (member.getFlightsCounter() > 0) {
            for (Flight bookedFlight : member.getBookedFlights()) {
                if (bookedFlight != null) {
                    bookedFlightList.append("Flight Number: ").append(bookedFlight.getFlightNum())
                            .append(" | From: ").append(bookedFlight.getDeparture())
                            .append(" | To: ").append(bookedFlight.getDestination())
                            .append("\n");
                }
            }
        } else {
            bookedFlightList.append("No flights booked.");
        }

        JTextArea flightsTextArea = new JTextArea(10, 40); // Multi-line, fixed size
        flightsTextArea.setText(bookedFlightList.toString());
        flightsTextArea.setEditable(false);
        flightsTextArea.setLineWrap(true);
        flightsTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(flightsTextArea);
        flightsTextArea.setCaretPosition(0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH; // Allow the scroll pane to expand
        cancelDialog.add(scrollPane, gbc);

        // Input field for flight number
        JLabel flightNumberLabel = new JLabel("Enter Flight Number to Cancel:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        cancelDialog.add(flightNumberLabel, gbc);

        flightNumberField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        cancelDialog.add(flightNumberField, gbc);

        // Submit button
        submitButton = new JButton("Cancel Booking");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        cancelDialog.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            String flightNumber = flightNumberField.getText().toUpperCase();
            boolean flightFound = false;

            // Check if the flight is booked
            for (Flight bookedFlight : member.getBookedFlights()) {
                if (bookedFlight != null && bookedFlight.getFlightNum().equals(flightNumber)) {
                    member.removeFlight(bookedFlight);
                    bookedFlight.removePassenger(member);
                    JOptionPane.showMessageDialog(cancelDialog, "Flight canceled successfully!");
                    loyaltyProgramGUI.cancelFlight(member, bookedFlight);
                    flightFound = true;
                    cancelDialog.dispose();
                    break;
                }
            }

            if (!flightFound) {
                JOptionPane.showMessageDialog(cancelDialog, "This flight is not in your bookings.");
            }
        });

        // Return to main menu button
        returnButton = new JButton("Return to Main Menu");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        cancelDialog.add(returnButton, gbc);

        returnButton.addActionListener(e -> cancelDialog.setVisible(false));

        cancelDialog.setVisible(true);
    }
}