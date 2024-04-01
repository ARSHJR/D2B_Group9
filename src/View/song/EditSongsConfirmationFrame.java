package View.song;

import javax.swing.*;

public class EditSongsConfirmationFrame extends JFrame {
    public EditSongsConfirmationFrame() {
        setTitle("Song edited successfully");
        setSize(300, 100);
        JLabel label = new JLabel("Song edited successfully");
        add(label);
        setVisible(true);
    }
}
