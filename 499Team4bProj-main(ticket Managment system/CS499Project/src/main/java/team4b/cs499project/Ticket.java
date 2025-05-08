package team4b.cs499project;

public class Ticket {
    int seatNum;
    float price;
    boolean disabledSeat;
    
    /**
     * Creates a default/empty ticket
     */
    public Ticket() {
        this.seatNum = 0;
        this.price = 0.0f;
        this.disabledSeat = false;
    }
    
    public Ticket(int seatNum, float seatPrice, boolean handicapSeat) {
        this.seatNum = seatNum;
        this.price = seatPrice;
        this.disabledSeat = handicapSeat;
    }
    
    public String exportData(String data) {
        data += String.valueOf(seatNum) + ',' + String.valueOf(price) + ',' + String.valueOf(disabledSeat) + '\n';
        return data;
    }

    ///  Boilerplate below this line. We can remove ones we clearly don't need.
    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public boolean getDisabledSeat() {
        return disabledSeat;
    }
    
    public void setDisabledSeat(boolean disabledSeat) {
        this.disabledSeat = disabledSeat;
    }
}