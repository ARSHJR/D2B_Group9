package View.artist;

import javax.swing.*;

public class DeleteArtistsConfirmationFrame extends JFrame {
    public DeleteArtistsConfirmationFrame() {
        setTitle("Artist Deleted successfully");
        setSize(300, 100);
        JLabel label = new JLabel("Artist Deleted Successfully");
        add(label);
        setVisible(true);
    }
}
