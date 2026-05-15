package database;

import java.sql.Connection;
import java.sql.SQLException;

public class testDB {
    public static void main(String[] args) {
        try (Connection con = DBManager.getConnection()) {
            System.out.println("✅ MariaDB Verbindung erfolgreich!");
        } catch (SQLException e) {
            System.out.println("❌ Verbindung fehlgeschlagen");
            e.printStackTrace();
        }
    }
}
