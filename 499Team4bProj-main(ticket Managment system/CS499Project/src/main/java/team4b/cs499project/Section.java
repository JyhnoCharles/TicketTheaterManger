package team4b.cs499project;

// 
// Author: Jyhno P. Charles
// 

import  java.util.ArrayList;


public class Section {
    public ArrayList<Row> rows;
    public float secPrice;
    String sectionName;
    
    /**
     * constructs a new default/empty section object
     */
    public Section() {
        this.rows = new ArrayList<>();
        this.secPrice = 0.0f;
        this.sectionName = "";
    }

    /**
     * Constructs a new Section object.
     * @param rows An ArrayList of Row objects belonging to this section.
     * @param secPrice The base price of tickets in this section.
     */
    public Section(ArrayList<Row> rows, float secPrice, String sectionName) {
        this.rows = rows;
        this.secPrice = secPrice;
        this.sectionName = sectionName;
    }
    
    public String exportData(String data) {       
        String newSectionName = "";
        for(int i = 0; i < sectionName.length(); i++) {
            if(sectionName.charAt(i) != ' ') {
                newSectionName += sectionName.charAt(i);
            } else {
                newSectionName += "_";
            }
        }
        data += newSectionName + ',' + secPrice + ',' + rows.size() + '\n';
        
        for (Row row : rows) {
            data = row.exportData(data);
        }
        
        return data;
    }

    // gets the price of a reservation for this section
    public float getReservationPrice(){
        return secPrice;
    }

    // get rows in section
    public ArrayList<Row> getRows() {
        return rows;
    }
    
    public float getSecPrice(){
        return secPrice;
    }

    // updates the rows
    public void setRows(ArrayList<Row> rows){
        this.rows = rows;
    }

    // updates the price
    public void setSecPrice(float secPrice){
        this.secPrice = secPrice;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
