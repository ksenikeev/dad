package icmit.dad.laborators.lab1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *  Тест подкл
 */
public class TestJDBCConnection {

    public static void main(String[] args){

        //Class.forName("org.postgresql.Driver").newInstance();

        String url = "jdbc:postgresql://localhost:5432/temp2";
        try (Connection conn = DriverManager.getConnection(url,"postgres","post")){

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
