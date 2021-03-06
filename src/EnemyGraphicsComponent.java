import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class EnemyGraphicsComponent extends JComponent
{

    static final int CARD_WIDTH = 100;
    static final int CARD_HEIGHT = 165;

    final String cardbackPath = "C:\\Users\\Johannes\\Desktop\\git_stuff\\JBP_game\\images\\cardback.jpg";
    final String placeholderPath = "C:\\Users\\Johannes\\Desktop\\git_stuff\\JBP_game\\images\\Cards.jpg";
    Player enemyPlayer;
    BufferedImage cardbackGraphics;

    public EnemyGraphicsComponent(Player enemyPlayer)
    {
        this.enemyPlayer = enemyPlayer;

        initCardGraphics();
    }

    void initCardGraphics()
    {
        try
        {
            File imageFile = new File(cardbackPath);
            cardbackGraphics = ImageIO.read(imageFile);

        }catch(java.io.IOException e)
        {
            try
            {
                File imageFile = new File(placeholderPath);
                cardbackGraphics = ImageIO.read(imageFile);
            }catch(java.io.IOException e1)
            {
                e1.printStackTrace();
            }
        }
    }

    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i < enemyPlayer.getHand().getCards().size();i++)
        {
            g2d.drawImage(cardbackGraphics,i*CARD_WIDTH,0,null);
        }
    }

    public Dimension getPreferredSize()
    {
        return new Dimension(enemyPlayer.getHand().MAX_HAND_SIZE*CARD_WIDTH,CARD_HEIGHT);
    }
}
