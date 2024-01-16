
package view;
import model.ConnessioneDB;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class HomeAdmin implements ActionListener{
    ConnessioneDB DB = new ConnessioneDB();
    Connection conn = DB.connect_to_db("PostgreSQL16","postgres","postgres");

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
    JLabel ruolo;
    JRadioButton portiere;
    JRadioButton difensore;
    JRadioButton centrocampista;
    JRadioButton attaccante;
    JTextField step1Inserisci_NazionalitaField;
    JLabel step1Inserisci_NazionalitaLabel;
    JComboBox step1Inserisci_DataRitiroGiorno;
    JComboBox step1Inserisci_DataRitiroMese;
    JComboBox step1Inserisci_DataRitiroAnno;
    JLabel step1Inserisci_DataRitiroLabel;
    JComboBox step1Giorno;
    JComboBox step1Mese;
    JComboBox step1Anno;
    JLabel step1Inserisci_DataDiNascitaLabel;
    JButton avantiToStep2InserisciGiocatore;
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

    //////////////////////
    //STEP 1 INSERISCI COMPETIZIONE
    JLabel s1InserisciNomeCompLabelIC;
    JTextField s1InserisciNomeCompFieldIC;
    JLabel s1AnnoCompLabelIC;
    JComboBox s1AnnoCompComboIC;
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



    JComboBox step1Modifica;
    JButton step1ToStep2Modifica = new JButton("Next");

    ArrayList ListaDiSquadre = new ArrayList();



    public HomeAdmin() throws IOException {

        //Carico stemmi laterali
        BufferedImage bufferedImage = ImageIO.read(new File("C:\\Users\\lucap\\IdeaProjects\\testProgOO\\s1.png"));
        Image image = bufferedImage.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon sito = new ImageIcon(image);

        BufferedImage bufferedImage2 = ImageIO.read(new File("C:\\Users\\lucap\\IdeaProjects\\testProgOO\\f2.png"));
        Image image2 = bufferedImage2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon federico = new ImageIcon(image2);

        JLabel logoSito = new JLabel();
        logoSito.setIcon(sito);
        logoSito.setBounds(10,10,200,200);

        JLabel logoFedericoII = new JLabel();
        logoFedericoII.setIcon(federico);
        logoFedericoII.setBounds(770,10,200,200);

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
        frameAdmin.add(annulla);

        //step1 Inserisci
        String[] opzStep1Insert = {"Inserisci giocatore", "Inserisci competizione", "Inserisci sponsor secondari", "Inserisci squadra"};
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
        step1Inserisci_Giocatore_NomeField.setBounds(100, 250, 120, 40);
        step1Inserisci_Giocatore_NomeField.setVisible(false);
        frameAdmin.add(step1Inserisci_Giocatore_NomeField);

        step1Inserisci_Giocatore_NomeLabel = new JLabel("Nome:");
        step1Inserisci_Giocatore_NomeLabel.setBounds(10, 250, 70, 40);
        step1Inserisci_Giocatore_NomeLabel.setFont(new Font("Consolas", Font.PLAIN, 14));
        step1Inserisci_Giocatore_NomeLabel.setVisible(false);
        frameAdmin.add(step1Inserisci_Giocatore_NomeLabel);

        //cognome
        step1Inserisci_Giocatore_CognomeField = new JTextField();
        step1Inserisci_Giocatore_CognomeField.setBounds(100, 320, 120, 40);
        step1Inserisci_Giocatore_CognomeField.setVisible(false);
        frameAdmin.add(step1Inserisci_Giocatore_CognomeField);

        step1Inserisci_Giocatore_CognomeLabel = new JLabel("Cognome:");
        step1Inserisci_Giocatore_CognomeLabel.setBounds(10, 320, 70, 40);
        step1Inserisci_Giocatore_CognomeLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        step1Inserisci_Giocatore_CognomeLabel.setVisible(false);
        frameAdmin.add(step1Inserisci_Giocatore_CognomeLabel);

        //Ruolo

        ruolo = new JLabel("Ruolo:");
        ruolo.setBounds(10, 380, 70, 40);
        ruolo.setFont(new Font("Consolas", Font.PLAIN, 13));ruolo.setVisible(false);
        frameAdmin.add(ruolo);

        portiere = new JRadioButton("Portiere");
        portiere.setVisible(false);
        portiere.setBounds(100, 400, 80, 30);
        portiere.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(portiere);

        difensore = new JRadioButton("Difensore");
        difensore.setVisible(false);
        difensore.setBounds(100, 440, 80, 30);
        difensore.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(difensore);

        centrocampista = new JRadioButton("Centrocampista");
        centrocampista.setVisible(false);
        centrocampista.setBounds(100, 480, 120, 30);
        centrocampista.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(centrocampista);

        attaccante = new JRadioButton("Attaccante");
        attaccante.setVisible(false);
        attaccante.setBounds(100, 520, 120, 30);
        attaccante.setBackground(Color.LIGHT_GRAY);
        frameAdmin.add(attaccante);

        //Nazionalità

        step1Inserisci_NazionalitaLabel = new JLabel("Nazionalita':");
        step1Inserisci_NazionalitaLabel.setBounds(260, 250, 120, 40);
        step1Inserisci_NazionalitaLabel.setVisible(false);
        step1Inserisci_NazionalitaLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        frameAdmin.add(step1Inserisci_NazionalitaLabel);

        step1Inserisci_NazionalitaField = new JTextField();
        step1Inserisci_NazionalitaField.setBounds(360, 250, 120, 40);
        step1Inserisci_NazionalitaField.setVisible(false);
        frameAdmin.add(step1Inserisci_NazionalitaField);

        //Data Ritiro

        String[] giorni = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        step1Inserisci_DataRitiroGiorno = new JComboBox(giorni);
        step1Inserisci_DataRitiroGiorno.setVisible(false);
        step1Inserisci_DataRitiroGiorno.setBounds(10, 590, 60, 30);
        frameAdmin.add(step1Inserisci_DataRitiroGiorno);

        String[] mesi = {"1","2","3","4","5","6","7","8","9","10","11","12"};
        step1Inserisci_DataRitiroMese = new JComboBox(mesi);
        step1Inserisci_DataRitiroMese.setVisible(false);
        step1Inserisci_DataRitiroMese.setBounds(90, 590, 60, 30);
        frameAdmin.add(step1Inserisci_DataRitiroMese);

        String[] anniRitiro = {"2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2036", "2035"};
        step1Inserisci_DataRitiroAnno = new JComboBox(anniRitiro);
        step1Inserisci_DataRitiroAnno.setVisible(false);
        step1Inserisci_DataRitiroAnno.setBounds(170, 590, 60, 30);
        frameAdmin.add(step1Inserisci_DataRitiroAnno);

        step1Inserisci_DataRitiroLabel = new JLabel("Data Ritiro:");
        step1Inserisci_DataRitiroLabel.setBounds(10, 560, 120, 40);
        step1Inserisci_DataRitiroLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        step1Inserisci_DataRitiroLabel.setVisible(false);
        frameAdmin.add(step1Inserisci_DataRitiroLabel);

        //Data di Nascita

        step1Inserisci_DataDiNascitaLabel = new JLabel("Data Di Nascita:");
        step1Inserisci_DataDiNascitaLabel.setBounds(260, 320, 120, 40);
        step1Inserisci_DataDiNascitaLabel.setFont(new Font("Consolas", Font.PLAIN, 13));
        step1Inserisci_DataDiNascitaLabel.setVisible(false);
        frameAdmin.add(step1Inserisci_DataDiNascitaLabel);

        step1Giorno = new JComboBox(giorni);
        step1Giorno.setBounds(300, 380, 60, 30);
        step1Giorno.setVisible(false);
        frameAdmin.add(step1Giorno);

        step1Mese = new JComboBox(mesi);
        step1Mese.setBounds(390, 380, 60, 30);
        step1Mese.setVisible(false);
        frameAdmin.add(step1Mese);

        String[] anni = {"2024", "2023", "2022", "2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924","1924","1923","1922","1921","1920","1919"};
        step1Anno = new JComboBox(anni);
        step1Anno.setBounds(480, 380, 60, 30);
        step1Anno.setVisible(false);
        frameAdmin.add(step1Anno);

        //tasto avanti fino a step 2 inserisci

        avantiToStep2InserisciGiocatore = new JButton("Avanti");
        avantiToStep2InserisciGiocatore.setBounds(650, 300, 100, 40);
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


        //Inizio Militanza

        step2InizioLabelIG = new JLabel("Data inizio militanza:");
        step2InizioLabelIG.setBounds(10,250,200,50);
        step2InizioLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2InizioLabelIG.setVisible(false);
        frameAdmin.add(step2InizioLabelIG);

        step2InizioGiornoIG = new JComboBox(giorni);
        step2InizioGiornoIG.setBounds(10, 300, 50, 25);
        step2InizioGiornoIG.setVisible(false);
        frameAdmin.add(step2InizioGiornoIG);

        step2InizioMeseIG = new JComboBox(mesi);
        step2InizioMeseIG.setBounds(70, 300, 50, 25);
        step2InizioMeseIG.setVisible(false);
        frameAdmin.add(step2InizioMeseIG);

        step2InizioAnnoIG = new JComboBox(anni);
        step2InizioAnnoIG.setBounds(130, 300, 70, 25);
        step2InizioAnnoIG.setVisible(false);
        frameAdmin.add(step2InizioAnnoIG);

        //Fine Militanza

        step2FineLabelIG = new JLabel("Data fine militanza:");
        step2FineLabelIG.setBounds(310, 250, 200, 50);
        step2FineLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2FineLabelIG.setVisible(false);
        frameAdmin.add(step2FineLabelIG);

        step2FineGiornoIG = new JComboBox(giorni);
        step2FineGiornoIG.setBounds(310, 300, 50, 25);
        step2FineGiornoIG.setVisible(false);
        frameAdmin.add(step2FineGiornoIG);

        step2FineMeseIG = new JComboBox(mesi);
        step2FineMeseIG.setBounds(370, 300, 50, 25);
        step2FineMeseIG.setVisible(false);
        frameAdmin.add(step2FineMeseIG);

        step2FineAnnoIG = new JComboBox(anni);
        step2FineAnnoIG.setBounds(430, 300, 70, 25);
        step2FineAnnoIG.setVisible(false);
        frameAdmin.add(step2FineAnnoIG);

        //Tiri segnati

        step2TiriSegantiLabelIG = new JLabel("Inserisci il numero di goal segnati:");
        step2TiriSegantiLabelIG.setBounds(10,340,300,50);
        step2TiriSegantiLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2TiriSegantiLabelIG.setVisible(false);
        frameAdmin.add(step2TiriSegantiLabelIG);

        step2TiriSegnatiFieldIG = new JTextField();
        step2TiriSegnatiFieldIG.setBounds(110, 390, 50, 30);
        step2TiriSegnatiFieldIG.setVisible(false);
        frameAdmin.add(step2TiriSegnatiFieldIG);

        //Partite Giocate

        step2PartiteGiocateLabelIG = new JLabel("Inserisci il numero partite di giocate:");
        step2PartiteGiocateLabelIG.setBounds(310,340,300,50);
        step2PartiteGiocateLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2PartiteGiocateLabelIG.setVisible(false);
        frameAdmin.add(step2PartiteGiocateLabelIG);

        step2PartiteGiocateFieldIG = new JTextField();
        step2PartiteGiocateFieldIG.setBounds(420, 390, 50, 30);
        step2PartiteGiocateFieldIG.setVisible(false);
        frameAdmin.add(step2PartiteGiocateFieldIG);

        //Goal Subiti

        step2GoalSubitiLabelIG = new JLabel("Inserisci il numero goal di subiti:");
        step2GoalSubitiLabelIG.setBounds(10,450,300,50);
        step2GoalSubitiLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        step2GoalSubitiLabelIG.setVisible(false);
        frameAdmin.add(step2GoalSubitiLabelIG);

        step2GoalSubitiFieldIG = new JTextField();
        step2GoalSubitiFieldIG.setBounds(110, 500, 50, 30);
        step2GoalSubitiFieldIG.setVisible(false);
        frameAdmin.add(step2GoalSubitiFieldIG);

        //Tasto per ritornare Indietro

        indietroToStep1DaIG = new JButton("Indietro");
        indietroToStep1DaIG.setBounds(650, 450, 100, 40);
        indietroToStep1DaIG.setVisible(false);
        indietroToStep1DaIG.addActionListener(this);
        frameAdmin.add(indietroToStep1DaIG);

        //Tasto per andare allo step 3

        avantiToStep3IG = new JButton("Avanti");
        avantiToStep3IG.setBounds(650, 300, 100, 40);
        avantiToStep3IG.setVisible(false);
        avantiToStep3IG.addActionListener(this);
        frameAdmin.add(avantiToStep3IG);

        //erroreMilitanza

        erroreMilitanza = new JLabel("Controllare che siano stati inseriti soltanto Numeri");
        erroreMilitanza.setVisible(false);
        erroreMilitanza.setBounds(600, 450, 300, 100);
        erroreMilitanza.setFont(new Font("Consolas", Font.PLAIN, 20));
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
        s3TrovaSquadraLabelIG.setBounds(10,400,200, 50);
        s3TrovaSquadraLabelIG.setVisible(false);



        //String[] listaSquadre = DB.prendiSquadreDalDB(DB.connect_to_db("ProgDB", "postgres","6879"));
        //s3TrovaSquadraComboIG = new JComboBox(listaSquadre);
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

        String[] nazioni = {"Italia","Spagna","Germania","Inghilterra","Francia","Belgio","Portogallo","Russia"};
        s3InserisciNazionalitaSquadraComboIG = new JComboBox(nazioni);
        s3InserisciNazionalitaSquadraComboIG.setBounds(350, 440, 150, 40);
        s3InserisciNazionalitaSquadraComboIG.setVisible(false);
        frameAdmin.add(s3InserisciNazionalitaSquadraComboIG);

        //inserimento Sponsor Tec ssquadra
        s3InserisciSponsorTecSquadraLabelIG = new JLabel("Inserisci lo sponsor tecnico della squadra");
        s3InserisciSponsorTecSquadraLabelIG.setBounds(10,490, 300, 50);
        s3InserisciSponsorTecSquadraLabelIG.setVisible(false);
        s3InserisciSponsorTecSquadraLabelIG.setFont(new Font("Consolas", Font.PLAIN, 13));
        frameAdmin.add(s3InserisciSponsorTecSquadraLabelIG);

        s3InserisciSponsorTecSquadraFieldIG = new JTextField();
        s3InserisciSponsorTecSquadraFieldIG.setBounds(10, 530, 150, 40);
        s3InserisciSponsorTecSquadraFieldIG.setVisible(false);
        frameAdmin.add(s3InserisciSponsorTecSquadraFieldIG);

        //tasto per tornare allo step 2
        indietroToStep2DaIG = new JButton("Indietro");
        indietroToStep2DaIG.setBounds(650, 450, 100, 40);
        indietroToStep2DaIG.setVisible(false);
        indietroToStep2DaIG.addActionListener(this);
        frameAdmin.add(indietroToStep2DaIG);

        //tasto per confermare il tutto
        confermaStep3IG = new JButton("Conferma");
        confermaStep3IG.setBounds(650, 300, 100, 40);
        confermaStep3IG.setVisible(false);
        confermaStep3IG.addActionListener(this);
        frameAdmin.add(confermaStep3IG);

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

        //SCELTA TIPO DI COMPETIZIONE
        s1SelezionaTipoCompetizioneLabelIC =  new JLabel("Scegli di che tipo e' la competizione");
        s1SelezionaTipoCompetizioneLabelIC.setBounds(10, 380, 300, 50);
        s1SelezionaTipoCompetizioneLabelIC.setFont(new Font("Consolas", Font.PLAIN, 13));
        s1SelezionaTipoCompetizioneLabelIC.setVisible(false);
        frameAdmin.add(s1SelezionaTipoCompetizioneLabelIC);


        s1NazionaleIC = new JRadioButton("Nazionale");
        s1NazionaleIC.setBounds(10, 435, 100, 40);
        s1NazionaleIC.setBackground(Color.LIGHT_GRAY);
        s1NazionaleIC.setVisible(false);
        frameAdmin.add(s1NazionaleIC);

        s1InternazionaleIC = new JRadioButton("Internazionale");
        s1InternazionaleIC.setBounds(150, 435, 100, 40);
        s1InternazionaleIC.setBackground(Color.LIGHT_GRAY);
        s1InternazionaleIC.setVisible(false);
        frameAdmin.add(s1InternazionaleIC);

        s1GruppoTipoCompIC = new ButtonGroup();
        s1GruppoTipoCompIC.add(s1NazionaleIC);
        s1GruppoTipoCompIC.add(s1InternazionaleIC);

        //LISTA NAZIONI DA SCEGLIERE
        s1CompNazComboIC = new JComboBox(nazioni);
        s1CompNazComboIC.setBounds(10, 560, 100, 40);
        s1CompNazComboIC.setEditable(true);
        s1CompNazComboIC.setVisible(false);
        frameAdmin.add(s1CompNazComboIC);

        //LISTA INTERNAZIONALI DA SCEGLIERE
        String[] internazioanli = {"Europeo","Mondiale","Americano"};
        s1CompNonNazComboIC = new JComboBox(internazioanli);
        s1CompNonNazComboIC.setBounds(10, 560,100,40);
        s1CompNonNazComboIC.setEditable(true);
        s1CompNonNazComboIC.setVisible(false);
        frameAdmin.add(s1CompNonNazComboIC);

        //TASTO CONFERMA TIPO COMPETIZIONE
        s1ConfermaCompIC = new JButton("OK");
        s1ConfermaCompIC.setBounds(10, 490, 60,40);
        s1ConfermaCompIC.setVisible(false);
        s1ConfermaCompIC.addActionListener(this);
        frameAdmin.add(s1ConfermaCompIC);

        //TASTO ANNULLA CONFERMA TIPO COMPETIZIONE
        s1AnnullaCompIC = new JButton("ANNULLA");
        s1AnnullaCompIC.setBounds(90, 490, 120, 40);
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


        //step1 Modifica
        String[] opzStep1Edit = {"Modifica militanza giocatore", "Aggiungi militanza giocatore", "Modifica data ritiro", "Modifica competizione", "Aggiungi ruolo a calciatore"};
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
        if(e.getSource()==inserisci) {
            inserisci.setEnabled(false);
            modifica.setEnabled(false);
            step1Inserisci.setVisible(true);
            step1LabelInserisci.setVisible(true);
            goToStep1.setVisible(true);
            String intoStep2 = (String) step1Inserisci.getSelectedItem();
        }
        /////////////////////////////
        //CONTROLLO COSA è STATO SCELTO NELLA COMBO BOX DI INSERISCI
        if(e.getSource() == goToStep1) {
            String intoStep2 = (String) step1Inserisci.getSelectedItem();

            if(intoStep2!= null && intoStep2.equals("Inserisci giocatore")) {
                step1Inserisci_Giocatore_NomeLabel.setVisible(true);
                step1Inserisci_Giocatore_NomeField.setVisible(true);
                step1Inserisci_Giocatore_CognomeLabel.setVisible(true);
                step1Inserisci_Giocatore_CognomeField.setVisible(true);
                portiere.setVisible(true);
                difensore.setVisible(true);
                centrocampista.setVisible(true);
                attaccante.setVisible(true);
                ruolo.setVisible(true);
                step1Inserisci_DataRitiroLabel.setVisible(true);
                step1Inserisci_DataRitiroGiorno.setVisible(true);
                step1Inserisci_DataRitiroMese.setVisible(true);
                step1Inserisci_DataRitiroAnno.setVisible(true);
                step1Inserisci_NazionalitaField.setVisible(true);
                step1Inserisci_NazionalitaLabel.setVisible(true);
                step1Inserisci_DataDiNascitaLabel.setVisible(true);
                avantiToStep2InserisciGiocatore.setVisible(true);
                step1Giorno.setVisible(true);
                step1Mese.setVisible(true);
                step1Anno.setVisible(true);

                goToStep1.setEnabled(false);
                step1Inserisci.setEnabled(false);
            }
            else if (intoStep2!= null && intoStep2.equals("Inserisci competizione"))
            {
                goToStep1.setEnabled(false);
                step1Inserisci.setEnabled(false);

                s1InserisciNomeCompLabelIC.setVisible(true);
                s1InserisciNomeCompFieldIC.setVisible(true);
                s1AnnoCompLabelIC.setVisible(true);
                s1AnnoCompComboIC.setVisible(true);
                s1SelezionaTipoCompetizioneLabelIC.setVisible(true);
                s1NazionaleIC.setVisible(true);
                s1InternazionaleIC.setVisible(true);
                s1ConfermaCompIC.setVisible(true);
                s1AnnullaCompIC.setVisible(true);
                s1AnnullaCompIC.setEnabled(false);
                s1ConfermaIC.setVisible(true);
            }
            else if(intoStep2!= null && intoStep2.equals("Inserisci squadra"))
            {
                goToStep1.setEnabled(false);
                step1Inserisci.setEnabled(false);

                s1NomeSquadraLabelIS.setVisible(true);
                s1NomeSquadraFieldIS.setVisible(true);
                s1NazionalitaLabelIS.setVisible(true);
                s1NazionalitaComboIS.setVisible(true);
                s1InserisciSponsorTecLabelIS.setVisible(true);
                s1InserisciSponsorTecFieldIS.setVisible(true);
                s1ConfermaIS.setVisible(true);
            }
        }

        //VEDI MODO DI INSERIMENTO DELLA COMPETIZIONE (INSERIMENTO COMPETIZIONE)
        if(e.getSource()==s1ConfermaCompIC) {

            if(s1NazionaleIC.isSelected()) {
                s1CompNazComboIC.setVisible(true);
                s1ConfermaCompIC.setEnabled(false);
                s1AnnullaCompIC.setEnabled(true);
                s1NazionaleIC.setEnabled(false);
                s1InternazionaleIC.setEnabled(false);
            }
            else if (s1InternazionaleIC.isSelected())
            {
                s1CompNonNazComboIC.setVisible(true);
                s1ConfermaCompIC.setEnabled(false);
                s1AnnullaCompIC.setEnabled(true);
                s1NazionaleIC.setEnabled(false);
                s1InternazionaleIC.setEnabled(false);
            }
        }

        //ANNULLA MODO DI INSERIMENTO DELLA COMPETIZIONE (INSERIMENTO COMPETIZIONE)
        if(e.getSource()==s1AnnullaCompIC) {
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

            if (!step1Inserisci_Giocatore_NomeField.getText().isEmpty() && !step1Inserisci_Giocatore_CognomeField.getText().isEmpty() &&
                    !step1Inserisci_NazionalitaField.getText().isEmpty() && (count > 0)) {

                //nascondo i dati che non mi servono più
                step1Inserisci_Giocatore_NomeLabel.setVisible(false);
                step1Inserisci_Giocatore_NomeField.setVisible(false);
                step1Inserisci_Giocatore_CognomeLabel.setVisible(false);
                step1Inserisci_Giocatore_CognomeField.setVisible(false);
                portiere.setVisible(false);
                difensore.setVisible(false);
                centrocampista.setVisible(false);
                attaccante.setVisible(false);
                ruolo.setVisible(false);
                step1Inserisci_DataRitiroLabel.setVisible(false);
                step1Inserisci_DataRitiroGiorno.setVisible(false);
                step1Inserisci_DataRitiroMese.setVisible(false);
                step1Inserisci_DataRitiroAnno.setVisible(false);
                step1Inserisci_NazionalitaField.setVisible(false);
                step1Inserisci_NazionalitaLabel.setVisible(false);
                step1Inserisci_DataDiNascitaLabel.setVisible(false);
                avantiToStep2InserisciGiocatore.setVisible(false);
                step1Giorno.setVisible(false);
                step1Mese.setVisible(false);
                step1Anno.setVisible(false);
                scrittaErrore.setVisible(false);

                //faccio inserire i nuovi dati

                step2InizioLabelIG.setVisible(true);
                step2InizioAnnoIG.setVisible(true);
                step2InizioMeseIG.setVisible(true);
                step2InizioGiornoIG.setVisible(true);
                step2FineAnnoIG.setVisible(true);
                step2FineGiornoIG.setVisible(true);
                step2FineMeseIG.setVisible(true);
                step2FineLabelIG.setVisible(true);
                step2TiriSegantiLabelIG.setVisible(true);
                step2TiriSegnatiFieldIG.setVisible(true);
                avantiToStep3IG.setVisible(true);

                //se è stato inserito il portiere allora si chiedono anche i goal subiti
                if(portiere.isSelected()) {
                    step2GoalSubitiFieldIG.setVisible(true);
                    step2GoalSubitiLabelIG.setVisible(true);
                }

                step2PartiteGiocateFieldIG.setVisible(true);
                step2PartiteGiocateLabelIG.setVisible(true);
                indietroToStep1DaIG.setVisible(true);
            }
            else
            {
                scrittaErrore.setVisible(true);
            }
        }

        //quando si torna indietro dallo step 2 di inserisci giocatore allo step 1
        if(e.getSource()==indietroToStep1DaIG) {

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

            //faccio ricomparire la vecchia schermata
            step1Inserisci_Giocatore_NomeLabel.setVisible(true);
            step1Inserisci_Giocatore_NomeField.setVisible(true);
            step1Inserisci_Giocatore_CognomeLabel.setVisible(true);
            step1Inserisci_Giocatore_CognomeField.setVisible(true);
            portiere.setVisible(true);
            difensore.setVisible(true);
            centrocampista.setVisible(true);
            attaccante.setVisible(true);
            ruolo.setVisible(true);
            step1Inserisci_DataRitiroLabel.setVisible(true);
            step1Inserisci_DataRitiroGiorno.setVisible(true);
            step1Inserisci_DataRitiroMese.setVisible(true);
            step1Inserisci_DataRitiroAnno.setVisible(true);
            step1Inserisci_NazionalitaField.setVisible(true);
            step1Inserisci_NazionalitaLabel.setVisible(true);
            step1Inserisci_DataDiNascitaLabel.setVisible(true);
            avantiToStep2InserisciGiocatore.setVisible(true);
            step1Giorno.setVisible(true);
            step1Mese.setVisible(true);
            step1Anno.setVisible(true);
        }

        //vado allo step 3
        if(e.getSource()==avantiToStep3IG){
            String tiriSegnati = step2TiriSegnatiFieldIG.getText();
            String partiteGiocate = step2PartiteGiocateFieldIG.getText();

            if(portiere.isSelected()){
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
                    confermaStep3IG.setVisible(true);
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

                } catch(NumberFormatException er) {

                    erroreMilitanza.setVisible(true);
                }

            }
            else
            {
                try {
                    int nTiriSeg = Integer.parseInt((tiriSegnati));
                    int npartGio = Integer.parseInt((partiteGiocate));

                    s3InsSquadraLabelIG.setVisible(true);
                    s3InserisciSquadraRadioIG.setVisible(true);
                    s3TrovaSquadraRadioIG.setVisible(true);
                    s3ConfermaSquadraButtonIG.setVisible(true);
                    indietroToStep2DaIG.setVisible(true);
                    confermaStep3IG.setVisible(true);
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

                } catch(NumberFormatException er) {

                    erroreMilitanza.setVisible(true);
                }
            }
        }

        //se confermo il metodo
        if(e.getSource()==s3ConfermaSquadraButtonIG) {

            if(s3InserisciSquadraRadioIG.isSelected()) {
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
            }
            else if(s3TrovaSquadraRadioIG.isSelected())
            {
                s3AnnullaMetodoSquadraIG.setEnabled(true);
                s3TrovaSquadraLabelIG.setVisible(true);
                s3TrovaSquadraComboIG.setVisible(true);
                erroreConfermaMetodoSquadraIG.setVisible(false);
                s3InserisciSquadraRadioIG.setEnabled(false);
                s3TrovaSquadraRadioIG.setEnabled(false);
                s3ConfermaSquadraButtonIG.setEnabled(false);
            }
            else
            {
                erroreConfermaMetodoSquadraIG.setVisible(true);
            }
        }

        //se si cuol cambiare metodo
        if(e.getSource()==s3AnnullaMetodoSquadraIG) {

            if(s3InserisciSquadraRadioIG.isSelected()) {
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
            }
            else if(s3TrovaSquadraRadioIG.isSelected())
            {
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
        if(e.getSource()==indietroToStep2DaIG) {

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
            step2FineAnnoIG.setVisible(true);
            step2FineGiornoIG.setVisible(true);
            step2FineMeseIG.setVisible(true);
            step2FineLabelIG.setVisible(true);
            step2TiriSegantiLabelIG.setVisible(true);
            step2TiriSegnatiFieldIG.setVisible(true);
            avantiToStep3IG.setVisible(true);

            //se è stato inserito il portiere allora si chiedono anche i goal subiti
            if(portiere.isSelected()) {
                step2GoalSubitiFieldIG.setVisible(true);
                step2GoalSubitiLabelIG.setVisible(true);
            }

            step2PartiteGiocateFieldIG.setVisible(true);
            step2PartiteGiocateLabelIG.setVisible(true);
            indietroToStep1DaIG.setVisible(true);
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
            step1Modifica.setVisible(false);
            step1LabelInserisci.setVisible(false);
            step1LabelModifica.setVisible(false);
            goToStep1.setVisible(false);
            step1ToStep2Modifica.setVisible(false);

            //INSERISCI GIOCATORE

            step1Inserisci_Giocatore_NomeLabel.setVisible(false);
            step1Inserisci_Giocatore_NomeField.setVisible(false);
            step1Inserisci_Giocatore_CognomeLabel.setVisible(false);
            step1Inserisci_Giocatore_CognomeField.setVisible(false);
            portiere.setVisible(false);
            difensore.setVisible(false);
            centrocampista.setVisible(false);
            attaccante.setVisible(false);
            ruolo.setVisible(false);
            step1Inserisci_DataRitiroLabel.setVisible(false);
            step1Inserisci_DataRitiroGiorno.setVisible(false);
            step1Inserisci_DataRitiroGiorno.setSelectedIndex(0);
            step1Inserisci_DataRitiroMese.setVisible(false);
            step1Inserisci_DataRitiroMese.setSelectedIndex(0);
            step1Inserisci_DataRitiroAnno.setVisible(false);
            step1Inserisci_DataRitiroAnno.setSelectedIndex(0);
            step1Inserisci_NazionalitaField.setVisible(false);
            step1Inserisci_NazionalitaLabel.setVisible(false);
            step1Inserisci_DataDiNascitaLabel.setVisible(false);
            step1Giorno.setVisible(false);
            step1Mese.setVisible(false);
            step1Anno.setVisible(false);
            step1Inserisci_Giocatore_NomeField.setText("");
            step1Inserisci_Giocatore_CognomeField.setText("");
            step1Inserisci_NazionalitaField.setText("");
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
            step2FineLabelIG.setVisible(false);
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

            //INSERISCI COMPETIZIONE

            s1InserisciNomeCompLabelIC.setVisible(false);
            s1InserisciNomeCompFieldIC.setVisible(false);
            s1InserisciNomeCompFieldIC.setText("");
            s1AnnoCompLabelIC.setVisible(false);
            s1AnnoCompComboIC.setVisible(false);
            s1AnnoCompComboIC.setSelectedIndex(0);
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


            goToStep1.setEnabled(true);
            step1Inserisci.setEnabled(true);
        }
    }
}