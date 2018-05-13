package view;

import control.Game;

import javax.swing.*;

public class GameFrame extends JFrame {
    
    private final int FRAME = 30;
    
    GameFrame(Game game) {
        
        GameBoard gameBoard = new GameBoard(game);
        add(gameBoard);
        
        setSize(game.getMap().getWidth() + 2 * FRAME,
                game.getMap().getHeight() + 2 * FRAME);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Killer Sokoban");
        setLocationRelativeTo(null);
    }
    
}
