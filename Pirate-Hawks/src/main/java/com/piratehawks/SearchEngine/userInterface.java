
package com.piratehawks.SearchEngine;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

/*
 * Search Engine project assignment # 3
 * User interface
 * by Myrlene Suarez
 *    Sam
 *    Jeff
 *    Agnes Benitez
 *        Updated 2/17/2019 - Merge userInterface file in a Java Project
 *                            Removed unused java import
 *                            Added a class Action ActionListener                               
 * 
 */
public class userInterface extends JFrame {

    public static void userWindow() {
        //sets up the jframe window
        JFrame userScreen = new JFrame("Search Engine");
        //title of the window, index, and subtitle
        JLabel title, subtitle, index;
        title = new JLabel("Search Engine");
        title.setBounds(100, 10, 300, 50);
        title.setFont(new Font("Arial", Font.BOLD, 36));

        //textfield for the search bar
        // Move textField so the cursor points to it.
        JTextField textField = new JTextField(20);
        textField.setBounds(150, 70, 190, 25);
        userScreen.add(textField);
        textField.setVisible(true);

        subtitle = new JLabel("Search Terms:");
        subtitle.setBounds(50, 70, 100, 25);
        index = new JLabel("Number of indexes:");
        index.setBounds(200, 500, 120, 24);
        userScreen.add(title);
        userScreen.add(subtitle);
        userScreen.add(index);
        userScreen.setSize(500, 600);
        userScreen.setLayout(null);
        userScreen.setVisible(true);

        //search button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(350, 70, 120, 25);
        userScreen.add(searchButton);
        searchButton.setVisible(true);
        searchButton.addActionListener((ActionListener) new search());

        //maintenance button
        JButton maintenanceButton = new JButton("Maintenance");
        maintenanceButton.setBounds(10, 500, 120, 25);
        userScreen.add(maintenanceButton);
        maintenanceButton.setVisible(true);
        //opens Maintenance JFrame when clicked
        maintenanceButton.addActionListener((ActionListener) new maintWindow());
        
        

        //about button
        JButton infoButton = new JButton("About");
        infoButton.setBounds(380, 500, 100, 25);
        userScreen.add(infoButton);
        infoButton.setVisible(true);
        infoButton.addActionListener((ActionListener) new Action());

        //drop list for the AND, OR, and EXACT phrases
        JLabel label = new JLabel("Pick a Search term and click Search:");
        label.setBounds(0, 100, 250, 25);
        label.setVisible(true);
        userScreen.add(label);

        String[] searchTerms = {" ", "All of the Search Terms", "Any of the Search Terms", "Exact Phrase"};

        JComboBox<String> dropList = new JComboBox<>(searchTerms);

        dropList.setBounds(215, 100, 250, 30);
        dropList.setVisible(true);
        userScreen.add(dropList);

        //text area
        JTextArea textArea = new JTextArea(5, 20);
        userScreen.add(textArea);
        textArea.setBounds(10, 150, 450, 300);
        textArea.setEditable(false);
        textArea.setVisible(true);
    }

    public static void main(String[] args) {
        //outputs the user window
        userWindow();
    }

    static class Action implements ActionListener {

        //private Action() {
        //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //}
        @Override
        public void actionPerformed(ActionEvent arg0) {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            JFrame aboutFrame = new JFrame("About");
            aboutFrame.setVisible(true);
            aboutFrame.setBounds(100, 10, 400, 200);
            JLabel lblTitleAboutFrame = new JLabel("Search Engine 1.1 Project #3. Written by Pirate-Hawks Team");
            JPanel panel = new JPanel();
            aboutFrame.add(panel);
            panel.add(lblTitleAboutFrame);
        }

    }
    
    static class maintWindow implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){ 
            //opens the maintenance window
            new Maintenance().setVisible(true);            
        }
    }
    
        static class search implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent a){ 
            //opens a window with search results
            JFrame searchWindow = new JFrame("Search Results");
            searchWindow.setVisible(true);
            ArrayList searchResult = new ArrayList();
            //for result in searchResult {
                
        }
            
   }
}


