package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class testDB {

    public static void main() {

        String sql = "SELECT * FROM employees";

        try (
                Connection con = DBManager.getConnection();
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt(1) + " | " +
                                rs.getString(2) + " | " +
                                rs.getString(3)
                );
            }

        } catch (Exception e) {
            System.out.println("Fehler beim Lesen");
            e.printStackTrace();
        }
    }
}