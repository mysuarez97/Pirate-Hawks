import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/*
 * Search Engine project assignment # 3
 * User interface
 * by Myrlene Suarez
 *    Sam
 *    Jeff
 *    Agnes
 *
 * */


public class userInterface extends JFrame{

    public static void userWindow()
    {
        //sets up the jframe window
        JFrame userScreen=new JFrame("Search Engine");
        //title of the window, index, and subtitle
        JLabel title,subtitle,index;
        title=new JLabel("Search Engine");
        title.setBounds(100,10, 300,50);
        title.setFont(new Font("Arial", Font.BOLD,36));
        subtitle=new JLabel("Search Terms:");
        subtitle.setBounds(50,70, 100,25);
        index=new JLabel("Number of indexs:");
        index.setBounds(200,500,120,24);
        userScreen.add(title); userScreen.add(subtitle);userScreen.add(index);
        userScreen.setSize(500,600);
        userScreen.setLayout(null);
        userScreen.setVisible(true);

        //search button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(350,70,120,25);
        userScreen.add(searchButton);
        searchButton.setVisible(true);

        //maintenance button
        JButton maintenanceButton=new JButton("Maintenance");
        maintenanceButton.setBounds(10,500,120,25);
        userScreen.add(maintenanceButton);
        maintenanceButton.setVisible(true);

        //about button
        JButton infoButton = new JButton("About");
        infoButton.setBounds(380,500,100,25);
        userScreen.add(infoButton);
        infoButton.setVisible(true);

        //textfield
        JTextField textField = new JTextField(20);
        textField.setBounds(150,70,190,25);
        userScreen.add(textField);
        textField.setVisible(true);

        //drop list for the AND, OR, and EXACT phrases
        JLabel label= new JLabel("Pick a Search term and click Search:");
        label.setBounds(0,100,250,25);
        label.setVisible(true);
        userScreen.add(label);

        String [] searchTerms ={" ","All of the Search Terms", "Any of the Search Terms","Exact Phrase"};

        JComboBox<String> dropList = new JComboBox<String>(searchTerms);

        dropList.setBounds(215,100,250,30);
        dropList.setVisible(true);
        userScreen.add(dropList);
        //text area

    }

    public static void main(String[] args)
    {
        //outputs the user window
        userWindow();
    }

}
