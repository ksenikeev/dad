package icmit.dad.laborators.lab4.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbWork {

    private static DbWork dbWork;
    private Connection connection;

    public static DbWork getInstance(){
        if (dbWork==null){
            dbWork = new DbWork();
        }
        return dbWork;
    }

    public Connection getConnection() throws SQLException {
        Properties p = getProperties();
        String host = p.getProperty("db_ip");
        String port = p.getProperty("db_port");
        String url = "jdbc:postgresql://localhost:5432/dad";
        if (connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(url, "postgres", "post");
        }
        return connection;
    }

    private Properties getProperties(){
        Properties prop = new Properties();;
        File f = new File("umms_sign.properties");
        if (f.exists()) {
            try {
                prop.load(new FileInputStream(f));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Long generateId(String sequenceName){

        Long id = null;
        String sql = "select nextval( ? ) as id";

        try (PreparedStatement st = getConnection().prepareStatement(sql)){

            st.setString(1, sequenceName);

            ResultSet rs = st.executeQuery();

            if (rs.next()){
                id = rs.getLong("id");
            }

            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
