/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanagement.Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sumaiya
 */
public class DBConn {
    public static void main(String[] args) {
        DBConn.getDBConnection();
    }
     
   public static Connection getDBConnection(){
    Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1234");
            System.out.println("::Connected::");
        } catch (SQLException ex) {
            Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;

     
}
}
