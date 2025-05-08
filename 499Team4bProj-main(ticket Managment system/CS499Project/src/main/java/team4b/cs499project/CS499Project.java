/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package team4b.cs499project;

import java.time.LocalDate; // Used to access ArrayLists
import java.util.ArrayList; // Used to access Dates

/**
 *
 * @author Team 4b
 */
public class CS499Project {

    static Utility utilityObject = new Utility();

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLoginScreen(utilityObject).setVisible(true);
            }
        });
        
        //test();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                utilityObject.exportVenues();
                utilityObject.exportUsers();
            }
        }, "Shutdown-thread"));
    }

    /**
     * This function tests the existing objects and functionality. For future additions, please
     * use the format as used below, separate your testing into blocks and label them with comments
     * describing what they're testing, referencing codes from the tickets where appropriate.
     */
    public static void test() {
        String username = "Test";
        String password = "Test";
        int seatNum = 1;
        float price = 4.25F;
        int permissions = 0;
        String address = "123 Example Street";
        LocalDate date = LocalDate.of(2025, 2, 24);

        
        /* Testing Account Creation */

        // ArrayList<UserAccount> userList = new ArrayList<>();
        // Utility utility = new Utility(userList);
    
        // System.out.println("----- Testing User Creation -----");
    
        // // Test Case 1: Successfully create a user
        // System.out.println("\nTest Case 1: Creating a valid user...");
        // UserAccount user1 = utility.createUser("JCharles", "password123", "123 Main St", 1,false);
        // assert user1 != null : "Test Case 1 Failed: User should be created.";
        // System.out.println(" Test Case 1 Passed!");
    
        // // Test Case 2: Prevent duplicate username
        // System.out.println("\nTest Case 2: Attempting to create duplicate user...");
        // UserAccount user2 = utility.createUser("JohnDoe", "password456", " 142 university dr", 0, true);
        // assert user2 == null : "Test Case 2 Failed: Duplicate username should not be allowed.";
        // System.out.println(" Test Case 2 Passed!");

        
        // // Test Case 3: handle empty passwords
        // System.out.println("\nTest Case 3: Attempting to create a user with an empty password");
        // UserAccount user3 = utility.createUser("philMop", "", "456 Elm St", 0,true);
        // assert user3 == null : "Test Case 3 Failed: Empty password should not be allowed";
        // System.out.println(" Test Case 3 Passed!");
    
        // // Test Case 4: Handle empty username
        // System.out.println("\nTest Case 4: Attempting to create a user with an empty username");
        // UserAccount user4 = utility.createUser("", "password789", "789 Oak St", 1,false);
        // assert user4 == null : "Test Case 4 Failed: Empty username should not be allowed.";
        // System.out.println(" Test Case 4 Passed!");
    
        // // Test Case 5: Creating another valid user
        // System.out.println("\nTest Case 5: Creating another unique user");
        // UserAccount user5 = utility.createUser("AliceSmith", "mypassword", "987 Pine St", 1,true);
        // assert user5 != null : "Test Case 5 Failed: User should be created.";
        // System.out.println(" Test Case 5 Passed!");

        
        // // Test Case 6: Creating another valid user
        // System.out.println("\nTest Case 6: Creating another unique user");
        // UserAccount user6 = utility.createUser("Micoksmal", "mypassword", "322 lewis ave", 1,true);
        // assert user6 != null : "Test Case 6 Failed: User should be created.";
        // System.out.println(" Test Case 6 Passed!");

        // // Test Case 6: Creating another valid user
        // System.out.println("\nTest Case 7: Creating another unique user");
        // UserAccount user7 = utility.createUser("Denis", "baldwin", "322 lewis ave", 20,true);
        // assert user7 != null : "Test Case 6 Failed: Account should not work because it is neither 1 or 0.";
        // System.out.println(" Test Case 7 Passed!");
    
        // // Print the final list of users
        // System.out.println("\nFinal Users in the System:");
        // for (UserAccount user : userList) {
        //     System.out.println(" - " + user.getUsername());
        // }
    
        // System.out.println("\nAll user Creation test cases completed !");

        /* Test UserAccount basic features */
        UserAccount testUser = new UserAccount(username, password, address, permissions, false);
        if(testUser.getUsername().equals(username)) {
            System.out.println("testUser took username.");
        } else {
            System.out.println("testUser failed to take username");
        }
        /* 100% this is a bad idea, but for testing: */
        if(testUser.getPassword().equals(password)) {
            System.out.println("testUser took password.");
        } else {
            System.out.println("testUser failed to take password");
        }
        if(testUser.getAddress().equals(address)) {
            System.out.println("testUser took address.");
        } else {
            System.out.println("testUser failed to take address.");
        }
        if(testUser.getPermissionLevel() == permissions) {
            System.out.println("testUser took permissionLevel");
        } else {
            System.out.println("testUser failed to take permission level");
        }
        if(testUser.validatePassword(password) > 0) {
            System.out.println("testUser can validate passwords.");
        } else {
            System.out.println("testUser failed to validate password");
        }
        if(testUser.getSeasonTicketHolder() == false) {
            System.out.println("testUser took season ticket holder status.");
        } else {
            System.out.println("testUser failed to take season ticket holder status");
        }

        /* Test AdminAccount */
        username = "Admin";
        permissions = 1;
        AdminAccount testAdmin = new AdminAccount(username, password, address, permissions, false);
        if(testAdmin.getUsername().equals(username)) {
            System.out.println("testAdmin took username.");
        } else {
            System.out.println("testAdmin failed to take username");
        }
        /* 100% this is a bad idea, but for testing: */
        if(testAdmin.getPassword().equals(password)) {
            System.out.println("testAdmin took password.");
        } else {
            System.out.println("testAdmin failed to take password");
        }
        if(testAdmin.getAddress().equals(address)) {
            System.out.println("testAdmin took address.");
        } else {
            System.out.println("testAdmin failed to take address.");
        }
        if(testAdmin.getPermissionLevel() == permissions) {
            System.out.println("testAdmin took permissionLevel");
        } else {
            System.out.println("testAdmin failed to take permission level");
        }
        if(testAdmin.validatePassword(password) > 0) {
            System.out.println("testAdmin can validate passwords.");
        } else {
            System.out.println("testAdmin failed to validate password");
        }

        /* Test Ticket */
        Ticket testTicket = new Ticket();
        testTicket.setSeatNum(seatNum);
        testTicket.setPrice(price);
        if(testTicket.getSeatNum() == seatNum) {
            System.out.println("testTicket took seat number.");
        } else {
            System.out.println("testTicket failed to take seat number");
        }
        if(testTicket.getPrice() == price) {
            System.out.println("testTicket took price.");
        } else {
            System.out.println("testTicket failed to take price");
        }

        /* Test Reservation */
        ArrayList<String> seatData = new ArrayList<>();
        seatData.add("Venue Section Row Number");
//        seatData.add("Section");
//        seatData.add("Row");
//        seatData.add("Number");
        ArrayList<Ticket> tickets = new ArrayList<>();
        tickets.add(testTicket);
        LocalDate dates = LocalDate.now();
        Reservation testReservation = new Reservation(seatData.getFirst(), tickets, dates, false, false, 0.2f);
        if(testReservation.getSeatData() == seatData) {
            System.out.println("Reservation took seatData.");
        } else {
            System.out.println("Reservation failed to take seatData");
        }
        if(testReservation.getTickets() == tickets) {
            System.out.println("Reservation took tickets.");
        } else {
            System.out.println("Reservation failed to take tickets");
        }
        if(testReservation.getDate().equals(dates)) {
            System.out.println("Reservation took dates.");
        } else {
            System.out.println("Reservation failed to take dates");
        }
        if(testReservation.getIsSeasonTicket() == false) {
            System.out.println("Reservation took season ticket status.");
        } else {
            System.out.println("Reservation failed to take season ticket status");
        }
        if(testReservation.getPaidFor() == false) {
            System.out.println("Reservation took paid  status.");
        } else {
            System.out.println("Reservation failed to take paid status");
        }
        if(testReservation.getDiscount() == 0.2) {
            System.out.println("Reservation took discount.");
        } else {
            System.out.println("Reservation failed to take discount.");
        }
        /* Also test a useraccount's ability to hold this reservation. */
        ArrayList<Reservation> reservations = new ArrayList<>();
        reservations.add(testReservation);
        testUser.setReservations(reservations);
        if(testUser.getReservations() == reservations) {
            System.out.println("testUser successfully took our reservation.");
        } else {
            System.out.println("testUser failed to take a reservation.");
        }

        /* Test Row */
        ArrayList<Ticket> tickets_array = new ArrayList<>();
        tickets_array.add(testTicket);
        Row testRow = new Row(tickets_array, 0.0f);
        testRow.setRowPrice(price);
        if(testRow.getTickets() == tickets_array) {
            System.out.println("Row took tickets.");
        } else {
            System.out.println("Row failed to take tickets");
        }
        if(testRow.getRowPrice() == price) {
            System.out.println("Row took price.");
        } else {
            System.out.println("Row failed to take price");
        }

        /* Test Section */
        String name = "Balcony";
        ArrayList<Row> rows = new ArrayList<>();
        rows.add(testRow);
        Section testSec = new Section(rows, price, name);
        if(testSec.getRows() == rows) {
            System.out.println("Section took rows.");
        } else {
            System.out.println("Section failed to take rows");
        }
        /* No getter for this. */
        if(testSec.secPrice == price) {
            System.out.println("Section took price.");
        } else {
            System.out.println("Section failed to take price");
        }
        if(testSec.getSectionName() == name) {
            System.out.println("Section took name.");
        } else {
            System.out.println("Section failed to take name.");
        }

        /* Test Venue */
        name = "Concert_Hall";
        String ID = "CH01";
        ArrayList<Section> sections = new ArrayList<>();
        sections.add(testSec);
        Venue testVenue = new Venue(sections, name);
        testVenue.setVenueName(name);
        testVenue.setUniqueID(ID);
        if(testVenue.getVenueName() == name) {
            System.out.println("Venue took name.");
        } else {
            System.out.println("Venue failed to take name");
        }
        if(testVenue.getUniqueID() == ID) {
            System.out.println("Venue took ID");
        } else {
            System.out.println("Venue failed to take ID");
        }
        /* No getter for this. */
        if(testVenue.sections == sections) {
            System.out.println("Venue took sections.");
        } else {
            System.out.println("Venue failed to take sections");
        }

        ArrayList<UserAccount> userList = new ArrayList<>();
        userList.add(testUser);
        /* Test Utility */
        utilityObject = new Utility();
        utilityObject.setUserAccounts(userList);
        /* Only substantial function to test right now */
        if (utilityObject.checkPermissions(testAdmin) == true) {
            System.out.println("Permissions check is working.");
        } else {
            System.out.println("Permissions check is not working.");
        }

        /* Test venue import/export */
        utilityObject.exportData(testVenue);
        utilityObject.importVenues();

        /* Test out the new user importing. */
        utilityObject.importUsers();

        /* Test out the user exporting. */
        utilityObject.exportAddressList("testExport.csv", false);
        utilityObject.exportAddressList("testSeasonTicketHolders.csv", true);

        /* Test out the ticket exporting. */
        utilityObject.exportTickets("ticketExport.csv");

        /* Test address list importing, and then re-export for test */
        utilityObject.importAddressList("testImport.csv");
        utilityObject.exportAddressList("testExport2.csv", false);

        /* Test ticket importing, and then re-export for test */
        utilityObject.importTickets("ticketImport.csv");
        utilityObject.exportTickets("ticketExport2.csv");
    }
}
