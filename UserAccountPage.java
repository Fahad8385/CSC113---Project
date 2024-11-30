import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserAccountPage {
    private JFrame accountFrame;

    public UserAccountPage(LoyaltyProgram loyaltyProgram, Member member) {
        // Initialize the frame
        accountFrame = new JFrame("User Dashboard");
        accountFrame.setSize(450, 600);
        accountFrame.setResizable(false);
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountFrame.setLayout(new GridBagLayout());
        accountFrame.setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();

        // Add Welcome Label
        gbc.gridx = 0; gbc.gridy = 0; // Position (0,0)
        gbc.gridwidth = 2; // Span 2 columns
        gbc.insets = new Insets(10, 0, 10, 0); // Add padding
        gbc.anchor = GridBagConstraints.CENTER;
        accountFrame.add(new JLabel("Welcome, " + member.getName() + "!"), gbc);

        // Add Book Flight Button
        JButton bookFlightButton = new JButton("Book Flight");
        gbc.gridx = 0; gbc.gridy = 1; // Position (0,1)
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        accountFrame.add(bookFlightButton, gbc);

        // Add Cancel Flight Button
        JButton cancelFlightButton = new JButton("Cancel Flight");
        gbc.gridx = 1; gbc.gridy = 1; // Position (1,1)
        accountFrame.add(cancelFlightButton, gbc);

        // Add View Details Button
        JButton viewDetailsButton = new JButton("View Account Details");
        gbc.gridx = 0; gbc.gridy = 2; // Position (0,2)
        gbc.gridwidth = 2; // Span 2 columns
        accountFrame.add(viewDetailsButton, gbc);

        // Add Logout Button
        JButton logoutButton = new JButton("Logout");
        gbc.gridx = 0; gbc.gridy = 3; // Position (0,3)
        gbc.gridwidth = 2; // Span 2 columns
        accountFrame.add(logoutButton, gbc);

        // Action listeners for buttons
        bookFlightButton.addActionListener(e -> new BookFlightDialog(loyaltyProgram, member));
        cancelFlightButton.addActionListener(e -> new CancelFlightDialog(loyaltyProgram, member));
        viewDetailsButton.addActionListener(e -> new ViewDetailsDialog(member).show());
        logoutButton.addActionListener(e -> {
            accountFrame.setVisible(false);
            new LoginFrame(loyaltyProgram);
        });

        // Show the frame
        accountFrame.setVisible(true);
    }

    public void show() {
        accountFrame.setVisible(true);
    }
}
