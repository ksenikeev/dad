package icmit.dad.laborators.lab1;

import java.sql.*;

/**
 * Пример выборки данных из таблицы
 *
 *
 */
public class SelectExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dad";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "post")) {

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("select * from phone");
            while (rs.next()){
                System.out.print(rs.getLong("id")+", ");
                System.out.print(rs.getLong("phonetype_id")+",  ");
                System.out.println(rs.getString("phonenumber"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

