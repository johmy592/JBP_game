import java.util.ArrayList;

public class Deck
{
    ArrayList<Card> cards = new ArrayList<Card>();

    public Deck(){}

    public Deck(ArrayList<Card> cards)
    {
        this.cards = cards;
    }

    void addCard(Card c)
    {
        cards.add(c);
    }

    Card drawCard()
    {
        if(cards.size() > 0)
        {
            return cards.remove(0);
        }else
        {
            return new FatigueCard();
        }
    }
}
