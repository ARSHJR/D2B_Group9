package View.song;
import jdk.internal.icu.impl.CharacterIteratorWrapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class SongTablePanel extends JPanel  {
    public Object getAddSongBtn;
    ArrayList<JButton> songs_buttons = new ArrayList<>();
    public SongTablePanel() {super();}
    public void createButtons(int count) {
        for(int i=1; i<=count; i++) {
            JButton b = new JButton();
            b.setBackground(Color.pink);
            b.setSize(500,50);
            songs_buttons.add(b);
            this.add(b);
            validate();
            repaint();
        }
    }

    public ArrayList<JButton> getSongs_buttons() {
        return songs_buttons;
    }
    public void setButtonText(int button_no, String button_text) {
        songs_buttons.get(button_no).setText(button_text);
    }



}
