package View.song;

import javax.swing.JPanel;
import java.awt.*;

public class InitialPanelSongs extends JPanel {
    private SongTablePanel stp;
    private AddPanelSongs aps;
    private EditSongPanel esp;
    private DeleteSongPanel dsp;

    public InitialPanelSongs() {
        super();
        setBackground(Color.darkGray);

        stp = new SongTablePanel();
        stp.setBackground(Color.gray);
        add(stp);
        aps = new AddPanelSongs();
        aps.setBackground(Color.gray);
        add(aps);
        esp = new EditSongPanel();
        esp.setBackground(Color.gray);
        add(esp);
        dsp = new DeleteSongPanel();
        dsp.setBackground(Color.gray);
        add(dsp);
    }

    public SongTablePanel getStp() {
        return stp;
    }

    public void setStp(SongTablePanel stp) {
        this.stp = stp;
    }

    public void setAps(AddPanelSongs aps) {
        this.aps = aps;
    }

    public AddPanelSongs getAps() {
        return aps;
    }

    public void setEsp(EditSongPanel esp) {
        this.esp = esp;
    }

    public EditSongPanel getEsp() {
        return esp;
    }

    public void setDsp(DeleteSongPanel dsp) {
        this.dsp = dsp;
    }

    public DeleteSongPanel getDsp() {
        return dsp;
    }
}
