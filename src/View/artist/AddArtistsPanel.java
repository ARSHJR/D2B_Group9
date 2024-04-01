package View.artist;

import javax.swing.*;
import java.awt.*;

public class AddArtistsPanel extends JPanel {
    JTextField txt_A_id;
    JTextField txt_A_f_name;
    JTextField txt_A_l_name;
    JTextField email;
    JTextField networth;
    JTextField Genre;
    JTextField Label;
    JButton addArtistbtn;

    public AddArtistsPanel() {
        setBackground(Color.gray);
        txt_A_id = new JTextField();
        txt_A_f_name = new JTextField();
        txt_A_l_name = new JTextField();
        email = new JTextField();
        networth = new JTextField();
        Genre = new JTextField();
        Label = new JTextField();
        addArtistbtn = new JButton();
        addArtistbtn.setBackground(Color.decode("#39a78e"));

        txt_A_id.setText("Artist's id");
        txt_A_f_name.setText("Artist's first name");
        txt_A_l_name.setText("Artist's last name");
        email.setText("Artist's email ID");
        networth.setText("Artist's networth");
        Genre.setText("Artist's genre");
        Label.setText("Artist's label");
        addArtistbtn.setText("Add Artist");

        add(txt_A_id);
        add(txt_A_f_name);
        add(txt_A_l_name);
        add(email);
        add(networth);
        add(Genre);
        add(Label);
        add(addArtistbtn);
    }

    public JButton getAddArtistbtn() {
        return addArtistbtn;
    }

    public JTextField getTxt_A_id() {
        return txt_A_id;
    }

    public JTextField getTxt_A_f_name() {
        return txt_A_f_name;
    }

    public JTextField getTxt_A_l_name() {
        return txt_A_l_name;
    }

    public JTextField getEmail() {
        return email;
    }

    public JTextField getNetworth() {
        return networth;
    }

    public JTextField getGenre() {
        return Genre;
    }

    public JTextField getLabel() {
        return Label;
    }

    public void setAddArtistbtn(JButton addArtistbtn) {
        this.addArtistbtn = addArtistbtn;
    }

    public void setTxt_A_id(JTextField txt_A_id) {
        this.txt_A_id = txt_A_id;
    }

    public void setTxt_A_f_name(JTextField txt_A_f_name) {
        this.txt_A_f_name = txt_A_f_name;
    }

    public void setTxt_A_l_name(JTextField txt_A_l_name) {
        this.txt_A_l_name = txt_A_l_name;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    public void setGenre(JTextField genre) {
        Genre = genre;
    }

    public void setLabel(JTextField label) {
        Label = label;
    }
}
