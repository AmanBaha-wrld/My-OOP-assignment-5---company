package kz.aitu.oop.practice.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kz.aitu.oop.practice.connection.DBinterface.DBinteface;

public class DBconnection implements DBinteface {

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:postgresql://localhost:5432/monitoring_app"; //it is our connection
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "abc123");
            return con;
        } catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
