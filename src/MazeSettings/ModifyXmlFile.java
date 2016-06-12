package MazeSettings;

import java.io.File;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ModifyXmlFile {
	
	
	
	public void ModifyXmlFile(String [] param){

		 try {
		      File inputFile = new File(".\\xml\\testxml.xml"); 	    	
		      DocumentBuilderFactory docFactory =
		      DocumentBuilderFactory.newInstance();
		      DocumentBuilder docBuilder = 
		      docFactory.newDocumentBuilder();
		      Document doc = docBuilder.parse(inputFile);
		      Node settings = doc.getFirstChild();
		      Node settings1 = doc.getElementsByTagName("Settings").item(0);
		    
		      
		      // update supercar attribute
		   //   NamedNodeMap attr = supercar.getAttributes();
		   //   Node nodeAttr = attr.getNamedItem("company");
		   //   nodeAttr.setTextContent("Lamborigini");

		      // loop the Settings child node
		      NodeList list = settings.getChildNodes();
		      for (int temp = 0; temp < list.getLength(); temp++) {
		         Node node = list.item(temp);
		         if (node.getNodeType() == Node.ELEMENT_NODE) {
		            Element eElement = (Element) node;
		            if ("NumberOfThreads".equals(eElement.getNodeName())){
		              
		                  eElement.setTextContent(param[0]);
		                  String s = eElement.getTextContent();
		                  System.out.println(s); 

		            }
		            if ("CreateAlgo".equals(eElement.getNodeName())){
			              
		                  eElement.setTextContent(param[1]);
		                  String s = eElement.getTextContent();
		                  System.out.println(s); 
		          
		            }
		            if ("SolveAlgo".equals(eElement.getNodeName())){
			              
		                  eElement.setTextContent(param[2]);
		                  String s = eElement.getTextContent();
		                  System.out.println(s); 
		           
		            }
		         }
		      }
		      
		      //loop that removes node
		      /*
		      NodeList childNodes = settings.getChildNodes();
		      for(int count = 0; count < childNodes.getLength(); count++){
		         Node node = childNodes.item(count);
		         if("luxurycars".equals(node.getNodeName()))
		        	 settings.removeChild(node);
		         }
		      */
		      
		         // write the content on console
		      
		      	TransformerFactory transformerFactory = 
		         TransformerFactory.newInstance();
		         Transformer transformer = transformerFactory.newTransformer();
		         DOMSource source = new DOMSource(doc);
		       //  System.out.println("-----------Modified File-----------");
		         StreamResult consoleResult = new StreamResult(System.out);
		         transformer.transform(source, consoleResult);
		       
		        
		         // write the content to file
		         StreamResult result =
		    	         new StreamResult(new File(".\\xml\\testxml.xml"));
		    	         transformer.transform(source, result);
		    	        
		      } catch (Exception e) {
		         e.printStackTrace();
		      }
		 }
		 
	 }

		


