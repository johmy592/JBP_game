import java.util.ArrayList;

public class main
{

    public static void main(String[] args) {
        System.out.println("Test");
        TestMethods test = new TestMethods();

        Board board = new Board();
        Player player1 = new HumanPlayer("JBP");
        Player player2 = new AIPlayer("Other guy");

        player1.setDeck(test.makeTestDeck());
        player2.setDeck(test.makeTestDeck());

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        Game game = new Game(players,board);
        game.startGame();

    }


}



