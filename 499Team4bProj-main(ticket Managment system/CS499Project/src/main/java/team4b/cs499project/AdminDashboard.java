package team4b.cs499project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.SoftBevelBorder;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.swing.SortOrder;
import javax.swing.RowSorter.SortKey;
import javax.swing.RowSorter;




public class AdminDashboard extends javax.swing.JFrame {
    Utility utility;
//     private final DefaultTableModel reservationModel;

    public AdminDashboard(Utility utility) {
        this.utility = utility;
        
        initComponents();
        
        
//        // 1) Set up your reservation table model
//        reservationModel = new DefaultTableModel(
//                new String[]{"Reservation Date", "Seat Info", "Paid For", "Discount"},
//                0
//        );
//        reservationTable.setModel(reservationModel);
//
//        // 2) Attach a TableRowSorter to keep it sorted by date (column 0)
//        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(reservationModel);
//        reservationTable.setRowSorter(sorter);
//
//        // 3) Tell the sorter how to compare those date strings ("yyyy‑MM‑dd")
//        sorter.setComparator(0, (String d1, String d2)
//                -> LocalDate.parse(d1, DateTimeFormatter.ISO_LOCAL_DATE)
//                        .compareTo(LocalDate.parse(d2, DateTimeFormatter.ISO_LOCAL_DATE))
//        );
//
//        // 4) Make it sort ascending on column 0 by default
//        sorter.setSortKeys(
//                Collections.singletonList(
//                        new RowSorter.SortKey(0, SortOrder.ASCENDING)
//                )
//        );
           populateUserTable();
//        initUserTableFlow();                // load‑edit‑save logic
            reloadReservations();
        
      

        
        reservationTable.setModel(new DefaultTableModel(
            new String[]{"Reservation Date", "Seat Info", "Paid For", "Discount"},
            0 // start with zero rows
    ));

        


        
        //Screen Resolution mechanics, NO TOUCHY! - Trey
        //this.setLocationRelativeTo(null); //ensure center screen pop up
        this.setResizable(false); //stops user from resizing window
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); //always ensure pixel width is maxed
        //this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize()); //ensure pixel width matches that of native screen
        this.setSize(1920, 1080);
        firstTimeStartup(); //The first time this code runs, every tab will default to closed

        addressList.addActionListener(e -> exportAddList());
        sthaddressList.addActionListener(e -> exportSthList());
        ticketAssignments.addActionListener(e -> exportTicketList());
        IMPaddressList.addActionListener(e -> importAddList());
        IMPticketAssignment.addActionListener(e -> importTicketList());

    }

    //Functions for adjusting what "tab" the screen is on
    //NOTE : for using the display function, the boolean at the end 
    //applies to the first parameter, and the opposite will apply to 
    //every other parameter. - Trey
    private void firstTimeStartup(){
        PanelDisplay(VenueTab, true);
        PanelDisplay(UMTab, false);
        PanelDisplay(ReserveTab, false);
        PanelDisplay(helpPanel, false);

        venueLoadingLabel.setVisible(false);
    }
    private void PanelDisplay(JComponent Panel, JComponent closePanel, JComponent closePanelt, boolean display) {
        Panel.setVisible(display);
        closePanel.setVisible(!display);
        closePanelt.setVisible(!display);
    }
    private void PanelDisplay(JComponent Panel, boolean display) {
        Panel.setVisible(display);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        exportMenu = new javax.swing.JPopupMenu();
        addressList = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        sthaddressList = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        ticketAssignments = new javax.swing.JMenuItem();
        importMenu = new javax.swing.JPopupMenu();
        IMPaddressList = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        IMPticketAssignment = new javax.swing.JMenuItem();
        OuterDashPanel = new javax.swing.JPanel();
        helpPanel = new javax.swing.JPanel();
        closeHelp = new javax.swing.JButton();
        HelpDocDisplay = new javax.swing.JScrollPane();
        HelpDisplay = new javax.swing.JTextArea();
        innerPanel = new javax.swing.JPanel();
        venueButton = new javax.swing.JButton();
        umButton = new javax.swing.JButton();
        reserveButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        VenueTab = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        btnAddSection = new javax.swing.JButton();
        venueNameField = new java.awt.TextField();
        venueSaveBtn = new javax.swing.JButton();
        venueLoadBtn = new javax.swing.JButton();
        deleteSectionBtn = new javax.swing.JButton();
        venueLoadingLabel = new javax.swing.JLabel();
        UMTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Usertable = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ReserveTab = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        FilterSearch = new javax.swing.JComboBox<>();
        reservationSearch = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reservationTable = new javax.swing.JTable();
        createReservation = new javax.swing.JButton();
        deleteReservationbtn = new javax.swing.JButton();

        addressList.setText("Address List");
        exportMenu.add(addressList);
        exportMenu.add(jSeparator6);

        sthaddressList.setText("Season Ticket List");
        exportMenu.add(sthaddressList);
        exportMenu.add(jSeparator7);

        ticketAssignments.setText("Ticket Assignments");
        exportMenu.add(ticketAssignments);

        IMPaddressList.setText("Address List");
        IMPaddressList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IMPaddressListMouseClicked(evt);
            }
        });
        importMenu.add(IMPaddressList);
        importMenu.add(jSeparator8);

        IMPticketAssignment.setText("Ticket Assignments");
        IMPticketAssignment.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IMPticketAssignmentMouseClicked(evt);
            }
        });
        importMenu.add(IMPticketAssignment);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        OuterDashPanel.setBackground(new java.awt.Color(255, 255, 255));
        OuterDashPanel.setLayout(new java.awt.GridBagLayout());

        helpPanel.setBackground(new java.awt.Color(204, 255, 255));
        helpPanel.setLayout(new java.awt.GridBagLayout());

        closeHelp.setText("Close");
        closeHelp.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        closeHelp.setContentAreaFilled(false);
        closeHelp.setFocusPainted(false);
        closeHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeHelpMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(760, 10, 0, 0);
        helpPanel.add(closeHelp, gridBagConstraints);

        HelpDocDisplay.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        HelpDocDisplay.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        HelpDisplay.setEditable(false);
        HelpDisplay.setColumns(20);
        HelpDisplay.setRows(5);
        HelpDisplay.setText("1. Venue Screen\n\n- Select venue in the dropdown menu at the top and click \"Load Venue\".\n- Or type a name for a new venue in the text box at the top left.\n- Type in a base price for the venue.\n- Click \"Add Section\" for as many sections as the venue has.\n- Type a name for each section in the text box at the top left of the section.\n- Type in a base price for each section.\n- Click \"Add Row\" for as many rows as a section has.\n- Type in a price for each row.\n- To label a seat disabled, click on it.\n- Click \"Save Venue\" to save the venue under that name and select it for use by the program.\n\n2. User Management Screen\n\nHere, a list of users will populate, with an option to search through them.\n\n- Optionally search for a user using the search box.\n- Select a user from the populated list.\n- Select the value to change and type in a new value.\n- Click \"Save File\".\n- If you make a mistake and want to revert, click \"Load File\".\n\n3. Reservation Management Screen\n\nHere, a list of reservations will populate, with an option to search through them.\n\nTo delete or modify a reservation:\n\n- Optionally search by user.\n- Select a reservation from the populated list.\n- Select the value to change and type in a new value.\n    - Or select \"Delete Reservation\" to remove the reservation.\n- Click \"Save Changes\" (or something like that).\n- If you make a mistake and want to revert, click \"Load Original\".\n\nTo make a new reservation:\n\n- Select the \"New Reservation\" button.\n- A pop-up with text boxes for the various parameters will show.\n- Select a date and seat, and you will be prompted to enter a username for the reservation.\n- You are responsible for taking user payment at the counter.\n\n4. Importing and Exporting\n\n- To import and export files containing user and ticket data, \nuse the corresponding buttons in the Import and Export drop down menus in the top right.");
        HelpDisplay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        HelpDocDisplay.setViewportView(HelpDisplay);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 538;
        gridBagConstraints.ipady = 824;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        helpPanel.add(HelpDocDisplay, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        OuterDashPanel.add(helpPanel, gridBagConstraints);

        innerPanel.setBackground(new java.awt.Color(32, 54, 64));
        innerPanel.setMaximumSize(new java.awt.Dimension(1920, 100));
        innerPanel.setMinimumSize(new java.awt.Dimension(1920, 100));
        innerPanel.setPreferredSize(new java.awt.Dimension(1920, 100));

        venueButton.setBackground(new java.awt.Color(242, 242, 242));
        venueButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        venueButton.setForeground(new java.awt.Color(255, 255, 255));
        venueButton.setText("Venue");
        venueButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        venueButton.setContentAreaFilled(false);
        venueButton.setFocusPainted(false);
        venueButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                venueButtonMouseClicked(evt);
            }
        });
        venueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venueButtonActionPerformed(evt);
            }
        });

        umButton.setBackground(new java.awt.Color(242, 242, 242));
        umButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        umButton.setForeground(new java.awt.Color(255, 255, 255));
        umButton.setText("User Management");
        umButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        umButton.setContentAreaFilled(false);
        umButton.setFocusPainted(false);
        umButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                umButtonMouseClicked(evt);
            }
        });
        umButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                umButtonActionPerformed(evt);
            }
        });

        reserveButton.setBackground(new java.awt.Color(242, 242, 242));
        reserveButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        reserveButton.setForeground(new java.awt.Color(255, 255, 255));
        reserveButton.setText("Reservation");
        reserveButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reserveButton.setContentAreaFilled(false);
        reserveButton.setFocusPainted(false);
        reserveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reserveButtonMouseClicked(evt);
            }
        });
        reserveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reserveButtonActionPerformed(evt);
            }
        });

        exportButton.setBackground(new java.awt.Color(242, 242, 242));
        exportButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        exportButton.setForeground(new java.awt.Color(255, 255, 255));
        exportButton.setText("Export");
        exportButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        exportButton.setContentAreaFilled(false);
        exportButton.setFocusPainted(false);
        exportButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exportButtonMouseClicked(evt);
            }
        });

        importButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        importButton.setForeground(new java.awt.Color(255, 255, 255));
        importButton.setText("Import");
        importButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        importButton.setContentAreaFilled(false);
        importButton.setFocusPainted(false);
        importButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                importButtonMouseClicked(evt);
            }
        });

        logoutButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        logoutButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutButton.setText("Log Out");
        logoutButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        logoutButton.setContentAreaFilled(false);
        logoutButton.setFocusPainted(false);
        logoutButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutButtonMouseClicked(evt);
            }
        });
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        helpButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        helpButton.setForeground(new java.awt.Color(255, 255, 255));
        helpButton.setText("Help");
        helpButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        helpButton.setContentAreaFilled(false);
        helpButton.setFocusPainted(false);
        helpButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpButtonMouseClicked(evt);
            }
        });

        closeButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        closeButton.setForeground(new java.awt.Color(255, 255, 255));
        closeButton.setText("Close");
        closeButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        closeButton.setContentAreaFilled(false);
        closeButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout innerPanelLayout = new javax.swing.GroupLayout(innerPanel);
        innerPanel.setLayout(innerPanelLayout);
        innerPanelLayout.setHorizontalGroup(
            innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(innerPanelLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(closeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(venueButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(umButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reserveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(importButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(helpButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton)
                .addGap(15, 15, 15))
        );
        innerPanelLayout.setVerticalGroup(
            innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, innerPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(venueButton)
                    .addComponent(umButton)
                    .addComponent(reserveButton)
                    .addComponent(exportButton)
                    .addComponent(importButton)
                    .addComponent(logoutButton)
                    .addComponent(helpButton)
                    .addComponent(closeButton))
                .addGap(28, 28, 28))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        OuterDashPanel.add(innerPanel, gridBagConstraints);

        VenueTab.setBackground(new java.awt.Color(49, 98, 95));
        VenueTab.setMaximumSize(new java.awt.Dimension(1920, 1080));
        VenueTab.setMinimumSize(new java.awt.Dimension(1920, 1080));
        VenueTab.setPreferredSize(new java.awt.Dimension(1920, 1080));

        mainPanel.setLayout(new javax.swing.BoxLayout(mainPanel, javax.swing.BoxLayout.LINE_AXIS));
        scrollPane.setViewportView(mainPanel);

        btnAddSection.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAddSection.setForeground(new java.awt.Color(255, 255, 255));
        btnAddSection.setText("Add Section");
        btnAddSection.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAddSection.setContentAreaFilled(false);
        btnAddSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddSectionMouseClicked(evt);
            }
        });
        btnAddSection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSectionActionPerformed(evt);
            }
        });

        venueNameField.setText("Venue Name");

        venueSaveBtn.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        venueSaveBtn.setForeground(new java.awt.Color(255, 255, 255));
        venueSaveBtn.setText("Save Venue");
        venueSaveBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        venueSaveBtn.setContentAreaFilled(false);
        venueSaveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venueSaveBtnActionPerformed(evt);
            }
        });

        venueLoadBtn.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        venueLoadBtn.setForeground(new java.awt.Color(255, 255, 255));
        venueLoadBtn.setText("Load Venue");
        venueLoadBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        venueLoadBtn.setContentAreaFilled(false);
        venueLoadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venueLoadBtnActionPerformed(evt);
            }
        });

        deleteSectionBtn.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        deleteSectionBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteSectionBtn.setText("Delete Section");
        deleteSectionBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteSectionBtn.setContentAreaFilled(false);
        deleteSectionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSectionBtnActionPerformed(evt);
            }
        });

        venueLoadingLabel.setForeground(new java.awt.Color(255, 255, 255));
        venueLoadingLabel.setText("LOADING...");

        javax.swing.GroupLayout VenueTabLayout = new javax.swing.GroupLayout(VenueTab);
        VenueTab.setLayout(VenueTabLayout);
        VenueTabLayout.setHorizontalGroup(
            VenueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VenueTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VenueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane)
                    .addGroup(VenueTabLayout.createSequentialGroup()
                        .addComponent(venueNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddSection)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteSectionBtn)
                        .addGap(220, 220, 220)
                        .addComponent(venueLoadingLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1143, Short.MAX_VALUE)
                        .addComponent(venueLoadBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(venueSaveBtn)))
                .addContainerGap())
        );
        VenueTabLayout.setVerticalGroup(
            VenueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VenueTabLayout.createSequentialGroup()
                .addGroup(VenueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VenueTabLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(VenueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(VenueTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnAddSection)
                                .addComponent(venueSaveBtn)
                                .addComponent(venueLoadBtn)
                                .addComponent(deleteSectionBtn))
                            .addComponent(venueNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(venueLoadingLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 990, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 4;
        OuterDashPanel.add(VenueTab, gridBagConstraints);

        UMTab.setBackground(new java.awt.Color(49, 98, 95));
        UMTab.setMaximumSize(new java.awt.Dimension(1920, 1080));
        UMTab.setMinimumSize(new java.awt.Dimension(1920, 1080));
        UMTab.setPreferredSize(new java.awt.Dimension(1920, 1080));
        UMTab.setLayout(new java.awt.GridBagLayout());

        Usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Username", "Password", "Address", "Season Ticket Holder"
            }
        ));
        Usertable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(Usertable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1069;
        gridBagConstraints.ipady = 530;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(18, 450, 280, 385);
        UMTab.add(jScrollPane1, gridBagConstraints);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 328;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 460, 0, 0);
        UMTab.add(jTextField1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Search Data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 7;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(160, 460, 0, 0);
        UMTab.add(jLabel1, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Save Users");
        jButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 588, 0, 0);
        UMTab.add(jButton1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        OuterDashPanel.add(UMTab, gridBagConstraints);

        ReserveTab.setBackground(new java.awt.Color(49, 98, 95));
        ReserveTab.setMaximumSize(new java.awt.Dimension(1920, 1080));
        ReserveTab.setMinimumSize(new java.awt.Dimension(1920, 1080));
        ReserveTab.setPreferredSize(new java.awt.Dimension(1920, 1080));
        ReserveTab.setLayout(new java.awt.GridBagLayout());

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 146;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 23, 0, 0);
        ReserveTab.add(searchTextField, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search Data");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(100, 610, 0, 0);
        ReserveTab.add(jLabel2, gridBagConstraints);

        FilterSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Username", "Venue", "Date" }));
        FilterSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 610, 0, 0);
        ReserveTab.add(FilterSearch, gridBagConstraints);

        reservationSearch.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        reservationSearch.setForeground(new java.awt.Color(255, 255, 255));
        reservationSearch.setText("Search");
        reservationSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        reservationSearch.setContentAreaFilled(false);
        reservationSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservationSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(1, 20, 0, 0);
        ReserveTab.add(reservationSearch, gridBagConstraints);

        reservationTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Reservation Date", "Seat info", "Paid For", "Discount"
            }
        ));
        jScrollPane2.setViewportView(reservationTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 750;
        gridBagConstraints.ipady = 429;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(38, 600, 421, 0);
        ReserveTab.add(jScrollPane2, gridBagConstraints);

        createReservation.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        createReservation.setForeground(new java.awt.Color(255, 255, 255));
        createReservation.setText("Create Reservation");
        createReservation.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createReservation.setContentAreaFilled(false);
        createReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createReservationActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 27;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(38, 14, 0, 380);
        ReserveTab.add(createReservation, gridBagConstraints);

        deleteReservationbtn.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        deleteReservationbtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteReservationbtn.setText("Delete Reservation");
        deleteReservationbtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        deleteReservationbtn.setContentAreaFilled(false);
        deleteReservationbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteReservationbtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 14, 0, 380);
        ReserveTab.add(deleteReservationbtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        OuterDashPanel.add(ReserveTab, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OuterDashPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1226, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OuterDashPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 682, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        


    private void IMPaddressListMouseClicked(java.awt.event.MouseEvent evt) {                                            

    }                                           

    private void IMPticketAssignmentMouseClicked(java.awt.event.MouseEvent evt) {                                                 

    }                                                

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {                                          
        utility.userLogout();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashboard(utility).setVisible(true);
                SwingUtilities.getWindowAncestor(logoutButton).dispose();
            }
        });
    }                                         

    private void importButtonMouseClicked(java.awt.event.MouseEvent evt) {                                          
        int x = importButton.getLocationOnScreen().x;
        int y = importButton.getLocationOnScreen().y + importButton.getHeight();
        importMenu.setPreferredSize(new Dimension(importButton.getWidth(), importMenu.getPreferredSize().height));
        importMenu.show(this, x - this.getLocationOnScreen().x, y - this.getLocationOnScreen().y);
    }                                         

    private void exportButtonMouseClicked(java.awt.event.MouseEvent evt) {                                          
        int x = exportButton.getLocationOnScreen().x;
        int y = exportButton.getLocationOnScreen().y + exportButton.getHeight();
        exportMenu.setPreferredSize(new Dimension(exportButton.getWidth(), exportMenu.getPreferredSize().height));
        exportMenu.show(this, x - this.getLocationOnScreen().x, y - this.getLocationOnScreen().y);
    }                                         

    private void reserveButtonMouseClicked(java.awt.event.MouseEvent evt) {                                           
        //switch displayed panel / tab - Trey
        PanelDisplay(ReserveTab, UMTab, VenueTab, true);
        populateUserTable();                // Push to JTable
        reloadReservations();
    }                                          

    private void umButtonMouseClicked(java.awt.event.MouseEvent evt) {                                      
        //switch displayed panel / tab - Trey
        PanelDisplay(UMTab, VenueTab, ReserveTab, true);
        populateUserTable();                // Push to JTable
        reloadReservations();
    }                                     

    private void venueButtonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        //switch displayed panel / tab - Trey
        PanelDisplay(VenueTab, UMTab, ReserveTab, true);
        populateUserTable();                // Push to JTable
        reloadReservations();
    }                                        

    private void helpButtonMouseClicked(java.awt.event.MouseEvent evt) {                                        
        PanelDisplay(helpPanel, true);
    }                                       

    private void closeHelpMouseClicked(java.awt.event.MouseEvent evt) {                                       
        PanelDisplay(helpPanel, false);
    }                                      

//    
//    private void initUserTableFlow() {
//        utility.importUsers();      // → memory
//        
//        // ── SYNC ALL EXISTING RESERVATIONS INTO utility.reservationList ──
//        utility.getAllReservations().clear();
//        for (UserAccount u : utility.getUserAccounts()) {
//            for (Reservation r : u.getReservations()) {
//                utility.getAllReservations().add(r);
//            }
//        }
//
//        populateUserTable();        // memory → JTable
//
//        // listener: JTable → memory, on every cell edit
//        DefaultTableModel tm = (DefaultTableModel) Usertable.getModel();
//        tm.addTableModelListener(e -> {
//            int r = e.getFirstRow(), c = e.getColumn();
//            if (r < 0 || c < 0) {
//                return;
//            }
//
//            String newUserName = tm.getValueAt(r, 0).toString().trim();
//
//            // Look up by *row*, not by name (safer when the name itself changes)
//            UserAccount u = utility.getUserAccounts().get(r);
//
//            switch (c) {
//                case 0 ->
//                    u.setUsername(newUserName);            // <‑‑ added
//                case 1 ->
//                    u.setPassword(tm.getValueAt(r, 1).toString());
//                case 2 ->
//                    u.setAddress(tm.getValueAt(r, 2).toString());
//                case 3 ->
//                    u.setSeasonTicketHolder(
//                            Boolean.parseBoolean(tm.getValueAt(r, 3).toString()));
//            }
//        });
//        
//
//        /* also save automatically when the Admin logs out or quits */
//        logoutButton.addActionListener(e -> {
//            utility.exportUsers();
//          
//        });
////        addWindowListener(new WindowAdapter() {
////            public void windowClosing(WindowEvent we) {
////                utility.exportUsers();
////            }
////        });
//        
//    }
    
    /**
     * push every in‑memory user into the JTable
     */
    private void populateUserTable() {
        DefaultTableModel tm = (DefaultTableModel) Usertable.getModel();
        tm.setRowCount(0);
        for (UserAccount u : utility.getUserAccounts()) {
            tm.addRow(new Object[]{
                u.getUsername(), u.getPassword(),
                u.getAddress(), u.getSeasonTicketHolder()
            });
        }
    }
    
  
        

    


    
    
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {                                        
        // TODO add your handling code here:
        
  
         DefaultTableModel model = (DefaultTableModel) Usertable.getModel();
         TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
         Usertable.setRowSorter(sorter);
         
         String searchText = jTextField1.getText();
         sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText)); // case-insensitive
       

       
    }                                       

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           
    
    ////////////////VENUE CREATION STUFF//////////////////////////////////////////////////////////////////////
    private void btnAddSectionActionPerformed(java.awt.event.ActionEvent evt) {                                              
       addSection();
    }                                             

    private void btnAddSectionMouseClicked(java.awt.event.MouseEvent evt) {                                           
        // not used
    }                                          

    private void venueSaveBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        saveVenue();
    }                                            

    private void closeButtonMouseClicked(java.awt.event.MouseEvent evt) {                                         
        System.exit(0);
    }                                        

    private void venueLoadBtnActionPerformed(java.awt.event.ActionEvent evt) {                                             
        showVenueSelector();
    }                                            

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void FilterSearchActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    public void showCreateReservationPopup() {
        // 1) build the form
        JPanel panel = new JPanel(new GridLayout(9, 2, 5, 5));
        JTextField usernameField = new JTextField();
        JTextField venueField = new JTextField();
        JTextField sectionField = new JTextField();
        JTextField rowField = new JTextField();
        JTextField seatField = new JTextField();
        JTextField dateField = new JTextField("yyyy-MM-dd");
        JTextField discountField = new JTextField("0.0");        // percent
        JCheckBox isPaidFor = new JCheckBox("Paid");
        JCheckBox isSeasonTicket = new JCheckBox("Season Ticket Holder");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Venue Name:"));
        panel.add(venueField);
        panel.add(new JLabel("Section:"));
        panel.add(sectionField);
        panel.add(new JLabel("Row:"));
        panel.add(rowField);
        panel.add(new JLabel("Seat Number(s):"));
        panel.add(seatField);
        panel.add(new JLabel("Date:"));
        panel.add(dateField);
        panel.add(new JLabel("Discount %:"));
        panel.add(discountField);
        panel.add(new JLabel("Paid for:"));
        panel.add(isPaidFor);
        panel.add(new JLabel("Season Ticket?"));
        panel.add(isSeasonTicket);

        int result = JOptionPane.showConfirmDialog(
                this, panel, "Create Reservation",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE
        );
        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        // 2) pull & validate inputs
        String uname = usernameField.getText().trim();
        String venue = venueField.getText().trim();
        String section = sectionField.getText().trim();
        String rowStr = rowField.getText().trim();
        String seatStr = seatField.getText().trim();
        String dateStr = dateField.getText().trim();
        String discStr = discountField.getText().trim();
        boolean paid = isPaidFor.isSelected();
        boolean season = isSeasonTicket.isSelected();

        if (uname.isEmpty() || venue.isEmpty() || section.isEmpty()
                || rowStr.isEmpty() || seatStr.isEmpty() || dateStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all required fields.");
            return;
        }

        UserAccount target = utility.findUser(uname);
        if (target == null) {
            JOptionPane.showMessageDialog(this, "User \"" + uname + "\" not found.");
            return;
        }

        int rowIndex;
        try {
            rowIndex = Integer.parseInt(rowStr) - 1; // convert to 0-based
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Row must be a number.");
            return;
        }

        float discountPct;
        try {
            discountPct = Float.parseFloat(discStr) / 100f;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Discount must be a decimal (e.g. 10 for 10%).");
            return;
        }

        LocalDate date;
        try {
            date = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Date format must be yyyy-MM-dd.");
            return;
        }

        // 3) finds price for rows
        Venue v = utility.findVenue(venue);
        if (v == null) {
            JOptionPane.showMessageDialog(this, "Venue not found.");
            return;
        }
        Section sec = v.findSection(section);
        if (sec == null) {
            JOptionPane.showMessageDialog(this, "Section not found.");
            return;
        }
        List<Row> rowsList = sec.getRows();
        if (rowIndex < 0 || rowIndex >= rowsList.size()) {
            JOptionPane.showMessageDialog(this, "Invalid row number.");
            return;
        }
        Row rowObj = rowsList.get(rowIndex);

        // 4) build the ticket list with correct prices
        ArrayList<Ticket> tickets = new ArrayList<>();
        for (String token : seatStr.split("-")) {
            int seatNum;
            try {
                seatNum = Integer.parseInt(token.trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid seat number: " + token);
                return;
            }
            Ticket template = rowObj.getTicketWithNum(seatNum);
            if (template == null) {
                JOptionPane.showMessageDialog(this, "Seat not found: " + seatNum);
                return;
            }
           
            tickets.add(new Ticket(
                    template.getSeatNum(),
                    rowObj.getRowPrice(),
                    template.getDisabledSeat()
            ));
        }

        // 5) if “Paid” was checked, compute total and collect payment method
        if (paid) {
            float subtotal = 0;
            for (Ticket t : tickets) {
                subtotal += rowObj.getRowPrice(); // since all ticket prices come from the row
            }
            float totalDue = subtotal * (1 - discountPct);

            String[] options = {"Cash", "Credit", "Check"};
            int method = JOptionPane.showOptionDialog(
                    this,
                    String.format("Total: $%.2f\nChoose payment method:", totalDue),
                    "Payment Method",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (method == 0) { // Cash
                String paidStr = JOptionPane.showInputDialog(
                        this,
                        String.format("Total due: $%.2f\nEnter cash amount:", totalDue),
                        "Cash Payment",
                        JOptionPane.PLAIN_MESSAGE
                );
                if (paidStr == null) {
                    return;
                }
                float paidAmount;
                try {
                    paidAmount = Float.parseFloat(paidStr);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid cash amount.");
                    return;
                }
                if (paidAmount < totalDue) {
                    JOptionPane.showMessageDialog(this, "Insufficient cash.");
                    return;
                }
                JOptionPane.showMessageDialog(this,
                        String.format("Payment accepted! Change: $%.2f", paidAmount - totalDue));

            } else if (method == 1) { // Credit
                String ccNum = JOptionPane.showInputDialog(this, "Enter 16-digit credit card number:");
                if (ccNum == null || !ccNum.matches("\\d{16}")) {
                    JOptionPane.showMessageDialog(this, "Invalid card number. Must be 16 digits.");
                    return;
                }
                JOptionPane.showMessageDialog(this, "Credit card accepted.");

            } else if (method == 2) { // Check
                JOptionPane.showMessageDialog(this, "Check received. Payment successful.");

            } else {
                return; // Cancelled
            }
        }


        // 6) finally, make the reservation
        if (season) {
            List<Reservation> results = utility.makeSeasonTicketReservations(
                    target, venue, section, rowIndex, tickets, date, discountPct
            );
            results.forEach(r -> r.setPaidFor(paid));
            utility.exportUsers();
            updateTable(new ArrayList<>(results));
            JOptionPane.showMessageDialog(this, "Season ticket booked (52 weeks)!");
        } else {
            Reservation res = utility.makeReservation(
                    target, venue, section, rowIndex, tickets, date, false, discountPct
            );
            if (res != null) {
                res.setPaidFor(paid);
                utility.exportUsers();
                updateTable(new ArrayList<>(Collections.singletonList(res)));
                JOptionPane.showMessageDialog(this, "One-off reservation created!");
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Failed to create reservation. Seat may be taken or invalid data."
                );
            }
        }

        // 7) refresh master reservations view
        updateTable(utility.getAllReservations());
    }

    
    
    
    
    
    
    private void reservationSearchActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        String selectedFilter = (String) FilterSearch.getSelectedItem();
        // Retrieve and trim the search term from the text field
        String searchTerm = searchTextField.getText().trim();
        
        
         // Initialize an empty list for the search results
        ArrayList<Reservation> reservations = new ArrayList<>();
        
        // Validate that a search term was provided
        if (searchTerm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a search term.");
            return;
        }
        
        // Decide on the search strategy based on the combo box selection
        switch (selectedFilter) {
            case "Username":
                // Calls searchReservations(String userName)
                reservations = utility.searchReservations(searchTerm);
                break;

            case "Date":
                try {
                    // Assuming date format is "yyyy-MM-dd"
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate date = LocalDate.parse(searchTerm, dtf);
                    // Calls searchReservations(LocalDate searchDate)
                    reservations = utility.searchReservations(date);
                } catch (DateTimeParseException e) {
                    JOptionPane.showMessageDialog(this, "Invalid date format. Please use yyyy-MM-dd.");
                    return;
                }
                break;

            case "Venue":
                // Find the Venue object based on the entered name
                Venue venue = utility.findVenue(searchTerm);
                if (venue == null) {
                    JOptionPane.showMessageDialog(this, "Venue not found.");
                    return;
                }
                // Calls searchReservations(Venue venue)
                reservations = utility.searchReservations(venue);
                break;

            default:
                JOptionPane.showMessageDialog(this, "Unknown search filter selected.");
                return;
        }

        updateTable(reservations);
             
        
    }                                                 

    private void createReservationActionPerformed(java.awt.event.ActionEvent evt) {                                                  
      
    showCreateReservationPopup();
    
    }                                                 

    private void deleteSectionBtnActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        int count = mainPanel.getComponentCount();
        if (count > 0) {
            mainPanel.remove(count - 1); // remove last added section
            mainPanel.revalidate();
            mainPanel.repaint();
        }
    }                                                

    private void deleteReservationbtnActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        int selectedRow = reservationTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a reservation to delete.");
            return;
        }

        // Confirm deletion
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this reservation?",
                "Delete Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        // Get selected values from table
        String dateStr = reservationTable.getValueAt(selectedRow, 0).toString();
        String seatInfo = reservationTable.getValueAt(selectedRow, 1).toString();

        // Parse the date
        LocalDate date;
        try {
            date = LocalDate.parse(dateStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Invalid date format.");
            return;
        }

        // Loop through all users and find the reservation match
        for (UserAccount user : utility.getUserAccounts()) {
            ArrayList<Reservation> reservations = user.getReservations();
            for (int i = 0; i < reservations.size(); i++) {
                Reservation res = reservations.get(i);
                if (!res.getDate().isEmpty() && res.getDate().get(0).equals(date)
                        && !res.getSeatData().isEmpty() && res.getSeatData().get(0).equals(seatInfo)) {

                    // Use your utility method to delete it
                    utility.deleteReservation(user, i);

                    JOptionPane.showMessageDialog(this, "Reservation deleted.");
                    updateTable(utility.getAllReservations()); // Refresh the table
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(this, "Reservation not found.");
    }                                                    

    private void reserveButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void umButtonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        DefaultTableModel model = (DefaultTableModel) Usertable.getModel();
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < model.getRowCount(); r++) {
            String uname = model.getValueAt(r, 0).toString().trim();

            if (seen.contains(uname)) {
                JOptionPane.showMessageDialog(this,
                        "Username \"" + uname + "\" is already in use.\nReverting to last saved state.",
                        "Duplicate Username", JOptionPane.ERROR_MESSAGE);

                utility.importUsers(); // :arrow_left: Restore from file
                populateUserTable();   // :arrow_left: Refresh UI
                return;
            }

            seen.add(uname);

            // Update memory from table
            UserAccount u = utility.getUserAccounts().get(r);
            u.setUsername(uname);
            u.setPassword(model.getValueAt(r, 1).toString());
            u.setAddress(model.getValueAt(r, 2).toString());
            u.setSeasonTicketHolder(Boolean.parseBoolean(model.getValueAt(r, 3).toString()));
        }

       
        JOptionPane.showMessageDialog(this, "All changes saved successfully!", "Saved", JOptionPane.INFORMATION_MESSAGE);
    }                                        

    private void venueButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    // Updates users Table
    private void updateTable(ArrayList<Reservation> reservations){
        
         
        DefaultTableModel model = (DefaultTableModel) reservationTable.getModel();
        // 1) Wipe out old rows
        model.setRowCount(0);

        // 2) Add one row per reservation
        for (Reservation res : reservations) {
            String dateStr = res.getDate().isEmpty() ? "" : res.getDate().get(0).toString();
            String seatInfo = res.getSeatData().isEmpty() ? "" : res.getSeatData().get(0);
            String paidForStr = res.getPaidFor().toString();
            String discountStr = String.format("%.0f%%", res.getDiscount() * 100);

            model.addRow(new Object[]{dateStr, seatInfo, paidForStr, discountStr});
        }
        
    }
    
    //Update Reservatoin Tables
    private void reloadReservations() {
        // 2) rebuild master reservation list
        utility.getAllReservations().clear();
        for (UserAccount u : utility.getUserAccounts()) {
            utility.getAllReservations().addAll(u.getReservations());
        }
        // 3) push into your JTable
        updateTable(utility.getAllReservations());
    }
    
    private void addSection() {
        JPanel sectionPanel = new JPanel();
        sectionPanel.setLayout(new BorderLayout());
        sectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Section Name and Price Text Field
        JPanel sectionHeader = new JPanel(new FlowLayout());
        JTextField sectionNameField = new JTextField("Section Name", 10);
        JTextField sectionPriceField = new JTextField("0.0", 5); // Section price input
        sectionHeader.add(new JLabel("Name:"));
        sectionHeader.add(sectionNameField);
        sectionHeader.add(new JLabel("Price:"));
        sectionHeader.add(sectionPriceField);
        sectionPanel.putClientProperty("sectionPriceField", sectionPriceField);
        sectionPanel.putClientProperty("sectionNameField", sectionNameField);
        sectionPanel.add(sectionHeader, BorderLayout.NORTH);

        JPanel seatGrid = new JPanel();
        seatGrid.setLayout(new GridBagLayout());
        sectionPanel.putClientProperty("seatGrid", seatGrid);
        
        List<List<JButton>> rows = new ArrayList<>();
        Map<Integer, Float> rowPrices = new HashMap<>();

        // Store rowPrices in the panel so saveVenue can access it
        sectionPanel.putClientProperty("rowPrices", rowPrices);

        // Row Control Panel
        JPanel rowControlPanel = new JPanel(new FlowLayout());
        JTextField seatCountField = new JTextField("Seats", 5);
        JTextField rowPriceField = new JTextField("0.0", 5);
        JButton addRowButton = new JButton("Add Row");
        addRowButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        addRowButton.setContentAreaFilled(false);
        addRowButton.setFont(new Font("Verdana", Font.BOLD, 12));

        addRowButton.addActionListener(e -> addRow(seatGrid, seatCountField, rowPriceField, rows, rowPrices));
        
        JButton deleteRowButton = new JButton("Delete Row");
        deleteRowButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        deleteRowButton.setContentAreaFilled(false);
        deleteRowButton.setFont(new Font("Verdana", Font.BOLD, 12));
        deleteRowButton.addActionListener(e -> {
            if (!rows.isEmpty()) {
                int lastIndex = rows.size() - 1;
                List<JButton> lastRow = rows.remove(lastIndex);
                rowPrices.remove(lastIndex);

                for (JButton seat : lastRow) {
                    seatGrid.remove(seat);
                }

                centerRows(seatGrid, rows);
                seatGrid.revalidate();
                seatGrid.repaint();
            }
        });

        rowControlPanel.add(new JLabel("Seats:"));
        rowControlPanel.add(seatCountField);
        rowControlPanel.add(new JLabel("Row Price:"));
        rowControlPanel.add(rowPriceField);
        rowControlPanel.add(addRowButton);
        rowControlPanel.add(deleteRowButton);

        sectionPanel.add(rowControlPanel, BorderLayout.WEST);
        sectionPanel.add(seatGrid, BorderLayout.CENTER);

        mainPanel.add(sectionPanel);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    private void addRow(JPanel seatGrid, JTextField seatCountField, JTextField rowPriceField, List<List<JButton>> rows, Map<Integer, Float> rowPrices) {
        int seatsInRow;
        float rowPrice;
        try {
            seatsInRow = Integer.parseInt(seatCountField.getText().trim());
            rowPrice = Float.parseFloat(rowPriceField.getText().trim());
            if (seatsInRow <= 0) return;
        } catch (NumberFormatException e) {
            return;
        }

        List<JButton> newRow = new ArrayList<>();
        rows.add(newRow);
        int rowIndex = rows.size() - 1;
        rowPrices.put(rowIndex, rowPrice);

        for (int i = 0; i < seatsInRow; i++) {
            JButton seatButton = new JButton("Seat ");
            seatButton.setBackground(Color.GREEN);
            seatButton.setOpaque(true);
            seatButton.setBorderPainted(false);
            seatButton.setPreferredSize(new Dimension(80, 30));
            seatButton.setToolTipText("Price: $" + rowPrice);
            seatButton.addActionListener(e -> toggleSeatSelection(seatButton));
            newRow.add(seatButton);
        }

        centerRows(seatGrid, rows);
    }

    private void centerRows(JPanel seatGrid, List<List<JButton>> rows) {
        seatGrid.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(2, 2, 2, 2);

        int maxRowSize = rows.stream().mapToInt(List::size).max().orElse(0);

        for (int col = 0; col < rows.size(); col++) {
            List<JButton> row = rows.get(col);
            int offset = (maxRowSize - row.size()) / 2; // Center the row

            for (int i = 0; i < row.size(); i++) {
                gbc.gridx = col;
                gbc.gridy = i + offset;
                seatGrid.add(row.get(i), gbc);
            }
        }

        seatGrid.revalidate();
        seatGrid.repaint();
    }

    private void toggleSeatSelection(JButton seatButton) {
        seatButton.setBackground(seatButton.getBackground().equals(Color.GREEN) ? Color.BLUE : Color.GREEN);
    }
    
    private boolean saveVenue() {
        String venueName = venueNameField.getText().trim().replaceAll(" ", "_");
        ArrayList<Section> sections = new ArrayList<>();

        for (Component sectionComp : mainPanel.getComponents()) {
            if (!(sectionComp instanceof JPanel sectionPanel)) continue;

            // Get section name and price from client properties
            JTextField sectionNameField = (JTextField) sectionPanel.getClientProperty("sectionNameField");
            JTextField sectionPriceField = (JTextField) sectionPanel.getClientProperty("sectionPriceField");
            JPanel seatGrid = (JPanel) sectionPanel.getClientProperty("seatGrid");
            Map<Integer, Float> rowPrices = (Map<Integer, Float>) sectionPanel.getClientProperty("rowPrices");

            String sectionName = (sectionNameField != null) ? sectionNameField.getText().trim() : "Unnamed";
            float sectionPrice = 0f;
            if (sectionPriceField != null) {
                try {
                    sectionPrice = Float.parseFloat(sectionPriceField.getText().trim());
                } catch (NumberFormatException ignored) {
                }
            }

            ArrayList<Row> rows = new ArrayList<>();
            if (seatGrid != null && seatGrid.getLayout() instanceof GridBagLayout layout) {
                // Map row indices to their seat lists
                Map<Integer, ArrayList<Ticket>> tempRowMap = new TreeMap<>();
                int seatNum = 1;

                for (Component seatButton : seatGrid.getComponents()) {
                    if (seatButton instanceof JButton btn) {
                        GridBagConstraints gbc = layout.getConstraints(btn);
                        int rowIdx = gbc.gridx;
                        boolean handicapSeat = btn.getBackground().equals(Color.BLUE);

                        Ticket ticket = new Ticket(seatNum, 0, handicapSeat);
                        seatNum++;
                        tempRowMap.computeIfAbsent(rowIdx, k -> new ArrayList<>()).add(ticket);
                    }
                }

                int rowIndex = 0;
                for (ArrayList<Ticket> ticketList : tempRowMap.values()) {
                    float rowPrice = (rowPrices != null) ? rowPrices.getOrDefault(rowIndex, 0f) : 0f;
                    rows.add(new Row(ticketList, rowPrice));
                    rowIndex++;
                }
            }

            sections.add(new Section(rows, sectionPrice, sectionName));
        }

        Venue venue = new Venue(sections, venueName);
        venueLoadingLabel.setVisible(true);
        utility.exportData(venue);
        utility.importVenues();
        utility.selectVenue(utility.findVenue(venueName));
        venueLoadingLabel.setVisible(false);
        return true;
    }
    
    private void showVenueSelector() {
        ArrayList<String> venueNames = utility.getLoadedVenues();
        String[] venueArray = venueNames.toArray(new String[0]);

        String selected = (String) JOptionPane.showInputDialog(VenueTab, "Select Venue", "Load Venue",
                JOptionPane.PLAIN_MESSAGE, null, venueArray, venueArray.length > 0 ? venueArray[0] : null);

        if (selected != null) {
            Venue venue = utility.findVenue(selected);
            if (venue != null) {
                rebuildFromVenue(venue);
            }
        }
    }
    
    private final JProgressBar loadingSpinner = new JProgressBar();

    private void rebuildFromVenue(Venue venue) {
        JDialog loadingDialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(VenueTab), "Loading", true);
        loadingDialog.setUndecorated(true);

        JPanel dialogPanel = new JPanel(new BorderLayout());
        JProgressBar loadingSpinner = new JProgressBar();
        loadingSpinner.setIndeterminate(true);
        loadingSpinner.setString("Loading venue...");
        loadingSpinner.setStringPainted(true);

        dialogPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
        dialogPanel.add(loadingSpinner, BorderLayout.CENTER);
        loadingDialog.getContentPane().add(dialogPanel);
        loadingDialog.pack();
        loadingDialog.setLocationRelativeTo(VenueTab);

        SwingUtilities.invokeLater(() -> loadingDialog.setVisible(true));
        
        new Timer(10, e -> {
            ((Timer) e.getSource()).stop(); // stop the timer

            mainPanel.removeAll();
            venueNameField.setText(venue.getVenueName().replaceAll("_", " "));
            utility.selectVenue(venue);

            for (Section section : venue.getSections()) {
                JPanel sectionPanel = new JPanel(new BorderLayout());
                sectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                JPanel sectionHeader = new JPanel(new FlowLayout());
                JTextField sectionNameField = new JTextField(section.getSectionName().replaceAll("_", " "), 10);
                JTextField sectionPriceField = new JTextField(String.valueOf(section.getSecPrice()), 5);
                sectionHeader.add(new JLabel("Name:"));
                sectionHeader.add(sectionNameField);
                sectionHeader.add(new JLabel("Price:"));
                sectionHeader.add(sectionPriceField);
                sectionPanel.add(sectionHeader, BorderLayout.NORTH);

                JPanel seatGrid = new JPanel(new GridBagLayout());
                sectionPanel.add(seatGrid, BorderLayout.CENTER);

                List<List<JButton>> rows = new ArrayList<>();
                Map<Integer, Float> rowPrices = new HashMap<>();

                int rowIndex = 0;
                for (Row row : section.getRows()) {
                    List<JButton> seatRow = new ArrayList<>();
                    for (Ticket ticket : row.getTickets()) {
                        JButton seatButton = new JButton("Seat " + ticket.getSeatNum());
                        seatButton.setBackground(ticket.disabledSeat ? Color.BLUE : Color.GREEN);
                        seatButton.setOpaque(true);
                        seatButton.setBorderPainted(false);
                        seatButton.setPreferredSize(new Dimension(80, 30));
                        seatButton.setToolTipText("Price: $" + row.getRowPrice());
                        seatButton.addActionListener(ee -> toggleSeatSelection(seatButton));
                        seatRow.add(seatButton);
                    }
                    rows.add(seatRow);
                    rowPrices.put(rowIndex, row.getRowPrice());
                    rowIndex++;
                }

                JPanel rowControlPanel = new JPanel(new FlowLayout());
                JTextField seatCountField = new JTextField("Seats", 5);
                JTextField rowPriceField = new JTextField("0.0", 5);
                JButton addRowButton = new JButton("Add Row");
                addRowButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                addRowButton.setContentAreaFilled(false);
                addRowButton.setFont(new Font("Verdana", Font.BOLD, 12));
                addRowButton.addActionListener(ee -> addRow(seatGrid, seatCountField, rowPriceField, rows, rowPrices));
                rowControlPanel.add(new JLabel("Seats:"));
                rowControlPanel.add(seatCountField);
                rowControlPanel.add(new JLabel("Row Price:"));
                JButton deleteRowButton = new JButton("Delete Row");
                deleteRowButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
                deleteRowButton.setContentAreaFilled(false);
                deleteRowButton.setFont(new Font("Verdana", Font.BOLD, 12));
                deleteRowButton.addActionListener(ee -> {
                    if (!rows.isEmpty()) {
                        int lastIndex = rows.size() - 1;
                        List<JButton> lastRow = rows.remove(lastIndex);
                        rowPrices.remove(lastIndex);

                        for (JButton seat : lastRow) {
                            seatGrid.remove(seat);
                        }

                        centerRows(seatGrid, rows);
                        seatGrid.revalidate();
                        seatGrid.repaint();
                    }
                });

                rowControlPanel.add(rowPriceField);
                rowControlPanel.add(addRowButton);
                rowControlPanel.add(deleteRowButton);
                sectionPanel.add(rowControlPanel, BorderLayout.WEST);

                sectionPanel.putClientProperty("sectionNameField", sectionNameField);
                sectionPanel.putClientProperty("sectionPriceField", sectionPriceField);
                sectionPanel.putClientProperty("seatGrid", seatGrid);
                sectionPanel.putClientProperty("rowPrices", rowPrices);

                centerRows(seatGrid, rows);

                SwingUtilities.invokeLater(() -> mainPanel.add(sectionPanel));
            }

            // After the main logic completes
            mainPanel.revalidate();
            mainPanel.repaint();
            loadingDialog.dispose();
        }).start();
    }

    ////////////////VENUE CREATION STUFF//////////////////////////////////////////////////////////////////////
    
    
    private void importAddList() {
        JFileChooser openDialog = new JFileChooser();
        openDialog.showOpenDialog(null);

        String filepath = openDialog.getSelectedFile().getAbsolutePath();

        utility.importAddressList(filepath);
    }

    private void importTicketList() {
        JFileChooser openDialog = new JFileChooser();
        openDialog.showOpenDialog(null);

        String filepath = openDialog.getSelectedFile().getAbsolutePath();

        utility.importTickets(filepath);
    }

      private void exportAddList() {
        JFileChooser saveDialog = new JFileChooser();
        saveDialog.showSaveDialog(null);

        String filepath = saveDialog.getSelectedFile().getAbsolutePath();

        utility.exportAddressList(filepath + ".csv", false);
    }

    private void exportSthList() {
        JFileChooser saveDialog = new JFileChooser();
        saveDialog.showSaveDialog(null);

        String filepath = saveDialog.getSelectedFile().getAbsolutePath();

        utility.exportAddressList(filepath + ".csv", true);
    }

    private void exportTicketList() {
        JFileChooser saveDialog = new JFileChooser();
        saveDialog.showSaveDialog(null);

        String filepath = saveDialog.getSelectedFile().getAbsolutePath();

        utility.exportTickets(filepath + ".csv");
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminDashboard().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> FilterSearch;
    private javax.swing.JTextArea HelpDisplay;
    private javax.swing.JScrollPane HelpDocDisplay;
    private javax.swing.JMenuItem IMPaddressList;
    private javax.swing.JMenuItem IMPticketAssignment;
    private javax.swing.JPanel OuterDashPanel;
    private javax.swing.JPanel ReserveTab;
    private javax.swing.JPanel UMTab;
    private javax.swing.JTable Usertable;
    private javax.swing.JPanel VenueTab;
    private javax.swing.JMenuItem addressList;
    private javax.swing.JButton btnAddSection;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton closeHelp;
    private javax.swing.JButton createReservation;
    private javax.swing.JButton deleteReservationbtn;
    private javax.swing.JButton deleteSectionBtn;
    private javax.swing.JButton exportButton;
    private javax.swing.JPopupMenu exportMenu;
    private javax.swing.JButton helpButton;
    private javax.swing.JPanel helpPanel;
    private javax.swing.JButton importButton;
    private javax.swing.JPopupMenu importMenu;
    private javax.swing.JPanel innerPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton reservationSearch;
    private javax.swing.JTable reservationTable;
    private javax.swing.JButton reserveButton;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JMenuItem sthaddressList;
    private javax.swing.JMenuItem ticketAssignments;
    private javax.swing.JButton umButton;
    private javax.swing.JButton venueButton;
    private javax.swing.JButton venueLoadBtn;
    private javax.swing.JLabel venueLoadingLabel;
    private java.awt.TextField venueNameField;
    private javax.swing.JButton venueSaveBtn;
    // End of variables declaration                   
}
