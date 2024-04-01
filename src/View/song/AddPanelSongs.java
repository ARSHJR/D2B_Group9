package View.song;
import javax.swing.*;
import java.awt.*;

public class AddPanelSongs extends JPanel {
    JTextField txt_song_id;
    JTextField txt_language;
    JTextField txt_song_name;
    JTextField txt_song_duration;
    JTextField txt_media_rating;
    JTextField txt_media_date;
    JButton addSongBtn;


    public AddPanelSongs() {
        txt_song_id = new JTextField();
        txt_language = new JTextField();
        txt_song_name = new JTextField();
        txt_song_duration = new JTextField();
        txt_media_rating = new JTextField();
        txt_media_date = new JTextField();
        addSongBtn = new JButton("Add Song");
        addSongBtn.setBackground(Color.decode("#39a78e"));

        txt_song_id.setText("ID");
        txt_language.setText("Language");
        txt_song_name.setText("Name");
        txt_song_duration.setText("Duration");
        txt_media_rating.setText("Media rating");
        txt_media_date.setText("Media date");

        add(txt_song_id);
        add(txt_language);
        add(txt_song_name);
        add(txt_song_duration);
        add(txt_media_rating);
        add(txt_media_date);
        add(addSongBtn);
    }

    public JTextField getTxt_song_id() {
        return txt_song_id;
    }

    public JTextField getTxt_media_date() {
        return txt_media_date;
    }

    public JTextField getTxt_media_rating() {
        return txt_media_rating;
    }

    public JTextField getTxt_song_duration() {
        return txt_song_duration;
    }

    public JButton getAddSongBtn() {
        return addSongBtn;
    }

    public JTextField getTxt_song_name() {
        return txt_song_name;
    }

    public JTextField getTxt_language() {
        return txt_language;
    }

    public void setTxt_song_name(JTextField txt_song_name) {
        this.txt_song_name = txt_song_name;
    }

    public void setTxt_song_duration(JTextField txt_song_duration) {
        this.txt_song_duration = txt_song_duration;
    }

    public void setTxt_media_rating(JTextField txt_media_rating) {
        this.txt_media_rating = txt_media_rating;
    }

    public void setTxt_song_id(JTextField txt_song_id) {
        this.txt_song_id = txt_song_id;
    }

    public void setAddSongBtn(JButton addSongBtn) {
        this.addSongBtn = addSongBtn;
    }

    public void setTxt_media_date(JTextField txt_media_date) {
        this.txt_media_date = txt_media_date;
    }

    public void setTxt_language(JTextField txt_language) {
        this.txt_language = txt_language;
    }
}
