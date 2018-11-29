package icmit.dad.laborators.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Пример удаления строки данных из phone
 */
public class DeleteExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dad";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "post")) {
            Statement statement = conn.createStatement();

            String sql = "delete from phone where id = 6";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

