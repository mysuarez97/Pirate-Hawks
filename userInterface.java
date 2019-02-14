import java.awt.*;
import javax.swing.*;

public class userInterface {

    private static void userWindow()
    {
        //sets up the jframe window
        JFrame textLabel=new JFrame("Search Engine");
        //title of the window and subtitle
        JLabel title,subtitle;
        title=new JLabel("Search Engine");
        title.setBounds(100,10, 300,50);
        title.setFont(new Font("Arial", Font.BOLD,36));
        subtitle=new JLabel("Search Terms:");
        subtitle.setBounds(50,70, 100,30);
        textLabel.add(title); textLabel.add(subtitle);
        textLabel.setSize(500,600);
        textLabel.setLayout(null);
        textLabel.setVisible(true);

    }

    public static void main(String[] args)
    {
        //outputs the user window
        userWindow();
    }



}
