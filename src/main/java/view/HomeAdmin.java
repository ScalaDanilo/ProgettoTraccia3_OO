package view;

import controller.Controller;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


public class HomeAdmin implements ActionListener{
    public JFrame frameAdmin = new JFrame();
    public JButton modifica = new JButton("Modifica");
    public JButton inserisci = new JButton("Inserisci");

    public JComboBox step1Inserisci;
    public JLabel step1LabelInserisci = new JLabel("Cosa vuoi inserire?");
    public JLabel step1LabelModifica = new JLabel("Cosa vuoi modificare?");
    JButton goToStep1 = new JButton("Next");
    JButton annulla = new JButton("Annulla");

    //step 1 INSERISCI GIOCATORE (GIOCATORE)
    JTextField step1Inserisci_Giocatore_NomeField;
    JLabel step1Inserisci_Giocatore_NomeLabel;
    JTextField step1Inserisci_Giocatore_CognomeField;
    JLabel step1Inserisci_Giocatore_CognomeLabel;
    JLabel ruoloLabel;
    JRadioButton portiere;
    JRadioButton difensore;
    JRadioButton centrocampista;
    JRadioButton attaccante;
    JComboBox step1Inserisci_NazionalitaCombo;
    JLabel step1Inserisci_NazionalitaLabel;
    JComboBox step1Inserisci_DataRitiroGiorno;
    JComboBox step1Inserisci_DataRitiroMese;
    JComboBox step1Inserisci_DataRitiroAnno;
    JLabel step1Inserisci_DataRitiroLabel;
    JRadioButton step1InserireDataRitiroRadioIG;
    JRadioButton step1NonInserireDataRitiroRadioIG;
    ButtonGroup dataRitiroBTGroup = new ButtonGroup();
    JComboBox step1Giorno;
    JComboBox step1Mese;
    JComboBox step1Anno;
    JLabel step1PiedePRLabel;
    JComboBox step1PiedePRCombo;
    JLabel step1Inserisci_DataDiNascitaLabel;
    JButton avantiToStep2InserisciGiocatore;
    JButton step1confermaDataRitiroButtonIG;

    JButton step1annullaDataRitiroButtonIG;
    JLabel scrittaErrore;

    //STEP 2 INSERISCI GIOCATORE (MILITANZA)

    JLabel step2InizioLabelIG;
    JLabel step2FineLabelIG;
    JLabel step2TiriSegantiLabelIG;
    JLabel step2PartiteGiocateLabelIG;
    JLabel step2GoalSubitiLabelIG;
    JComboBox step2InizioGiornoIG;
    JComboBox step2InizioMeseIG;
    JComboBox step2InizioAnnoIG;
    JComboBox step2FineGiornoIG;
    JComboBox step2FineMeseIG;
    JComboBox step2FineAnnoIG;
    JRadioButton step2fineAncoraInAttoRadio;
    JRadioButton step2fineDefinita;
    ButtonGroup fineMilitanzaGroup;
    JButton step2confermaFineMilitanzaButton;
    JButton step2annullaFineMilitanzaButton;

    JTextField step2TiriSegnatiFieldIG;
    JTextField step2PartiteGiocateFieldIG;
    JTextField step2GoalSubitiFieldIG;
    JButton indietroToStep1DaIG;
    JButton avantiToStep3IG;
    JLabel erroreMilitanza;

    //STEP 3 INSERISCI GIOCATORE (SQUADRA)
    JRadioButton s3InserisciSquadraRadioIG;
    JRadioButton s3TrovaSquadraRadioIG;
    JLabel s3TrovaSquadraLabelIG;
    JLabel s3InsSquadraLabelIG;
    ButtonGroup s3GruppoSquadraIG;
    JButton s3ConfermaSquadraButtonIG;
    JButton s3AnnullaMetodoSquadraIG;
    JLabel erroreConfermaMetodoSquadraIG;
    JComboBox s3TrovaSquadraComboIG;
    JLabel s3InserisciNomeSquadraLabelIG;
    JTextField s3InserisciNomeSquadraFieldIG;
    JLabel s3InserisciNazionalitaSquadraLabelIG;
    JComboBox s3InserisciNazionalitaSquadraComboIG;
    JLabel s3InserisciSponsorTecSquadraLabelIG;
    JTextField s3InserisciSponsorTecSquadraFieldIG;
    JButton indietroToStep2DaIG;
    JButton confermaStep3IG;
    JLabel s3confermaErroreLabelIG;

    //////////////////////
    //STEP 1 INSERISCI COMPETIZIONE
    JLabel s1InserisciNomeCompLabelIC;
    JTextField s1InserisciNomeCompFieldIC;
    JLabel s1AnnoCompLabelIC;
    JComboBox s1AnnoCompComboIC;
    JLabel s1nomeTrofeoLabelIC;
    JTextField s1nomeTrofeoFieldIC;
    JLabel s1annoFineCompLabelIC;
    JComboBox s1AnnoFineCompComboIC;
    JLabel s1SelezionaTipoCompetizioneLabelIC;
    JRadioButton s1NazionaleIC;
    JRadioButton s1InternazionaleIC;
    ButtonGroup s1GruppoTipoCompIC;
    JComboBox s1CompNazComboIC;
    JComboBox s1CompNonNazComboIC;
    JButton s1ConfermaCompIC;
    JButton s1AnnullaCompIC;
    JButton s1ConfermaIC;

    /////////////////////////////
    //STEP 1 INSERISCI SQUADRA
    JLabel s1NomeSquadraLabelIS;
    JTextField s1NomeSquadraFieldIS;
    JLabel s1NazionalitaLabelIS;
    JComboBox s1NazionalitaComboIS;
    JLabel s1InserisciSponsorTecLabelIS;
    JTextField s1InserisciSponsorTecFieldIS;
    JButton s1ConfermaIS;

    ///////////////////////////////
    //INSERISCI SPONSOR SECONDARI
    JLabel s1CercaSquadraLabelSS;
    JComboBox s1CercaSquadraComboSS;
    JButton s1ConfermaSquadraButtonSS;
    JButton s1AnnullaSquadraButtonSS;
    JLabel s1InserisciNomeSponsorLabelSS;
    JTextField s1InserisciNomeSponsorFieldSS;
    JButton s1ConfermaInserimentoSS;

    /////////////////////////////////
    //MODIFICA MILITANZA
    JLabel s1SelezionaGiocatoreLabelMM;
    JComboBox s1SelezionaGiocatoreComboMM;
    JButton s1ConfermaGiocatoreButtonMM;
    JButton s1AnnullaGiocatoreButtonMM;
    JLabel s1SceltaTraGiocatoriUgualiLabelMM;
    JComboBox s1SceltaTraGiocatoriUgualiComboMM;
    JButton s1ConfermaGiocatoreButton2MM;
    JButton s1AnnullaGiocatoreButton2MM;
    JLabel s1InserisciDataFineExMilitanzaLabelMM;
    JComboBox s1InserisciDataFineExMilitanzaGiornoComboMM;
    JComboBox s1InserisciDataFineExMilitanzaMeseComboMM;
    JComboBox s1InserisciDataFineExMilitanzaAnnoComboMM;
    JLabel s1InserisciDataInizioNuovaMilitanzaLabelMM;
    JComboBox s1InserisciDataInizioNuovaMilitanzaGiornoComboMM;
    JComboBox s1InserisciDataInizioNuovaMilitanzaMeseComboMM;
    JComboBox s1InserisciDataInizioNuovaMilitanzaAnnoComboMM;
    JLabel s1InserisciDataFineNuovaMilitanzaLabelMM;
    JComboBox s1InserisciDataFineNuovaMilitanzaGiornoComboMM;
    JComboBox s1InserisciDataFineNuovaMilitanzaMeseComboMM;
    JComboBox s1InserisciDataFineNuovaMilitanzaAnnoComboMM;
    JLabel s1UltimaMilitanzaLabelMM;
    JRadioButton s1MilitanzaInAttoRadioMM;
    JRadioButton s1MilitanzaFinitaRadioMM;
    JButton s1ConfermaFineMilitanzaButtonMM;
    JButton s1AnnullaFineMilitanzaButtonMM;
    ButtonGroup ModificaMilitanza;
    JLabel s1InserisciTiriSegnatiLabelMM;
    JTextField s1InserisciTiriSegnatiFieldMM;
    JLabel s1InserisciPartiteGiocateLabelMM;
    JTextField s1InserisciPartiteGiocateFieldMM;
    JLabel s1InserisciGoalSubitiLabelMM;
    JTextField s1InserisciGoalSubitiFieldMM;
    JLabel s1SelezionaSquadraLabelMM;
    JComboBox s1SelezionaSquadraComboMM;
    JButton s1ConfermaInserimentoMM;

    /////////////////////////
    //MODIFICA CALCIATOIRE
    JLabel s1SelezionaGiocatoreLabelMC;
    JComboBox s1SelezionaGiocatoreComboMC;
    JButton s1ConfermaGiocatoreButtonMC;
    JButton s1AnnullaGiocatoreButtonMC;
    JLabel s1SceltaTraGiocatoriUgualiLabelMC;
    JComboBox s1SceltaTraGiocatoriUgualiComboMC;
    JButton s1ConfermaGiocatoreButton2MC;
    JButton s1AnnullaGiocatoreButton2MC;
    ButtonGroup radioMC;
    JRadioButton s1InserireDataRitiroRadioMC;
    JRadioButton s1NonInserireDataRitiroRadioMC;
    JLabel s1DataRitiroLabelMC;
    JButton s1ConfermaSceltaRitiroButtonMC;
    JButton s1AnnullaSceltaRitiroButtonMC;
    JComboBox s1DataRitiroGiornoComboMC;
    JComboBox s1DataRitiroMeseComboMC;
    JComboBox s1DataRitiroAnnoComboMC;
    JLabel s1InserisciFeatureLabelMC;
    JComboBox s1InserisciFeatureComboMC;
    JButton s1ConfermaInserimentoMC;

    //Inserisci Squadra in competizione
    JLabel s1ScegliCompetizioneLabelISIC;
    JComboBox s1ScegliCompetizioneComboISIC;
    JLabel s1AnnoCompetizioneLabelISIC;
    JComboBox s1AnnoCompetizioneComboISIC;
    JButton s1ConfermaCompetizioneButtonISIC;
    JButton s1AnnullaCompetizioneButtonISIC;
    JLabel s1SelezionaSquadraLabelISIC;
    JComboBox s1SelezionaSquadraComboISIC;
    JButton s1ConfermaInserimentoISIC;
    ////////////////////////
    //ASSEGNA TROFEO
    JLabel s1SelezionaTipoTrofeoLabelAT;
    JRadioButton s1TrofeoSquadraRadioAT;
    JRadioButton s1TrofeoIndividualeRadioAT;
    ButtonGroup groupAT;
    JButton s1ConfermaSceltaTrofeoButtonAT;
    JButton s1AnnullaSceltaTrofeoButtonAT;
    JLabel s1SelezionaTrofeoLabelAT;
    JComboBox s1SelezionaTrofeoComboAT;
    JButton s1ConfermaSceltaTrofeo2ButtonAT;
    JButton s1AnnullaSceltaTrofeo2ButtonAT;
    JLabel s1ScegliTraIdoneiLabelAT;
    JComboBox s1ScegliTraIdoneiComboAT;
    JLabel s1ScegliTraIdoneiUgualiLabelAT;
    JComboBox s1ScegliTraIdoneiUgualiComboAT;
    JButton s1ConfermaInserimentoAT;
    JLabel s1SceltaAnnoAssegnazioneLabelAT;
    JComboBox s1SceltaAnnoAssegnazioneComboAT;

    String[] nazioni = {"Italia", "Spagna", "Germania", "Inghilterra", "Francia", "Belgio", "Portogallo", "Russia"};
    String[] internazioanli = {"Europeo", "Mondiale", "Americano"};
    JComboBox step1Modifica;
    JButton step1ToStep2Modifica = new JButton("Next");
    private Controller controller; // Aggiunto campo per il controller

    public HomeAdmin() throws IOException {
        controller = new Controller();
        //Carico stemmi laterali
        BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\Logo.png"));
        Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon sito = new ImageIcon(image);

        BufferedImage bufferedImage2 = ImageIO.read(new File("C:\\Users\\Danilo\\Desktop\\Secondo anno\\Progetto OO e BD\\OO\\ProgettoTraccia3_OO_e_BD\\university.png"));
        Image image2 = bufferedImage2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon federico = new ImageIcon(image2);

        JLabel logoSito = new JLabel();
        logoSito.setIcon(sito);
        logoSito.setBounds(10, 10, 200, 200);

        JLabel logoFedericoII = new JLabel();
        logoFedericoII.setIcon(federico);
        logoFedericoII.setBounds(770, 10, 200, 200);

        //Tasto inserisci

        inserisci.setBounds(250, 50, 200, 50);
        inserisci.addActionListener(this);
        frameAdmin.add(inserisci);

        //Tasto Modificia

        modifica.setBounds(550, 50, 200, 50);
        modifica.addActionListener(this);
        frameAdmin.add(modifica);

        //Tasto Annulla

        annulla.setBounds(375, 650, 250, 50);
        annulla.addActionListener(this);
        annulla.setVisible(false);
        frameAdmin.add(annulla);

        //step1 Inserisci
        String[] opzStep1Insert = {"Inserisci giocatore", "Inserisci competizione", "Inserisci sponsor secondari", "Inserisci squadra", "Inserisci squadra in competizione"};
        step1Inserisci = new JComboBox(opzStep1Insert);
        step1Inserisci.setVisible(false);
        step1Inserisci.setBounds(400, 150, 200, 40);
        step1Inserisci.addActionListener(this);
        frameAdmin.add(step1Inserisci);

        goToStep1.setVisible(false);
        goToStep1.setBounds(625, 150, 80, 40);
        goToStep1.addActionListener(this);
        frameAdmin.add(goToStep1);

        step1LabelInserisci.setVisible(false);
        step1LabelInserisci.setBounds(425, 110, 250, 40);
        step1LabelInserisci.setFont(new Font("Consolas", Font.PLAIN, 14));
        frameAdmin.add(step1LabelInserisci);

        ///////////////////////////
        //step1 Inserisci Giocatore
        //nome

        step1Inserisci_Giocatore_NomeField = new JTextField();
        step1Inserisci_Giocatore_NomeField.setBounds(90, 250, 120, 40);
        step1Inserisci_Giocatore_NomeField.setVisible(false);
        frameAdmin.add(step1Inserisci_Giocatore_NomeField);

        step1Inserisci_Giocatore_NomeLabel = new JLabel("Nome:");
        step1Inserisci_Giocatore_NomeLabel.setBounds(10, 250, 70, 40);
        step1Inserisci_Giocatore_NomeLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        step1Inserisci_Giocatore_NomeLabel.setVisible(false);
        frameAdmin.add(step1Inserisci_Giocatore_NomeLabel);

        //cognome
        step1Inserisci_Giocatore_CognomeField = new JTextField();
        step1Inserisci_Giocatore_CognomeField.setBounds(90, 320, 120, 40);
        step1Inserisci_Giocatore_CognomeField.setVisible(false);
        frameAdmin.add(step1Inserisci_Giocatore_CognomeField);

        step1Inserisci_Giocatore_CognomeLabel = new JLabel("Cognome:");
        step1Inserisci_Giocatore_CognomeLabel.setBounds(10, 320, 70, 40);
        step1Inserisci_Giocatore_CognomeLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        step1Inserisci_Giocatore_CognomeLabel.setVisible(false);
        frameAdmin.add(step1Inserisci_Giocatore_CognomeLabel);

        //PIEDE PR
        step1PiedePRLabel = new JLabel("Piede preferito:");
        step1PiedePRLabel.setBounds(280, 420, 150, 40);
        step1PiedePRLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        step1PiedePRLabel.setVisible(false);
        frameAdmin.add(step1PiedePRLabel);

        String[] piedi = {"Destro", "Sinistro", "Ambidestro"};
        step1PiedePRCombo = new JComboBox(piedi);
        step1PiedePRCombo.setBounds(300, 470, 100, 40);
        step1PiedePRCombo.setVisible(false);
        frameAdmin.add(step1PiedePRCombo);

        //Ruolo

        ruoloLabel = new JLabel("Ruolo:");
        ruoloLabel.setBounds(10, 380, 70, 40);
        ruoloLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        ruoloLabel.setVisible(false);
        frameAdmin.add(ruoloLabel);

        portiere = new JRadioButton("Portiere");
        portiere.setVisible(false);
        portiere.setBounds(90, 400, 80, 30);
        portiere.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(portiere);

        difensore = new JRadioButton("Difensore");
        difensore.setVisible(false);
        difensore.setBounds(90, 440, 80, 30);
        difensore.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(difensore);

        centrocampista = new JRadioButton("Centrocampista");
        centrocampista.setVisible(false);
        centrocampista.setBounds(90, 480, 120, 30);
        centrocampista.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(centrocampista);

        attaccante = new JRadioButton("Attaccante");
        attaccante.setVisible(false);
        attaccante.setBounds(90, 520, 120, 30);
        attaccante.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(attaccante);

        //Nazionalità

        step1Inserisci_NazionalitaLabel = new JLabel("Nazionalita':");
        step1Inserisci_NazionalitaLabel.setBounds(280, 250, 120, 40);
        step1Inserisci_NazionalitaLabel.setVisible(false);
        step1Inserisci_NazionalitaLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        frameAdmin.add(step1Inserisci_NazionalitaLabel);



        step1Inserisci_NazionalitaCombo = new JComboBox(nazioni);
        step1Inserisci_NazionalitaCombo.setBounds(400, 250, 120, 40);
        step1Inserisci_NazionalitaCombo.setVisible(false);
        frameAdmin.add(step1Inserisci_NazionalitaCombo);

        //Data Ritiro
        step1Inserisci_DataRitiroLabel = new JLabel("Data Ritiro:");
        step1Inserisci_DataRitiroLabel.setBounds(10, 560, 120, 40);
        step1Inserisci_DataRitiroLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        step1Inserisci_DataRitiroLabel.setVisible(false);
        frameAdmin.add(step1Inserisci_DataRitiroLabel);

        step1InserireDataRitiroRadioIG = new JRadioButton("Ha una data di ritiro");
        step1InserireDataRitiroRadioIG.setBounds(10, 590, 180, 30);
        step1InserireDataRitiroRadioIG.setVisible(false);
        step1InserireDataRitiroRadioIG.setBackground(Color.LIGHT_GRAY);
        step1InserireDataRitiroRadioIG.addActionListener(this);
        frameAdmin.add(step1InserireDataRitiroRadioIG);

        step1NonInserireDataRitiroRadioIG = new JRadioButton("Non ha una data di ritiro");
        step1NonInserireDataRitiroRadioIG.setBounds(200, 590, 200, 30);
        step1NonInserireDataRitiroRadioIG.setVisible(false);
        step1NonInserireDataRitiroRadioIG.setBackground(Color.LIGHT_GRAY);
        step1NonInserireDataRitiroRadioIG.addActionListener(this);
        frameAdmin.add(step1NonInserireDataRitiroRadioIG);

        dataRitiroBTGroup.add(step1InserireDataRitiroRadioIG);
        dataRitiroBTGroup.add(step1NonInserireDataRitiroRadioIG);

        step1confermaDataRitiroButtonIG = new JButton("Conferma");
        step1confermaDataRitiroButtonIG.setBounds(10, 640, 130, 40);
        step1confermaDataRitiroButtonIG.setVisible(false);
        step1confermaDataRitiroButtonIG.addActionListener(this);
        frameAdmin.add(step1confermaDataRitiroButtonIG);


        step1annullaDataRitiroButtonIG = new JButton("Annulla");
        step1annullaDataRitiroButtonIG.setBounds(200, 640, 130, 40);
        step1annullaDataRitiroButtonIG.setVisible(false);
        step1annullaDataRitiroButtonIG.addActionListener(this);
        frameAdmin.add(step1annullaDataRitiroButtonIG);


        String[] giorni = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        step1Inserisci_DataRitiroGiorno = new JComboBox(giorni);
        step1Inserisci_DataRitiroGiorno.setVisible(false);
        step1Inserisci_DataRitiroGiorno.setBounds(10, 700, 60, 30);
        frameAdmin.add(step1Inserisci_DataRitiroGiorno);

        String[] mesi = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        step1Inserisci_DataRitiroMese = new JComboBox(mesi);
        step1Inserisci_DataRitiroMese.setVisible(false);
        step1Inserisci_DataRitiroMese.setBounds(90, 700, 60, 30);
        frameAdmin.add(step1Inserisci_DataRitiroMese);

        String[] anniRitiro = {"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2036", "2035"};
        step1Inserisci_DataRitiroAnno = new JComboBox(anniRitiro);
        step1Inserisci_DataRitiroAnno.setVisible(false);
        step1Inserisci_DataRitiroAnno.setBounds(170, 700, 60, 30);
        frameAdmin.add(step1Inserisci_DataRitiroAnno);

        //Data di Nascita

        step1Inserisci_DataDiNascitaLabel = new JLabel("Data Di Nascita(giorno/mese/anno):");
        step1Inserisci_DataDiNascitaLabel.setBounds(280, 320, 320, 40);
        step1Inserisci_DataDiNascitaLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        step1Inserisci_DataDiNascitaLabel.setVisible(false);
        frameAdmin.add(step1Inserisci_DataDiNascitaLabel);

        step1Giorno = new JComboBox(giorni);
        step1Giorno.setBounds(300, 360, 60, 30);
        step1Giorno.setVisible(false);
        frameAdmin.add(step1Giorno);

        step1Mese = new JComboBox(mesi);
        step1Mese.setBounds(390, 360, 60, 30);
        step1Mese.setVisible(false);
        frameAdmin.add(step1Mese);

        String[] anni = {"2030", "2029", "2028", "2027", "2026", "2025", "2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919"};
        step1Anno = new JComboBox(anni);
        step1Anno.setBounds(480, 360, 60, 30);
        step1Anno.setVisible(false);
        frameAdmin.add(step1Anno);

        //tasto avanti fino a step 2 inserisci

        avantiToStep2InserisciGiocatore = new JButton("Vai a militanza");
        avantiToStep2InserisciGiocatore.setBounds(750, 400, 200, 50);
        avantiToStep2InserisciGiocatore.setVisible(false);
        avantiToStep2InserisciGiocatore.addActionListener(this);
        frameAdmin.add(avantiToStep2InserisciGiocatore);

        //scrittaErrore nell avanzare

        scrittaErrore = new JLabel("Inserire tutti i dati");
        scrittaErrore.setVisible(false);
        scrittaErrore.setBounds(600, 450, 300, 100);
        scrittaErrore.setFont(new Font("Consolas", Font.PLAIN, 25));
        scrittaErrore.setForeground(Color.RED);
        frameAdmin.add(scrittaErrore);


        ////////////////////////////
        //STEP 2 INSERISCI GIOCATORE


        //Inizio model.Militanza

        step2InizioLabelIG = new JLabel("Inizio militanza(giorno/mese/anno):");
        step2InizioLabelIG.setBounds(10, 250, 300, 50);
        step2InizioLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2InizioLabelIG.setVisible(false);
        frameAdmin.add(step2InizioLabelIG);

        step2InizioGiornoIG = new JComboBox(giorni);
        step2InizioGiornoIG.setBounds(10, 310, 50, 25);
        step2InizioGiornoIG.setVisible(false);
        frameAdmin.add(step2InizioGiornoIG);

        step2InizioMeseIG = new JComboBox(mesi);
        step2InizioMeseIG.setBounds(70, 310, 50, 25);
        step2InizioMeseIG.setVisible(false);
        frameAdmin.add(step2InizioMeseIG);

        step2InizioAnnoIG = new JComboBox(anni);
        step2InizioAnnoIG.setBounds(130, 310, 70, 25);
        step2InizioAnnoIG.setVisible(false);
        frameAdmin.add(step2InizioAnnoIG);

        //Fine model.Militanza

        step2FineLabelIG = new JLabel("Militanza:");
        step2FineLabelIG.setBounds(350, 250, 200, 50);
        step2FineLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2FineLabelIG.setVisible(false);
        frameAdmin.add(step2FineLabelIG);

        step2fineAncoraInAttoRadio = new JRadioButton("Ancora in atto");
        step2fineAncoraInAttoRadio.setBounds(430, 250, 110, 50);
        step2fineAncoraInAttoRadio.setBackground(Color.LIGHT_GRAY);
        step2fineAncoraInAttoRadio.setVisible(false);
        frameAdmin.add(step2fineAncoraInAttoRadio);

        step2fineDefinita = new JRadioButton("Finita");
        step2fineDefinita.setBounds(550, 250, 70, 50);
        step2fineDefinita.setBackground(Color.LIGHT_GRAY);
        step2fineDefinita.setVisible(false);
        frameAdmin.add(step2fineDefinita);

        fineMilitanzaGroup = new ButtonGroup();
        fineMilitanzaGroup.add(step2fineDefinita);
        fineMilitanzaGroup.add(step2fineAncoraInAttoRadio);

        step2confermaFineMilitanzaButton = new JButton("Ok");
        step2confermaFineMilitanzaButton.setBounds(630, 260, 50, 25);
        step2confermaFineMilitanzaButton.setVisible(false);
        step2confermaFineMilitanzaButton.addActionListener(this);
        frameAdmin.add(step2confermaFineMilitanzaButton);

        step2annullaFineMilitanzaButton = new JButton("Annulla");
        step2annullaFineMilitanzaButton.setBounds(700, 260, 80, 25);
        step2annullaFineMilitanzaButton.setVisible(false);
        step2annullaFineMilitanzaButton.addActionListener(this);
        frameAdmin.add(step2annullaFineMilitanzaButton);

        step2FineGiornoIG = new JComboBox(giorni);
        step2FineGiornoIG.setBounds(350, 310, 50, 25);
        step2FineGiornoIG.setVisible(false);
        frameAdmin.add(step2FineGiornoIG);

        step2FineMeseIG = new JComboBox(mesi);
        step2FineMeseIG.setBounds(410, 310, 50, 25);
        step2FineMeseIG.setVisible(false);
        frameAdmin.add(step2FineMeseIG);

        step2FineAnnoIG = new JComboBox(anni);
        step2FineAnnoIG.setBounds(470, 310, 70, 25);
        step2FineAnnoIG.setVisible(false);
        frameAdmin.add(step2FineAnnoIG);

        //Tiri segnati

        step2TiriSegantiLabelIG = new JLabel("Inserisci il numero di goal segnati:");
        step2TiriSegantiLabelIG.setBounds(10, 400, 300, 50);
        step2TiriSegantiLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2TiriSegantiLabelIG.setVisible(false);
        frameAdmin.add(step2TiriSegantiLabelIG);

        step2TiriSegnatiFieldIG = new JTextField();
        step2TiriSegnatiFieldIG.setBounds(110, 430, 50, 30);
        step2TiriSegnatiFieldIG.setVisible(false);
        frameAdmin.add(step2TiriSegnatiFieldIG);

        //Partite Giocate

        step2PartiteGiocateLabelIG = new JLabel("Inserisci il numero partite di giocate:");
        step2PartiteGiocateLabelIG.setBounds(350, 400, 300, 50);
        step2PartiteGiocateLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2PartiteGiocateLabelIG.setVisible(false);
        frameAdmin.add(step2PartiteGiocateLabelIG);

        step2PartiteGiocateFieldIG = new JTextField();
        step2PartiteGiocateFieldIG.setBounds(470, 430, 50, 30);
        step2PartiteGiocateFieldIG.setVisible(false);
        frameAdmin.add(step2PartiteGiocateFieldIG);

        //Goal Subiti

        step2GoalSubitiLabelIG = new JLabel("Inserisci il numero goal di subiti:");
        step2GoalSubitiLabelIG.setBounds(10, 500, 300, 50);
        step2GoalSubitiLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2GoalSubitiLabelIG.setVisible(false);
        frameAdmin.add(step2GoalSubitiLabelIG);

        step2GoalSubitiFieldIG = new JTextField();
        step2GoalSubitiFieldIG.setBounds(110, 530, 50, 30);
        step2GoalSubitiFieldIG.setVisible(false);
        frameAdmin.add(step2GoalSubitiFieldIG);

        //Tasto per ritornare Indietro

        indietroToStep1DaIG = new JButton("Torna a calciatore");
        indietroToStep1DaIG.setBounds(750, 550, 200, 50);
        indietroToStep1DaIG.setVisible(false);
        indietroToStep1DaIG.addActionListener(this);
        frameAdmin.add(indietroToStep1DaIG);

        //Tasto per andare allo step 3

        avantiToStep3IG = new JButton("Vai a squadra");
        avantiToStep3IG.setBounds(750, 400, 200, 50);
        avantiToStep3IG.setVisible(false);
        avantiToStep3IG.addActionListener(this);
        frameAdmin.add(avantiToStep3IG);

        //erroreMilitanza

        erroreMilitanza = new JLabel("Controllare che siano stati inseriti soltanto Numeri");
        erroreMilitanza.setVisible(false);
        erroreMilitanza.setBounds(700, 450, 250, 100);
        erroreMilitanza.setFont(new Font("Consolas", Font.PLAIN, 17));
        erroreMilitanza.setForeground(Color.RED);
        frameAdmin.add(erroreMilitanza);

        ///////////////////////////////////////
        //STEP 3 INSERISCI GIOCATORE (SQUADRA)

        //Inserimento Squadra
        s3InsSquadraLabelIG = new JLabel("In che modo vuoi inserire la squadra?");
        s3InsSquadraLabelIG.setBounds(10, 240, 300, 50);
        s3InsSquadraLabelIG.setVisible(false);
        s3InsSquadraLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        frameAdmin.add(s3InsSquadraLabelIG);

        //Inserimento dei due radio
        s3InserisciSquadraRadioIG = new JRadioButton("Inserisci Squadra");
        s3InserisciSquadraRadioIG.setBounds(10, 280, 150, 50);
        s3InserisciSquadraRadioIG.setVisible(false);
        s3InserisciSquadraRadioIG.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(s3InserisciSquadraRadioIG);

        s3TrovaSquadraRadioIG = new JRadioButton("Trova Squadra");
        s3TrovaSquadraRadioIG.setBounds(170, 280, 150, 50);
        s3TrovaSquadraRadioIG.setVisible(false);
        s3TrovaSquadraRadioIG.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(s3TrovaSquadraRadioIG);

        s3GruppoSquadraIG = new ButtonGroup();
        s3GruppoSquadraIG.add(s3InserisciSquadraRadioIG);
        s3GruppoSquadraIG.add(s3TrovaSquadraRadioIG);

        //Tasto di conferma Squadra
        s3ConfermaSquadraButtonIG = new JButton("Conferma scelta");
        s3ConfermaSquadraButtonIG.setBounds(10, 340, 130, 40);
        s3ConfermaSquadraButtonIG.setVisible(false);
        s3ConfermaSquadraButtonIG.addActionListener(this);
        frameAdmin.add(s3ConfermaSquadraButtonIG);

        //Tasto di annulla metodo

        s3AnnullaMetodoSquadraIG = new JButton("Annulla Scelta");
        s3AnnullaMetodoSquadraIG.setBounds(150, 340, 130, 40);
        s3AnnullaMetodoSquadraIG.addActionListener(this);
        s3AnnullaMetodoSquadraIG.setVisible(false);
        frameAdmin.add(s3AnnullaMetodoSquadraIG);


        //errore se si preme il tasto senza selezionare
        erroreConfermaMetodoSquadraIG = new JLabel("Selezionare prima il metodo");
        erroreConfermaMetodoSquadraIG.setBounds(10, 400, 200, 50);
        erroreConfermaMetodoSquadraIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        erroreConfermaMetodoSquadraIG.setVisible(false);
        erroreConfermaMetodoSquadraIG.setBackground(Color.RED);
        frameAdmin.add(erroreConfermaMetodoSquadraIG);

        //Trova la squadra in una combobox
        s3TrovaSquadraLabelIG = new JLabel("Trova la Squadra");
        s3TrovaSquadraLabelIG.setBounds(10, 400, 200, 50);
        s3TrovaSquadraLabelIG.setVisible(false);


        String[] listaSquadre = new String[0];
        try {
            listaSquadre = (controller.prendiSquadreDalDB() != null) ? controller.prendiSquadreDalDB().split(",") : new String[0];
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        s3TrovaSquadraComboIG = new JComboBox(listaSquadre);
        s3TrovaSquadraComboIG.setBounds(10, 440, 100, 40);
        s3TrovaSquadraComboIG.setVisible(false);
        s3TrovaSquadraComboIG.setEditable(true);
        frameAdmin.add(s3TrovaSquadraComboIG);

        //Inserimento Nome Squadra
        s3InserisciNomeSquadraLabelIG = new JLabel("Inserisci il nome della squadra:");
        s3InserisciNomeSquadraLabelIG.setBounds(10, 400, 300, 50);
        s3InserisciNomeSquadraLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        s3InserisciNomeSquadraLabelIG.setVisible(false);
        frameAdmin.add(s3InserisciNomeSquadraLabelIG);

        s3InserisciNomeSquadraFieldIG = new JTextField();
        s3InserisciNomeSquadraFieldIG.setBounds(10, 440, 150, 40);
        s3InserisciNomeSquadraFieldIG.setVisible(false);
        frameAdmin.add(s3InserisciNomeSquadraFieldIG);

        //inserimento nazionalita Squadra
        s3InserisciNazionalitaSquadraLabelIG = new JLabel("Inserisci la nazionalita' della squadra:");
        s3InserisciNazionalitaSquadraLabelIG.setBounds(350, 400, 300, 50);
        s3InserisciNazionalitaSquadraLabelIG.setVisible(false);
        s3InserisciNazionalitaSquadraLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        frameAdmin.add(s3InserisciNazionalitaSquadraLabelIG);

        s3InserisciNazionalitaSquadraComboIG = new JComboBox(nazioni);
        s3InserisciNazionalitaSquadraComboIG.setBounds(350, 440, 150, 40);
        s3InserisciNazionalitaSquadraComboIG.setVisible(false);
        frameAdmin.add(s3InserisciNazionalitaSquadraComboIG);

        //inserimento Sponsor Tec ssquadra
        s3InserisciSponsorTecSquadraLabelIG = new JLabel("Inserisci lo sponsor tecnico della squadra");
        s3InserisciSponsorTecSquadraLabelIG.setBounds(10, 490, 300, 50);
        s3InserisciSponsorTecSquadraLabelIG.setVisible(false);
        s3InserisciSponsorTecSquadraLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        frameAdmin.add(s3InserisciSponsorTecSquadraLabelIG);

        s3InserisciSponsorTecSquadraFieldIG = new JTextField();
        s3InserisciSponsorTecSquadraFieldIG.setBounds(10, 530, 150, 40);
        s3InserisciSponsorTecSquadraFieldIG.setVisible(false);
        frameAdmin.add(s3InserisciSponsorTecSquadraFieldIG);

        //tasto per tornare allo step 2
        indietroToStep2DaIG = new JButton("Torna a militanza");
        indietroToStep2DaIG.setBounds(750, 550, 200, 50);
        indietroToStep2DaIG.setVisible(false);
        indietroToStep2DaIG.addActionListener(this);
        frameAdmin.add(indietroToStep2DaIG);

        //tasto per confermare il tutto
        confermaStep3IG = new JButton("Conferma inserimento DB");
        confermaStep3IG.setBounds(750, 400, 200, 50);
        confermaStep3IG.setVisible(false);
        confermaStep3IG.addActionListener(this);
        frameAdmin.add(confermaStep3IG);

        //SCRITTA ERRORE NELLA CONFERMA
        s3confermaErroreLabelIG = new JLabel();
        s3confermaErroreLabelIG.setBounds(600, 450, 300, 100);
        s3confermaErroreLabelIG.setVisible(false);
        s3confermaErroreLabelIG.setFont(new Font("Consolas", Font.PLAIN, 10));
        s3confermaErroreLabelIG.setForeground(Color.RED);
        frameAdmin.add(s3confermaErroreLabelIG);

        ///////////////////////////
        // STEP 1 INSERISCI COMPETIZIONE

        //NOME COMPETIZIONE
        s1InserisciNomeCompLabelIC = new JLabel("Inserici il nome della competizione");
        s1InserisciNomeCompLabelIC.setBounds(10, 250, 250, 50);
        s1InserisciNomeCompLabelIC.setVisible(false);
        s1InserisciNomeCompLabelIC.setFont(new Font("Consolas", Font.PLAIN, 13));
        frameAdmin.add(s1InserisciNomeCompLabelIC);

        s1InserisciNomeCompFieldIC = new JTextField();
        s1InserisciNomeCompFieldIC.setBounds(10, 300, 150, 35);
        s1InserisciNomeCompFieldIC.setVisible(false);
        frameAdmin.add(s1InserisciNomeCompFieldIC);

        //ANNO COMPETIZIONE
        s1AnnoCompLabelIC = new JLabel("Inserisci l'anno in cui inizia la competizione");
        s1AnnoCompLabelIC.setBounds(350, 250, 450, 50);
        s1AnnoCompLabelIC.setFont(new Font("Consolas", Font.PLAIN, 13));
        s1AnnoCompLabelIC.setVisible(false);
        frameAdmin.add(s1AnnoCompLabelIC);

        s1AnnoCompComboIC = new JComboBox(anni);
        s1AnnoCompComboIC.setBounds(350, 300, 80, 40);
        s1AnnoCompComboIC.setVisible(false);
        frameAdmin.add(s1AnnoCompComboIC);

        //nome trofeo
        s1nomeTrofeoLabelIC = new JLabel("Inserire il nome del trofeo");
        s1nomeTrofeoLabelIC.setBounds(10, 350, 250, 50);
        s1nomeTrofeoLabelIC.setVisible(false);
        s1nomeTrofeoLabelIC.setFont(new Font("Consolas", Font.PLAIN, 13));
        frameAdmin.add(s1nomeTrofeoLabelIC);

        s1nomeTrofeoFieldIC = new JTextField();
        s1nomeTrofeoFieldIC.setBounds(10, 400, 150, 35);
        s1nomeTrofeoFieldIC.setVisible(false);
        frameAdmin.add(s1nomeTrofeoFieldIC);

        //anno fine competizione
        s1annoFineCompLabelIC = new JLabel("Seleziona l'Anno di assegnazione del trofeo");
        s1annoFineCompLabelIC.setBounds(350, 350, 300, 50);
        s1annoFineCompLabelIC.setVisible(false);
        s1annoFineCompLabelIC.setFont(new Font("Consolas", Font.PLAIN, 13));
        frameAdmin.add(s1annoFineCompLabelIC);

        s1AnnoFineCompComboIC = new JComboBox(anni);
        s1AnnoFineCompComboIC.setBounds(350, 400, 80, 40);
        s1AnnoFineCompComboIC.setVisible(false);
        frameAdmin.add(s1AnnoFineCompComboIC);

        //SCELTA TIPO DI COMPETIZIONE
        s1SelezionaTipoCompetizioneLabelIC = new JLabel("Scegli di che tipo e' la competizione");
        s1SelezionaTipoCompetizioneLabelIC.setBounds(10, 450, 300, 50);
        s1SelezionaTipoCompetizioneLabelIC.setFont(new Font("Consolas", Font.PLAIN, 13));
        s1SelezionaTipoCompetizioneLabelIC.setVisible(false);
        frameAdmin.add(s1SelezionaTipoCompetizioneLabelIC);


        s1NazionaleIC = new JRadioButton("Nazionale");
        s1NazionaleIC.setBounds(10, 500, 100, 40);
        s1NazionaleIC.setBackground(Color.LIGHT_GRAY);
        s1NazionaleIC.setVisible(false);
        frameAdmin.add(s1NazionaleIC);

        s1InternazionaleIC = new JRadioButton("Internazionale");
        s1InternazionaleIC.setBounds(150, 500, 100, 40);
        s1InternazionaleIC.setBackground(Color.LIGHT_GRAY);
        s1InternazionaleIC.setVisible(false);
        frameAdmin.add(s1InternazionaleIC);

        s1GruppoTipoCompIC = new ButtonGroup();
        s1GruppoTipoCompIC.add(s1NazionaleIC);
        s1GruppoTipoCompIC.add(s1InternazionaleIC);

        //LISTA NAZIONI DA SCEGLIERE
        s1CompNazComboIC = new JComboBox(nazioni);
        s1CompNazComboIC.setBounds(10, 610, 100, 40);
        s1CompNazComboIC.setEditable(true);
        s1CompNazComboIC.setVisible(false);
        frameAdmin.add(s1CompNazComboIC);

        //LISTA INTERNAZIONALI DA SCEGLIERE
        String[] internazioanli = {"Europeo", "Mondiale", "Americano"};
        s1CompNonNazComboIC = new JComboBox(internazioanli);
        s1CompNonNazComboIC.setBounds(10, 610, 100, 40);
        s1CompNonNazComboIC.setEditable(true);
        s1CompNonNazComboIC.setVisible(false);
        frameAdmin.add(s1CompNonNazComboIC);

        //TASTO CONFERMA TIPO COMPETIZIONE
        s1ConfermaCompIC = new JButton("OK");
        s1ConfermaCompIC.setBounds(10, 550, 60, 40);
        s1ConfermaCompIC.setVisible(false);
        s1ConfermaCompIC.addActionListener(this);
        frameAdmin.add(s1ConfermaCompIC);

        //TASTO ANNULLA CONFERMA TIPO COMPETIZIONE
        s1AnnullaCompIC = new JButton("ANNULLA");
        s1AnnullaCompIC.setBounds(90, 550, 120, 40);
        s1AnnullaCompIC.setVisible(false);
        s1AnnullaCompIC.addActionListener(this);
        s1AnnullaCompIC.setEnabled(false);
        frameAdmin.add(s1AnnullaCompIC);

        //TASTO CONFERMA INSERIMENTO COMPETIZIONE
        s1ConfermaIC = new JButton("Conferma inserimento");
        s1ConfermaIC.setBounds(700, 400, 200, 70);
        s1ConfermaIC.setVisible(false);
        s1ConfermaIC.addActionListener(this);
        frameAdmin.add(s1ConfermaIC);


///////////////////////////////////////////////////////////
        //STEP1 INSERISCI SQUADRA

        //NOME SQUADRA
        s1NomeSquadraLabelIS = new JLabel("Inserisci il nome della squadra");
        s1NomeSquadraLabelIS.setBounds(10, 250, 250, 50);
        s1NomeSquadraLabelIS.setFont(new Font("Consolas", Font.PLAIN, 13));
        s1NomeSquadraLabelIS.setVisible(false);
        frameAdmin.add(s1NomeSquadraLabelIS);


        s1NomeSquadraFieldIS = new JTextField();
        s1NomeSquadraFieldIS.setBounds(10, 300, 150, 40);
        s1NomeSquadraFieldIS.setVisible(false);
        frameAdmin.add(s1NomeSquadraFieldIS);

        //NAZIONALITà
        s1NazionalitaLabelIS = new JLabel("Inserire la nazionalità della squadra");
        s1NazionalitaLabelIS.setBounds(10, 400, 350, 50);
        s1NazionalitaLabelIS.setFont(new Font("Consolas", Font.PLAIN, 13));
        s1NazionalitaLabelIS.setVisible(false);
        frameAdmin.add(s1NazionalitaLabelIS);

        s1NazionalitaComboIS = new JComboBox(nazioni);
        s1NazionalitaComboIS.setBounds(10, 450, 150, 40);
        s1NazionalitaComboIS.setVisible(false);
        frameAdmin.add(s1NazionalitaComboIS);

        //SPONSOR TEC
        s1InserisciSponsorTecLabelIS = new JLabel("Inserire lo sponsor tecnico della squadra");
        s1InserisciSponsorTecLabelIS.setBounds(300, 250, 350, 50);
        s1InserisciSponsorTecLabelIS.setFont(new Font("Consolas", Font.PLAIN, 13));
        s1InserisciSponsorTecLabelIS.setVisible(false);
        frameAdmin.add(s1InserisciSponsorTecLabelIS);

        s1InserisciSponsorTecFieldIS = new JTextField();
        s1InserisciSponsorTecFieldIS.setBounds(300, 300, 150, 40);
        s1InserisciSponsorTecFieldIS.setVisible(false);
        frameAdmin.add(s1InserisciSponsorTecFieldIS);

        //TASTO CONFERMA TUTTO
        s1ConfermaIS = new JButton("Conferma Squadra");
        s1ConfermaIS.setBounds(700, 400, 200, 70);
        s1ConfermaIS.setVisible(false);
        s1ConfermaIS.addActionListener(this);
        frameAdmin.add(s1ConfermaIS);

        ////////////////////////////////////////
        //Inserisci Sponsor Secondario

        //cerca Squadra
        s1CercaSquadraLabelSS = new JLabel("Seleziona la squadra");
        s1CercaSquadraLabelSS.setBounds(10, 250, 150, 50);
        s1CercaSquadraLabelSS.setFont(new Font("Consolas", Font.PLAIN, 13));
        s1CercaSquadraLabelSS.setVisible(false);
        frameAdmin.add(s1CercaSquadraLabelSS);

        s1CercaSquadraComboSS = new JComboBox(listaSquadre);
        s1CercaSquadraComboSS.setBounds(200, 250, 150, 50);
        s1CercaSquadraComboSS.setVisible(false);
        frameAdmin.add(s1CercaSquadraComboSS);

        //tasto conferma squadra
        s1ConfermaSquadraButtonSS = new JButton("Conferma");
        s1ConfermaSquadraButtonSS.setBounds(10, 330, 150, 50);
        s1ConfermaSquadraButtonSS.addActionListener(this);
        s1ConfermaSquadraButtonSS.setVisible(false);
        frameAdmin.add(s1ConfermaSquadraButtonSS);

        //tasto annulla squadra
        s1AnnullaSquadraButtonSS = new JButton("Annulla");
        s1AnnullaSquadraButtonSS.setBounds(200, 330, 100, 50);
        s1AnnullaSquadraButtonSS.addActionListener(this);
        s1AnnullaSquadraButtonSS.setVisible(false);
        s1AnnullaSquadraButtonSS.setEnabled(false);
        frameAdmin.add(s1AnnullaSquadraButtonSS);

        //Nome SPonsor
        s1InserisciNomeSponsorLabelSS = new JLabel("Inserisci il nome dello sponsor");
        s1InserisciNomeSponsorLabelSS.setBounds(10, 420, 250, 50);
        s1InserisciNomeSponsorLabelSS.setVisible(false);
        s1InserisciNomeSponsorLabelSS.setFont(new Font("Consolas", Font.PLAIN, 13));;
        frameAdmin.add(s1InserisciNomeSponsorLabelSS);

        s1InserisciNomeSponsorFieldSS = new JTextField();
        s1InserisciNomeSponsorFieldSS.setBounds(10, 520, 200, 50);
        s1InserisciNomeSponsorFieldSS.setVisible(false);
        frameAdmin.add(s1InserisciNomeSponsorFieldSS);

        //tasto conferma Inserimento
        s1ConfermaInserimentoSS = new JButton("Conferma Sponsor");
        s1ConfermaInserimentoSS.setBounds(700, 400, 200, 70);
        s1ConfermaInserimentoSS.setVisible(false);
        s1ConfermaInserimentoSS.addActionListener(this);
        frameAdmin.add(s1ConfermaInserimentoSS);

        //MODIFICA MILITANZA

        //seleziona giocatore
        s1SelezionaGiocatoreLabelMM = new JLabel("Seleziona Giocatore");
        s1SelezionaGiocatoreLabelMM.setVisible(false);
        s1SelezionaGiocatoreLabelMM.setBounds(10,250, 150, 40);
        frameAdmin.add(s1SelezionaGiocatoreLabelMM);

        s1SelezionaGiocatoreComboMM = new JComboBox();
        s1SelezionaGiocatoreComboMM.setVisible(false);
        s1SelezionaGiocatoreComboMM.setBounds(180, 250, 180, 40);
        frameAdmin.add(s1SelezionaGiocatoreComboMM);

        //conferma/annulla calciatore
        s1ConfermaGiocatoreButtonMM = new JButton("Conferma1");
        s1ConfermaGiocatoreButtonMM.setVisible(false);
        s1ConfermaGiocatoreButtonMM.setBounds(435, 250, 120, 40);
        s1ConfermaGiocatoreButtonMM.addActionListener(this);
        frameAdmin.add(s1ConfermaGiocatoreButtonMM);

        s1AnnullaGiocatoreButtonMM = new JButton("Annulla1");
        s1AnnullaGiocatoreButtonMM.setVisible(false);
        s1AnnullaGiocatoreButtonMM.setEnabled(false);
        s1AnnullaGiocatoreButtonMM.setBounds(580, 250, 90, 40);
        s1AnnullaGiocatoreButtonMM.addActionListener(this);
        frameAdmin.add(s1AnnullaGiocatoreButtonMM);

        //Scelta Giocatori uguali
        s1SceltaTraGiocatoriUgualiLabelMM = new JLabel("Quale tra questi");
        s1SceltaTraGiocatoriUgualiLabelMM.setBounds(10, 300, 150, 40);
        s1SceltaTraGiocatoriUgualiLabelMM.setVisible(false);
        frameAdmin.add(s1SceltaTraGiocatoriUgualiLabelMM);

        s1SceltaTraGiocatoriUgualiComboMM = new JComboBox();
        s1SceltaTraGiocatoriUgualiComboMM.setBounds(150, 300, 250, 40);
        s1SceltaTraGiocatoriUgualiComboMM.setVisible(false);
        frameAdmin.add(s1SceltaTraGiocatoriUgualiComboMM);

        //Annulla/conferma tra giocatori uguali
        s1ConfermaGiocatoreButton2MM = new JButton("Conferma2");
        s1ConfermaGiocatoreButton2MM.setBounds(435, 300, 120, 40);
        s1ConfermaGiocatoreButton2MM.setVisible(false);
        s1ConfermaGiocatoreButton2MM.addActionListener(this);
        frameAdmin.add(s1ConfermaGiocatoreButton2MM);

        s1AnnullaGiocatoreButton2MM = new JButton("Annulla2");
        s1AnnullaGiocatoreButton2MM.setBounds(580, 300, 90, 40);
        s1AnnullaGiocatoreButton2MM.setVisible(false);
        s1AnnullaGiocatoreButton2MM.setEnabled(false);
        s1AnnullaGiocatoreButton2MM.addActionListener(this);
        frameAdmin.add(s1AnnullaGiocatoreButton2MM);

        //Inserimento dataFine ex Militanza
        s1UltimaMilitanzaLabelMM = new JLabel();
        s1UltimaMilitanzaLabelMM.setBounds(10, 350, 300, 40);
        s1UltimaMilitanzaLabelMM.setVisible(false);
        frameAdmin.add(s1UltimaMilitanzaLabelMM);

        s1InserisciDataFineExMilitanzaLabelMM = new JLabel("Inserisci data fine della vecchia militanza");
        s1InserisciDataFineExMilitanzaLabelMM.setBounds(10, 350, 300, 40);
        s1InserisciDataFineExMilitanzaLabelMM.setVisible(false);
        frameAdmin.add(s1InserisciDataFineExMilitanzaLabelMM);

        s1InserisciDataFineExMilitanzaGiornoComboMM = new JComboBox(giorni);
        s1InserisciDataFineExMilitanzaGiornoComboMM.setBounds(350, 350, 50, 40);
        s1InserisciDataFineExMilitanzaGiornoComboMM.setVisible(false);
        frameAdmin.add(s1InserisciDataFineExMilitanzaGiornoComboMM);

        s1InserisciDataFineExMilitanzaMeseComboMM = new JComboBox(mesi);
        s1InserisciDataFineExMilitanzaMeseComboMM.setBounds(410, 350, 50, 40);
        s1InserisciDataFineExMilitanzaMeseComboMM.setVisible(false);
        frameAdmin.add(s1InserisciDataFineExMilitanzaMeseComboMM);

        s1InserisciDataFineExMilitanzaAnnoComboMM = new JComboBox(anni);
        s1InserisciDataFineExMilitanzaAnnoComboMM.setBounds(470, 350, 100, 40);
        s1InserisciDataFineExMilitanzaAnnoComboMM.setVisible(false);
        frameAdmin.add(s1InserisciDataFineExMilitanzaAnnoComboMM);

        //Inserimento dataInizio nuova Militanza
        s1InserisciDataInizioNuovaMilitanzaLabelMM = new JLabel("Inserisci data inizio della nuova militanza");
        s1InserisciDataInizioNuovaMilitanzaLabelMM.setBounds(10, 400, 300, 40);
        s1InserisciDataInizioNuovaMilitanzaLabelMM.setVisible(false);
        frameAdmin.add(s1InserisciDataInizioNuovaMilitanzaLabelMM);

        s1InserisciDataInizioNuovaMilitanzaGiornoComboMM = new JComboBox(giorni);
        s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setBounds(350, 400, 50, 40);
        s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setVisible(false);
        frameAdmin.add(s1InserisciDataInizioNuovaMilitanzaGiornoComboMM);

        s1InserisciDataInizioNuovaMilitanzaMeseComboMM = new JComboBox(mesi);
        s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setBounds(410, 400, 50, 40);
        s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setVisible(false);
        frameAdmin.add(s1InserisciDataInizioNuovaMilitanzaMeseComboMM);

        s1InserisciDataInizioNuovaMilitanzaAnnoComboMM = new JComboBox(anni);
        s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.setBounds(470, 400, 100, 40);
        s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.setVisible(false);
        frameAdmin.add(s1InserisciDataInizioNuovaMilitanzaAnnoComboMM);

        //Radio scelta fine militanza
        ModificaMilitanza = new ButtonGroup();
        s1MilitanzaInAttoRadioMM = new JRadioButton("Militanza ancora in atto");
        s1MilitanzaInAttoRadioMM.setBackground(Color.LIGHT_GRAY);
        s1MilitanzaInAttoRadioMM.setBounds(10, 450, 200, 40);
        s1MilitanzaInAttoRadioMM.setVisible(false);
        frameAdmin.add(s1MilitanzaInAttoRadioMM);
        ModificaMilitanza.add(s1MilitanzaInAttoRadioMM);

        s1MilitanzaFinitaRadioMM = new JRadioButton("Militanza Finita");
        s1MilitanzaFinitaRadioMM.setBounds(220, 450, 150, 40);
        s1MilitanzaFinitaRadioMM.setVisible(false);
        s1MilitanzaFinitaRadioMM.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(s1MilitanzaFinitaRadioMM);
        ModificaMilitanza.add(s1MilitanzaFinitaRadioMM);

        //bottoni conferma radio
        s1ConfermaFineMilitanzaButtonMM = new JButton("Ok");
        s1ConfermaFineMilitanzaButtonMM.setBounds(435, 450, 50, 40);
        s1ConfermaFineMilitanzaButtonMM.setVisible(false);
        s1ConfermaFineMilitanzaButtonMM.addActionListener(this);
        frameAdmin.add(s1ConfermaFineMilitanzaButtonMM);

        s1AnnullaFineMilitanzaButtonMM = new JButton("Indietro");
        s1AnnullaFineMilitanzaButtonMM.setBounds(505, 450, 80, 40);
        s1AnnullaFineMilitanzaButtonMM.setVisible(false);
        s1AnnullaFineMilitanzaButtonMM.setEnabled(false);
        s1AnnullaFineMilitanzaButtonMM.addActionListener(this);
        frameAdmin.add(s1AnnullaFineMilitanzaButtonMM);

        //Inserimento dataFine nuova Militanza
        s1InserisciDataFineNuovaMilitanzaLabelMM = new JLabel("Inserisci data fine della nuova militanza");
        s1InserisciDataFineNuovaMilitanzaLabelMM.setVisible(false);
        s1InserisciDataFineNuovaMilitanzaLabelMM.setBounds(10, 500, 300, 40);
        frameAdmin.add(s1InserisciDataFineNuovaMilitanzaLabelMM);

        s1InserisciDataFineNuovaMilitanzaGiornoComboMM = new JComboBox(giorni);
        s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setVisible(false);
        s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setBounds(350, 500, 50, 40);
        frameAdmin.add(s1InserisciDataFineNuovaMilitanzaGiornoComboMM);

        s1InserisciDataFineNuovaMilitanzaMeseComboMM = new JComboBox(mesi);
        s1InserisciDataFineNuovaMilitanzaMeseComboMM.setVisible(false);
        s1InserisciDataFineNuovaMilitanzaMeseComboMM.setBounds(410, 500, 50, 40);
        frameAdmin.add(s1InserisciDataFineNuovaMilitanzaMeseComboMM);

        s1InserisciDataFineNuovaMilitanzaAnnoComboMM = new JComboBox(anni);
        s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setBounds(470, 500, 100, 40);
        s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setVisible(false);
        frameAdmin.add(s1InserisciDataFineNuovaMilitanzaAnnoComboMM);

        //TiriSegnati, GoalSubiti, PartiteGiocate
        s1InserisciTiriSegnatiLabelMM = new JLabel("Goal Segnati");
        s1InserisciTiriSegnatiLabelMM.setBounds(10, 550, 100, 40);
        s1InserisciTiriSegnatiLabelMM.setVisible(false);
        frameAdmin.add(s1InserisciTiriSegnatiLabelMM);

        s1InserisciTiriSegnatiFieldMM = new JTextField();
        s1InserisciTiriSegnatiFieldMM.setBounds(10, 600, 80, 40);
        s1InserisciTiriSegnatiFieldMM.setVisible(false);
        frameAdmin.add(s1InserisciTiriSegnatiFieldMM);

        s1InserisciPartiteGiocateLabelMM = new JLabel("Partite Giocate");
        s1InserisciPartiteGiocateLabelMM.setBounds(125, 550, 100, 40);
        s1InserisciPartiteGiocateLabelMM.setVisible(false);
        frameAdmin.add(s1InserisciPartiteGiocateLabelMM);

        s1InserisciPartiteGiocateFieldMM = new JTextField();
        s1InserisciPartiteGiocateFieldMM.setBounds(125, 600, 80, 40);
        s1InserisciPartiteGiocateFieldMM.setVisible(false);
        frameAdmin.add(s1InserisciPartiteGiocateFieldMM);

        s1InserisciGoalSubitiLabelMM = new JLabel("Goal Subiti");
        s1InserisciGoalSubitiLabelMM.setVisible(false);
        s1InserisciGoalSubitiLabelMM.setBounds(265, 550, 100, 40);
        frameAdmin.add(s1InserisciGoalSubitiLabelMM);

        s1InserisciGoalSubitiFieldMM = new JTextField();
        s1InserisciGoalSubitiFieldMM.setVisible(false);
        s1InserisciGoalSubitiFieldMM.setBounds(265, 600, 80, 40);
        frameAdmin.add(s1InserisciGoalSubitiFieldMM);

        //seleziona squadra

        s1SelezionaSquadraLabelMM = new JLabel("Seleziona squadra");
        s1SelezionaSquadraLabelMM.setBounds(405, 550, 120, 40);
        s1SelezionaSquadraLabelMM.setVisible(false);
        frameAdmin.add(s1SelezionaSquadraLabelMM);

        s1SelezionaSquadraComboMM = new JComboBox(listaSquadre);
        s1SelezionaSquadraComboMM.setBounds(405, 600, 100, 40);
        s1SelezionaSquadraComboMM.setVisible(false);
        frameAdmin.add(s1SelezionaSquadraComboMM);

        s1ConfermaInserimentoMM = new JButton("Conferma Militanza");
        s1ConfermaInserimentoMM.setBounds(700, 400, 200, 70);
        s1ConfermaInserimentoMM.setVisible(false);
        s1ConfermaInserimentoMM.addActionListener(this);
        frameAdmin.add(s1ConfermaInserimentoMM);

        //MODIFICA CALCIATORE

        //seleziona calciatore

        s1SelezionaGiocatoreLabelMC = new JLabel("Seleziona Calciatore");
        s1SelezionaGiocatoreLabelMC.setVisible(false);
        s1SelezionaGiocatoreLabelMC.setBounds(10,250, 150, 40);
        frameAdmin.add(s1SelezionaGiocatoreLabelMC);


        s1SelezionaGiocatoreComboMC = new JComboBox();
        s1SelezionaGiocatoreComboMC.setVisible(false);
        s1SelezionaGiocatoreComboMC.setBounds(180, 250, 180, 40);
        frameAdmin.add(s1SelezionaGiocatoreComboMC);


        s1ConfermaGiocatoreButtonMC = new JButton("Conferma1");
        s1ConfermaGiocatoreButtonMC.setVisible(false);
        s1ConfermaGiocatoreButtonMC.addActionListener(this);
        s1ConfermaGiocatoreButtonMC.setBounds(435, 250, 120, 40);
        frameAdmin.add(s1ConfermaGiocatoreButtonMC);

        s1AnnullaGiocatoreButtonMC = new JButton("Annulla1");
        s1AnnullaGiocatoreButtonMC.addActionListener(this);
        s1AnnullaGiocatoreButtonMC.setVisible(false);
        s1AnnullaGiocatoreButtonMC.setBounds(580, 250, 90, 40);
        frameAdmin.add(s1AnnullaGiocatoreButtonMC);

        //SELEZIONA GIOCATORI UGUALI

        s1SceltaTraGiocatoriUgualiLabelMC = new JLabel("Seleziona calciatore tra questi");
        s1SceltaTraGiocatoriUgualiLabelMC.setVisible(false);
        s1SceltaTraGiocatoriUgualiLabelMC.setBounds(10, 300, 150, 40);
        frameAdmin.add(s1SceltaTraGiocatoriUgualiLabelMC);

        s1SceltaTraGiocatoriUgualiComboMC = new JComboBox();
        s1SceltaTraGiocatoriUgualiComboMC.setVisible(false);
        s1SceltaTraGiocatoriUgualiComboMC.setBounds(150, 300, 250, 40);
        frameAdmin.add(s1SceltaTraGiocatoriUgualiComboMC);


        s1ConfermaGiocatoreButton2MC = new JButton("Conferma2");
        s1ConfermaGiocatoreButton2MC.setVisible(false);
        s1ConfermaGiocatoreButton2MC.addActionListener(this);
        s1ConfermaGiocatoreButton2MC.setBounds(435, 300, 120, 40);
        frameAdmin.add(s1ConfermaGiocatoreButton2MC);

        s1AnnullaGiocatoreButton2MC = new JButton("Annulla2");
        s1AnnullaGiocatoreButton2MC.setVisible(false);
        s1AnnullaGiocatoreButton2MC.addActionListener(this);
        s1AnnullaGiocatoreButton2MC.setBounds(580, 300, 90, 40);
        frameAdmin.add(s1AnnullaGiocatoreButton2MC);

        //Scelta Data Ritiro
        radioMC = new ButtonGroup();

        s1DataRitiroLabelMC = new JLabel("Vuoi inserire la data ritiro?");
        s1DataRitiroLabelMC.setBounds(10, 350, 250, 40);
        s1DataRitiroLabelMC.setVisible(false);
        frameAdmin.add(s1DataRitiroLabelMC);

        s1InserireDataRitiroRadioMC = new JRadioButton("Si");
        s1InserireDataRitiroRadioMC.setVisible(false);
        s1InserireDataRitiroRadioMC.setBounds(10, 400, 50, 40);
        s1InserireDataRitiroRadioMC.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(s1InserireDataRitiroRadioMC);

        s1NonInserireDataRitiroRadioMC = new JRadioButton("No ");
        s1NonInserireDataRitiroRadioMC.setBounds(70, 400, 50, 40);
        s1NonInserireDataRitiroRadioMC.setVisible(false);
        s1NonInserireDataRitiroRadioMC.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(s1NonInserireDataRitiroRadioMC);
        radioMC.add(s1InserireDataRitiroRadioMC);
        radioMC.add(s1NonInserireDataRitiroRadioMC);

        s1ConfermaSceltaRitiroButtonMC = new JButton("Ok");
        s1ConfermaSceltaRitiroButtonMC.setBounds(150, 400, 50, 40);
        s1ConfermaSceltaRitiroButtonMC.setVisible(false);
        s1ConfermaSceltaRitiroButtonMC.addActionListener(this);
        frameAdmin.add(s1ConfermaSceltaRitiroButtonMC);

        s1AnnullaSceltaRitiroButtonMC = new JButton("Annulla");
        s1AnnullaSceltaRitiroButtonMC.setBounds(210, 400, 100, 40);
        s1AnnullaSceltaRitiroButtonMC.setVisible(false);
        s1AnnullaSceltaRitiroButtonMC.addActionListener(this);
        frameAdmin.add(s1AnnullaSceltaRitiroButtonMC);

        s1DataRitiroGiornoComboMC = new JComboBox(anni);
        s1DataRitiroGiornoComboMC.setBounds(10, 450, 50, 40);
        s1DataRitiroGiornoComboMC.setVisible(false);
        frameAdmin.add(s1DataRitiroGiornoComboMC);

        s1DataRitiroMeseComboMC = new JComboBox(mesi);
        s1DataRitiroMeseComboMC.setVisible(false);
        s1DataRitiroMeseComboMC.setBounds(70, 450, 50, 40);
        frameAdmin.add(s1DataRitiroMeseComboMC);

        s1DataRitiroAnnoComboMC = new JComboBox(anni);
        s1DataRitiroAnnoComboMC.setVisible(false);
        s1DataRitiroAnnoComboMC.setBounds(130, 450, 100, 40);
        frameAdmin.add(s1DataRitiroAnnoComboMC);

        //feature caratteristiche;
        s1InserisciFeatureLabelMC = new JLabel("Scegli feature");
        s1InserisciFeatureLabelMC.setBounds(10, 500, 100, 40);
        s1InserisciFeatureLabelMC.setVisible(false);
        frameAdmin.add(s1InserisciFeatureLabelMC);

        s1InserisciFeatureComboMC = new JComboBox();
        s1InserisciFeatureComboMC.setVisible(false);
        s1InserisciFeatureComboMC.setBounds(10, 550, 150, 40);
        frameAdmin.add(s1InserisciFeatureComboMC);

        s1ConfermaInserimentoMC = new JButton("Conferma Modifica");
        s1ConfermaInserimentoMC.setBounds(700, 400, 200, 70);
        s1ConfermaInserimentoMC.setVisible(false);
        s1ConfermaInserimentoMC.addActionListener(this);
        frameAdmin.add(s1ConfermaInserimentoMC);

        ////////////////////////
        //Inserisci squadra in competizione

        //Seleziona competizione
        s1ScegliCompetizioneLabelISIC = new JLabel("Seleziona competizione");
        s1ScegliCompetizioneLabelISIC.setBounds(10, 250, 150, 40);
        s1ScegliCompetizioneLabelISIC.setVisible(false);
        frameAdmin.add(s1ScegliCompetizioneLabelISIC);

        s1AnnoCompetizioneLabelISIC = new JLabel("Seleziona anno");
        s1AnnoCompetizioneLabelISIC.setBounds(225, 250, 150, 40);
        s1AnnoCompetizioneLabelISIC.setVisible(false);
        frameAdmin.add(s1AnnoCompetizioneLabelISIC);

        s1AnnoCompetizioneComboISIC = new JComboBox();
        s1AnnoCompetizioneComboISIC.setBounds(225, 300, 100, 40);
        s1AnnoCompetizioneComboISIC.setVisible(false);
        frameAdmin.add(s1AnnoCompetizioneComboISIC);



        s1ScegliCompetizioneComboISIC = new JComboBox();
        s1ScegliCompetizioneComboISIC.setVisible(false);
        s1ScegliCompetizioneComboISIC.setBounds(10, 300, 150, 40);
        frameAdmin.add(s1ScegliCompetizioneComboISIC);

        //Tasto conferma/annulla
        s1ConfermaCompetizioneButtonISIC = new JButton("Ok");
        s1ConfermaCompetizioneButtonISIC.setVisible(false);
        s1ConfermaCompetizioneButtonISIC.setBounds(10, 350, 60, 40);
        s1ConfermaCompetizioneButtonISIC.addActionListener(this);
        frameAdmin.add(s1ConfermaCompetizioneButtonISIC);

        s1AnnullaCompetizioneButtonISIC = new JButton("Annulla");
        s1AnnullaCompetizioneButtonISIC.setVisible(false);
        s1AnnullaCompetizioneButtonISIC.addActionListener(this);
        s1AnnullaCompetizioneButtonISIC.setBounds(90, 350, 100, 40);
        frameAdmin.add(s1AnnullaCompetizioneButtonISIC);

        //seleziona Squadra
        s1SelezionaSquadraLabelISIC = new JLabel("Seleziona squadra");
        s1SelezionaSquadraLabelISIC.setBounds(10, 400, 150, 40);
        s1SelezionaSquadraLabelISIC.setVisible(false);
        frameAdmin.add(s1SelezionaSquadraLabelISIC);

        s1SelezionaSquadraComboISIC = new JComboBox();
        s1SelezionaSquadraComboISIC.setBounds(10, 450, 150, 40);
        s1SelezionaSquadraComboISIC.setVisible(false);
        frameAdmin.add(s1SelezionaSquadraComboISIC);

        s1ConfermaInserimentoISIC = new JButton("Conferma Inserimento");
        s1ConfermaInserimentoISIC.setBounds(700, 400, 200, 70);
        s1ConfermaInserimentoISIC.setVisible(false);
        s1ConfermaInserimentoISIC.addActionListener(this);
        frameAdmin.add(s1ConfermaInserimentoISIC);

        //ASSEGNA TROFEO

        //scelta trofeo
        s1SelezionaTipoTrofeoLabelAT = new JLabel("Seleziona tipo trofeo");
        s1SelezionaTipoTrofeoLabelAT.setBounds(10, 250, 140, 40);
        s1SelezionaTipoTrofeoLabelAT.setVisible(false);
        frameAdmin.add(s1SelezionaTipoTrofeoLabelAT);

        s1TrofeoSquadraRadioAT = new JRadioButton("Trofeo di Squadra");
        s1TrofeoSquadraRadioAT.setVisible(false);
        s1TrofeoSquadraRadioAT.setBackground(Color.LIGHT_GRAY);
        s1TrofeoSquadraRadioAT.setBounds(150, 250, 140, 40);
        frameAdmin.add(s1TrofeoSquadraRadioAT);

        s1TrofeoIndividualeRadioAT = new JRadioButton("Trofeo Individuale");
        s1TrofeoIndividualeRadioAT.setVisible(false);
        s1TrofeoIndividualeRadioAT.setBackground(Color.LIGHT_GRAY);
        s1TrofeoIndividualeRadioAT.setBounds(300, 270, 140, 40);
        frameAdmin.add(s1TrofeoIndividualeRadioAT);

        groupAT = new ButtonGroup();
        groupAT.add(s1TrofeoIndividualeRadioAT);
        groupAT.add(s1TrofeoSquadraRadioAT);

        //CONFERMA/ANNULLA SCELTA 1
        s1ConfermaSceltaTrofeoButtonAT = new JButton("OK");
        s1ConfermaSceltaTrofeoButtonAT.setBounds(10, 300, 60, 40);
        s1ConfermaSceltaTrofeoButtonAT.setVisible(false);
        s1ConfermaSceltaTrofeoButtonAT.addActionListener(this);
        frameAdmin.add(s1ConfermaSceltaTrofeoButtonAT);

        s1AnnullaSceltaTrofeoButtonAT = new JButton("Annulla");
        s1AnnullaSceltaTrofeoButtonAT.setVisible(false);
        s1AnnullaSceltaTrofeoButtonAT.setBounds(80, 300, 100, 40);
        s1AnnullaSceltaTrofeoButtonAT.addActionListener(this);
        frameAdmin.add(s1AnnullaSceltaTrofeoButtonAT);

        //SLEZIONA TROFEO
        s1SelezionaTrofeoLabelAT = new JLabel("Scegli il trofeo da assegnare");
        s1SelezionaTrofeoLabelAT.setBounds(10, 350, 200, 40);
        s1SelezionaTrofeoLabelAT.setVisible(false);
        frameAdmin.add(s1SelezionaTrofeoLabelAT);

        s1SelezionaTrofeoComboAT = new JComboBox();
        s1SelezionaTrofeoComboAT.setVisible(false);
        s1SelezionaTrofeoComboAT.setBounds(10, 400, 150, 40);
        frameAdmin.add(s1SelezionaTrofeoComboAT);

        //SCELTA ANNO
        s1SceltaAnnoAssegnazioneLabelAT = new JLabel("Seleziona l'anno della vincita");
        s1SceltaAnnoAssegnazioneLabelAT.setBounds(250, 350, 200, 40);
        s1SceltaAnnoAssegnazioneLabelAT.setVisible(false);
        frameAdmin.add(s1SceltaAnnoAssegnazioneLabelAT);

        s1SceltaAnnoAssegnazioneComboAT = new JComboBox();
        s1SceltaAnnoAssegnazioneComboAT.setBounds(250, 400, 100, 40);
        s1SceltaAnnoAssegnazioneComboAT.setVisible(false);
        frameAdmin.add(s1SceltaAnnoAssegnazioneComboAT);

        //CONFERMA/ANNULLA 2

        s1ConfermaSceltaTrofeo2ButtonAT = new JButton("Ok");
        s1ConfermaSceltaTrofeo2ButtonAT.setBounds(10, 450, 60, 40);
        s1ConfermaSceltaTrofeo2ButtonAT.setVisible(false);
        s1ConfermaSceltaTrofeo2ButtonAT.addActionListener(this);
        frameAdmin.add(s1ConfermaSceltaTrofeo2ButtonAT);

        s1AnnullaSceltaTrofeo2ButtonAT = new JButton("Annulla");
        s1AnnullaSceltaTrofeo2ButtonAT.setBounds(80, 450, 110, 40);
        s1AnnullaSceltaTrofeo2ButtonAT.setVisible(false);
        s1AnnullaSceltaTrofeo2ButtonAT.addActionListener(this);
        frameAdmin.add(s1AnnullaSceltaTrofeo2ButtonAT);

        //SCELTRA TRA IDONEEI
        s1ScegliTraIdoneiLabelAT = new JLabel("Scegli a chi assegnare il trofeo");
        s1ScegliTraIdoneiLabelAT.setVisible(false);
        s1ScegliTraIdoneiLabelAT.setBounds(10, 550, 150, 40);
        frameAdmin.add(s1ScegliTraIdoneiLabelAT);

        s1ScegliTraIdoneiComboAT = new JComboBox();
        s1ScegliTraIdoneiComboAT.setVisible(false);
        s1ScegliTraIdoneiComboAT.setBounds(10, 600, 150, 40);
        frameAdmin.add(s1ScegliTraIdoneiComboAT);

        //SCELTA TRA IDONEI UGUALI
        s1ScegliTraIdoneiUgualiLabelAT = new JLabel("Scegli quale tra questi");
        s1ScegliTraIdoneiUgualiLabelAT.setVisible(false);
        s1ScegliTraIdoneiUgualiLabelAT.setBounds(250, 550, 150, 40);
        frameAdmin.add(s1ScegliTraIdoneiUgualiLabelAT);

        s1ScegliTraIdoneiUgualiComboAT = new JComboBox();
        s1ScegliTraIdoneiUgualiComboAT.setVisible(false);
        s1ScegliTraIdoneiUgualiComboAT.setBounds(250, 600, 200, 40);
        frameAdmin.add(s1ScegliTraIdoneiUgualiComboAT);

        s1ConfermaInserimentoAT = new JButton("Conferma Assegnazione");
        s1ConfermaInserimentoAT.setBounds(700, 400, 200, 70);
        s1ConfermaInserimentoAT.setVisible(false);
        s1ConfermaInserimentoAT.addActionListener(this);
        frameAdmin.add(s1ConfermaInserimentoAT);


        //step1 Modifica
        String[] opzStep1Edit = {"Modifica militanza giocatore", "Modifica giocatore", "Assegna trofeo"};
        step1Modifica = new JComboBox(opzStep1Edit);
        step1Modifica.setVisible(false);
        step1Modifica.setBounds(400, 150, 200, 40);
        frameAdmin.add(step1Modifica);

        step1ToStep2Modifica.setVisible(false);
        step1ToStep2Modifica.setBounds(625, 150, 80, 40);
        step1ToStep2Modifica.addActionListener(this);
        frameAdmin.add(step1ToStep2Modifica);

        step1LabelModifica.setVisible(false);
        step1LabelModifica.setBounds(425, 110, 200, 40);
        step1LabelModifica.setFont(new Font("Consolas", Font.PLAIN, 14));
        frameAdmin.add(step1LabelModifica);


        frameAdmin.add(logoSito);
        frameAdmin.add(logoFedericoII);
        frameAdmin.setLayout(null);
        frameAdmin.setVisible(true);
        frameAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAdmin.setSize(1000, 800);
        frameAdmin.setResizable(false);
        frameAdmin.getContentPane().setBackground(Color.LIGHT_GRAY);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == inserisci) {
            inserisci.setEnabled(false);
            modifica.setEnabled(false);
            step1Inserisci.setVisible(true);
            step1LabelInserisci.setVisible(true);
            goToStep1.setVisible(true);
            String intoStep2 = (String) step1Inserisci.getSelectedItem();
        }
        /////////////////////////////
        //CONTROLLO COSA è STATO SCELTO NELLA COMBO BOX DI INSERISCI
        if (e.getSource() == goToStep1) {
            String intoStep2 = (String) step1Inserisci.getSelectedItem();

            if (intoStep2 != null && intoStep2.equals("Inserisci giocatore")) {
                annulla.setVisible(true);
                step1Inserisci_Giocatore_NomeLabel.setVisible(true);
                step1Inserisci_Giocatore_NomeField.setVisible(true);
                step1Inserisci_Giocatore_CognomeLabel.setVisible(true);
                step1Inserisci_Giocatore_CognomeField.setVisible(true);
                portiere.setVisible(true);
                difensore.setVisible(true);
                centrocampista.setVisible(true);
                attaccante.setVisible(true);
                ruoloLabel.setVisible(true);
                step1Inserisci_DataRitiroLabel.setVisible(true);
                step1InserireDataRitiroRadioIG.setVisible(true);
                step1NonInserireDataRitiroRadioIG.setVisible(true);
                step1Inserisci_NazionalitaCombo.setVisible(true);
                step1Inserisci_NazionalitaLabel.setVisible(true);
                step1Inserisci_DataDiNascitaLabel.setVisible(true);
                avantiToStep2InserisciGiocatore.setVisible(true);
                step1Giorno.setVisible(true);
                step1Mese.setVisible(true);
                step1Anno.setVisible(true);
                step1PiedePRLabel.setVisible(true);
                step1PiedePRCombo.setVisible(true);
                step1annullaDataRitiroButtonIG.setVisible(true);
                step1annullaDataRitiroButtonIG.setEnabled(false);
                step1confermaDataRitiroButtonIG.setVisible(true);
                step2confermaFineMilitanzaButton.setEnabled(true);
                step2annullaFineMilitanzaButton.setEnabled(false);


                goToStep1.setEnabled(false);
                step1Inserisci.setEnabled(false);
            } else if (intoStep2 != null && intoStep2.equals("Inserisci competizione")) {
                annulla.setVisible(true);
                goToStep1.setEnabled(false);
                step1Inserisci.setEnabled(false);

                s1InserisciNomeCompLabelIC.setVisible(true);
                s1InserisciNomeCompFieldIC.setVisible(true);
                s1AnnoCompLabelIC.setVisible(true);
                s1AnnoCompComboIC.setVisible(true);
                s1nomeTrofeoLabelIC.setVisible(true);
                s1nomeTrofeoFieldIC.setVisible(true);
                s1annoFineCompLabelIC.setVisible(true);
                s1AnnoFineCompComboIC.setVisible(true);
                s1SelezionaTipoCompetizioneLabelIC.setVisible(true);
                s1NazionaleIC.setVisible(true);
                s1InternazionaleIC.setVisible(true);
                s1ConfermaCompIC.setVisible(true);
                s1AnnullaCompIC.setVisible(true);
                s1AnnullaCompIC.setEnabled(false);

            } else if (intoStep2 != null && intoStep2.equals("Inserisci squadra")) {
                annulla.setVisible(true);
                goToStep1.setEnabled(false);
                step1Inserisci.setEnabled(false);

                s1NomeSquadraLabelIS.setVisible(true);
                s1NomeSquadraFieldIS.setVisible(true);
                s1NazionalitaLabelIS.setVisible(true);
                s1NazionalitaComboIS.setVisible(true);
                s1InserisciSponsorTecLabelIS.setVisible(true);
                s1InserisciSponsorTecFieldIS.setVisible(true);
                s1ConfermaIS.setVisible(true);

            } else if (intoStep2 != null && intoStep2.equals("Inserisci sponsor secondari")){
                annulla.setVisible(true);
                goToStep1.setEnabled(false);
                step1Inserisci.setEnabled(false);

                s1CercaSquadraLabelSS.setVisible(true);
                s1CercaSquadraComboSS.setVisible(true);
                s1ConfermaSquadraButtonSS.setVisible(true);
                s1AnnullaSquadraButtonSS.setVisible(false);
                s1AnnullaSquadraButtonSS.setEnabled(false);

            } else if (intoStep2 != null && intoStep2.equals("Inserisci squadra in competizione")) {
                annulla.setVisible(true);
                goToStep1.setEnabled(false);
                step1Inserisci.setEnabled(false);

                s1ScegliCompetizioneLabelISIC.setVisible(true);
                s1ScegliCompetizioneComboISIC.setVisible(true);
                s1AnnoCompetizioneLabelISIC.setVisible(true);
                s1AnnoCompetizioneComboISIC.setVisible(true);
                s1AnnoCompetizioneComboISIC.removeAllItems();
                s1ScegliCompetizioneComboISIC.removeAllItems();

                String[] listaCompetizioni = new String[0];
                String competizioniString = controller.prendiCompetizioni();
                listaCompetizioni = (competizioniString != null) ? competizioniString.split("_") : new String[0];
                for (String giocatore : listaCompetizioni) {
                    s1ScegliCompetizioneComboISIC.addItem(giocatore);
                }

                s1ScegliCompetizioneComboISIC.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {

                        if(e.getStateChange()==ItemEvent.SELECTED) {
                            String comp = s1ScegliCompetizioneComboISIC.getSelectedItem().toString();

                            s1AnnoCompetizioneComboISIC.removeAllItems();

                            String[] listaAnni = new String[0];
                            try {
                                String AnniString = controller.prendiAnni(comp);
                                listaAnni = (AnniString != null) ? AnniString.split(",") : new String[0];
                            } catch (SQLException et) {
                                throw new RuntimeException(et);
                            }
                            for (String giocatore : listaAnni) {
                                s1AnnoCompetizioneComboISIC.addItem(giocatore);
                            }
                        }
                    }
                });

                System.out.println("ciao");
                s1ConfermaCompetizioneButtonISIC.setEnabled(true);
                s1ConfermaCompetizioneButtonISIC.setVisible(true);
                s1AnnullaCompetizioneButtonISIC.setVisible(true);
                s1AnnullaCompetizioneButtonISIC.setEnabled(false);
            }
        }
        if(e.getSource() == step1ToStep2Modifica) {

            String intoStep2 = (String) step1Modifica.getSelectedItem();


            if (intoStep2 != null && intoStep2.equals("Modifica militanza giocatore")) {

                annulla.setVisible(true);
                step1ToStep2Modifica.setEnabled(false);
                step1Inserisci.setEnabled(false);

                String[] listaGiocatori = new String[0];
                try {
                    String giocatoriString = controller.prendiGiocatori();
                    listaGiocatori = (giocatoriString != null) ? giocatoriString.split(",") : new String[0];
                } catch (SQLException et) {
                    throw new RuntimeException(et);
                }
                for (String giocatore : listaGiocatori) {
                    s1SelezionaGiocatoreComboMM.addItem(giocatore);
                }
                s1SelezionaGiocatoreLabelMM.setVisible(true);
                s1SelezionaGiocatoreComboMM.setVisible(true);
                s1ConfermaGiocatoreButtonMM.setVisible(true);
                s1AnnullaGiocatoreButtonMM.setVisible(true);
            } else if (intoStep2 != null && intoStep2.equals("Modifica giocatore")) {
                annulla.setVisible(true);
                step1ToStep2Modifica.setEnabled(false);
                step1Inserisci.setEnabled(false);

                s1SelezionaGiocatoreLabelMC.setVisible(true);
                s1SelezionaGiocatoreComboMC.setVisible(true);

                String[] listaGiocatori = new String[0];
                try {
                    String giocatoriString = controller.prendiGiocatori();
                    listaGiocatori = (giocatoriString != null) ? giocatoriString.split(",") : new String[0];
                } catch (SQLException et) {
                    throw new RuntimeException(et);
                }
                for (String giocatore : listaGiocatori) {
                    s1SelezionaGiocatoreComboMC.addItem(giocatore);
                }
                s1ConfermaGiocatoreButtonMC.setVisible(true);
                s1AnnullaGiocatoreButtonMC.setVisible(true);
                s1AnnullaGiocatoreButtonMC.setEnabled(false);
            } else if (intoStep2 != null && intoStep2.equals("Assegna trofeo")) {
                annulla.setVisible(true);
                step1ToStep2Modifica.setEnabled(false);
                step1Inserisci.setEnabled(false);

                s1SelezionaTipoTrofeoLabelAT.setVisible(true);
                s1TrofeoSquadraRadioAT.setVisible(true);
                s1TrofeoSquadraRadioAT.setEnabled(true);
                s1TrofeoIndividualeRadioAT.setVisible(true);
                s1TrofeoIndividualeRadioAT.setEnabled(true);
                s1ConfermaSceltaTrofeoButtonAT.setVisible(true);
                s1ConfermaSceltaTrofeoButtonAT.setEnabled(true);
                s1AnnullaSceltaTrofeoButtonAT.setVisible(true);
                s1AnnullaSceltaTrofeoButtonAT.setEnabled(false);
            }
        }
        //conferma 1 AT
        if(e.getSource()==s1ConfermaSceltaTrofeoButtonAT) {
            if(s1TrofeoIndividualeRadioAT.isSelected()) {
                //TROFEO INDIVIDUALE
                s3confermaErroreLabelIG.setVisible(false);
                s1TrofeoIndividualeRadioAT.setEnabled(false);
                s1TrofeoSquadraRadioAT.setEnabled(false);
                s1ConfermaSceltaTrofeoButtonAT.setEnabled(false);
                s1AnnullaSceltaTrofeoButtonAT.setEnabled(true);
                s1SelezionaTrofeoLabelAT.setVisible(true);
                s1SelezionaTrofeoComboAT.setVisible(true);
                s1SelezionaTipoTrofeoLabelAT.setVisible(true);
                s1SelezionaTrofeoComboAT.removeAllItems();
                s1ConfermaInserimentoAT.setVisible(false);
                s1ConfermaSceltaTrofeo2ButtonAT.setVisible(true);
                s1ConfermaSceltaTrofeo2ButtonAT.setEnabled(true);
                s1AnnullaSceltaTrofeo2ButtonAT.setVisible(true);
                s1AnnullaSceltaTrofeo2ButtonAT.setEnabled(false);
                s1SelezionaTrofeoComboAT.removeAll();

                String[] listaTrofeoIndividuali = new String[0];
                try {
                    s3confermaErroreLabelIG.setVisible(false);
                    String trofeiIndividualiString = controller.prendiTrofeiIndividuali();
                    listaTrofeoIndividuali = (trofeiIndividualiString != null) ? trofeiIndividualiString.split(",") : new String[0];
                } catch (SQLException et) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("Non ci sono trofei Individuali");
                    throw new RuntimeException(et);
                }
                s1SelezionaTrofeoComboAT.removeAllItems();
                for (String giocatore : listaTrofeoIndividuali) {
                    s1SelezionaTrofeoComboAT.addItem(giocatore);
                }


                s1SelezionaTrofeoComboAT.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        s1SceltaAnnoAssegnazioneLabelAT.setVisible(true);
                        s1SceltaAnnoAssegnazioneComboAT.setVisible(true);
                        s1SceltaAnnoAssegnazioneComboAT.removeAllItems();
                        s1ScegliTraIdoneiLabelAT.setVisible(false);
                        s1ScegliTraIdoneiComboAT.setVisible(false);
                        s1ScegliTraIdoneiUgualiLabelAT.setVisible(false);
                        s1ScegliTraIdoneiUgualiComboAT.setVisible(false);
                        s1ConfermaInserimentoAT.setVisible(false);


                        String[] listaAnni = new String[0];
                        try {
                            String anniString = controller.prendiAnniTrofeo(s1SelezionaTrofeoComboAT.getSelectedItem().toString());
                            System.out.println(anniString);
                            listaAnni = (anniString != null) ? anniString.split(",") : new String[0];
                        } catch (SQLException et) {
                            s3confermaErroreLabelIG.setVisible(true);
                            s3confermaErroreLabelIG.setText("problemi");
                        }
                        for (String giocatore : listaAnni) {
                            s1SceltaAnnoAssegnazioneComboAT.addItem(giocatore);
                        }
                    }
                });


            } else if (s1TrofeoSquadraRadioAT.isSelected()) {
                //TROFEO SQUARDA
                s3confermaErroreLabelIG.setVisible(false);
                s1TrofeoIndividualeRadioAT.setEnabled(false);
                s1TrofeoSquadraRadioAT.setEnabled(false);
                s1ConfermaSceltaTrofeoButtonAT.setEnabled(false);
                s1AnnullaSceltaTrofeoButtonAT.setEnabled(true);
                s1SelezionaTrofeoLabelAT.setVisible(true);
                s1SelezionaTrofeoComboAT.setVisible(true);
                s1SelezionaTipoTrofeoLabelAT.setVisible(true);
                s1SelezionaTrofeoComboAT.removeAllItems();
                s1ConfermaInserimentoAT.setVisible(false);
                s1ConfermaSceltaTrofeo2ButtonAT.setVisible(true);
                s1ConfermaSceltaTrofeo2ButtonAT.setEnabled(true);
                s1AnnullaSceltaTrofeo2ButtonAT.setVisible(true);
                s1AnnullaSceltaTrofeo2ButtonAT.setEnabled(false);
                s1SelezionaTrofeoComboAT.removeAll();

                String[] listaTrofeiSquadra = new String[0];
                try {
                    s3confermaErroreLabelIG.setVisible(false);
                    String trofeiSquadraString = controller.prendiTrofeiSquadra();
                    listaTrofeiSquadra = (trofeiSquadraString != null) ? trofeiSquadraString.split(",") : new String[0];
                } catch (SQLException et) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("Non ci sono trofei Individuali");
                    throw new RuntimeException(et);
                }
                for (String giocatore : listaTrofeiSquadra) {
                    s1SelezionaTrofeoComboAT.addItem(giocatore);
                }


                s1SelezionaTrofeoComboAT.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        s1SceltaAnnoAssegnazioneLabelAT.setVisible(true);
                        s1SceltaAnnoAssegnazioneComboAT.setVisible(true);
                        s1SceltaAnnoAssegnazioneComboAT.removeAllItems();
                        s1ScegliTraIdoneiLabelAT.setVisible(false);
                        s1ScegliTraIdoneiComboAT.setVisible(false);
                        s1ScegliTraIdoneiUgualiLabelAT.setVisible(false);
                        s1ScegliTraIdoneiUgualiComboAT.setVisible(false);
                        s1ConfermaInserimentoAT.setVisible(false);


                        String[] listaAnni = new String[0];
                        try {
                            String anniString = controller.prendiAnniTrofeo(s1SelezionaTrofeoComboAT.getSelectedItem().toString());
                            System.out.println(anniString);
                            listaAnni = (anniString != null) ? anniString.split(",") : new String[0];
                        } catch (SQLException et) {
                            s3confermaErroreLabelIG.setVisible(true);
                            s3confermaErroreLabelIG.setText("problemi");
                        }
                        for (String giocatore : listaAnni) {
                            s1SceltaAnnoAssegnazioneComboAT.addItem(giocatore);
                        }
                    }
                });
            } else {
                s3confermaErroreLabelIG.setVisible(true);
                s3confermaErroreLabelIG.setText("Scegliere tipo di trofeo");
            }
        }
        //ANNULLA 1 AT
        if(e.getSource() == s1AnnullaSceltaTrofeoButtonAT) {
            s3confermaErroreLabelIG.setVisible(false);
            s1TrofeoIndividualeRadioAT.setEnabled(true);
            s1TrofeoSquadraRadioAT.setEnabled(true);
            s1ConfermaSceltaTrofeoButtonAT.setEnabled(true);
            s1AnnullaSceltaTrofeoButtonAT.setEnabled(false);
            s1SelezionaTrofeoLabelAT.setVisible(false);
            s1SelezionaTrofeoComboAT.setVisible(false);
            s1SelezionaTipoTrofeoLabelAT.setVisible(false);
            s1SelezionaTrofeoComboAT.removeAllItems();
            s1ConfermaInserimentoAT.setVisible(false);
            s1ConfermaSceltaTrofeo2ButtonAT.setVisible(false);
            s1ConfermaSceltaTrofeo2ButtonAT.setEnabled(true);
            s1AnnullaSceltaTrofeo2ButtonAT.setVisible(false);
            s1AnnullaSceltaTrofeo2ButtonAT.setEnabled(false);
        }

        //CONFERMA 2 AT
        if(e.getSource() == s1ConfermaSceltaTrofeo2ButtonAT) {
            if(!s1SceltaAnnoAssegnazioneComboAT.getSelectedItem().toString().isEmpty()){
                s3confermaErroreLabelIG.setVisible(false);
                s1AnnullaSceltaTrofeoButtonAT.setEnabled(false);
                s1SelezionaTrofeoComboAT.setEnabled(false);
                s1SceltaAnnoAssegnazioneComboAT.setEnabled(false);
                s1ConfermaSceltaTrofeo2ButtonAT.setEnabled(false);
                s1AnnullaSceltaTrofeo2ButtonAT.setEnabled(true);

                s1ScegliTraIdoneiLabelAT.setVisible(true);
                s1ScegliTraIdoneiComboAT.setVisible(true);

                if (s1TrofeoIndividualeRadioAT.isSelected()) {

                    String[] listaGiocatoriIdonei = new String[0];
                    try {

                        int anno = Integer.parseInt(s1SceltaAnnoAssegnazioneComboAT.getSelectedItem().toString());
                        s3confermaErroreLabelIG.setVisible(false);
                        String trofeiGiocatoriIdoneiString = controller.prendiGiocatoriValidi(anno);
                        listaGiocatoriIdonei = (trofeiGiocatoriIdoneiString != null) ? trofeiGiocatoriIdoneiString.split(",") : new String[0];
                    } catch (SQLException et) {
                        s3confermaErroreLabelIG.setVisible(true);
                        s3confermaErroreLabelIG.setText("Non ci sono trofei Individuali");
                        throw new RuntimeException(et);
                    }
                    for (String giocatore : listaGiocatoriIdonei) {
                        s1ScegliTraIdoneiComboAT.addItem(giocatore);
                    }

                    s1ScegliTraIdoneiComboAT.removeAll();
                    s1ScegliTraIdoneiComboAT.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            s1ScegliTraIdoneiUgualiComboAT.removeAllItems();
                            s1ScegliTraIdoneiUgualiComboAT.setVisible(false);
                            s1ScegliTraIdoneiUgualiLabelAT.setVisible(false);

                            String nome = null;
                            String cognome = null;

                            try {
                                String[] partiNomeCognome = s1ScegliTraIdoneiComboAT.getSelectedItem().toString().split(" ");

                                nome = partiNomeCognome[0];
                                cognome = partiNomeCognome[1];

                                try {
                                    String[] giocatoriUgualiArray;
                                    s3confermaErroreLabelIG.setVisible(false);
                                    String giocatoriUgualiString = controller.prendiGiocatoriUgualiDalDB(nome, cognome);
                                    giocatoriUgualiArray = (giocatoriUgualiString != null) ? giocatoriUgualiString.split(",") : new String[0];

                                    System.out.println(giocatoriUgualiArray.length);

                                    if (giocatoriUgualiArray.length <= 1) {
                                        s1ScegliTraIdoneiUgualiComboAT.removeAllItems();
                                        s1ScegliTraIdoneiUgualiComboAT.setVisible(false);
                                        s1ConfermaInserimentoAT.setVisible(true);

                                    } else if(giocatoriUgualiArray.length > 1) {

                                        s1ConfermaInserimentoAT.setVisible(false);
                                        s1ScegliTraIdoneiUgualiComboAT.setVisible(true);
                                        s1ScegliTraIdoneiUgualiLabelAT.setVisible(true);

                                        for (String giocatore : giocatoriUgualiArray) {
                                            s1ScegliTraIdoneiUgualiComboAT.addItem(giocatore);
                                        }
                                        System.out.println("t");
                                        s1ConfermaInserimentoAT.setVisible(true);
                                    }
                                } catch (SQLException et) {
                                    s3confermaErroreLabelIG.setVisible(true);
                                    s3confermaErroreLabelIG.setText("Non ci sono trofei Individuali");
                                    throw new RuntimeException(et);
                                }
                            } catch (NullPointerException eq) {

                            }
                        }
                    });
                } else {
                    String[] listaSquadraIdonee = new String[0];
                    try {

                        int anno = Integer.parseInt(s1SceltaAnnoAssegnazioneComboAT.getSelectedItem().toString());
                        s3confermaErroreLabelIG.setVisible(false);
                        String listaSquadraIdoneeString = controller.prendiSquadreIdoneePerTrofeo(anno, s1SelezionaTrofeoComboAT.getSelectedItem().toString());
                        listaSquadraIdonee = (listaSquadraIdoneeString != null) ? listaSquadraIdoneeString.split(",") : new String[0];
                    } catch (SQLException et) {
                        s3confermaErroreLabelIG.setVisible(true);
                        s3confermaErroreLabelIG.setText("Non ci sono trofei Individuali");
                        throw new RuntimeException(et);
                    }
                    for (String giocatore : listaSquadraIdonee) {
                        s1ScegliTraIdoneiComboAT.addItem(giocatore);
                    }

                    s1ScegliTraIdoneiComboAT.removeAll();
                    s1ConfermaInserimentoAT.setVisible(true);
                }
            } else {
                s3confermaErroreLabelIG.setVisible(true);
                s3confermaErroreLabelIG.setText("Selezionare anno");
            }
        }
        //ANNULLA 2 AT
        if(e.getSource() == s1AnnullaSceltaTrofeo2ButtonAT) {
            s1ConfermaInserimentoAT.setVisible(false);
            s1ScegliTraIdoneiComboAT.setVisible(false);
            s1ScegliTraIdoneiComboAT.removeAll();
            s1ScegliTraIdoneiLabelAT.setVisible(false);
            s1ScegliTraIdoneiUgualiComboAT.setVisible(false);
            s1ScegliTraIdoneiUgualiComboAT.removeAll();
            s1ScegliTraIdoneiUgualiLabelAT.setVisible(false);
            s1AnnullaSceltaTrofeo2ButtonAT.setEnabled(false);
            s1ConfermaSceltaTrofeo2ButtonAT.setEnabled(true);
            s1SelezionaTrofeoComboAT.setEnabled(true);
        }


        //conferma competizione ISIC
        if(e.getSource()==s1ConfermaCompetizioneButtonISIC) {
            s3confermaErroreLabelIG.setVisible(false);
            if(!s1AnnoCompetizioneComboISIC.getSelectedItem().toString().isEmpty()) {
                s1ScegliCompetizioneComboISIC.setEnabled(false);
                s1ConfermaCompetizioneButtonISIC.setEnabled(false);
                s1AnnullaCompetizioneButtonISIC.setEnabled(true);
                s1AnnoCompetizioneComboISIC.setEnabled(false);

                s1SelezionaSquadraLabelISIC.setVisible(true);
                s1SelezionaSquadraComboISIC.setVisible(true);

                String competizione = (String) s1ScegliCompetizioneComboISIC.getSelectedItem();
                String nazione = null;
                String tipo = null;

                String[] listaSquadre = new String[0];
                try {
                    s3confermaErroreLabelIG.setVisible(false);
                    String squadreString = controller.prendiSquadreidonee(competizione, Integer.parseInt(s1AnnoCompetizioneComboISIC.getSelectedItem().toString()));
                    System.out.println(squadreString);
                    listaSquadre = (squadreString != null) ? squadreString.split(",") : new String[0];
                } catch (NullPointerException et) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("Nessuna squadra disponibile");
                    throw new RuntimeException(et);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                for (String giocatore : listaSquadre) {
                    s1SelezionaSquadraComboISIC.addItem(giocatore);
                }

                s1ConfermaInserimentoISIC.setVisible(true);
            } else {
                s3confermaErroreLabelIG.setVisible(true);
                s3confermaErroreLabelIG.setText("Inserire anno");
            }
        }
        //Annulla competizione ISIC
        if(e.getSource()==s1AnnullaCompetizioneButtonISIC) {
            s1ScegliCompetizioneComboISIC.setEnabled(true);
            s1ConfermaCompetizioneButtonISIC.setEnabled(true);
            s1AnnullaCompetizioneButtonISIC.setEnabled(false);
            s1AnnoCompetizioneComboISIC.setEnabled(true);


            s1SelezionaSquadraComboISIC.removeAllItems();

            s1SelezionaSquadraLabelISIC.setVisible(false);
            s1SelezionaSquadraComboISIC.setVisible(false);
        }


        //conferma Calciatore1 MC
        if(e.getSource()==s1ConfermaGiocatoreButtonMC) {
            s1ConfermaGiocatoreButtonMC.setEnabled(false);
            s1AnnullaGiocatoreButtonMC.setEnabled(true);
            s1SelezionaGiocatoreComboMC.setEnabled(false);

            String[] partiNomeCognome = s1SelezionaGiocatoreComboMC.getSelectedItem().toString().split(" ");

            String nome = partiNomeCognome[0];
            String cognome = partiNomeCognome[1];
            String nazione = null;
            Date nascita = null;

            int countCalciatori = controller.vediQuantiCalciatori(nome, cognome);

            if (countCalciatori == 1) {
                String id_giocatore = controller.getIDGiocatore(nome, cognome, nazione, nascita);
                //prendo feature

                String[] listaFeature = new String[0];
                s1InserisciFeatureComboMC.insertItemAt("", 0);
                String featureString = controller.prendiFeature(id_giocatore);
                listaFeature = (featureString != null) ? featureString.split("_") : new String[0];
                for (String feature : listaFeature) {
                    s1InserisciFeatureComboMC.addItem(feature);
                }


                boolean checkDataRitiro = controller.checkDataRitiro(id_giocatore);
                if(checkDataRitiro) {
                    s1InserisciFeatureLabelMC.setVisible(true);
                    s1InserisciFeatureComboMC.setVisible(true);
                    s1ConfermaInserimentoMC.setVisible(true);

                } else {

                    s1DataRitiroLabelMC.setVisible(true);
                    s1InserireDataRitiroRadioMC.setVisible(true);
                    s1InserireDataRitiroRadioMC.setEnabled(true);
                    s1NonInserireDataRitiroRadioMC.setEnabled(true);
                    s1NonInserireDataRitiroRadioMC.setVisible(true);
                    s1ConfermaSceltaRitiroButtonMC.setVisible(true);
                    s1ConfermaSceltaRitiroButtonMC.setEnabled(true);
                    s1AnnullaGiocatoreButtonMC.setVisible(true);
                    s1AnnullaSceltaRitiroButtonMC.setVisible(true);
                    s1AnnullaSceltaRitiroButtonMC.setEnabled(false);
                    s1InserisciFeatureLabelMC.setVisible(true);
                    s1InserisciFeatureComboMC.setVisible(true);

                }
                //ci sono giocatori con stesso nome e cognome
            } else {
                try {
                    String giocatoriUgualiString = controller.prendiGiocatoriUgualiDalDB(nome, cognome);
                    String[] giocatoriUguali = giocatoriUgualiString != null ? giocatoriUgualiString.split(",") : new String[0];

                    for (String giocatore : giocatoriUguali) {
                        s1SceltaTraGiocatoriUgualiComboMC.addItem(giocatore);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                s1SceltaTraGiocatoriUgualiLabelMC.setVisible(true);
                s1SceltaTraGiocatoriUgualiComboMC.setVisible(true);
                s1ConfermaGiocatoreButton2MC.setVisible(true);
                s1AnnullaGiocatoreButton2MC.setVisible(true);
                s1AnnullaGiocatoreButton2MC.setEnabled(false);
            }
        }
        //annulla giocatore1 MC
        if(e.getSource()==s1AnnullaGiocatoreButtonMC) {
            //parte alta
            s1ConfermaGiocatoreButtonMC.setEnabled(true);
            s1AnnullaGiocatoreButtonMC.setEnabled(false);
            s1SelezionaGiocatoreComboMC.setEnabled(true);

            //giocatori uguali
            s1SceltaTraGiocatoriUgualiLabelMC.setVisible(false);
            s1SceltaTraGiocatoriUgualiComboMC.setVisible(false);
            s1SceltaTraGiocatoriUgualiComboMC.removeAllItems();
            s1ConfermaGiocatoreButton2MC.setVisible(false);
            s1ConfermaGiocatoreButton2MC.setEnabled(true);
            s1AnnullaGiocatoreButton2MC.setVisible(false);
            s1AnnullaGiocatoreButton2MC.setEnabled(false);

            //tutto il resto
            s1DataRitiroLabelMC.setVisible(false);
            s1InserireDataRitiroRadioMC.setVisible(false);
            s1NonInserireDataRitiroRadioMC.setVisible(false);
            s1ConfermaSceltaRitiroButtonMC.setVisible(false);
            s1InserisciFeatureLabelMC.setVisible(false);
            s1InserisciFeatureComboMC.setVisible(false);
            s1ConfermaInserimentoMC.setVisible(false);
            s1DataRitiroGiornoComboMC.setVisible(false);
            s1DataRitiroMeseComboMC.setVisible(false);
            s1DataRitiroAnnoComboMC.setVisible(false);
            s1AnnullaSceltaRitiroButtonMC.setVisible(false);
            s1AnnullaSceltaRitiroButtonMC.setEnabled(false);
            s1InserisciFeatureComboMC.removeAllItems();
        }
        //conferma calciatore2 MC
        if(e.getSource()==s1ConfermaGiocatoreButton2MC) {
            s1SceltaTraGiocatoriUgualiComboMC.setEnabled(false);
            s1ConfermaGiocatoreButton2MC.setEnabled(false);
            s1AnnullaGiocatoreButtonMC.setEnabled(false);
            s1AnnullaGiocatoreButton2MC.setEnabled(true);

            String[] partiNomeCognomeNazNasc = s1SceltaTraGiocatoriUgualiComboMC.getSelectedItem().toString().split(" ");

            String nome = partiNomeCognomeNazNasc[0];
            String cognome = partiNomeCognomeNazNasc[1];
            String nazione = partiNomeCognomeNazNasc[2];
            Date nascita = Date.valueOf(partiNomeCognomeNazNasc[3]);

            String id_giocatore = controller.getIDGiocatore(nome, cognome, nazione, nascita);
            //prendo feature

            String[] listaFeature = new String[0];
            s1InserisciFeatureComboMC.insertItemAt("", 0);
            String featureString = controller.prendiFeature(id_giocatore);
            listaFeature = (featureString != null) ? featureString.split("_") : new String[0];
            for (String feature : listaFeature) {
                s1InserisciFeatureComboMC.addItem(feature);
            }

            s1InserisciFeatureComboMC.addItem(listaFeature);

            boolean checkDataRitiro = controller.checkDataRitiro(id_giocatore);
            if(checkDataRitiro) {
                s1InserisciFeatureLabelMC.setVisible(true);
                s1InserisciFeatureComboMC.setVisible(true);
                s1ConfermaInserimentoMC.setVisible(true);

            } else {

                s1DataRitiroLabelMC.setVisible(true);
                s1InserireDataRitiroRadioMC.setVisible(true);
                s1InserireDataRitiroRadioMC.setEnabled(true);
                s1NonInserireDataRitiroRadioMC.setEnabled(true);
                s1NonInserireDataRitiroRadioMC.setVisible(true);
                s1ConfermaSceltaRitiroButtonMC.setVisible(true);
                s1ConfermaSceltaRitiroButtonMC.setEnabled(true);
                s1AnnullaSceltaRitiroButtonMC.setEnabled(false);
                s1AnnullaSceltaRitiroButtonMC.setVisible(true);
                s1AnnullaGiocatoreButtonMC.setVisible(true);
                s1AnnullaGiocatoreButtonMC.setEnabled(false);
                s1InserisciFeatureLabelMC.setVisible(true);
                s1InserisciFeatureComboMC.setVisible(true);

            }
        }
        //annulla calciatore2 MC
        if(e.getSource()==s1AnnullaGiocatoreButton2MC) {
            //tolgo cose nuove
            s1DataRitiroLabelMC.setVisible(false);
            s1InserireDataRitiroRadioMC.setVisible(false);
            s1NonInserireDataRitiroRadioMC.setVisible(false);
            s1ConfermaSceltaRitiroButtonMC.setVisible(false);
            s1ConfermaSceltaRitiroButtonMC.setEnabled(true);
            s1InserisciFeatureLabelMC.setVisible(false);
            s1InserisciFeatureComboMC.setVisible(false);
            s1InserisciFeatureComboMC.removeAllItems();
            s1ConfermaInserimentoMC.setVisible(false);
            s1AnnullaSceltaRitiroButtonMC.setVisible(false);
            s1InserisciFeatureComboMC.removeAllItems();
            //faccio vede
            s1ConfermaGiocatoreButtonMC.setEnabled(false);
            s1AnnullaGiocatoreButtonMC.setEnabled(true);
            s1SelezionaGiocatoreComboMM.setEnabled(false);
            s1SceltaTraGiocatoriUgualiLabelMC.setVisible(true);
            s1SceltaTraGiocatoriUgualiComboMC.setVisible(true);
            s1SceltaTraGiocatoriUgualiComboMC.setEnabled(true);
            s1ConfermaGiocatoreButton2MC.setVisible(true);
            s1ConfermaGiocatoreButton2MC.setEnabled(true);
            s1AnnullaGiocatoreButton2MC.setVisible(true);
            s1AnnullaGiocatoreButton2MC.setEnabled(false);
        }
        //conferma scelta ritiro MC
        if(e.getSource()==s1ConfermaSceltaRitiroButtonMC) {
            if(s1InserireDataRitiroRadioMC.isSelected()) {
                s1DataRitiroGiornoComboMC.setVisible(true);
                s1DataRitiroMeseComboMC.setVisible(true);
                s1DataRitiroAnnoComboMC.setVisible(true);
                s1ConfermaInserimentoMC.setVisible(true);
                s1InserireDataRitiroRadioMC.setEnabled(false);
                s1NonInserireDataRitiroRadioMC.setEnabled(false);
                s1ConfermaSceltaRitiroButtonMC.setEnabled(false);
                s1AnnullaSceltaRitiroButtonMC.setEnabled(true);
            } else if (s1NonInserireDataRitiroRadioMC.isSelected()) {
                s1InserireDataRitiroRadioMC.setEnabled(false);
                s1NonInserireDataRitiroRadioMC.setEnabled(false);
                s1ConfermaSceltaRitiroButtonMC.setEnabled(false);
                s1AnnullaSceltaRitiroButtonMC.setEnabled(true);
                s1ConfermaInserimentoMC.setVisible(true);
            }
        }
        //ANNULLA SCELTA RITIRO MC
        if(e.getSource()==s1AnnullaSceltaRitiroButtonMC) {
            s1ConfermaInserimentoMC.setVisible(false);
            s1InserireDataRitiroRadioMC.setEnabled(true);
            s1NonInserireDataRitiroRadioMC.setEnabled(true);
            s1ConfermaSceltaRitiroButtonMC.setEnabled(true);
            s1AnnullaSceltaRitiroButtonMC.setEnabled(false);
            s1DataRitiroGiornoComboMC.setVisible(false);
            s1DataRitiroMeseComboMC.setVisible(false);
            s1DataRitiroAnnoComboMC.setVisible(false);
        }
        //conferma calciatore1 MM
        if(e.getSource()==s1ConfermaGiocatoreButtonMM) {
            s1ConfermaGiocatoreButtonMM.setEnabled(false);
            s1AnnullaGiocatoreButtonMM.setEnabled(true);
            s1SelezionaGiocatoreComboMM.setEnabled(false);

            String[] partiNomeCognome = s1SelezionaGiocatoreComboMM.getSelectedItem().toString().split(" ");

            String nome = partiNomeCognome[0];
            String cognome = partiNomeCognome[1];
            String nazione = null;
            Date nascita = null;

            int countCalciatori = controller.vediQuantiCalciatori(nome, cognome);

            if (countCalciatori == 1) {

                String idGiocatore = controller.getIDGiocatore(nome, cognome, nazione, nascita);
                boolean prendiRuoloPortiere = controller.prendiRuoloCalciatoreFacile(nome, cognome);
                Date checkLastMil = (Date) controller.checkLastMil(idGiocatore);

                if(checkLastMil == null) {
                    s1InserisciDataFineExMilitanzaLabelMM.setVisible(true);
                    s1InserisciDataFineExMilitanzaGiornoComboMM.setVisible(true);
                    s1InserisciDataFineExMilitanzaMeseComboMM.setVisible(true);
                    s1InserisciDataFineExMilitanzaAnnoComboMM.setVisible(true);
                } else {
                    s1UltimaMilitanzaLabelMM.setText("Data fine militanza: " + checkLastMil);
                    s1UltimaMilitanzaLabelMM.setVisible(true);
                }

                s1InserisciDataInizioNuovaMilitanzaLabelMM.setVisible(true);
                s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setVisible(true);
                s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setVisible(true);
                s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.setVisible(true);
                s1MilitanzaInAttoRadioMM.setVisible(true);
                s1MilitanzaFinitaRadioMM.setVisible(true);
                s1ConfermaFineMilitanzaButtonMM.setVisible(true);
                s1AnnullaFineMilitanzaButtonMM.setVisible(true);
                s1InserisciTiriSegnatiLabelMM.setVisible(true);
                s1InserisciTiriSegnatiFieldMM.setVisible(true);
                s1InserisciPartiteGiocateLabelMM.setVisible(true);
                s1InserisciPartiteGiocateFieldMM.setVisible(true);

                if(prendiRuoloPortiere) {
                    s1InserisciGoalSubitiLabelMM.setVisible(true);
                    s1InserisciGoalSubitiFieldMM.setVisible(true);
                }

                s1SelezionaSquadraLabelMM.setVisible(true);
                s1SelezionaSquadraComboMM.setVisible(true);
            } else if (countCalciatori > 1) {
                try {
                    String giocatoriUgualiString = controller.prendiGiocatoriUgualiDalDB(nome, cognome);
                    String[] giocatoriUguali = giocatoriUgualiString != null ? giocatoriUgualiString.split(",") : new String[0];

                    for (String giocatore : giocatoriUguali) {
                        s1SceltaTraGiocatoriUgualiComboMM.addItem(giocatore);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                s1SceltaTraGiocatoriUgualiLabelMM.setVisible(true);
                s1SceltaTraGiocatoriUgualiComboMM.setVisible(true);
                s1ConfermaGiocatoreButton2MM.setVisible(true);
                s1AnnullaGiocatoreButton2MM.setVisible(true);
                s1AnnullaGiocatoreButton2MM.setEnabled(false);

            }

        }
        //annulla calciatore1 MM
        if(e.getSource()==s1AnnullaGiocatoreButtonMM) {
            s1ConfermaGiocatoreButtonMM.setEnabled(true);
            s1AnnullaGiocatoreButtonMM.setEnabled(false);
            s1SelezionaGiocatoreComboMM.setEnabled(true);

            s1UltimaMilitanzaLabelMM.setVisible(false);
            s1InserisciDataFineExMilitanzaLabelMM.setVisible(false);
            s1InserisciDataFineExMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataFineExMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataFineExMilitanzaAnnoComboMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaLabelMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.setVisible(false);
            s1MilitanzaInAttoRadioMM.setVisible(false);
            s1MilitanzaFinitaRadioMM.setVisible(false);
            s1ConfermaFineMilitanzaButtonMM.setVisible(false);
            s1AnnullaFineMilitanzaButtonMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaLabelMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setVisible(false);
            s1InserisciTiriSegnatiLabelMM.setVisible(false);
            s1InserisciTiriSegnatiFieldMM.setVisible(false);
            s1InserisciTiriSegnatiFieldMM.setText("");
            s1InserisciGoalSubitiFieldMM.setVisible(false);
            s1InserisciGoalSubitiFieldMM.setText("");
            s1InserisciPartiteGiocateLabelMM.setVisible(false);
            s1InserisciPartiteGiocateFieldMM.setVisible(false);
            s1InserisciPartiteGiocateFieldMM.setText("");
            s1InserisciGoalSubitiLabelMM.setVisible(false);
            s1InserisciGoalSubitiFieldMM.setVisible(false);
            s1InserisciGoalSubitiFieldMM.setText("");
            s1SelezionaSquadraLabelMM.setVisible(false);
            s1SelezionaSquadraComboMM.setVisible(false);
            s1SceltaTraGiocatoriUgualiComboMM.removeAllItems();

            s1SceltaTraGiocatoriUgualiLabelMM.setVisible(false);
            s1SceltaTraGiocatoriUgualiComboMM.setVisible(false);
            s1ConfermaGiocatoreButton2MM.setVisible(false);
            s1ConfermaGiocatoreButton2MM.setEnabled(true);
            s1AnnullaGiocatoreButton2MM.setVisible(false);
            s1AnnullaGiocatoreButton2MM.setEnabled(false);

            s1ConfermaInserimentoMM.setVisible(false);
        }
        //conferma calciatore2MM
        if(e.getSource()==s1ConfermaGiocatoreButton2MM) {
            s1AnnullaGiocatoreButtonMM.setEnabled(false);
            s1SceltaTraGiocatoriUgualiComboMM.setEnabled(false);
            s1ConfermaGiocatoreButton2MM.setEnabled(false);
            s1AnnullaGiocatoreButton2MM.setEnabled(true);

            String[] partiNomeCognomeNazionalitaNascita = s1SceltaTraGiocatoriUgualiComboMM.getSelectedItem().toString().split(" ");

            String nome = partiNomeCognomeNazionalitaNascita[0];
            String cognome = partiNomeCognomeNazionalitaNascita[1];
            String nazione = partiNomeCognomeNazionalitaNascita[2];
            Date nascita = Date.valueOf(partiNomeCognomeNazionalitaNascita[3]);

            String idGiocatore = controller.getIDGiocatore(nome, cognome, nazione, nascita);
            boolean prendiRuoloPortiere = controller.prendiRuoloCalciatoreDifficile(nome, cognome, nazione, nascita);
            Date checkLastMil = (Date) controller.checkLastMil(idGiocatore);

            if(checkLastMil == null) {
                s1InserisciDataFineExMilitanzaLabelMM.setVisible(true);
                s1InserisciDataFineExMilitanzaGiornoComboMM.setVisible(true);
                s1InserisciDataFineExMilitanzaMeseComboMM.setVisible(true);
                s1InserisciDataFineExMilitanzaAnnoComboMM.setVisible(true);
            } else {
                s1UltimaMilitanzaLabelMM.setText("Data fine militanza: " + checkLastMil);
                s1UltimaMilitanzaLabelMM.setVisible(true);
            }

            s1InserisciDataInizioNuovaMilitanzaLabelMM.setVisible(true);
            s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setVisible(true);
            s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setVisible(true);
            s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.setVisible(true);
            s1MilitanzaInAttoRadioMM.setVisible(true);
            s1MilitanzaFinitaRadioMM.setVisible(true);
            s1MilitanzaInAttoRadioMM.setEnabled(true);
            s1MilitanzaFinitaRadioMM.setEnabled(true);
            s1ConfermaFineMilitanzaButtonMM.setVisible(true);
            s1AnnullaFineMilitanzaButtonMM.setVisible(true);
            s1AnnullaFineMilitanzaButtonMM.setEnabled(false);
            s1InserisciTiriSegnatiLabelMM.setVisible(true);
            s1InserisciTiriSegnatiFieldMM.setVisible(true);
            s1InserisciPartiteGiocateLabelMM.setVisible(true);
            s1InserisciPartiteGiocateFieldMM.setVisible(true);

            if(prendiRuoloPortiere) {
                s1InserisciGoalSubitiLabelMM.setVisible(true);
                s1InserisciGoalSubitiFieldMM.setVisible(true);
            }

            s1SelezionaSquadraLabelMM.setVisible(true);
            s1SelezionaSquadraComboMM.setVisible(true);
        }
        //annulla calciatore2 MM
        if(e.getSource()==s1AnnullaGiocatoreButton2MM) {
            s1ConfermaGiocatoreButton2MM.setEnabled(true);
            s1InserisciDataFineExMilitanzaLabelMM.setVisible(false);
            s1InserisciDataFineExMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataFineExMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataFineExMilitanzaAnnoComboMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaLabelMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setVisible(false);
            s1MilitanzaInAttoRadioMM.setVisible(false);
            s1MilitanzaFinitaRadioMM.setVisible(false);
            s1ConfermaFineMilitanzaButtonMM.setVisible(false);
            s1AnnullaFineMilitanzaButtonMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaLabelMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setVisible(false);
            s1InserisciTiriSegnatiLabelMM.setVisible(false);
            s1InserisciTiriSegnatiFieldMM.setVisible(false);
            s1UltimaMilitanzaLabelMM.setVisible(false);
            s1InserisciTiriSegnatiFieldMM.setText("");
            s1InserisciPartiteGiocateLabelMM.setVisible(false);
            s1InserisciPartiteGiocateFieldMM.setVisible(false);
            s1InserisciPartiteGiocateFieldMM.setText("");
            s1InserisciGoalSubitiLabelMM.setVisible(false);
            s1InserisciGoalSubitiFieldMM.setVisible(false);
            s1InserisciGoalSubitiFieldMM.setText("");
            s1SelezionaSquadraLabelMM.setVisible(false);
            s1SelezionaSquadraComboMM.setVisible(false);

            s1AnnullaGiocatoreButtonMM.setEnabled(true);
            s1SceltaTraGiocatoriUgualiComboMM.setEnabled(true);
            s1ConfermaGiocatoreButton2MM.setVisible(true);
            s1AnnullaGiocatoreButton2MM.setEnabled(false);
        }
        //conferma radio fine ex militanza
        if(e.getSource()==s1ConfermaFineMilitanzaButtonMM) {
            if(s1MilitanzaInAttoRadioMM.isSelected()) {
                s1ConfermaInserimentoMM.setVisible(true);

                s1MilitanzaInAttoRadioMM.setEnabled(false);
                s1MilitanzaFinitaRadioMM.setEnabled(false);
                s1ConfermaFineMilitanzaButtonMM.setEnabled(false);
                s1AnnullaFineMilitanzaButtonMM.setEnabled(true);

            } else if(s1MilitanzaFinitaRadioMM.isSelected()) {
                s1InserisciDataFineNuovaMilitanzaLabelMM.setVisible(true);
                s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setVisible(true);
                s1InserisciDataFineNuovaMilitanzaMeseComboMM.setVisible(true);
                s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setVisible(true);

                s1ConfermaInserimentoMM.setVisible(true);

                s1MilitanzaInAttoRadioMM.setEnabled(false);
                s1MilitanzaFinitaRadioMM.setEnabled(false);
                s1ConfermaFineMilitanzaButtonMM.setEnabled(false);
                s1AnnullaFineMilitanzaButtonMM.setEnabled(true);
            }
        }
        //annulla radio fine ex militanza
        if(e.getSource()==s1AnnullaFineMilitanzaButtonMM) {
            s1InserisciDataFineNuovaMilitanzaLabelMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setVisible(false);

            s1ConfermaInserimentoMM.setVisible(false);

            s1MilitanzaInAttoRadioMM.setEnabled(true);
            s1MilitanzaFinitaRadioMM.setEnabled(true);
            s1ConfermaFineMilitanzaButtonMM.setEnabled(true);
            s1AnnullaFineMilitanzaButtonMM.setEnabled(false);
        }
        //cONFERMA SQUADRA SPONSOR SECONDARIO
        if(e.getSource()==s1ConfermaSquadraButtonSS) {
            s1ConfermaSquadraButtonSS.setEnabled(false);
            s1AnnullaSquadraButtonSS.setEnabled(true);
            s1InserisciNomeSponsorLabelSS.setVisible(true);
            s1InserisciNomeSponsorFieldSS.setVisible(true);
            s1ConfermaInserimentoSS.setVisible(true);
        }
        //aNNULLA SQUADRA SPONSOR SECONDARIO
        if(e.getSource()==s1AnnullaSquadraButtonSS) {
            s1AnnullaSquadraButtonSS.setEnabled(false);
            s1ConfermaSquadraButtonSS.setEnabled(true);
            s1InserisciNomeSponsorLabelSS.setVisible(false);
            s1InserisciNomeSponsorFieldSS.setVisible(false);
            s1InserisciNomeSponsorFieldSS.setText("");
            s1ConfermaInserimentoSS.setVisible(false);
        }
        //VEDI MODO DI INSERIMENTO DELLA COMPETIZIONE (INSERIMENTO COMPETIZIONE)
        if (e.getSource() == s1ConfermaCompIC) {
            if (s1NazionaleIC.isSelected()) {
                s1ConfermaIC.setVisible(true);
                s1CompNazComboIC.setVisible(true);
                s1ConfermaCompIC.setEnabled(false);
                s1AnnullaCompIC.setEnabled(true);
                s1NazionaleIC.setEnabled(false);
                s1InternazionaleIC.setEnabled(false);
            } else if (s1InternazionaleIC.isSelected()) {
                s1ConfermaIC.setVisible(true);
                s1CompNonNazComboIC.setVisible(true);
                s1ConfermaCompIC.setEnabled(false);
                s1AnnullaCompIC.setEnabled(true);
                s1NazionaleIC.setEnabled(false);
                s1InternazionaleIC.setEnabled(false);
            }
        }
        //ANNULLA MODO DI INSERIMENTO DELLA COMPETIZIONE (INSERIMENTO COMPETIZIONE)
        if (e.getSource() == s1AnnullaCompIC) {
            s1ConfermaIC.setVisible(false);
            s1CompNonNazComboIC.setVisible(false);
            s1CompNazComboIC.setVisible(false);
            s1ConfermaCompIC.setEnabled(true);
            s1AnnullaCompIC.setEnabled(false);
            s1NazionaleIC.setEnabled(true);
            s1InternazionaleIC.setEnabled(true);
        }
        //quando si passa dallo step 1 di inserisci giocatore allo step 2
        if (e.getSource() == avantiToStep2InserisciGiocatore) {
            int count = 0;
            if (portiere.isSelected()) {
                count++;
            }
            if (difensore.isSelected()) {
                count++;
            }
            if (centrocampista.isSelected()) {
                count++;
            }
            if (attaccante.isSelected()) {
                count++;
            }

            if (!step1Inserisci_Giocatore_NomeField.getText().isEmpty() && !step1Inserisci_Giocatore_CognomeField.getText().isEmpty()
                    && (count > 0) && (step1InserireDataRitiroRadioIG.isSelected() || step1NonInserireDataRitiroRadioIG.isSelected())) {

                //nascondo i dati che non mi servono più
                step1Inserisci_Giocatore_NomeLabel.setVisible(false);
                step1Inserisci_Giocatore_NomeField.setVisible(false);
                step1Inserisci_Giocatore_CognomeLabel.setVisible(false);
                step1Inserisci_Giocatore_CognomeField.setVisible(false);
                portiere.setVisible(false);
                difensore.setVisible(false);
                centrocampista.setVisible(false);
                attaccante.setVisible(false);
                ruoloLabel.setVisible(false);
                step1Inserisci_DataRitiroLabel.setVisible(false);
                if (step1InserireDataRitiroRadioIG.isSelected()) {
                    step1Inserisci_DataRitiroGiorno.setVisible(false);
                    step1Inserisci_DataRitiroMese.setVisible(false);
                    step1Inserisci_DataRitiroAnno.setVisible(false);
                }
                step1confermaDataRitiroButtonIG.setVisible(false);
                step1annullaDataRitiroButtonIG.setVisible(false);

                step1InserireDataRitiroRadioIG.setVisible(false);
                step1NonInserireDataRitiroRadioIG.setVisible(false);
                step1Inserisci_NazionalitaCombo.setVisible(false);
                step1Inserisci_NazionalitaLabel.setVisible(false);
                step1Inserisci_DataDiNascitaLabel.setVisible(false);
                avantiToStep2InserisciGiocatore.setVisible(false);
                step1Giorno.setVisible(false);
                step1Mese.setVisible(false);
                step1Anno.setVisible(false);
                scrittaErrore.setVisible(false);
                step1PiedePRCombo.setVisible(false);
                step1PiedePRLabel.setVisible(false);

                //faccio inserire i nuovi dati

                step2InizioLabelIG.setVisible(true);
                step2InizioAnnoIG.setVisible(true);
                step2InizioMeseIG.setVisible(true);
                step2InizioGiornoIG.setVisible(true);
                step2fineAncoraInAttoRadio.setVisible(true);
                step2fineDefinita.setVisible(true);
                step2confermaFineMilitanzaButton.setVisible(true);
                step2annullaFineMilitanzaButton.setVisible(true);
                step2FineLabelIG.setVisible(true);
                step2TiriSegantiLabelIG.setVisible(true);
                step2TiriSegnatiFieldIG.setVisible(true);
                if(step2fineDefinita.isSelected() && !step2confermaFineMilitanzaButton.isEnabled()) {
                    step2FineGiornoIG.setVisible(true);
                    step2FineMeseIG.setVisible(true);
                    step2FineAnnoIG.setVisible(true);
                }

                //se è stato inserito il portiere allora si chiedono anche i goal subiti
                if (portiere.isSelected()) {
                    step2GoalSubitiFieldIG.setVisible(true);
                    step2GoalSubitiLabelIG.setVisible(true);
                }

                step2PartiteGiocateFieldIG.setVisible(true);
                step2PartiteGiocateLabelIG.setVisible(true);
                indietroToStep1DaIG.setVisible(true);
            } else {
                scrittaErrore.setVisible(true);
            }
        }
        //TASTO PER CONFERMARE MODO FINE MILITANZA
        if(e.getSource() == step2confermaFineMilitanzaButton) {
            if(step2fineAncoraInAttoRadio.isSelected()) {
                step2fineAncoraInAttoRadio.setEnabled(false);
                step2fineDefinita.setEnabled(false);
                step2confermaFineMilitanzaButton.setEnabled(false);
                step2annullaFineMilitanzaButton.setEnabled(true);
                avantiToStep3IG.setVisible(true);
            } else if (step2fineDefinita.isSelected()) {
                step2fineAncoraInAttoRadio.setEnabled(false);
                step2fineDefinita.setEnabled(false);
                step2confermaFineMilitanzaButton.setEnabled(false);
                step2annullaFineMilitanzaButton.setEnabled(true);
                step2FineGiornoIG.setVisible(true);
                step2FineMeseIG.setVisible(true);
                step2FineAnnoIG.setVisible(true);
                avantiToStep3IG.setVisible(true);
            }
        }
        //TASTO PER ANNULLARE MODO FINE MILITANZA
        if(e.getSource() == step2annullaFineMilitanzaButton) {
            step2FineGiornoIG.setVisible(false);
            step2FineMeseIG.setVisible(false);
            step2FineAnnoIG.setVisible(false);
            step2fineAncoraInAttoRadio.setEnabled(true);
            step2fineDefinita.setEnabled(true);
            step2confermaFineMilitanzaButton.setEnabled(true);
            step2annullaFineMilitanzaButton.setEnabled(false);
            avantiToStep3IG.setVisible(false);
        }
        //TASTO PER CONFERMARE DATARITIRO
        if (e.getSource() == step1confermaDataRitiroButtonIG) {
            if(step1InserireDataRitiroRadioIG.isSelected()) {
                step1Inserisci_DataRitiroGiorno.setVisible(true);
                step1InserireDataRitiroRadioIG.setEnabled(false);
                step1NonInserireDataRitiroRadioIG.setEnabled(false);
                step1confermaDataRitiroButtonIG.setEnabled(false);
                step1annullaDataRitiroButtonIG.setEnabled(true);
                step1NonInserireDataRitiroRadioIG.setEnabled(true);
                step1Inserisci_DataRitiroMese.setVisible(true);
                step1Inserisci_DataRitiroAnno.setVisible(true);
                step1NonInserireDataRitiroRadioIG.setEnabled(false);
            }
            else if(step1NonInserireDataRitiroRadioIG.isSelected()) {
                step1InserireDataRitiroRadioIG.setEnabled(false);
                step1Inserisci_DataRitiroGiorno.setEnabled(false);
                step1NonInserireDataRitiroRadioIG.setEnabled(false);
                step1confermaDataRitiroButtonIG.setEnabled(false);
                step1annullaDataRitiroButtonIG.setEnabled(true);
            }


        }
        //TASTO PER ANNULLARE DATA RITIRO
        if (e.getSource() == step1annullaDataRitiroButtonIG) {
            step1NonInserireDataRitiroRadioIG.setEnabled(false);
            step1annullaDataRitiroButtonIG.setEnabled(false);
            step1confermaDataRitiroButtonIG.setEnabled(true);
            step1NonInserireDataRitiroRadioIG.setEnabled(true);
            step1confermaDataRitiroButtonIG.setSelected(false);
            step1annullaDataRitiroButtonIG.setSelected(false);
            step1InserireDataRitiroRadioIG.setEnabled(true);
            step1Inserisci_DataRitiroGiorno.setVisible(false);
            step1Inserisci_DataRitiroMese.setVisible(false);
            step1Inserisci_DataRitiroAnno.setVisible(false);

        }
        //quando si torna indietro dallo step 2 di inserisci giocatore allo step 1
        if (e.getSource() == indietroToStep1DaIG) {

            //quando torno indetro nascondo la nuova schermata
            step2InizioLabelIG.setVisible(false);
            step2InizioAnnoIG.setVisible(false);
            step2InizioMeseIG.setVisible(false);
            step2InizioGiornoIG.setVisible(false);
            step2FineAnnoIG.setVisible(false);
            step2FineGiornoIG.setVisible(false);
            step2FineMeseIG.setVisible(false);
            step2FineLabelIG.setVisible(false);
            step2TiriSegantiLabelIG.setVisible(false);
            step2TiriSegnatiFieldIG.setVisible(false);
            step2GoalSubitiFieldIG.setVisible(false);
            step2GoalSubitiLabelIG.setVisible(false);
            step2PartiteGiocateFieldIG.setVisible(false);
            step2PartiteGiocateLabelIG.setVisible(false);
            indietroToStep1DaIG.setVisible(false);
            erroreMilitanza.setVisible(false);
            step2GoalSubitiFieldIG.setText("");
            step2fineAncoraInAttoRadio.setVisible(false);
            step2fineDefinita.setVisible(false);
            step2annullaFineMilitanzaButton.setVisible(false);
            step2confermaFineMilitanzaButton.setVisible(false);

            //faccio ricomparire la vecchia schermata
            step1Inserisci_Giocatore_NomeLabel.setVisible(true);
            step1Inserisci_Giocatore_NomeField.setVisible(true);
            step1Inserisci_Giocatore_CognomeLabel.setVisible(true);
            step1Inserisci_Giocatore_CognomeField.setVisible(true);
            portiere.setVisible(true);
            difensore.setVisible(true);
            centrocampista.setVisible(true);
            attaccante.setVisible(true);
            ruoloLabel.setVisible(true);
            step1Inserisci_DataRitiroLabel.setVisible(true);

            if (step1InserireDataRitiroRadioIG.isSelected()) {
                step1Inserisci_DataRitiroGiorno.setVisible(true);
                step1Inserisci_DataRitiroMese.setVisible(true);
                step1Inserisci_DataRitiroAnno.setVisible(true);
            } else {
                step1Inserisci_DataRitiroGiorno.setVisible(false);
                step1Inserisci_DataRitiroMese.setVisible(false);
                step1Inserisci_DataRitiroAnno.setVisible(false);
            }
            step1confermaDataRitiroButtonIG.setVisible(true);
            step1annullaDataRitiroButtonIG.setVisible(true);

            step1NonInserireDataRitiroRadioIG.setVisible(true);
            step1InserireDataRitiroRadioIG.setVisible(true);
            step1Inserisci_NazionalitaCombo.setVisible(true);
            step1Inserisci_NazionalitaLabel.setVisible(true);
            step1Inserisci_DataDiNascitaLabel.setVisible(true);
            avantiToStep2InserisciGiocatore.setVisible(true);
            step1Giorno.setVisible(true);
            step1Mese.setVisible(true);
            step1Anno.setVisible(true);
            step1PiedePRCombo.setVisible(true);
            step1PiedePRLabel.setVisible(true);
        }
        //vado allo step 3
        if (e.getSource() == avantiToStep3IG) {
            String tiriSegnati = step2TiriSegnatiFieldIG.getText();
            String partiteGiocate = step2PartiteGiocateFieldIG.getText();

            if (portiere.isSelected()) {
                String goalSubiti = step2GoalSubitiFieldIG.getText();

                try {
                    int nTiriSeg = Integer.parseInt((tiriSegnati));
                    int npartGio = Integer.parseInt((partiteGiocate));
                    int ngoalSub = Integer.parseInt((goalSubiti));

                    s3InsSquadraLabelIG.setVisible(true);
                    s3InserisciSquadraRadioIG.setVisible(true);
                    s3TrovaSquadraRadioIG.setVisible(true);
                    s3ConfermaSquadraButtonIG.setVisible(true);
                    indietroToStep2DaIG.setVisible(true);
                    erroreMilitanza.setVisible(false);

                    step2InizioLabelIG.setVisible(false);
                    step2InizioAnnoIG.setVisible(false);
                    step2InizioMeseIG.setVisible(false);
                    step2InizioGiornoIG.setVisible(false);
                    step2FineAnnoIG.setVisible(false);
                    step2FineGiornoIG.setVisible(false);
                    step2FineMeseIG.setVisible(false);
                    step2FineLabelIG.setVisible(false);
                    step2TiriSegantiLabelIG.setVisible(false);
                    step2TiriSegnatiFieldIG.setVisible(false);
                    step2GoalSubitiFieldIG.setVisible(false);
                    step2GoalSubitiLabelIG.setVisible(false);
                    step2PartiteGiocateFieldIG.setVisible(false);
                    step2PartiteGiocateLabelIG.setVisible(false);
                    s3AnnullaMetodoSquadraIG.setVisible(true);
                    s3AnnullaMetodoSquadraIG.setEnabled(false);
                    indietroToStep1DaIG.setVisible(false);
                    avantiToStep3IG.setVisible(false);
                    step2fineAncoraInAttoRadio.setVisible(false);
                    step2fineDefinita.setVisible(false);
                    step2confermaFineMilitanzaButton.setVisible(false);
                    step2annullaFineMilitanzaButton.setVisible(false);

                } catch (NumberFormatException er) {

                    erroreMilitanza.setVisible(true);
                }

            } else {
                try {
                    int nTiriSeg = Integer.parseInt((tiriSegnati));
                    int npartGio = Integer.parseInt((partiteGiocate));

                    s3InsSquadraLabelIG.setVisible(true);
                    s3InserisciSquadraRadioIG.setVisible(true);
                    s3TrovaSquadraRadioIG.setVisible(true);
                    s3ConfermaSquadraButtonIG.setVisible(true);
                    indietroToStep2DaIG.setVisible(true);
                    s3AnnullaMetodoSquadraIG.setVisible(true);
                    s3AnnullaMetodoSquadraIG.setEnabled(false);
                    erroreMilitanza.setVisible(false);

                    step2InizioLabelIG.setVisible(false);
                    step2InizioAnnoIG.setVisible(false);
                    step2InizioMeseIG.setVisible(false);
                    step2InizioGiornoIG.setVisible(false);
                    step2FineAnnoIG.setVisible(false);
                    step2FineGiornoIG.setVisible(false);
                    step2FineMeseIG.setVisible(false);
                    step2FineLabelIG.setVisible(false);
                    step2TiriSegantiLabelIG.setVisible(false);
                    step2TiriSegnatiFieldIG.setVisible(false);
                    step2GoalSubitiFieldIG.setVisible(false);
                    step2GoalSubitiLabelIG.setVisible(false);
                    step2PartiteGiocateFieldIG.setVisible(false);
                    step2PartiteGiocateLabelIG.setVisible(false);
                    indietroToStep1DaIG.setVisible(false);
                    avantiToStep3IG.setVisible(false);
                    step2fineAncoraInAttoRadio.setVisible(false);
                    step2fineDefinita.setVisible(false);
                    step2confermaFineMilitanzaButton.setVisible(false);
                    step2annullaFineMilitanzaButton.setVisible(false);

                } catch (NumberFormatException er) {

                    erroreMilitanza.setVisible(true);
                }
            }
        }
        //se confermo il metodo
        if (e.getSource() == s3ConfermaSquadraButtonIG) {

            if (s3InserisciSquadraRadioIG.isSelected()) {
                confermaStep3IG.setVisible(true);
                s3AnnullaMetodoSquadraIG.setEnabled(true);
                s3InserisciNomeSquadraLabelIG.setVisible(true);
                s3InserisciNomeSquadraFieldIG.setVisible(true);
                s3InserisciNazionalitaSquadraLabelIG.setVisible(true);
                s3InserisciNazionalitaSquadraComboIG.setVisible(true);
                s3InserisciSponsorTecSquadraLabelIG.setVisible(true);
                s3InserisciSponsorTecSquadraFieldIG.setVisible(true);
                erroreConfermaMetodoSquadraIG.setVisible(false);
                s3InserisciSquadraRadioIG.setEnabled(false);
                s3TrovaSquadraRadioIG.setEnabled(false);
                s3ConfermaSquadraButtonIG.setEnabled(false);
            } else if (s3TrovaSquadraRadioIG.isSelected()) {
                confermaStep3IG.setVisible(true);
                s3AnnullaMetodoSquadraIG.setEnabled(true);
                s3TrovaSquadraLabelIG.setVisible(true);
                s3TrovaSquadraComboIG.setVisible(true);
                erroreConfermaMetodoSquadraIG.setVisible(false);
                s3InserisciSquadraRadioIG.setEnabled(false);
                s3TrovaSquadraRadioIG.setEnabled(false);
                s3ConfermaSquadraButtonIG.setEnabled(false);
            } else {
                erroreConfermaMetodoSquadraIG.setVisible(true);
            }
        }
        //se si cuol cambiare metodo
        if (e.getSource() == s3AnnullaMetodoSquadraIG) {

            if (s3InserisciSquadraRadioIG.isSelected()) {
                confermaStep3IG.setVisible(false);
                s3AnnullaMetodoSquadraIG.setEnabled(false);
                s3InserisciNomeSquadraLabelIG.setVisible(false);
                s3InserisciNomeSquadraFieldIG.setVisible(false);
                s3InserisciNazionalitaSquadraLabelIG.setVisible(false);
                s3InserisciNazionalitaSquadraComboIG.setVisible(false);
                s3InserisciSponsorTecSquadraLabelIG.setVisible(false);
                s3InserisciSponsorTecSquadraFieldIG.setVisible(false);
                erroreConfermaMetodoSquadraIG.setVisible(false);
                s3InserisciSquadraRadioIG.setEnabled(true);
                s3TrovaSquadraRadioIG.setEnabled(true);
                s3ConfermaSquadraButtonIG.setEnabled(true);
            } else if (s3TrovaSquadraRadioIG.isSelected()) {
                confermaStep3IG.setVisible(false);
                s3AnnullaMetodoSquadraIG.setEnabled(false);
                s3TrovaSquadraLabelIG.setVisible(false);
                s3TrovaSquadraComboIG.setVisible(false);
                erroreConfermaMetodoSquadraIG.setVisible(false);
                s3InserisciSquadraRadioIG.setEnabled(true);
                s3TrovaSquadraRadioIG.setEnabled(true);
                s3ConfermaSquadraButtonIG.setEnabled(true);
            }
        }
        //se si va dallo step 3 allo step 2 di inserisci giocatore
        if (e.getSource() == indietroToStep2DaIG) {

            //nascondo lo step3
            s3InsSquadraLabelIG.setVisible(false);
            s3InserisciSquadraRadioIG.setVisible(false);
            s3TrovaSquadraRadioIG.setVisible(false);
            s3ConfermaSquadraButtonIG.setVisible(false);
            s3TrovaSquadraComboIG.setVisible(false);
            s3InserisciNomeSquadraLabelIG.setVisible(false);
            s3InserisciNomeSquadraFieldIG.setVisible(false);
            s3InserisciNazionalitaSquadraLabelIG.setVisible(false);
            s3InserisciNazionalitaSquadraComboIG.setVisible(false);
            s3InserisciSponsorTecSquadraLabelIG.setVisible(false);
            s3InserisciSponsorTecSquadraFieldIG.setVisible(false);
            indietroToStep2DaIG.setVisible(false);
            confermaStep3IG.setVisible(false);
            erroreMilitanza.setVisible(false);
            erroreConfermaMetodoSquadraIG.setVisible(false);
            s3AnnullaMetodoSquadraIG.setVisible(false);
            s3AnnullaMetodoSquadraIG.setEnabled(false);
            s3ConfermaSquadraButtonIG.setEnabled(true);
            s3TrovaSquadraRadioIG.setEnabled(true);
            s3InserisciSquadraRadioIG.setEnabled(true);


            //faccio rivedere lo step 2
            step2InizioLabelIG.setVisible(true);
            step2InizioAnnoIG.setVisible(true);
            step2InizioMeseIG.setVisible(true);
            step2InizioGiornoIG.setVisible(true);
            step2FineLabelIG.setVisible(true);
            step2TiriSegantiLabelIG.setVisible(true);
            step2TiriSegnatiFieldIG.setVisible(true);
            avantiToStep3IG.setVisible(true);
            step2fineAncoraInAttoRadio.setVisible(true);
            step2fineDefinita.setVisible(true);
            step2confermaFineMilitanzaButton.setVisible(true);
            step2annullaFineMilitanzaButton.setVisible(true);
            if(step2fineDefinita.isSelected() && !step2confermaFineMilitanzaButton.isEnabled()) {
                step2FineGiornoIG.setVisible(true);
                step2FineMeseIG.setVisible(true);
                step2FineAnnoIG.setVisible(true);
            } else {
                step2FineGiornoIG.setVisible(false);
                step2FineMeseIG.setVisible(false);
                step2FineAnnoIG.setVisible(false);
            }

            //se è stato inserito il portiere allora si chiedono anche i goal subiti
            if (portiere.isSelected()) {
                step2GoalSubitiFieldIG.setVisible(true);
                step2GoalSubitiLabelIG.setVisible(true);
            }

            step2PartiteGiocateFieldIG.setVisible(true);
            step2PartiteGiocateLabelIG.setVisible(true);
            indietroToStep1DaIG.setVisible(true);
        }
        //CONFERMO INSERIMENTO GIOCATORE E INSERISCO TUTTO NEL DBMS
        if (e.getSource() == confermaStep3IG) {
            if ((s3InserisciSquadraRadioIG.isSelected() && !s3InserisciNomeSquadraFieldIG.getText().isEmpty() && !s3InserisciSponsorTecSquadraFieldIG.getText().isEmpty()) || (s3TrovaSquadraRadioIG.isSelected())) {

                s3confermaErroreLabelIG.setVisible(false);

                //PRENDO DATI CALCIATORE
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                String dataNascita = step1Anno.getSelectedItem() + "-" + step1Mese.getSelectedItem() + "-" + step1Giorno.getSelectedItem();
                String dataRitiroString;
                if(step1InserireDataRitiroRadioIG.isSelected()) {
                    dataRitiroString = step1Inserisci_DataRitiroAnno.getSelectedItem() + "-" + step1Inserisci_DataRitiroMese.getSelectedItem() + "-" + step1Inserisci_DataRitiroGiorno.getSelectedItem();
                } else {
                    dataRitiroString = null;
                }
                String nazion = (String) step1Inserisci_NazionalitaCombo.getSelectedItem().toString();
                String piedePR = (String) step1PiedePRCombo.getSelectedItem();
                String nome = step1Inserisci_Giocatore_NomeField.getText();
                String cognome = step1Inserisci_Giocatore_CognomeField.getText();

                //PRENDO DATI MILITANZA
                String dataInizio = step2InizioAnnoIG.getSelectedItem() + "-" + step2InizioMeseIG.getSelectedItem() + "-" + step2InizioGiornoIG.getSelectedItem();
                String dataFine;
                if(step2fineDefinita.isSelected()) {
                    dataFine = step2FineAnnoIG.getSelectedItem() + "-" + step2FineMeseIG.getSelectedItem() + "-" + step2FineGiornoIG.getSelectedItem();
                } else {
                    dataFine = null;
                }

                int i = controller.checkMilitanza(dataNascita, dataInizio, dataFine);

                if(i == 0) {
                    s3confermaErroreLabelIG.setVisible(false);

                    Date dataNascitaDate;
                    Optional<Date> dataRitiroDate;
                    Date dataInizioDate;
                    Optional<Date> dataFineDate;

                    try {

                        dataNascitaDate = (dataNascita != null) ? new Date(dateFormat.parse(dataNascita).getTime()) : null;
                        dataRitiroDate = Optional.ofNullable(dataRitiroString)
                                .map(str -> {
                                    try {
                                        return new Date(dateFormat.parse(str).getTime());
                                    } catch (ParseException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                });
                        dataInizioDate = (dataInizio != null) ? new Date(dateFormat.parse(dataInizio).getTime()) : null;
                        dataFineDate = Optional.ofNullable(dataFine)
                                .map(str -> {
                                    try {
                                        return new Date(dateFormat.parse(str).getTime());
                                    } catch (ParseException ex) {
                                        throw new RuntimeException(ex);
                                    }
                                });

                        int tiriSegnati = Integer.parseInt(step2TiriSegnatiFieldIG.getText());
                        int partiteGiocate = Integer.parseInt(step2PartiteGiocateFieldIG.getText());

                        String ruoli = "";
                        String goalSubiti = null;

                        //inserisco tupla ruolo dopo averla creata
                        if (portiere.isSelected()) {
                            ruoli = ruoli + '_' + "portiere";
                            goalSubiti = step2GoalSubitiFieldIG.getText();
                        } else {
                            goalSubiti = null;
                        }
                        if (difensore.isSelected()) {
                            ruoli = ruoli + '_' + "difensore";
                        }
                        if (centrocampista.isSelected()) {
                            ruoli = ruoli + '_' + "centrocampista";
                        }
                        if (attaccante.isSelected()) {
                            ruoli = ruoli + '_' + "attaccante";
                        }
                        if (ruoli.length() > 0 && ruoli.charAt(0) == '_') {
                            ruoli = ruoli.substring(1);
                        }

                        String nomeSquadra = null;
                        String nazSquadra = null;
                        String nomeSponsor = null;

                        if(s3InserisciSquadraRadioIG.isSelected()) {
                            nomeSquadra = s3InserisciNomeSquadraFieldIG.getText();
                            nazSquadra = (String) s3InserisciNazionalitaSquadraComboIG.getSelectedItem();
                            nomeSponsor = s3InserisciSponsorTecSquadraFieldIG.getText();
                        }
                        else if (s3TrovaSquadraRadioIG.isSelected()) {
                            nomeSquadra = (String) s3TrovaSquadraComboIG.getSelectedItem();
                            nazSquadra = null;
                            nomeSponsor = null;
                        }

                        try {
                            s3confermaErroreLabelIG.setVisible(false);
                            controller.inserisci_Calc_Ruolo_Spon_Squa_Mil(nome, cognome, nazion, dataNascitaDate, dataRitiroDate, piedePR, ruoli, nomeSponsor,
                                    nomeSquadra, nazSquadra, dataInizioDate, dataFineDate, tiriSegnati, partiteGiocate, goalSubiti);

                            System.out.println("bravo");
                            inserisci.setEnabled(true);goToStep1.setVisible(false);modifica.setEnabled(true);step1Inserisci.setVisible(false);step1Inserisci.setEnabled(true);step1Modifica.setVisible(false);step1Modifica.setEnabled(true);step1LabelInserisci.setVisible(false);step1LabelModifica.setVisible(false);goToStep1.setVisible(true);step1ToStep2Modifica.setVisible(false);  step1Inserisci_Giocatore_NomeLabel.setVisible(false);step1Inserisci_Giocatore_NomeField.setVisible(false);step1Inserisci_Giocatore_CognomeLabel.setVisible(false);step1Inserisci_Giocatore_CognomeField.setVisible(false);step1PiedePRCombo.setVisible(false);step1PiedePRLabel.setVisible(false);portiere.setVisible(false);difensore.setVisible(false);centrocampista.setVisible(false);attaccante.setVisible(false);ruoloLabel.setVisible(false);step1Inserisci_DataRitiroLabel.setVisible(false);step1Inserisci_DataRitiroGiorno.setVisible(false);step1Inserisci_DataRitiroGiorno.setEnabled(true);step1Inserisci_DataRitiroGiorno.setSelectedIndex(0);step1InserireDataRitiroRadioIG.setVisible(false);step1InserireDataRitiroRadioIG.setSelected(false);step1NonInserireDataRitiroRadioIG.setVisible(false);step1NonInserireDataRitiroRadioIG.setSelected(false);step1InserireDataRitiroRadioIG.setEnabled(true);step1NonInserireDataRitiroRadioIG.setEnabled(true);step1Inserisci_DataRitiroMese.setVisible(false);step1Inserisci_DataRitiroMese.setSelectedIndex(0);step1Inserisci_DataRitiroAnno.setVisible(false);step1Inserisci_DataRitiroAnno.setSelectedIndex(0);step1Inserisci_NazionalitaCombo.setVisible(false);step1Inserisci_NazionalitaLabel.setVisible(false);step1Inserisci_DataDiNascitaLabel.setVisible(false);step1Giorno.setVisible(false);step1Mese.setVisible(false);step1Anno.setVisible(false);step1annullaDataRitiroButtonIG.setVisible(false);step1confermaDataRitiroButtonIG.setVisible(false);step1confermaDataRitiroButtonIG.setEnabled(true);step1annullaDataRitiroButtonIG.setEnabled(false);step1InserireDataRitiroRadioIG.setSelected(false);step1NonInserireDataRitiroRadioIG.setSelected(false);step1Inserisci_Giocatore_NomeField.setText("");step1Inserisci_Giocatore_CognomeField.setText("");step1Inserisci_NazionalitaCombo.setSelectedIndex(0);portiere.setSelected(false);difensore.setSelected(false);centrocampista.setSelected(false);attaccante.setSelected(false);step1Giorno.setSelectedIndex(0);step1Mese.setSelectedIndex(0);step1Anno.setSelectedIndex(0);avantiToStep2InserisciGiocatore.setVisible(false);step2InizioLabelIG.setVisible(false);step2InizioAnnoIG.setVisible(false);step2InizioMeseIG.setVisible(false);step2InizioGiornoIG.setVisible(false);step2FineAnnoIG.setVisible(false);step2FineGiornoIG.setVisible(false);step2FineMeseIG.setVisible(false);step2FineLabelIG.setVisible(false);;step2confermaFineMilitanzaButton.setEnabled(true);step2annullaFineMilitanzaButton.setEnabled(true);step2TiriSegantiLabelIG.setVisible(false);step2TiriSegnatiFieldIG.setVisible(false);step2TiriSegnatiFieldIG.setText("");step2GoalSubitiFieldIG.setVisible(false);step2GoalSubitiFieldIG.setText("");step2GoalSubitiLabelIG.setVisible(false);step2PartiteGiocateFieldIG.setVisible(false);step2PartiteGiocateFieldIG.setText("");step2PartiteGiocateLabelIG.setVisible(false);indietroToStep1DaIG.setVisible(false);avantiToStep3IG.setVisible(false);s3InsSquadraLabelIG.setVisible(false);s3InserisciSquadraRadioIG.setVisible(false);s3TrovaSquadraRadioIG.setVisible(false);s3ConfermaSquadraButtonIG.setVisible(false);s3TrovaSquadraComboIG.setVisible(false);s3InserisciNomeSquadraLabelIG.setVisible(false);s3InserisciNomeSquadraFieldIG.setVisible(false);s3InserisciNomeSquadraFieldIG.setText("");s3InserisciNazionalitaSquadraLabelIG.setVisible(false);s3InserisciNazionalitaSquadraComboIG.setVisible(false);s3InserisciNazionalitaSquadraComboIG.setSelectedIndex(0);s3InserisciSponsorTecSquadraLabelIG.setVisible(false);s3InserisciSponsorTecSquadraFieldIG.setVisible(false);s3InserisciSponsorTecSquadraFieldIG.setText("");indietroToStep2DaIG.setVisible(false);confermaStep3IG.setVisible(false);erroreMilitanza.setVisible(false);erroreConfermaMetodoSquadraIG.setVisible(false);s3AnnullaMetodoSquadraIG.setVisible(false);s3TrovaSquadraRadioIG.setEnabled(true);s3InserisciSquadraRadioIG.setEnabled(true);step2InizioGiornoIG.setSelectedIndex(0);step2InizioMeseIG.setSelectedIndex(0);step2InizioAnnoIG.setSelectedIndex(0);step2FineAnnoIG.setSelectedIndex(0);step2FineGiornoIG.setSelectedIndex(0);step2FineMeseIG.setSelectedIndex(0);s3ConfermaSquadraButtonIG.setEnabled(true);scrittaErrore.setVisible(false);s3confermaErroreLabelIG.setVisible(false);step2fineAncoraInAttoRadio.setVisible(false);step2fineDefinita.setVisible(false);step2confermaFineMilitanzaButton.setVisible(false);step2confermaFineMilitanzaButton.setEnabled(true);step2confermaFineMilitanzaButton.setEnabled(false);step2annullaFineMilitanzaButton.setVisible(false);
                        } catch (SQLException ex) {

                            System.out.println("scemo");
                            s3confermaErroreLabelIG.setVisible(true);
                            s3confermaErroreLabelIG.setText("Errore SQL: " + ex.getMessage());
                        }

                    } catch (ParseException er) {
                        er.printStackTrace();
                    }
                    //errori della militanza
                } else if (i == 1) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("La fineMil non è nei mesi consentiti");
                } else if (i == 2) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("La fineMil avviene prima dell'inizioMil ");
                } else if (i == 3) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("L'inizioMil non è nei mesi consentiti");
                } else if (i == 4) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("La differenza tra nascita e inizioMil non è sufficiente");
                }
                //errore ultima page
            } else {
                s3confermaErroreLabelIG.setVisible(true);
                s3confermaErroreLabelIG.setText("Inserire tutti i campi");
            }
        }
        //CONFERMO INSERIMENTO SQUADRA E INSERISCO NEL DB
        if (e.getSource() == s1ConfermaIS) {
            s3confermaErroreLabelIG.setVisible(true);
            String nomeSquadra = s1NomeSquadraFieldIS.getText();
            String nomeSponsor = s1InserisciSponsorTecFieldIS.getText();
            String nazione = (String) s1NazionalitaComboIS.getSelectedItem();


            try{
                s3confermaErroreLabelIG.setVisible(false);
                controller.inserisciSquadra(nomeSquadra, nomeSponsor, nazione);
                inserisci.setEnabled(true);goToStep1.setVisible(false);goToStep1.setEnabled(true);modifica.setEnabled(true);step1Inserisci.setVisible(false);step1Modifica.setVisible(false);step1LabelInserisci.setVisible(false);step1LabelModifica.setVisible(false);goToStep1.setVisible(false);step1ToStep2Modifica.setVisible(false);s1NomeSquadraLabelIS.setVisible(false);s1NomeSquadraFieldIS.setVisible(false);s1NomeSquadraFieldIS.setText("");s1NazionalitaLabelIS.setVisible(false);s1NazionalitaComboIS.setVisible(false);s1NazionalitaComboIS.setSelectedIndex(0);s1InserisciSponsorTecLabelIS.setVisible(false);s1InserisciSponsorTecFieldIS.setVisible(false);s1InserisciSponsorTecFieldIS.setText("");s1ConfermaIS.setVisible(false);
                System.out.println("bravo");

            } catch (SQLException ex) {

                System.out.println("scemo");
                s3confermaErroreLabelIG.setVisible(true);
                s3confermaErroreLabelIG.setText("Errore SQL: " + ex.getMessage());
            }
        }
        //CONFERMO INSERIMENTO COMPETIZIONE E INSERISCO NEL DB
        if(e.getSource() == s1ConfermaIC) {

            if(s1InserisciNomeCompFieldIC.isValid() && s1nomeTrofeoFieldIC.isValid()) { //controllo se il nome della competizione è valido

                Integer annoInizio = Integer.parseInt((String) s1AnnoCompComboIC.getSelectedItem());
                Integer annoFine = Integer.parseInt((String) s1AnnoFineCompComboIC.getSelectedItem());

                if(annoFine > annoInizio) {
                    s3confermaErroreLabelIG.setVisible(false);

                    String nomeComp = s1InserisciNomeCompFieldIC.getText();
                    String nomeTrofeo = s1nomeTrofeoFieldIC.getText();
                    String nazione = null;
                    String tipo = null;

                    if(s1NazionaleIC.isSelected()) {
                        nazione = (String) s1CompNazComboIC.getSelectedItem();
                    } else {
                        tipo = (String) s1CompNonNazComboIC.getSelectedItem();
                    }

                    try {
                        s3confermaErroreLabelIG.setVisible(false);
                        controller.inserisciCompetizione(nomeComp, annoInizio, nazione, tipo, nomeTrofeo, annoFine);

                        inserisci.setEnabled(true);goToStep1.setVisible(false);modifica.setEnabled(true);step1Inserisci.setVisible(false);step1Inserisci.setEnabled(true);step1Modifica.setVisible(false);step1Modifica.setEnabled(true);step1LabelInserisci.setVisible(false);step1LabelModifica.setVisible(false);goToStep1.setVisible(false);goToStep1.setEnabled(true);step1ToStep2Modifica.setVisible(false);

                        s1NazionaleIC.setEnabled(true);s1NazionaleIC.setSelected(false);s1InternazionaleIC.setEnabled(true);s1InternazionaleIC.setSelected(false);s1ConfermaCompIC.setEnabled(true); s1InserisciNomeCompLabelIC.setVisible(false);s1InserisciNomeCompFieldIC.setVisible(false);s1InserisciNomeCompFieldIC.setText("");s1AnnoCompLabelIC.setVisible(false);s1AnnoCompComboIC.setVisible(false);s1AnnoCompComboIC.setSelectedIndex(0);s1nomeTrofeoLabelIC.setVisible(false);s1nomeTrofeoFieldIC.setVisible(false);s1nomeTrofeoFieldIC.setText("");s1annoFineCompLabelIC.setVisible(false);s1AnnoFineCompComboIC.setVisible(false);s1AnnoFineCompComboIC.setSelectedIndex(0);s1SelezionaTipoCompetizioneLabelIC.setVisible(false);s1NazionaleIC.setVisible(false);s1NazionaleIC.setSelected(false);s1InternazionaleIC.setVisible(false);s1InternazionaleIC.setSelected(false);s1ConfermaCompIC.setVisible(false);s1AnnullaCompIC.setVisible(false);s1AnnullaCompIC.setEnabled(false);s1ConfermaIC.setVisible(false);s1CompNonNazComboIC.setVisible(false);s1CompNonNazComboIC.setSelectedIndex(0);s1CompNazComboIC.setVisible(false);s1CompNazComboIC.setSelectedIndex(0);

                    } catch (SQLException ex) {
                        s3confermaErroreLabelIG.setVisible(true);
                        s3confermaErroreLabelIG.setText("SQL: " + ex);
                    }
                }
                else
                {   //errore data di inzio dopo di quella di fine
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("L'anno di fine e' incongruente con l'anno di inizio");
                }

            }
            else
            {   //errore campi non inseriti
                s3confermaErroreLabelIG.setVisible(true);
                s3confermaErroreLabelIG.setText("Inserire tutti i campi");
            }
        }
        //INSERIMENTO SPOSNOR SECONDARIO SUL DATABASE
        if(e.getSource()==s1ConfermaInserimentoSS) {
            if(s1InserisciNomeSponsorFieldSS.isValid()) {
                s3confermaErroreLabelIG.setVisible(false);

                String nomeSquadra = (String) s1CercaSquadraComboSS.getSelectedItem();
                String nomeSponsor = s1InserisciNomeSponsorFieldSS.getText();

                try {
                    controller.inserisciSponsorSecondario(nomeSquadra, nomeSponsor);
                    s3confermaErroreLabelIG.setVisible(false);
                    inserisci.setEnabled(true);goToStep1.setVisible(false);modifica.setEnabled(true);step1Inserisci.setVisible(false);step1Inserisci.setEnabled(true);step1Modifica.setVisible(false);step1Modifica.setEnabled(true);step1LabelInserisci.setVisible(false);step1LabelModifica.setVisible(false);goToStep1.setVisible(false);goToStep1.setEnabled(true);step1ToStep2Modifica.setVisible(false);

                    s1CercaSquadraLabelSS.setVisible(false);s1CercaSquadraComboSS.setVisible(false);s1CercaSquadraComboSS.setSelectedIndex(0);s1ConfermaSquadraButtonSS.setVisible(false);s1ConfermaSquadraButtonSS.setEnabled(true);s1AnnullaSquadraButtonSS.setVisible(false);s1AnnullaSquadraButtonSS.setEnabled(false);s1InserisciNomeSponsorLabelSS.setVisible(false);s1InserisciNomeSponsorFieldSS.setVisible(false);s1InserisciNomeSponsorFieldSS.setText("");s1ConfermaInserimentoSS.setVisible(false);
                    System.out.println("Bravo");
                } catch (SQLException ex) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("SQL error:" + ex);
                    System.out.println("scemo");
                }

            } else {
                s3confermaErroreLabelIG.setVisible(true);
                s3confermaErroreLabelIG.setText("Inserire un nome sponsor corretto");
            }
        }
        //MODIFICA MILITANZA CALCIATORE
        if(e.getSource() == s1ConfermaInserimentoMM) {

            String nome = null;
            String cognome = null;
            String nazione = null;
            Date nascita = null;

            if(s1SceltaTraGiocatoriUgualiComboMM.getSelectedItem() != null) {

                String[] partiNomeCognomeNazionalitaNascita = s1SceltaTraGiocatoriUgualiComboMM.getSelectedItem().toString().split(" ");

                nome = partiNomeCognomeNazionalitaNascita[0];
                cognome = partiNomeCognomeNazionalitaNascita[1];
                nazione = partiNomeCognomeNazionalitaNascita[2];
                nascita = Date.valueOf(partiNomeCognomeNazionalitaNascita[3]);

            }
            else
            {
                String[] partiNomeCognome = s1SelezionaGiocatoreComboMM.getSelectedItem().toString().split(" ");

                nome = partiNomeCognome[0];
                cognome = partiNomeCognome[1];
            }

            String idGiocatore = controller.getIDGiocatore(nome, cognome, nazione, nascita);

            String squadra = s1SelezionaSquadraComboMM.getSelectedItem().toString();

            String dataFineExMilitanza = null;
            String dataInizioNuovaMilitanza = s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.getSelectedItem().toString() + '-' + s1InserisciDataInizioNuovaMilitanzaMeseComboMM.getSelectedItem().toString() + '-' + s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.getSelectedItem().toString();
            String dataFineNuovaMilitanza = null;

            if(s1MilitanzaFinitaRadioMM.isSelected()) {
                dataFineNuovaMilitanza = s1InserisciDataFineNuovaMilitanzaAnnoComboMM.getSelectedItem().toString() + '-' + s1InserisciDataFineNuovaMilitanzaMeseComboMM.getSelectedItem().toString() + '-' + s1InserisciDataFineNuovaMilitanzaGiornoComboMM.getSelectedItem().toString();
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            Optional<Date> dataFineExMilitanzaDate;
            Date dataInizioNuovaMilitanzaDate;
            Optional<Date> dataFineNuovaMilitanzaDate;

            Date checkLastMil = controller.checkLastMil(idGiocatore);

            if(checkLastMil == null) {
                dataFineExMilitanza = s1InserisciDataFineExMilitanzaAnnoComboMM.getSelectedItem().toString() + '-' + s1InserisciDataFineExMilitanzaMeseComboMM.getSelectedItem().toString() + '-' + s1InserisciDataFineExMilitanzaGiornoComboMM.getSelectedItem().toString();
            }

            try {

                dataInizioNuovaMilitanzaDate = (dataInizioNuovaMilitanza != null) ? new Date(dateFormat.parse(dataInizioNuovaMilitanza).getTime()) : null;
                dataFineNuovaMilitanzaDate = Optional.ofNullable(dataFineNuovaMilitanza)
                        .map(str -> {
                            try {
                                return new Date(dateFormat.parse(str).getTime());
                            } catch (ParseException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                dataFineExMilitanzaDate = Optional.ofNullable(dataFineExMilitanza)
                        .map(str -> {
                            try {
                                return new Date(dateFormat.parse(str).getTime());
                            } catch (ParseException ex) {
                                throw new RuntimeException(ex);
                            }
                        });

                try {
                    String partiteGiocate = s1InserisciPartiteGiocateFieldMM.getText();
                    String tiriSegnati = s1InserisciTiriSegnatiFieldMM.getText();
                    String goalSubiti = s1InserisciGoalSubitiFieldMM.getText();

                    if(goalSubiti.isEmpty()) {
                        goalSubiti = null;
                    } else {
                        int goalSubitiInt = Integer.parseInt(goalSubiti);
                    }

                    if(!partiteGiocate.isEmpty() || !tiriSegnati.isEmpty()) {
                        int partiteGiocateInt = Integer.parseInt(partiteGiocate);
                        int tiriSegnatiInt = Integer.parseInt(tiriSegnati);

                        try {
                            s3confermaErroreLabelIG.setVisible(false);
                            System.out.println(idGiocatore + dataFineExMilitanzaDate + dataInizioNuovaMilitanzaDate +
                                    dataFineNuovaMilitanzaDate + squadra + tiriSegnatiInt + partiteGiocateInt + goalSubiti);
                            controller.inserisciMilitanza(idGiocatore, dataFineExMilitanzaDate, dataInizioNuovaMilitanzaDate,
                                    dataFineNuovaMilitanzaDate, squadra, tiriSegnatiInt, partiteGiocateInt, goalSubiti);


                            goToStep1.setEnabled(true);
                            goToStep1.setVisible(false);
                            step1Inserisci.setEnabled(true);
                            annulla.setVisible(false);
                            inserisci.setEnabled(true);
                            modifica.setEnabled(true);
                            step1Inserisci.setVisible(false);
                            step1Inserisci.setEnabled(true);
                            step1Modifica.setVisible(false);
                            step1Modifica.setEnabled(true);
                            step1LabelInserisci.setVisible(false);
                            step1LabelModifica.setVisible(false);
                            step1ToStep2Modifica.setVisible(false);
                            step1ToStep2Modifica.setEnabled(true);

                            s1SelezionaGiocatoreLabelMM.setVisible(false);s1SelezionaGiocatoreComboMM.setVisible(false);s1SelezionaGiocatoreComboMM.setSelectedIndex(0);s1SelezionaGiocatoreComboMM.setEnabled(true);s1ConfermaGiocatoreButtonMM.setVisible(false);s1ConfermaGiocatoreButtonMM.setEnabled(true);s1AnnullaGiocatoreButtonMM.setVisible(false);s1SceltaTraGiocatoriUgualiLabelMM.setVisible(false);s1SceltaTraGiocatoriUgualiComboMM.setVisible(false);s1ConfermaGiocatoreButton2MM.setVisible(false);s1ConfermaGiocatoreButton2MM.setEnabled(true);s1AnnullaGiocatoreButton2MM.setVisible(false);s1InserisciDataFineExMilitanzaLabelMM.setVisible(false);s1InserisciDataFineExMilitanzaGiornoComboMM.setVisible(false);s1InserisciDataFineExMilitanzaGiornoComboMM.setSelectedIndex(0);s1InserisciDataFineExMilitanzaMeseComboMM.setVisible(false);s1InserisciDataFineExMilitanzaMeseComboMM.setSelectedIndex(0);s1InserisciDataFineExMilitanzaAnnoComboMM.setVisible(false);s1InserisciDataFineExMilitanzaAnnoComboMM.setSelectedIndex(0);s1InserisciDataInizioNuovaMilitanzaLabelMM.setVisible(false);s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setVisible(false);s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setSelectedIndex(0);s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setVisible(false);s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setSelectedIndex(0);s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.setVisible(false);s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.setSelectedIndex(0);s1InserisciDataFineNuovaMilitanzaLabelMM.setVisible(false);s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setVisible(false);s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setSelectedIndex(0);s1InserisciDataFineNuovaMilitanzaMeseComboMM.setVisible(false);s1InserisciDataFineNuovaMilitanzaMeseComboMM.setSelectedIndex(0);s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setVisible(false);s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setSelectedIndex(0);s1MilitanzaInAttoRadioMM.setVisible(false);s1MilitanzaInAttoRadioMM.setSelected(false);s1MilitanzaFinitaRadioMM.setVisible(false);s1MilitanzaFinitaRadioMM.setSelected(false);s1ConfermaFineMilitanzaButtonMM.setVisible(false);s1ConfermaFineMilitanzaButtonMM.setEnabled(true);s1AnnullaFineMilitanzaButtonMM.setVisible(false);s1InserisciTiriSegnatiLabelMM.setVisible(false);s1InserisciTiriSegnatiFieldMM.setVisible(false);s1InserisciTiriSegnatiFieldMM.setText("");s1InserisciPartiteGiocateLabelMM.setVisible(false);s1InserisciPartiteGiocateFieldMM.setVisible(false);s1InserisciPartiteGiocateFieldMM.setText("");s1InserisciGoalSubitiLabelMM.setVisible(false);s1InserisciGoalSubitiFieldMM.setVisible(false);s1InserisciGoalSubitiFieldMM.setText("");s1SelezionaSquadraLabelMM.setVisible(false);s1SelezionaSquadraComboMM.setVisible(false);s1SelezionaSquadraComboMM.setSelectedIndex(0);s1ConfermaInserimentoMM.setVisible(false);s1UltimaMilitanzaLabelMM.setVisible(false);s1SceltaTraGiocatoriUgualiComboMM.removeAllItems();

                        } catch (SQLException ex) {
                            s3confermaErroreLabelIG.setVisible(true);
                            s3confermaErroreLabelIG.setText(String.valueOf(ex));
                        }
                    } else {
                        s3confermaErroreLabelIG.setVisible(true);
                        s3confermaErroreLabelIG.setText("Riempire tutti i campi");
                    }
                }
                catch(NumberFormatException em) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("Inserire esclusivamente numeri");
                    em.printStackTrace();
                }
            }
            catch (ParseException en) {
                //problemi date
                en.printStackTrace();
            }
        }
        //MODIFICA CALCIATORE
        if(e.getSource() == s1ConfermaInserimentoMC) {
            String nome = null;
            String cognome = null;
            String nazione = null;
            Date nascita = null;

            if(s1SceltaTraGiocatoriUgualiComboMC.getSelectedItem() != null) {
                String[] partiNomeCognomeNazNascita = s1SceltaTraGiocatoriUgualiComboMC.getSelectedItem().toString().split(" ");

                nome = partiNomeCognomeNazNascita[0];
                cognome = partiNomeCognomeNazNascita[1];
                nazione = partiNomeCognomeNazNascita[2];
                nascita = Date.valueOf(partiNomeCognomeNazNascita[3]);
            } else {
                String[] partiNomeCognome = s1SelezionaGiocatoreComboMC.getSelectedItem().toString().split(" ");

                nome = partiNomeCognome[0];
                cognome = partiNomeCognome[1];
            }

            String idGiocatore = controller.getIDGiocatore(nome, cognome, nazione, nascita);
            boolean checkDataRitiro = controller.checkDataRitiro(idGiocatore);
            if(!checkDataRitiro) {
                if(s1InserireDataRitiroRadioMC.isSelected()) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    String dataRitiro = s1DataRitiroAnnoComboMC.getSelectedItem().toString() + '-' + s1DataRitiroMeseComboMC.getSelectedItem().toString() + '-' + s1DataRitiroGiornoComboMC.getSelectedItem().toString();
                    Date dataRitiroDate = null;
                    try {
                        dataRitiroDate = (dataRitiro != null) ? new Date(dateFormat.parse(dataRitiro).getTime()) : null;
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    controller.inserisciDataRitiro(idGiocatore, dataRitiroDate);
                }
            }

            if(s1InserisciFeatureComboMC.getSelectedItem() != "") {
                String feature = s1InserisciFeatureComboMC.getSelectedItem().toString();
                controller.inserisciFeature(idGiocatore, feature);
            }

            goToStep1.setEnabled(true);
            goToStep1.setVisible(false);
            step1Inserisci.setEnabled(true);
            annulla.setVisible(false);
            inserisci.setEnabled(true);
            modifica.setEnabled(true);
            step1Inserisci.setVisible(false);
            step1Inserisci.setEnabled(true);
            step1Modifica.setVisible(false);
            step1Modifica.setEnabled(true);
            step1LabelInserisci.setVisible(false);
            step1LabelModifica.setVisible(false);
            step1ToStep2Modifica.setVisible(false);
            step1ToStep2Modifica.setEnabled(true);

            s1SelezionaGiocatoreLabelMC.setVisible(false);s1SelezionaGiocatoreComboMC.setVisible(false);s1SelezionaGiocatoreComboMC.removeAllItems();s1ConfermaGiocatoreButtonMC.setVisible(false);s1ConfermaGiocatoreButtonMC.setEnabled(true);s1AnnullaGiocatoreButtonMC.setVisible(false);s1AnnullaGiocatoreButtonMC.setEnabled(false);s1SceltaTraGiocatoriUgualiLabelMC.setVisible(false);s1SceltaTraGiocatoriUgualiComboMC.setVisible(false);s1SceltaTraGiocatoriUgualiComboMC.removeAllItems();s1ConfermaGiocatoreButton2MC.setVisible(false);s1ConfermaGiocatoreButton2MC.setEnabled(true);s1AnnullaGiocatoreButton2MC.setVisible(false);s1AnnullaGiocatoreButton2MC.setEnabled(false);s1InserireDataRitiroRadioMC.setVisible(false);s1InserireDataRitiroRadioMC.setEnabled(true);s1NonInserireDataRitiroRadioMC.setVisible(false);s1NonInserireDataRitiroRadioMC.setEnabled(true);s1DataRitiroLabelMC.setVisible(false);s1ConfermaSceltaRitiroButtonMC.setVisible(false);s1ConfermaSceltaRitiroButtonMC.setEnabled(true);s1AnnullaSceltaRitiroButtonMC.setVisible(false);s1AnnullaSceltaRitiroButtonMC.setEnabled(false);s1DataRitiroGiornoComboMC.setVisible(false);s1DataRitiroGiornoComboMC.setSelectedIndex(0);s1DataRitiroMeseComboMC.setVisible(false);s1DataRitiroMeseComboMC.setSelectedIndex(0);s1DataRitiroAnnoComboMC.setVisible(false);s1DataRitiroAnnoComboMC.setSelectedIndex(0);s1InserisciFeatureLabelMC.setVisible(false);s1InserisciFeatureComboMC.setVisible(false);s1InserisciFeatureComboMC.removeAllItems();s1ConfermaInserimentoMC.setVisible(false);
        }

        if(e.getSource()==s1ConfermaInserimentoISIC) {

            String squadra = s1SelezionaSquadraComboISIC.getSelectedItem().toString();
            String nomeCampionato = s1ScegliCompetizioneComboISIC.getSelectedItem().toString();
            int anno = Integer.parseInt(s1AnnoCompetizioneComboISIC.getSelectedItem().toString());
            try {
                s3confermaErroreLabelIG.setVisible(false);
                controller.inserisciSquadraInCompetizione(squadra, nomeCampionato, anno);


            } catch (SQLException el) {
                s3confermaErroreLabelIG.setVisible(true);
                s3confermaErroreLabelIG.setText("boh");
            }
            goToStep1.setEnabled(true);goToStep1.setVisible(false);step1Inserisci.setEnabled(true);annulla.setVisible(false);inserisci.setEnabled(true);modifica.setEnabled(true);step1Inserisci.setVisible(false);step1Inserisci.setEnabled(true);step1Modifica.setVisible(false);step1Modifica.setEnabled(true);step1LabelInserisci.setVisible(false);step1LabelModifica.setVisible(false);step1ToStep2Modifica.setVisible(false);step1ToStep2Modifica.setEnabled(true);

            s1ScegliCompetizioneComboISIC.setVisible(false);s1ScegliCompetizioneComboISIC.setEnabled(true);s1ScegliCompetizioneComboISIC.removeAllItems();s1ScegliCompetizioneLabelISIC.setVisible(false);s1AnnoCompetizioneComboISIC.setVisible(false);s1AnnoCompetizioneComboISIC.setEnabled(true);s1AnnoCompetizioneComboISIC.removeAllItems();s1AnnoCompetizioneLabelISIC.setVisible(false);s1ConfermaCompetizioneButtonISIC.setVisible(false);s1ConfermaCompetizioneButtonISIC.setEnabled(true);s1AnnullaCompetizioneButtonISIC.setVisible(false);s1AnnullaCompetizioneButtonISIC.setEnabled(false);s1SelezionaSquadraComboISIC.setVisible(false);s1SelezionaSquadraComboISIC.setEnabled(true);s1SelezionaSquadraComboISIC.removeAllItems();s1SelezionaSquadraLabelISIC.setVisible(false);s1ConfermaInserimentoISIC.setVisible(false);
        }

        if (e.getSource() == s1ConfermaInserimentoAT) {
            s3confermaErroreLabelIG.setVisible(false);
            String nomeTrofeo = s1SelezionaTrofeoComboAT.getSelectedItem().toString();
            int anno = Integer.parseInt(s1SceltaAnnoAssegnazioneComboAT.getSelectedItem().toString());
            String idoneoInfo = s1ScegliTraIdoneiComboAT.getSelectedItem().toString();

            if (s1TrofeoIndividualeRadioAT.isSelected()) {
                String checkPlaya = null;
                Object selectedItem = s1ScegliTraIdoneiUgualiComboAT.getSelectedItem();

                if (selectedItem != null) {
                    checkPlaya = selectedItem.toString();
                    idoneoInfo = checkPlaya;
                }

                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String nome = null;
                String cognome = null;
                String nazione = null;
                Date nascita = null;

                String[] arrayInfo = idoneoInfo.split(" ");
                for (int i = 0; i < arrayInfo.length; i++) {
                    System.out.println(arrayInfo[i]);

                }
                System.out.println(arrayInfo.length);
                if (arrayInfo.length == 2) {
                    nome = arrayInfo[0];
                    cognome = arrayInfo[1];
                } else {
                    nome = arrayInfo[0];
                    cognome = arrayInfo[1];
                    nazione = arrayInfo[2];
                    nascita = Date.valueOf(arrayInfo[3]);
                }

                String idGiocatore = controller.getIDGiocatore(nome, cognome, nazione, nascita);

                try {
                    controller.inserisciTrofeoIndividuale(nomeTrofeo, anno, idGiocatore);
                } catch (SQLException em) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("SQL:" + em);
                }
            } else {
                try {
                    controller.inserisciTrofeoDiSquadra(nomeTrofeo, anno, idoneoInfo);
                } catch (SQLException et) {
                    s3confermaErroreLabelIG.setVisible(true);
                    s3confermaErroreLabelIG.setText("SQL:" + et);
                }
            }
            goToStep1.setEnabled(true);goToStep1.setVisible(false);step1Inserisci.setEnabled(true);annulla.setVisible(false);inserisci.setEnabled(true);modifica.setEnabled(true);step1Inserisci.setVisible(false);step1Inserisci.setEnabled(true);step1Modifica.setVisible(false);step1Modifica.setEnabled(true);step1LabelInserisci.setVisible(false);step1LabelModifica.setVisible(false);step1ToStep2Modifica.setVisible(false);step1ToStep2Modifica.setEnabled(true);

            s1TrofeoIndividualeRadioAT.setVisible(false);s1TrofeoIndividualeRadioAT.setEnabled(true);s1TrofeoSquadraRadioAT.setVisible(false);s1TrofeoSquadraRadioAT.setEnabled(true);s1ConfermaSceltaTrofeoButtonAT.setVisible(false);s1ConfermaSceltaTrofeoButtonAT.setEnabled(true);s1AnnullaSceltaTrofeoButtonAT.setVisible(false);s1AnnullaSceltaTrofeoButtonAT.setEnabled(false);s1SelezionaTrofeoComboAT.setVisible(false);s1SelezionaTrofeoComboAT.setEnabled(true);s1SelezionaTrofeoComboAT.removeAll();s1SelezionaTrofeoLabelAT.setVisible(false);s1SceltaAnnoAssegnazioneLabelAT.setVisible(false);s1SceltaAnnoAssegnazioneComboAT.setVisible(false);s1SceltaAnnoAssegnazioneComboAT.setEnabled(true);s1SceltaAnnoAssegnazioneComboAT.removeAll();s1ConfermaSceltaTrofeo2ButtonAT.setVisible(false);s1ConfermaSceltaTrofeo2ButtonAT.setEnabled(true);s1AnnullaSceltaTrofeo2ButtonAT.setVisible(false);s1AnnullaSceltaTrofeo2ButtonAT.setEnabled(false);s1ScegliTraIdoneiLabelAT.setVisible(false);s1ScegliTraIdoneiComboAT.setVisible(false);s1ScegliTraIdoneiComboAT.removeAll();s1ScegliTraIdoneiUgualiLabelAT.setVisible(false);s1ScegliTraIdoneiUgualiComboAT.setVisible(false);s1ScegliTraIdoneiUgualiComboAT.removeAll();s1ConfermaInserimentoAT.setVisible(false);
        }



        if(e.getSource()==modifica) {
            inserisci.setEnabled(false);
            modifica.setEnabled(false);
            step1Modifica.setVisible(true);
            step1LabelModifica.setVisible(true);
            step1ToStep2Modifica.setVisible(true);
        }

        if(e.getSource()==annulla) {
            inserisci.setEnabled(true);
            modifica.setEnabled(true);
            step1Inserisci.setVisible(false);
            step1Inserisci.setEnabled(true);
            step1Modifica.setVisible(false);
            step1Modifica.setEnabled(true);
            step1LabelInserisci.setVisible(false);
            step1LabelModifica.setVisible(false);
            goToStep1.setVisible(true);
            step1ToStep2Modifica.setVisible(false);
            step1ToStep2Modifica.setEnabled(true);


            //INSERISCI GIOCATORE

            step1Inserisci_Giocatore_NomeLabel.setVisible(false);
            step1Inserisci_Giocatore_NomeField.setVisible(false);
            step1Inserisci_Giocatore_CognomeLabel.setVisible(false);
            step1Inserisci_Giocatore_CognomeField.setVisible(false);
            step1PiedePRCombo.setVisible(false);
            step1PiedePRLabel.setVisible(false);
            portiere.setVisible(false);
            difensore.setVisible(false);
            centrocampista.setVisible(false);
            attaccante.setVisible(false);
            ruoloLabel.setVisible(false);
            step1Inserisci_DataRitiroLabel.setVisible(false);
            step1Inserisci_DataRitiroGiorno.setVisible(false);
            step1Inserisci_DataRitiroGiorno.setEnabled(true);
            step1Inserisci_DataRitiroGiorno.setSelectedIndex(0);
            step1InserireDataRitiroRadioIG.setVisible(false);
            step1InserireDataRitiroRadioIG.setSelected(false);
            step1NonInserireDataRitiroRadioIG.setVisible(false);
            step1NonInserireDataRitiroRadioIG.setSelected(false);
            step1InserireDataRitiroRadioIG.setEnabled(true);
            step1NonInserireDataRitiroRadioIG.setEnabled(true);
            step1Inserisci_DataRitiroMese.setVisible(false);
            step1Inserisci_DataRitiroMese.setSelectedIndex(0);
            step1Inserisci_DataRitiroAnno.setVisible(false);
            step1Inserisci_DataRitiroAnno.setSelectedIndex(0);
            step1Inserisci_NazionalitaCombo.setVisible(false);
            step1Inserisci_NazionalitaLabel.setVisible(false);
            step1Inserisci_DataDiNascitaLabel.setVisible(false);
            step1Giorno.setVisible(false);
            step1Mese.setVisible(false);
            step1Anno.setVisible(false);
            step1annullaDataRitiroButtonIG.setVisible(false);
            step1confermaDataRitiroButtonIG.setVisible(false);
            step1confermaDataRitiroButtonIG.setEnabled(true);
            step1annullaDataRitiroButtonIG.setEnabled(false);
            step1InserireDataRitiroRadioIG.setSelected(false);
            step1NonInserireDataRitiroRadioIG.setSelected(false);
            step1Inserisci_Giocatore_NomeField.setText("");
            step1Inserisci_Giocatore_CognomeField.setText("");
            step1Inserisci_NazionalitaCombo.setSelectedIndex(0);
            portiere.setSelected(false);
            difensore.setSelected(false);
            centrocampista.setSelected(false);
            attaccante.setSelected(false);
            step1Giorno.setSelectedIndex(0);
            step1Mese.setSelectedIndex(0);
            step1Anno.setSelectedIndex(0);
            avantiToStep2InserisciGiocatore.setVisible(false);
            step2InizioLabelIG.setVisible(false);
            step2InizioAnnoIG.setVisible(false);
            step2InizioMeseIG.setVisible(false);
            step2InizioGiornoIG.setVisible(false);
            step2FineAnnoIG.setVisible(false);
            step2FineGiornoIG.setVisible(false);
            step2FineMeseIG.setVisible(false);
            step2FineLabelIG.setVisible(false);;
            step2confermaFineMilitanzaButton.setEnabled(true);
            step2annullaFineMilitanzaButton.setEnabled(true);
            step2TiriSegantiLabelIG.setVisible(false);
            step2TiriSegnatiFieldIG.setVisible(false);
            step2TiriSegnatiFieldIG.setText("");
            step2GoalSubitiFieldIG.setVisible(false);
            step2GoalSubitiFieldIG.setText("");
            step2GoalSubitiLabelIG.setVisible(false);
            step2PartiteGiocateFieldIG.setVisible(false);
            step2PartiteGiocateFieldIG.setText("");
            step2PartiteGiocateLabelIG.setVisible(false);
            indietroToStep1DaIG.setVisible(false);
            avantiToStep3IG.setVisible(false);
            s3InsSquadraLabelIG.setVisible(false);
            s3InserisciSquadraRadioIG.setVisible(false);
            s3TrovaSquadraRadioIG.setVisible(false);
            s3ConfermaSquadraButtonIG.setVisible(false);
            s3TrovaSquadraComboIG.setVisible(false);
            s3InserisciNomeSquadraLabelIG.setVisible(false);
            s3InserisciNomeSquadraFieldIG.setVisible(false);
            s3InserisciNomeSquadraFieldIG.setText("");
            s3InserisciNazionalitaSquadraLabelIG.setVisible(false);
            s3InserisciNazionalitaSquadraComboIG.setVisible(false);
            s3InserisciNazionalitaSquadraComboIG.setSelectedIndex(0);
            s3InserisciSponsorTecSquadraLabelIG.setVisible(false);
            s3InserisciSponsorTecSquadraFieldIG.setVisible(false);
            s3InserisciSponsorTecSquadraFieldIG.setText("");
            indietroToStep2DaIG.setVisible(false);
            confermaStep3IG.setVisible(false);
            erroreMilitanza.setVisible(false);
            erroreConfermaMetodoSquadraIG.setVisible(false);
            s3AnnullaMetodoSquadraIG.setVisible(false);
            s3TrovaSquadraRadioIG.setEnabled(true);
            s3InserisciSquadraRadioIG.setEnabled(true);
            step2InizioGiornoIG.setSelectedIndex(0);
            step2InizioMeseIG.setSelectedIndex(0);
            step2InizioAnnoIG.setSelectedIndex(0);
            step2FineAnnoIG.setSelectedIndex(0);
            step2FineGiornoIG.setSelectedIndex(0);
            step2FineMeseIG.setSelectedIndex(0);
            s3ConfermaSquadraButtonIG.setEnabled(true);
            scrittaErrore.setVisible(false);
            s3confermaErroreLabelIG.setVisible(false);
            step2fineAncoraInAttoRadio.setVisible(false);
            step2fineDefinita.setVisible(false);
            step2confermaFineMilitanzaButton.setVisible(false);
            step2confermaFineMilitanzaButton.setEnabled(true);
            step2confermaFineMilitanzaButton.setEnabled(false);
            step2annullaFineMilitanzaButton.setVisible(false);

            //INSERISCI COMPETIZIONE

            s1InserisciNomeCompLabelIC.setVisible(false);
            s1InserisciNomeCompFieldIC.setVisible(false);
            s1InserisciNomeCompFieldIC.setText("");
            s1AnnoCompLabelIC.setVisible(false);
            s1AnnoCompComboIC.setVisible(false);
            s1AnnoCompComboIC.setSelectedIndex(0);
            s1nomeTrofeoLabelIC.setVisible(false);
            s1nomeTrofeoFieldIC.setVisible(false);
            s1nomeTrofeoFieldIC.setText("");
            s1annoFineCompLabelIC.setVisible(false);
            s1AnnoFineCompComboIC.setVisible(false);
            s1AnnoFineCompComboIC.setSelectedIndex(0);
            s1SelezionaTipoCompetizioneLabelIC.setVisible(false);
            s1NazionaleIC.setVisible(false);
            s1NazionaleIC.setSelected(false);
            s1InternazionaleIC.setVisible(false);
            s1InternazionaleIC.setSelected(false);
            s1ConfermaCompIC.setVisible(false);
            s1AnnullaCompIC.setVisible(false);
            s1AnnullaCompIC.setEnabled(false);
            s1ConfermaIC.setVisible(false);
            s1CompNonNazComboIC.setVisible(false);
            s1CompNonNazComboIC.setSelectedIndex(0);
            s1CompNazComboIC.setVisible(false);
            s1CompNazComboIC.setSelectedIndex(0);

            //INSERISCI SQUADRA

            s1NomeSquadraLabelIS.setVisible(false);
            s1NomeSquadraFieldIS.setVisible(false);
            s1NomeSquadraFieldIS.setText("");
            s1NazionalitaLabelIS.setVisible(false);
            s1NazionalitaComboIS.setVisible(false);
            s1NazionalitaComboIS.setSelectedIndex(0);
            s1InserisciSponsorTecLabelIS.setVisible(false);
            s1InserisciSponsorTecFieldIS.setVisible(false);
            s1InserisciSponsorTecFieldIS.setText("");
            s1ConfermaIS.setVisible(false);

            //INSERISCI SPONSOR SECONDARIO

            s1CercaSquadraLabelSS.setVisible(false);
            s1CercaSquadraComboSS.setVisible(false);
            s1CercaSquadraComboSS.setSelectedIndex(0);
            s1ConfermaSquadraButtonSS.setVisible(false);
            s1ConfermaSquadraButtonSS.setEnabled(true);
            s1AnnullaSquadraButtonSS.setVisible(false);
            s1AnnullaSquadraButtonSS.setEnabled(false);
            s1InserisciNomeSponsorLabelSS.setVisible(false);
            s1InserisciNomeSponsorFieldSS.setVisible(false);
            s1InserisciNomeSponsorFieldSS.setText("");
            s1ConfermaInserimentoSS.setVisible(false);

            //MODIFICA MILITANZA
            s1SelezionaGiocatoreLabelMM.setVisible(false);
            s1SelezionaGiocatoreComboMM.setVisible(false);
            s1SelezionaGiocatoreComboMM.setEnabled(true);
            s1ConfermaGiocatoreButtonMM.setVisible(false);
            s1ConfermaGiocatoreButtonMM.setEnabled(true);
            s1AnnullaGiocatoreButtonMM.setVisible(false);
            s1SceltaTraGiocatoriUgualiLabelMM.setVisible(false);
            s1SceltaTraGiocatoriUgualiComboMM.setVisible(false);
            s1ConfermaGiocatoreButton2MM.setVisible(false);
            s1ConfermaGiocatoreButton2MM.setEnabled(true);
            s1AnnullaGiocatoreButton2MM.setVisible(false);
            s1InserisciDataFineExMilitanzaLabelMM.setVisible(false);
            s1InserisciDataFineExMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataFineExMilitanzaGiornoComboMM.setSelectedIndex(0);
            s1InserisciDataFineExMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataFineExMilitanzaMeseComboMM.setSelectedIndex(0);
            s1InserisciDataFineExMilitanzaAnnoComboMM.setVisible(false);
            s1InserisciDataFineExMilitanzaAnnoComboMM.setSelectedIndex(0);
            s1InserisciDataInizioNuovaMilitanzaLabelMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaGiornoComboMM.setSelectedIndex(0);
            s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaMeseComboMM.setSelectedIndex(0);
            s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.setVisible(false);
            s1InserisciDataInizioNuovaMilitanzaAnnoComboMM.setSelectedIndex(0);
            s1InserisciDataFineNuovaMilitanzaLabelMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaGiornoComboMM.setSelectedIndex(0);
            s1InserisciDataFineNuovaMilitanzaMeseComboMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaMeseComboMM.setSelectedIndex(0);
            s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setVisible(false);
            s1InserisciDataFineNuovaMilitanzaAnnoComboMM.setSelectedIndex(0);
            s1MilitanzaInAttoRadioMM.setVisible(false);
            s1MilitanzaInAttoRadioMM.setSelected(false);
            s1MilitanzaFinitaRadioMM.setVisible(false);
            s1MilitanzaFinitaRadioMM.setSelected(false);
            s1ConfermaFineMilitanzaButtonMM.setVisible(false);
            s1ConfermaFineMilitanzaButtonMM.setEnabled(true);
            s1AnnullaFineMilitanzaButtonMM.setVisible(false);
            s1InserisciTiriSegnatiLabelMM.setVisible(false);
            s1InserisciTiriSegnatiFieldMM.setVisible(false);
            s1InserisciTiriSegnatiFieldMM.setText("");
            s1InserisciPartiteGiocateLabelMM.setVisible(false);
            s1InserisciPartiteGiocateFieldMM.setVisible(false);
            s1InserisciPartiteGiocateFieldMM.setText("");
            s1InserisciGoalSubitiLabelMM.setVisible(false);
            s1InserisciGoalSubitiFieldMM.setVisible(false);
            s1InserisciGoalSubitiFieldMM.setText("");
            s1SelezionaSquadraLabelMM.setVisible(false);
            s1SelezionaSquadraComboMM.setVisible(false);
            s1SelezionaSquadraComboMM.setSelectedIndex(0);
            s1ConfermaInserimentoMM.setVisible(false);
            s1UltimaMilitanzaLabelMM.setVisible(false);
            s1SceltaTraGiocatoriUgualiComboMM.removeAllItems();

            //modifica calciatore
            s1SelezionaGiocatoreLabelMC.setVisible(false);
            s1SelezionaGiocatoreComboMC.setVisible(false);
            s1SelezionaGiocatoreComboMC.removeAllItems();
            s1ConfermaGiocatoreButtonMC.setVisible(false);
            s1ConfermaGiocatoreButtonMC.setEnabled(true);
            s1AnnullaGiocatoreButtonMC.setVisible(false);
            s1AnnullaGiocatoreButtonMC.setEnabled(false);
            s1SceltaTraGiocatoriUgualiLabelMC.setVisible(false);
            s1SceltaTraGiocatoriUgualiComboMC.setVisible(false);
            s1SceltaTraGiocatoriUgualiComboMC.removeAllItems();
            s1ConfermaGiocatoreButton2MC.setVisible(false);
            s1ConfermaGiocatoreButton2MC.setEnabled(true);
            s1AnnullaGiocatoreButton2MC.setVisible(false);
            s1AnnullaGiocatoreButton2MC.setEnabled(false);
            s1InserireDataRitiroRadioMC.setVisible(false);
            s1InserireDataRitiroRadioMC.setEnabled(true);
            s1NonInserireDataRitiroRadioMC.setVisible(false);
            s1NonInserireDataRitiroRadioMC.setEnabled(true);
            s1DataRitiroLabelMC.setVisible(false);
            s1ConfermaSceltaRitiroButtonMC.setVisible(false);
            s1ConfermaSceltaRitiroButtonMC.setEnabled(true);
            s1AnnullaSceltaRitiroButtonMC.setVisible(false);
            s1AnnullaSceltaRitiroButtonMC.setEnabled(false);
            s1DataRitiroGiornoComboMC.setVisible(false);
            s1DataRitiroGiornoComboMC.setSelectedIndex(0);
            s1DataRitiroMeseComboMC.setVisible(false);
            s1DataRitiroMeseComboMC.setSelectedIndex(0);
            s1DataRitiroAnnoComboMC.setVisible(false);
            s1DataRitiroAnnoComboMC.setSelectedIndex(0);
            s1InserisciFeatureLabelMC.setVisible(false);
            s1InserisciFeatureComboMC.setVisible(false);
            s1InserisciFeatureComboMC.removeAllItems();
            s1ConfermaInserimentoMC.setVisible(false);

            //INSERISCI squadra IN COMPETIZIONE
            s1ScegliCompetizioneComboISIC.setVisible(false);
            s1ScegliCompetizioneComboISIC.setEnabled(true);
            s1ScegliCompetizioneComboISIC.removeAllItems();
            s1ScegliCompetizioneLabelISIC.setVisible(false);
            s1AnnoCompetizioneComboISIC.setVisible(false);
            s1AnnoCompetizioneComboISIC.setEnabled(true);
            s1AnnoCompetizioneComboISIC.removeAllItems();
            s1AnnoCompetizioneLabelISIC.setVisible(false);
            s1ConfermaCompetizioneButtonISIC.setVisible(false);
            s1ConfermaCompetizioneButtonISIC.setEnabled(true);
            s1AnnullaCompetizioneButtonISIC.setVisible(false);
            s1AnnullaCompetizioneButtonISIC.setEnabled(false);
            s1SelezionaSquadraComboISIC.setVisible(false);
            s1SelezionaSquadraComboISIC.setEnabled(true);
            s1SelezionaSquadraComboISIC.removeAllItems();
            s1SelezionaSquadraLabelISIC.setVisible(false);
            s1ConfermaInserimentoISIC.setVisible(false);

            //ASSEGNA TROFEO
            s1TrofeoIndividualeRadioAT.setVisible(false);
            s1TrofeoIndividualeRadioAT.setEnabled(true);
            s1TrofeoSquadraRadioAT.setVisible(false);
            s1TrofeoSquadraRadioAT.setEnabled(true);
            s1ConfermaSceltaTrofeoButtonAT.setVisible(false);
            s1ConfermaSceltaTrofeoButtonAT.setEnabled(true);
            s1AnnullaSceltaTrofeoButtonAT.setVisible(false);
            s1AnnullaSceltaTrofeoButtonAT.setEnabled(false);
            s1SelezionaTrofeoComboAT.setVisible(false);
            s1SelezionaTrofeoComboAT.setEnabled(true);
            s1SelezionaTrofeoComboAT.removeAll();
            s1SelezionaTrofeoLabelAT.setVisible(false);
            s1SceltaAnnoAssegnazioneLabelAT.setVisible(false);
            s1SceltaAnnoAssegnazioneComboAT.setVisible(false);
            s1SceltaAnnoAssegnazioneComboAT.setEnabled(true);
            s1SceltaAnnoAssegnazioneComboAT.removeAll();
            s1ConfermaSceltaTrofeo2ButtonAT.setVisible(false);
            s1ConfermaSceltaTrofeo2ButtonAT.setEnabled(true);
            s1AnnullaSceltaTrofeo2ButtonAT.setVisible(false);
            s1AnnullaSceltaTrofeo2ButtonAT.setEnabled(false);
            s1ScegliTraIdoneiLabelAT.setVisible(false);
            s1ScegliTraIdoneiComboAT.setVisible(false);
            s1ScegliTraIdoneiComboAT.removeAll();
            s1ScegliTraIdoneiUgualiLabelAT.setVisible(false);
            s1ScegliTraIdoneiUgualiComboAT.setVisible(false);
            s1ScegliTraIdoneiUgualiComboAT.removeAll();
            s1ConfermaInserimentoAT.setVisible(false);

            goToStep1.setEnabled(true);
            goToStep1.setVisible(false);
            step1Inserisci.setEnabled(true);
            annulla.setVisible(false);
        }
    }
}
