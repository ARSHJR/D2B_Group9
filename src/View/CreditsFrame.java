package View;

import javax.swing.*;
import java.awt.*;

public class CreditsFrame extends JFrame {
    JPanel Credits;
    JLabel credits;
    JPanel names;
    JPanel rjtg;
    JLabel richard;
    ScrollText s = new ScrollText("Aarush Satpute(46) | Nidhish Shirur(49) | Nihal Sinha(51) | Priyanka Ochaney(40)");
    public CreditsFrame() {
        super("Credits");

        setLayout(new BorderLayout());

        Credits = new JPanel();
        credits = new JLabel("Credits");
        credits.setFont(new Font("Arial", Font.BOLD, 60));
        Credits.setBackground(Color.gray);
        Credits.add(credits, BorderLayout.CENTER);

        names = new JPanel();
        names.setBackground(Color.DARK_GRAY);
        names.add(s);

        rjtg = new JPanel();
        richard = new JLabel("*And also, Richard Joseph Sir the Great!");
        richard.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
        rjtg.add(richard);

        add(Credits, BorderLayout.NORTH);
        add(names, BorderLayout.CENTER);
        add(rjtg, BorderLayout.SOUTH);

        setSize(500, 500);
    }
}
