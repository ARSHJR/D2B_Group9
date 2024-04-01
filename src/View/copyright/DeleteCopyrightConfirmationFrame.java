package View.copyright;

import javax.swing.*;

public class DeleteCopyrightConfirmationFrame extends JFrame {
    public DeleteCopyrightConfirmationFrame() {
        setTitle("Copyright deleted successfully");
        setSize(300, 100);
        JLabel label = new JLabel("Copyright deleted successfully");
        add(label);
        setVisible(true);
    }
}
