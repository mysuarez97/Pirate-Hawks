// A standalone GUI Java program that serves as a search engine for text files. Users may search for files by selecting a search type and by entering search terms.
// Written by Christopher Stambaugh, 3/19/2019
// Team name: Pirate Hawks
// Team members: Samuel Graham, Christopher Stambaugh, Agnes Benitez, and Myrlene Suarez
// Note: there are currently many stubs where pressing certain buttons will either lead the user back to the main menu or simply exit the program

package com.piratehawks.SearchEngine;

import javax.swing.JOptionPane;

class MyCommit {

    public static void main ( String [] args )
    {
        while (true) {  // intentionally designed to loop forever; that is, of course, until the GUI's 'X' button is pressed
            searchEngine();  // runs the search engine
        }
    }

    /**
     *  A method that acts as a search engine, prompting users to select a search type and to enter search terms, returning any text files which contain said search terms.
     *  @return <code>true</code> no matter what, intentionally allowing this method to run indefinitely.
     */
    static boolean searchEngine() {

        Object[] optionsInitial =  // the options the user must initially choose from at the search engine's main menu
                {"AND Search",
                        "OR Search",
                        "PHRASE Search",
                        "ADMINS ONLY"};

        int searchEngine = JOptionPane.showOptionDialog(  // the search engine's main menu
                null,
                "Select an option.",
                "Search Engine",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                optionsInitial,
                optionsInitial[0]);

        String searchAND = null;  // the AND search type

        if (searchEngine == 0) {  // prompts the user to enter search terms for an AND search, should they select this search type from the main menu
            searchAND = (String) JOptionPane.showInputDialog(
                    null,
                    "Enter search terms here.\nResulting text documents will include all searched terms.",
                    "Search Engine - AND Search",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);
        }

        // stub; placeholder for features which will allow users to search for entered terms or to cancel their search
        /*if ((searchAND != null) && (searchAND.length() > 0)) {} else { return true; } */

        String searchOR = null;  // the OR search type

        if (searchEngine == 1) {  // prompts the user to enter search terms for an OR search, should they select this search type from the main menu
            searchOR = (String) JOptionPane.showInputDialog(
                    null,
                    "Enter search terms here.\nResulting text documents will include at least one searched term.",
                    "Search Engine - OR Search",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);
        }

        // stub; placeholder for features which will allow users to search for entered terms or to cancel their search
        /*if ((searchOR != null) && (searchOR.length() > 0)) {} else { return true; } */

        String searchPHRASE = null;  // the PHRASE search type

        if (searchEngine == 2) {  // prompts the user to enter search terms for a PHRASE search, should they select this search type from the main menu
            searchPHRASE = (String) JOptionPane.showInputDialog(
                    null,
                    "Enter search terms here.\nResulting text documents will include all searched terms in the exact order in which they are typed.",
                    "Search Engine - PHRASE Search",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);
        }

        // stub; placeholder for features which will allow users to search for entered terms or to cancel their search
        /*if ((searchPHRASE != null) && (searchPHRASE.length() > 0)) {} else { return true; } */

        String adminsOnly = null;  // the administrator verification menu; requires the user to enter the correct password to access the administrator tools menu

        if (searchEngine == 3) {  // prompts the user to enter the password to access the administrator tools menu, should they select this option from the main menu
            adminsOnly = (String) JOptionPane.showInputDialog(
                    null,
                    "Admins only! Enter the password.",
                    "Search Engine - Admin Verification",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);
        }

        final String PASSWORD = "piratehawks";  // the password to access the administrator tools menu

        Object[] optionsAdmin =  // the options the user may choose from at the search engine's administrator tools menu
                {"Add File",
                        "Remove File",
                        "Update Index"};

        while (!adminsOnly.equals(PASSWORD)) {  // prompts the user to re-enter the password to access the administrator tools menu, should they enter an incorrect password
            adminsOnly = (String) JOptionPane.showInputDialog(
                    null,
                    "Admins only! Password incorrect.",
                    "Search Engine - Admin Verification",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    null,
                    null);
        }

        int adminTools;  // the administrator tools menu; only accessible by administrators and good password guessers

        if (adminsOnly.equals(PASSWORD)) {  // the search engine's administrator tools menu
            adminTools = JOptionPane.showOptionDialog(
                    null,
                    "Select an option.",
                    "Search Engine - Administrator Tools",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    optionsAdmin,
                    optionsAdmin[0]);
        }

        // stub; placeholder for a feature which will allow administrators to add files to the index
        /* if (adminTools == 0) {} */

        // stub; placeholder for a feature which will allow administrators to remove files from the index
        /* if (adminTools == 1) {} */

        // stub; placeholder for a feature which will allow administrators to update the index
        /* if (adminTools == 2) {} */

        return true;  // returns the user to the main menu

    }
}