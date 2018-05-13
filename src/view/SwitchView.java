package view;

import model.*;

import java.awt.*;

public class SwitchView implements Drawable {
    
    private final int SPACE = 64;
    
    protected Switch aSwitch;
    protected Image imgOn;
    protected Image imgOff;
    protected Image imgOil;
    protected Image imgHoney;
    
    private int x;
    private int y;
    
    public SwitchView(Switch aSwitch, int x, int y) {
        this.aSwitch = aSwitch;
        this.x = x * SPACE;
        this.y = y * SPACE;
    
        loadImages();
    }
    
    private void loadImages() {
        ImageRepository repo = ImageRepository.getInstance();
        this.imgOn = repo.getSwitchOnImage();
        this.imgOff = repo.getSwitchOffImage();
        this.imgOil = repo.getOilImage();
        this.imgHoney = repo.getHoneyImage();
    }
    
    @Override
    public void draw(Graphics g) {
        System.out.println("drawing switch on " + "x-" + x + ", y-" + y);
        
        if(aSwitch.isActive()){
            g.drawImage(imgOn, this.x, this.y, null);
        } else {
            g.drawImage(imgOff, this.x, this.y, null);
        }
        
        if (aSwitch.getSlipperiness() == 0) {
            g.drawImage(imgOil, this.x, this.y, null);
        } else if (aSwitch.getSlipperiness() == 2) {
            g.drawImage(imgHoney, this.x, this.y, null);
        }
        
        Pushable item = this.aSwitch.getPushable();
        if (item instanceof Wall){
            WallView wv = new WallView((Wall) item, this.x, this.y);
            wv.draw(g);
        }
        if (item instanceof Crate){
            CrateView cv = new CrateView((Crate) item, this.x, this.y);
            cv.draw(g);
        }
        if (item instanceof Worker){
            WorkerView wv = new WorkerView((Worker) item, this.x, this.y);
            wv.draw(g);
        }
    }
}
