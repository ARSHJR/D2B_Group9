package View.artist;

import javax.swing.*;

public class EditArtistsConfirmationFrame extends JFrame {
    public EditArtistsConfirmationFrame() {
        setTitle("Artist edited successfully");
        setSize(300, 100);
        JLabel label = new JLabel("Artist edited Successfully");
        add(label);
        setVisible(true);
    }
}
