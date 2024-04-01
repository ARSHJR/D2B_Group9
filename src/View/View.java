package View;
import Model.Artists.ManageArtists;
import View.artist.ManageArtistsFrame;
import View.copyright.ManageCopyrightFrame;
import View.song.ManageSongsFrame;
import java.awt.*;
import java.util.ArrayList;

public class View {
    FirstFrame ff;
    CreditsFrame cf;
    ManageArtistsFrame MA_f;
    ManageSongsFrame MS_f;
    ManageCopyrightFrame MC_f;

    public View() {
        ff = new FirstFrame();
        cf = new CreditsFrame();
        MA_f = new ManageArtistsFrame();
        MS_f = new ManageSongsFrame();
        MC_f = new ManageCopyrightFrame();
    }

    public void centerInitialSetupArtists(int linesBeingDisplayed, int size) {
        MA_f.getArtists_ip().getAtp().setLayout(new GridLayout(linesBeingDisplayed+1, size));
        MA_f.getArtists_ip().getAtp().createButtons((linesBeingDisplayed+1) * size);
    }

    public void centerUpdateArtists(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            MA_f.getArtists_ip().getAtp().getAllButtons().get(i).setText(headers.get(i));
        }

        for(int artists_row_no = 0; artists_row_no < lines.size(); artists_row_no++) {
            for(int artists_col_no = 0; artists_col_no < headers.size(); artists_col_no++) {
                int button_no = artists_row_no * headers.size() + headers.size() + artists_col_no;
                String button_txt = lines.get(artists_row_no).get(artists_col_no);

                MA_f.getArtists_ip().getAtp().getAllButtons().get(button_no).setText(button_txt);
            }
        }
    }

    //songs:

    public void centerInitialSetupSongs(int linesBeingDisplayed, int size) {
        MS_f.getSongIp().getStp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
        MS_f.getSongIp().getStp().createButtons((linesBeingDisplayed + 1)*size);
    }
    public void centerInitialSetupCopyright(int linesBeingDisplayed, int size) {
        MC_f.getIc().getCtp().setLayout(new GridLayout(linesBeingDisplayed + 1, size));
        MC_f.getIc().getCtp().createButtons((linesBeingDisplayed + 1)*size);
    }

    public void centerUpdateSong(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i< headers.size(); i++) {
            MS_f.getSongIp().getStp().getSongs_buttons().get(i).setText(headers.get(i));
        }

        for (int song_row = 0; song_row< lines.size(); song_row++) {
            for (int song_cl = 0; song_cl<headers.size(); song_cl++) {
                int button_no = song_row * headers.size() + headers.size() + song_cl;
                String button_txt = lines.get(song_row).get(song_cl);

                MS_f.getSongIp().getStp().getSongs_buttons().get(button_no).setText(button_txt);
            }
        }
    }
    public void centerUpdateCopyright(ArrayList<ArrayList<String>> lines, ArrayList<String> headers) {
        for (int i = 0; i < headers.size(); i++) {
            MC_f.getIc().getCtp().getButtons().get(i).setText(headers.get(i));
        }

        for (int copyright_row = 0; copyright_row < lines.size(); copyright_row++) {
            for (int copyright_cl = 0; copyright_cl < headers.size(); copyright_cl++) {
                int button_no = copyright_row * headers.size() + headers.size() + copyright_cl;
                String button_txt = lines.get(copyright_row).get(copyright_cl);

                MC_f.getIc().getCtp().getButtons().get(button_no).setText(button_txt);
            }
        }
    }

    public void setFf(FirstFrame ff) {
        this.ff = ff;
    }

    public FirstFrame getFf() {
        return ff;
    }

    public ManageArtistsFrame getMA_f() {
        return MA_f;
    }

    public void setMS_f(ManageSongsFrame MS_f) {
        this.MS_f = MS_f;
    }

    public ManageSongsFrame getMS_f() {
        return MS_f;
    }

    public void setMA_f(ManageArtistsFrame MA_f) {
        this.MA_f = MA_f;
    }

    public void setMC_f(ManageCopyrightFrame MC_f) {
        this.MC_f = MC_f;
    }

    public ManageCopyrightFrame getMC_f() {
        return MC_f;
    }

    public CreditsFrame getCf() {
        return cf;
    }
}

