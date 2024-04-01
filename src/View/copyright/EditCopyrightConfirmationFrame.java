package View.copyright;

import javax.swing.*;

public class EditCopyrightConfirmationFrame extends JFrame {
    public EditCopyrightConfirmationFrame() {
        setTitle("Copyright edited successfully");
        setSize(300, 100);
        JLabel label = new JLabel("Copyright edited successfully");
        add(label);
        setVisible(true);
    }
}
