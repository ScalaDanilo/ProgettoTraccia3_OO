package view;
import controller.Controller;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Home implements ActionListener {
    public Controller controler;

    private final JButton tastoLogin;
    private final JButton tastoRegister;
    private final JButton loginReset;
    private final JToggleButton passIcon;
    public static JTextField login;
    private final JPasswordField password;
    private final JFrame Home;
    private final JLabel utenteNonTrovato;
    private JPanel panelHome;

    BufferedImage bufferedImage = ImageIO.read(new File("src/main/resources/Logo.png"));
    Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon sito = new ImageIcon(image);

    BufferedImage bufferedImage2 = ImageIO.read(new File("src/main/resources/university.png"));
    Image image2 = bufferedImage2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon federico = new ImageIcon(image2);

    BufferedImage bufferedImage3 = ImageIO.read(new File("src/main/resources/reset.png"));
    Image image3 = bufferedImage3.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon reset = new ImageIcon(image3);

    BufferedImage bufferedMostra = ImageIO.read(new File("src/main/resources/mostra.png"));
    Image imageMostra = bufferedMostra.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon mostra = new ImageIcon(imageMostra);

    BufferedImage bufferedNascondi = ImageIO.read(new File("src/main/resources/nascondi.png"));
    Image imageNascondi = bufferedNascondi.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon nascondi = new ImageIcon(imageNascondi);

    public Home() throws IOException {
        Home = new JFrame();

        controler = new Controller();

        JLabel logoSito = new JLabel();
        logoSito.setIcon(sito);
        logoSito.setBounds(10,10,200,200);

        JLabel logoFedericoII = new JLabel();
        logoFedericoII.setIcon(federico);
        logoFedericoII.setBounds(570,10,200,200);

        JLabel benvenutoSu = new JLabel();
        benvenutoSu.setText("Benvenuto su");
        benvenutoSu.setBounds(320, -120, 500, 300);
        benvenutoSu.setSize(400, 400);
        benvenutoSu.setFont(new Font("Times",Font.BOLD, 18));

        JLabel discoveryFootball = new JLabel();
        discoveryFootball.setText("Discovery Football");
        discoveryFootball.setBounds(250, -70, 500, 300);
        discoveryFootball.setSize(400, 400);
        discoveryFootball.setFont(new Font("Times",Font.BOLD, 30));

        JLabel inserireCredenziali = new JLabel();
        inserireCredenziali.setText("Inserire le seguenti credenziali");
        inserireCredenziali.setBounds(245, 30, 500, 300);
        inserireCredenziali.setSize(400, 400);
        inserireCredenziali.setFont(new Font("Times",Font.BOLD, 20));

        JLabel emailLabel = new JLabel();
        emailLabel.setText("Nome Utente:");
        emailLabel.setBounds(100, 80, 500, 300);
        emailLabel.setSize(400, 400);
        emailLabel.setFont(new Font("Times",Font.BOLD, 20));

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        passwordLabel.setBounds(100, 140, 500, 300);
        passwordLabel.setSize(400, 400);
        passwordLabel.setFont(new Font("Times",Font.BOLD, 20));

        login = new JTextField("Inserisci il nome utente.");
        login.setBounds(240, 260, 300, 40);
        login.setFont(new Font("Consolas", Font.PLAIN, 20));
        login.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        login.setForeground(Color.LIGHT_GRAY);
        login.addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e) {
                JTexFieldFocusGained(e);
            }
            @Override
            public void focusLost(FocusEvent e) {
                JTexFieldFocusLost(e);
            }
        });

        loginReset = new JButton("", reset);
        loginReset.setBounds(550, 260, 40, 40);
        loginReset.setBackground(Color.GRAY);
        loginReset.addActionListener(this);

        password = new JPasswordField("Inserisci la password.");
        password.setBounds(240, 320, 300, 40);
        password.setFont(new Font("Consolas", Font.PLAIN, 20));
        password.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));
        password.setForeground(Color.LIGHT_GRAY);
        password.setEchoChar((char)0);
        password.addFocusListener(new FocusListener() {
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
        passIcon.setBounds(550, 320, 40, 40);
        passIcon.setBackground(Color.GRAY);
        passIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JToggleButtonMouseClicked(e);
            }
        });

        tastoLogin = new JButton("Accedi");
        tastoLogin.setBounds(240, 390, 140 , 40);
        tastoLogin.addActionListener(this);
        tastoLogin.setBackground(Color.DARK_GRAY);
        tastoLogin.setForeground(Color.LIGHT_GRAY);
        tastoLogin.setBorder(new LineBorder(Color.GRAY, 3, true));

        tastoRegister = new JButton("Registrati");
        tastoRegister.setBounds(400, 390, 140 , 40);
        tastoRegister.addActionListener(this);
        tastoRegister.setBackground(Color.DARK_GRAY);
        tastoRegister.setForeground(Color.LIGHT_GRAY);
        tastoRegister.setBorder(new LineBorder(Color.GRAY, 3, true));

        utenteNonTrovato = new JLabel("<html>"+"Utente"+"<br>"+"Non trovato"+"</html>");
        utenteNonTrovato.setBounds(600, 260, 200, 100);
        utenteNonTrovato.setFont(new Font("Times",Font.BOLD, 18));
        utenteNonTrovato.setForeground(Color.RED);
        utenteNonTrovato.hide();

        Home.add(benvenutoSu);
        Home.add(discoveryFootball);
        Home.add(inserireCredenziali);
        Home.add(emailLabel);
        Home.add(passwordLabel);
        Home.add(tastoLogin);
        Home.add(tastoRegister);
        Home.add(password);
        Home.add(login);
        Home.add(loginReset);
        Home.add(passIcon);
        Home.add(utenteNonTrovato);
        Home.setLayout(null);
        Home.setVisible(true);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setSize(800, 500);
        Home.setResizable(false);
        Home.getContentPane().setBackground(Color.LIGHT_GRAY);
        Home.add(logoSito);
        Home.add(logoFedericoII);
    }

    public void initHome(){Home.setVisible(true);}

    @Override
    public void actionPerformed(ActionEvent e) {
        // Resetting the login text field
        if (e.getSource() == loginReset) login.setText("");

        // Opening the RegisterPage frame
        if(e.getSource() == tastoRegister) {
            Home.setVisible(false);
            try {
                RegisterPage apriRegisterPage = new RegisterPage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        // Logging in and navigating to different frames based on user type
        if(e.getSource() == tastoLogin) {
            String userLogin = login.getText();
            String userPassword = String.copyValueOf(password.getPassword());

            switch (controler.checkUserEPass(userLogin, userPassword)) {
                case 1:
                    Home.setVisible(false);
                    try {
                        HomeAdmin vaiHomeAdmin = new HomeAdmin();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                case 2:
                    Home.setVisible(false);
                    try {
                        HomeUtente vaiHomeUtente = new HomeUtente();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                case -1:
                    utenteNonTrovato.show();
            }

        }
    }

    public void JToggleButtonMouseClicked(java.awt.event.MouseEvent evt){
        if (passIcon.isSelected())
        {
            password.setEchoChar((char)0);
            passIcon.setIcon(nascondi);
        }
        else
        {
            password.setEchoChar('●');
            passIcon.setIcon(mostra);
        }
    }

    private void JTexFieldFocusGained(java.awt.event.FocusEvent evt){
        if (login.getText().equals("Inserisci il nome utente.")){
            login.setText("");
            login.setForeground(Color.DARK_GRAY);
        }
    }

    private void JTexFieldFocusLost(java.awt.event.FocusEvent evt){
        if (login.getText().equals("")){
            login.setText("Inserisci il nome utente.");
            login.setForeground(Color.LIGHT_GRAY);
        }
    }

    private void JPasswordFieldFocusGained(java.awt.event.FocusEvent evt){
        if (password.getText().equals("Inserisci la password.")){
            password.setText("");
            password.setEchoChar('●');
            password.setForeground(Color.DARK_GRAY);
        }
    }

    private void JPasswordFieldFocusLost(java.awt.event.FocusEvent evt){
        if (password.getText().equals("")){
            password.setText("Inserisci la password.");
            password.setEchoChar((char)0);
            password.setForeground(Color.LIGHT_GRAY);
        }
    }
}