package View.copyright;

import javax.swing.*;
import java.awt.*;

public class ManageCopyrightFrame extends JFrame {
    InitialPanelCopyright ic;
    public ManageCopyrightFrame() {
       super("Manage Copyright Dashboard");
       ic = new InitialPanelCopyright();
       ic.setBackground(Color.DARK_GRAY);
       add(ic);
       pack();
       setSize(500,600);
    }

    public void setIc(InitialPanelCopyright ic) {
        this.ic = ic;
    }

    public InitialPanelCopyright getIc() {
        return ic;
    }
}
