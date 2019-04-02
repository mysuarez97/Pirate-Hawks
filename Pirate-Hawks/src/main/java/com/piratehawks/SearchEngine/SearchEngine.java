/*
 * Some license info may be nice
 */
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

    public static String directoryToSearch = "C:\\Test\\IndexedFiles.db"; //the path to the directory
    static String userSearch = userInterface.textField.getText(); //the word(s) to find. input a variable later
    public static List<String> listOfFiles = new ArrayList<>(); // array list of all files in directory
    
    //File searchFolder = new File(directoryToSearch);
   // public static String searchFilePath = "";

    //static Connection connection;
    static Statement stmt;
    static JTable FilenameTable = new javax.swing.JTable();
    
    public static void main(String[] args) throws SQLException {

       JOptionPane.showMessageDialog(null, "This is a test" + userSearch);
       newquery();
       JOptionPane.showMessageDialog(null, listOfFiles);      
    }

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
                */
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


    

    

    

    
    public static void fileSearchMethod(String directoryToSearch) throws SQLException {

        
        try {
            sqliteConnection2.dbConnector();
        } 
        catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
/*
        for (File file : listOfFiles) {
            searchFilePath = file.getAbsolutePath(); //get the path of the next file
            if (file.isFile()) {

                try {
                    FileInputStream fstream = new FileInputStream(searchFilePath); // makes sure it's a good path
                    DataInputStream in = new DataInputStream(fstream); // open the file.
                    BufferedReader br = new BufferedReader(new InputStreamReader(in)); //buffered reader for the file               
                    String strLine;

                    while ((strLine = br.readLine()) != null) { //read each line until end of of file
                        if (strLine.contains(wordToFind)) { //look for designated word.
                            System.out.println(file.getName()); //print the file name
                        }
                    }
                    in.close(); //close the file loop back to folder and search next file
                } catch (Exception e) { //try catch required for FileInputStream           
                    System.err.println("Error: File not found");
                }
            } else if (file.isDirectory()) {
                searchSubFolder(searchFilePath);
            }
        }
    }*/
/*
    public static void searchSubFolder(String searchSubFolder) {

        directoryToSearch = searchSubFolder; // public static variable declared before main
        searchFolder = new File(searchSubFolder); //another public variable but given the argument from method call
        File[] SubFolderFiles = searchFolder.listFiles(); // array of all files in the sub folder.

        for (File subfile : SubFolderFiles) {
            // for each file (subfile in SubFolderFiles array
            String searchSubFolderPath = subfile.getAbsolutePath(); //get the path of the next file                        
            if (subfile.isFile()) {
                // if it is a file do this.
                try {
                    FileInputStream fstream = new FileInputStream(searchSubFolderPath); // makes sure it's a good path
                    DataInputStream in = new DataInputStream(fstream); // open the file.
                    BufferedReader br = new BufferedReader(new InputStreamReader(in)); //buffered reader for the file               
                    String strLine;

                    while ((strLine = br.readLine()) != null) { //read each line until end of of file
                        if (strLine.contains(wordToFind)) { //look for designated word.
                            System.out.println(subfile.getName()); //print the file name
                        }
                    }
                    in.close(); //close the file loop back to folder and search next file            
                } catch (Exception e) { //try catch required for FileInputStream        
                    System.err.println("Error: File not found");
                }
            } else if (subfile.isDirectory()) {
                //recursive call of this method to search all sub folders.
                searchSubFolder(searchSubFolderPath);
            }
        }
    }
}
*/
