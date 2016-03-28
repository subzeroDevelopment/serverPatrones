package com.example;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;



@Path("/addUser")
public class AgregarUser{
      String URL="jdbc:postgresql://ec2-54-243-149-147.compute-1.amazonaws.com:5432/dau1to9lfh16k3?user=zbuqlgfhcjnvyv&password=LyceoJd0YeTQe7ueEHRri8uhr-&sslmode=require";

      @POST
      @Path("/prueba")
      @Consumes(MediaType.APPLICATION_XML)
      @Produces(MediaType.TEXT_PLAIN)
      public Response postPrueba(String incomingXML,@Context HttpHeaders headers){
        String []ar;
        try{
        ReadXML lec=new ReadXML();
          ar=lec.cargarXml(incomingXML);
        }
        catch(Exception e){
          e.printStackTrace();
          return Response.status(400).entity(incomingXML).build();

        }
        try{
          Connection connection = GetConnection.getConnection();

          Statement stmt = connection.createStatement();
          String s="INSERT INTO observadores(nombre,url,mail) VALUES(\'"+ar[0]+"\',\'"+ar[1]+"\',\'"+ar[2]+"\')";
          //System.out.println(s);
          stmt.executeUpdate(s);
          ResultSet rs = stmt.executeQuery("SELECT * FROM observadores");
          while (rs.next()) {
            System.out.println("Read from DB: " + rs.getString("nombre")+" "+rs.getString("url")+" "+rs.getString("mail"));
          }
        }
        catch(Exception e){
          e.printStackTrace();
          return Response.status(400).entity(incomingXML).build();
        }

        //String s = headers.getRequestHeaders().getFirst("Content-Type");

        return Response.status(200).entity("Observador agregado con exito").build();
      }

      @POST
      @Path("/post")
      //@Consumes(MediaType.TEXT_XML)
      public Response postStrMsg( String msg) {
        try{
          Connection connection = GetConnection.getConnection();

          Statement stmt = connection.createStatement();
          stmt.executeUpdate("DROP TABLE IF EXISTS ticks");
          stmt.executeUpdate("CREATE TABLE ticks (tick timestamp)");
          stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
          ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
          while (rs.next()) {
            System.out.println("Read from DB: " + rs.getTimestamp("tick"));
          }
        }
        catch(Exception e){
          e.printStackTrace();
        }
          String output = "POST:Jersey say : " + msg;
          return Response.status(200).entity(output).build();

      }






}
