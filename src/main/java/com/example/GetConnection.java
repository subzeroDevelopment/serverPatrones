package com.example;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class GetConnection {
      private static Connection driver=null;

    private GetConnection(){}

    public  static Connection getConnection() throws URISyntaxException, SQLException {
        if(driver==null){
          String username = "postgres";
          String password = "toor";
          System.out.println("user:"+username);
          System.out.println("pass:"+password);

          String dbUrl = "jdbc:postgresql://127.0.0.1:5432/patrones";
          driver=DriverManager.getConnection(dbUrl, username, password);
          return driver;
      }
      else{
        return driver;
      }
    }

}
