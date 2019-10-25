package icmit.dad.laborators.lab1;

import java.sql.*;

/**
 * Пример выборки данных из 2-x таблиц: contact и phone,
 * объединенных по правилу совпадения внешнего (phone.contact_id) и первичного (contact.id) ключа
 *
 *  Протестируйте работу с различными вариантами JOIN: LEFT JOIN, RIGHT JOIN, INNER JOIN
 */
public class Select2Example {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dad";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "post")) {
            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("SELECT contact.fullname, phone.phonenumber FROM " +
                    "contact Left JOIN phone ON contact.id = phone.contact_id");
            while (rs.next()){
                System.out.print(rs.getString("fullname")+", ");
                System.out.println(rs.getString("phonenumber"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

