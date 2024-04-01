package View.song;

import javax.swing.*;

public class AddSongsConfirmationFrame extends JFrame {
    public AddSongsConfirmationFrame() {
        setTitle("Song added successfully");
        setSize(300, 100);
        JLabel label = new JLabel("Song added successfully");
        add(label);
        setVisible(true);
    }
}
