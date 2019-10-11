package icmit.dad.laborators.lab14;

import java.sql.*;
import java.util.Scanner;

/**
 *
 */
public class SqlInjExample {
    public static void main(String[] args) {

        String username="";
        String password="";

        System.out.print("Input username:");
        Scanner scan = new Scanner(System. in);
        username = scan.nextLine();

        System.out.println();
        System.out.print("Input password:");
        scan = new Scanner(System. in);
        password = scan.nextLine();

        String url = "jdbc:postgresql://localhost:5432/sqlinj";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "post")) {

            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery("select * from users where username = '" +
                    username + "' and password = '" + password + "'");

            if (rs.next()) {
                System.out.println("autorisation success!");
            } else {
                System.out.println("autorisation filed!");
            }

            rs.close();
            s.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

