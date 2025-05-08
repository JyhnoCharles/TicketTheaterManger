package team4b.cs499project;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class AdminLoginScreen extends javax.swing.JFrame {
    private Utility utility;

    public AdminLoginScreen(Utility utility) {
        initComponents();
        saveButton.addActionListener(e -> loginClicked());
        clearButton.addActionListener(e -> clearClicked());
        
        this.utility = utility;

        utility.importVenues();
        utility.importUsers();

        
        
        //Screen Resolution mechanics, NO TOUCHY! - Trey
        //this.setLocationRelativeTo(null); //ensure center screen pop up
        this.setResizable(false); //stops user from resizing window
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); //always ensure pixel width is maxed
        //this.setSize(java.awt.Toolkit.getDefaultToolkit().getScreenSize()); //ensure pixel width matches that of native screen
        this.setSize(1920, 1080);

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        AdminLoginMainPanel = new javax.swing.JPanel();
        BackPanel = new javax.swing.JPanel();
        WritablePanel = new javax.swing.JPanel();
        usernameQuery = new javax.swing.JLabel();
        passwordQuery = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        ErrorField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        AdminLoginMainPanel.setBounds(0, 0, 1024, 768);
        AdminLoginMainPanel.setBackground(new java.awt.Color(32, 54, 64));
        AdminLoginMainPanel.setMaximumSize(new java.awt.Dimension(1920, 1080));
        AdminLoginMainPanel.setMinimumSize(new java.awt.Dimension(1920, 1080));
        AdminLoginMainPanel.setPreferredSize(new java.awt.Dimension(1920, 1080));
        AdminLoginMainPanel.setLayout(new java.awt.GridBagLayout());

        BackPanel.setBackground(new java.awt.Color(49, 98, 95));
        BackPanel.setMaximumSize(new java.awt.Dimension(960, 730));
        BackPanel.setLayout(new java.awt.GridBagLayout());

        WritablePanel.setBounds(0,0,600,400);
        WritablePanel.setBackground(new java.awt.Color(58, 115, 75));
        WritablePanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        WritablePanel.setMaximumSize(new java.awt.Dimension(382, 338));
        WritablePanel.setMinimumSize(new java.awt.Dimension(382, 338));
        WritablePanel.setPreferredSize(new java.awt.Dimension(382, 338));

        usernameQuery.setBackground(new java.awt.Color(153, 153, 0));
        usernameQuery.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        usernameQuery.setForeground(new java.awt.Color(255, 255, 255));
        usernameQuery.setText("Please input your Username");

        passwordQuery.setBackground(new java.awt.Color(153, 153, 0));
        passwordQuery.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        passwordQuery.setForeground(new java.awt.Color(255, 255, 255));
        passwordQuery.setText("Please input your Password");

        usernameField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        usernameField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usernameField.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        saveButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Login");
        saveButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        saveButton.setContentAreaFilled(false);
        saveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveButtonMouseClicked(evt);
            }
        });

        clearButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        clearButton.setForeground(new java.awt.Color(255, 255, 255));
        clearButton.setText("Clear");
        clearButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        clearButton.setContentAreaFilled(false);
        clearButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearButtonMouseClicked(evt);
            }
        });

        passwordField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        passwordField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        ErrorField.setEditable(false);
        ErrorField.setBackground(new java.awt.Color(58, 115, 75));
        ErrorField.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        ErrorField.setForeground(new java.awt.Color(255, 0, 0));
        ErrorField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ErrorField.setToolTipText("");
        ErrorField.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admin");

        javax.swing.GroupLayout WritablePanelLayout = new javax.swing.GroupLayout(WritablePanel);
        WritablePanel.setLayout(WritablePanelLayout);
        WritablePanelLayout.setHorizontalGroup(
            WritablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WritablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(WritablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(passwordQuery, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameQuery, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameField)
                    .addComponent(passwordField)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, WritablePanelLayout.createSequentialGroup()
                        .addComponent(clearButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveButton))
                    .addComponent(ErrorField))
                .addGap(155, 155, 155))
            .addGroup(WritablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WritablePanelLayout.setVerticalGroup(
            WritablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WritablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addComponent(usernameQuery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(passwordQuery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(WritablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(clearButton))
                .addGap(18, 18, 18)
                .addComponent(ErrorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -140;
        gridBagConstraints.ipady = 9;
        gridBagConstraints.insets = new java.awt.Insets(191, 361, 192, 362);
        BackPanel.add(WritablePanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        AdminLoginMainPanel.add(BackPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminLoginMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AdminLoginMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1160, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonMouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonMouseClicked

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        loginClicked();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldKeyPressed


    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AdminLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
    }
    
    private void loginClicked() {
        String username = usernameField.getText();
        System.out.println(username);

        if (utility.hasUserlist()) { // Check if a list of users exists
            if (utility.doesUserExist(username)) { // Username Check
                
                UserAccount userAccount = utility.findUser(username);
                String password = String.valueOf(passwordField.getPassword());
                
                if (userAccount.validatePassword(password) == 1) { // Password Check
                    
                    if (utility.checkPermissions(userAccount)) { // Permission Check
                        //ErrorField.setText("Admin login Success");
                        utility.userLogin(userAccount);
                        java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new AdminDashboard(utility).setVisible(true);
                            SwingUtilities.getWindowAncestor(ErrorField).dispose();
                        }
                        });
                    } // End Permission Check Success
                    else {
                        ErrorField.setText("Must be Admin to login.");
                    } // End Permission Check
                    
                } // End Password Check Success
                else {
                    ErrorField.setText("Incorrect Username/Password");
                } // End Password Check
                
            } // End Username Check Success
            else {
                ErrorField.setText("Incorrect Username/Password");
            } // End Username Check
                     
        } // End User list check success
        else {
            System.out.println("User List does not exist");
            if (username.equals("Admin")) {
                String password = String.valueOf(passwordField.getPassword());
                if (password.equals("Admin")) {
                    //ErrorField.setText("Default Admin Login");
                    java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new AdminAcctCreationScreen(utility).setVisible(true);
                        SwingUtilities.getWindowAncestor(ErrorField).dispose();
                    }
                    });
                }
                else {
                    ErrorField.setText("Incorrect Username/Password");
                }
            }
            else {
                ErrorField.setText("Incorrect Username/Password");
            }
        }
    }
    
    private void clearClicked() {
        passwordField.setText("");
        usernameField.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdminLoginMainPanel;
    private javax.swing.JPanel BackPanel;
    private javax.swing.JTextField ErrorField;
    private javax.swing.JPanel WritablePanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordQuery;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameQuery;
    // End of variables declaration//GEN-END:variables
}
