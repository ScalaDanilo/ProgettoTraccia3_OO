package org.example;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeAdmin implements ActionListener{
    JFrame frameAdmin = new JFrame();
    JButton modifica = new JButton();
    JButton inserisci = new JButton("Inserisci");
    JComboBox step1Inserisci;
    JComboBox step2Inserisci;
    JComboBox step1Modifica;
    JButton annulla = new JButton("Annulla");

    public HomeAdmin() throws IOException {

        //Carico stemmi laterali
        BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Logo.png"));
        Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon sito = new ImageIcon(image);

        BufferedImage bufferedImage2 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\university.png"));
        Image image2 = bufferedImage2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon federico = new ImageIcon(image2);

        JLabel logoSito = new JLabel();
        logoSito.setIcon(sito);
        logoSito.setBounds(10,10,200,200);

        JLabel logoFedericoII = new JLabel();
        logoFedericoII.setIcon(federico);
        logoFedericoII.setBounds(770,10,200,200);

        //Tasto inserisci

        inserisci.setBounds(200, 100, 250, 50);
        inserisci.addActionListener(this);

        //Tasto Modificia


        modifica.setBounds(550, 100, 250, 50);
        modifica.addActionListener(this);

        //Tasto Annulla

        annulla.setBounds(375, 650, 250, 50);
        annulla.addActionListener(this);

        //step1 Inserisci
        String[] opzStep1Insert = {"Inserisci Giocatore", "Inserisci Competizione", "Inserisci Sponsor secondari", "Inserisci Squadra"};
        step1Inserisci = new JComboBox(opzStep1Insert);
        step1Inserisci.setVisible(false);
        step1Inserisci.setBounds(375, 250, 250, 50);

















        frameAdmin.add(logoSito);
        frameAdmin.add(logoFedericoII);
        frameAdmin.add(step1Inserisci);
        frameAdmin.add(inserisci);
        frameAdmin.add(modifica);
        frameAdmin.add(annulla);
        /*frameAdmin.add();
        frameAdmin.add();
        frameAdmin.add();
        frameAdmin.add();
        frameAdmin.add();
        frameAdmin.add();
        frameAdmin.add();
        frameAdmin.add();*/
        frameAdmin.setLayout(null);
        frameAdmin.setVisible(true);
        frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdmin.setSize(1000, 800);
        frameAdmin.setResizable(false);
        frameAdmin.getContentPane().setBackground(Color.LIGHT_GRAY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==inserisci) {
            inserisci.setEnabled(false);
            modifica.setEnabled(false);
            step1Inserisci.setVisible(true);
        }
        else
        {
            inserisci.setEnabled(false);
            modifica.setEnabled(false);
            step1Modifica.setVisible(true);
        }

        if(e.getSource()==annulla) {
            inserisci.setEnabled(true);
            modifica.setEnabled(true);
            step1Inserisci.setVisible(false);
            step1Modifica.setVisible(false);
        }
    }
}

