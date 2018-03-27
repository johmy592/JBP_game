import java.util.ArrayList;

public class Game
{
    GameState gameState = GameState.PREGAME;
    ArrayList<Player> players;
    Board board;
    Player currentPlayer;
    int currentPlayerIndex = 0;
    Move move;
    GameFrame graphicsFrame;

    public Game(Board board)
    {
        this.players = board.getPlayers();
        this.board = board;
        initGame();
    }

    void initGame()
    {
        currentPlayer = players.get(0);
        for(Player p : players)
        {
            p.draw(5);
        }
        gameState = GameState.INGAME;
        graphicsFrame = new GameFrame(board);
        graphicsFrame.setVisible(true);
    }

    void startGame()
    {
        gameLooop();
    }

    void gameLooop()
    {
        while(true)
        {
            System.out.println(currentPlayer.getName() + " turn: \n");
            currentPlayer.draw(1);
            playTurn();
            rotateTurn();
        }
    }

    void playTurn()
    {
        Boolean turnOver = false;
        while(true)
        {
            move = currentPlayer.makeMove(board.getOpenCards());
            if(checkMove(move))
            {
                turnOver = executeMove(move);
                if(turnOver)
                {
                    break;
                }
            }else
            {
                System.out.println("Impossible move");
            }
            System.out.println("BOARD AFTER MOVE: ");
            board.printBoard();
        }
    }

    void rotateTurn()
    {
        if(currentPlayerIndex == players.size()-1)
        {
            currentPlayerIndex = 0;
        }else
        {
            currentPlayerIndex += 1;
        }
        currentPlayer = players.get(currentPlayerIndex);
    }

    Boolean checkMove(Move move)
    {
        return true;
    }

    boolean executeMove(Move move)
    {
        switch (move.getType())
        {
            case PLAYMINION:
                board.addCard(currentPlayer, move.getCard());
                currentPlayer.getHand().removeCard(move.card);
                return false;
            case END:
                return true;
        }
        return false;
    }
}
