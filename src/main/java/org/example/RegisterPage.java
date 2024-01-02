package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class RegisterPage implements ActionListener {

    JFrame frameReg= new JFrame();
    JLabel emailLabel = new JLabel();
    JTextField emailTextField = new JTextField();
    JLabel passwordLabel = new JLabel();
    JPasswordField passwordField = new JPasswordField();
    JLabel ripetiPasswordLabel = new JLabel();
    JPasswordField ripetiPasswordField = new JPasswordField();
    JButton confermaRegistrazione = new JButton();
    JButton resetEmail = new JButton();
    JButton resetPass  = new JButton();
    JButton resetPass2 = new JButton();

    public RegisterPage() {

        //email
        emailLabel.setBounds(40, 40, 200, 40);
        emailLabel.setText("Inserire email:");
        emailLabel.setFont(new Font("Consolas", Font.PLAIN, 17));

        emailTextField.setBounds(220, 40, 250, 40);
        emailTextField.setFont(new Font("Consolas", Font.PLAIN, 18));

        resetEmail.setBounds(500, 40, 100, 40);
        resetEmail.setText("Reset");
        resetEmail.setBackground(Color.LIGHT_GRAY);
        resetEmail.addActionListener(this);

        //password1
        passwordLabel.setBounds(40, 100, 200, 40);
        passwordLabel.setText("Inserire password:");
        passwordLabel.setFont(new Font("Consolas", Font.PLAIN, 17));

        passwordField.setBounds(220, 100, 250, 40);
        passwordField.setFont(new Font("Consolas", Font.PLAIN, 18));

        resetPass.setBounds(500, 100, 100, 40);
        resetPass.setText("Reset");
        resetPass.setBackground(Color.LIGHT_GRAY);
        resetPass.addActionListener(this);

        //password2
        ripetiPasswordLabel.setBounds(40, 160, 200, 40);
        ripetiPasswordLabel.setText("Conferma password:");
        ripetiPasswordLabel.setFont(new Font("Consolas", Font.PLAIN, 17));

        ripetiPasswordField.setBounds(220, 160, 250, 40);
        ripetiPasswordField.setFont(new Font("Consolas", Font.PLAIN, 17));

        resetPass2.setBounds(500, 160, 100, 40);
        resetPass2.setText("Reset");
        resetPass2.setBackground(Color.LIGHT_GRAY);
        resetPass2.addActionListener(this);

        //Tasto ConfermaRegistrazione
        confermaRegistrazione.setBounds(245, 240, 200, 40);
        confermaRegistrazione.setText("Registrati");
        confermaRegistrazione.setBackground(Color.DARK_GRAY);
        confermaRegistrazione.setForeground(Color.LIGHT_GRAY);
        confermaRegistrazione.addActionListener(this);


        //
        frameReg.add(emailLabel);
        frameReg.add(emailTextField);
        frameReg.add(resetEmail);
        frameReg.add(passwordLabel);
        frameReg.add(passwordField);
        frameReg.add(resetPass);
        frameReg.add(ripetiPasswordLabel);
        frameReg.add(ripetiPasswordField);
        frameReg.add(resetPass2);
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
        if(e.getSource() == resetPass) passwordField.setText("");
        if(e.getSource() == resetPass2) ripetiPasswordField.setText("");

        if(e.getSource() == confermaRegistrazione) {
            try {
                frameReg.setVisible(false);
                Home ritornaAllaHome = new Home();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}

