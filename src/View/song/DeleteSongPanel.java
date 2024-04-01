package View.song;

import javax.swing.*;
import java.awt.*;

public class DeleteSongPanel extends JPanel {

    JTextField txt_del_s_id;
    JButton deleteSongBtn;

    public DeleteSongPanel() {
        txt_del_s_id = new JTextField();
        deleteSongBtn = new JButton();

        txt_del_s_id.setText("ID");
        deleteSongBtn.setText("Delete Song");
        deleteSongBtn.setBackground(Color.decode("#39a78e"));

        add(txt_del_s_id);
        add(deleteSongBtn);
    }

    public JButton getDeleteSongBtn() {
        return deleteSongBtn;
    }

    public JTextField getTxt_del_s_id() {
        return txt_del_s_id;
    }

    public void setDeleteSongBtn(JButton deleteSongBtn) {
        this.deleteSongBtn = deleteSongBtn;
    }

    public void setTxt_del_s_id(JTextField txt_del_s_id) {
        this.txt_del_s_id = txt_del_s_id;
    }
}
