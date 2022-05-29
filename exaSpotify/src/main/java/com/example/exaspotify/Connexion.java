package com.example.exaspotify;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;

import static java.lang.Class.forName;

public class Connexion {
    public Connection basedatos;
    public Connection getConnection(){
        String dbname="spotify";
        String dbuser="root";
        String dbpasswd="dbrootpass";
        String url="jdbc:mysql://localhost:33006/" + dbname;
        try {
            basedatos = DriverManager.getConnection(url,dbuser,dbpasswd);
        } catch (Exception e ) {
            e.printStackTrace();
            e.getCause();
        }
        return basedatos;
    }

}
