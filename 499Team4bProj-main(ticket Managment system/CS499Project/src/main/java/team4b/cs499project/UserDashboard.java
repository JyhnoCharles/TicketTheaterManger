package team4b.cs499project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingUtilities;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import javax.swing.border.SoftBevelBorder;




public class UserDashboard extends javax.swing.JFrame {
    Utility utility;

    public UserDashboard(Utility utility) {
        initComponents();
        this.utility = utility;
        utility.importUsers();
        if (utility.getCurrentUser() == null) {
            logoutButton.setText("Login");
        }
        
        //Screen Resolution mechanics, NO TOUCHY! - Trey
        //this.setLocationRelativeTo(null); //ensure center screen pop up
        this.setResizable(false); //stops user from resizing window
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); //always ensure pixel width is maxed
        //this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize()); //ensure pixel width matches that of native screen
        this.setSize(1920, 1080);
        firstTimeStartup(); //The first time this code runs, every tab will default to closed
    }
    
    //Functions for adjusting what "tab" the screen is on
    //NOTE : for using the display function, the boolean at the end 
    //applies to the first parameter, and the opposite will apply to 
    //every other parameter. - Trey
    private void firstTimeStartup(){
        PanelDisplay(sthTab, false);
        PanelDisplay(ReservationTab, true);
        buildReservationPanel();
        PanelDisplay(helpPanel, false);
    }
    private void PanelDisplay(JComponent Panel, JComponent closePanel, boolean display) {
        Panel.setVisible(display);
        closePanel.setVisible(!display);
    }
    private void PanelDisplay(JComponent Panel, boolean display) {
        Panel.setVisible(display);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        OuterDashPanel = new javax.swing.JPanel();
        helpPanel = new javax.swing.JPanel();
        closeHelp = new javax.swing.JButton();
        HelpDocDisplay = new javax.swing.JScrollPane();
        HelpDisplay = new javax.swing.JTextArea();
        innerPanel = new javax.swing.JPanel();
        UMButton = new javax.swing.JButton();
        reserveButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        sthTab = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        usernameField = new javax.swing.JTextField();
        savebtn = new javax.swing.JButton();
        ReservationTab = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setUndecorated(true);

        OuterDashPanel.setBackground(new java.awt.Color(255, 255, 255));
        OuterDashPanel.setMaximumSize(new java.awt.Dimension(1920, 1080));
        OuterDashPanel.setMinimumSize(new java.awt.Dimension(1920, 1080));
        OuterDashPanel.setPreferredSize(new java.awt.Dimension(1920, 1080));
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
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(270, 30, 0, 0);
        helpPanel.add(closeHelp, gridBagConstraints);

        HelpDocDisplay.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        HelpDocDisplay.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        HelpDisplay.setEditable(false);
        HelpDisplay.setColumns(20);
        HelpDisplay.setRows(5);
        HelpDisplay.setText("User Help Screen\n\n1. Reservation Selection Screen (Default)\n\n- Log in if not logged in.\n- Select a date to select seats from on the calendar.\n- Select a seat or seats to purchase in the venue view.\n- Click one of the payment buttons near the bottom.\n- Type the amount of money given to calculate change.\n- Accept change.\n\n2. User Management Screen (Available Once Logged In)\n\n- Here, your user information (username, password, and address) will populate.\n- Change the values in the text box to alter them.\n- If you are satisfied with the changes, click \"Save\" to save them to your account.");
        HelpDisplay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        HelpDocDisplay.setViewportView(HelpDisplay);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 560;
        gridBagConstraints.ipady = 344;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        helpPanel.add(HelpDocDisplay, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        OuterDashPanel.add(helpPanel, gridBagConstraints);

        innerPanel.setBackground(new java.awt.Color(33, 53, 38));
        innerPanel.setMaximumSize(new java.awt.Dimension(1920, 100));
        innerPanel.setMinimumSize(new java.awt.Dimension(1920, 100));
        innerPanel.setPreferredSize(new java.awt.Dimension(1920, 100));

        UMButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        UMButton.setForeground(new java.awt.Color(255, 255, 255));
        UMButton.setText("User Management");
        UMButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        UMButton.setContentAreaFilled(false);
        UMButton.setFocusPainted(false);
        UMButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UMButtonMouseClicked(evt);
            }
        });
        UMButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UMButtonActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout innerPanelLayout = new javax.swing.GroupLayout(innerPanel);
        innerPanel.setLayout(innerPanelLayout);
        innerPanelLayout.setHorizontalGroup(
            innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(innerPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(UMButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reserveButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1489, Short.MAX_VALUE)
                .addComponent(helpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        innerPanelLayout.setVerticalGroup(
            innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(innerPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(innerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UMButton)
                    .addComponent(reserveButton)
                    .addComponent(logoutButton)
                    .addComponent(helpButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        OuterDashPanel.add(innerPanel, gridBagConstraints);

        sthTab.setBackground(new java.awt.Color(48, 63, 38));
        sthTab.setMaximumSize(new java.awt.Dimension(1920, 1080));
        sthTab.setMinimumSize(new java.awt.Dimension(1920, 1080));
        sthTab.setPreferredSize(new java.awt.Dimension(1920, 1080));
        sthTab.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 820, 0, 0);
        sthTab.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Account Information");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipady = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(190, 820, 0, 680);
        sthTab.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Address:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 28;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 830, 0, 0);
        sthTab.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 820, 0, 0);
        sthTab.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 3, 0, 680);
        sthTab.add(passwordField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 3, 0, 680);
        sthTab.add(emailField, gridBagConstraints);

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 196;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 3, 0, 680);
        sthTab.add(usernameField, gridBagConstraints);

        savebtn.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Save");
        savebtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        savebtn.setContentAreaFilled(false);
        savebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savebtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 203, 618, 0);
        sthTab.add(savebtn, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        OuterDashPanel.add(sthTab, gridBagConstraints);

        ReservationTab.setBackground(new java.awt.Color(48, 63, 38));
        ReservationTab.setMaximumSize(new java.awt.Dimension(1920, 1080));
        ReservationTab.setMinimumSize(new java.awt.Dimension(1920, 1080));
        ReservationTab.setPreferredSize(new java.awt.Dimension(1920, 1080));
        ReservationTab.setLayout(new java.awt.BorderLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 3;
        OuterDashPanel.add(ReservationTab, gridBagConstraints);
        ReservationTab.getAccessibleContext().setAccessibleName("");
        ReservationTab.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OuterDashPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OuterDashPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void logoutButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutButtonMouseClicked
        if (utility.getCurrentUser() == null) {
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new UserLoginScreen(utility).setVisible(true);
                    SwingUtilities.getWindowAncestor(logoutButton).dispose();
                }
            });
            logoutButton.setText("Logout");
        }
        else {
            utility.exportUsers(); 
            utility.userLogout();
            logoutButton.setText("Login");
        }
    }//GEN-LAST:event_logoutButtonMouseClicked

    private void reserveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserveButtonMouseClicked
        //switch displayed panel / tab  - Trey
        PanelDisplay(ReservationTab, sthTab, true);
        System.out.println(utility.getSelectedVenue().venueName);
        buildReservationPanel();
    }//GEN-LAST:event_reserveButtonMouseClicked

    private void UMButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UMButtonMouseClicked
        //switch displayed panel / tab - Trey 
        PanelDisplay(sthTab, ReservationTab, true);        
    }//GEN-LAST:event_UMButtonMouseClicked

    private void closeHelpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeHelpMouseClicked
        PanelDisplay(helpPanel, false);
    }//GEN-LAST:event_closeHelpMouseClicked

    private void helpButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpButtonMouseClicked
        PanelDisplay(helpPanel, true);
    }//GEN-LAST:event_helpButtonMouseClicked

    private void UMButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UMButtonActionPerformed
        // TODO add your handling code here:
         UserAccount current = utility.getCurrentUser();
         
         if (current == null) {
            JOptionPane.showMessageDialog(this, "You must be logged in to access.");
            return;
        }

    if (current != null) {
        usernameField.setText(current.getUsername());
        passwordField.setText(current.getPassword());
        emailField.setText(current.getAddress());
    }
        
    }//GEN-LAST:event_UMButtonActionPerformed

    private void savebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savebtnActionPerformed
        UserAccount current = utility.getCurrentUser();
        if (current == null) {
            JOptionPane.showMessageDialog(this, "No user is logged in.");
            return;
        }

        String newUsername = usernameField.getText().trim();
        String newPassword = passwordField.getText().trim();
        String newEmail = emailField.getText().trim();

        if (newUsername.isEmpty() || newPassword.isEmpty() || newEmail.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required.");
            return;
        }

        // Optional: Check if the new username already exists
        if (!newUsername.equalsIgnoreCase(current.getUsername()) && utility.doesUserExist(newUsername)) {
            JOptionPane.showMessageDialog(this, "That username is already in use.");
            return;
        }

        current.setUsername(newUsername);
        current.setPassword(newPassword);
        current.setAddress(newEmail);

       

        JOptionPane.showMessageDialog(this, "Account information updated!");        // TODO add your handling code here:
    }//GEN-LAST:event_savebtnActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed
 
   

    
 
    
 
   
    
    ///////////////////////////START USER RESERVATION CREATION////////////////////////////////////////////////////
    private void buildReservationPanel() {
        ReservationTab.removeAll();
        Venue selectedVenue = utility.getSelectedVenue();
        JLabel costLabel = new JLabel("Total: $0.00");
        costLabel.setForeground(new Color(255, 255, 255, 255));

        LocalDate[] selectedDate = {LocalDate.now()};
        ArrayList<Reservation> reservations = new ArrayList<>();

        JPanel header = new JPanel(new FlowLayout());
        JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
        dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));
        JButton loadDateButton = new JButton("Load Date");
        loadDateButton.setForeground(new Color(255, 255, 255, 255));
        loadDateButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        loadDateButton.setContentAreaFilled(false);
        loadDateButton.setFont(new Font("Verdana", Font.BOLD, 12));

        JLabel dateLabel = new JLabel();
        dateLabel.setText("Select Date:");
        dateLabel.setForeground(new Color(255,255,255,255));        
        header.add(dateLabel);

        header.add(dateSpinner);
        header.add(loadDateButton);
        header.add(costLabel);
        header.setBackground(new Color(48,63,38,255));
        ReservationTab.add(header, BorderLayout.NORTH);

        JPanel venuePanel = new JPanel();
        venuePanel.setLayout(new BoxLayout(venuePanel, BoxLayout.X_AXIS));

        Map<JButton, Float> buttonToPrice = new HashMap<>();
        Map<JButton, String> buttonToLocationKey = new HashMap<>();
        List<JButton> selectedButtons = new ArrayList<>();
        final int[] selectedRow = {-1};

        loadDateButton.addActionListener(e -> {
            selectedDate[0] = ((Date) dateSpinner.getValue()).toInstant()
                .atZone(ZoneId.systemDefault()).toLocalDate();
            reservations.clear();
            reservations.addAll(utility.searchReservations(selectedDate[0]));
            buildVenueLayoutForReservation(venuePanel, selectedVenue, reservations, selectedDate[0], buttonToPrice, selectedButtons, selectedRow, costLabel, buttonToLocationKey);
            ReservationTab.revalidate();
            ReservationTab.repaint();
        });
        loadDateButton.doClick();

        buildVenueLayoutForReservation(venuePanel, selectedVenue, reservations, selectedDate[0], buttonToPrice, selectedButtons, selectedRow, costLabel, buttonToLocationKey);
        JPanel venueWrapper = new JPanel(new BorderLayout());
        venueWrapper.add(venuePanel, BorderLayout.CENTER);

        JScrollPane scrollPane = new JScrollPane(venueWrapper);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        ReservationTab.add(scrollPane, BorderLayout.CENTER);

        JPanel actionPanel = new JPanel(new FlowLayout());
        
        JButton cashButton = new JButton("Pay with Cash");
        cashButton.setForeground(Color.WHITE);
        cashButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        cashButton.setContentAreaFilled(false);
        cashButton.setFont(new Font("Verdana", Font.BOLD, 12));

        JButton creditButton = new JButton("Pay with Credit");
        creditButton.setForeground(Color.WHITE);
        creditButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        creditButton.setContentAreaFilled(false);
        creditButton.setFont(new Font("Verdana", Font.BOLD, 12));

        JButton checkButton = new JButton("Pay with Check");
        checkButton.setForeground(Color.WHITE);
        checkButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        checkButton.setContentAreaFilled(false);
        checkButton.setFont(new Font("Verdana", Font.BOLD, 12));
        
        JButton payLaterButton = new JButton("Pay Later");
        payLaterButton.setForeground(new Color(255, 255, 255, 255));
        payLaterButton.setBorder(new SoftBevelBorder(SoftBevelBorder.RAISED));
        payLaterButton.setContentAreaFilled(false);
        payLaterButton.setFont(new Font("Verdana", Font.BOLD, 12));

        cashButton.addActionListener(e -> handleCashPayment(selectedButtons, selectedVenue, selectedDate[0], buttonToLocationKey, buttonToPrice, selectedRow));
        creditButton.addActionListener(e -> handleCreditPayment(selectedButtons, selectedVenue, selectedDate[0], buttonToLocationKey, selectedRow));
        checkButton.addActionListener(e -> handleReservation("PAID", selectedButtons, selectedVenue, selectedDate[0], buttonToLocationKey, selectedRow));
        payLaterButton.addActionListener(e -> handleReservation("UNPAID", selectedButtons, selectedVenue, selectedDate[0], buttonToLocationKey, selectedRow));

        actionPanel.add(cashButton);
        actionPanel.add(creditButton);
        actionPanel.add(checkButton);
        actionPanel.add(payLaterButton);
        actionPanel.setPreferredSize(new Dimension(500, 85));
        actionPanel.setBackground(new Color(48,63,38,255));
        ReservationTab.add(actionPanel, BorderLayout.SOUTH);

        ReservationTab.revalidate();
        ReservationTab.repaint();
    }
    
    private void buildVenueLayoutForReservation(JPanel venuePanel, Venue venue, List<Reservation> reservations, LocalDate date, Map<JButton, Float> buttonToPrice, List<JButton> selectedButtons, int[] selectedRow, JLabel costLabel, Map<JButton, String> buttonToLocationKey) {
        venuePanel.removeAll();
        Map<JButton, Boolean> buttonIsHandicap = new HashMap<>();

        for (Section section : venue.getSections()) {
            JPanel sectionPanel = new JPanel(new BorderLayout());
            sectionPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            sectionPanel.add(new JLabel(section.getSectionName().replaceAll("_", " ")), BorderLayout.NORTH);

            JPanel seatGrid = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 0;

            int rowIndex = 0;
            for (Row row : section.getRows()) {
                final int currentRowIndex = rowIndex;
                gbc.gridx = rowIndex;
                gbc.gridy = 0;
                for (Ticket ticket : row.getTickets()) {
                    JButton seatButton = new JButton("" + ticket.getSeatNum());
                    seatButton.setPreferredSize(new Dimension(80, 30));
                    seatButton.setOpaque(true);
                    seatButton.setBorderPainted(false);
                    buttonIsHandicap.put(seatButton, ticket.disabledSeat);

                    boolean isReserved = isSeatReserved(reservations, venue, section.getSectionName(), currentRowIndex, ticket.getSeatNum());
                    if (isReserved) {
                        seatButton.setBackground(Color.RED);
                        seatButton.setEnabled(false);
                    } else {
                        seatButton.setBackground(ticket.disabledSeat ? Color.BLUE : Color.GREEN);
                        float price = row.getRowPrice() + section.getSecPrice();
                        seatButton.setToolTipText("Price: $" + price);
                        buttonToPrice.put(seatButton, price);
                        buttonToLocationKey.put(seatButton, section.getSectionName() + "|" + currentRowIndex);

                        seatButton.addActionListener(e -> {
                            if (selectedRow[0] != -1 && selectedRow[0] != currentRowIndex) return;

                            if (seatButton.getBackground().equals(Color.YELLOW)) {
                                selectedButtons.remove(seatButton);
                                if (buttonIsHandicap.getOrDefault(seatButton, false)) {
                                    seatButton.setBackground(Color.BLUE);
                                } else {
                                    seatButton.setBackground(Color.GREEN);
                                }
                                if (selectedButtons.isEmpty()) {
                                    selectedRow[0] = -1;
                                }
                            } else {
                                seatButton.setBackground(Color.YELLOW);
                                selectedButtons.add(seatButton);
                                selectedRow[0] = currentRowIndex;
                            }

                            float total = selectedButtons.stream()
                                    .map(buttonToPrice::get)
                                    .reduce(0f, Float::sum);
                            costLabel.setText("Total: $" + String.format("%.2f", total));
                        });
                    }

                    gbc.gridy++;
                    seatGrid.add(seatButton, gbc);
                }
                rowIndex++;
            }

            sectionPanel.add(seatGrid, BorderLayout.CENTER);
            venuePanel.add(sectionPanel);
        }

        venuePanel.revalidate();
        venuePanel.repaint();
        venuePanel.setPreferredSize(venuePanel.getPreferredSize());
}
    
    private boolean isSeatReserved(List<Reservation> reservations, Venue venue, String sectionName, int rowNum, int seatNum) {
        for (Reservation res : reservations) {
            for (String seatData : res.getSeatData()) {
                String[] parts = seatData.split(" ");
                if (parts.length < 4) continue;
                String resVenue = parts[0];
                String resSection = parts[1];
                int resRow = Integer.parseInt(parts[2]);

                if (!resVenue.equals(venue.getVenueName())) continue;
                if (!resSection.equals(sectionName)) continue;
                if (resRow != rowNum) continue;

                for (int i = 3; i < parts.length; i++) {
                    String[] seatRange = parts[i].split("-");
                    for (String seat : seatRange) {
                        if (Integer.parseInt(seat) == seatNum) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    private void handleReservation(String status, List<JButton> selectedButtons, Venue venue, LocalDate date, Map<JButton, String> buttonToLocationKey, int[] selectedRow) {
        if (selectedButtons.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No seats selected.");
            return;
        }

        JButton referenceButton = selectedButtons.get(0);
        int referenceSeatNum = Integer.parseInt(referenceButton.getText());
        String locationKey = buttonToLocationKey.get(referenceButton);

        if (locationKey == null) {
            JOptionPane.showMessageDialog(null, "Error: Seat location not found.");
            return;
        }

        String[] parts = locationKey.split("\\|");
        String sectionName = parts[0];
        int rowIndex = Integer.parseInt(parts[1]);

        Row targetRow = null;
        Section targetSection = null;

        for (Section section : venue.getSections()) {
            if (section.getSectionName().equals(sectionName)) {
                targetSection = section;
                targetRow = section.getRows().get(rowIndex);
                break;
            }
        }

        if (targetSection == null || targetRow == null) {
            JOptionPane.showMessageDialog(null, "Error: Could not find the selected row or section.");
            return;
        }

        List<Integer> seatNumbers = selectedButtons.stream()
            .map(b -> Integer.parseInt(b.getText()))
            .sorted()
            .collect(Collectors.toList());

        String seatData = venue.getVenueName().replaceAll(" ", "_") + " "
                        + sectionName.replaceAll(" ", "_") + " "
                        + rowIndex + " "
                        + seatNumbers.stream().map(Object::toString).collect(Collectors.joining("-"));

        ArrayList<Ticket> selectedTickets = new ArrayList<>();
        for (Ticket ticket : targetRow.getTickets()) {
            if (seatNumbers.contains(ticket.getSeatNum())) {
                selectedTickets.add(ticket);
            }
        }

        boolean isPaid = status.equals("PAID");
        System.out.println("At Reservation Creation: " + seatData);
        Reservation reservation = new Reservation(seatData, selectedTickets, date, false, isPaid, 0f);
        try {
            utility.getCurrentUser().addReservation(reservation);
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null, "User must be logged in to purchase seats!", "Information", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null, "Reservation made (" + status + ").");

        for (JButton btn : selectedButtons) {
            btn.setBackground(Color.RED);
            btn.setEnabled(false);
        }
        selectedButtons.clear();
        selectedRow[0] = -1;
    }
    
    private void handleCashPayment(List<JButton> selectedButtons, Venue venue, LocalDate date, Map<JButton, String> buttonToLocationKey, Map<JButton, Float> buttonToPrice, int[] selectedRow) {
        float total = selectedButtons.stream()
                .map(b -> buttonToPrice.get(b))
                .reduce(0f, Float::sum);

        String input = JOptionPane.showInputDialog(null, "Total: $" + String.format("%.2f", total) + "\nEnter cash amount given:");
        if (input == null) return;

        try {
            float cashGiven = Float.parseFloat(input);
            if (cashGiven < total) {
                JOptionPane.showMessageDialog(null, "Insufficient funds provided.");
                return;
            }

            float change = cashGiven - total;
            handleReservation("PAID", selectedButtons, venue, date, buttonToLocationKey, selectedRow);
            JOptionPane.showMessageDialog(null, "Cash accepted. Change due: $" + String.format("%.2f", change));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid cash amount entered.");
        }
    }
    
    private void handleCreditPayment(List<JButton> selectedButtons, Venue venue, LocalDate date, Map<JButton, String> buttonToLocationKey, int[] selectedRow) {
        String input = JOptionPane.showInputDialog(null, "Enter 16-digit credit card number:");
        if (input == null) return;

        if (input.matches("\\d{16}")) {
            handleReservation("PAID", selectedButtons, venue, date, buttonToLocationKey, selectedRow);
            JOptionPane.showMessageDialog(null, "Credit card accepted.");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credit card number. Must be 16 digits.");
        }
    }
    
    //////////////////////////////END USER RESERVATION CREATION///////////////////////////////////////////////////
    
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
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new UserDashboard().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea HelpDisplay;
    private javax.swing.JScrollPane HelpDocDisplay;
    private javax.swing.JPanel OuterDashPanel;
    private javax.swing.JPanel ReservationTab;
    private javax.swing.JButton UMButton;
    private javax.swing.JButton closeHelp;
    private javax.swing.JTextField emailField;
    private javax.swing.JButton helpButton;
    private javax.swing.JPanel helpPanel;
    private javax.swing.JPanel innerPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField passwordField;
    private javax.swing.JButton reserveButton;
    private javax.swing.JButton savebtn;
    private javax.swing.JPanel sthTab;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
