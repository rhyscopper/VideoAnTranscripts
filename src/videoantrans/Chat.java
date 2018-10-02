
package videoantrans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rhys
 */
public class Chat {
    
    private List<Participant> participants;
    private List<Paragraph> paragraphs;
    
    public Chat(){
        participants = new ArrayList<Participant>();
        paragraphs = new ArrayList<Paragraph>();
    }
    
    public void addParticipant(Participant p){
        participants.add(p);
    }
    
    public void addParagraph(Paragraph p){
        paragraphs.add(p);
    }

    public List<Participant> getParticipants() {
        return participants;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }
    
    
}
