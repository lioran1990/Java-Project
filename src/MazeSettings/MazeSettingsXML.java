package MazeSettings;


import java.io.File;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
 
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
 
/**
 * @author Crunchify.com with DOM
 */
 
public class MazeSettingsXML {
 
    public static void main(String[] args) {
        DocumentBuilderFactory icFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder icBuilder;
        try {
            icBuilder = icFactory.newDocumentBuilder();
            Document doc = icBuilder.newDocument();
            Element mainRootElement = doc.createElement("root");
            doc.appendChild(mainRootElement);
 
            // append child elements to root element
            mainRootElement.appendChild(getCompany(doc, "1", "4", "DFS", "BFS"));
            
 
            // output DOM XML to console 
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); 
            DOMSource source = new DOMSource(doc);
            StreamResult console = new StreamResult(System.out);
            transformer.transform(source, console);
 
            System.out.println("\nXML DOM Created Successfully..");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    private static Node getCompany(Document doc, String id, String NumberOFThreads, String CreateAlgo, String SolveAlgo) {
        Element company = doc.createElement("Settings");
        //company.setAttribute("DefaultSettings", id);
        company.appendChild(getCompanyElements(doc, company, "NumberOfThreads", NumberOFThreads));
        company.appendChild(getCompanyElements(doc, company, "CreateAlgo", CreateAlgo));
        company.appendChild(getCompanyElements(doc, company, "SolveAlgo", SolveAlgo));
        return company;
    }
 
    // utility method to create text node
    private static Node getCompanyElements(Document doc, Element element, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
      // System.out.println(node.getAttributeNode("NumberOfThreads")); 
        return node;
    }
}