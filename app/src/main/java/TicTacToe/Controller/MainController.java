package TicTacToe.Controller;

import TicTacToe.Model.CellState;
import TicTacToe.Model.Grid;
import TicTacToe.View.CellButtonState;
import TicTacToe.View.Frame;
import TicTacToe.View.Panel;

/**
 * Main class of the application, this class should be called by the main
 * to execute the application
 */
public class MainController {
    
    private Frame frame;
    private Panel panel;

    private Grid grid;

    private Turn currenTurn;

    /**
     * Creates the main controller, the application frame, its main panel and the game grid
     */
    public MainController() {
        this.frame = new Frame(this);
        this.panel = frame.getPanel();
        this.grid = new Grid();

        this.currenTurn = Turn.X; // starts with X's turn
    }

    /**
     * Changes the current turn, if it is X's turn then changes to O's turn
     * and if it is O's turn then changes to X's turn
     */
    private void changeTurn() {
        if (this.currenTurn == Turn.X) {
            this.currenTurn = Turn.O;
        } else {
            this.currenTurn = Turn.X;
        }
    }

    /**
     * Places on the model grid and checks if the game is won or if it is a tie
     * @param i i coordinate of the grid
     * @param j j coordinate of the grid
     */
    public void place(int i, int j) {
        CellState state;
        if (currenTurn == Turn.X) {
            state = CellState.X;
        } else {
            state = CellState.O;
        }
        this.grid.place(j, i, state);
        CellState cellState = this.grid.hasWon();
        if (cellState == CellState.X) {
            this.panel.playerWon(CellButtonState.X);
        } else if (cellState == CellState.O) {
            this.panel.playerWon(CellButtonState.O);
        } else if (this.grid.isFull()) {
            this.panel.playerWon(CellButtonState.EMPTY);
        } else {
            this.changeTurn();
        }
    }

    /**
     * Returns the current player's turn
     * @return the current turn
     */
    public Turn getCurrenTurn() {
        return this.currenTurn;
    }

    /**
     * Restarts the game by clearing the grid on the model and 
     * on the GUI
     */
    public void replayGame() {
        this.grid.clearGrid();
        this.panel.resetGrid();
        this.currenTurn = Turn.X;
    }

}
