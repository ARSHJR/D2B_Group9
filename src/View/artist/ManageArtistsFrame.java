package View.artist;

import javax.swing.*;
import java.awt.*;

public class ManageArtistsFrame extends JFrame {

    InitialPanelArtists artists_ip;

    public ManageArtistsFrame() {
        super("Manage Artists Dashboard");
        artists_ip = new InitialPanelArtists();
        artists_ip.setBackground(Color.DARK_GRAY);
        add(artists_ip);
        pack();
        setSize(500, 600);
    }

    public InitialPanelArtists getArtists_ip() {
        return artists_ip;
    }

    public void setArtists_ip(InitialPanelArtists artists_ip) {
        this.artists_ip = artists_ip;
    }
}
