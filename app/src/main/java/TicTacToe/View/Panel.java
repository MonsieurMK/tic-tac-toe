package TicTacToe.View;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import TicTacToe.Controller.CellButtonListener;
import TicTacToe.Controller.MainController;
import TicTacToe.Controller.ReplayListener;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class Panel extends JPanel {

    public static final int GRID_SIZE = 3;
    private CellButton[][] cells;

    private MainController mc;

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

    public void setCell(int j, int i, String text) {
        this.cells[i][j].setText(text);
    }

    public JButton getCell(int j, int i) {
        return this.cells[i][j];
    }

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

    public void resetGrid() {
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                this.cells[i][j].setEnabled(true);
                this.cells[i][j].setState(CellButtonState.EMPTY);
            }
        }
    }

}
