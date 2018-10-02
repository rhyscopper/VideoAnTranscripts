
package videoantrans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rhys
 */
public class Paragraph {
    
    private String who;
    private String id;
    private double time;
    private List<String> words;
    
    public Paragraph(String who, String id, String time){
        this.who = who;
        this.id = id;
        this.time = Double.parseDouble(time);
        words = new ArrayList<String>();
    }
    
    public void addWord(String w){
        words.add(w);
    }

    public String getWho() {
        return who;
    }

    public String getId() {
        return id;
    }

    public double getTime() {
        return time;
    }
    public List<String> getWords() {
        return words;
    }
}
