package net.josegarvin.StAX;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLInputFactory;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) {

    try {
      FileReader r = new FileReader("/home/b4tm4n/alumnes.xml");
      XMLStreamReader parser = XMLInputFactory.newInstance()
          .createXMLStreamReader(r);

      while (parser.hasNext() != false) {
        int eventCode = parser.next();
        if (eventCode == XMLStreamReader.START_ELEMENT) {
          if(parser.getLocalName().equalsIgnoreCase("nom")){
            parser.getLocalName();
            
          }         
        }
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
      System.out.println("No s'ha trobat el fitxer!");
    } catch (XMLStreamException e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
      System.out.println("El parser ha fallat!!");
    } catch (FactoryConfigurationError e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
      System.out.println("No s'ha pogut crear la fabrica!");
    }

  }
}
