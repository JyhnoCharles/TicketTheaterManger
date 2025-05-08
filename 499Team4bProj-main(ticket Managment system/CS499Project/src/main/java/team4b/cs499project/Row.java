package team4b.cs499project;

/*
 * 
 * Author: Jyhno Charles
 */

 import  java.util.ArrayList;

public class Row {
    public  ArrayList<Ticket> tickets;
    float rowPrice;
    
    public String exportData(String data) {
        data += "Row" + ',' + rowPrice + ',' + tickets.size() + '\n';
        
        for (Ticket ticket : tickets) {
            data = ticket.exportData(data);
        }
        
        return data;
    }
    
    /**
     * Constructs a new Row to default/empty
     */
    public Row() {
        this.tickets = new ArrayList<>();
        this.rowPrice = 0.0f;
    }
    
    public Row(ArrayList<Ticket> tickets, float rowPrice){
        this.tickets = tickets;
        this.rowPrice = rowPrice;
    }

    public Ticket getTicketWithNum(int num) {
        for(Ticket ticket : tickets) {
            if(ticket.seatNum == num) {
                return ticket;
            }
        }
        return null;
    }
    
    public void setSeats(ArrayList<Ticket> tickets){
        this.tickets = tickets;
    }


    
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public float getRowPrice() {
        return rowPrice;
    }

    public void setRowPrice(float rowPrice) {
        this.rowPrice = rowPrice;
    }
}

