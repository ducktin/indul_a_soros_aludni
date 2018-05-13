package view;

import control.Controller;
import control.Game;

import javax.swing.*;
import java.io.Console;
import java.util.List;

public class GameFrame extends JFrame {
    
    
    GameFrame(Game game) {
        
        GameBoard gameBoard = new GameBoard(game);
        
        add(gameBoard);
        
        setSize(250, 200);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Killer Sokoban");
        setLocationRelativeTo(null);
    }
    
}
