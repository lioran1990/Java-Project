package MazeSettings;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import java.io.File;

public class CreateXmlFile {
	
	public void  Create (String [] param) {

	      try {
	         DocumentBuilderFactory dbFactory =
	         DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = 
	            dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.newDocument();
	         
	         // root element
	         Element rootElement = doc.createElement("Settings");
	         doc.appendChild(rootElement);

	         // NumberOfThreads element
	         Element NumberOfThreads = doc.createElement("NumberOfThreads");
	         NumberOfThreads.appendChild(
	         doc.createTextNode(param[0]));
	         rootElement.appendChild(NumberOfThreads);
	         
	         // CreateAlgo element
	         Element CreateAlgo = doc.createElement("CreateAlgo");
	         CreateAlgo.appendChild(
	         doc.createTextNode(param[1]));
	         rootElement.appendChild(CreateAlgo);
	         
	         //SolveAlgo element
	         Element SolveAlgo = doc.createElement("SolveAlgo");
	         SolveAlgo.appendChild(
	         doc.createTextNode(param[2]));
	         rootElement.appendChild(SolveAlgo);

	         // write the content into xml file
	         TransformerFactory transformerFactory =
	         TransformerFactory.newInstance();
	         Transformer transformer =
	         transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	        
	         StreamResult result =
	         new StreamResult(new File(".\\xml\\testxml.xml"));
	         transformer.transform(source, result);
	       
	         
	         // Output to console for testing
	         /*
	         StreamResult consoleResult =
	         new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
	         */
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	}


