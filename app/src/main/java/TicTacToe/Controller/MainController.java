package TicTacToe.Controller;

import TicTacToe.Model.CellState;
import TicTacToe.Model.Grid;
import TicTacToe.View.CellButtonState;
import TicTacToe.View.Frame;
import TicTacToe.View.Panel;

public class MainController {
    
    private Frame frame;
    private Panel panel;

    private Grid grid;

    private Turn currenTurn;

    public MainController() {
        this.frame = new Frame(this);
        this.panel = frame.getPanel();
        this.grid = new Grid();

        this.currenTurn = Turn.X; // starts with X's turn
    }

    private void changeTurn() {
        if (this.currenTurn == Turn.X) {
            this.currenTurn = Turn.O;
        } else {
            this.currenTurn = Turn.X;
        }
    }

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

    public Turn getCurrenTurn() {
        return this.currenTurn;
    }

    public void replayGame() {
        this.grid.clearGrid();
        this.panel.resetGrid();
        this.currenTurn = Turn.X;
    }

}
