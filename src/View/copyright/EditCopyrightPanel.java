package View.copyright;
import javax.swing.*;
import java.awt.*;

public class EditCopyrightPanel extends JPanel{
    JTextField txt_get_c_idx;
    JButton getCopyrightBtn;
    JTextField txt_copyright_id;
    JTextField txt_song_id;
    JTextField txt_artist_id;
    JTextField txt_record_lable;
    JButton editCopyrightBtn;

    public EditCopyrightPanel() {
        txt_copyright_id = new JTextField();
        txt_song_id = new JTextField();
        txt_artist_id = new JTextField();
        txt_record_lable = new JTextField();

        txt_get_c_idx = new JTextField();
        editCopyrightBtn = new JButton("Edit Copyright");
        editCopyrightBtn.setBackground(Color.decode("#39a78e"));
        getCopyrightBtn = new JButton("Get Copyright to Edit");
        getCopyrightBtn.setBackground(Color.decode("#9aff9a"));

        txt_copyright_id.setText("Copyright_id");
        txt_song_id.setText("Song_id");
        txt_artist_id.setText("Artist_id");
        txt_record_lable.setText("Record_label");
        txt_get_c_idx.setText("get copyright idx");

        txt_copyright_id.setEditable(false);
        txt_song_id.setEditable(false);

        add(txt_get_c_idx);
        add(getCopyrightBtn);

        add(txt_copyright_id);
        add(txt_song_id);
        add(txt_artist_id);
        add(txt_record_lable);
        add(editCopyrightBtn);
    }

    public JTextField getTxt_copyright_id() {
        return txt_copyright_id;
    }

    public JTextField getTxt_record_lable() {
        return txt_record_lable;
    }

    public JButton getEditCopyrightBtn() {
        return editCopyrightBtn;
    }

    public JButton getGetCopyrightBtn() {
        return getCopyrightBtn;
    }

    public JTextField getTxt_artist_id() {
        return txt_artist_id;
    }

    public JTextField getTxt_get_c_idx() {
        return txt_get_c_idx;
    }

    public JTextField getTxt_song_id() {
        return txt_song_id;
    }

    public void setTxt_record_lable(JTextField txt_record_lable) {
        this.txt_record_lable = txt_record_lable;
    }

    public void setEditCopyrightBtn(JButton editCopyrightBtn) {
        this.editCopyrightBtn = editCopyrightBtn;
    }

    public void setGetCopyrightBtn(JButton getCopyrightBtn) {
        this.getCopyrightBtn = getCopyrightBtn;
    }

    public void setTxt_artist_id(JTextField txt_artist_id) {
        this.txt_artist_id = txt_artist_id;
    }

    public void setTxt_copyright_id(JTextField txt_copyright_id) {
        this.txt_copyright_id = txt_copyright_id;
    }

    public void setTxt_get_c_idx(JTextField txt_get_c_idx) {
        this.txt_get_c_idx = txt_get_c_idx;
    }

    public void setTxt_song_id(JTextField txt_song_id) {
        this.txt_song_id = txt_song_id;
    }

}
