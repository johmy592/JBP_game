import java.util.ArrayList;

public class TestMethods
{
    public Deck makeTestDeck()
    {
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add( new MinionCard("LUL",2,"Hehe",1,1));
        cards.add( new MinionCard("Big Guy",5,"So stronk",7,7));
        return new Deck(cards);
    }
}
