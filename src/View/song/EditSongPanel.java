package View.song;

import javax.swing.*;
import java.awt.*;

public class EditSongPanel extends JPanel {
    JTextField txt_get_song_idx;
    JButton getAddSongBtn;
    JTextField txt_s_id;
    JTextField txt_language;
    JTextField txt_s_name;
    JTextField txt_s_duration;
    JTextField txt_media_rating;
    JTextField txt_media_date;
    JButton editSongBtn;

    public EditSongPanel() {
        txt_s_id = new JTextField();
        txt_language = new JTextField();
        txt_s_name = new JTextField();
        txt_s_duration = new JTextField();
        txt_media_rating = new JTextField();
        txt_media_date = new JTextField();
        editSongBtn = new JButton("Edit Song");
        txt_get_song_idx = new JTextField();
        getAddSongBtn = new JButton("Get Song to Edit");
        getAddSongBtn.setBackground(Color.decode("#9aff9a"));

        txt_s_id.setText("ID");
        txt_language.setText("Language");
        txt_s_name.setText("Name");
        txt_s_duration.setText("Duration");
        txt_media_rating.setText("Media rating");
        txt_media_date.setText("Media date");
        txt_get_song_idx.setText("idx");
        editSongBtn.setBackground(Color.decode("#39a78e"));

        add(txt_get_song_idx);
        add(getAddSongBtn);

        add(txt_s_id);
        add(txt_s_name);
        add(txt_language);
        add(txt_s_duration);
        add(txt_media_rating);
        add(txt_media_date);
        add(editSongBtn);
    }
    public JTextField getTxt_s_id() {
        return txt_s_id;
    }

    public JTextField getTxt_language() {
        return txt_language;
    }

    public JTextField getTxt_s_name() {
        return txt_s_name;
    }

    public JTextField getTxt_s_duration() {
        return txt_s_duration;
    }

    public JTextField getTxt_media_rating() {
        return txt_media_rating;
    }

    public JTextField getTxt_media_date() {
        return txt_media_date;
    }

    public JButton getEditSongBtn() {
        return editSongBtn;
    }

    public JButton getGetAddSongBtn() {
        return getAddSongBtn;
    }

    public JTextField getTxt_get_song_idx() {
        return txt_get_song_idx;
    }


    public void setTxt_s_id(JTextField txt_s_id) {
        this.txt_s_id = txt_s_id;
    }

    public void setEditSongBtn(JButton editSongBtn) {
        this.editSongBtn = editSongBtn;
    }

    public void setGetAddSongBtn(JButton getAddSongBtn) {
        this.getAddSongBtn = getAddSongBtn;
    }

    public void setTxt_get_song_idx(JTextField txt_get_song_idx) {
        this.txt_get_song_idx = txt_get_song_idx;
    }

    public void setTxt_language(JTextField txt_language) {
        this.txt_language = txt_language;
    }

    public void setTxt_media_date(JTextField txt_media_date) {
        this.txt_media_date = txt_media_date;
    }

    public void setTxt_s_duration(JTextField txt_s_duration) {
        this.txt_s_duration = txt_s_duration;
    }

    public void setTxt_media_rating(JTextField txt_media_rating) {
        this.txt_media_rating = txt_media_rating;
    }

    public void setTxt_s_name(JTextField txt_s_name) {
        this.txt_s_name = txt_s_name;
    }
}
