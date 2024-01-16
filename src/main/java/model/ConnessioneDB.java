package model;

import java.sql.*;

public class ConnessioneDB {
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

    public String prendiSquadreDalDB(Connection conn) {
        StringBuilder elencoSquadre = new StringBuilder();

        try {
            if (conn != null) {
                Statement stmt = conn.createStatement();
                String sql = "SELECT nomeSquadra FROM squadre";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String nomeSquadra = rs.getString("nomeSquadra");
                    elencoSquadre.append(nomeSquadra).append(",");
                }

                rs.close();
                stmt.close();

            } else {
                System.out.println("Connessione non stabilita");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return elencoSquadre.length() > 0 ? elencoSquadre.substring(0, elencoSquadre.length() - 1) : "";
    }



}