package PostgresDAO;

import Connessione.ConnessioneDB;
import DAO.HomeAdminDAO;
import model.SponsorSecondari;

import java.sql.*;
import java.util.Optional;

/**
 * The type Home admin postgres dao.
 */
public class HomeAdminPostgresDAO implements HomeAdminDAO {
    private String nomeDB = "DataBase DiscoveryFootball";
    private String user = "postgres";
    private String pass = "6879";
    /**
     * Retrieves a list of football teams from the database.
     *
     * @return A String containing a list of football teams.
     * @throws SQLException if an error occurs during the database operation.
     */
    @Override
    public String prendiSquadreDalDB() throws SQLException {
        String listaSquadre = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiSquadre()";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaSquadre = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (listaSquadre != null) ? listaSquadre : "";
    }
    /**
     * Inserts information about a football player, including roles, sponsorships, team affiliations, and statistics.
     *
     * @param nome            The first name of the player.
     * @param cognome         The last name of the player.
     * @param nazion          The nationality of the player.
     * @param dataNascita     The date of birth of the player.
     * @param dataRitiro      The optional retirement date of the player.
     * @param piedePR         The preferred foot of the player.
     * @param ruoli           The roles or positions played by the player.
     * @param nomeSponsor     The name of the sponsor associated with the player.
     * @param nomeSquadra     The name of the team associated with the player.
     * @param nazSquadra      The nationality of the team associated with the player.
     * @param dataInizio      The start date of the player's affiliation with the team.
     * @param dataFine        The optional end date of the player's affiliation with the team.
     * @param tiriSegnati     The number of goals scored by the player.
     * @param partiteGiocate  The number of matches played by the player.
     * @param goalSubiti      The number of goals conceded by the player (for goalkeepers).
     * @throws SQLException if an error occurs during the database operation.
     */
    @Override
    public void inserisciCalcRuoloSponSquaMil(String nome, String cognome, String nazion, Date dataNascita, Optional<Date> dataRitiro, String piedePR, String ruoli, String nomeSponsor, String nomeSquadra, String nazSquadra, Date dataInizio, Optional<Date> dataFine, int tiriSegnati, int partiteGiocate, String goalSubiti) throws SQLException {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            try (PreparedStatement preparedStatement = conn.prepareStatement(
                    "CALL inserisci_Calciatore_Ruolo_Sponsor_Squadra_Militanza(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cognome);
                preparedStatement.setString(3, nazion);
                preparedStatement.setDate(4, dataNascita);
                if (dataRitiro.isPresent()) {
                    preparedStatement.setDate(5, dataRitiro.get());
                } else {
                    preparedStatement.setNull(5, Types.DATE);
                }
                preparedStatement.setString(6, piedePR);
                preparedStatement.setString(7, ruoli);
                preparedStatement.setString(8, nomeSponsor);
                preparedStatement.setString(9, nomeSquadra);
                preparedStatement.setString(10, nazSquadra);
                preparedStatement.setDate(11, dataInizio);

                if (dataFine.isPresent()) {
                    preparedStatement.setDate(12, dataFine.get());
                } else {
                    preparedStatement.setNull(12, Types.DATE);
                }

                preparedStatement.setInt(13, tiriSegnati);
                preparedStatement.setInt(14, partiteGiocate);
                preparedStatement.setString(15, goalSubiti);

                preparedStatement.execute();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Non esiste un calciatore con questi dati");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
    }
    /**
     * Inserts information about a football team into the database.
     *
     * @param nomeSquadra The name of the football team.
     * @param nomeSponsor The name of the team's sponsor.
     * @param nazione     The nationality of the team.
     * @throws SQLException if an error occurs during the database operation.
     */
    @Override
    public void inserisciSquadra(String nomeSquadra, String nomeSponsor, String nazione) throws SQLException {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {
            String query = "CALL insert_squadra(?,?,?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nomeSquadra);
                preparedStatement.setString(2, nomeSponsor);
                preparedStatement.setString(3, nazione);

                preparedStatement.executeUpdate();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error 2");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
    }
    /**
     * Inserts information about a secondary sponsor associated with a football team.
     *
     * @param sponsorSecondari The secondary sponsor information.
     * @throws SQLException if an error occurs during the database operation.
     */
    @Override
    public void inserisciSponsorSecondario(SponsorSecondari sponsorSecondari) throws SQLException {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {
            String query = "CALL insert_sponsor_secondari(?,?,?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, sponsorSecondari.getNome());
                preparedStatement.setInt(2, sponsorSecondari.getFinanziamento());
                preparedStatement.setString(3, sponsorSecondari.getSquadra().getNomeSquadra());

                preparedStatement.executeUpdate();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error 2");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
    }
    /**
     * Inserts information about a football competition and its associated trophy.
     *
     * @param nomeComp   The name of the football competition.
     * @param annoInizio  The starting year of the competition.
     * @param nazione     The nationality of the competition.
     * @param tipo        The type of the competition.
     * @param nomeTrofeo  The name of the trophy associated with the competition.
     * @param annoFine    The ending year of the competition (optional).
     * @throws SQLException if an error occurs during the database operation.
     */
    @Override
    public void inserisciCompetizione(String nomeComp, Integer annoInizio, String nazione, String tipo, String nomeTrofeo, Integer annoFine) throws SQLException {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "CALL insert_competizione_trofeosquadra(?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nomeComp);
                preparedStatement.setInt(2, annoInizio);
                preparedStatement.setString(3, nazione);
                preparedStatement.setString(4, tipo);
                preparedStatement.setString(5, nomeTrofeo);
                preparedStatement.setInt(6, annoFine);

                preparedStatement.executeUpdate();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error 2");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
    }
    /**
     * Retrieves the count of football players with a specific name and surname.
     *
     * @param nome    The first name of the player.
     * @param cognome The last name of the player.
     * @return The count of football players with the specified name and surname.
     */

    @Override
    public int vediQuantiCalciatori(String nome, String cognome) {
        int count = 0;
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {
            String query = "SELECT COUNT(*) FROM Calciatore WHERE nome = ? AND cognome = ?";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cognome);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        count = resultSet.getInt(1);
                    }
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error 2");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
        }
        return count;
    }
    /**
     * Retrieves information about football players with the same name and surname from the database.
     *
     * @param nome    The first name of the player.
     * @param cognome The last name of the player.
     * @return A string containing information about players with the specified name and surname.
     * @throws SQLException if an error occurs during the database operation.
     */
    @Override
    public String prendiGiocatoriUgualiDalDB(String nome, String cognome) throws SQLException {
        String giocatoriUguali = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiGiocatoriUguali(?, ?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cognome);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    giocatoriUguali = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (giocatoriUguali != null) ? giocatoriUguali : "";
    }
    /**
     * Retrieves whether a football player has an easy-to-find role in the database.
     *
     * @param nome    The first name of the player.
     * @param cognome The last name of the player.
     * @return True if the player's role is easy to find, false otherwise.
     */
    @Override
    public boolean prendiRuoloCalciatoreFacile(String nome, String cognome) {
        boolean result = false;
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {
            String query = "SELECT prendiRuoloCalciatoreFacile(?, ?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cognome);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        result = resultSet.getBoolean(1);
                    }
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error 2");

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");

        }
        return result;
    }
    /**
     * Retrieves whether a football player has a difficult-to-find role in the database.
     *
     * @param nome         The first name of the player.
     * @param cognome      The last name of the player.
     * @param nazionalita  The nationality of the player.
     * @param data         The birthdate of the player.
     * @return True if the player's role is difficult to find, false otherwise.
     */
    @Override
    public boolean prendiRuoloCalciatoreDifficile(String nome, String cognome, String nazionalita, Date data) {
        boolean result = false;

        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {
            String query = "SELECT prendiRuoloCalciatoreDifficile(?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cognome);
                preparedStatement.setString(3, nazionalita);
                preparedStatement.setDate(4, data);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        result = resultSet.getBoolean(1);
                    }
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error 3");

            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");

        }
        return result;
    }
    /**
     * Retrieves the unique identifier of a football player from the database.
     *
     * @param nome      The first name of the player.
     * @param cognome   The last name of the player.
     * @param nazione   The nationality of the player.
     * @param nascita   The birthdate of the player.
     * @return The unique identifier of the player.
     */
    @Override
    public String getIDGiocatore(String nome, String cognome, String nazione, Date nascita) {
        String result = null;

        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {
            String query = "SELECT prendiIdGiocatore(?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nome);
                preparedStatement.setString(2, cognome);
                preparedStatement.setString(3, nazione);
                preparedStatement.setDate(4, nascita);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        result = resultSet.getString(1);
                    }
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error 4");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");

        }
        return result;
    }
    /**
     * Inserts information about a player's military service into the database.
     *
     * @param idGiocatore                   The unique identifier of the player.
     * @param dataFineExMilitanzaDate      The end date of the player's previous military service.
     * @param dataInizioNuovaMilitanzaDate The start date of the player's new military service.
     * @param dataFineNuovaMilitanzaDate    The end date of the player's new military service.
     * @param squadra                       The team associated with the player's military service.
     * @param tiriSegnatiInt                The number of scored shots.
     * @param partiteGiocateInt             The number of games played.
     * @param goalSubitiInt                 The number of goals conceded.
     * @throws SQLException if an error occurs during the database operation.
     */
    @Override
    public void inserisciMilitanza (String idGiocatore, Optional<Date> dataFineExMilitanzaDate, Date dataInizioNuovaMilitanzaDate, Optional<Date> dataFineNuovaMilitanzaDate,
                                    String squadra, int tiriSegnatiInt, int partiteGiocateInt, String goalSubitiInt) throws SQLException {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "CALL insert_militanza(?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {

                preparedStatement.setString(1, idGiocatore);

                System.out.println(dataFineExMilitanzaDate);
                if (dataFineExMilitanzaDate.isPresent()) {
                    preparedStatement.setDate(2, dataFineExMilitanzaDate.get());
                } else {
                    preparedStatement.setNull(2, Types.DATE);
                }
                preparedStatement.setDate(3, dataInizioNuovaMilitanzaDate);

                if (dataFineNuovaMilitanzaDate.isPresent()) {
                    preparedStatement.setDate(4, dataFineNuovaMilitanzaDate.get());
                } else {
                    preparedStatement.setNull(4, Types.DATE);
                }
                preparedStatement.setString(5, squadra);
                preparedStatement.setInt(6, tiriSegnatiInt);
                preparedStatement.setInt(7, partiteGiocateInt);
                preparedStatement.setString(8, goalSubitiInt);

                preparedStatement.executeUpdate();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("error 2");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
    }
    /**
     * Retrieves a list of football players from the database.
     *
     * @return A string containing information about all football players.
     * @throws SQLException if an error occurs during the database operation.
     */
    @Override
    public String prendiGiocatori() throws SQLException {
        String listaGiocatori = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiGiocatori()";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaGiocatori = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (listaGiocatori != null) ? listaGiocatori : "";
    }

    /**
     * Checks the date of the last military service for a football player.
     *
     * @param idGiocatore The unique identifier of the player.
     * @return The date of the last military service for the player.
     */
    @Override
    public Date checkLastMil(String idGiocatore) {
        Date check = null;
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiLastMil(?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, idGiocatore);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    check = resultSet.getDate(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
        }

        return check;
    }
    /**
     * Retrieves the features associated with a football player from the database.
     *
     * @param id The unique identifier of the player.
     * @return A string containing the features associated with the player.
     */
    @Override
    public String prendiFeature(String id) {
        String listaFeature = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendi_solo_feature_disponibili(?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaFeature = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");

        }
        return (listaFeature != null) ? listaFeature : "";
    }

    /**
     * Checks if a football player has a retirement date recorded in the database.
     *
     * @param id The unique identifier of the player.
     * @return {@code true} if the player has a retirement date, {@code false} otherwise.
     */
    @Override
    public boolean checkDataRitiro(String id) {
        Date check;
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT dataRitiro FROM calciatore WHERE TRIM(id_giocatore) LIKE TRIM(?) ";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    check = resultSet.getDate(1);

                    if(check == null) {
                        return false;
                    }
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
        }
        return true;
    }
    /**
     * Inserts a retirement date for a football player into the database.
     *
     * @param idGio The unique identifier of the player.
     * @param dataR The retirement date of the player.
     */
    @Override
    public void inserisciDataRitiro(String idGio, Date dataR) {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "UPDATE CALCIATORE SET dataRitiro = ? WHERE TRIM(id_giocatore) LIKE TRIM(?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setDate(1, dataR);
                preparedStatement.setString(2, idGio);
                int resultSet = preparedStatement.executeUpdate();

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
        }
    }
    /**
     * Inserts a feature for a football player into the database.
     *
     * @param idGiocatore The unique identifier of the player.
     * @param feature     The feature to be associated with the player.
     */
    @Override
    public void inserisciFeature(String idGiocatore, String feature) {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "INSERT INTO giocatore_possiede_feature_caratteristiche(giocatore, tipo) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, idGiocatore);
                preparedStatement.setString(2, feature);
                int resultSet = preparedStatement.executeUpdate();

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
        }
    }
    /**
     * Retrieves the list of football competitions from the database.
     *
     * @return A string containing the list of football competitions.
     */
    @Override
    public String prendiCompetizioni() {
        String listaCompetizioni = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiCompetizioni()";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaCompetizioni = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");

            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");

        }
        return (listaCompetizioni != null) ? listaCompetizioni : "";
    }
    /**
     * Retrieves the list of years associated with a specific football competition from the database.
     *
     * @param comp The name of the football competition.
     * @return A string containing the list of years for the specified competition.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public String prendiAnni(String comp) throws SQLException {
        String listaAnni = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiAnni(?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, comp);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaAnni = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (listaAnni != null) ? listaAnni : "";
    }
    /**
     * Checks the type of a football competition in the database.
     *
     * @param competizione The name of the football competition.
     * @return A string representing the type of the competition.
     */
    @Override
    public String checkCompetizione(String competizione) {
        String tipoNaz = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT checkCompetizione(?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, competizione);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    tipoNaz = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
        }
        return tipoNaz;
    }
    /**
     * Retrieves the list of eligible football teams for a specific competition and year from the database.
     *
     * @param comp The name of the football competition.
     * @param anno The year of the competition.
     * @return A string containing the list of eligible football teams.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public String prendiSquadreIdonee(String comp, int anno) throws SQLException{
        String listaSquadre = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendi_squadre_idonee(?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, comp);
                preparedStatement.setInt(2, anno);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaSquadre = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (listaSquadre != null) ? listaSquadre : "";
    }
    /**
     * Retrieves the list of individual trophies from the database.
     *
     * @return A string containing the list of individual trophies.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public String prendiTrofeiIndividuali() throws SQLException {
        String listaTrofeiIndividuali = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiTrofeiIndividuali()";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaTrofeiIndividuali = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (listaTrofeiIndividuali != null) ? listaTrofeiIndividuali : "";
    }
    /**
     * Retrieves the list of years associated with a specific trophy from the database.
     *
     * @param trofeo The name of the trophy.
     * @return A string containing the list of years for the specified trophy.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public String prendiAnniTrofeo(String trofeo) throws SQLException {
        String listaAnniTrofeo = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiAnniTrofeo(?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, trofeo);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaAnniTrofeo = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (listaAnniTrofeo != null) ? listaAnniTrofeo : "";
    }
    /**
     * Retrieves the list of valid players for a specific year from the database.
     *
     * @param anno The year for which to retrieve valid players.
     * @return A string containing the list of valid players.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public String prendiGiocatoriValidi(int anno) throws SQLException {
        String listaGiocatoriValidi = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiGiocatoriValidi(?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, anno);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaGiocatoriValidi = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (listaGiocatoriValidi != null) ? listaGiocatoriValidi : "";
    }
    /**
     * Retrieves the list of team trophies from the database.
     *
     * @return A string containing the list of team trophies.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public String prendiTrofeiSquadra() throws SQLException {
        String listaTrofeiSquadra = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiTrofeiSquadra()";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaTrofeiSquadra = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (listaTrofeiSquadra != null) ? listaTrofeiSquadra : "";
    }
    /**
     * Retrieves the list of eligible teams for a specific trophy and year from the database.
     *
     * @param anno    The year of the competition.
     * @param nomeTrof The name of the trophy.
     * @return A string containing the list of eligible teams.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public String prendiSquadreIdoneePerTrofeo(int anno, String nomeTrof) throws SQLException {
        String listaSquadre = "";
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "SELECT prendiSquadreIdoneePerTrofeo(?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, anno);
                preparedStatement.setString(2, nomeTrof);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    listaSquadre = resultSet.getString(1);
                }
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
        return (listaSquadre != null) ? listaSquadre : "";
    }
    /**
     * Inserts the winner of an individual trophy into the database.
     *
     * @param nomeTrofe   The name of the individual trophy.
     * @param anno        The year of the trophy.
     * @param idGiocatore The ID of the winning player.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public void inserisciTrofeoIndividuale(String nomeTrofe, int anno, String idGiocatore) throws SQLException {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "CALL inserisciVincitoreTrofeoIndividuale(?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(2, anno);
                preparedStatement.setString(1, nomeTrofe);
                preparedStatement.setString(3, idGiocatore);

                boolean resultSet = preparedStatement.execute();

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
    }
    /**
     * Inserts the winner of a team trophy into the database.
     *
     * @param nomeTrofeo The name of the team trophy.
     * @param anno       The year of the trophy.
     * @param squadra     The name of the winning team.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public void inserisciTrofeoDiSquadra(String nomeTrofeo, int anno, String squadra) throws SQLException {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "CALL inserisciVincitoreTrofeoDiSquadra(?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(2, anno);
                preparedStatement.setString(1, nomeTrofeo);
                preparedStatement.setString(3, squadra);

                boolean resultSet = preparedStatement.execute();

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
    }
    /**
     * Inserts a football team into a specific competition for a given year in the database.
     *
     * @param nomeSq  The name of the football team.
     * @param nomeCp  The name of the competition.
     * @param anno    The year of the competition.
     * @throws SQLException If a database access error occurs.
     */
    @Override
    public void inserisciSquadraInCompetizione(String nomeSq, String nomeCp, int anno) throws  SQLException {
        try (Connection conn = new ConnessioneDB().connect_to_db(nomeDB, user, pass)) {

            String query = "CALL insert_squadrgiocaincompetizione(?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setString(1, nomeSq);
                preparedStatement.setString(2, nomeCp);
                preparedStatement.setInt(3, anno);

                boolean resultSet = preparedStatement.execute();

                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Errore durante l'esecuzione della query");
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore durante la connessione al database");
            throw e;
        }
    }
}
