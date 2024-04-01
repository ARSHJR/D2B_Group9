package View.artist;

import javax.swing.*;
import java.awt.*;

public class DeleteArtistsPanel extends JPanel {
    JTextField txt_del_artist_id;
    JButton deleteArtistBtn;

    public DeleteArtistsPanel() {
        txt_del_artist_id = new JTextField();
        deleteArtistBtn = new JButton();

        txt_del_artist_id.setText("Enter ID of artist to be deleted");
        deleteArtistBtn.setText("Delete Artist");
        deleteArtistBtn.setBackground(Color.decode("#39a78e"));

        add(txt_del_artist_id);
        add(deleteArtistBtn);
    }

    public JTextField getTxt_del_artist_id() {
        return txt_del_artist_id;
    }

    public JButton getDeleteArtistBtn() {
        return deleteArtistBtn;
    }

    public void setTxt_del_artist_id(JTextField txt_del_artist_id) {
        this.txt_del_artist_id = txt_del_artist_id;
    }

    public void setDeleteArtistBtn(JButton deleteArtistBtn) {
        this.deleteArtistBtn = deleteArtistBtn;
    }
}
