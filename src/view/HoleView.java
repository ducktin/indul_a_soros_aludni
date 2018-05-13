package view;

import model.Hole;

import java.awt.*;

public class HoleView implements Drawable {
    
    protected Hole hole;
    protected Image img;
    
    public HoleView(Hole hole) {
        this.hole = hole;
    }
    
    
    @Override
    public void draw(Graphics g) {
    
    }
}
