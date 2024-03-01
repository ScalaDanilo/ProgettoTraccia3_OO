package DAO;

import java.sql.Connection;

public interface ConnessioneDAO {
    Connection connect_to_db(String dbname, String user, String pass);
}
