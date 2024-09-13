package View;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import java.util.EventObject;
import Controller.*;
public class Site extends JFrame {
    public JPanel site;
    private JButton confirmerButton;
    private JButton precedentButton;
    private JButton button1;
    private JTable listeSite;
    public void site(){
        setContentPane(site);
        setSize(700, 550);
        setLocation(250, 100);
        setVisible(true);
        setResizable(false);
        confirmerButton.setEnabled(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
//        ImageIcon icon = new ImageIcon("/icone/utilisateur8.png");
        ImageIcon icon = new ImageIcon(Site.class.getResource("../icone/utilisateur8.png"));
        setIconImage(icon.getImage());
        listeSite.setRowHeight(60);
        precedentButton.setBackground(Color.GREEN);
        listeSite.setDefaultEditor(Object.class, new DefaultCellEditor(new JTextField()) {
            @Override
            public boolean isCellEditable(EventObject  anEvent) {
                return false;
            }
        });
        rempliTableau();
        precedentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                precedent();
            }
        });
        listeSite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int selectionner =listeSite.getSelectedRow();
                if(selectionner==-1){
                    confirmerButton.setEnabled(false);
                    confirmerButton.setBackground(Color.GRAY);
                }else {
                    confirmerButton.setEnabled(true);
                    confirmerButton.setBackground(Color.CYAN);
                    confirmerButton.setForeground(Color.white);
                }
                System.out.println(recuperlign());
            }
        });
        confirmerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ToSiteWeb();
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                help();
            }
        });
    }
    private void help(){
         JOptionPane.showMessageDialog(this,"Veuillez choisir un site sur cette liste \nen cliquant sur le nom du site de\n votre choix.","Aide",JOptionPane.INFORMATION_MESSAGE);
    }
    private void precedent(){
        int oui = JOptionPane.showConfirmDialog(this,"Voulez-vous vraiment retourner \nvers la page d'authentification","Information", JOptionPane.OK_CANCEL_OPTION);
        if(oui == JOptionPane.YES_OPTION){
            new Login();
            this.dispose();
        }
    }
    private String recuperlign(){
        int selectionner =listeSite.getSelectedRow();
        DefaultTableModel model =(DefaultTableModel) listeSite.getModel();
        String siteSelect =(String) model.getValueAt(selectionner,1);
        return siteSelect;
    }
    private void ToSiteWeb() {
        switch (recuperlign()) {
            case "Facebook":
                RempliLogFb remplirfb = new RempliLogFb();
                remplirfb.rempli("rakotonirinaclaudius@gmail.com", "Claudius1305xxlfb001safidy2");
                break;
            case "Whatsapp":
                RempliLogWapp remplirwapp =  new RempliLogWapp();
                remplirwapp.remplir();
                break;
            case "Linkedin":
                RempliLogLin remplirlin = new RempliLogLin();
                remplirlin.rempli("rakotonirinaclaudius@gmail.com","aucun compte Linkedin");
                break;
            case "Instagram":
                RempliLogInstagram remplirInst = new RempliLogInstagram();
                remplirInst.remplir("rakotonirinaclaudius@gmail.com","aucun compte Linkedin");
                break;
//            case "Twitter":
//                RempliTwitter rempliTwitter = new RempliTwitter();
//                rempliTwitter.rempli("rakotonirinaclaudius@gmail.com","aucun compte Linkedin");
//                break;
        }
    }
    private void rempliTableau(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("icone");
        model.addColumn("Site Disponible pour votre compte :");
        listeSite.setModel(model);
        ImageIcon icon1 = new ImageIcon(Site.class.getResource("../icone/facebook20.png"));
        ImageIcon icon2 = new ImageIcon(Site.class.getResource("../icone/whatsapp20.png"));
        ImageIcon icon3 = new ImageIcon(Site.class.getResource("../icone/linkedin20.png"));
        ImageIcon icon4 = new ImageIcon(Site.class.getResource("../icone/instagram10.png"));
//        ImageIcon icon5 = new ImageIcon(Site.class.getResource("../icone/twitter11.png"));
        model.addRow(new Object[]{icon1,"Facebook"});
        model.addRow(new Object[]{icon2,"Whatsapp"});
        model.addRow(new Object[]{icon3,"Linkedin"});
        model.addRow(new Object[]{icon4,"Instagram"});
//        model.addRow(new Object[]{icon5,"Twitter"});

        TableCellRenderer iconRenderer = new DefaultTableCellRenderer() {
            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value instanceof Icon) {
                    setIcon((Icon) value);
                } else {
                    setIcon(null);
                }
                return this;
            }
        };
        listeSite.getColumnModel().getColumn(0).setCellRenderer(iconRenderer);
        JTableHeader header = listeSite.getTableHeader();
        header.setPreferredSize(new Dimension(0, 0));
        header.setVisible(false);
    }
}