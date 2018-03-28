import java.awt.*;

public class HumanPlayerGraphicsComponent extends CardGraphicsComponent
{

    HumanPlayer player;

    public HumanPlayerGraphicsComponent(Board board)
    {
        super(board);
        player = board.getHumanPlayer();

        super.initCardGraphics();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int cardPos = 0;
        for(Card c : player.getHand().getCards())
        {
            g2d.drawImage(cardGraphics.get(c.getName()),CARD_WIDTH*cardPos,10,null);
            cardPos ++;
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(player.getHand().MAX_HAND_SIZE*CARD_WIDTH,CARD_HEIGHT);
    }

}
