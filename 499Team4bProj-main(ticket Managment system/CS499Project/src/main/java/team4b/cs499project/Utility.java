package team4b.cs499project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

/**
 *
 * @author treyh
 */
public class Utility {
    private ArrayList<UserAccount> userAccounts = new ArrayList<>();
    private ArrayList<Venue> venues = new ArrayList<>();
    private ArrayList<Reservation> reservationList = new ArrayList<>();
    private UserAccount currentUser;
    private Venue selectedVenue;

    public Utility(){

    }
    
    public void userLogin (UserAccount user) {
        currentUser = user;
    }
    
    public void userLogout () {
        currentUser = null;
    }
    
    public UserAccount getCurrentUser() {
        return currentUser;
    }
    
    public void selectVenue(Venue selectedVenue) {
        this.selectedVenue = selectedVenue;
    }
    
    public Venue getSelectedVenue() {
        return selectedVenue;
    }
    
    public void deselectVenue() {
        selectedVenue = null;
    }

    /**
     * Very simple helper function that walks through our users and sees if a given username exists.
     * @param username The username to check for
     * @return True if it exists, false if it doesn't.
     */
    public Boolean doesUserExist(String username) {
        for (UserAccount user : userAccounts){
            if(user.getUsername().equalsIgnoreCase(username)){
                System.out.println("Error: username already Exists");
                return true;
            }
        }
        return false;
    }
    
    public UserAccount createUser(String username, String password, String address, int permissionLevel  ,boolean seasonTicketHolder ){

        // Validate input so usernames if empty
        if (username == null || username.trim().isEmpty()){
            System.out.println("Error: username can not be empty");
            return null;
        }

          // Validate input so Passwword if empty
          if (password == null || password.trim().isEmpty()){
            System.out.println("Error: Password can not be empty");
            return null;
        }
        

        // Check if user already Exists
        if(doesUserExist(username)) {
            return null;
        }
        
        //Checks Permision level
        if (permissionLevel != 0 && permissionLevel != 1){
            System.out.println("Error: Invalid Permision Level");
            return null;
        }

        // Create and add the new user
        UserAccount newUser = new UserAccount(username, password, address, permissionLevel, seasonTicketHolder);
        
        System.out.println("User Account created succesfully");
        userAccounts.add(newUser);

        return newUser;
    }
    
    
    
    //allows the user to purchase a spot at the reservation
    public void purchaseReservation(){
        
        
    }
    
    /**
     * @param venue the venue name (no underscores)
     * @param section the section name
     * @param row zero‑based row index
     * @param seatNum the seat number to check
     * @param dates the full list of LocalDate you want to test (1 date for
     * normal, 52 for STH)
     */
private boolean isSeatBlocked(String venue, String section, int uiRowNumber, int seatNum, List<LocalDate> dates) {
    
    for (Reservation r : reservationList) {
        // Check if reservation is for same venue/section/row
        for (String seatData : r.getSeatData()) {
            String[] parts = seatData.split(" ");
            if (parts.length < 4) continue;
            
            if (parts[0].equals(venue) && 
                parts[1].equals(section) && 
                Integer.parseInt(parts[2]) == uiRowNumber) {
                
                // Check if dates overlap
                if (dates.stream().anyMatch(d -> r.getDate().contains(d))) {
                    // Check if seat number is in this reservation
                    for (String num : parts[3].split("-")) {
                        if (Integer.parseInt(num) == seatNum) {
                            return true;
                        }
                    }
                }
            }
        }
    }
    return false;
}

    
    public Reservation makeReservation(UserAccount user,
            String venueName,
            String sectionName,
            int rowNumber,
            ArrayList<Ticket> tickets,
            LocalDate date,
            boolean seasonTicket,
            float discount) {
        
        // 1) Build list of dates: just one day or 52 weeks
        List<LocalDate> dates = new ArrayList<>();
        dates.add(date);
        if (seasonTicket) {
            for (int i = 1; i < 52; i++) {
                dates.add(date.plusWeeks(i));
            }
        }

        // 2) For each requested ticket, either slide (season) or reject (one‑off)
        ArrayList<Ticket> finalTickets = new ArrayList<>();
        for (Ticket t : tickets) {
            int seat = t.getSeatNum();
            if (seasonTicket) {
                // slide forward until free on *all* 52 dates
                while (isSeatBlocked(venueName, sectionName, rowNumber, seat, dates)) {
                    seat++;
                }
            } else {
                // if it's blocked on that one date, cancel entire booking
                if (isSeatBlocked(venueName, sectionName, rowNumber, seat, dates)) {
                    return null;
                }
            }
            finalTickets.add(new Ticket(seat, t.getPrice(), t.getDisabledSeat()));
        }

        // 3) Build the seatData string (e.g. "MyVenue MySection 3 12-13-14")
        String seatNums = finalTickets.stream()
                .map(Ticket::getSeatNum)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining("-"));
        String seatData = venueName + " " + sectionName + " " + rowNumber + " " + seatNums;

        // 4) Create & save the reservation
        Reservation res = new Reservation(seatData, finalTickets, date, seasonTicket, false, discount);
        if (seasonTicket) {
            // constructor only added the start date → add the other 51 weeks
            for (int i = 1; i < 52; i++) {
                res.addDate(date.plusWeeks(i));
            }
        }
        user.addReservation(res);
        reservationList.add(res);
        return res;
    }

   
    /**
     * Returns a copy of every reservation ever made.
     */
    public ArrayList<Reservation> getAllReservations() {
        return reservationList;
    }

    // Season Ticket Renewal notification
    public void notifySeasonTicketHolder() {

        System.out.println("Reminder, It's time to renew your season ticket!");

    }

  

    
    
    //will generate a custom venue
    public void makeVenue(){
        
        
    }


    /**
     * This exports venue data.
     * @param venue the venue object whose data is to be exported.
     */
    public void exportData(Venue venue){
        String filename = "./venues/" + venue.venueName + ".csv";
        String data = "";
        data = venue.exportData(data);
        //Print data for test
        System.out.print(data);
        
       writeDatabase(filename, data);
    }

    /**
     * This imports venues to the built-in venue list.
     */
    public void importVenues() {
        if (!venues.isEmpty()) {
            venues.clear();
        }
        File directory = new File("./venues/");
        File[] filelist = directory.listFiles();
        if(filelist != null) {
            for(File file : filelist) {
                try {
                    Scanner lineReader = new Scanner(file);
                    while (lineReader.hasNextLine()) {
                        String line = lineReader.nextLine();
                        String[] cells = line.split(",");
                        Venue newVenue = new Venue();
                        newVenue.setVenueName(cells[0]);
                        newVenue.setUniqueID(cells[1]);
                        int i = 0;
                        int numSections = Integer.parseInt(cells[2]);
                        ArrayList<Section> sections = new ArrayList<>();
                        while (i < numSections) {
                            String sectionLine = lineReader.nextLine();
                            String[] sectionCells = sectionLine.split(",");
                            Section newSection = new Section();
                            newSection.setSectionName(sectionCells[0]);
                            newSection.setSecPrice(Float.parseFloat(sectionCells[1]));
                            int j = 0;
                            int numRows = Integer.parseInt(sectionCells[2]);
                            ArrayList<Row> rows = new ArrayList<>();
                            while (j < numRows) {
                                String rowLine = lineReader.nextLine();
                                String[] rowCells = rowLine.split(",");
                                Row newRow = new Row();
                                newRow.setRowPrice(Float.parseFloat(rowCells[1]));
                                int k = 0;
                                int numTickets = Integer.parseInt(rowCells[2]);
                                ArrayList<Ticket> tickets = new ArrayList<>();
                                while (k < numTickets) {
                                    String ticketLine = lineReader.nextLine();
                                    String[] ticketCells = ticketLine.split(",");
                                    Ticket newTicket = new Ticket();
                                    newTicket.setSeatNum(Integer.parseInt(ticketCells[0]));
                                    newTicket.setPrice(Float.parseFloat(ticketCells[1]));
                                    newTicket.setDisabledSeat(Boolean.parseBoolean(ticketCells[2]));
                                    tickets.add(newTicket);
                                    k++;
                                }
                                newRow.setSeats(tickets);
                                rows.add(newRow);
                                j++;
                            }
                            newSection.setRows(rows);
                            sections.add(newSection);
                            i++;
                        }
                        newVenue.setSections(sections);
                        venues.add(newVenue);
                    }
                } catch(FileNotFoundException e) {
                    System.out.println("No venues to load.");
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * This exports venues to the canon persistent venues in venues/
     * Uses the really helpful exportData()
     */
    public void exportVenues() {
        for(Venue venue : venues) {
            exportData(venue);
        }
    }

    /**
     * Gets the tickets identified by a seatData string and returns them as an array list.
     * @param seatDataString The string containing the seatData
     * @return THe arraylist of tickets, or null if invalid.
     */
    public ArrayList<Ticket> getTickets(String seatDataString) {
        String[] seatData = seatDataString.split(" ");
        // The below has null checks that are triggered if any reservation data is invalid.
        Venue resVenue = findVenue(seatData[0]);
        if(resVenue == null) {
            return null;
        }
        Section resSection = resVenue.findSection(seatData[1]);
        if(resSection == null) {
            return null;
        }
        Row resRow = null;
        try {
            resRow = resSection.getRows().get(Integer.parseInt(seatData[2]));
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Invalid data in sheet for reservation row.");
            e.printStackTrace();
        }
        if (resRow == null) {
            return null;
        }
        ArrayList<Ticket> resTickets = new ArrayList<>();
        String[] ticketData = seatData[3].split("-");
        for(String ticketNum : ticketData) {
            Ticket resTicket = null;
            try {
                resTicket = resRow.getTicketWithNum(Integer.parseInt(ticketNum));
            } catch(IndexOutOfBoundsException e) {
                System.out.println("Invalid ticket seat number.");
                e.printStackTrace();
            }
            if (resTicket == null) {
                continue;
            }
            resTickets.add(resTicket);
        }
        return resTickets;
    }

    /**
     * Searches for a venue linearly in the venue list
     * @param venueName A string containing the venue name to search for.
     * @return Returns the Venue once found.
     */
    public Venue findVenue(String venueName) {
        for(Venue venue : venues) {
            if(venue.getVenueName().equalsIgnoreCase(venueName)) {
                return venue;
            }
        }
        return null;
    }
    
    public ArrayList<String> getLoadedVenues() {
        ArrayList<String> venueNames = new ArrayList<>();
        
        for(Venue venue : venues) {
            venueNames.add(venue.getVenueName());
            }
        
        return venueNames;
    }

    /**
     * Imports users to the built-in user list
     */
    public boolean importUsers() {
        File CSV = new File("./users.csv");
        try {
            Scanner lineReader = new Scanner(CSV);
            while (lineReader.hasNextLine()) {
                String line = lineReader.nextLine();
                String[] cells = line.split(",");
                UserAccount newUser = new UserAccount(cells[0],cells[1],cells[2],Integer.parseInt(cells[3]),Boolean.parseBoolean(cells[4]));
                int i = 0; // The below code loads a user's reservations.
                int numRes = Integer.parseInt(cells[5]);
                while(i < numRes) {
                    String resLine = lineReader.nextLine();
                    String[] resCells = resLine.split(",");
                    Reservation newRes = new Reservation();
                    newRes.addDate(LocalDate.parse(resCells[0]));
                    newRes.addSeatData(resCells[1]);
                    newRes.setIsSeasonTicket(Boolean.parseBoolean(resCells[2]));
                    newRes.setPaidFor(Boolean.parseBoolean(resCells[3]));
                    newRes.setDiscount(Float.parseFloat(resCells[4]));
                    ArrayList<Ticket> resTickets = getTickets(resCells[1]);
                    newRes.setTickets(resTickets);
                    if(newRes.getTickets() != null) {
                        newUser.addReservation(newRes);
                    } else {
                        i++;
                        continue;
                    }
                    i++;
                }
                if(doesUserExist(newUser.getUsername())) {
                    continue;
                }
                userAccounts.add(newUser);
            }
            // If this outputs the right seat data, then it's working.
            // System.out.println(userAccounts.getFirst().getReservations().get(0).getSeatData().get(0));
        } catch(FileNotFoundException e) {
            System.out.println("No users to load.");
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    /**
     * This exports our users to the canonical persistent user list.
     * Uses very similar code to exportAddressList() Potential refactoring?
     */
    public void exportUsers() {
        String data = "";
        for (UserAccount user : userAccounts) {
            data += user.getUsername();
            data += ",";
            data += user.getPassword();
            data += ",";
            data += user.getAddress();
            data += ",";
            data += String.valueOf(user.getPermissionLevel());
            data += ",";
            data += String.valueOf(user.getSeasonTicketHolder());
            data += ",";
            data += String.valueOf(user.getReservations().size());
            data += '\n';
            for(Reservation res : user.getReservations()) {
                data += String.valueOf(res.getDate().getFirst());
                data += ",";
                data += res.getSeatData().getFirst();
                data += ",";
                data += String.valueOf(res.getIsSeasonTicket());
                data += ",";
                data += String.valueOf(res.getPaidFor());
                data += ",";
                data += String.valueOf(res.getDiscount());
                data += '\n';
            }
        }
        writeDatabase("./users.csv", data);
    }

    /**
     * This function outputs the usernames and addresses of users from the user list
     * @param filename the filename to output to
     * @param onlySeasonTicketHolders whether or not we only output season ticket holders
     */
    public void exportAddressList(String filename, Boolean onlySeasonTicketHolders) {
        String data = "";
        for(UserAccount user : userAccounts) {
            if(onlySeasonTicketHolders) {
                if(user.getSeasonTicketHolder()) {
                    data += user.getUsername();
                    data += ",";
                    data += user.getAddress();
                    data += '\n';
                }
            } else {
                data += user.getUsername();
                data += ",";
                data += user.getAddress();
                data += '\n';
            }

        }
        writeDatabase(filename, data);
    }

    public UserAccount findUser(String username) {
        for(UserAccount user : userAccounts) {
            if(user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     * This function takes in usernames and addresses from a file, and adds the new addresses to users we have in the system.
     * @param filename The file to import from.
     */
    public void importAddressList(String filename) {
        File CSV = new File(filename);
        try {
            Scanner lineReader = new Scanner(CSV);
            while(lineReader.hasNextLine()) {
                String line = lineReader.nextLine();
                String[] cells = line.split(",");
                UserAccount user = findUser(cells[0]);
                if(user != null) {
                    try {
                        user.setAddress(cells[1]);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("No address in sheet, leaving as-is.");
                    }
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("No file to load.");
            e.printStackTrace();
        }
    }

    /**
     * This function exports the tickets from every current user.
     * @param filename The filename to export this data to.
     */
    public void exportTickets(String filename) {
        String data = "";
        for(UserAccount user : userAccounts) {
            data = user.exportTickets(data);
        }
        writeDatabase(filename, data);
    }

    public void importTickets(String filename) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        formatter = formatter.withLocale(Locale.US);
        File CSV = new File(filename);
        try {
            Scanner lineReader = new Scanner(CSV);
            while (lineReader.hasNextLine()) {
                String line = lineReader.nextLine();
                String[] cells = line.split(",");
                UserAccount user = findUser(cells[0]);
                if(user != null) {
                    ArrayList<Ticket> tickets = getTickets(cells[1]);
                    if(tickets != null) {
                        Reservation newRes = new Reservation(cells[1], tickets, LocalDate.parse(cells[2], formatter), false, Boolean.parseBoolean(cells[3]), 0.0f);
                        Boolean testDup = false;
                        for(Reservation res : user.getReservations()) {
                            if(newRes.getSeatData().equals(res.getSeatData()) && newRes.getDate().equals(res.getDate())) {
                                testDup = true;
                            }
                        }
                        if(testDup == false) {
                            user.addReservation(newRes);
                        }
                    }
                }
            }
        } catch(FileNotFoundException e) {
            System.out.println("No file to load.");
            e.printStackTrace();
        }
    }

    //rudimentary permission check function. Simply returns true or false to the isAdmin bool based on the read in.
    //utilizes the getter function from UserAccount

    /**
     * Simple function to check the permissions of a user account.
     * @param userAccount User account object to check the permissions ove.
     * @return
     */
    public Boolean checkPermissions(UserAccount userAccount){
        int permLevel = userAccount.getPermissionLevel();
        if(permLevel == 1){
            // this.isAdmin = true;
            return true;
        }
        else{
            // this.isAdmin = false;
            return false;
        }
        // return isAdmin;
    }
    
    /**
     * Simple function to check if user accounts have been imported.
     * @return
     */
    public Boolean hasUserlist(){
        return !userAccounts.isEmpty();
    }

    //Overloaded Reservation function to allow the username, date, and venue to be changed - Trey
    // Search Reservations by username. Loops through users and returns reservation

    public ArrayList<Reservation> searchReservations(String userName){
        ArrayList<Reservation> result = new ArrayList<>();
        for(UserAccount user : userAccounts){
            if (user.getUsername().equalsIgnoreCase(userName)) {
                result.addAll(user.getReservations());
            }
        }
        return result;
    }

    // Search Reservations by Date. Loops through reservations that matches the specific date
    public ArrayList<Reservation> searchReservations(LocalDate searchDate){
        ArrayList<Reservation> result = new ArrayList<>();
        for(UserAccount user : userAccounts){
            for(Reservation reservation : user.getReservations()){
                if (reservation.getDate().contains(searchDate))
                    result.add(reservation);
            }
        }
        return result;
    }

    // Search Reservations by Venue. Loops through reservations that matches the specific Venue
    public ArrayList<Reservation> searchReservations(Venue venue){
        ArrayList<Reservation> result = new ArrayList<>();
        String prefix = venue.getVenueName() + " ";
        for (UserAccount user : userAccounts) {
            for (Reservation reservation : user.getReservations()) {
                for (String sd : reservation.getSeatData()) {
                    // match only if the seatData string starts with "VenueName "
                    if (sd.startsWith(prefix)) {
                        result.add(reservation);
                        break;  // stop scanning this reservation’s seatData list
                    }
                }
            }
        }
        return result;
    }

    // Uses the list of reservations and deletes the one given by an index. We could make this a unique ID later,
    // but an index works fine.
    public void deleteReservation(UserAccount user, int index) {
        ArrayList<Reservation> reservations = user.getReservations();
        Reservation toRemove = user.getReservations().get(index);
        reservations.remove(index);
        user.setReservations(reservations);
        reservationList.remove(toRemove);
    }

    public void modifyReservation(UserAccount user, int index, LocalDate date, Boolean seasonTicket, Boolean paidFor) {
        ArrayList<Reservation> reservations = user.getReservations();
        reservations.get(index).addDate(date);
        reservations.get(index).setIsSeasonTicket(seasonTicket);
        reservations.get(index).setPaidFor(paidFor);
        user.setReservations(reservations);
    }
    
    
  
    /**
 * Books 52 back‑to‑back weekly reservations, bumping only the
 * individual week if that seat’s already taken.
 * 
 * @param user              The UserAccount to which reservations will be added
 * @param venueName         Name of Venue
 * @param sectionName
 * @param uiRowNumber     Index rows
 * @param tickets           The list of Ticket objects desired in a seat
 * @param startDate         The localDate of the first week's reservation
 * @param discount          the discount
 * 
 * 
 */
// makes reservation for if season Ticket holder is checked.
    // makes reservation for if season Ticket holder is checked.
    // makes reservation for if season Ticket holder is checked.
    public List<Reservation> makeSeasonTicketReservations(
            UserAccount user,
            String venueName,
            String sectionName,
            int uiRowNumber,
            List<Ticket> tickets,
            LocalDate startDate,
            float discount
    ) {
        List<Ticket> originalTickets = new ArrayList<>(tickets);
        List<Reservation> booked = new ArrayList<>();

        List<Row> rows = this.findVenue(venueName)
                .findSection(sectionName)
                .getRows();

        int groupSize = tickets.size();

        for (int weekOffset = 0; weekOffset < 52; weekOffset++) {
            LocalDate weekDate = startDate.plusWeeks(weekOffset);
            ArrayList<Ticket> assigned = new ArrayList<>();

            System.out.printf("\nWeek %d (%s):%n", weekOffset + 1, weekDate);

            boolean blockFound = false;

            int currentRow = uiRowNumber;
            while (!blockFound && currentRow < rows.size()) {
                int rowWidth = rows.get(currentRow).getTickets().size();
                // compute cumulative offset of seat numbers from previous rows
                int seatNumOffset = 0;
                for (int r = 0; r < currentRow; r++) {
                    seatNumOffset += rows.get(r).getTickets().size();
                }

                for (int startSeat = 1; startSeat <= rowWidth - groupSize + 1; startSeat++) {
                    boolean allFree = true;

                    for (int offset = 0; offset < groupSize; offset++) {
                        int seatToCheck = startSeat + offset;
                        if (isSeatReservedForDate(venueName, sectionName, currentRow, seatToCheck, weekDate)) {
                            allFree = false;
                            break;
                        }
                    }

                    if (allFree) {
                        // Assign all seats in this block with continuous numbering across rows
                        for (int i = 0; i < groupSize; i++) {
                            int assignedSeat = seatNumOffset + startSeat + i;
                            Ticket base = originalTickets.get(i % originalTickets.size());
                            Ticket newTicket = new Ticket(assignedSeat, base.getPrice(), base.getDisabledSeat());
                            assigned.add(newTicket);
                        }
                        blockFound = true;

                        String seatData = createSeatDataString(venueName, sectionName, currentRow, assigned);
                        Reservation r = new Reservation(seatData, assigned, weekDate, true, false, discount);
                        user.addReservation(r);
                        user.setSeasonTicketHolder(true);
                        reservationList.add(r);
                        booked.add(r);
                        break;
                    }
                }

                if (!blockFound) {
                    currentRow++;
                }
            }

            if (!blockFound) {
                System.out.println("No block found for week " + weekDate + ". Reservation skipped.");
                continue; // skip this week if no block was found
            }
        }

        return booked;
    }



        // check to see if seat is reserved for that date (localDate) 
    private boolean isSeatReservedForDate(String venue, String section, int row, int seat, LocalDate date) {
        for (Reservation r : reservationList) {
            for (LocalDate d : r.getDate()) {
                if (d.equals(date)) {
                    for (String seatData : r.getSeatData()) {
                        String[] parts = seatData.split(" ");
                        if (parts.length >= 4
                                && parts[0].equals(venue)
                                && parts[1].equals(section)
                                && Integer.parseInt(parts[2]) == row) {

                            for (String s : parts[3].split("-")) {
                                if (Integer.parseInt(s) == seat) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


// Helper method to format seat data
    private String createSeatDataString(String venue, String section, int uiRow, ArrayList<Ticket> tickets) {
        String seats = tickets.stream()
                .map(t -> String.valueOf(t.getSeatNum()))
                .sorted()
                .collect(Collectors.joining("-"));
        return String.format("%s %s %d %s", venue, section, uiRow, seats);
    }
    
    
    public void setUserAccounts(ArrayList<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }
  
    public ArrayList<UserAccount> getUserAccounts() {
        return userAccounts;
    }
    
    //Allows the admin to save previous changes made - Trey
    private void saveReservations() {
        return;
    }

    //Is it worth considering haveing an if(isAdmin) check in each of these functions? - Trey
    
    
    //Admin priviledge to altar Reservation price - Trey
    private void changeReservationPrice(float price, Reservation reservation) {
        return;
    }


    //Overloaded setPrice function to allow price to be changed at the Ticket, Row, or Section level - Trey
    private void setPrice(Ticket ticket, float newPrice) {
        return;
    }

    private void setPrice(Row row, float newPrice) {
        return;
    }

    private void setPrice(Section section, float newPrice) {
        return;
    }
    
    private void writeDatabase(String filename, String data) {
        File file = new File(filename);
        File parent = file.getParentFile();
        
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    
    
    
}
