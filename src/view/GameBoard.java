package view;

import control.Controller;
import control.Game;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoard extends JPanel {
    
    private final int OFFSET = 30;
    private final int SPACE = 32;
    
    private Game game;
    private List<Drawable> drawables = new ArrayList<>();
    
    GameBoard(Game game) {
        this.game = game;
        
        initDrawables(game);
        
        addKeyListener(new Controller(this));
        setFocusable(true);
    }
    
    private void initDrawables(Game game) {
        Map map = game.getMap();
        for (int x = 0; x < map.getWidth(); x++) {
            for (int y = 0; y < map.getHeight(); y++) {
                Field field = map.getFields()[x][y];
                
                if (field instanceof TrapHole){
                    drawables.add(new TrapHoleView((TrapHole) field));
                }
                if (field instanceof Hole){
                    drawables.add(new HoleView((Hole) field));
                }
                if (field instanceof Switch){
                    drawables.add(new SwitchView((Switch) field));
                }
                if (field instanceof GoalField){
                    drawables.add(new GoalFieldView((GoalField) field));
                }
                if (field instanceof Field){
                    drawables.add(new FieldView(field));
                }
            }
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paint(g);
        drawMap(g);
    }
    
    public void drawMap(Graphics g) {
        
        g.setColor(new Color(250, 240, 170));
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        for (int i = 0; i < drawables.size(); i++) {

            Drawable item = drawables.get(i);
            item.draw(g);
            
        }
    }
    
    public Game getGame() {
        return game;
    }
}
