import java.awt.*;

public class OpenCardsGraphicsComponent extends CardGraphicsComponent
{
    private static final int SPACING = 50;

    OpenCardsGraphicsComponent(Board board)
    {
        super(board);
        super.initCardGraphics();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        Player humanPlayer = board.getHumanPlayer();
        for(Player p : board.getPlayers())
        {
            int cardPos = 0;
            int yPos;
            if(p != humanPlayer)
            {
                yPos = 0;
            }else
            {
                yPos = CARD_HEIGHT + SPACING;
            }
            for(Card c : board.getOpenCards().get(p))
            {
                g2d.drawImage(cardGraphics.get(c.getName()),cardPos*CARD_WIDTH, yPos,null);
                cardPos ++;
            }
        }
    }

    @Override
    public Dimension getPreferredSize()
    {
        return new Dimension(board.MAX_NUM_OPEN_CARDS*CARD_WIDTH,CARD_HEIGHT + SPACING);
    }
}