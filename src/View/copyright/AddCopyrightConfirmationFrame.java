package View.copyright;

import javax.swing.*;

public class AddCopyrightConfirmationFrame extends JFrame {
    public AddCopyrightConfirmationFrame() {
        setTitle("Copyright added successfully");
        setSize(300, 100);
        JLabel label = new JLabel("Copyright added successfully");
        add(label);
        setVisible(true);
    }
}
