import javax.swing.*;
import java.awt.*;

public class BookFlightDialog {
    private JDialog bookDialog;
    private JTextField flightNumberField;
    private JButton submitButton, returnButton;

    public BookFlightDialog(LoyaltyProgramGUI loyaltyProgramGUI, Member member) {
        bookDialog = new JDialog();
        bookDialog.setTitle("Book Flight");
        bookDialog.setSize(500, 400);
        bookDialog.setLayout(new GridBagLayout());
        bookDialog.setResizable(false);
        bookDialog.setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();

        // Label for available flights
        JLabel availableFlightsLabel = new JLabel("Available Flights:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding
        gbc.anchor = GridBagConstraints.CENTER;
        bookDialog.add(availableFlightsLabel, gbc);

        // Flight list in a scroll pane with numbering and details
        StringBuilder flightListBuilder = new StringBuilder();
        Flight[] flights = loyaltyProgramGUI.getFlights();
        int flightCounter = 1;

        for (Flight flight : flights) {
            if (flight != null) {
                flightListBuilder.append(flightCounter++).append(". Flight Number: ").append(flight.getFlightNum())
                        .append(" | From: ").append(flight.getDeparture())
                        .append(" | To: ").append(flight.getDestination())
                        .append("\n");
            }
        }

        if (flightListBuilder.isEmpty()) {
            flightListBuilder.append("No flights available.");
        }

        JTextArea flightsTextArea = new JTextArea(10, 40);
        flightsTextArea.setText(flightListBuilder.toString());
        flightsTextArea.setEditable(false);
        flightsTextArea.setLineWrap(true);
        flightsTextArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(flightsTextArea);
        flightsTextArea.setCaretPosition(0);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        bookDialog.add(scrollPane, gbc);

        // Input field for flight number
        JLabel flightNumberLabel = new JLabel("Enter Flight Number:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.NONE;
        bookDialog.add(flightNumberLabel, gbc);

        flightNumberField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        bookDialog.add(flightNumberField, gbc);

        // Submit button
        submitButton = new JButton("Book");
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        bookDialog.add(submitButton, gbc);

        submitButton.addActionListener(e -> {
            try {
                String flightNumber = flightNumberField.getText().toUpperCase();
                boolean flightFound = false;

                // Check if the flight is already booked
                for (Flight flight : member.bookedFlights) {
                    if (member.flightsCounter > 0 && flight != null) {
                        if (flight.getFlightNum().equals(flightNumber)) {
                            JOptionPane.showMessageDialog(bookDialog, "You have already booked this flight!");
                            flightFound = true;
                            bookDialog.dispose();
                            break;
                        }
                    }
                }

                // Check if the entered flight number exists in the available flights
                if (!flightFound) {
                    for (Flight flight : loyaltyProgramGUI.getFlights()) {
                        if (flight != null && flight.getFlightNum().equals(flightNumber)) {
                            // Book the flight
                            loyaltyProgramGUI.bookFlight(member, flight);
                            JOptionPane.showMessageDialog(bookDialog, "Flight booked successfully!");
                            flightFound = true;
                            bookDialog.dispose();
                            break;
                        }
                    }
                }

                if (!flightFound) {
                    JOptionPane.showMessageDialog(bookDialog, "This flight does not exist.");
                }

            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(bookDialog, ex.getMessage());
            }
        });


        // Return to main menu button
        returnButton = new JButton("Return to Main Menu");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        bookDialog.add(returnButton, gbc);

        returnButton.addActionListener(e -> bookDialog.setVisible(false));

        bookDialog.setVisible(true);
    }
}