package DAO;

import java.sql.Connection;

public interface HomeDAO {
    int controllaPriority(String loginUser, String passwordUser);
}
