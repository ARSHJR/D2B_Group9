package View.copyright;
import javax.swing.*;
import java.awt.*;

public class DeleteCopyrightPanel extends JPanel{

    JTextField txt_del_c_id;
    JButton deleteCopyrightBtn;

    public DeleteCopyrightPanel() {
        txt_del_c_id = new JTextField();
        deleteCopyrightBtn = new JButton();

        txt_del_c_id.setText("c_id");
        deleteCopyrightBtn.setText("Delete Copyright");
        deleteCopyrightBtn.setBackground(Color.decode("#39a78e"));

        add(txt_del_c_id);
        add(deleteCopyrightBtn);
    }

    public JButton getDeleteCopyrightBtn() {
        return deleteCopyrightBtn;
    }

    public JTextField getTxt_del_c_id() {
        return txt_del_c_id;
    }

    public void setDeleteCopyrightBtn(JButton deleteCopyrightBtn) {
        this.deleteCopyrightBtn = deleteCopyrightBtn;
    }

    public void setTxt_del_c_id(JTextField txt_del_c_id) {
        this.txt_del_c_id = txt_del_c_id;
    }
}
