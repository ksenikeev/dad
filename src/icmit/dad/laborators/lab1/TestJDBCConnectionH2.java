package icmit.dad.laborators.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *  Тест подключения к базе данных H2
 */
public class TestJDBCConnectionH2 {

    public static void main(String[] args){

        //Class.forName("org.postgresql.Driver").newInstance();

        String url = "jdbc:h2:~/dad";
        try (Connection conn = DriverManager.getConnection(url,"admin","admin")){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
