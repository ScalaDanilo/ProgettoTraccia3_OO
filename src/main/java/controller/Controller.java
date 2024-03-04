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
     * Inserts a secondary sponsor for a given team.
     *
     * @param nomeSquadra The name of the team.
     * @param nomeSponsor The name of the secondary sponsor.
     * @throws SQLException if an error occurs during the insertion of the secondary sponsor.
     */
    public void inserisciSponsorSecondario(String nomeSquadra, String nomeSponsor) throws SQLException {
        Squadre squadra = new Squadre(nomeSquadra);
        SponsorSecondari sponsorSecondari = new SponsorSecondari(squadra, nomeSponsor);

        HomeAdminPostgresDAO homeAdminDAO =  new HomeAdminPostgresDAO();
        homeAdminDAO.inserisciSponsorSecondario(sponsorSecondari);
    }

    /**
     * Inserts player information along with playing position, sponsorship, and team details.
     *
     * @param nome            The first name of the player.
     * @param cognome         The last name of the player.
     * @param nazion          The nationality of the player.
     * @param dataNascita     The date of birth of the player.
     * @param dataRitiro      The optional date of retirement of the player.
     * @param piedePR         The preferred foot of the player.
     * @param ruoli           The playing position(s) of the player.
     * @param nomeSponsor     The name of the sponsor associated with the player.
     * @param nomeSquadra     The name of the team the player belongs to.
     * @param nazSquadra      The nationality of the team.
     * @param dataInizio      The start date of the player's association with the team.
     * @param dataFine        The optional end date of the player's association with the team.
     * @param tiriSegnati     The number of goals scored by the player.
     * @param partiteGiocate  The number of matches played by the player.
     * @param goalSubiti      The number of goals conceded by the player (for goalkeepers).
     * @throws SQLException if an error occurs during the insertion process.
     */
    public void inserisci_Calc_Ruolo_Spon_Squa_Mil(String nome, String cognome, String nazion, Date dataNascita, Optional<Date> dataRitiro, String piedePR, String ruoli, String nomeSponsor,
                                                   String nomeSquadra, String nazSquadra, Date dataInizio, Optional<Date> dataFine, int tiriSegnati, int partiteGiocate, String goalSubiti) throws SQLException{

        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();
        homeAdminDAO.inserisciCalcRuoloSponSquaMil(nome, cognome, nazion, dataNascita, dataRitiro, piedePR, ruoli, nomeSponsor, nomeSquadra,
                nazSquadra, dataInizio, dataFine, tiriSegnati, partiteGiocate, goalSubiti);

    }

    /**
     * Inserts a new team with the given name, primary sponsor, and nationality.
     *
     * @param nomeSquadra The name of the team.
     * @param nomeSponsor The name of the primary sponsor.
     * @param nazione      The nationality of the team.
     * @throws SQLException if an error occurs during the insertion of the team.
     */
    public void inserisciSquadra(String nomeSquadra, String nomeSponsor, String nazione) throws SQLException {

        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();
        homeAdminDAO.inserisciSquadra(nomeSquadra, nomeSponsor, nazione);
    }

    /**
     * Retrieves a string representation of teams from the database.
     *
     * @return A String containing information about teams retrieved from the database.
     * @throws SQLException if an error occurs during the retrieval process.
     */
    public String prendiSquadreDalDB() throws SQLException{
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiSquadreDalDB();
    }

    /**
     * Checks the eligibility of a player's association with a team based on birthdate, start date, and end date.
     *
     * @param dataN The player's date of birth.
     * @param dataI The start date of the player's association with the team.
     * @param dataF The optional end date of the player's association with the team.
     * @return An integer code indicating the result of the eligibility check.
     *         0 - Eligible, 1 - Invalid end date month, 2 - End date not after start date,
     *         3 - Invalid start date month, 4 - Insufficient age at the start date.
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
     * Inserts a new competition with the given details.
     *
     * @param nomeComp   The name of the competition.
     * @param annoInizio  The starting year of the competition.
     * @param nazione    The nationality of the competition.
     * @param tipo       The type of the competition.
     * @param nomeTrofeo The name of the trophy associated with the competition.
     * @param annoFine    The ending year of the competition.
     * @throws SQLException if an error occurs during the insertion of the competition.
     */
    public void inserisciCompetizione(String nomeComp, Integer annoInizio, String nazione, String tipo, String nomeTrofeo, Integer annoFine) throws SQLException {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        homeAdminDAO.inserisciCompetizione(nomeComp, annoInizio, nazione, tipo, nomeTrofeo, annoFine);
    }

    /**
     * Retrieves the number of football players with the given name and surname.
     *
     * @param nome    The first name of the player.
     * @param cognome The last name of the player.
     * @return The number of football players with the specified name and surname.
     */
    public int vediQuantiCalciatori(String nome, String cognome) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.vediQuantiCalciatori(nome, cognome);
    }
    /**
     * Retrieves information about football players with the given name and surname from the database.
     *
     * @param nome    The first name of the player.
     * @param cognome The last name of the player.
     * @return A String containing information about football players with the specified name and surname.
     * @throws SQLException if an error occurs during the retrieval process.
     */

    public String prendiGiocatoriUgualiDalDB(String nome, String cognome) throws SQLException{
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiGiocatoriUgualiDalDB(nome, cognome);
    }

    /**
     * Checks if a football player with the given name and surname has an easily determinable playing position.
     *
     * @param nome    The first name of the player.
     * @param cognome The last name of the player.
     * @return true if the playing position is easily determinable, false otherwise.
     */
    public boolean prendiRuoloCalciatoreFacile(String nome, String cognome) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiRuoloCalciatoreFacile(nome, cognome);
    }

    /**
     * Checks if a football player with the given name, surname, nationality, and date of birth has a determinable playing position.
     *
     * @param nome    The first name of the player.
     * @param cognome The last name of the player.
     * @param nazione The nationality of the player.
     * @param nascita The date of birth of the player.
     * @return true if the playing position is determinable, false otherwise.
     */
    public boolean prendiRuoloCalciatoreDifficile(String nome, String cognome, String nazione, Date nascita) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiRuoloCalciatoreDifficile(nome, cognome, nazione, nascita);
    }
    /**
     * Retrieves the ID of a football player with the given name, surname, nationality, and date of birth.
     *
     * @param nome    The first name of the player.
     * @param cognome The last name of the player.
     * @param nazione The nationality of the player.
     * @param nascita The date of birth of the player.
     * @return The ID of the football player.
     */
    public String getIDGiocatore(String nome, String cognome, String nazione, Date nascita) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.getIDGiocatore(nome, cognome, nazione, nascita);
    }
    /**
     * Inserts player affiliation details, including previous and new memberships.
     *
     * @param idGiocatore               The ID of the player.
     * @param dataFineExMilitanzaDate   The optional end date of the player's previous affiliation.
     * @param dataInizioNuovaMilitanzaDate The start date of the player's new affiliation.
     * @param dataFineNuovaMilitanzaDate   The optional end date of the player's new affiliation.
     * @param squadra                   The team the player is affiliated with.
     * @param tiriSegnatiInt            The number of goals scored by the player.
     * @param partiteGiocateInt         The number of matches played by the player.
     * @param goalSubitiInt             The number of goals conceded by the player (for goalkeepers).
     * @throws SQLException if an error occurs during the insertion process.
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
     * Retrieves information about all football players from the database.
     *
     * @return A String containing information about all football players.
     * @throws SQLException if an error occurs during the retrieval process.
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
     * Checks the last affiliation end date for a given player.
     *
     * @param idGiocatore The ID of the player.
     * @return The last affiliation end date.
     */
    public Date checkLastMil(String idGiocatore) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.checkLastMil(idGiocatore);
    }
    /**
     * Retrieves additional features associated with a player.
     *
     * @param id The ID of the player.
     * @return A String containing additional features associated with the player.
     */

    public String prendiFeature(String id) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiFeature(id);
    }
    /**
     * Checks if a player has a retirement date recorded.
     *
     * @param id The ID of the player.
     * @return true if a retirement date is recorded, false otherwise.
     */
    public boolean checkDataRitiro(String id) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.checkDataRitiro(id);
    }

    /**
     * Inserts a retirement date for a given player.
     *
     * @param idGio      The ID of the player.
     * @param dataRitiro The retirement date.
     */
    public void inserisciDataRitiro(String idGio, Date dataRitiro) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        homeAdminDAO.inserisciDataRitiro(idGio, dataRitiro);
    }

    /**
     * Inserts additional features for a player.
     *
     * @param idGiocatore The ID of the player.
     * @param feature     The additional feature to be inserted.
     */
    public void inserisciFeature(String idGiocatore, String feature) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        homeAdminDAO.inserisciFeature(idGiocatore, feature);
    }
    /**
     * Retrieves information about competitions from the database.
     *
     * @return A String containing information about competitions.
     */

    public String prendiCompetizioni() {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.prendiCompetizioni();
    }

    /**
     * Retrieves years associated with a specific competition.
     *
     * @param comp The name of the competition.
     * @return A String containing years associated with the competition.
     * @throws SQLException if an error occurs during the retrieval process.
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
     * Checks the existence of a competition.
     *
     * @param competizione The name of the competition.
     * @return A String containing information about the competition's existence.
     */
    public String checkCompetizione(String competizione) {
        HomeAdminPostgresDAO homeAdminDAO = new HomeAdminPostgresDAO();

        return homeAdminDAO.checkCompetizione(competizione);
    }

    /**
     * Retrieves eligible teams for a specific competition and year.
     *
     * @param comp The name of the competition.
     * @param anno The year of the competition.
     * @return A String containing information about eligible teams.
     * @throws SQLException if an error occurs during the retrieval process.
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
     * Retrieves information about individual trophies.
     *
     * @return A String containing information about individual trophies.
     * @throws SQLException if an error occurs during the retrieval process.
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
     * Retrieves years associated with a specific individual trophy.
     *
     * @param trofeo The name of the individual trophy.
     * @return A String containing years associated with the individual trophy.
     * @throws SQLException if an error occurs during the retrieval process.
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
     * Retrieves information about valid players for a specific year.
     *
     * @param anno The year for which players are considered valid.
     * @return A String containing information about valid players.
     * @throws SQLException if an error occurs during the retrieval process.
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
     * Retrieves information about team trophies.
     *
     * @return A String containing information about team trophies.
     * @throws SQLException if an error occurs during the retrieval process.
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
     * Retrieves eligible teams for a specific team trophy and year.
     *
     * @param anno     The year of the team trophy.
     * @param nomeTrof The name of the team trophy.
     * @return A String containing information about eligible teams for the specified team trophy and year.
     * @throws SQLException if an error occurs during the retrieval process.
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
     * Inserts an individual trophy for a player.
     *
     * @param nomeTrofeo The name of the individual trophy.
     * @param anno       The year of the individual trophy.
     * @param idGiocatore The ID of the player receiving the trophy.
     * @throws SQLException if an error occurs during the insertion process.
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
     * Inserts a team trophy for a squad.
     *
     * @param nomeTrofeo The name of the team trophy.
     * @param anno       The year of the team trophy.
     * @param squadra     The name of the squad receiving the trophy.
     * @throws SQLException if an error occurs during the insertion process.
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
     * Inserts a team into a competition for a specific year.
     *
     * @param nomeSq The name of the team.
     * @param nomeCp The name of the competition.
     * @param anno   The year of the competition.
     * @throws SQLException if an error occurs during the insertion process.
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