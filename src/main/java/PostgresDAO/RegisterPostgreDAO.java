package PostgresDAO;

import Connessione.ConnessioneDB;
import DAO.RegisterPageDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * The `RegisterPostgreDAO` class implements the `RegisterPageDAO` interface for handling user registration operations in a PostgreSQL database.
 */
public class RegisterPostgreDAO implements RegisterPageDAO {

    /**
     * The database connection.
     */
    Connection conn = new ConnessioneDB().connect_to_db("postgres","postgres","password");

    /**
     * Inserts a new user into the database with the provided login username and password.
     *
     * @param loginUser The login username of the new user.
     * @param passUser  The password of the new user.
     * @throws Exception If an error occurs during the registration process, including integrity constraint violations (e.g., duplicate username).
     */
    public void insUtente(String loginUser, String passUser) throws Exception {
        String query = "CALL register(?, ?)";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)){
            preparedStatement.setString(1, loginUser);
            preparedStatement.setString(2, passUser);

            preparedStatement.execute();
        } catch (SQLIntegrityConstraintViolationException e){
            throw e;
        }
    }
}
