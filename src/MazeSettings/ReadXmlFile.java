package MazeSettings;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXmlFile {
	
	public static void main(String[] args)
	{
		ReadXmlFile readxml= new ReadXmlFile();
		String [] param= new String [3];
		param= readxml.read();
		for (int i = 0; i < param.length; i++) {
			
			System.err.println(param[i]);
			
		}
		
	
		
	}
	
	
	public String [] read()
	{
		File inputFile = new File(".\\xml\\testxml.xml"); 	
		DocumentBuilderFactory docFactory =
		DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = docBuilder.parse(inputFile);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Node settings = doc.getFirstChild();
	   // Node settings1 = doc.getElementsByTagName("Settings").item(0);
	    String [] param = new String [3];
	    
		  NodeList list = settings.getChildNodes();
	      for (int temp = 0; temp < list.getLength(); temp++) {
	         Node node = list.item(temp);
	         if (node.getNodeType() == Node.ELEMENT_NODE) {
	            Element eElement = (Element) node;
	            if ("NumberOfThreads".equals(eElement.getNodeName())){
	            	
	                  param[0] = eElement.getTextContent();
	            }
	            if ("CreateAlgo".equals(eElement.getNodeName())){
		              
	            	   param[1] = eElement.getTextContent();
	            }
	            if ("SolveAlgo".equals(eElement.getNodeName())){
	            	
	            	   param[2] = eElement.getTextContent();
	           
	            }
	         }
	      }
	      return param;

	}}
