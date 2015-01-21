package net.josegarvin.StAX;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLInputFactory;

/**
 * Programa per generar uns resultats a partir d'un fitxer XML.
 * 
 * @author Jose Garvin Victoria.
 */
public class App {

  /**
   * Mètode principal del programa.
   * 
   * @param args
   *          -->.
   */
  public static void main(final String[] args) {

    /**
     * Instancia de la classe.
     */
    App programa = new App();
    
    /**
     * Mapa on s'emmagatzemaran les dades que es vagin
     * recuperant.
     */
    Map<String, ArrayList<String>> dadesOrdenades =
        new HashMap<String, ArrayList<String>>();
    
    /**
     * ArrayList d'alumnes.
     */
    ArrayList<String> alumnes;
    
    /**
     * Variable per controlar el nom que s'esta llegint.
     */
    String nomActual = "";
    
    /**
     * Variable per controlar el modul que s'esta llegint.
     */
    String modulActual = "";

    try {
      FileReader r = new FileReader("/home/b4tm4n/alumnes.xml");
      XMLStreamReader parser = XMLInputFactory.newInstance()
          .createXMLStreamReader(r);

      while (parser.hasNext()) {
        int eventCode = parser.next();
        if (eventCode == XMLStreamReader.START_ELEMENT) {
          // System.out.println(parser.getLocalName());

          if (parser.getLocalName() == "nom") {
            nomActual = parser.getElementText();
            // System.out.println(parser.getElementText());
          }

          if (parser.getLocalName() == "assignatura") {
            modulActual = parser.getElementText();
            // System.out.println(parser.getElementText());

            if (!dadesOrdenades.containsKey(modulActual)) {

              dadesOrdenades.put(modulActual, new ArrayList<String>());
            }
            alumnes = dadesOrdenades.get(modulActual);
            alumnes.add(nomActual);

          }
        }
      }

      programa.mostrarResultats(dadesOrdenades);

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

  /**
   * Mètode que s'encarrega de mostrar els resultats a partir
   * d'un mapa.
   * @param dadesOrdenades --> ArrayList amb les dades recollides del fitxer.
   */
 final void mostrarResultats(final Map<String,
     ArrayList<String>> dadesOrdenades) {

    Iterator it = dadesOrdenades.keySet().iterator();
    while (it.hasNext()) {
      Object key = it.next();
      System.out.println(key);
      System.out.println("--------------------------------");

      for (int i = 0; i < dadesOrdenades.get(key).size(); i++) {
        System.out.println(dadesOrdenades.get(key).get(i));
      }

      System.out.println();
    }

  }

}
