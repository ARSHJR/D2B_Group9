package View.artist;

import javax.swing.*;
import java.awt.*;

public class EditArtistsPanel extends JPanel {
    JTextField txt_get_artist_idx;
    JButton getArtistBtn;
    JLabel colon;
    JTextField txt_A_id;
    JTextField txt_f_name;
    JTextField txt_l_name;
    JTextField email;
    JTextField networth;
    JTextField genre;
    JTextField label;
    JButton editArtistBtn;

    public EditArtistsPanel() {
        txt_get_artist_idx = new JTextField();
        txt_A_id = new JTextField();
        txt_f_name = new JTextField();
        txt_l_name = new JTextField();
        email = new JTextField();
        networth = new JTextField();
        genre = new JTextField();
        label = new JTextField();
        getArtistBtn = new JButton();
        editArtistBtn = new JButton();
        colon = new JLabel();

        txt_get_artist_idx.setText("Enter Artist's index");
        getArtistBtn.setText("Get Artist");
        getArtistBtn.setBackground(Color.decode("#9aff9a"));
        txt_A_id.setText("ID");
        txt_f_name.setText("First name");
        txt_l_name.setText("Last name");
        email.setText("Email ID");
        networth.setText("Networth");
        genre.setText("Genre");
        label.setText("Label");
        editArtistBtn.setText("Edit Artist");
        editArtistBtn.setBackground(Color.decode("#39a78e"));
        colon.setText(":");

        add(txt_get_artist_idx);
        add(getArtistBtn);

        add(colon);

        add(txt_A_id);
        add(txt_f_name);
        add(txt_l_name);
        add(email);
        add(networth);
        add(genre);
        add(label);
        add(editArtistBtn);
    }

    public JTextField getTxt_get_artist_idx() {
        return txt_get_artist_idx;
    }

    public JTextField getTxt_A_id() {
        return txt_A_id;
    }

    public JTextField getTxt_f_name() {
        return txt_f_name;
    }

    public JTextField getTxt_l_name() {
        return txt_l_name;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getNetworth() {
        return networth;
    }

    public JTextField getGenre() {
        return genre;
    }

    public JTextField getLabel() {
        return label;
    }

    public JButton getGetArtistBtn() {
        return getArtistBtn;
    }

    public JButton getEditArtistBtn() {
        return editArtistBtn;
    }

    public void setTxt_get_artist_idx(JTextField txt_get_artist_idx) {
        this.txt_get_artist_idx = txt_get_artist_idx;
    }

    public void setTxt_A_id(JTextField txt_A_id) {
        this.txt_A_id = txt_A_id;
    }

    public void setTxt_f_name(JTextField txt_f_name) {
        this.txt_f_name = txt_f_name;
    }

    public void setTxt_l_name(JTextField txt_l_name) {
        this.txt_l_name = txt_l_name;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    public void setNetworth(JTextField networth) {
        this.networth = networth;
    }

    public void setGenre(JTextField genre) {
        this.genre = genre;
    }

    public void setLabel(JTextField label) {
        this.label = label;
    }

    public void setGetArtistBtn(JButton getArtistBtn) {
        this.getArtistBtn = getArtistBtn;
    }

    public void setEditArtistBtn(JButton editArtistBtn) {
        this.editArtistBtn = editArtistBtn;
    }
}
