package View.copyright;

import javax.swing.JPanel;
import java.awt.*;

public class InitialPanelCopyright extends JPanel {
    private CopyrightTablePanel ctp;
    private AddPanelCopyright apc;
    private EditCopyrightPanel ecp;
    private DeleteCopyrightPanel dcp;

    public void setEcp(EditCopyrightPanel ecp) {
        this.ecp = ecp;
    }

    public EditCopyrightPanel getEcp() {
        return ecp;
    }

    public void setDcp(DeleteCopyrightPanel dcp) {
        this.dcp = dcp;
    }

    public DeleteCopyrightPanel getDcp() {
        return dcp;
    }

    public void setCtp(CopyrightTablePanel ctp) {
        this.ctp = ctp;
    }

    public CopyrightTablePanel getCtp() {
        return ctp;
    }

    public void setApc(AddPanelCopyright apc) {
        this.apc = apc;
    }

    public AddPanelCopyright getApc() {
        return apc;
    }

    public InitialPanelCopyright() {
        super();
        ctp = new CopyrightTablePanel();
        ctp.setBackground(Color.gray);
        add(ctp);
        apc = new AddPanelCopyright();
        apc.setBackground(Color.gray);
        add(apc);
        ecp = new EditCopyrightPanel();
        ecp.setBackground(Color.gray);
        add(ecp);
        dcp = new DeleteCopyrightPanel();
        dcp.setBackground(Color.gray);
        add(dcp);
    }


}
