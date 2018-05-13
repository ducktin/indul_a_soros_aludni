package view;

import control.Game;

import javax.swing.*;

public class GameFrame extends JFrame {
    
    private final int FRAME = 30;
    private final int SPACE = 64;
    
    GameFrame(Game game) {
        
        GameBoard gameBoard = new GameBoard(game);
        add(gameBoard);
        
        setSize(game.getMap().getWidth() * SPACE + 2 * FRAME,
                game.getMap().getHeight() * SPACE + 2 * FRAME);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Killer Sokoban");
        setLocationRelativeTo(null);
    }
    
}
