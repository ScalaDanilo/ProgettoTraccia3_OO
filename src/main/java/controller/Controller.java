package controller;

import DAO.HomeDAO;
import PostgresDAO.HomeAdminPostgresDAO;
import PostgresDAO.LoginPostgreDAO;
import PostgresDAO.RegisterPostgreDAO;
import PostgresDAO.UtentePostgreDAO;
import model.Calciatori;
import model.SponsorSecondari;
import model.Squadre;
import java.sql.Date;
import java.util.Optional;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Controller {

    public int checkUserEPass(String Username, String Password)
    {
        int priority = new LoginPostgreDAO().controllaPriority(Username, Password);
        return priority;
    }


    public void insertUser(String Username, String Password) throws Exception
    {
        new RegisterPostgreDAO().insUtente(Username, Password);
    }

    public ArrayList<Calciatori> visualizzaCalciatori(String nome)
    {
        ArrayList<Calciatori> calc = new ArrayList<>();

        for (String c: new UtentePostgreDAO().Calciatori(nome))
        {
            String[] datiCalc = (c != null) ? c.split(" ") : new String[0];
            Calciatori calciatore = new Calciatori();
            //System.out.println(datiCalc[0] + " " + datiCalc[1] + " " + datiCalc[2] + " " + datiCalc[3] + " " + datiCalc[4] + " " + datiCalc[5] + " " + datiCalc[6] + " " + datiCalc[7]);

            calciatore.setNome(datiCalc[0]);
            calciatore.setCognome(datiCalc[1]);
            calciatore.setDataNascita(datiCalc[2]);
            calciatore.setPiedePreferito(datiCalc[3]);
            calciatore.setDataRitiro(datiCalc[4]);
            calciatore.setNazionalita(datiCalc[5]);
            calciatore.setId_Giocatore(datiCalc[6]);
            calciatore.setValoreMercato(Double.valueOf(datiCalc[7]));


            calc.add(calciatore);
        }
        return calc;
    }

    public String[] visualizzaCalcRuolo(String ruolo)
    {
        return new UtentePostgreDAO().CalcRuolo(ruolo);
    }

    public ArrayList<Calciatori> visualizzaCalcPiedePR(String piede)
    {
        ArrayList<Calciatori> calc = new ArrayList<>();

        for (String c: new UtentePostgreDAO().CalcPiede(piede))
        {
            String[] datiCalc = (c != null) ? c.split(" ") : new String[0];
            Calciatori calciatore = new Calciatori();

            calciatore.setNome(datiCalc[0]);
            calciatore.setCognome(datiCalc[1]);
            calciatore.setDataNascita(datiCalc[2]);
            calciatore.setPiedePreferito(datiCalc[3]);
            calciatore.setDataRitiro(datiCalc[4]);
            calciatore.setNazionalita(datiCalc[5]);
            calciatore.setId_Giocatore(datiCalc[6]);
            calciatore.setValoreMercato(Double.valueOf(datiCalc[7]));

            calc.add(calciatore);
        }
        return calc;
    }

    public String[] visualizzaCalcGoalSegnati(int goal)
    {
        return new UtentePostgreDAO().CalcGoalSegnati(goal);
    }

    public  String[] visualizzaCalcGoalSubiti(int goal)
    {
        return new UtentePostgreDAO().CalcGoalSubiti(goal);
    }
    public ArrayList<Calciatori> visualizzaCalcEta(int eta)
    {
        ArrayList<Calciatori> calc = new ArrayList<>();

        for (String c: new UtentePostgreDAO().CalcEta(eta))
        {
            String[] datiCalc = (c != null) ? c.split(" ") : new String[0];
            Calciatori calciatore = new Calciatori();

            calciatore.setNome(datiCalc[0]);
            calciatore.setCognome(datiCalc[1]);
            calciatore.setDataNascita(datiCalc[2]);
            calciatore.setPiedePreferito(datiCalc[3]);
            calciatore.setDataRitiro(datiCalc[4]);
            calciatore.setNazionalita(datiCalc[5]);
            calciatore.setId_Giocatore(datiCalc[6]);
            calciatore.setValoreMercato(Double.valueOf(datiCalc[7]));

            calc.add(calciatore);
        }
        return calc;
    }

    public String[] visualizzaCalcSquadra(String squadra)
    {
        return new UtentePostgreDAO().CalcSquadra(squadra);
    }

    public String[] TopBottomPanel(){return new UtentePostgreDAO().Top();}

    public void inserisciSponsorSecondario(String nomeSquadra, String nomeSponsor) throws SQLException {
        Squadre squadra = new Squadre(nomeSquadra);
        SponsorSecondari sponsorSecondari = new SponsorSecondari(squadra, nomeSponsor);

        HomeAdminPostgresDAO homeAdminDAO =  new HomeAdminPostgresDAO();
        homeAdminDAO.inserisciSponsorSecondario(sponsorSecondari);
    }
    public void inserisci_Calc_Ruolo_Spon_Squa_Mil(String nome, String cognome, String nazion, Date dataNascita, Optional<Date> dataRitiro, String piedePR, String ruoli, String nomeSponsor,
                                                   String nomeSquadra, String nazSquadra, Date dataInizio, Optional<Date> dataFine, int tiriSegnati, int partiteGiocate, String goalSubiti) throws SQLException{

        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();
        homeAdminDAO.inserisciCalcRuoloSponSquaMil(nome, cognome, nazion, dataNascita, dataRitiro, piedePR, ruoli, nomeSponsor, nomeSquadra,
                nazSquadra, dataInizio, dataFine, tiriSegnati, partiteGiocate, goalSubiti);

    }

    public void inserisciSquadra(String nomeSquadra, String nomeSponsor, String nazione) throws SQLException {

        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();
        homeAdminDAO.inserisciSquadra(nomeSquadra, nomeSponsor, nazione);
    }

    public String prendiSquadreDalDB() throws SQLException{
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiSquadreDalDB();
    }

    public int checkMilitanza(String dataN, String dataI, String dataF) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateNascita = LocalDate.parse(dataN, formatter);
        LocalDate dateInizio = LocalDate.parse(dataI, formatter);

        // Se la dataFine è null, esegui solo i controlli senza tener conto di essa
        if (dataF == null || dataF.isEmpty()) {
            // Verifica che dateInizio sia nei mesi specificati e almeno 16 anni dopo dateN
            int meseInizio = dateInizio.getMonthValue();

            if (meseInizio == 1 || meseInizio == 7 || meseInizio == 8 || meseInizio == 9) {
                // Verifica che dateI sia almeno 16 anni dopo dateN
                long differenzaAnni = ChronoUnit.YEARS.between(dateNascita, dateInizio);
                if (differenzaAnni >= 16) {
                    return 0; // Tutte le condizioni sono soddisfatte
                } else {
                    return 4; // La differenza tra dateN e dateI non è sufficiente
                }
            } else {
                return 3; // La dataI non è nei mesi consentiti
            }
        } else {
            // Se la dataFine non è nulla, esegui tutti i controlli normalmente
            LocalDate dateFine = LocalDate.parse(dataF, formatter);

            // Verifica che dateInizio sia nei mesi specificati e almeno 16 anni dopo dateN
            int meseInizio = dateInizio.getMonthValue();

            if (meseInizio == 1 || meseInizio == 7 || meseInizio == 8 || meseInizio == 9) {
                // Verifica che dateFine avvenga dopo dateInizio
                if (dateFine.isAfter(dateInizio)) {
                    // Verifica che dateFine sia nei mesi specificati
                    int meseFine = dateFine.getMonthValue();
                    if (meseFine == 1 || meseFine == 7 || meseFine == 8 || meseFine == 9) {
                        // Verifica che dateI sia almeno 16 anni dopo dateN
                        long differenzaAnni = ChronoUnit.YEARS.between(dateNascita, dateInizio);
                        if (differenzaAnni >= 16) {
                            return 0; // Tutte le condizioni sono soddisfatte
                        } else {
                            return 4; // La differenza tra dateN e dateI non è sufficiente
                        }
                    } else {
                        return 1; // La dataF non è nei mesi consentiti
                    }
                } else {
                    return 2; // La dataF non avviene dopo la dataI
                }
            } else {
                return 3; // La dataI non è nei mesi consentiti
            }
        }
    }

    public void inserisciCompetizione(String nomeComp, Integer annoInizio, String nazione, String tipo, String nomeTrofeo, Integer annoFine) throws SQLException {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        homeAdminDAO.inserisciCompetizione(nomeComp, annoInizio, nazione, tipo, nomeTrofeo, annoFine);
    }

    public int vediQuantiCalciatori(String nome, String cognome) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.vediQuantiCalciatori(nome, cognome);
    }

    public String prendiGiocatoriUgualiDalDB(String nome, String cognome) throws SQLException{
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiGiocatoriUgualiDalDB(nome, cognome);
    }
    public boolean prendiRuoloCalciatoreFacile(String nome, String cognome) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiRuoloCalciatoreFacile(nome, cognome);
    }
    public boolean prendiRuoloCalciatoreDifficile(String nome, String cognome, String nazione, Date nascita) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiRuoloCalciatoreDifficile(nome, cognome, nazione, nascita);
    }
    public String getIDGiocatore(String nome, String cognome, String nazione, Date nascita) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.getIDGiocatore(nome, cognome, nazione, nascita);
    }
    public void inserisciMilitanza (String idGiocatore, Optional<Date> dataFineExMilitanzaDate, Date dataInizioNuovaMilitanzaDate, Optional<Date> dataFineNuovaMilitanzaDate,
                                    String squadra, int tiriSegnatiInt, int partiteGiocateInt, String goalSubitiInt) throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            homeAdminDAO.inserisciMilitanza(idGiocatore, dataFineExMilitanzaDate, dataInizioNuovaMilitanzaDate,
                    dataFineNuovaMilitanzaDate, squadra, tiriSegnatiInt, partiteGiocateInt, goalSubitiInt);
        } catch(SQLException e) {
            throw e;
        }
    }
    public String prendiGiocatori() throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiGiocatori();
        } catch (SQLException e) {
            throw e;
        }
    }
    public Date checkLastMil(String idGiocatore) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.checkLastMil(idGiocatore);
    }
    public String prendiFeature(String id) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiFeature(id);
    }
    public boolean checkDataRitiro(String id) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.checkDataRitiro(id);
    }
    public void inserisciDataRitiro(String idGio, Date dataRitiro) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        homeAdminDAO.inserisciDataRitiro(idGio, dataRitiro);
    }
    public void inserisciFeature(String idGiocatore, String feature) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        homeAdminDAO.inserisciFeature(idGiocatore, feature);
    }
    public String prendiCompetizioni() {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiCompetizioni();
    }
    public String prendiAnni(String comp) throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiAnni(comp);
        } catch(SQLException e) {
            throw e;
        }
    }
    public String checkCompetizione(String competizione) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.checkCompetizione(competizione);
    }
    public String prendiSquadreidonee(String comp, int anno) throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiSquadreIdonee(comp, anno);
        } catch(SQLException R) {
            throw R;
        }
    }
    public String prendiTrofeiIndividuali() throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiTrofeiIndividuali();
        } catch (SQLException w) {
            throw w;
        }
    }
    public String prendiAnniTrofeo(String trofeo) throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiAnniTrofeo(trofeo);
        } catch (SQLException e) {
            throw e;
        }
    }
    public String prendiGiocatoriValidi(int anno) throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiGiocatoriValidi(anno);
        } catch (SQLException e) {
            throw e;
        }
    }
    public String prendiTrofeiSquadra() throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiTrofeiSquadra();
        } catch(SQLException e) {
            throw e;
        }
    }
    public String prendiSquadreIdoneePerTrofeo(int anno, String nomeTrof) throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiSquadreIdoneePerTrofeo(anno, nomeTrof);
        } catch (SQLException e) {
            throw e;
        }
    }
    public void inserisciTrofeoIndividuale(String nomeTrofeo, int anno, String idGiocatore) throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            homeAdminDAO.inserisciTrofeoIndividuale(nomeTrofeo, anno, idGiocatore);
        } catch (SQLException e) {
            throw e;
        }
    }
    public void inserisciTrofeoDiSquadra(String nomeTrofeo, int anno, String squadra) throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            homeAdminDAO.inserisciTrofeoIndividuale(nomeTrofeo, anno, squadra);
        } catch (SQLException e) {
            throw e;
        }
    }
    public void inserisciSquadraInCompetizione(String nomeSq, String nomeCp, int anno) throws  SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            homeAdminDAO.inserisciSquadraInCompetizione(nomeSq, nomeCp, anno);
        } catch(SQLException e) {
            throw  e;
        }
    }
}