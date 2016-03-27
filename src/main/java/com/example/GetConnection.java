package com.example;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class GetConnection {
      private static Connection driver=null;

    private GetConnection(){}
    public  static Connection getConnection() throws URISyntaxException, SQLException {
        if(driver==null){
          URI dbUri = new URI(System.getenv("DATABASE_URL"));
          String username = dbUri.getUserInfo().split(":")[0];
          String password = dbUri.getUserInfo().split(":")[1];
          String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + dbUri.getPath();
          driver=DriverManager.getConnection(dbUrl, username, password);
          return DriverManager.getConnection(dbUrl, username, password);
      }
      else{
        return driver;
      }
    }

}
