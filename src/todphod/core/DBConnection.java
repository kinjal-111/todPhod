/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todphod.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    Connection conn;
    
    /*
    Returns a valid Connection Object if it can establish connection with the ims.
    Else returns null
    */
    public static Connection connectDB(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todphod", "root", "");
//            JOptionPane.showMessageDialog(null, "Connection Established Successfully!");
            return conn;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Connection Failed! " + e);
            return null;
        }
    }
}
