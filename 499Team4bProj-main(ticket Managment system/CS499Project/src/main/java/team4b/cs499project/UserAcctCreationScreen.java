package team4b.cs499project;
import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class UserAcctCreationScreen extends javax.swing.JFrame {
    private Utility utility;
    
    public UserAcctCreationScreen(Utility utility) {
        initComponents();
        saveButton.addActionListener(e -> saveClicked());
        clearButton.addActionListener(e -> clearClicked());
        
        this.utility = utility;
 
   
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

        MakeUserMainPanel = new javax.swing.JPanel();
        BackPanel = new javax.swing.JPanel();
        WritablePanel = new javax.swing.JPanel();
        usernameQuery = new javax.swing.JLabel();
        passwordQuery = new javax.swing.JLabel();
        passwordConfirm = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        clearButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        confirmField = new javax.swing.JPasswordField();
        ErrorField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        MakeUserMainPanel.setBounds(0, 0, 1024, 768);
        MakeUserMainPanel.setBackground(new java.awt.Color(33, 53, 38));
        MakeUserMainPanel.setLayout(new java.awt.GridBagLayout());

        BackPanel.setBackground(new java.awt.Color(48, 63, 38));
        BackPanel.setMaximumSize(new java.awt.Dimension(960, 730));
        BackPanel.setMinimumSize(new java.awt.Dimension(960, 730));
        BackPanel.setLayout(new java.awt.GridBagLayout());

        WritablePanel.setBounds(0,0,600,400);
        WritablePanel.setBackground(new java.awt.Color(95, 95, 38));
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

        passwordConfirm.setBackground(new java.awt.Color(153, 153, 0));
        passwordConfirm.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        passwordConfirm.setForeground(new java.awt.Color(255, 255, 255));
        passwordConfirm.setText("Confirm your Password");

        usernameField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        usernameField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usernameField.setSelectedTextColor(new java.awt.Color(0, 0, 0));

        saveButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(255, 255, 255));
        saveButton.setText("Save");
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

        confirmField.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        confirmField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        confirmField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                confirmFieldKeyPressed(evt);
            }
        });

        ErrorField.setEditable(false);
        ErrorField.setBackground(new java.awt.Color(95, 95, 38));
        ErrorField.setFont(new java.awt.Font("Verdana", 2, 14)); // NOI18N
        ErrorField.setForeground(new java.awt.Color(255, 0, 0));
        ErrorField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ErrorField.setToolTipText("");
        ErrorField.setBorder(null);

        javax.swing.GroupLayout WritablePanelLayout = new javax.swing.GroupLayout(WritablePanel);
        WritablePanel.setLayout(WritablePanelLayout);
        WritablePanelLayout.setHorizontalGroup(
            WritablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WritablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(WritablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WritablePanelLayout.createSequentialGroup()
                        .addComponent(passwordConfirm)
                        .addGap(178, 178, 178))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WritablePanelLayout.createSequentialGroup()
                        .addGroup(WritablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passwordQuery, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameQuery, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(usernameField)
                            .addComponent(passwordField)
                            .addComponent(confirmField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, WritablePanelLayout.createSequentialGroup()
                                .addComponent(clearButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(saveButton))
                            .addComponent(ErrorField))
                        .addGap(155, 155, 155))))
        );
        WritablePanelLayout.setVerticalGroup(
            WritablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WritablePanelLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(usernameQuery)
                .addGap(11, 11, 11)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordQuery)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(passwordConfirm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(WritablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(clearButton))
                .addGap(18, 18, 18)
                .addComponent(ErrorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = -140;
        gridBagConstraints.ipady = 29;
        gridBagConstraints.insets = new java.awt.Insets(546, 841, 547, 841);
        BackPanel.add(WritablePanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        MakeUserMainPanel.add(BackPanel, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MakeUserMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MakeUserMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_clearButtonMouseClicked

    private void saveButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveButtonMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonMouseClicked

    private void confirmFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_confirmFieldKeyPressed
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        saveClicked();
    }        // TODO add your handling code here:
    }//GEN-LAST:event_confirmFieldKeyPressed


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
            java.util.logging.Logger.getLogger(UserAcctCreationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserAcctCreationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserAcctCreationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserAcctCreationScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

 
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminAcctCreationScreen().setVisible(true);
//            }
//        });
        //</editor-fold>
        //</editor-fold>

 
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AdminAcctCreationScreen().setVisible(true);
//            }
//        });
    }
    
    private void saveClicked() {
        String username = usernameField.getText();
        if (username.equals("")) {
            ErrorField.setText("Username cannot be empty");
            return;
        }
        
        String password = String.valueOf(passwordField.getPassword());
        if (password.equals("")) {
            ErrorField.setText("Password cannot be empty");
            return;
        }
        if (!password.equals(String.valueOf(confirmField.getPassword()))) {
            ErrorField.setText("Passwords do not match");
            return;
        }
        
        utility.createUser(username, password, "", 0, false);
        //ErrorField.setText("User Created!");
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserLoginScreen(utility).setVisible(true);
                SwingUtilities.getWindowAncestor(ErrorField).dispose();
            }
            });
    }
    
    private void clearClicked() {
        passwordField.setText("");
        usernameField.setText("");
        confirmField.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackPanel;
    private javax.swing.JTextField ErrorField;
    private javax.swing.JPanel MakeUserMainPanel;
    private javax.swing.JPanel WritablePanel;
    private javax.swing.JButton clearButton;
    private javax.swing.JPasswordField confirmField;
    private javax.swing.JLabel passwordConfirm;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordQuery;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameQuery;
    // End of variables declaration//GEN-END:variables
}
