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

/**
 * The `RegisterPage` class represents a graphical user interface for user registration.
 * It includes input fields for username and password, with additional features like
 * password visibility toggling and error message displays.
 *
 */
public class RegisterPage implements ActionListener {

    /**
     * The `JFrame` instance representing the registration frame.
     */
    JFrame frameReg;

    /**
     * The label for the email input field.
     */
    JLabel emailLabel;

    /**
     * The label for the password input field.
     */
    JTextField emailTextField;

    /**
     * The password input field for entering the password.
     */
    JLabel passwordLabel;

    /**
     * The password input field for entering the password.
     */
    JPasswordField passwordField;

    /**
     * The label for confirming the password.
     */
    JLabel ripetiPasswordLabel;

    /**
     * The password input field for confirming the password.
     */
    JPasswordField ripetiPasswordField;

    /**
     * The button for confirming the registration.
     */
    JButton confermaRegistrazione;

    /**
     * The button for resetting the email input field.
     */
    JButton resetEmail;

    /**
     * The toggle button for password visibility.
     */
    JToggleButton passIcon;

    /**
     * The second toggle button for password visibility.
     */
    JToggleButton passIcon2;

    /**
     * The label indicating that the entered passwords do not match.
     */
    JLabel passNonCoincide;

    /**
     * The label indicating that the user already exists.
     */
    JLabel utenteEsiste;

    /**
     * The label indicating that the username cannot be empty.
     */
    JLabel utenteVuoto;

    /**
     * The controller for handling registration logic.
     */
    Controller controller;

    /**
     * Buffered image for the reset button.
     */
    BufferedImage bufferedImage3 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\reset.png"));

    /**
     * The scaled image for the reset button.
     */
    Image image3 = bufferedImage3.getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    /**
     * The `ImageIcon` for the reset button.
     */
    ImageIcon reset = new ImageIcon(image3);

    /**
     * Buffered image for the show password button.
     */
    BufferedImage bufferedMostra = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\mostra.png"));

    /**
     * The scaled image for the show password button.
     */
    Image imageMostra = bufferedMostra.getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    /**
     * The `ImageIcon` for the show password button.
     */
    ImageIcon mostra = new ImageIcon(imageMostra);

    /**
     * Buffered image for the hide password button.
     */
    BufferedImage bufferedNascondi = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\nascondi.png"));

    /**
     * The scaled image for the hide password button.
     */
    Image imageNascondi = bufferedNascondi.getScaledInstance(30, 30, Image.SCALE_DEFAULT);

    /**
     * The `ImageIcon` for the hide password button.
     */
    ImageIcon nascondi = new ImageIcon(imageNascondi);

    /**
     * Constructs a new instance of the RegisterPage class.
     * Initializes the graphical user interface (GUI) components for user registration.
     * The constructor sets up the JFrame, labels, text fields, buttons, and other UI elements.
     * It also configures the appearance, positioning, and event listeners for these components.
     * The constructor instantiates a Controller for handling registration logic.
     *
     * @throws IOException If an error occurs while reading image files.
     */
    public RegisterPage() throws IOException {
        // Initialize the main JFrame for user registration.
        frameReg = new JFrame();

        // Instantiate the Controller for handling registration logic.
        controller = new Controller();

        // Set up UI components for email input.
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

        // Set up UI components for password input.
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

        // Set up UI components for confirming the password.
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

        // Set up the "Registrati" button and its appearance.
        confermaRegistrazione = new JButton();
        confermaRegistrazione.setBounds(245, 240, 200, 40);
        confermaRegistrazione.setText("Registrati");
        confermaRegistrazione.setBackground(Color.DARK_GRAY);
        confermaRegistrazione.setForeground(Color.LIGHT_GRAY);
        confermaRegistrazione.addActionListener(this);

        // Set up labels for error messages.
        passNonCoincide = new JLabel("Le due password non coincidono.");
        passNonCoincide.setBounds(200,260,400,100);
        passNonCoincide.setFont(new Font("Times",Font.BOLD, 18));
        passNonCoincide.setForeground(Color.RED);
        passNonCoincide.hide();

        utenteEsiste = new JLabel("L'utente già esiste.");
        utenteEsiste.setBounds(260,260,400,100);
        utenteEsiste.setFont(new Font("Times",Font.BOLD, 18));
        utenteEsiste.setForeground(Color.RED);
        utenteEsiste.hide();

        utenteVuoto = new JLabel("Non puoi registrarti con i campi vuoti.");
        utenteVuoto.setBounds(185,260,400,100);
        utenteVuoto.setFont(new Font("Times",Font.BOLD, 18));
        utenteVuoto.setForeground(Color.RED);
        utenteVuoto.hide();

        // Add UI components to the main JFrame and configure its appearance.
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

    /**
     * Handles action events triggered by user interactions with the graphical user interface.
     * This method is part of the ActionListener interface and is invoked when specific
     * registered components, such as buttons, are interacted with.
     *
     * @param e The ActionEvent representing the user's action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check if the action event is associated with the resetEmail button.
        if(e.getSource() == resetEmail) {
            // Clear the content of the emailTextField.
            emailTextField.setText("");
        }

        // Check if the action event is associated with the confermaRegistrazione button.
        if(e.getSource() == confermaRegistrazione) {
            // Retrieve the user input for login, password, and repeated password.
            String userLogin = emailTextField.getText();
            String userPassword = String.copyValueOf(passwordField.getPassword());
            String userPasswordRepeat = String.copyValueOf(ripetiPasswordField.getPassword());

            // Check if any of the input fields is in its default placeholder state.
            if (userLogin.equals("Inserisci il nome utente.") || userPassword.equals("Inserisci la password.") || userPasswordRepeat.equals("Inserisci la password.")) {
                // Display an error message for empty fields.
                utenteVuoto.show();
                utenteEsiste.hide();
                passNonCoincide.hide();
            } else {
                // Check if the entered passwords match.
                if (userPassword.equals(userPasswordRepeat)) {
                    try {
                        // Attempt to insert the user into the database using the Controller.
                        controller.insertUser(userLogin, userPassword);

                        // Close the registration frame and open the home page.
                        frameReg.dispose();
                        Home ritornaAllaHome = new Home();
                    } catch (SQLIntegrityConstraintViolationException ex) {
                        // Display an error message if the user already exists in the database.
                        utenteVuoto.hide();
                        utenteEsiste.show();
                        passNonCoincide.hide();
                    } catch (Exception ex) {
                        // Throw a runtime exception if an unexpected error occurs.
                        throw new RuntimeException(ex);
                    }
                } else {
                    // Display an error message if the passwords do not match.
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

