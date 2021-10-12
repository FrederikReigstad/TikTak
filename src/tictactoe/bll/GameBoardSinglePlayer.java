package tictactoe.bll;

/**
 * The GameBoardSinglePlayer class is the optional and advanced implementation for the TicTacToe assignment.
 * It is used for games where there are one human player vs. a computer player.
 */
public class GameBoardSinglePlayer implements IGameModel {

    int[][] gameBoard = new int[3][3];
    public int player = 2;
    int nuke = -1;
    int winner;
    protected GameBoardSinglePlayer() {
        for (int r = 0; r < gameBoard.length; r++)
        {
            for (int c = 0; c < gameBoard[0].length; c++)
            {
                gameBoard[r][c] = nuke;
            }
        }

    }

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    @Override
    public int getNextPlayer() {
        
        
        if (player % 2 == 0){

            player=1;
        }
        else {
            player=2;
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
    public boolean play(int col, int row) {
        boolean isMovePermitted;
        if (!isGameOver() && gameBoard[row][col] == nuke)
        {
            gameBoard[row][col] = player;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Tells us if the game has ended either by draw or by meeting the winning
     * condition.
     *
     * @return true if the game is over, else it will return false.
     */
    @Override
    public boolean isGameOver() {
        for (int i = 0; i < 3; i++){
            if (gameBoard[i][0] == gameBoard[i][1] && gameBoard[i][1] == gameBoard[i][2] && gameBoard[i][2] != nuke){
                this.winner = gameBoard[i][0];
                return true;
            }

        }
        /**
         *  Checking if there is a winner vertical
         */
        for (int j = 0; j < 3; j++){
            if (gameBoard[0][j] == gameBoard[1][j] && gameBoard[1][j] == gameBoard[2][j] && gameBoard[2][j] != nuke){
                this.winner = gameBoard[0][j];
                return true;
            }

        }

        /**
         *  Checking if there is a winner diagonal left to right
         */
        if(gameBoard[0][0] == gameBoard[1][1] && gameBoard[1][1] == gameBoard[2][2] && gameBoard[0][0] != nuke) {
            this.winner = gameBoard[0][0];
            return true;
        }

        /**
         *  Checking if there is a winner diagonal right to left
         */
        if(gameBoard[2][0] == gameBoard[1][1] && gameBoard[1][1] ==  gameBoard[0][2] && gameBoard[2][0] != nuke) {
            this.winner = gameBoard[2][0];
            return true;
        }

        /**
         *  Checking if there is a draw to see if there is a nuke int value left on the gameBoard
         */
        for (int r = 0; r < gameBoard.length; r++) // inits 2D array values to be -1
        {
            for (int c = 0; c < gameBoard[0].length; c++)
            {

                if (gameBoard[r][c] == nuke)
                {
                    return false;
                }
            }
        }

        /**
         *  if you reach here then the game is a draw
         */
        this.winner = nuke;
        return true;
    }

    /**
     * Gets the id of the winner, -1 if its a draw or if the game is still running.
     *
     * @return int id of winner, or -1 if draw or if gameOver() == false.
     */
    @Override
    public int getWinner() {
        return winner;
    }

    /**
     * Resets the game to a new game state.
     */
    @Override
    public void newGame() {
        for (int r = 0; r < gameBoard.length; r++)
        {
            for (int c = 0; c < gameBoard[0].length; c++)
            {
                gameBoard[r][c] = nuke;
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
    public int getPlayerAt(int col, int row)     {
        return gameBoard[row][col];
    }
}
