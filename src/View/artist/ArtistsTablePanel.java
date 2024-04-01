package View.artist;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//this class creates the buttons required for the table of artists

public class ArtistsTablePanel extends JPanel {
    ArrayList<JButton> artists_buttons = new ArrayList<>();
    public ArtistsTablePanel() {
        super();
    }
    public void createButtons(int number) {
        for(int i = 1; i <= number; i++) {
            JButton b = new JButton();
            b.setBackground(Color.pink);
            b.setSize(500, 50);
            artists_buttons.add(b);
            this.add(b); //this class doesn't contain an 'add' method therefore its parent class (JPanel) must contain this function. Therefore, the artists_buttons are added to the panel one by one in the loop.
            validate();
            repaint();
        }
    }
    public void setButtonText(int button_no, String button_text) {
        artists_buttons.get(button_no).setText(button_text);
    }
    public ArrayList<JButton> getAllButtons() {
        return artists_buttons;
    }
}
