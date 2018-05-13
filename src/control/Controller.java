package control;

import model.Direction;
import model.Watcher;
import view.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.Key;

public class Controller implements KeyListener {

    private GameBoard gameBoard;
    private Game game;

    public Controller(GameBoard gameboard) {
        this.gameBoard = gameboard;
        this.game = gameBoard.getGame();
        game.watcher = Watcher.getInstance();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        System.out.println("key fired:" + key);
    
        switch (key) {
            //Player No.1
            case KeyEvent.VK_W:
                game.map.moveWorker(0, Direction.UP);
                break;
            case KeyEvent.VK_A:
                game.map.moveWorker(0, Direction.LEFT);
                break;
            case KeyEvent.VK_D:
                game.map.moveWorker(0, Direction.RIGHT);
                break;
            case KeyEvent.VK_S:
                game.map.moveWorker(0, Direction.DOWN);
                break;
            case KeyEvent.VK_Q:
                game.map.getWorkers().get(0).dropOil();
                break;
            case KeyEvent.VK_E:
                game.map.getWorkers().get(0).dropHoney();
                break;
            //Player No.2
            case KeyEvent.VK_I:
                game.map.moveWorker(1, Direction.UP);
                break;
            case KeyEvent.VK_J:
                game.map.moveWorker(1, Direction.LEFT);
                break;
            case KeyEvent.VK_L:
                game.map.moveWorker(1, Direction.RIGHT);
                break;
            case KeyEvent.VK_K:
                game.map.moveWorker(1, Direction.DOWN);
                break;
            case KeyEvent.VK_U:
                game.map.getWorkers().get(1).dropOil();
                break;
            case KeyEvent.VK_O:
                game.map.getWorkers().get(1).dropHoney();
                break;
            case KeyEvent.VK_LEFT:
                game.map.moveWorker(2, Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                game.map.moveWorker(2, Direction.RIGHT);
                break;
            case KeyEvent.VK_UP:
                game.map.moveWorker(2, Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                game.map.moveWorker(2, Direction.DOWN);
                break;
            case KeyEvent.VK_T:
                try {
                    Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=dQw4w9WgXcQ").toURI());
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            default:
                break;
        }
        gameBoard.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
