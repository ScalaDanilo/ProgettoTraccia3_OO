package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Home{
    BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Logo1.jpeg"));
    Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon icon = new ImageIcon(image);
    private final JFrame home;
    private JPanel panelHome;
    private JPanel panelLogo;
    private JLabel label1;

    public Home() throws IOException {
        home = new JFrame("Home");
        home.add(panelHome);
        home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        home.pack();
        home.setMinimumSize(new Dimension(800,500));
        home.setLayout(null);
        panelLogo.setSize(600,600);
        panelLogo.setBounds(0,0,600,600);

        label1.setIcon(icon);
    }

    public void initHome(){home.setVisible(true);}
}
