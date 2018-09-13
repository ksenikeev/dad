package icmit.dad.laborators.lab1;

import java.sql.*;

public class InsertExample {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dad";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "post")) {
            Statement statement = conn.createStatement();

            ResultSet rs = statement.executeQuery("select nextval('contact_seq') as id");
            long id=0;
            if (rs.next()){ id = rs.getLong("id");}
            rs.close();

            statement.executeUpdate("insert into contact (id, fullname) values ("+id+",'Мой хороший друг 2')");

            statement.executeUpdate("insert into phone (contact_id, phonetype_id, phonenumber) values " +
                    "("+id+", 1, '+7902340459')");
            statement.close();
            System.out.println(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/dad";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "post")) {
            Statement statement = conn.createStatement();

            System.out.println(statement.execute("insert into contact (fullname) values ('Тест2') RETURNING id"));
            ResultSet rs = statement.getResultSet();
            rs.next();
            int id = rs.getInt("id");
            System.out.println(id + " row inserted");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
*/
