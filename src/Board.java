import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Board
{
    ArrayList<Player> players = new ArrayList<Player>();
    Map<Player,ArrayList<Card>> openCards = new HashMap<Player, ArrayList<Card>>();

    public Board(){}


    Map<Player,ArrayList<Card>> getOpenCards()
    {
        return openCards;
    }

    void addPlayer(Player p)
    {
        players.add(p);
        openCards.put(p,new ArrayList<Card>());
    }

    void addCard(Player p, Card c)
    {
        openCards.get(p).add(c);
    }

    void printBoard()
    {
        System.out.println("CURRENT BOARD SETUP");
        for(Player p : players)
        {
            System.out.println(p.getName());
            for(Card c : openCards.get(p))
            {
                System.out.println(c.toStr());
            }
        }
    }
}
