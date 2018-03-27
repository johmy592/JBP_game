import javax.swing.*;
import java.awt.*;

public class StartMenuFrame extends JFrame
{
    public StartMenuFrame()
    {
        super("JBP Game");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(400,400);


        JButton testButton = new JButton("Test");
        testButton.setAlignmentX(CENTER_ALIGNMENT);

        JButton testButton2 = new JButton("Test2");

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(testButton);
        panel.add(testButton2);
        this.add(panel);
    }

    public static void main(String[] args) {
        StartMenuFrame frame = new StartMenuFrame();
        frame.setVisible(true);
    }
}
