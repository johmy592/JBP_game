import java.util.ArrayList;
import java.util.Map;

public abstract class Player
{
    Hand hand = new Hand();
    Deck deck = new Deck();
    String name = "PLACEHOLDER";
    Move nextMove = new Move();

    public Player(String name)
    {
        this.name = name;
    }


    String getName()
    {
        return name;
    }

    Hand getHand()
    {
        return hand;
    }

    void setDeck(Deck deck)
    {
        this.deck = deck;
    }

    void draw(int numCards)
    {
        for(int i=0; i<numCards; i++)
        {
            hand.addCard(deck.drawCard());
        }
    }

    abstract Move makeMove(Map<Player,ArrayList<Card>> openCards);


}
