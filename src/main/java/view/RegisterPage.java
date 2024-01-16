package view;
import view.Home;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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

        //email
        emailLabel = new JLabel();
        emailLabel.setText("Inserire email:");
        emailLabel.setBounds(40, 40, 200, 40);
        emailLabel.setFont(new Font("Times",Font.BOLD, 20));

        emailTextField = new JTextField();
        emailTextField.setBounds(250, 40, 250, 40);
        emailTextField.setFont(new Font("Consolas",Font.PLAIN, 18));
        emailTextField.setBorder(new LineBorder(Color.DARK_GRAY, 3, true));
        emailTextField.setForeground(Color.LIGHT_GRAY);
        emailTextField.setText("Enter the email.");
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
        passwordField.setText("Enter the password.");
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
        ripetiPasswordField.setText("Repeat the password.");
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
                JToggleButtonMouseClicked(e);
            }
        });

        //Tasto ConfermaRegistrazione
        confermaRegistrazione = new JButton();
        confermaRegistrazione.setBounds(245, 240, 200, 40);
        confermaRegistrazione.setText("Registrati");
        confermaRegistrazione.setBackground(Color.DARK_GRAY);
        confermaRegistrazione.setForeground(Color.LIGHT_GRAY);
        confermaRegistrazione.addActionListener(this);


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
            try {
                frameReg.setVisible(false);
                Home ritornaAllaHome = new Home();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
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

    private void JTexFieldFocusGained(java.awt.event.FocusEvent evt){
        if (emailTextField.getText().equals("Enter the email.")){
            emailTextField.setText("");
            emailTextField.setForeground(Color.DARK_GRAY);
        }
    }

    private void JTexFieldFocusLost(java.awt.event.FocusEvent evt){
        if (emailTextField.getText().equals("")){
            emailTextField.setText("Enter the email.");
            emailTextField.setForeground(Color.LIGHT_GRAY);
        }
    }

    private void JPasswordFieldFocusGained(java.awt.event.FocusEvent evt){
        if (passwordField.getText().equals("Enter the password.")){
            passwordField.setText("");
            passwordField.setEchoChar('●');
            passwordField.setForeground(Color.DARK_GRAY);
        }
    }

    private void JPasswordFieldFocusLost(java.awt.event.FocusEvent evt){
        if (passwordField.getText().equals("")){
            passwordField.setText("Enter the password.");
            passwordField.setEchoChar((char)0);
            passwordField.setForeground(Color.LIGHT_GRAY);
        }
    }

    private void JPasswordFieldFocusGained2(java.awt.event.FocusEvent evt){
        if (ripetiPasswordField.getText().equals("Repeat the password.")){
            ripetiPasswordField.setText("");
            ripetiPasswordField.setEchoChar('●');
            ripetiPasswordField.setForeground(Color.DARK_GRAY);
        }
    }

    private void JPasswordFieldFocusLost2(java.awt.event.FocusEvent evt){
        if (ripetiPasswordField.getText().equals("")){
            ripetiPasswordField.setText("Repeat the password.");
            ripetiPasswordField.setEchoChar((char)0);
            ripetiPasswordField.setForeground(Color.LIGHT_GRAY);
        }
    }
}

