package View.artist;

import javax.swing.*;
import java.awt.*;

public class InitialPanelArtists extends JPanel {
    private ArtistsTablePanel atp;
    private AddArtistsPanel aap;
    private EditArtistsPanel eap;
    private DeleteArtistsPanel dap;
    public InitialPanelArtists() {
        super();
        atp = new ArtistsTablePanel();
        atp.setBackground(Color.DARK_GRAY);
        add(atp);
        aap = new AddArtistsPanel();
        aap.setBackground(Color.gray);
        add(aap);
        eap = new EditArtistsPanel();
        eap.setBackground(Color.gray);
        add(eap);
        dap = new DeleteArtistsPanel();
        dap.setBackground(Color.gray);
        add(dap);
    }

    public ArtistsTablePanel getAtp() {
        return atp;
    }

    public AddArtistsPanel getAap() {
        return aap;
    }

    public EditArtistsPanel getEap() {
        return eap;
    }

    public DeleteArtistsPanel getDap() {
        return dap;
    }

    public void setAtp(ArtistsTablePanel atp) {
        this.atp = atp;
    }

    public void setAap(AddArtistsPanel aap) {
        this.aap = aap;
    }

    public void setEap(EditArtistsPanel eap) {
        this.eap = eap;
    }

    public void setDap(DeleteArtistsPanel dap) {
        this.dap = dap;
    }
}
