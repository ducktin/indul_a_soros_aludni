package view;

import model.Field;

import java.awt.*;
import java.awt.image.ImageObserver;

public class FieldView implements Drawable {
    
    private final int SPACE = 64;
    
    protected Field field;
    protected Image imgBase;
    protected Image imgOil;
    protected Image imgHoney;
    private int x;
    private int y;
    
    public FieldView(Field field, int x, int y) {
        this.field = field;
        this.x = x * SPACE;
        this.y = y * SPACE;
        
        loadImages();
    }
    
    private void loadImages() {
        this.imgBase = ImageRepository.getInstance().getFieldImage();
        this.imgOil = ImageRepository.getInstance().getFieldImage();
        this.imgHoney = ImageRepository.getInstance().getFieldImage();
    }
    
    @Override
    public void draw(Graphics g) {
        System.out.println("drawing: " + "x-" + x + ", y-" + y);
        g.drawImage(imgBase, this.x, this.y, null);
        if (field.getSlipperiness() == 0) {
            g.drawImage(imgOil, this.x, this.y, null);
        } else if (field.getSlipperiness() == 2) {
            g.drawImage(imgHoney, this.x, this.y, null);
            
        }
    }
}
