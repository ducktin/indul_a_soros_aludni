package view;

import model.Field;

import java.awt.*;
import java.awt.image.ImageObserver;

public class FieldView implements Drawable {
    
    private final int SPACE = 64;
    
    protected Field field;
    protected Image imgBase;
    protected Image imgHoney;
    protected Image imgOil;
    
    public FieldView(Field field) {
        this.field = field;
        imgBase = ImageRepository.getInstance().getFieldImage();
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(imgBase, 0, 0, null);
        if (field.getSlipperiness() == 0) {
            g.drawImage(imgOil, 0, 0, null);
        } else if (field.getSlipperiness() == 2) {
            g.drawImage(imgHoney, 0, 0, null);
            
        }
    }
}
