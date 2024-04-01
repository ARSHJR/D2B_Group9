package View;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class FirstFrame extends JFrame {
    JButton manageArtistsBtn;
    JButton manageSongsBtn;
    JButton manageCopyrightsBtn;
    JPanel mainPanel;
    JPanel toppanel;
    JLabel welcomemessage;
    JButton waste1;
    JButton waste2;
    JButton waste3;
    JButton waste4;
    JButton waste5;
    JButton waste6;
    JPanel leftPanel;
    JPanel rightPanel;
    JPanel creditsPanel;
    JButton creditsBtn;

    FirstFrame() {
        super("Main Menu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        toppanel = new JPanel();
        toppanel.setBackground(Color.DARK_GRAY);
        welcomemessage = new JLabel("Welcome to HarmonyHub: Music Management Database!");
        welcomemessage.setForeground(Color.white);
        welcomemessage.setFont(new Font("Arial", Font.BOLD, 50));

        toppanel.add(welcomemessage, BorderLayout.CENTER);

        mainPanel = new JPanel();
        manageArtistsBtn = new JButton();
        manageSongsBtn = new JButton();
        manageCopyrightsBtn = new JButton();

        manageArtistsBtn = displaybutton("Artists");
        manageSongsBtn = displaybutton("Songs");
        manageCopyrightsBtn = displaybutton("Copyrights");

        waste1 = new JButton();
        waste1.setVisible(false);
        waste2 = new JButton();
        waste2.setVisible(false);
        waste3 = new JButton();
        waste3.setVisible(false);
        waste4 = new JButton();
        waste4.setVisible(false);
        waste5 = new JButton();
        waste5.setVisible(false);
        waste6 = new JButton();
        waste6.setVisible(false);

        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setLayout(new GridLayout(3, 3, 20, 0));
        mainPanel.add(waste1);
        mainPanel.add(waste2);
        mainPanel.add(waste3);
        mainPanel.add(manageArtistsBtn);
        mainPanel.add(manageSongsBtn);
        mainPanel.add(manageCopyrightsBtn);
        mainPanel.add(waste4);
        mainPanel.add(waste5);
        mainPanel.add(waste6);

        leftPanel = new JPanel();
        leftPanel.setBackground(Color.DARK_GRAY);
        rightPanel = new JPanel();
        rightPanel.setBackground(Color.DARK_GRAY);
        rightPanel.setSize(new Dimension(50, 50));

        creditsPanel = new JPanel();
        creditsPanel.setBackground(Color.DARK_GRAY);
        creditsPanel.setLayout(new BorderLayout());
        creditsBtn = new JButton("Credits");
        creditsBtn.setBackground(Color.WHITE);
        creditsBtn.setSize(25, 25);
        creditsPanel.add(creditsBtn, BorderLayout.EAST);

        add(toppanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
        add(leftPanel, BorderLayout.WEST);
        add(rightPanel, BorderLayout.EAST);
        add(creditsPanel, BorderLayout.SOUTH);

        pack();
        setSize(500, 600);
        setVisible(true);
    }

    public JButton displaybutton (String text) {
        JButton b = new JButton(text);
        b.setBackground(Color.gray);
        b.setForeground(Color.white);
        b.setBorder(new LineBorder(Color.BLACK));
        b.setPreferredSize(new Dimension(50, 70));

        return b;
    }

    public void setFirstPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setManageArtistsBtn(JButton manageArtistsBtn) {
        this.manageArtistsBtn = manageArtistsBtn;
    }

    public void setManageSongsBtn(JButton manageSongsBtn) {
        this.manageSongsBtn = manageSongsBtn;
    }

    public void setManageCopyrightsBtn(JButton manageCopyrightsBtn) {
        this.manageCopyrightsBtn = manageCopyrightsBtn;
    }

    public JPanel getFirstPanel() {
        return mainPanel;
    }

    public JButton getManageArtistsBtn() {
        return manageArtistsBtn;
    }

    public JButton getManageSongsBtn() {
        return manageSongsBtn;
    }

    public JButton getManageCopyrightsBtn() {
        return manageCopyrightsBtn;
    }

    public JButton getCreditsBtn() {
        return creditsBtn;
    }
}
