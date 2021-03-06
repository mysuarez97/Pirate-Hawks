package com.piratehawks;




        /*

         * To change this license header, choose License Headers in Project Properties.

         * To change this template file, choose Tools | Templates

         * and open the template in the editor.

         */



        import net.proteanit.sql.DbUtils;

        import java.sql.ResultSet;

        import java.sql.*;

        import java.sql.SQLException;

        import java.util.logging.Level;

        import java.util.logging.Logger;

        import java.util.ArrayList;

        import java.io.File;

        import javax.swing.*;

        import javax.swing.JFileChooser;

        import java.time.LocalDate;



/**

 *

 * @author Agnes B

 */



public class Maintenance extends javax.swing.JFrame {



    Connection connection = null;

    Statement stmt = null;

    public static int fileCount;





    /**

     * Creates new form Maintenance //* //@throws java.sql.SQLException

     */

    public Maintenance() {

//  Connection connection = null;

        /**

         * Creates new form Maintenance

         //* //@throws java.sql.SQLException*/

        initComponents();

        newquery();

        NumberIndex.setText(Integer.toString(FilenameTable.getRowCount()));





    }



    /**

     * This method is called from within the constructor to initialize the form.

     * WARNING: Do NOT modify this code. The content of this method is always

     * regenerated by the Form Editor.

     */

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents

    private void initComponents() {



        lblTitleBar = new java.awt.Label();

        jScrollPane1 = new javax.swing.JScrollPane();



        FilenameTable = new javax.swing.JTable();

        AddButton = new java.awt.Button();

        RebuildButton = new java.awt.Button();

        RemoveButton = new java.awt.Button();

        lblTitleNumOfFiles = new java.awt.Label();

        NumberIndex = new java.awt.TextField();

        lblTitleVersionNum = new java.awt.Label();

        jTextDir = new javax.swing.JTextField(null, null, 4);

        lblPathname = new javax.swing.JLabel();





        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setTitle("Search Engine Index Maintenance");



        lblTitleBar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        lblTitleBar.setText("Search Engine - Index Maintenance");



        FilenameTable.setModel(new javax.swing.table.DefaultTableModel(

                new ArrayList [][][][]{

                        {null, null, null, null},

                        {null, null, null, null},

                        {null, null, null, null},

                        {null, null, null, null},

                        {null, null, null, null},

                        {null, null, null, null},

                        {null, null, null, null},

                        {null, null, null, null},

                        {null, null, null, null}

                },

                new String [] {

                        "PathName", "Status", "Date Added", "Last Modified"

                }

        ));



        FilenameTable.setColumnSelectionAllowed(true);



        //List columns = new ArrayList(FilenameTable.getColumnCount());

        //FilenameTable.setColumnCount(4);

        FilenameTable.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                FilenameTableMouseClicked(evt);

            }

        });

        jScrollPane1.setViewportView(FilenameTable);

        FilenameTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);



        AddButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        AddButton.setLabel("Add File");

        AddButton.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override

            public void mouseClicked(java.awt.event.MouseEvent evt) {

                AddButtonMouseClicked(evt);

            }

        });



        AddButton.addActionListener(new java.awt.event.ActionListener() {

            @Override

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                try {

                    AddButtonActionPerformed(evt);

                } catch (SQLException ex) {

                    Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);

                }

            }

        });



        RebuildButton.setLabel("Rebuild Out-of-Date");

        RebuildButton.addActionListener(new java.awt.event.ActionListener() {

            @Override

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                RebuildButtonActionPerformed(evt);

            }

        });



        RemoveButton.setLabel("Remove Selected Files");

        RemoveButton.addActionListener(new java.awt.event.ActionListener() {

            @Override

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                RemoveButtonActionPerformed(evt);

            }

        });



        lblTitleNumOfFiles.setText("Number of files indexed:");

        NumberIndex.setText(Integer.toString(fileCount));

        lblTitleVersionNum.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N

        lblTitleVersionNum.setText("Search Engine Version 1.0");



        jTextDir.addActionListener(new java.awt.event.ActionListener() {

            @Override

            public void actionPerformed(java.awt.event.ActionEvent evt) {

                jTextDirActionPerformed(evt);

            }

        });



        lblPathname.setText("Pathname:");



        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());

        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(

                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(layout.createSequentialGroup()

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                                        .addGroup(layout.createSequentialGroup()

                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                                                        .addGroup(layout.createSequentialGroup()

                                                                .addGap(210, 210, 210)

                                                                .addComponent(lblTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                        .addGroup(layout.createSequentialGroup()

                                                                .addGap(72, 72, 72)

                                                                .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                .addGap(68, 68, 68)

                                                                .addComponent(RebuildButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                .addGap(60, 60, 60)

                                                                .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                                                        .addGroup(layout.createSequentialGroup()

                                                                .addGap(210, 210, 210)

                                                                .addComponent(lblTitleNumOfFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                .addGap(8, 8, 8)

                                                                .addComponent(NumberIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                .addGap(80, 80, 80)

                                                                .addComponent(lblTitleVersionNum, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))

                                                .addGap(0, 92, Short.MAX_VALUE))

                                        .addComponent(jScrollPane1))

                                .addContainerGap())

                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()

                                .addContainerGap()

                                .addComponent(lblPathname, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

                                .addComponent(jTextDir, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))

        );

        layout.setVerticalGroup(

                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                        .addGroup(layout.createSequentialGroup()

                                .addGap(10, 10, 10)

                                .addComponent(lblTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addGap(7, 7, 7)

                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)

                                .addGap(54, 54, 54)

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                                        .addComponent(jTextDir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                        .addComponent(lblPathname))

                                .addGap(21, 21, 21)

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                                        .addComponent(AddButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                        .addComponent(RebuildButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                        .addComponent(RemoveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))

                                .addGap(16, 16, 16)

                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                                        .addComponent(lblTitleNumOfFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                        .addComponent(NumberIndex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)

                                        .addGroup(layout.createSequentialGroup()

                                                .addGap(10, 10, 10)

                                                .addComponent(lblTitleVersionNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))

        );

        NumberIndex.setText(Integer.toString(FilenameTable.getRowCount()));



        pack();

    }// </editor-fold>//GEN-END:initComponents



    public void AddButtonActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_AddButtonActionPerformed

        // TODO add your handling code here:



        LocalDate today = LocalDate.now();

        String date = String.valueOf(today);

        String indexStatus = "Indexed";

        int rowCount = FilenameTable.getRowCount();



        JFileChooser chooser = new JFileChooser();

        chooser.showOpenDialog(null);

        File f = chooser.getSelectedFile();

        String filePath = f.getAbsolutePath();

        String fileName = f.getName();

        jTextDir.setText(filePath);



        try {



            String query = "Insert into IndexedFiles (ID,FILE_NAME,FILE_PATH,DATE_MODIFIED,STATUS) values (?,?,?,?,?)" ;



            try (PreparedStatement pst = connection.prepareStatement(query)) {

                pst.setInt(1, (rowCount + 1));

                pst.setString(2, fileName);

                pst.setString(3, filePath);

                pst.setString(4, date);

                pst.setString(5, indexStatus);



                NumberIndex.setText(Integer.toString(FilenameTable.getRowCount()));



                pst.execute();

                JOptionPane.showMessageDialog(null,"Directory Added!");

                pst.close();



                newquery();

            }

        }catch (SQLException e)

        {



        }



        /**/

    }//GEN-LAST:event_AddButtonActionPerformed



    private void AddButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddButtonMouseClicked

        // TODO add your handling code here:

    }//GEN-LAST:event_AddButtonMouseClicked



    private void jTextDirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDirActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_jTextDirActionPerformed



    private void RemoveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveButtonActionPerformed

        // TODO add your handling code here:

        String query = "delete from IndexedFiles where FILE_NAME=?";

        try (PreparedStatement pst = connection.prepareStatement(query)) {



            pst.setString(1, jTextDir.getText());



            pst.execute();

            JOptionPane.showMessageDialog(null,"Filename Deleted!");

            newquery();

            fileCount--;

            NumberIndex.setText(Integer.toString(FilenameTable.getRowCount()));

            pst.close();





        }catch (SQLException e)

        {

        }









    }//GEN-LAST:event_RemoveButtonActionPerformed



    private void FilenameTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FilenameTableMouseClicked

        // TODO add your handling code here:

        try{

            int row=FilenameTable.getSelectedRow();

            String Table_Click=(FilenameTable.getModel().getValueAt(row, 0)).toString();

            String query="select * from IndexedFiles where Pathname='"+Table_Click+"' ";

            PreparedStatement pst=connection.prepareStatement(query);

            ResultSet rs=pst.executeQuery();

            while (rs.next())

            {

                String dir1;

                dir1 = rs.getString("Pathname");

                jTextDir.setText(dir1);

            }

            // pst.close(); //<editor-fold defaultstate="collapsed" desc="comment">



        }catch (SQLException e)

//</editor-fold>

        {

        }



    }//GEN-LAST:event_FilenameTableMouseClicked



    private void RebuildButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RebuildButtonActionPerformed

        // TODO add your handling code here:

        newquery();

        JOptionPane.showMessageDialog(null,"Rebuild Index!");

    }//GEN-LAST:event_RebuildButtonActionPerformed



    /**

     * @param args the command line arguments

     */

    @SuppressWarnings("Convert2Lambda")

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

        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(Maintenance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>



        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override

            public void run() {

                new Maintenance().setVisible(true);

            }

        });

    }



    // Variables declaration - do not modify//GEN-BEGIN:variables

    private java.awt.Button AddButton;

    private javax.swing.JTable FilenameTable;

    private java.awt.TextField NumberIndex;

    private java.awt.Button RebuildButton;

    private java.awt.Button RemoveButton;

    private javax.swing.JLabel lblPathname;

    private javax.swing.JScrollPane jScrollPane1;

    public javax.swing.JTextField jTextDir;

    private java.awt.Label lblTitleBar;

    private java.awt.Label lblTitleNumOfFiles;

    private java.awt.Label lblTitleVersionNum;

    // End of variables declaration//GEN-END:variables



    private void newquery() {

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {

            connection=sqliteConnection2.dbConnector();

            String query;

            query = "select ID,FILE_NAME,FILE_PATH,DATE_MODIFIED,STATUS from IndexedFiles";

            PreparedStatement pst = null;



            try {

                pst = connection.prepareStatement(query);

            } catch (SQLException ex) {

                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);

            }

            ResultSet rs = null;

            try {

                rs = pst.executeQuery();

            } catch (SQLException ex) {

                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);

            }

            FilenameTable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (ClassNotFoundException ex) {

            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

}