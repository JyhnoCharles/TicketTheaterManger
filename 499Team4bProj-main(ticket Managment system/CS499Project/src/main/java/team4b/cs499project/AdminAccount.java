/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package team4b.cs499project;

import java.util.Date;

/**
 *
 * @author kersh
 */
public class AdminAccount extends UserAccount {
    /**
     * Constructs a new AdminAccount object given values for it's internal variables. Just calls UserAccount constructor.
     * @param username A string containing the name a UserAccount has.
     * @param password A string containing the password this UserAccount will use.
     * @param permissionLevel An integer containing the permission level, 0 for user, 1 for admin
     */
    public AdminAccount(String username, String password, String address, int permissionLevel, Boolean seasonTicketHolder) {
        super(username, password, address, permissionLevel, seasonTicketHolder);
    }
    
    private void changeReservationPrice(float price, Reservation reservation) {
        return;
    }
    
    private void checkPermissions() {
        return;
    }
    
    private void setPrice(Ticket ticket, float newPrice) {
        return;
    }
    
    private void setPrice(Row row, float newPrice) {
        return;
    }
    
    private void setPrice(Section section, float newPrice) {
        return;
    }
    
    private Reservation searchReservations(String userName) {
        return null;
    }
    
    private Reservation searchReservations(Date date) {
        return null;
    }
    
    private Reservation searchReservations(Venue venue) {
        return null;
    }
    
    private void saveReservations() {
        return;
    }
    
}
