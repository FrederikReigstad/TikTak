package tictactoe.bll;

import tictactoe.gui.controller.TicTacViewController;

/**
 * The GameBoardTwoPlayer class is the mandatory implementation for the TicTacToe assignment.
 * It is used for games where there are two human players.
 */
public class GameBoardTwoPlayer implements IGameModel {

    Boolean debug = true;
    int[][] gameBoard = new int[3][3];
    public int player;
    int nuke = -1;

    public GameBoardTwoPlayer()
    {
    }

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    @Override
    public int getNextPlayer() {
        if (player % 2 == 0){

            player = 1;
        }
        else {
            player = 0 ;
        }

        return player;
    }

    /**
     * Attempts to let the current player play at the given coordinates. If the
     * attempt is successful the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver ==
     * true this method will always return false.
     */
    @Override
    public boolean play(int col, int row)
    {
        boolean isMovePermitted;
        isMovePermitted = true;

        if (debug == true)
                {
                    System.out.print("isMovePermitted: " + isMovePermitted);
                }

    return isMovePermitted;
    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will return false.
     */
    @Override
    public boolean isGameOver() {
        //TODO Implement this method
        return false;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    @Override
    public int getWinner() {
        //TODO Implement this method
        return -1;
    }

    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame()
    {
        for (int r = 0; r < gameBoard.length; r++)
        {
            for (int c = 0; c < gameBoard[0].length; c++)
            {
                gameBoard[r][c] = nuke;
                if (debug == true)
                {
                    System.out.println("Gameboard Reset: " + gameBoard[r][c]);
                }
            }
        }
    }

    /**
     * Returns the value representing which players has played the given field.
     *
     * @param col The column to look at.
     * @param row The row to look at.
     * @return Will return 0 if player 0 has played the field, 1 for player one, and -1 if no player has played the field.
     */
    @Override
    public int getPlayerAt(int col, int row) {
        int playerAt = gameBoard[row][col];
        if (debug == true)
        {
            System.out.println("playerAt: " + playerAt);
        }
        return playerAt;
    }
}