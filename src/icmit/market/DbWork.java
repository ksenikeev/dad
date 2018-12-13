package icmit.market;

import java.sql.*;

public class DbWork {

    private static volatile Connection connection;

    public static Connection getInstance(){
        Connection con = connection;
        if (con==null){
            synchronized(DbWork.class) {
                con = connection;
                if (con==null){
                    String url = "jdbc:postgresql://localhost:5432/market";
                    try {
                        con = connection = DriverManager.getConnection(url, "postgres", "post");
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return con;
    }

    public static synchronized void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Long generateId(String sequenceName){

        Long id = null;
        String sql = "select nextval( ? ) as id";

        try (PreparedStatement st = connection.prepareStatement(sql)){

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
