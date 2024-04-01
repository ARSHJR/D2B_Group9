package View.artist;

import javax.swing.*;
import java.awt.*;

public class AddArtistsConfirmationFrame extends JFrame {
    public AddArtistsConfirmationFrame() {
        setTitle("Artist added successfully");
        setSize(300, 100);
        JLabel label = new JLabel("Artist Added Successfully");
        add(label);
        setVisible(true);
    }
}
