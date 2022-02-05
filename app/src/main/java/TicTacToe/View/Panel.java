package TicTacToe.View;

import javax.swing.JButton;
import javax.swing.JPanel;

import TicTacToe.Controller.CellButtonListener;
import TicTacToe.Controller.MainController;
import TicTacToe.Controller.ReplayListener;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

/**
 * Main panel of the frame
 */
public class Panel extends JPanel {

    /**
     * Size of the square grid
     */
    public static final int GRID_SIZE = 3;

    /**
     * Cell buttons of the GUI's grid
     */
    private CellButton[][] cells;

    /**
     * MainController of the application
     */
    private MainController mc;

    /**
     * Creates a panel of the GUI
     * @param mc MainController of the application
     */
    public Panel(MainController mc) {
        this.setLayout(new BorderLayout());

        // grid panel
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(3, 3));
        this.add(gridPanel, BorderLayout.CENTER);

        this.cells = new CellButton[GRID_SIZE][GRID_SIZE];

        this.mc = mc;

        CellButtonListener cellBL = new CellButtonListener(mc);

        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.cells[i][j] = new CellButton(j, i); // may not be inverted
                this.cells[i][j].addActionListener(cellBL);
                gridPanel.add(this.cells[i][j]);
            }
        }

        // optionsPanel
        JPanel optionsPanel = new JPanel();
        optionsPanel.setLayout(new FlowLayout());
        this.add(optionsPanel, BorderLayout.SOUTH);

        JButton replayButton = new JButton("Replay");
        replayButton.addActionListener(new ReplayListener(this.mc));
        optionsPanel.add(replayButton);
    }

    /**
     * Changes the text of a given cell button
     * @param j i coordinate (swapped)
     * @param i j coordinate (swapped)
     * @param text new text to display 
     */
    @Deprecated
    public void setCell(int j, int i, String text) {
        this.cells[i][j].setText(text);
    }

    /**
     * Returns a given cell button on the grid
     * @param j i coordinate (swapped)
     * @param i j coordinate (swapped)
     * @return the cell button
     */
    public JButton getCell(int j, int i) {
        return this.cells[i][j];
    }

    /**
     * Displays the winner of the game, or shows that is a tie
     * @param winner state of the winner, EMPTY if it is a tie
     */
    public void playerWon(CellButtonState winner) {
        if (winner == CellButtonState.EMPTY) {
            System.out.println("TIE");
        } else {
            System.out.println("" + winner + " won");
        }
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.cells[i][j].setEnabled(false);
            }
        }
    }

    /**
     * Resets the buttons of the grid
     */
    public void resetGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.cells[i][j].setEnabled(true);
                this.cells[i][j].setState(CellButtonState.EMPTY);
            }
        }
    }

}
