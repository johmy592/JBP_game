import java.util.ArrayList;
import java.util.Map;

public class AIPlayer extends Player
{
    public AIPlayer(String name)
    {
        super(name);
    }

    @Override
    Move makeMove(Map<Player, ArrayList<Card>> openCards)
    {
        nextMove.setCard(hand.getCardAt(0));
        nextMove.setType(MoveType.PLAYMINION);
        return nextMove;
    }
}
