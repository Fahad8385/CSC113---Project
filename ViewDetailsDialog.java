import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class ViewDetailsDialog {
    private JDialog detailsDialog;

    public ViewDetailsDialog(Member member) {
        detailsDialog = new JDialog();
        detailsDialog.setTitle("View Details");
        detailsDialog.setResizable(false);
        detailsDialog.setSize(400, 300);
        detailsDialog.setLayout(new GridBagLayout());
        detailsDialog.setLocationRelativeTo(null);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);

        ImageIcon imageIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/person-icon-1682.png")));
        JLabel imageLabel = new JLabel(imageIcon);
        detailsDialog.setIconImage(imageIcon.getImage());

        // Resize the image
        Image scaledImage = imageIcon.getImage().getScaledInstance(150, 75, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(scaledImage);
        imageLabel.setIcon(imageIcon);

        // Add member details
        JLabel nameLabel = new JLabel("Name: " + member.getName());
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        detailsDialog.add(nameLabel, gbc);

        JLabel membershipLabel = new JLabel("Membership Level: " + member.getMembershipLevel());
        gbc.gridx = 0;
        gbc.gridy = 1;
        detailsDialog.add(membershipLabel, gbc);

        JLabel pointsLabel = new JLabel("Points: " + member.getPoints());
        gbc.gridx = 0;
        gbc.gridy = 2;
        detailsDialog.add(pointsLabel, gbc);

        // Add close button
        JButton closeButton = new JButton("Close");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        detailsDialog.add(closeButton, gbc);

        // Add action listener to close the dialog
        closeButton.addActionListener(e -> detailsDialog.setVisible(false));
    }

    public void show() {
        detailsDialog.setVisible(true);
    }
}