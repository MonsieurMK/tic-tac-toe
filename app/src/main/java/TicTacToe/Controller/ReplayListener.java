package TicTacToe.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReplayListener implements ActionListener {

    private MainController mc;

    public ReplayListener(MainController mc) {
        this.mc = mc;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        this.mc.replayGame();
    }
    
}
