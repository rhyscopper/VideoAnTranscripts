 
package videoantrans;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 *
 * @author Rhys
 */

public class ChatParser {
    
    public static Chat parse(String xmlFile){
        
        Chat chat = new Chat();
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(xmlFile));
            Element root = doc.getDocumentElement();
            NodeList nodesParticipants = root.getElementsByTagName("participant");
            for(int i=0; i < nodesParticipants.getLength(); i++){
                Element nodeParticipant = (Element)nodesParticipants.item(i);
                String uid = nodeParticipant.getAttribute("id");
                String name="NoName";
                if(nodeParticipant.hasAttribute("name")){
                    name = nodeParticipant.getAttribute("name");
                }
                Participant p = new Participant(uid, name);
                chat.addParticipant(p);
            }
            
            NodeList nodeParagraphs = root.getElementsByTagName("u");
            NodeList nodeParagraphs2 = root.getElementsByTagName("internal-media");
            for(int i=0; i < nodeParagraphs.getLength(); i++){
                Element nodeParagraph = (Element)nodeParagraphs.item(i); 
                Element nodeParagraph2 = (Element)nodeParagraphs2.item(i);
                String id = nodeParagraph.getAttribute("uID");
                String who = nodeParagraph.getAttribute("who");
                String Time = nodeParagraph2.getAttribute("start");
                Paragraph p = new Paragraph(who, id, Time);
                
                NodeList wNodeList = nodeParagraph.getElementsByTagName("w");
                for(int j=0; j < wNodeList.getLength(); j++){
                    Element wElem = (Element)wNodeList.item(j);
                    String word = wElem.getTextContent();
                    p.addWord(word);
                }
                chat.addParagraph(p);
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }        
        
        return chat;
    }
}