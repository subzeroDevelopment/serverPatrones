/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author subzero
 */
import java.io.FileWriter;
import java.io.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import org.jdom.*;          // |\ Librerías
import org.jdom.output.*;
import org.jdom.JDOMException;    // |/ JDOM
import org.jdom.input.SAXBuilder; // |
public class CrearXML {
    public static void main(String []ar){


        CrearXML n=new CrearXML();
        Document d=n.getNoticias();

        try{
            // new XMLOutputter().output(doc, System.out);
		XMLOutputter xmlOutput = new XMLOutputter();

		// display nice nice
		xmlOutput.setFormat(Format.getPrettyFormat());
		xmlOutput.output(d, new FileWriter("file.xml"));

		System.out.println("File Saved!");
        }
        catch(Exception e){

        }
    }

    public Element getBody(){

                Element ch=new Element("channel");
        try{



                /*  <title>El Universal: Mundo</title>
                    <link>http://www.eluniversal.com.mx/elmundo/index.html</link>
                    <description>Servicio de Noticias en Espa�ol</description>
                    <language>es-MX</language>*/

                Element t = new Element("title");
                t.setText("RSS subzero");
                Element l=new Element("link");
                l.setText("http://localhost:5000");
                Element d=new Element("description");
                d.setText("RSS de subzero");
                Element la=new Element("language");
                la.setText("es-MX");

                ch.addContent(t);
                ch.addContent(l);
                ch.addContent(d);
                ch.addContent(la);
                /*<item>
                   <title>Ni�os del Estado Isl�mico asesinan a 25 soldados sirios</title>
                   <link>http://www.eluniversal.com.mx/el-mundo/2015/ninios-del-estado-islamico-asesinan-a-25-soldados-sirios-1111830.html</link>
                    <guid>http://www.eluniversal.com.mx/el-mundo/2015/ninios-del-estado-islamico-asesinan-a-25-soldados-sirios-1111830.html</guid>
                    <pubDate>Sat, 04 Jul 2015 12:27:00 CST</pubDate>
                    <description><img src="http://www.eluniversal.com.mx/img/2015/07/Int/estado_silamico_ejecuin_menores_old-web.jpg" title="Ni�os del Estado Isl�mico asesinan a 25 soldados sirios" /> Yihadistas publican video donde aparecen las v�ctimas de rodillas y en fila en el escenario del teatro romano de Palmira</description>
                    <author>EFE</author>
                </item>*/
		//staff.addContent(new Element("firstname").setText("yong"));



                		// new XMLOutputter().output(doc, System.out);
        }
        catch(Exception e){
            e.printStackTrace();
        }


        return ch;
    }

    public Document getDeportes(){
        Element rss= new Element("rss");
	Document doc = new Document(rss);
        doc.setRootElement(rss);

        Namespace ns2 = Namespace.getNamespace("content", "http://purl.org/rss/1.0/modules/content/");
        Attribute a2=new Attribute("version","2.0");
        rss.addNamespaceDeclaration(ns2);
        rss.setAttribute(a2);

        CrearXML n=new CrearXML();
        Element chanel=n.getBody();



        try{
            Connection connection = GetConnection.getConnection();

          Statement stmt = connection.createStatement();
          String s="SELECT * FROM deportes";
          System.out.println(s);
          ResultSet rs=stmt.executeQuery(s);
          while (rs.next()) {
              Element x=n.getItem(rs.getString("titulo"),rs.getString("link"), rs.getString("guid"),rs.getString("pubdate"),rs.getString("descripcion"));
              chanel.addContent(x);
          }
        }
        catch(Exception e){
         e.printStackTrace();
        }

        rss.addContent(chanel);
        return doc;

    }
    public Document getTecnologia(){
        Element rss= new Element("rss");
	Document doc = new Document(rss);
        doc.setRootElement(rss);

        Namespace ns2 = Namespace.getNamespace("content", "http://purl.org/rss/1.0/modules/content/");
        Attribute a2=new Attribute("version","2.0");
        rss.addNamespaceDeclaration(ns2);
        rss.setAttribute(a2);

        CrearXML n=new CrearXML();
        Element chanel=n.getBody();



        try{
            Connection connection = GetConnection.getConnection();

          Statement stmt = connection.createStatement();
          String s="SELECT * FROM tecnologia";
          System.out.println(s);
          ResultSet rs=stmt.executeQuery(s);
          while (rs.next()) {
              Element x=n.getItem(rs.getString("titulo"),rs.getString("link"), rs.getString("guid"),rs.getString("pubdate"),rs.getString("descripcion"));
              chanel.addContent(x);
          }
        }
        catch(Exception e){
         e.printStackTrace();
        }

        rss.addContent(chanel);
        return doc;

    }
    public Document getNoticias(){
        Element rss= new Element("rss");
	Document doc = new Document(rss);
        doc.setRootElement(rss);

        Namespace ns2 = Namespace.getNamespace("content", "http://purl.org/rss/1.0/modules/content/");
        Attribute a2=new Attribute("version","2.0");
        rss.addNamespaceDeclaration(ns2);
        rss.setAttribute(a2);

        CrearXML n=new CrearXML();
        Element chanel=n.getBody();



        try{
            Connection connection = GetConnection.getConnection();

          Statement stmt = connection.createStatement();
          String s="SELECT * FROM noticias";
          System.out.println(s);
          ResultSet rs=stmt.executeQuery(s);
          while (rs.next()) {
              Element x=n.getItem(rs.getString("titulo"),rs.getString("link"), rs.getString("guid"),rs.getString("pubdate"),rs.getString("descripcion"));
              chanel.addContent(x);
          }
        }
        catch(Exception e){
         e.printStackTrace();
        }

        rss.addContent(chanel);
        return doc;

    }

    public Element getItem(String t,String l,String g,String p,String d){
        Element it0=new Element("item");

                Element ti0=new Element("title");
                 ti0.setText(t);
                Element li0=new Element("link");
                li0.setText(l);
                Element gu0=new Element("guid");
                gu0.setText(g);
                Element fe0=new Element("pubDate");
                fe0.setText(p);
                Element de0=new Element("description");
                de0.setText(d);

                it0.addContent(ti0);
                it0.addContent(li0);
                it0.addContent(gu0);
                it0.addContent(fe0);
                it0.addContent(de0);
           return it0;
    }

}
