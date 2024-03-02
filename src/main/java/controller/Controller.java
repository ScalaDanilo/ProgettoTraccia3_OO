package controller;

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

/**
 * The Controller class handles the business logic and serves as an intermediary between the user interface and the data access objects.
 */
public class Controller {

    /**
     * Checks the priority of a user based on the provided username and password.
     *
     * @param Username The username of the user.
     * @param Password The password of the user.
     * @return An integer representing the user priority (1 for admin, 2 for regular user, -1 for user not found).
     */
    public int checkUserEPass(String Username, String Password)
    {
        int priority = new LoginPostgreDAO().controllaPriority(Username, Password);
        return priority;
    }


    /**
     * Inserts a new user with the provided username and password.
     *
     * @param Username The username of the new user.
     * @param Password The password of the new user.
     * @throws Exception If an error occurs during user insertion.
     */
    public void insertUser(String Username, String Password) throws Exception
    {
        new RegisterPostgreDAO().insUtente(Username, Password);
    }

    /**
     * Retrieves a list of football players based on the provided name.
     *
     * @param nome The name used as a filter for retrieving players.
     * @return An ArrayList containing Calciatori objects representing the football players matching the provided name.
     */
    public ArrayList<Calciatori> visualizzaCalciatori(String nome)
    {
        ArrayList<Calciatori> calc = new ArrayList<>();

        // Iterates through the list of player data obtained from the database
        for (String c: new UtentePostgreDAO().Calciatori(nome))
        {
            // Splits the player data into individual attributes
            String[] datiCalc = (c != null) ? c.split(" ") : new String[0];
            Calciatori calciatore = new Calciatori();

            // Sets the attributes of the Calciatori object
            calciatore.setNome(datiCalc[0]);
            calciatore.setCognome(datiCalc[1]);
            calciatore.setDataNascita(datiCalc[2]);
            calciatore.setPiedePreferito(datiCalc[3]);
            calciatore.setDataRitiro(datiCalc[4]);
            calciatore.setNazionalita(datiCalc[5]);
            calciatore.setId_Giocatore(datiCalc[6]);
            calciatore.setValoreMercato(Double.valueOf(datiCalc[7]));

            // Adds the Calciatori object to the ArrayList
            calc.add(calciatore);
        }
        return calc;
    }

    /**
     * Retrieves an array of strings representing football players based on the specified role.
     *
     * @param ruolo The role used as a filter for retrieving players.
     * @return A String array containing player information matching the provided role.
     */
    public String[] visualizzaCalcRuolo(String ruolo)
    {
        return new UtentePostgreDAO().CalcRuolo(ruolo);
    }

    /**
     * Retrieves an ArrayList of football players based on the specified preferred foot.
     *
     * @param piede The preferred foot used as a filter for retrieving players.
     * @return An ArrayList of Calciatori objects containing player information matching the provided preferred foot.
     */
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

    /**
     * Retrieves an array of football players based on the specified number of goals scored.
     *
     * @param goal The number of goals used as a filter for retrieving players.
     * @return An array of strings containing information about players who have scored the specified number of goals.
     */
    public String[] visualizzaCalcGoalSegnati(int goal)
    {
        return new UtentePostgreDAO().CalcGoalSegnati(goal);
    }

    /**
     * Retrieves an array of football players based on the specified number of goals conceded.
     *
     * @param goal The number of goals conceded used as a filter for retrieving players.
     * @return An array of strings containing information about players who have conceded the specified number of goals.
     */
    public  String[] visualizzaCalcGoalSubiti(int goal)
    {
        return new UtentePostgreDAO().CalcGoalSubiti(goal);
    }

    /**
     * Retrieves an ArrayList of football players based on the specified age.
     *
     * @param eta The age used as a filter for retrieving players.
     * @return An ArrayList of Calciatori objects containing information about players who have the specified age.
     */
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

    /**
     * Retrieves an array of football players based on the specified team.
     *
     * @param squadra The team name used as a filter for retrieving players.
     * @return An array of String objects containing information about players who belong to the specified team.
     */
    public String[] visualizzaCalcSquadra(String squadra)
    {
        return new UtentePostgreDAO().CalcSquadra(squadra);
    }

    /**
     * Retrieves an array of String objects representing data for the bottom panel.
     *
     * @return An array of String objects containing information for the bottom panel.
     */
    public String[] TopBottomPanel(){return new UtentePostgreDAO().Top();}

    /**
     * Inserisci sponsor secondario.
     *
     * @param nomeSquadra the nome squadra
     * @param nomeSponsor the nome sponsor
     * @throws SQLException the sql exception
     */
    public void inserisciSponsorSecondario(String nomeSquadra, String nomeSponsor) throws SQLException {
        Squadre squadra = new Squadre(nomeSquadra);
        SponsorSecondari sponsorSecondari = new SponsorSecondari(squadra, nomeSponsor);

        HomeAdminPostgresDAO homeAdminDAO =  new HomeAdminPostgresDAO();
        homeAdminDAO.inserisciSponsorSecondario(sponsorSecondari);
    }

    /**
     * Inserisci calc ruolo spon squa mil.
     *
     * @param nome the nome
     * @param cognome the cognome
     * @param nazion the nazion
     * @param dataNascita the data nascita
     * @param dataRitiro the data ritiro
     * @param piedePR the piede pr
     * @param ruoli the ruoli
     * @param nomeSponsor the nome sponsor
     * @param nomeSquadra the nome squadra
     * @param nazSquadra the naz squadra
     * @param dataInizio the data inizio
     * @param dataFine the data fine
     * @param tiriSegnati the tiri segnati
     * @param partiteGiocate the partite giocate
     * @param goalSubiti the goal subiti
     * @throws SQLException the sql exception
     */
    public void inserisci_Calc_Ruolo_Spon_Squa_Mil(String nome, String cognome, String nazion, Date dataNascita, Optional<Date> dataRitiro, String piedePR, String ruoli, String nomeSponsor,
                                                   String nomeSquadra, String nazSquadra, Date dataInizio, Optional<Date> dataFine, int tiriSegnati, int partiteGiocate, String goalSubiti) throws SQLException{

        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();
        homeAdminDAO.inserisciCalcRuoloSponSquaMil(nome, cognome, nazion, dataNascita, dataRitiro, piedePR, ruoli, nomeSponsor, nomeSquadra,
                nazSquadra, dataInizio, dataFine, tiriSegnati, partiteGiocate, goalSubiti);

    }

    /**
     * Inserisci squadra.
     *
     * @param nomeSquadra the nome squadra
     * @param nomeSponsor the nome sponsor
     * @param nazione the nazione
     * @throws SQLException the sql exception
     */
    public void inserisciSquadra(String nomeSquadra, String nomeSponsor, String nazione) throws SQLException {

        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();
        homeAdminDAO.inserisciSquadra(nomeSquadra, nomeSponsor, nazione);
    }

    /**
     * Prendi squadre dal db string.
     *
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiSquadreDalDB() throws SQLException{
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiSquadreDalDB();
    }

    /**
     * Check militanza int.
     *
     * @param dataN the data n
     * @param dataI the data i
     * @param dataF the data f
     * @return the int
     */
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

    /**
     * Inserisci competizione.
     *
     * @param nomeComp the nome comp
     * @param annoInizio the anno inizio
     * @param nazione the nazione
     * @param tipo the tipo
     * @param nomeTrofeo the nome trofeo
     * @param annoFine the anno fine
     * @throws SQLException the sql exception
     */
    public void inserisciCompetizione(String nomeComp, Integer annoInizio, String nazione, String tipo, String nomeTrofeo, Integer annoFine) throws SQLException {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        homeAdminDAO.inserisciCompetizione(nomeComp, annoInizio, nazione, tipo, nomeTrofeo, annoFine);
    }

    /**
     * Vedi quanti calciatori int.
     *
     * @param nome the nome
     * @param cognome the cognome
     * @return the int
     */
    public int vediQuantiCalciatori(String nome, String cognome) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.vediQuantiCalciatori(nome, cognome);
    }

    /**
     * Prendi giocatori uguali dal db string.
     *
     * @param nome the nome
     * @param cognome the cognome
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiGiocatoriUgualiDalDB(String nome, String cognome) throws SQLException{
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiGiocatoriUgualiDalDB(nome, cognome);
    }

    /**
     * Prendi ruolo calciatore facile boolean.
     *
     * @param nome the nome
     * @param cognome the cognome
     * @return the boolean
     */
    public boolean prendiRuoloCalciatoreFacile(String nome, String cognome) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiRuoloCalciatoreFacile(nome, cognome);
    }

    /**
     * Prendi ruolo calciatore difficile boolean.
     *
     * @param nome the nome
     * @param cognome the cognome
     * @param nazione the nazione
     * @param nascita the nascita
     * @return the boolean
     */
    public boolean prendiRuoloCalciatoreDifficile(String nome, String cognome, String nazione, Date nascita) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiRuoloCalciatoreDifficile(nome, cognome, nazione, nascita);
    }

    /**
     * Gets id giocatore.
     *
     * @param nome the nome
     * @param cognome the cognome
     * @param nazione the nazione
     * @param nascita the nascita
     * @return the id giocatore
     */
    public String getIDGiocatore(String nome, String cognome, String nazione, Date nascita) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.getIDGiocatore(nome, cognome, nazione, nascita);
    }

    /**
     * Inserisci militanza.
     *
     * @param idGiocatore the id giocatore
     * @param dataFineExMilitanzaDate the data fine ex militanza date
     * @param dataInizioNuovaMilitanzaDate the data inizio nuova militanza date
     * @param dataFineNuovaMilitanzaDate the data fine nuova militanza date
     * @param squadra the squadra
     * @param tiriSegnatiInt the tiri segnati int
     * @param partiteGiocateInt the partite giocate int
     * @param goalSubitiInt the goal subiti int
     * @throws SQLException the sql exception
     */
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

    /**
     * Prendi giocatori string.
     *
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiGiocatori() throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiGiocatori();
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Check last mil date.
     *
     * @param idGiocatore the id giocatore
     * @return the date
     */
    public Date checkLastMil(String idGiocatore) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.checkLastMil(idGiocatore);
    }

    /**
     * Prendi feature string.
     *
     * @param id the id
     * @return the string
     */
    public String prendiFeature(String id) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiFeature(id);
    }

    /**
     * Check data ritiro boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean checkDataRitiro(String id) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.checkDataRitiro(id);
    }

    /**
     * Inserisci data ritiro.
     *
     * @param idGio the id gio
     * @param dataRitiro the data ritiro
     */
    public void inserisciDataRitiro(String idGio, Date dataRitiro) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        homeAdminDAO.inserisciDataRitiro(idGio, dataRitiro);
    }

    /**
     * Inserisci feature.
     *
     * @param idGiocatore the id giocatore
     * @param feature the feature
     */
    public void inserisciFeature(String idGiocatore, String feature) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        homeAdminDAO.inserisciFeature(idGiocatore, feature);
    }

    /**
     * Prendi competizioni string.
     *
     * @return the string
     */
    public String prendiCompetizioni() {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiCompetizioni();
    }

    /**
     * Prendi anni string.
     *
     * @param comp the comp
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiAnni(String comp) throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiAnni(comp);
        } catch(SQLException e) {
            throw e;
        }
    }

    /**
     * Check competizione string.
     *
     * @param competizione the competizione
     * @return the string
     */
    public String checkCompetizione(String competizione) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.checkCompetizione(competizione);
    }

    /**
     * Prendi squadreidonee string.
     *
     * @param comp the comp
     * @param anno the anno
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiSquadreidonee(String comp, int anno) throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiSquadreIdonee(comp, anno);
        } catch(SQLException R) {
            throw R;
        }
    }

    /**
     * Prendi trofei individuali string.
     *
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiTrofeiIndividuali() throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiTrofeiIndividuali();
        } catch (SQLException w) {
            throw w;
        }
    }

    /**
     * Prendi anni trofeo string.
     *
     * @param trofeo the trofeo
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiAnniTrofeo(String trofeo) throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiAnniTrofeo(trofeo);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Prendi giocatori validi string.
     *
     * @param anno the anno
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiGiocatoriValidi(int anno) throws SQLException{
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiGiocatoriValidi(anno);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Prendi trofei squadra string.
     *
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiTrofeiSquadra() throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiTrofeiSquadra();
        } catch(SQLException e) {
            throw e;
        }
    }

    /**
     * Prendi squadre idonee per trofeo string.
     *
     * @param anno the anno
     * @param nomeTrof the nome trof
     * @return the string
     * @throws SQLException the sql exception
     */
    public String prendiSquadreIdoneePerTrofeo(int anno, String nomeTrof) throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            return homeAdminDAO.prendiSquadreIdoneePerTrofeo(anno, nomeTrof);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Inserisci trofeo individuale.
     *
     * @param nomeTrofeo the nome trofeo
     * @param anno the anno
     * @param idGiocatore the id giocatore
     * @throws SQLException the sql exception
     */
    public void inserisciTrofeoIndividuale(String nomeTrofeo, int anno, String idGiocatore) throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            homeAdminDAO.inserisciTrofeoIndividuale(nomeTrofeo, anno, idGiocatore);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Inserisci trofeo di squadra.
     *
     * @param nomeTrofeo the nome trofeo
     * @param anno the anno
     * @param squadra the squadra
     * @throws SQLException the sql exception
     */
    public void inserisciTrofeoDiSquadra(String nomeTrofeo, int anno, String squadra) throws SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            homeAdminDAO.inserisciTrofeoIndividuale(nomeTrofeo, anno, squadra);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Inserisci squadra in competizione.
     *
     * @param nomeSq the nome sq
     * @param nomeCp the nome cp
     * @param anno the anno
     * @throws SQLException the sql exception
     */
    public void inserisciSquadraInCompetizione(String nomeSq, String nomeCp, int anno) throws  SQLException {
        try {
            HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

            homeAdminDAO.inserisciSquadraInCompetizione(nomeSq, nomeCp, anno);
        } catch(SQLException e) {
            throw  e;
        }
    }
}