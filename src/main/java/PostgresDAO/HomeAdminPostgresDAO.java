package PostgresDAO;

import Connessione.ConnessioneDB;
import DAO.HomeAdminDAO;
import model.SponsorSecondari;

import java.sql.*;
import java.util.Optional;

public class HomeAdminPostgresDAO implements HomeAdminDAO {
    private String nomeDB = "DataBase DiscoveryFootball";
    private String user = "postgres";
    private String pass = "6879";

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
