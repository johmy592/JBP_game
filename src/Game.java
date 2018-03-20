import java.util.ArrayList;

public class Game
{
    GameState gameState = GameState.PREGAME;
    ArrayList<Player> players;
    Board board;
    Player currentPlayer;

    public Game(ArrayList<Player> players, Board board)
    {
        this.players = players;
        this.board = board;
        initGame();
    }

    void initGame()
    {
        currentPlayer = players.get(0);
        for(Player p : players)
        {
            board.addPlayer(p);
            p.draw(5);
        }
        gameState = GameState.INGAME;
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
            Move move = currentPlayer.makeMove(board.getOpenCards());
            executeMove(move);
            System.out.println("BOARD AFTER MOVE: \n");
            board.printBoard();
            break;
        }
    }

    void executeMove(Move move)
    {
        switch (move.getType())
        {
            case PLAYMINION:
                board.addCard(currentPlayer, move.getCard());
                currentPlayer.getHand().removeCard(move.card);
        }
    }
}
