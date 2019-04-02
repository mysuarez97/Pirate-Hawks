package com.piratehawks.SearchEngine;

import java.awt.Cursor;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import org.sqlite.SQLiteConfig;
import org.sqlite.util.*;

/**
 * Searches a folder at a designated path for files containing specified
 * word(s).
 */
public class SearchEngine {

    //public static String directoryToSearch = "C:\\Test\\IndexedFiles.db"; //the path to the directory
    //static String userSearch = userInterface.textField.getText(); //the word(s) to find. input a variable later
    public static List<String> listOfFiles = new ArrayList<>(); // array list of all files in directory
    
    //File searchFolder = new File(directoryToSearch);
   // public static String searchFilePath = "";
    static String SearchTerm;  //AND/OR CONDITION
    static String varText;
    static String varTerm;
    static Connection connection;
    static Statement stmt;
    static JTable FilenameTable = new javax.swing.JTable();
    
    /*
    public static void main(String[] args) throws SQLException {

       JOptionPane.showMessageDialog(null, "This is a test" + userSearch);
       userQuery();
       JOptionPane.showMessageDialog(null, listOfFiles);      
    }*/

    /**
     *
     * @param directoryToSearch
     * @throws SQLException
     */
    
    /*
    private void connectToDB(String directoryToSearch)  {
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enforceForeignKeys(true);
            connection = DriverManager.getConnection("jdbc:sqlite:" + directoryToSearch);
            JOptionPane.showMessageDialog(null,"Successful Connection to Database");
        }
         catch (SQLException ex) {
        
        }   
        catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/
    
    @SuppressWarnings("null")
        static void userQuery() throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            FilenameTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Matching Files"
            }
        ));
            
        if ("".equals(userInterface.textField.getText())){
        JOptionPane.showMessageDialog(null,"No Matching Files!");
        return;
        }
       
        if ("AND".equals(varTerm)){
               
            varText = userInterface.textField.getText();   
            String pattern;
            //pattern = "(.*)(,*)";
            pattern = "(.,)";
            // Create a Pattern object
            Pattern r = Pattern.compile(pattern);

             // Now create matcher object.
            Matcher m = r.matcher(varText);
                
        try {
           // initComponents();
            connection=sqliteConnection2.dbConnector();
                String query;
                query = "select FILE_PATH, Status from IndexedFiles ORDER BY FILE_PATH";
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
                if (m.find( )) {
                    
                userQuery(); 
               
                }
                else {
                    varText = "";
                    JOptionPane.showMessageDialog(null,"No Match!");
                }

               //form table name=FilenameTable
          FilenameTable.setModel(DbUtils.resultSetToTableModel(rs));
          
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
/*
    static void newquery() throws SQLException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
           // initComponents();
            sqliteConnection2.dbConnector();
                String query;
                int fileIndex = 1;
                String getNextFile = "SELECT * FROM IndexedFiles";
                int fileCount = 3;
                /*
                ResultSet res = stmt.executeQuery("SELECT COUNT(*) FROM "+ "C:\\Test\\IndexedFiles.db");
                while (res.next()){
                    fileCount = res.getInt(1);
                }
                
                //PreparedStatement pst = null;
                //ResultSet rs = null;
                PreparedStatement pst = sqliteConnection2.dbConnector().prepareStatement(getNextFile);
                ResultSet rs = stmt.executeQuery(getNextFile);
                
                while (rs.next())
                    {

                        String path = rs.getString(3);
                        listOfFiles.add(path);
                        fileIndex++;
                    }
                
                query = "SELECT FILE_PATH FROM IndexedFiles";
                //Cursor cursor = sqliteDatabse.rawquery(query, null);
               // PreparedStatement pst = null;
            
                
            try {
                pst = sqliteConnection2.dbConnector().prepareStatement(query);
            } catch (SQLException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
                //ResultSet rs = null;
                
            try {
                rs = pst.executeQuery();
                //listOfFiles = rs.getString("FILE_PATH");
            } catch (SQLException ex) {
                Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
            }
               //FilenameTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

*/
    

}

    

    
    public static void fileSearchMethod(String directoryToSearch) throws SQLException {

        
        try {
            sqliteConnection2.dbConnector();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
