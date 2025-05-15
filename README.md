# TicketTheaterManger

Overview:
Theater Ticket Manager is a Java-based desktop application created for our CS 499 Senior Project. Designed for two public venues at the Huntsville Civic Center, it lets non-profit groups handle ticket sales and seat assignments without double-booking. The program offers separate dashboards for everyday patrons and administrators, supports one-off reservations and full-season tickets, and can be configured to match each organization’s pricing and seating policies. Built with standard Java and Swing, it runs on both Windows and macOS and includes basic data-export tools so ticket and sales records can be used in other systems.




Requirements:
JDK 24
Maven
Apache NetBeans

Steps:
1. Open Apache NetBeans and open the project as a new project.
2. Right click CS499Project and click "Clean and Build".
3. Right click CS499Project and click open in system.
4. Open target folder.
5. The filed called "CS499Project-1.0-SNAPSHOT.jar" is the executable.
6. If you want the provided Concert Hall and Playhouse venues copy the "venues" folder into the same folder as the executable.
7. For initial login use Admin Admin as username/password. Initial login is indicated by "users.csv" not being present in the folder with the executable.
8. When Manually entering Venue and Section names for manual reservation entry/searching you must use "_" in place of " " to match database naming convention.

Note: You could use any IDE with Maven, but I don't know where your executable will end up so that's on the reader to figure out.
