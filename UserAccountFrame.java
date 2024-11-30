import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Objects;

public class UserAccountFrame {
    private JFrame accountFrame;

    public UserAccountFrame(LoyaltyProgramGUI loyaltyProgramGUI, Member member) {
        // Initialize the frame
        accountFrame = new JFrame("User Dashboard");
        accountFrame.setSize(450, 600);
        accountFrame.setResizable(false);
        accountFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountFrame.setLayout(new GridBagLayout());
        accountFrame.setLocationRelativeTo(null);
        accountFrame.getContentPane().setBackground(new Color(225, 246, 255));
        GridBagConstraints gbc = new GridBagConstraints();

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/plane_Logo.png")));
        JLabel imageLabel = new JLabel(imageIcon);
        accountFrame.setIconImage(imageIcon.getImage());

        accountFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Call the exitProgram method before exiting
                loyaltyProgramGUI.exitProgram();
                System.exit(0); // Terminate the program
            }
        });
        accountFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Prevent default close behavior

        // Add Welcome Label
        gbc.gridx = 0; gbc.gridy = 0; // Position (0,0)
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 10, 0);
        gbc.anchor = GridBagConstraints.CENTER;
        accountFrame.add(new JLabel("Welcome, " + member.getName() + "!"), gbc);

        // Add Book Flight Button
        JButton bookFlightButton = new JButton("Book Flight");
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        accountFrame.add(bookFlightButton, gbc);

        // Add Cancel Flight Button
        JButton cancelFlightButton = new JButton("Cancel Flight");
        gbc.gridx = 1; gbc.gridy = 1;
        accountFrame.add(cancelFlightButton, gbc);

        // Add View Details Button
        JButton viewDetailsButton = new JButton("View Account Details");
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        accountFrame.add(viewDetailsButton, gbc);

        // Add Logout Button
        JButton logoutButton = new JButton("Logout");
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.gridwidth = 2;
        accountFrame.add(logoutButton, gbc);

        // Action listeners for buttons
        bookFlightButton.addActionListener(e -> new BookFlightDialog(loyaltyProgramGUI, member));
        cancelFlightButton.addActionListener(e -> {
            if (member.getFlightsCounter() == 0) {
                JOptionPane.showMessageDialog(accountFrame, "You have no booked flights.");
            } else {
                new CancelFlightDialog(loyaltyProgramGUI, member); // Open the dialog only if flights exist
            }
        });
        viewDetailsButton.addActionListener(e -> new ViewDetailsDialog(member).show());
        logoutButton.addActionListener(e -> {
            accountFrame.setVisible(false);
            new LoginFrame(loyaltyProgramGUI);
        });

        // Show the frame
        accountFrame.setVisible(true);
    }

    public void show() {
        accountFrame.setVisible(true);
    }
}
