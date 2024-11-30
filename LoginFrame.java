import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class LoginFrame {
    private JFrame loginFrame;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame(LoyaltyProgramGUI loyaltyProgramGUI) {
        // Initialize the frame
        loginFrame = new JFrame("Airline Loyalty Program - Login");
        loginFrame.setSize(450, 600);
        loginFrame.setResizable(false);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.getContentPane().setBackground(new Color(225, 246, 255));

        // Load the image (used for icon and body)
        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/plane_Logo.png")));
        JLabel imageLabel = new JLabel(imageIcon);
        loginFrame.setIconImage(imageIcon.getImage());

        loginFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                loyaltyProgramGUI.exitProgram();
                System.exit(0);
            }
        });
        loginFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent default close behavior

        // Set GridBagLayout
        loginFrame.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);

        // Resize the body image
        Image scaledImage = imageIcon.getImage().getScaledInstance(150, 75, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(imageIcon);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // Span across 2 columns
        gbc.insets = new Insets(10, 0, 10, 0); // Add padding around the image
        gbc.anchor = GridBagConstraints.CENTER;
        loginFrame.add(imageLabel, gbc);

        gbc.gridwidth = 1;

        // Add Username Label and Field
        gbc.gridx = 0;
        gbc.gridy = 1; // Position (0,1)
        gbc.anchor = GridBagConstraints.EAST; // Align to the right
        loginFrame.add(new JLabel("Username: "), gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        loginFrame.add(usernameField, gbc);

        // Add Password Label and Field
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        loginFrame.add(new JLabel("Password: "), gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        loginFrame.add(passwordField, gbc);

        // Add Login Button
        loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        loginFrame.add(loginButton, gbc);

        // Action listener for the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                System.out.println("Attempting login for username: " + username + " and pass: " + password); // Debug message

                try {
                    Member member = loyaltyProgramGUI.login(username, password);
                    System.out.println("Login successful for: " + username); // Debug message

                    if (member != null) {
                        System.out.println("Transitioning to UserAccountPage...");
                        loginFrame.dispose();
                        new UserAccountFrame(loyaltyProgramGUI, member).show();
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

