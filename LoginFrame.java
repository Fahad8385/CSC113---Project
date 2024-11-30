import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginFrame {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame(LoyaltyProgram loyaltyProgram) {
        // Initialize the frame
        loginFrame = new JFrame("Airline Loyalty Program - Login");
        loginFrame.setSize(450, 600);
        loginFrame.setResizable(false);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        // Set GridBagLayout
        loginFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Add Username Label and Field
        gbc.gridx = 0; gbc.gridy = 0; // Position (0,0)
        gbc.anchor = GridBagConstraints.EAST; // Align to the right
        loginFrame.add(new JLabel("Username:"), gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1; gbc.gridy = 0; // Position (1,0)
        gbc.anchor = GridBagConstraints.WEST; // Align to the left
        loginFrame.add(usernameField, gbc);

        // Add Password Label and Field
        gbc.gridx = 0; gbc.gridy = 1; // Position (0,1)
        gbc.anchor = GridBagConstraints.EAST;
        loginFrame.add(new JLabel("Password:"), gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1; gbc.gridy = 1; // Position (1,1)
        gbc.anchor = GridBagConstraints.WEST;
        loginFrame.add(passwordField, gbc);

        // Add Login Button
        loginButton = new JButton("Login");
        gbc.gridx = 0; gbc.gridy = 2; // Position (0,2)
        gbc.gridwidth = 2; // Span 2 columns
        gbc.anchor = GridBagConstraints.CENTER; // Center the button
        loginFrame.add(loginButton, gbc);

        // Action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                System.out.println("Attempting login for username: " + username + " and pass: " + password); // Debug message

                try {
                    Member member = loyaltyProgram.login(username, password);
                    System.out.println("Login successful for: " + username); // Debug message

                    if (member != null) {
                        System.out.println("Transitioning to UserAccountPage...");
                        // loginFrame.setVisible(false);
                        loginFrame.dispose();
                        new UserAccountPage(loyaltyProgram, member).show();
                    }
                } catch (CustomException ex) {
                    JOptionPane.showMessageDialog(loginFrame, ex.getMessage());
                }
            }
        });


        // Show the frame
        loginFrame.setVisible(true);
    }
}
