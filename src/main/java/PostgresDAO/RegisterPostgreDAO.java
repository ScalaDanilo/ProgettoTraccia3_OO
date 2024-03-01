package PostgresDAO;

import Connessione.ConnessioneDB;
import DAO.RegisterPageDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;

/**
 * The type Register postgre dao.
 */
public class RegisterPostgreDAO implements RegisterPageDAO {
    /**
     * The Conn.
     */
    Connection conn = new ConnessioneDB().connect_to_db("postgres","postgres","password");
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
