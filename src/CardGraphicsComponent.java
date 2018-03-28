import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public abstract class CardGraphicsComponent extends JComponent
{
    static final int CARD_WIDTH = 100;
    static final int CARD_HEIGHT = 165;

    Board board;
    Map<String,BufferedImage> cardGraphics = new HashMap<String, BufferedImage>();
    final String graphicsFolderPath = "C:\\Users\\Johannes\\Desktop\\git_stuff\\JBP_game\\images\\";
    final String placeholderPath = "C:\\Users\\Johannes\\Desktop\\git_stuff\\JBP_game\\images\\Cards.jpg";

    public CardGraphicsComponent(Board board)
    {
        this.board = board;
    }

    void initCardGraphics() {
        for (Player p : board.getPlayers()) {
            for (Card c : p.getDeck().getCards()) {

                if (!cardGraphics.containsKey(c.getName())) {
                    try {
                        String pathname = graphicsFolderPath + c.getName() + ".jpg";
                        File imageFile = new File(pathname);
                        BufferedImage cur = ImageIO.read(imageFile);

                        cardGraphics.put(c.getName(), cur);
                    } catch (java.io.IOException e) {
                        try {
                            File imageFile = new File(placeholderPath);
                            BufferedImage cur = ImageIO.read(imageFile);
                            cardGraphics.put(c.getName(), cur);
                        } catch (java.io.IOException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }
        try {
            String pathname = graphicsFolderPath + "fatigue.jpg";
            File imageFile = new File(pathname);
            BufferedImage cur = ImageIO.read(imageFile);

            cardGraphics.put("oops", cur);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
