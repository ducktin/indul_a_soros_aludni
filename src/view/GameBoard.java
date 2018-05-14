package view;

import control.Controller;
import control.Game;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JPanel {
    
    private final int SPACE = 64;
    
    private Game game;
    private List<Drawable> drawables = new ArrayList<>();
    
    GameBoard(Game game) {
        this.game = game;
        
        initDrawables(game);
        
        addKeyListener(new Controller(this));
        setFocusable(true);
    }
    
    private void initDrawables(Game game) {
        drawables.clear();
        Map map = game.getMap();
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Field field = map.getFields()[y][x];
                if (field instanceof TrapHole){
                    drawables.add(new TrapHoleView((TrapHole) field, x, y));
                }
                else if (field instanceof Hole){
                    drawables.add(new HoleView((Hole) field, x, y));
                }
                else if (field instanceof Switch){
                    drawables.add(new SwitchView((Switch) field, x, y));
                }
                else if (field instanceof GoalField){
                    drawables.add(new GoalFieldView((GoalField) field, x, y));
                }
                else if (field instanceof Field){
                   drawables.add(new FieldView(field, x, y));
                }
            }
        }
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        initDrawables(this.game);
        drawMap(g);
        int playerNum = 1;
        for (Worker worker: game.getMap().getWorkers()) {
            g.setColor(new Color(255, 255, 255));
            g.drawString("Player" + playerNum +" point: " + worker.getPoints(), 15, playerNum*15);
            playerNum++;
        }
        if(!game.getStarted()){
            g.setColor(new Color(255, 0, 0));
            g.drawString("Over", 15, 50);
        }
    }
    
    public void drawMap(Graphics g) {
        
        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        System.out.println(drawables.size());
        for (int i = 0; i < drawables.size(); i++) {

            Drawable item = drawables.get(i);
            item.draw(g);
        }
    }
    
    public Game getGame() {
        return game;
    }
}
