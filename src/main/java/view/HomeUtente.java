package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeUtente {
    public JLabel Welcome;
    public JLabel text;
    public JFrame HomeUtente;
    public JPanel TopPanel;
    public JPanel CenterPanel;
    public JPanel DownPanel;
    public JPanel RightPanel;
    public JPanel LeftPanel;
    BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Logo.png"));
    Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon sito = new ImageIcon(image);

    BufferedImage bufferedImage2 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\university.png"));
    Image image2 = bufferedImage2.getScaledInstance(180, 180, Image.SCALE_DEFAULT);
    ImageIcon federico = new ImageIcon(image2);

    public HomeUtente() throws IOException {
        HomeUtente = new JFrame();

        JLabel logoSito = new JLabel();
        logoSito.setIcon(sito);

        JLabel logoFedericoII = new JLabel();
        logoFedericoII.setIcon(federico);

        //PANNELLO SUPERIORE
        Welcome = new JLabel("Benvenuto " + Home.login.getText());
        Welcome.setBounds(220, -120, 300, 300);
        Welcome.setFont(new Font("Times", Font.BOLD, 30));

        text = new JLabel("questa è la tua home personale.");
        text.setBounds(220,-100,300,300);
        text.setFont(new Font("Times", Font.BOLD, 15));

        TopPanel = new JPanel();
        TopPanel.add(Welcome);
        TopPanel.add(text);
        TopPanel.setLayout(null);
        TopPanel.setBounds(0,0,1200,200);
        TopPanel.add(logoSito);
        TopPanel.add(logoFedericoII);
        TopPanel.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.BLACK));


        //PANNELLO CENTRALE
        CenterPanel = new JPanel();
        CenterPanel.setLayout(null);
        CenterPanel.setBounds(200,200,800,400);
        //CenterPanel.setBackground(Color.RED);

        //PANNELLO IN BASSO
        DownPanel = new JPanel();
        DownPanel.setLayout(null);
        DownPanel.setBounds(0,600,1200,200);
        //DownPanel.setBackground(Color.CYAN);
        DownPanel.setBorder(BorderFactory.createMatteBorder(5,0,0,0,Color.BLACK));

        //PANNELLO A DESTRA
        RightPanel = new JPanel();
        RightPanel.setLayout(null);
        RightPanel.setBounds(1000,200,200,400);
        //RightPanel.setBackground(Color.ORANGE);
        RightPanel.setBorder(BorderFactory.createMatteBorder(0,5,0,0,Color.BLACK));

        //PANNELLO A SINISTRA
        LeftPanel = new JPanel();
        LeftPanel.setLayout(null);
        LeftPanel.setBounds(0,200,200,400);
        //LeftPanel.setBackground(Color.ORANGE);
        LeftPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,5,Color.BLACK));

        //HOME
        HomeUtente.add(TopPanel, BorderLayout.NORTH);
        HomeUtente.add(CenterPanel, BorderLayout.CENTER);
        HomeUtente.add(DownPanel, BorderLayout.SOUTH);
        HomeUtente.add(RightPanel, BorderLayout.EAST);
        HomeUtente.add(LeftPanel, BorderLayout.WEST);
        HomeUtente.setLayout(null);
        HomeUtente.setVisible(true);
        HomeUtente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomeUtente.setSize(1200, 800);
        HomeUtente.setResizable(false);

        logoSito.setBounds(0,0,200,200);
        logoSito.setBorder(BorderFactory.createMatteBorder(0,0,0,5,Color.BLACK));
        logoFedericoII.setBounds(1000,0,200,200);
        logoFedericoII.setBorder(BorderFactory.createMatteBorder(0,5,0,0,Color.BLACK));
    }
}
