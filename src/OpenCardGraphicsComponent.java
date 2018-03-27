import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class OpenCardGraphicsComponent extends JComponent
{
    Map<String,BufferedImage> cardGraphics = new HashMap<String, BufferedImage>();
    //ArrayList<BufferedImage> cardGraphics = new ArrayList<BufferedImage>();
    Board board;
    HumanPlayer player;
    final String graphicsFolderPath = "C:\\Users\\Johannes\\Desktop\\git_stuff\\JBP_game\\images\\";
    final String placeholderPath = "C:\\Users\\Johannes\\Desktop\\git_stuff\\JBP_game\\images\\Cards.jpg";

    public OpenCardGraphicsComponent(Board board)
    {
        this.board = board;
        player = board.getHumanPlayer();

        initCardGraphics();
    }

    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int cardPos = 0;
        for(Card c : player.getHand().getCards())
        {
            g2d.drawImage(cardGraphics.get(c.getName()),10*cardPos,10,null);
            cardPos ++;
        }
    }

    void initCardGraphics()
    {

        for(Card c : player.getHand().getCards())
        {
            if(!cardGraphics.containsKey(c.getName()))
            {
                try {
                    String pathname = graphicsFolderPath + c.getName() + ".jpg";
                    System.out.println(pathname);
                    File imageFile = new File(pathname);
                    BufferedImage cur = ImageIO.read(imageFile);
                    cardGraphics.put(c.getName(), cur);
                }catch(java.io.IOException e)
                {
                    try {
                        File imageFile = new File(placeholderPath);
                        BufferedImage cur = ImageIO.read(imageFile);
                        cardGraphics.put(c.getName(), cur);
                    }catch(java.io.IOException e1)
                    {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }
}
