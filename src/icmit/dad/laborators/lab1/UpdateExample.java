package icmit.dad.laborators.lab1;

import java.sql.*;

public class UpdateExample {
    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/dad";
        try(Connection conn = DriverManager.getConnection(url, "postgres", "post")) {

            Statement statement = conn.createStatement();
            statement.executeUpdate("update phone set phonenumber= '+7999975555' where id = 4 ");
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
    // вариант с PreparedStatement
    PreparedStatement statement = conn.prepareStatement("update phone set phonenumber= ? where id = ? ");
    statement.setString(1, "+7999912234");
    statement.setLong(2, 4);

    statement.executeUpdate();
    statement.close();
*/