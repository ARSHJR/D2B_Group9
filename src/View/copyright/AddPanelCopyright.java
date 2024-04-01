package View.copyright;

import javax.swing.*;
import java.awt.*;

public class AddPanelCopyright extends JPanel {
    JTextField txt_c_id;
    JTextField txt_s_id;
    JTextField txt_a_id;
    JTextField txt_record_lable;
    JButton addCopyrightBtn;

    public AddPanelCopyright() {
        txt_c_id = new JTextField();
        txt_s_id = new JTextField();
        txt_a_id = new JTextField();
        txt_record_lable = new JTextField();
        addCopyrightBtn = new JButton("Add Copyright");
        addCopyrightBtn.setBackground(Color.decode("#39a78e"));

        txt_c_id.setText("c_id");
        txt_s_id.setText("s_id");
        txt_a_id.setText("a_id");
        txt_record_lable.setText("record_label");

        add(txt_c_id);
        add(txt_s_id);
        add(txt_a_id);
        add(txt_record_lable);
        add(addCopyrightBtn);
    }

    public JTextField getTxt_s_id() {
        return txt_s_id;
    }

    public JTextField getTxt_c_id() {
        return txt_c_id;
    }

    public JTextField getTxt_a_id() {
        return txt_a_id;
    }

    public JTextField getTxt_record_lable() {
        return txt_record_lable;
    }

    public JButton getAddCopyrightBtn() {
        return addCopyrightBtn;
    }

    public void setAddCopyrightBtn(JButton addCopyrightBtn) {
        this.addCopyrightBtn = addCopyrightBtn;
    }

    public void setTxt_s_id(JTextField txt_s_id) {
        this.txt_s_id = txt_s_id;
    }

    public void setTxt_c_id(JTextField txt_c_id) {
        this.txt_c_id = txt_c_id;
    }

    public void setTxt_a_id(JTextField txt_a_id) {
        this.txt_a_id = txt_a_id;
    }

    public void setTxt_record_lable(JTextField txt_record_lable) {
        this.txt_record_lable = txt_record_lable;
    }
}
