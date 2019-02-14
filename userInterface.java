import java.awt.*;
import javax.swing.*;

public class userInterface {

    private static void userWindow()
    {
        JFrame frame = new JFrame("Search Engine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JLabel textLabel = new JLabel("Search Engine");
        textLabel.setLocation(100,60);
        textLabel.setPreferredSize(new Dimension(500,500));


        frame.getContentPane().add(textLabel,BorderLayout.CENTER);

        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {
        userWindow();
    }



}
