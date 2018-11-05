package icmit.dad.laborators.lab1;

import java.sql.*;

/**
 * Пример добавления данных в 2 связанные таблицы: contact и phone.
 * Связь между таблицами осуществляется посредством внешнего ключа
 * contact_id таблицы phone.
 *
 *
 */
public class Insert2Example {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dad";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "post")) {
            Statement s = conn.createStatement();

            // Генерируем новое значение первичного ключа для таблицы contact,
            // используя последовательность contact_seq
            ResultSet rs = s.executeQuery("select nextval('contact_seq') as id");
            long id=0;
            if (rs.next()){ id = rs.getLong("id");}
            rs.close();

            PreparedStatement ps1 =
                    conn.prepareStatement("insert into contact (id, fullname) values ( ? , ? ) ");
            ps1.setLong(1, id);
            ps1.setString(2, "Контакт "+id);

            ps1.executeUpdate();
            ps1.close();

            PreparedStatement ps2 =
                conn.prepareStatement(
                    "insert into phone (contact_id, phonetype_id, phonenumber) values ( ? , ? , ? )");
            ps2.setLong(1, id);
            ps2.setLong(2, 1);
            ps2.setString(3, "+7902340459");

            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

