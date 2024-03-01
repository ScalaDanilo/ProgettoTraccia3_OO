package view;
import controller.Controller;
import view.Home;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

public class RegisterPage implements ActionListener {

    JFrame frameReg;
    JLabel emailLabel;
    JTextField emailTextField;
    JLabel passwordLabel;
    JPasswordField passwordField;
    JLabel ripetiPasswordLabel;
    JPasswordField ripetiPasswordField;
    JButton confermaRegistrazione;
    JButton resetEmail;
    JToggleButton passIcon;
    JToggleButton passIcon2;
    JLabel passNonCoincide;
    JLabel utenteEsiste;
    JLabel utenteVuoto;
    Controller controller;

    BufferedImage bufferedImage3 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\reset.png"));
    Image image3 = bufferedImage3.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon reset = new ImageIcon(image3);

    BufferedImage bufferedMostra = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\mostra.png"));
    Image imageMostra = bufferedMostra.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon mostra = new ImageIcon(imageMostra);

    BufferedImage bufferedNascondi = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\nascondi.png"));
    Image imageNascondi = bufferedNascondi.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon nascondi = new ImageIcon(imageNascondi);

    public RegisterPage() throws IOException {

        frameReg = new JFrame();

        controller = new Controller();

        //email
        emailLabel = new JLabel();
        emailLabel.setText("Inserire username:");
        emailLabel.setBounds(40, 40, 200, 40);
        emailLabel.setFont(new Font("Times",Font.BOLD, 20));

        emailTextField = new JTextField();
        emailTextField.setBounds(250, 40, 250, 40);
        emailTextField.setFont(new Font("Consolas",Font.PLAIN, 18));
        emailTextField.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
        emailTextField.setForeground(Color.LIGHT_GRAY);
        emailTextField.setText("Inserisci l'username.");
        emailTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTexFieldFocusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTexFieldFocusLost(e);
            }
        });

        resetEmail = new JButton("", reset);
        resetEmail.setBounds(510, 40, 40, 40);
        resetEmail.setBackground(Color.GRAY);
        resetEmail.addActionListener(this);

        //password1
        passwordLabel = new JLabel();
        passwordLabel.setBounds(40, 100, 200, 40);
        passwordLabel.setText("Inserire password:");
        passwordLabel.setFont(new Font("Times",Font.BOLD, 20));

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 100, 250, 40);
        passwordField.setFont(new Font("Consolas", Font.PLAIN, 18));
        passwordField.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
        passwordField.setForeground(Color.LIGHT_GRAY);
        passwordField.setEchoChar((char)0);
        passwordField.setText("Inserisci la password.");
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JPasswordFieldFocusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                JPasswordFieldFocusLost(e);
            }
        });

        passIcon = new JToggleButton("", mostra);
        passIcon.setBounds(510, 100, 40, 40);
        passIcon.setBackground(Color.GRAY);
        passIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JToggleButtonMouseClicked(e);
            }
        });

        //password2
        ripetiPasswordLabel = new JLabel();
        ripetiPasswordLabel.setBounds(40, 160, 200, 40);
        ripetiPasswordLabel.setText("Conferma password:");
        ripetiPasswordLabel.setFont(new Font("Times",Font.BOLD, 20));

        ripetiPasswordField = new JPasswordField();
        ripetiPasswordField.setBounds(250, 160, 250, 40);
        ripetiPasswordField.setFont(new Font("Consolas", Font.PLAIN, 18));
        ripetiPasswordField.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
        ripetiPasswordField.setForeground(Color.LIGHT_GRAY);
        ripetiPasswordField.setEchoChar((char)0);
        ripetiPasswordField.setText("Ripeti la password.");
        ripetiPasswordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JPasswordFieldFocusGained2(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                JPasswordFieldFocusLost2(e);
            }
        });

        passIcon2  = new JToggleButton("", mostra);
        passIcon2.setBounds(510, 160, 40, 40);
        passIcon2.setBackground(Color.GRAY);
        passIcon2.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JToggleButtonMouseClicked2(e);
            }
        });

        //Tasto ConfermaRegistrazione
        confermaRegistrazione = new JButton();
        confermaRegistrazione.setBounds(245, 240, 200, 40);
        confermaRegistrazione.setText("Registrati");
        confermaRegistrazione.setBackground(Color.DARK_GRAY);
        confermaRegistrazione.setForeground(Color.LIGHT_GRAY);
        confermaRegistrazione.addActionListener(this);

        //LABEL PER LE DUE PASSWORD CHE NON COINCIDONO
        passNonCoincide = new JLabel("Le due password non coincidono.");
        passNonCoincide.setBounds(200,260,400,100);
        passNonCoincide.setFont(new Font("Times",Font.BOLD, 18));
        passNonCoincide.setForeground(Color.RED);
        passNonCoincide.hide();

        //UTENTE GIA' ESISTENTE
        utenteEsiste = new JLabel("L'utente già esiste.");
        utenteEsiste.setBounds(260,260,400,100);
        utenteEsiste.setFont(new Font("Times",Font.BOLD, 18));
        utenteEsiste.setForeground(Color.RED);
        utenteEsiste.hide();

        //USERNAME VUOTO
        utenteVuoto = new JLabel("Non puoi registrarti con i campi vuoti.");
        utenteVuoto.setBounds(185,260,400,100);
        utenteVuoto.setFont(new Font("Times",Font.BOLD, 18));
        utenteVuoto.setForeground(Color.RED);
        utenteVuoto.hide();

        //FRAME REGISTRAZIONE
        frameReg.add(emailLabel);
        frameReg.add(emailTextField);
        frameReg.add(resetEmail);
        frameReg.add(passwordLabel);
        frameReg.add(passwordField);
        frameReg.add(passIcon);
        frameReg.add(ripetiPasswordLabel);
        frameReg.add(ripetiPasswordField);
        frameReg.add(passIcon2);
        frameReg.add(confermaRegistrazione);
        frameReg.add(passNonCoincide);
        frameReg.add(utenteEsiste);
        frameReg.add(utenteVuoto);
        frameReg.setLayout(null);
        frameReg.setVisible(true);
        frameReg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameReg.setSize(700, 400);
        frameReg.setResizable(false);
        frameReg.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == resetEmail) emailTextField.setText("");

        if(e.getSource() == confermaRegistrazione) {
            String userLogin = emailTextField.getText();
            String userPassword = String.copyValueOf(passwordField.getPassword());
            String userPasswordRepeat = String.copyValueOf(ripetiPasswordField.getPassword());
            
            if (userLogin.equals("Inserisci il nome utente.") || userPassword.equals("Inserisci la password.") || userPasswordRepeat.equals("Inserisci la password."))
            {
                utenteVuoto.show();
                utenteEsiste.hide();
                passNonCoincide.hide();
            } else {
                if (userPassword.equals(userPasswordRepeat)){
                    try {
                        controller.insertUser(userLogin, userPassword);

                        frameReg.dispose();
                        Home ritornaAllaHome = new Home();
                    } /*catch (SQLIntegrityConstraintViolationException ex){
                        utenteVuoto.hide();
                        utenteEsiste.show();
                        passNonCoincide.hide();
                    }
                    */
                    catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else
                {
                    utenteVuoto.hide();
                    utenteEsiste.hide();
                    passNonCoincide.show();
                }
            }
        }
    }

    public void JToggleButtonMouseClicked(java.awt.event.MouseEvent evt){
        if (passIcon.isSelected())
        {
            passwordField.setEchoChar((char)0);
            passIcon.setIcon(nascondi);
        }
        else
        {
            passwordField.setEchoChar('●');
            passIcon.setIcon(mostra);
        }
    }

    public void JToggleButtonMouseClicked2(java.awt.event.MouseEvent evt){
        if (passIcon2.isSelected())
        {
            ripetiPasswordField.setEchoChar((char)0);
            passIcon2.setIcon(nascondi);
        }
        else
        {
            ripetiPasswordField.setEchoChar('●');
            passIcon2.setIcon(mostra);
        }
    }

    private void JTexFieldFocusGained(java.awt.event.FocusEvent evt){
        if (emailTextField.getText().equals("Inserisci l'username.")){
            emailTextField.setText("");
            emailTextField.setForeground(Color.DARK_GRAY);
        }
    }

    private void JTexFieldFocusLost(java.awt.event.FocusEvent evt){
        if (emailTextField.getText().equals("")){
            emailTextField.setText("Inserisci l'username.");
            emailTextField.setForeground(Color.LIGHT_GRAY);
        }
    }

    private void JPasswordFieldFocusGained(java.awt.event.FocusEvent evt){
        if (passwordField.getText().equals("Inserisci la password.")){
            passwordField.setText("");
            passwordField.setEchoChar('●');
            passwordField.setForeground(Color.DARK_GRAY);
        }
    }

    private void JPasswordFieldFocusLost(java.awt.event.FocusEvent evt){
        if (passwordField.getText().equals("")){
            passwordField.setText("Inserisci la password.");
            passwordField.setEchoChar((char)0);
            passwordField.setForeground(Color.LIGHT_GRAY);
        }
    }

    private void JPasswordFieldFocusGained2(java.awt.event.FocusEvent evt){
        if (ripetiPasswordField.getText().equals("Ripeti la password.")){
            ripetiPasswordField.setText("");
            ripetiPasswordField.setEchoChar('●');
            ripetiPasswordField.setForeground(Color.DARK_GRAY);
        }
    }

    private void JPasswordFieldFocusLost2(java.awt.event.FocusEvent evt){
        if (ripetiPasswordField.getText().equals("")){
            ripetiPasswordField.setText("Ripeti la password.");
            ripetiPasswordField.setEchoChar((char)0);
            ripetiPasswordField.setForeground(Color.LIGHT_GRAY);
        }
    }
}

