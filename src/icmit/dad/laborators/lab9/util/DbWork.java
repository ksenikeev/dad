package icmit.dad.laborators.lab9.util;

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
        if (connection == null || connection.isClosed()){
            Properties p = getProperties();
            String host = p.getProperty("db_ip");
            String port = p.getProperty("db_port");
            String dbName = p.getProperty("db_name");
            String user = p.getProperty("db_user");
            String password = p.getProperty("db_password");
            String url = "jdbc:postgresql://"+host+":"+port +"/"+dbName;
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }

    private Properties getProperties(){
        Properties prop = new Properties();;
        File f = new File("dad.properties");
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
