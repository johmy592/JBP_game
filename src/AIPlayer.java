import java.util.ArrayList;
import java.util.Map;

public class AIPlayer extends Player
{
    int moveNum = 0;
    public AIPlayer(String name)
    {
        super(name);
    }

    @Override
    Move makeMove(Map<Player, ArrayList<Card>> openCards)
    {
        if(moveNum == 0) {
            nextMove.setCard(hand.getCardAt(0));
            nextMove.setType(MoveType.PLAYMINION);
            moveNum += 1;
        }else{
            moveNum = 0;
            nextMove.setType(MoveType.END);
        }
        return nextMove;
    }
}
