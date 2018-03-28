import java.util.ArrayList;

public class Hand
{
    public static final int MAX_HAND_SIZE = 5;

    ArrayList<Card> cards = new ArrayList<Card>();

    void addCard(Card c)
    {
        if(cards.size() <= MAX_HAND_SIZE)
        {
            cards.add(c);
        }
    }

    ArrayList<Card> getCards()
    {
        return cards;
    }

    Card getCardAt(int i)
    {
        return cards.get(i);
    }

    Card removeCardAt(int i)
    {
        return cards.remove(i);
    }

    void removeCard(Card c)
    {
        cards.remove(c);
    }

    void printHand()
    {
        System.out.println("HAND: ");
        for(Card c : cards)
        {
            System.out.println(c.toStr());
        }
    }
}
