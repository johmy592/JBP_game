public class Move
{
    Card card = null;
    Card target = null;
    MoveType type;


    public Move(){}

    public Move(Card card, Card target, MoveType type)
    {
        this.card = card;
        this.target = target;
        this.type = type;
    }

    public Move(Card card, MoveType type)
    {
        this.card = card;
        this.type = type;
    }

    public Move(MoveType type)
    {
        this.type = type;
    }

    Card getCard()
    {
        return card;
    }

    Card getTarget()
    {
        return target;
    }

    MoveType getType()
    {
        return type;
    }

    void setCard(Card c)
    {
        card = c;
    }

    void setTarget(Card c)
    {
        target = c;
    }

    void setType(MoveType t)
    {
        type = t;
    }
}
