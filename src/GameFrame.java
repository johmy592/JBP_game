import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame
{
    OpenCardGraphicsComponent openCardGraphics;
    EnemyGraphicsComponent enemyGraphics;
    Board board;


    public GameFrame(Board board)
    {
        super("Ingame");
        this.setSize(1200,900);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.board = board;
        Container contentPane = this.getContentPane();

        openCardGraphics = new OpenCardGraphicsComponent(board);
        openCardGraphics.setPreferredSize(new Dimension(200,200));

        enemyGraphics = new EnemyGraphicsComponent(board.getFirstAIPlayer());
        enemyGraphics.setPreferredSize(new Dimension(200,200));

        contentPane.add(openCardGraphics,BorderLayout.PAGE_START);
        contentPane.add(enemyGraphics,BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        System.out.println("Test");
        TestMethods test = new TestMethods();


        HumanPlayer player1 = new HumanPlayer("JBP");
        Player player2 = new AIPlayer("Other guy");

        player1.setDeck(test.makeTestDeck());
        player2.setDeck(test.makeTestDeck());

        ArrayList<Player> players = new ArrayList<Player>();
        players.add(player1);
        players.add(player2);

        Board board = new Board(players,player1);
        Game game = new Game(board);
        game.startGame();


    }

}
