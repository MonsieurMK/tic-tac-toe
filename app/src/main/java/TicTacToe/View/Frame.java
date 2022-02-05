package TicTacToe.View;

import java.awt.Dimension;

import javax.swing.JFrame;

import TicTacToe.Controller.MainController;

/**
 * Main frame of the application
 */
public class Frame extends JFrame {

    /**
     * Main panel
     */
    private Panel panel;

    /**
     * MainController of the application
     */
    private MainController mc;

    /**
     * Creates the frame
     * @param mc MainController of the application
     */
    public Frame(MainController mc) {
        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(400, 400));
        this.setResizable(false);

        this.mc = mc;

        this.panel = new Panel(this.mc);
        this.add(panel);

        this.pack();
    }

    /**
     * Returns the main panel of the frame
     * @return main panel
     */
    public Panel getPanel() {
        return panel;
    }    
    
}
