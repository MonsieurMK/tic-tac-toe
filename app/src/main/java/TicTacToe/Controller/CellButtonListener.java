package TicTacToe.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import TicTacToe.View.CellButton;
import TicTacToe.View.CellButtonState;

/**
 * Listener for the cell buttons
 */
public class CellButtonListener implements ActionListener {

    private MainController mc;

    /**
     * Creates a CellButtonListener
     * @param mc Associated MainController
     */
    public CellButtonListener(MainController mc) {
        this.mc = mc;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        CellButton cb = (CellButton) event.getSource();
        int i = cb.getiCoordinate();
        int j = cb.getjCoordinate();
        CellButtonState state;
        if (this.mc.getCurrenTurn() == Turn.X) {
            state = CellButtonState.X;
        } else {
            state = CellButtonState.O;
        }
        this.mc.place(i, j);
        cb.setState(state);
    }
    
}
