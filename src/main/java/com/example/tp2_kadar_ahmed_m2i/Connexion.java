package com.example.tp2_kadar_ahmed_m2i;

import java.sql.*;

public class Connexion {
    static Connection conn;

    public static Connection getConnexion() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","");
        System.out.println("Connexion réussite .");
        return conn;
    }
}