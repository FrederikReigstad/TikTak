package tictactoe.gui.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ScoreModel {

    private final ObservableList<String> winners;

    public ScoreModel() {
        winners = FXCollections.observableArrayList();
    }

    public ObservableList<String> getWinners() {
        return winners;
    }


    /**
    * Displays the player, who wins. 0 or 1
    */
    public void setNextWinner(String winner) {

        if (winner.equals("-1"))
        {
            winners.add("Draw");
        }
        else
        {
            winners.add("Player " + winner);
        }
    }

}