package View.song;

import javax.swing.*;

public class DeleteSongsConfirmationFrame extends JFrame {
    public DeleteSongsConfirmationFrame() {
        setTitle("Song deleted successfully");
        setSize(300, 100);
        JLabel label = new JLabel("Song deleted successfully");
        add(label);
        setVisible(true);
    }
}
