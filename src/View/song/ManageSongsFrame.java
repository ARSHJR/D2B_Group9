package View.song;
import View.song.InitialPanelSongs;

import javax.swing.*;
public class ManageSongsFrame extends JFrame {
    InitialPanelSongs ip;

    public ManageSongsFrame() {
        super("Manage Song Dashboard");
        ip = new InitialPanelSongs();
        add(ip);
        pack();
        setSize(500,600);
    }

    public void setIp(InitialPanelSongs ip) {
        this.ip = ip;
    }
    public InitialPanelSongs getSongIp() {
        return ip;
    }
}
