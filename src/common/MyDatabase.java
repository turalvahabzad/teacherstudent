package common;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDatabase {

public static Connection connect() throws ClassNotFoundException, SQLException{

    Class.forName("com.mysql.cj.jdbc.Driver");

    return DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/sys", "root", "tural12345");
}
}
