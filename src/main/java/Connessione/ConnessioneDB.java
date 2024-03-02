package Connessione;

import DAO.ConnessioneDAO;

import java.sql.*;

/**
 * Provides methods to establish a connection to the PostgreSQL database.
 */
public class ConnessioneDB implements ConnessioneDAO {

    /**
     * Connects to the PostgreSQL database.
     *
     * @param dbname The name of the database to connect to.
     * @param user   The username for the database connection.
     * @param pass   The password for the database connection.
     * @return A Connection object representing the established database connection.
     */
    public Connection connect_to_db(String dbname, String user, String pass) {

        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + dbname, user, pass);

            if (conn != null) {
                System.out.println("Connessione stabilita");
            } else {
                System.out.println("Connessione fallita");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Driver non trovato: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Errore durante la connessione al database: " + e.getMessage());
        }

        return conn;
    }
}