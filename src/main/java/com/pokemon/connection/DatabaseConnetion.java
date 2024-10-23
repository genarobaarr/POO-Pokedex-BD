package com.pokemon.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnetion {
    private static DatabaseConnetion instance;
    private Connection connection;
    private static final String URL = "jdbc:mysql://localhost:3306/pokemondb";
    private static final String USER = "root";
    private static final String PASSWORD = "my$Q.L1P4sS$w0Rd";

    private DatabaseConnetion()throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  static DatabaseConnetion getInstance() throws SQLException{
        if(instance==null || instance.getConnection().isClosed()){
            instance = new DatabaseConnetion();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }



}