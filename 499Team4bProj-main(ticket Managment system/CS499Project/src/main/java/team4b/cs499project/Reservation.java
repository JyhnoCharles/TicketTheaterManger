/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package team4b.cs499project;

import java.time.LocalDate; // Used to access ArrayLists
import java.util.ArrayList; // Used to access Dates

/**
 *
 * @author kersh
 */
public class Reservation {
    ArrayList<String> seatData;
    ArrayList<Ticket> tickets;
    ArrayList<LocalDate> date;
    Boolean isSeasonTicket;
    Boolean isPaidFor;
    Float discount;
    
    /**
     * Constructs a new Reservation object with empty/default values.
     */
    public Reservation() {
        this.seatData = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.date = new ArrayList<>();
        this.isSeasonTicket = false;
        this.isPaidFor = false;
        this.discount = 0.0f;
    }
    
    /**
     * Constructs a new Reservation object given values for it's internal variables.
     * @param seatData A string containing the information needed to find the seat(s) associated with the reservation.
     * @param tickets An array containing all the tickets associated with the reservation.
     * @param date An Array of dates associated with the Reservation, should only be longer than 1 for season tickets
     * @param isSeasonTicket A quick access to check if the reservation is a season ticket holder
     * @param isPaidFor A quick check for the reservation to see if it's been paid for.
     */
    public Reservation(String seatData, ArrayList<Ticket> tickets, LocalDate date, Boolean isSeasonTicket, Boolean isPaidFor, Float discount) {
        this.seatData = new ArrayList<>();
        this.seatData.add(seatData);
        this.tickets = tickets;
        this.date = new ArrayList<>();
        this.date.add(date);
        this.isSeasonTicket = isSeasonTicket;
        this.isPaidFor = isPaidFor;
        this.discount = discount;
        
      
    }

    /**
     * Simple function that reports all the tickets for this reservation.
     * @param username The current user we are exporting.
     * @return The new data variable with all the relevant additions.
     */
    public String exportTickets(String username) {
        String data = "";
        for(String seat : seatData) {
            for(LocalDate day : date) {
                data += username + "," + seat + "," + day + "," + String.valueOf(isPaidFor) + "\n";
            }
        }
        return data;
    }

    public float getReservationsPrice(){
        float totalPrice = 0.0f;
        for(Ticket ticket : tickets){
            totalPrice += ticket.getPrice();
        }

        return totalPrice;
    }

    public void addDate(LocalDate date) {
        this.date.add(date);
    }

    public void addSeatData(String seatData) {
        this.seatData.add(seatData);
    }

    /// Boilerplate getters and setters

    public ArrayList<String> getSeatData() {
        return seatData;
    }

    public void setSeatData(ArrayList<String> seatData) {
        this.seatData = seatData;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ArrayList<LocalDate> getDate() {
        return date;
    }

    public void setDate(ArrayList<LocalDate> date) {
        this.date = date;
    }

    public Boolean getIsSeasonTicket() {
        return isSeasonTicket;
    }

    public void setIsSeasonTicket(Boolean isSeasonTicket) {
        this.isSeasonTicket = isSeasonTicket;
    }

    public Boolean getPaidFor() {
        return isPaidFor;
    }

    public void setPaidFor(Boolean paidFor) {
        isPaidFor = paidFor;
    }

    public Boolean getSeasonTicket() {
        return isSeasonTicket;
    }

    public void setSeasonTicket(Boolean seasonTicket) {
        isSeasonTicket = seasonTicket;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }
}
    
