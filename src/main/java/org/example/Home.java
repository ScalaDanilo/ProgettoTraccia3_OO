package org.example;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Home implements ActionListener {
    private final JButton tastoLogin;
    private final JButton tastoRegister;
    private final JButton loginReset;
    private final JToggleButton passReset;
    private final JTextField login;
    private final JPasswordField password;
    private final JFrame Home;
    private JPanel panelHome;

    BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Logo.png"));
    Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon sito = new ImageIcon(image);

    BufferedImage bufferedImage2 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\university.png"));
    Image image2 = bufferedImage2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon federico = new ImageIcon(image2);

    BufferedImage bufferedImage3 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\reset.png"));
    Image image3 = bufferedImage3.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon reset = new ImageIcon(image3);

    BufferedImage bufferedMostra = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\mostra.png"));
    Image imageMostra = bufferedMostra.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon mostra = new ImageIcon(imageMostra);

    BufferedImage bufferedNascondi = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\nascondi.png"));
    Image imageNascondi = bufferedNascondi.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
    ImageIcon nascondi = new ImageIcon(imageNascondi);

    public Home() throws IOException {
        
        Home = new JFrame();

        JLabel logoSito = new JLabel();
        logoSito.setIcon(sito);

        JLabel logoFedericoII = new JLabel();
        logoFedericoII.setIcon(federico);

        //SCRITTA BENVENUTO
        JLabel benvenutoSu = new JLabel();
        benvenutoSu.setText("Benvenuto su");
        benvenutoSu.setBounds(290, -120, 500, 300);
        benvenutoSu.setSize(400, 400);
        benvenutoSu.setFont(new Font("Times",Font.BOLD, 30));

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
        emailLabel.setText("Email:");
        emailLabel.setBounds(100, 80, 500, 300);
        emailLabel.setSize(400, 400);
        emailLabel.setFont(new Font("Times",Font.BOLD, 20));

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Password:");
        passwordLabel.setBounds(100, 140, 500, 300);
        passwordLabel.setSize(400, 400);
        passwordLabel.setFont(new Font("Times",Font.BOLD, 20));



        //EMAIL
        login = new JTextField();
        login.setBounds(240, 260, 300, 40);
        login.setFont(new Font("Consolas", Font.PLAIN, 20));
        login.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));



        loginReset = new JButton("", reset);
        loginReset.setBounds(550, 260, 40, 40);
        loginReset.setBackground(Color.GRAY);
        loginReset.addActionListener(this);

        //PASSWORD
        password = new javax.swing.JPasswordField();
        password.setBounds(240, 320, 300, 40);
        password.setFont(new Font("Consolas", Font.PLAIN, 20));
        password.setBorder(new LineBorder(Color.DARK_GRAY, 2, true));

        passReset = new JToggleButton("", mostra);
        passReset.setBounds(550, 320, 40, 40);
        passReset.setBackground(Color.GRAY);
        passReset.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JToggleButtonMouseClicked(e);
            }
        });

        //BUTTON
        tastoLogin = new JButton("Login");
        tastoLogin.setBounds(240, 390, 140 , 40);
        tastoLogin.addActionListener(this);
        tastoLogin.setBackground(Color.DARK_GRAY);
        tastoLogin.setForeground(Color.LIGHT_GRAY);
        tastoLogin.setBorder(new LineBorder(Color.GRAY, 3, true));

        tastoRegister = new JButton("Register");
        tastoRegister.setBounds(400, 390, 140 , 40);
        tastoRegister.addActionListener(this);
        tastoRegister.setBackground(Color.DARK_GRAY);
        tastoRegister.setForeground(Color.LIGHT_GRAY);
        tastoRegister.setBorder(new LineBorder(Color.GRAY, 3, true));


        //FRAME
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
        Home.add(passReset);
        Home.setLayout(null);
        Home.setVisible(true);
        Home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Home.setSize(800, 500);
        Home.setResizable(false);
        Home.getContentPane().setBackground(Color.LIGHT_GRAY);

        Home.add(logoSito);
        Home.add(logoFedericoII);
        logoSito.setBounds(10,10,200,200);
        logoFedericoII.setBounds(570,10,200,200);
    }

    public void initHome(){Home.setVisible(true);}
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == loginReset) login.setText("");

        if(e.getSource() == tastoRegister) {
            Home.setVisible(false);
            RegisterPage apriRegisterPage = new RegisterPage();
        }

        if(e.getSource() == tastoLogin) {
            String userLogin = login.getText();
            String userPassword = String.copyValueOf(password.getPassword());

            Home.setVisible(false);
            if(userLogin.equals("1") && userPassword.equals("1"))
            {
                Home.setVisible(false);
                try {
                    HomeAdmin vaiHomeAdmin = new HomeAdmin();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            else
            {
                Home.setVisible(false);
                HomeUtente vaiHomeUtente = new HomeUtente();
            }
        }
    }

    public void JToggleButtonMouseClicked(java.awt.event.MouseEvent evt){
        if (passReset.isSelected())
        {
            password.setEchoChar((char)0);
            passReset.setIcon(nascondi);
        }
        else
        {
            password.setEchoChar('●');
            passReset.setIcon(mostra);
        }
    }
}