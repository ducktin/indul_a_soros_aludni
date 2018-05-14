package view;

import model.*;

import java.awt.*;

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
        ImageRepository repo = ImageRepository.getInstance();
        this.imgBase = repo.getFieldImage();
        this.imgOil = repo.getOilImage();
        this.imgHoney = repo.getHoneyImage();
    }
    
    @Override
    public void draw(Graphics g) {
//        System.out.println("drawing field on " + "x-" + x + ", y-" + y);
        g.drawImage(imgBase, this.x, this.y, null);
        if (field.getSlipperiness() == 0) {
            g.drawImage(imgOil, this.x, this.y, null);
        } else if (field.getSlipperiness() == 2) {
            g.drawImage(imgHoney, this.x, this.y, null);
        }
        
        Pushable item = this.field.getPushable();
        if (item instanceof Wall){
            WallView wv = new WallView((Wall) item, this.x, this.y);
            wv.draw(g);
        }
        if (item instanceof Crate){
            CrateView cv = new CrateView((Crate) item, this.x, this.y);
            cv.draw(g);
        }
        if (item instanceof Worker){
            WorkerView wv = new WorkerView((Worker) item, this.x, this.y, ((Worker) item).getPlayerNum());
            wv.draw(g);
        }
    }
}
