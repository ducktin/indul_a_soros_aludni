package view;

import model.GoalField;

import java.awt.*;

public class GoalFieldView implements Drawable {
    
    protected GoalField goalField;
    protected Image img;
    
    public GoalFieldView(GoalField goalField, int x, int y) {
        this.goalField = goalField;
    }
    
    
    @Override
    public void draw(Graphics g) {
    
    }
}
