package view;

import controller.Controller;
import model.Calciatori;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class HomeUtente implements ActionListener{
    public Controller controller;
    public JLabel Welcome;
    public JLabel text;
    public JComboBox scelta;
    public String[] scelte;
    public String selezione;
    public JTextField ricerca;
    public JButton ricercaButton;
    public JFrame HomeUtente;
    public JPanel TopPanel;
    public JPanel CentralPanel;
    public JPanel DownPanel;
    public JPanel RightPanel;
    public JPanel LeftPanel;
    public JLabel defaultLabel;
    public JLabel topLabel;
    public JPanel defaultPanel;
    public JPanel NamePanel;
    public JPanel EtaPanel;
    public JPanel GoalSubitiPanel;
    public JPanel GoalSegnatiPanel;
    public JPanel RuoloPanel;
    public JPanel PiedePRPanel;
    public JPanel SquadraPanel;
    public JPanel debugPanel;
    public JTable Table;
    public JScrollPane TableScrollPane;
    public JTable TopTable;
    public JScrollPane TopTableScrollPane;
    BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Logo.png"));
    Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
    ImageIcon sito = new ImageIcon(image);
    BufferedImage bufferedImageBackground = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Sfondo.jpg"));
    Image imageBackground = bufferedImageBackground.getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
    ImageIcon sitoBackground = new ImageIcon(imageBackground);
    BufferedImage bufferedImage2 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\university.png"));
    Image image2 = bufferedImage2.getScaledInstance(180, 180, Image.SCALE_DEFAULT);
    ImageIcon federico = new ImageIcon(image2);
    BufferedImage bufferedImage3 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\ricerca.png"));
    Image image3 = bufferedImage3.getScaledInstance(40, 40, Image.SCALE_DEFAULT);
    ImageIcon ricercaIcon = new ImageIcon(image3);
    BufferedImage bufferedImageLeft = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Immagine1.jpg"));
    Image imageLeft = bufferedImageLeft.getScaledInstance(195, 400, Image.SCALE_DEFAULT);
    ImageIcon leftIcon = new ImageIcon(imageLeft);
    BufferedImage bufferedImageRight = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Immagine2.jpg"));
    Image imageRight = bufferedImageRight.getScaledInstance(180, 400, Image.SCALE_DEFAULT);
    ImageIcon rightIcon = new ImageIcon(imageRight);

    public HomeUtente() throws IOException {
        HomeUtente = new JFrame();

        controller = new Controller();

        JLabel logoSito = new JLabel();
        logoSito.setIcon(sito);
        logoSito.setBounds(0,0,200,200);
        logoSito.setBorder(BorderFactory.createMatteBorder(0,0,0,5,Color.BLACK));

        JLabel logoFedericoII = new JLabel();
        logoFedericoII.setIcon(federico);
        logoFedericoII.setBounds(1000,0,200,200);
        logoFedericoII.setBorder(BorderFactory.createMatteBorder(0,5,0,0,Color.BLACK));

        JLabel immagineBackground = new JLabel();
        immagineBackground.setIcon(sitoBackground);

        JLabel rightImage = new JLabel();
        rightImage.setIcon(rightIcon);
        rightImage.setBounds(5,0,180,400);

        JLabel leftImage = new JLabel();
        leftImage.setIcon(leftIcon);
        leftImage.setBounds(0,0,195,400);

        scelte = new String[]{"Nome", "Ruolo", "Piede", "Goal segnati", "Goal subiti", "Età", "Squadra"};

        //PANNELLO SUPERIORE

        //TASTO DI RICERCA
        ricercaButton = new JButton("", ricercaIcon);
        ricercaButton.setBounds(930,120,50,50);
        ricercaButton.setContentAreaFilled(false);
        //ricercaButton.setBorderPainted(false);
        ricercaButton.setBorder(BorderFactory.createMatteBorder(1,0,1,2,Color.BLACK));
        ricercaButton.addActionListener(this);

        ricerca = new JTextField("Cerca il giocatore per...");
        ricerca.setBounds(630, 120,300, 50);
        ricerca.setFont(new Font("Consolas", Font.PLAIN, 15));
        ricerca.setForeground(Color.LIGHT_GRAY);
        ricerca.setBorder(BorderFactory.createMatteBorder(1,0,1,0,Color.BLACK));
        ricerca.disable();
        ricerca.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JTexFieldFocusGained(e);
            }

            @Override
            public void focusLost(FocusEvent e) {
                JTexFieldFocusLost(e);
            }
        });

        //SCELTA DELLA RICERCA
        scelta = new JComboBox<String>();
        for (String str: scelte) {
            scelta.addItem(str);
        }
        scelta.setSelectedItem(scelte);
        scelta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Questo metodo verrà chiamato ogni volta che la scelta della JComboBox cambia
                JComboBox<String> source = (JComboBox<String>) e.getSource();
                selezione = (String) source.getSelectedItem();
                ricerca.setText(selezione != null ? "Cerca il giocatore per..." + selezione : "");
                ricerca.setForeground(Color.LIGHT_GRAY);
                ricerca.enable();
            }
        });
        scelta.setBounds(500,120,130,50);
        scelta.setSelectedItem(0);
        scelta.setFont(new Font("Consolas", Font.PLAIN, 15));
        scelta.setBorder(BorderFactory.createMatteBorder(1,1,1,0,Color.BLACK));
        scelta.setBackground(Color.WHITE);

        //SCRITTA WELCOME
        Welcome = new JLabel();
        Welcome.setText("Benvenuto " + Home.login.getText());

        Welcome.setBounds(220, -120, 300, 300);
        Welcome.setFont(new Font("Times", Font.BOLD, 30));

        text = new JLabel("questa è la tua home personale.");
        text.setBounds(220,-100,300,300);
        text.setFont(new Font("Times", Font.BOLD, 15));

        //MODIFICHE E AGGIUNTE DEI COMPONENTI AL PANNELLO SUPERIORE
        TopPanel = new JPanel();
        TopPanel.add(Welcome);
        TopPanel.add(text);
        TopPanel.add(ricerca);
        TopPanel.add(scelta);
        TopPanel.setLayout(null);
        TopPanel.setBounds(0,0,1200,200);
        TopPanel.add(logoSito);
        TopPanel.add(logoFedericoII);
        TopPanel.add(ricercaButton);
        TopPanel.setBorder(BorderFactory.createMatteBorder(0,0,5,0,Color.BLACK));

        //PANNELLO CENTRALE

        //SCRITTA PANNELLO CENTRALE DEFAULT
        defaultLabel = new JLabel("Nessuna ricerca eseguita.");
        defaultLabel.setBounds(50,100,650,200);
        defaultLabel.setFont(new Font("Times", Font.BOLD, 40));
        defaultLabel.setForeground(Color.LIGHT_GRAY);

        //PANNELLO CENTRALE DEFAULT
        defaultPanel = new JPanel();
        Color transparentColorDefault = new Color(defaultPanel.getBackground().getRed(),
                defaultPanel.getBackground().getGreen(),
                defaultPanel.getBackground().getBlue(),
                0);
        defaultPanel.setBackground(transparentColorDefault);
        defaultPanel.setLayout(null);
        defaultPanel.setBounds(100,50,600,350);
        defaultPanel.setBorder(null);
        defaultPanel.add(defaultLabel);

        //PANNELLO CENTRALE RICERCA PER NOME
        NamePanel = new JPanel();
        Color transparentColorName = new Color(NamePanel.getBackground().getRed(),
                NamePanel.getBackground().getGreen(),
                NamePanel.getBackground().getBlue(),
                0);
        NamePanel.setBackground(transparentColorName);
        NamePanel.setLayout(null);
        NamePanel.setBorder(null);
        NamePanel.setBounds(100,50,600,350);
        NamePanel.hide();

        //PANNELLO CENTRALE RICERCA PER RUOLO
        RuoloPanel = new JPanel();
        Color transparentColorRuolo = new Color(RuoloPanel.getBackground().getRed(),
                RuoloPanel.getBackground().getGreen(),
                RuoloPanel.getBackground().getBlue(),
                0);
        RuoloPanel.setBackground(transparentColorRuolo);
        RuoloPanel.setLayout(null);
        RuoloPanel.setBounds(100,50,600,350);
        RuoloPanel.setBorder(null);
        RuoloPanel.hide();

        //PANNELLO CENTRALE RICERCA PER PIEDE PREFERITO
        PiedePRPanel = new JPanel();
        Color transparentColorPiede = new Color(PiedePRPanel.getBackground().getRed(),
                PiedePRPanel.getBackground().getGreen(),
                PiedePRPanel.getBackground().getBlue(),
                0);
        PiedePRPanel.setBackground(transparentColorPiede);
        PiedePRPanel.setLayout(null);
        PiedePRPanel.setBounds(100,50,600,350);
        PiedePRPanel.setBorder(null);
        PiedePRPanel.hide();

        //PANNELLO CENTRALE RICERCA PER GOAL SEGNATI
        GoalSegnatiPanel = new JPanel();
        Color transparentColorGoalSe = new Color(GoalSegnatiPanel.getBackground().getRed(),
                GoalSegnatiPanel.getBackground().getGreen(),
                GoalSegnatiPanel.getBackground().getBlue(),
                0);
        GoalSegnatiPanel.setBackground(transparentColorGoalSe);
        GoalSegnatiPanel.setLayout(null);
        GoalSegnatiPanel.setBounds(100,50,600,350);
        GoalSegnatiPanel.setBorder(null);
        GoalSegnatiPanel.hide();

        //PANNELLO CENTRALE RICERCA PER GOAL SUBITI
        GoalSubitiPanel = new JPanel();
        Color transparentColorGoalSu = new Color(GoalSubitiPanel.getBackground().getRed(),
                GoalSubitiPanel.getBackground().getGreen(),
                GoalSubitiPanel.getBackground().getBlue(),
                0);
        GoalSubitiPanel.setBackground(transparentColorGoalSu);
        GoalSubitiPanel.setLayout(null);
        GoalSubitiPanel.setBounds(100,50,600,350);
        GoalSubitiPanel.setBorder(null);
        GoalSubitiPanel.hide();

        //PANNELLO CENTRALE RICERCA PER ETA'
        EtaPanel = new JPanel();
        Color transparentColorEta = new Color(EtaPanel.getBackground().getRed(),
                EtaPanel.getBackground().getGreen(),
                EtaPanel.getBackground().getBlue(),
                0);
        EtaPanel.setBackground(transparentColorEta);
        EtaPanel.setLayout(null);
        EtaPanel.setBounds(100,50,600,350);
        EtaPanel.setBorder(null);
        EtaPanel.hide();

        //PANNELLO CENTRALE RICERCA PER SQUADRA
        SquadraPanel = new JPanel();
        Color transparentColorSquadra = new Color(SquadraPanel.getBackground().getRed(),
                SquadraPanel.getBackground().getGreen(),
                SquadraPanel.getBackground().getBlue(),
                0);
        SquadraPanel.setBackground(transparentColorSquadra);
        SquadraPanel.setLayout(null);
        SquadraPanel.setBounds(100,50,600,350);
        SquadraPanel.setBorder(null);
        SquadraPanel.hide();

        //PANNELLO UTILIZZATO PER EVITARE PROBLEMI
        debugPanel = new JPanel();
        debugPanel.hide();

        //PANNELLO CENTRALE
        CentralPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sitoBackground.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        CentralPanel.setBounds(200,200,800,400);
        CentralPanel.setLayout(new BorderLayout());
        CentralPanel.add(immagineBackground);
        CentralPanel.add(defaultPanel);
        CentralPanel.add(NamePanel);
        CentralPanel.add(PiedePRPanel);
        CentralPanel.add(RuoloPanel);
        CentralPanel.add(GoalSegnatiPanel);
        CentralPanel.add(GoalSubitiPanel);
        CentralPanel.add(EtaPanel);
        CentralPanel.add(SquadraPanel);
        CentralPanel.add(debugPanel);

        //LABEL DELLA TOP
        topLabel = new JLabel("Top 10 giocatori con più goal segnati: ");
        topLabel.setBounds(50,20,400,50);
        topLabel.setFont(new Font("Times", Font.BOLD, 20));

        //TABELLA DELLA TOP
        String[] TopTableTitles = {"1° Posto", "2° Posto", "3° Posto", "4° Posto", "5° Posto", "6° Posto", "7° Posto", "8° Posto", "9° Posto", "10° Posto"};

        TopTable = new JTable();
        TopTable.setColumnSelectionAllowed(false);
        TopTable.getTableHeader().setReorderingAllowed(false);
        TopTable.disable();
        DefaultTableModel uneditableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        // Imposta il nuovo modello sulla tabella
        TopTable.setModel(uneditableModel);
        TopTableScrollPane = new JScrollPane(TopTable);
        TopTableScrollPane.setBounds(20,70,1140,39);
        DefaultTableModel model = (DefaultTableModel) TopTable.getModel();

        model.setColumnIdentifiers(TopTableTitles);

        model.addRow(controller.TopBottomPanel());

        //PANNELLO IN BASSO
        DownPanel = new JPanel();
        DownPanel.setLayout(null);
        DownPanel.setBounds(0,600,1200,200);
        //DownPanel.setBackground(Color.CYAN);
        DownPanel.setBorder(BorderFactory.createMatteBorder(5,0,0,0,Color.BLACK));
        DownPanel.add(topLabel);
        DownPanel.add(TopTableScrollPane);

        //PANNELLO A DESTRA
        RightPanel = new JPanel();
        RightPanel.setLayout(null);
        RightPanel.setBounds(1000,200,200,400);
        RightPanel.add(rightImage);
        //RightPanel.setBackground(Color.ORANGE);
        RightPanel.setBorder(BorderFactory.createMatteBorder(0,5,0,0,Color.BLACK));

        //PANNELLO A SINISTRA
        LeftPanel = new JPanel();
        LeftPanel.setLayout(null);
        LeftPanel.setBounds(0,200,200,400);
        LeftPanel.add(leftImage);
        //LeftPanel.setBackground(Color.ORANGE);
        LeftPanel.setBorder(BorderFactory.createMatteBorder(0,0,0,5,Color.BLACK));

        //HOME
        HomeUtente.add(TopPanel, BorderLayout.NORTH);
        HomeUtente.add(CentralPanel, BorderLayout.CENTER);
        HomeUtente.add(DownPanel, BorderLayout.SOUTH);
        HomeUtente.add(RightPanel, BorderLayout.EAST);
        HomeUtente.add(LeftPanel, BorderLayout.WEST);
        HomeUtente.setLayout(null);
        HomeUtente.setVisible(true);
        HomeUtente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        HomeUtente.setSize(1200, 800);
        HomeUtente.setResizable(false);
    }

    private void JTexFieldFocusGained(FocusEvent evt){
        if (ricerca.getText().equals("Cerca il giocatore per..." + selezione)){
            ricerca.setText("");
            ricerca.setForeground(Color.DARK_GRAY);
        }
    }

    private void JTexFieldFocusLost(FocusEvent evt){
        if (ricerca.getText().equals("")){
            ricerca.setText("Cerca il giocatore per..." + selezione);
            ricerca.setForeground(Color.LIGHT_GRAY);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<Calciatori> calciatori;
        if (selezione.equals("Nome")) {
            if (!ricerca.getText().equals("Cerca il giocatore per..." + selezione))
            {
                defaultPanel.hide();
                NamePanel.show();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();

                String[] TableTitles = {"Nome", "Cognome", "Data di Nascita", "Piede Preferito", "Data Ritiro", "Nazionalità", "Valore Mercato"};

                Table = new JTable();
                Table.setColumnSelectionAllowed(false);
                Table.getTableHeader().setReorderingAllowed(false);
                Table.disable();
                DefaultTableModel uneditableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                // Imposta il nuovo modello sulla tabella
                Table.setModel(uneditableModel);
                Table.setShowGrid(false);
                Table.setBorder(null);
                TableScrollPane = new JScrollPane(Table);
                TableScrollPane.getViewport().setOpaque(false);
                TableScrollPane.setOpaque(false);
                TableScrollPane.setViewportBorder(null);
                TableScrollPane.setBorder(null);
                TableScrollPane.setBounds(0,0,600,350);
                DefaultTableModel model = (DefaultTableModel) Table.getModel();

                model.setColumnIdentifiers(TableTitles);
                calciatori = controller.visualizzaCalciatori(ricerca.getText());
                for (Calciatori calc : calciatori)
                {
                    String[] row = {calc.Nome, calc.Cognome, calc.DataNascita, calc.PiedePreferito, calc.DataRitiro, calc.Nazionalita, String.valueOf(calc.ValoreMercato)};
                    model.addRow(row);
                }
                NamePanel.removeAll();


                NamePanel.add(TableScrollPane, BorderLayout.CENTER);
            } else {
                defaultPanel.show();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();
            }
        } else if (selezione.equals("Ruolo")) {
            if (!ricerca.getText().equals("Cerca il giocatore per..." + selezione))
            {
                defaultPanel.hide();
                NamePanel.hide();
                RuoloPanel.show();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();


                String[] RuoloTableTitles = {"Nome", "Cognome", "Data di Nascita", "Piede Preferito", "Nazionalità", "Ruolo"};

                Table = new JTable();
                Table.setColumnSelectionAllowed(false);
                Table.getTableHeader().setReorderingAllowed(false);
                Table.disable();
                DefaultTableModel uneditableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                // Imposta il nuovo modello sulla tabella
                Table.setModel(uneditableModel);
                Table.setShowGrid(false);
                Table.setBorder(null);
                TableScrollPane = new JScrollPane(Table);
                TableScrollPane.getViewport().setOpaque(false);
                TableScrollPane.setOpaque(false);
                TableScrollPane.setViewportBorder(null);
                TableScrollPane.setBorder(null);
                TableScrollPane.setBounds(0,0,600,350);
                DefaultTableModel model = (DefaultTableModel) Table.getModel();

                model.setColumnIdentifiers(RuoloTableTitles);
                for (String calc : controller.visualizzaCalcRuolo(ricerca.getText()))
                {
                    String[] datiCalc = (calc != null) ? calc.split(" ") : new String[0];
                    String[] row = {datiCalc[0], datiCalc[1], datiCalc[2], datiCalc[3], datiCalc[4], datiCalc[5]};
                    model.addRow(row);
                }
                RuoloPanel.removeAll();


                RuoloPanel.add(TableScrollPane, BorderLayout.CENTER);

            } else {
                defaultPanel.show();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();
            }
        } else if (selezione.equals("Piede")) {
            if (!ricerca.getText().equals("Cerca il giocatore per..." + selezione))
            {
                defaultPanel.hide();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.show();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();

                String[] PiedeTableTitles = {"Nome", "Cognome", "Data di Nascita", "Piede Preferito", "Data Ritiro", "Nazionalità", "Valore Mercato"};

                Table = new JTable();
                Table.setColumnSelectionAllowed(false);
                Table.getTableHeader().setReorderingAllowed(false);
                Table.disable();
                DefaultTableModel uneditableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                // Imposta il nuovo modello sulla tabella
                Table.setModel(uneditableModel);
                Table.setShowGrid(false);
                Table.setBorder(null);
                TableScrollPane = new JScrollPane(Table);
                TableScrollPane.getViewport().setOpaque(false);
                TableScrollPane.setOpaque(false);
                TableScrollPane.setViewportBorder(null);
                TableScrollPane.setBorder(null);
                TableScrollPane.setBounds(0,0,600,350);
                DefaultTableModel model = (DefaultTableModel) Table.getModel();

                model.setColumnIdentifiers(PiedeTableTitles);
                calciatori = controller.visualizzaCalcPiedePR(ricerca.getText());
                for (Calciatori calc : calciatori)
                {
                    String[] row = {calc.Nome, calc.Cognome, calc.DataNascita, calc.PiedePreferito, calc.DataRitiro, calc.Nazionalita, String.valueOf(calc.ValoreMercato)};
                    model.addRow(row);
                }
                PiedePRPanel.removeAll();


                PiedePRPanel.add(TableScrollPane, BorderLayout.CENTER);
            } else {
                defaultPanel.show();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();
            }
        } else if (selezione.equals("Goal segnati")) {
            if (!ricerca.getText().equals("Cerca il giocatore per..." + selezione))
            {
                defaultPanel.hide();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.show();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();

                String[] GoalSegnatiTableTitles = {"Nome", "Cognome", "Data di Nascita", "Piede Preferito", "Nazionalità", "N°Goal Segnati"};

                Table = new JTable();
                Table.setColumnSelectionAllowed(false);
                Table.getTableHeader().setReorderingAllowed(false);
                Table.disable();
                DefaultTableModel uneditableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                Table.setModel(uneditableModel);
                Table.setShowGrid(false);
                Table.setBorder(null);
                TableScrollPane = new JScrollPane(Table);
                TableScrollPane.getViewport().setOpaque(false);
                TableScrollPane.setOpaque(false);
                TableScrollPane.setViewportBorder(null);
                TableScrollPane.setBorder(null);
                TableScrollPane.setBounds(0,0,600,350);
                DefaultTableModel model = (DefaultTableModel) Table.getModel();

                model.setColumnIdentifiers(GoalSegnatiTableTitles);
                for (String calc : controller.visualizzaCalcGoalSegnati(parseInt(ricerca.getText())))
                {
                    String[] datiCalc = (calc != null) ? calc.split(" ") : new String[0];
                    String[] row = {datiCalc[0], datiCalc[1], datiCalc[2], datiCalc[3], datiCalc[4], datiCalc[5]};
                    model.addRow(row);
                }
                GoalSegnatiPanel.removeAll();


                GoalSegnatiPanel.add(TableScrollPane, BorderLayout.CENTER);
            } else {
                defaultPanel.show();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();
            }
        } else if (selezione.equals("Goal subiti")) {
            if (!ricerca.getText().equals("Cerca il giocatore per..." + selezione))
            {
                defaultPanel.hide();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.show();
                EtaPanel.hide();
                SquadraPanel.hide();

                String[] GoalSubitiTableTitles = {"Nome", "Cognome", "Data di Nascita", "Piede Preferito", "Nazionalità", "N°Goal Subiti"};

                Table = new JTable();
                Table.setColumnSelectionAllowed(false);
                Table.getTableHeader().setReorderingAllowed(false);
                Table.disable();
                DefaultTableModel uneditableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                Table.setModel(uneditableModel);
                Table.setShowGrid(false);
                Table.setBorder(null);
                TableScrollPane = new JScrollPane(Table);
                TableScrollPane.getViewport().setOpaque(false);
                TableScrollPane.setOpaque(false);
                TableScrollPane.setViewportBorder(null);
                TableScrollPane.setBorder(null);
                TableScrollPane.setBounds(0,0,600,350);
                DefaultTableModel model = (DefaultTableModel) Table.getModel();

                model.setColumnIdentifiers(GoalSubitiTableTitles);
                for (String calc : controller.visualizzaCalcGoalSubiti(parseInt(ricerca.getText())))
                {
                    String[] datiCalc = (calc != null) ? calc.split(" ") : new String[0];
                    String[] row = {datiCalc[0], datiCalc[1], datiCalc[2], datiCalc[3], datiCalc[4], datiCalc[5]};
                    model.addRow(row);
                }
                GoalSubitiPanel.removeAll();


                GoalSubitiPanel.add(TableScrollPane, BorderLayout.CENTER);
            } else {
                defaultPanel.show();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();
            }
        } else if (selezione.equals("Età")) {
            if (!ricerca.getText().equals("Cerca il giocatore per..." + selezione))
            {
                defaultPanel.hide();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.show();
                SquadraPanel.hide();

                String[] EtaTableTitles = {"Nome", "Cognome", "Età", "Piede Preferito", "Data Ritiro", "Nazionalità", "Valore Mercato"};

                Table = new JTable();
                Table.setColumnSelectionAllowed(false);
                Table.getTableHeader().setReorderingAllowed(false);
                Table.disable();
                DefaultTableModel uneditableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                // Imposta il nuovo modello sulla tabella
                Table.setModel(uneditableModel);
                Table.setShowGrid(false);
                Table.setBorder(null);
                TableScrollPane = new JScrollPane(Table);
                TableScrollPane.getViewport().setOpaque(false);
                TableScrollPane.setOpaque(false);
                TableScrollPane.setViewportBorder(null);
                TableScrollPane.setBorder(null);
                TableScrollPane.setBounds(0,0,600,350);
                DefaultTableModel model = (DefaultTableModel) Table.getModel();

                model.setColumnIdentifiers(EtaTableTitles);
                calciatori = controller.visualizzaCalcEta(parseInt(ricerca.getText()));
                for (Calciatori calc : calciatori)
                {
                    String[] row = {calc.Nome, calc.Cognome, calc.DataNascita, calc.PiedePreferito, calc.DataRitiro, calc.Nazionalita, String.valueOf(calc.ValoreMercato)};
                    model.addRow(row);
                }
                EtaPanel.removeAll();


                EtaPanel.add(TableScrollPane, BorderLayout.CENTER);
            } else {
                defaultPanel.show();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();
            }
        } else if (selezione.equals("Squadra")) {
            if (!ricerca.getText().equals("Cerca il giocatore per..." + selezione))
            {
                defaultPanel.hide();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.show();

                String[] SquadraTableTitles = {"Nome", "Cognome", "Data di Nascita", "Piede Preferito", "Nazionalità", "Squadra"};

                Table = new JTable();
                Table.setColumnSelectionAllowed(false);
                Table.getTableHeader().setReorderingAllowed(false);
                Table.disable();
                DefaultTableModel uneditableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };

                Table.setModel(uneditableModel);
                Table.setShowGrid(false);
                Table.setBorder(null);
                TableScrollPane = new JScrollPane(Table);
                TableScrollPane.getViewport().setOpaque(false);
                TableScrollPane.setOpaque(false);
                TableScrollPane.setViewportBorder(null);
                TableScrollPane.setBorder(null);
                TableScrollPane.setBounds(0,0,600,350);
                DefaultTableModel model = (DefaultTableModel) Table.getModel();

                model.setColumnIdentifiers(SquadraTableTitles);
                for (String calc : controller.visualizzaCalcSquadra(ricerca.getText()))
                {
                    String[] datiCalc = (calc != null) ? calc.split(" ") : new String[0];
                    String[] row = {datiCalc[0], datiCalc[1], datiCalc[2], datiCalc[3], datiCalc[4], datiCalc[5]};
                    model.addRow(row);
                }
                SquadraPanel.removeAll();


                SquadraPanel.add(TableScrollPane, BorderLayout.CENTER);
            } else {
                defaultPanel.show();
                NamePanel.hide();
                RuoloPanel.hide();
                PiedePRPanel.hide();
                GoalSegnatiPanel.hide();
                GoalSubitiPanel.hide();
                EtaPanel.hide();
                SquadraPanel.hide();
            }
        }
    }
}
