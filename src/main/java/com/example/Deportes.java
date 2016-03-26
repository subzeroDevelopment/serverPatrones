package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("getDeportes")
public class Deportes{

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces("text/xml")
    public String getIt() {
        return leer();
    }


    String leer(){
      String archivo="deporte.xml";
      String cadena="";
      try{
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while(( b.readLine())!=null) {
            cadena+=b.readLine();
        }
        b.close();

      }
      catch(Exception e){
        e.printStackTrace();
      }


      return cadena;

}


}
