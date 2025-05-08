package team4b.cs499project;

import java.util.ArrayList; // Used to access ArrayLists

public class UserAccount {
    String username;
    String password;
    String address;
    int permissionLevel;
    ArrayList<Reservation> reservations;
    Boolean seasonTicketHolder;
    
    /**
     * Constructs a default/empty UserAccount
     */
    public UserAccount() {
        this.username = "";
        this.password = "";
        this.address = "";
        this.permissionLevel = 0;
        this.reservations = new ArrayList<>();
    }

    /**
     * Constructs a new UserAccount object given values for it's internal variables.
     * @param username A string containing the name a UserAccount has.
     * @param password A string containing the password this UserAccount will use.
     * @param permissionLevel An integer containing the permission level, 0 for user, 1 for admin
     */
    public UserAccount(String username, String password, String address, int permissionLevel, Boolean seasonTicketHolder) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.permissionLevel = permissionLevel;
        this.seasonTicketHolder = seasonTicketHolder;
        this.reservations = new ArrayList<>();
    }

    /**
     * Checks the password given against the password stored in the object.
     * @param testPassword The password to validate.
     * @return An integer that will return -1 upon error state (there is no password in this object; bad initilization), 1 if they are equal, 0 if they are not.
     */
    public int validatePassword(String testPassword) {
        if(this.password.equals("")) {
            return -1;
        } else if(this.password.equals(testPassword)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Simple function that reports all the tickets for this user.
     * @param data The current data already included in the export.
     * @return The new data variable with all the relevant additions.
     */
    public String exportTickets(String data) {
        for(Reservation reservation : reservations) {
            data += reservation.exportTickets(username);
        }
        return data;
    }

    // Allows a new reservation to be added to the user account
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /// Boilerplate below this line. We can remove ones we clearly don't need.
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(int permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    public ArrayList<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<Reservation> reservations) {
        this.reservations = reservations;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getSeasonTicketHolder() {
        return seasonTicketHolder;
    }

    public void setSeasonTicketHolder(Boolean seasonTicketHolder) {
        this.seasonTicketHolder = seasonTicketHolder;
    }
}