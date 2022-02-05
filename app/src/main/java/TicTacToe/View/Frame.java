package TicTacToe.View;

import java.awt.Dimension;

import javax.swing.JFrame;

import TicTacToe.Controller.MainController;

public class Frame extends JFrame {

    private Panel panel;

    private MainController mc;

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

    public Panel getPanel() {
        return panel;
    }    
    
}
