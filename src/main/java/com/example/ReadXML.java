package com.example;


import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;         // |
import org.jdom.Element;          // |\ Librerías
import org.jdom.JDOMException;    // |/ JDOM
import org.jdom.input.SAXBuilder;
//Ejemplo de xml a parsear
/*<?xml version="1.0" encoding="UTF-8"?>
<observador>
  <nombre>Tove</nombre>
  <url>Jani</url>
  <mail>Reminder</mail>
</observador> */

public class ReadXML{

  public String[] cargarXml(String archivo){
    //Se crea un SAXBuilder para poder parsear el archivo
    //System.out.println(archivo);
    String reg[]={"","",""};
    SAXBuilder builder = new SAXBuilder();
    try{
        //Se crea el documento a traves del archivo
        StringBufferInputStream str=new StringBufferInputStream(archivo);
        Document document = (Document) builder.build(str);

        //Se obtiene la raiz 'tables'
        Element rootNode = document.getRootElement();
        reg[0]=rootNode.getChildText("nombre");
        reg[1]=rootNode.getChildText("url");
        reg[2]=rootNode.getChildText("mail");
    }
    catch ( IOException io ) {
        System.out.println( io.getMessage() );
    }
    catch ( JDOMException jdomex ) {
        jdomex.printStackTrace();
    }
    return reg;
}

}
