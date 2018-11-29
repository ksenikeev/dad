package icmit.dad.laborators.lab1;

import java.sql.*;

/**
 * Пример добавления строки данных в таблицу phone
 */
public class InsertExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dad";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "post")) {

            Statement statement = conn.createStatement();

            String sql=
                "insert into phone (contact_id, phonetype_id, phonenumber) values (4 , 2, '+790234777')";
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

