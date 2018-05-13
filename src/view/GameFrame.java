package view;

import control.Game;

import javax.swing.*;

public class GameFrame extends JFrame {
    
    private final int SPACE = 64;
    
    GameFrame(Game game) {
        
        GameBoard gameBoard = new GameBoard(game);
        add(gameBoard);
        
        setSize(game.getMap().getWidth() * SPACE,
                game.getMap().getHeight() * SPACE);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Killer Sokoban");
        setLocationRelativeTo(null);
    }
    
}
