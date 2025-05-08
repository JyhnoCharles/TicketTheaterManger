package team4b.cs499project;

import java.util.ArrayList; // Used to access ArrayLists

public class Venue {
    String venueName;
    String uniqueID;
    ArrayList<Section> sections;
    
    /**
     * Constructs a default/empty Venue
     */
    public Venue() {
        this.venueName = "";
        this.uniqueID = "";
        this.sections = new ArrayList<>();
    }

    /**
     * Creates a new Venue object, given an array of sections.
     * @param sections An array list of sections to be contained in the new Venue.
     */
    public Venue(ArrayList<Section> sections, String venueName) {
        this.sections = sections;
        this.venueName = venueName;
    }
    
    public String exportData(String data) {
        String newVenueName = "";
        for(int i = 0; i < venueName.length(); i++) {
            if(venueName.charAt(i) != ' ') {
                newVenueName += venueName.charAt(i);
            } else {
                newVenueName += "_";
            }
        }
        data += newVenueName  + ',' + uniqueID + ',' + sections.size() + '\n';
        
        for (Section section : sections) {
            data = section.exportData(data);
        }
        
        return data;
    }

    public Section findSection(String sectionName) {
        for(Section section : sections) {
            if(section.getSectionName().equals(sectionName)) {
                return section;
            }
        }
        return null;
    }

    /// Boilerplate below this line. We can remove ones we clearly don't need.
    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }
}