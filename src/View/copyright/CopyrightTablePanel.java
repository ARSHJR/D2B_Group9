package View.copyright;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CopyrightTablePanel extends JPanel {
    ArrayList<JButton> copyright_buttons = new ArrayList<>();

    public CopyrightTablePanel() {
        super();
    }
    public void createButtons(int count) {
        for(int i = 1; i<=count; i++) {
            JButton b = new JButton();
            b.setBackground(Color.pink);
            b.setSize(500, 500);
            copyright_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
    }

    public ArrayList<JButton> getButtons() {
        return copyright_buttons;
    }
    public void setButtonText(int button_no, String button_text) {
        copyright_buttons.get(button_no).setText(button_text);
    }
}
