package presenter;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**<h1>PropertiesHandler</h1>
* The PropertiesHandler class.
* @author Lior Ran and Omri Haviv
* @version 1.0
* @since May 21,2016
*/
public class PropertiesHandler {

    private static  Properties properties;
    

    public static Properties getInstance() throws FileNotFoundException, Exception {
        if (properties == null) {
            properties =  read(".\\xml\\properties.xml");
        }
        
        return properties;
    }


/**Write function that writes the maze properties to an XML file
 *  @throws Exception*/
    public static void write(Properties p, String filename) throws Exception {
        XMLEncoder encoder
                = new XMLEncoder(
                        new BufferedOutputStream(
                                new FileOutputStream(filename)));

        encoder.writeObject(p);
        encoder.flush();
        encoder.close();
    }
/**read function that reads the maze properties from an XML file
 * 
 * @throws Exception*/
    public static Properties read(String filename) throws Exception {
        XMLDecoder decoder
                = new XMLDecoder(new BufferedInputStream(
                        new FileInputStream(filename)));
        Properties o = (Properties) decoder.readObject();
        decoder.close();
        return o;
    }


}
