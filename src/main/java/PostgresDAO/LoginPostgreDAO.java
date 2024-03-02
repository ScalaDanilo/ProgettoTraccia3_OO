package PostgresDAO;

import Connessione.ConnessioneDB;
import DAO.HomeDAO;

import java.sql.*;

/**
 * The `LoginPostgreDAO` class implements the `HomeDAO` interface for handling login-related data access operations in a PostgreSQL database.
 */
public class LoginPostgreDAO implements HomeDAO {

    /**
     * The database connection.
     */
    Connection conn = new ConnessioneDB().connect_to_db("postgres","postgres","password");

    /**
     * Checks the priority level of a user based on the provided login and password.
     *
     * @param loginUser    The login username of the user.
     * @param passwordUser The password of the user.
     * @return An integer representing the priority level of the user. Returns -1 if the user is not found or an error occurs.
     */
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
