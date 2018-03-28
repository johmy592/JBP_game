import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameFrame extends JFrame
{
    OpenCardsGraphicsComponent openCardGraphics;
    HumanPlayerGraphicsComponent humanPlayerGraphics;
    EnemyGraphicsComponent enemyGraphics;
    Board board;


    public GameFrame(Board board)
    {
        super("Ingame");
        this.setSize(1200,900);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.board = board;
        Container contentPane = this.getContentPane();

        humanPlayerGraphics = new HumanPlayerGraphicsComponent(board);
        openCardGraphics = new OpenCardsGraphicsComponent(board);
        enemyGraphics = new EnemyGraphicsComponent(board.getFirstAIPlayer());

        contentPane.add(humanPlayerGraphics,BorderLayout.PAGE_END);
        contentPane.add(enemyGraphics,BorderLayout.PAGE_START);
        contentPane.add(openCardGraphics,BorderLayout.CENTER);
    }


}
