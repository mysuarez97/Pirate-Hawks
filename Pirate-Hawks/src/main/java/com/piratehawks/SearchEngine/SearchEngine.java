/*
 * Some license info may be nice
 */
package com.piratehawks.SearchEngine;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import org.sqlite.SQLiteConfig;
import org.sqlite.util.*;

/**
 * Searches a folder at a designated path for files containing specified
 * word(s).
 */
public class SearchEngine {

    public static String directoryToSearch = "C:\\Test\\FilenameDB.sqlite"; //the path to the directory
   // public static String wordToFind = "Testing"; //the word(s) to find. input a variable later
   // public static File searchFolder = new File(directoryToSearch);
   // public static String searchFilePath = "";

    Connection connection = null;
    
    public static void main(String[] args) throws SQLException {
        //fileSearchMethod(directoryToSearch);
       
       JOptionPane.showMessageDialog(null, "This is a test");
        
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

    private void newquery() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try {
           // initComponents();
            connection=sqliteConnection2.dbConnector();
                String query;
                query = "select PathName, Status from SearchEngine";
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
               //FilenameTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Maintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

    

    /*
    public static void fileSearchMethod(String directoryToSearch) {

        File[] listOfFiles = searchFolder.listFiles(); // array list of all files in directory
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
