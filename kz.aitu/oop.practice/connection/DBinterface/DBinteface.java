package kz.aitu.oop.practice.connection.DBinterface;

import java.sql.Connection;
import java.sql.SQLException;


public interface DBinteface {
    Connection getConnection() throws SQLException, ClassNotFoundException; // interface
}
