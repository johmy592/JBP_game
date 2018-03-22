import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class HumanPlayer extends Player
{
    Scanner userInput;
    String[] allowedInput = {"PLAYCARD","END"};
    public HumanPlayer(String name)
    {
        super(name);
        userInput = new Scanner(System.in);
    }

    void selectCard()
    {
        hand.printHand();
        System.out.println("Enter index of card you want to play: ");
        int i = userInput.nextInt();
        if(i > hand.getCards().size()-1 || i < 0)
        {
            System.out.println("Invalid index");
            selectCard();
        }else{
            nextMove.setCard(hand.getCardAt(i));
        }
    }

    Move makeMove(Map<Player,ArrayList<Card>> openCards)
    {
        System.out.println("What move type? PLAYCARD/END");
        userInput.reset();
        String enteredMove = userInput.nextLine();
        if(!Arrays.asList(allowedInput).contains(enteredMove))
        {
            System.out.println("Not a valid move type");
            makeMove(openCards);
        }else{
            switch (enteredMove)
            {
                case "PLAYCARD":
                    nextMove.setType(MoveType.PLAYMINION);
                    selectCard();
                    break;
                case "END":
                    nextMove.setType(MoveType.END);
                    break;
            }
        }
        return nextMove;
    }
}
