package TicTacToe.View;

import javax.swing.JButton;

public class CellButton extends JButton {

    private CellButtonState state;
    private int iCoordinate;
    private int jCoordinate;
    
    public CellButton(int iCoordinate, int jCoordinate) {
        this.state = CellButtonState.EMPTY;
        this.iCoordinate = iCoordinate;
        this.jCoordinate = jCoordinate;
    }

    public int getiCoordinate() {
        return iCoordinate;
    }

    public int getjCoordinate() {
        return jCoordinate;
    }

    public CellButtonState getState() {
        return state;
    }

    public void setState(CellButtonState state) {
        this.state = state;
        if (state == CellButtonState.EMPTY) {
            this.setText("");
        } else {
            this.setText("" + state);
        }
    }
    
}
