package TicTacToe.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener for the replay button
 */
public class ReplayListener implements ActionListener {

    private MainController mc;

    /**
     * Creates a ReplayListener
     * @param mc Associated MainController
     */
    public ReplayListener(MainController mc) {
        this.mc = mc;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.mc.replayGame();
    }
    
}
