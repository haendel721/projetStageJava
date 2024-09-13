package View;
import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

import Controller.*;
import org.mindrot.jbcrypt.BCrypt;

public class Login extends JFrame {
    private JPanel loginPage;
    public JTextField champMail;
    private JButton seConnecterButton;
    private JLabel ErrorMessage;
    public JPasswordField passwordField1;
    private JLabel idText;
    private JLabel MdpText;
    private JLabel textBienv;
    private JLabel textBienv2;
    private JLabel ErrorMailMessage;
    private JLabel NexisteError;
    private JLabel NexisteError2;
    final int longMotPasse = 8;
    public void Login(){
        setContentPane(loginPage);
        setSize(700, 550);
        setLocation(250, 100);
        setVisible(true);
        setResizable(false);
        ErrorMessage.setVisible(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(Login.class.getResource("/icone/utilisateur8.png"));
        setIconImage(icon.getImage());
        champMail.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
        idText.setBorder(new UnderlineBorder());
        MdpText.setBorder(new UnderlineBorder());
        textBienv.setBorder(new MarginBorder(5,5,0,5));
        textBienv2.setBorder(new MarginBorder(0,5,5,5));
        seConnecterButton.setEnabled(false);
        seConnecterButton.setBackground(Color.GRAY);
        NexisteError.setVisible(false);
        NexisteError2.setVisible(false);
        seConnecterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                affiche();
            }
        });
        champMail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                champMail.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
                ErrorMessage.setVisible(false);
                NexisteError.setVisible(false);
                NexisteError2.setVisible(false);
            }
        });
        passwordField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                passwordField1.setBorder(BorderFactory.createLineBorder(Color.cyan, 2));
                ErrorMessage.setVisible(false);
                NexisteError.setVisible(false);
                NexisteError2.setVisible(false);
            }
        });
        champMail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                champMail.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        });
        passwordField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                passwordField1.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
            }
        });
        champMail.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verifivation();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                verifivation();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                verifivation();
            }
        });
        passwordField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verifivation();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
                verifivation();
            }
            @Override
            public void changedUpdate(DocumentEvent e) {
                verifivation();
            }
        });
    }
    static class UnderlineBorder extends AbstractBorder  {
        private final Color underlineColor = Color.GRAY;
        private final int thickness = 1;
        @Override
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            g.setColor(underlineColor);
            g.fillRect(x, y + height - thickness, width, thickness);
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(0, 0, thickness, 0);
        }
    }
    static class MarginBorder extends AbstractBorder {
        private final Insets insets;
        public MarginBorder(int top, int left, int bottom, int right) {
            this.insets = new Insets(top, left, bottom, right);
        }
        @Override
        public Insets getBorderInsets(Component c) {
            return insets;
        }
    }
    private void affiche(){
            RequeteLogin rq = new RequeteLogin();
            if(rq.iscompteExiste(champMail.getText())){
                if(BCrypt.checkpw(passwordField1.getText(),rq.requteToDb(champMail.getText()))){
                    Site st = new Site();
                    st.site();
                    this.dispose();
//                RecevoirLog recu = new RecevoirLog();
//                recu.recevoir(mail,motPasse);
                }else {
                    ErrorMessage.setVisible(true);
                }
            }else {
                NexisteError.setVisible(true);
                NexisteError2.setVisible(true);
            }
        }

    private void verifivation(){
        if(champMail.getText().endsWith("@gmail.com") || champMail.getText().endsWith("@yahoo.com") || (champMail.getText().endsWith("@outlook.com")) ){
            ErrorMailMessage.setVisible(false);
            String motPasse = passwordField1.getText();
            if((motPasse.length() >= longMotPasse)){
                seConnecterButton.setEnabled(true);
                seConnecterButton.setBackground(Color.CYAN);
            }else {
                seConnecterButton.setEnabled(false);
                seConnecterButton.setBackground(Color.GRAY);
            }
        }else {
            ErrorMailMessage.setVisible(true);
            seConnecterButton.setEnabled(false);
            seConnecterButton.setBackground(Color.GRAY);
        }
    }
}