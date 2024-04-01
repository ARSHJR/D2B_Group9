package Model;

import Model.Artists.ManageArtists;
import Model.Copyrights.ManageCopyrights;
import Model.Songs.ManageSongs;

public class Model {
    ManageArtists ma;
    ManageSongs ms;
    ManageCopyrights mc;
    public Model() {
        ma = new ManageArtists();
        ms = new ManageSongs();
        mc = new ManageCopyrights();
    }

    public ManageArtists getMa() {
        return ma;
    }

    public ManageSongs getMs() {
        return ms;
    }

    public ManageCopyrights getMc() {
        return mc;
    }

    public void setMa(ManageArtists ma) {
        this.ma = ma;
    }

    public void setMs(ManageSongs ms) {
        this.ms = ms;
    }

    public void setMc(ManageCopyrights mc) {
        this.mc = mc;
    }
}
