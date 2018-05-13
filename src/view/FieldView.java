package view;

import model.Field;

import java.awt.*;

public class FieldView implements Drawable {

    protected Field field;
    protected Image imgBase;
    protected Image imgHoney;
    protected Image imgOil;
    
    public FieldView(Field field) {
        this.field = field;
    }
    
    @Override
    public void draw(Graphics g) {
    
    }
}
