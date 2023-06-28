/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.crud_java;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Juud
 */
public class CConnection {
    Connection toConnect = null;
    String user ="root";
    String password="coder";
    String bd="bdschool";
    String ip="localhost";
    String puerto= "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd; 
    public Connection stablishConnection(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            toConnect= DriverManager.getConnection(cadena,user,password);
            //JOptionPane.showMessageDialog(null,"The connection has been successfully established");
        } catch (Exception e){
        JOptionPane.showMessageDialog(null,"Error connecting to the database, error:" + e.toString());
    }
        return toConnect;
    }
}
