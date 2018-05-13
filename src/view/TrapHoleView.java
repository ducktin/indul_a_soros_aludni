package view;

import model.TrapHole;

import java.awt.*;

public class TrapHoleView implements Drawable {
    
    protected TrapHole trapHole;
    protected Image img;
    
    public TrapHoleView(TrapHole trapHole) {
        this.trapHole = trapHole;
    }
    
    @Override
    public void draw(Graphics g) {
    
    }
}
