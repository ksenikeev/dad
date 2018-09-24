/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icmit.dad.laborators.lab1.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADKazankov
 */
public class DBWork {
    private static DBWork db;
    private static Connection connection;
    private String adressDB;
    private String portDB;
    private String nameDB;
    private String userName;
    private String userPass;
        
    private void readProperties(){
        Properties properties;
        File f = new File("dad.properties"); 
        try(FileInputStream stream = new FileInputStream(f)){
             if(f.exists()){
                 properties = new Properties();
                 properties.load(stream);
                 adressDB = properties.getProperty("adressDB");
                 portDB = properties.getProperty("portDB");
                 nameDB = properties.getProperty("nameDB");
                 userName = properties.getProperty("userName");
                 userPass = properties.getProperty("userPass");
                 
             }
        } catch (IOException  ex) {
            Logger.getLogger(DBWork.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void connect() throws SQLException{
        String url = "jdbc:postgresql://"+adressDB+":"+portDB+"/"+nameDB;
        connection = DriverManager.getConnection(url,userName,userPass);
    }
    public static DBWork getInstance() throws SQLException{
        if(db == null){
            db = new DBWork();
        }
        return db;
    }
    public Connection getConnection() throws SQLException{
        if(connection==null || connection.isClosed()){
            readProperties();
            connect();
        }
        return connection;
    }
}
