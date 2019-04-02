// A standalone GUI Java program that serves as a search engine for text files. Users may search for files by selecting a search type and by entering search terms.
// Written by Christopher Stambaugh, 3/19/2019
// Last updated 4/2/2019
// Team name: Pirate Hawks
// Team members: Samuel Graham, Christopher Stambaugh, Agnes Benitez, and Myrlene Suarez
// Note: I was only able to get the 'OR' search working; the 'AND' and 'PHRASE' searches are placeholders for now

package com.piratehawks.SearchEngine;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

class MyCommit {

    public static void main ( String [] args )
    {
        while (true) {  // loops essentially forever
           searchEngine();  // runs the search engine
        }
    }

    /**
     *  A method that acts as a search engine, prompting users to select a search type and to enter search terms, returning any text files which contain said search terms.
     *  @return <code>true</code> no matter what, intentionally allowing this method to run indefinitely.
     */
    static boolean searchEngine() {

        List<String> index = new ArrayList<>();  // the list of text documents in the index
        index.add("File0.txt");  // placeholder text document
        index.add("File1.txt");  // placeholder text document
        index.add("File2.txt");  // placeholder text document
        String[] indexes = index.toArray(new String[0]);  // converts the list to an array of strings
        int indexSize = index.size();  // the number of text documents in the index
        boolean[] indexMatchesTerm = new boolean[indexSize];  // compares the words in the text document to the user's searched terms
        String indexesMatchingTerms = "";  // the filenames of the text documents which contain at least one match to the user's searched terms
        int i;  // counter variable

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

            if ((searchAND != null) && (searchAND.length() > 0)) {  // an 'OR' search as a placeholder; see searchOR
                String[] searchANDterms = searchAND.split("\\s+");

                String[] indexWords = new String[10000];
                int j = 0;
                for (String indexName : indexes) {
                    try {
                        Scanner scanner = new Scanner(new File(indexName));
                        while (scanner.hasNext()) {
                            String indexLines = scanner.nextLine();
                            indexWords = indexLines.split("\\s+");
                        }
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,
                                "Error: Index is empty.",
                                "Search Engine - Error",
                                JOptionPane.PLAIN_MESSAGE);
                        return true;
                    }

                    for (String terms : searchANDterms) {

                        for (i = 0; indexWords.length > i && indexWords[i] != null; i++) {
                            if (indexWords[i] == null) break;
                            if (indexWords[i].equals(terms)) {
                                indexMatchesTerm[j] = true;
                                if (indexMatchesTerm[j]) {
                                    break;
                                }
                            }
                        }
                    }

                    j++;
                }

                for (i = 0; i < indexSize; i++) {
                    if (indexMatchesTerm[i]) {
                        indexesMatchingTerms += indexes[i] + " ";
                    }
                }

                JOptionPane.showMessageDialog(null,
                        "Matching files: " + indexesMatchingTerms,
                        "Search Engine - AND Search",
                        JOptionPane.PLAIN_MESSAGE);
                if (true) {
                    return true;
                }

            } else {
                return false;
            }

        }

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

            if ((searchOR != null) && (searchOR.length() > 0)) {  // checks the searched terms for validity
                String[] searchORterms = searchOR.split("\\s+");  // splits the sentence of terms into individual words

                String[] indexWords = new String[10000];  // the words in the text document
                int j = 0;  // counter variable
                for (String indexName : indexes) {  // scans each text document
                    try {
                        Scanner scanner = new Scanner(new File(indexName));
                        while (scanner.hasNext()) {
                            String indexLines = scanner.nextLine();
                            indexWords = indexLines.split("\\s+");  // splits the sentences in the text document into words
                        }
                    } catch (FileNotFoundException ex) {  // throws an exception, should the index be empty or a file be missing
                        JOptionPane.showMessageDialog(null,
                                "Error: File not found.",
                                "Search Engine - Error",
                                JOptionPane.PLAIN_MESSAGE);
                        return true;
                    }

                    for (String terms : searchORterms) {  // matches the searched terms to the contents of the text documents

                        for (i = 0; indexWords.length > i && indexWords[i] != null; i++) {
                            if (indexWords[i] == null) break;
                            if (indexWords[i].equals(terms)) {
                                indexMatchesTerm[j] = true;
                                if (indexMatchesTerm[j]) {
                                    break;
                                }
                            }
                        }
                    }

                    j++;
                }

                for (i = 0; i < indexSize; i++) {  // lists the text documents which contain at least one match
                    if (indexMatchesTerm[i]) {
                        indexesMatchingTerms += indexes[i] + " ";
                    }
                }

                JOptionPane.showMessageDialog(null,  // displays the list of term-matching text documents to the user
                        "Matching files: " + indexesMatchingTerms,
                        "Search Engine - OR Search",
                        JOptionPane.PLAIN_MESSAGE);
                if (true) {
                    return true;
                }

            } else {
                return false;
            }

        }

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

            if ((searchPHRASE != null) && (searchPHRASE.length() > 0)) {  // an 'OR' search as a placeholder; see searchOR
                String[] searchPHRASEterms = searchPHRASE.split("\\s+");

                String[] indexWords = new String[10000];
                int j = 0;
                for (String indexName : indexes) {
                    try {
                        Scanner scanner = new Scanner(new File(indexName));
                        while (scanner.hasNext()) {
                            String indexLines = scanner.nextLine();
                            indexWords = indexLines.split("\\s+");
                        }
                    } catch (FileNotFoundException ex) {
                        JOptionPane.showMessageDialog(null,
                                "Error: Index is empty.",
                                "Search Engine - Error",
                                JOptionPane.PLAIN_MESSAGE);
                        return true;
                    }

                    for (String terms : searchPHRASEterms) {

                        for (i = 0; indexWords.length > i && indexWords[i] != null; i++) {
                            if (indexWords[i] == null) break;
                            if (indexWords[i].equals(terms)) {
                                indexMatchesTerm[j] = true;
                                if (indexMatchesTerm[j]) {
                                    break;
                                }
                            }
                        }
                    }

                    j++;
                }

                for (i = 0; i < indexSize; i++) {
                    if (indexMatchesTerm[i]) {
                        indexesMatchingTerms += indexes[i] + " ";
                    }
                }

                JOptionPane.showMessageDialog(null,
                        "Matching files: " + indexesMatchingTerms,
                        "Search Engine - PHRASE Search",
                        JOptionPane.PLAIN_MESSAGE);
                if (true) {
                    return true;
                }

            } else {
                return false;
            }

        }

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

            final String PASSWORD = "piratehawks";  // the password to access the administrator tools menu

            Object[] optionsAdmin =  // the options the user may choose from at the search engine's administrator tools menu
                    {"Add File",
                            "Remove File",
                            "Cancel"};

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

            int adminTools = 0;  // the administrator tools menu; only accessible by administrators and good password guessers

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

            String addFile = null;  // an administrator feature which allows text documents to be added to the index

            if (adminTools == 0) {
                addFile = (String) JOptionPane.showInputDialog(
                        null,
                        "Enter the filename of the text document you wish to add to the index.\n" +
                                "(ex. 'File0.txt')",
                        "Search Engine - Add File",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
            }

            if ((addFile != null) && (addFile.length() > 0) && addFile.endsWith(".txt")) {  // adds the text file to the index
                index.add(addFile);
            }

            String removeFile = null;  // an administrator feature which allows text documents to be removed from the index

            if (adminTools == 1) {
                removeFile = (String) JOptionPane.showInputDialog(
                        null,
                        "Enter the filename of the text document you wish to remove from the index.\n" +
                                "(ex. 'File0.txt')",
                        "Search Engine - Remove File",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        null,
                        null);
            }

            if ((removeFile != null) && (removeFile.length() > 0) && removeFile.endsWith(".txt")) {  // removes the text file from the index
                index.remove(removeFile);
            }

        }

        return true;  // returns the user to the main menu

    }
}