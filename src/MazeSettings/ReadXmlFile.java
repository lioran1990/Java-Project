package MazeSettings;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXmlFile {
	

	
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

}
