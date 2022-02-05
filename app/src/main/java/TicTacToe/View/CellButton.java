package TicTacToe.View;

import javax.swing.JButton;

/**
 * Buttons of the game grid
 */
public class CellButton extends JButton {

    /**
     * Current state of the button
     */
    private CellButtonState state;
    /**
     * i coordinate of the button
     */
    private int iCoordinate;
    /**
     * j coordinate of the button
     */
    private int jCoordinate;
    
    /**
     * Creates a button with the given coordinates
     * @param iCoordinate i coordinate on the grid
     * @param jCoordinate j coordinate on the grid
     */
    public CellButton(int iCoordinate, int jCoordinate) {
        this.state = CellButtonState.EMPTY;
        this.iCoordinate = iCoordinate;
        this.jCoordinate = jCoordinate;
    }

    /**
     * Returns the coordinate
     * @return i coordinate
     */
    public int getiCoordinate() {
        return iCoordinate;
    }

    /**
     * Returns the coordinate
     * @return j coordinate
     */
    public int getjCoordinate() {
        return jCoordinate;
    }

    /**
     * Returns the current state of the button
     * @return state of the button
     */
    public CellButtonState getState() {
        return state;
    }

    /**
     * Sets the current state of the button and changes its text
     * @param state new state of the button
     */
    public void setState(CellButtonState state) {
        this.state = state;
        if (state == CellButtonState.EMPTY) {
            this.setText("");
        } else {
            this.setText("" + state);
        }
    }
    
}
