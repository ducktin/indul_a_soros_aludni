package view;

import control.Controller;
import control.Game;

import javax.swing.*;

public class GameBoard extends JPanel {
    
    Game game;
    
    GameBoard(Game game) {
        this.game = game;
        
        addKeyListener(new Controller(game));
        setFocusable(true);
    }
}
