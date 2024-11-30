import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ViewDetailsDialog {
    private JDialog dialog;

    public ViewDetailsDialog(Member member) {
        dialog = new JDialog();
        dialog.setTitle("View Details");
        dialog.setSize(300, 200);
        dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));

        // Add components (example: member details)
        dialog.add(new JLabel("Name: " + member.getName()));
        dialog.add(new JLabel("Membership Level: " + member.getMembershipLevel()));
        dialog.add(new JLabel("Points: " + member.getPoints()));

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dialog.setVisible(false));
        dialog.add(closeButton);
    }

    public void show() {
        dialog.setVisible(true);
    }
}
