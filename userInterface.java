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
        //title of the window and subtitle
        JLabel title,subtitle;
        title=new JLabel("Search Engine");
        title.setBounds(100,10, 300,50);
        title.setFont(new Font("Arial", Font.BOLD,36));
        subtitle=new JLabel("Search Terms:");
        subtitle.setBounds(50,70, 100,25);
        userScreen.add(title); userScreen.add(subtitle);
        userScreen.setSize(500,600);
        userScreen.setLayout(null);
        userScreen.setVisible(true);

        //search button
        JButton searchButton = new JButton("Search");
        searchButton.setBounds(350,70,120,25);
        userScreen.add(searchButton);
        searchButton.setVisible(true);

        //textfield
        JTextField textField = new JTextField(20);
        textField.setBounds(150,70,190,25);
        userScreen.add(textField);
        textField.setVisible(true);

    }
    
    public static void main(String[] args)
    {
        //outputs the user window
        userWindow();
    }

}
