package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbManager {

    static final String DB_URL = "jdbc:mariadb://localhost:3306/";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "";

    protected Connection connection = null;

    public dbManager(String dbName) {
        try{
            this.connection = DriverManager.getConnection(DB_URL + dbName, DB_USER, DB_PASSWORD);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Connection getConnection() {return connection;}

}
