package PostgresDAO;

import Connessione.ConnessioneDB;
import DAO.HomeDAO;

import java.sql.*;

public class LoginPostgreDAO implements HomeDAO {
    Connection conn = new ConnessioneDB().connect_to_db("postgres","postgres","password");
    //Connection conn = DB.connect_to_db("postgres","postgres","password");
    @Override
    public int controllaPriority(String loginUser, String passwordUser) {
        int priority = -1;
        String query = "SELECT * FROM verification(?, ?)";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, loginUser);
            preparedStatement.setString(2, passwordUser);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    priority = resultSet.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Non esiste un utente con questo login e password.");
        }
        return priority;
    }
}
