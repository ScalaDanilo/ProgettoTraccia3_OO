package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Home{
    BufferedImage bufferedImage1 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Logo1.jpeg"));
    Image image1 = bufferedImage1.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon icon1 = new ImageIcon(image1);
    BufferedImage bufferedImage2 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\university.png"));
    Image image2 = bufferedImage2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon icon2 = new ImageIcon(image2);
    private final JFrame home;
    private JPanel panelHome;
    private JPanel panelLogo;
    private JLabel logo;
    private JLabel f2;
    private JPanel panelF2;


    public Home() throws IOException {
        home = new JFrame("Home");
        home.add(panelHome);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.pack();
        home.setMinimumSize(new Dimension(800,500));
        home.add(logo);
        home.add(f2);
        home.setLayout(null);

        logo.setVerticalAlignment(SwingConstants.TOP);
        logo.setHorizontalAlignment(SwingConstants.LEFT);

        f2.setVerticalAlignment(SwingConstants.TOP);
        f2.setHorizontalAlignment(SwingConstants.RIGHT);

        logo.setIcon(icon1);
        f2.setIcon(icon2);
    }

    public void initHome(){home.setVisible(true);}
}
