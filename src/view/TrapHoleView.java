package view;

import model.*;

import java.awt.*;

public class TrapHoleView implements Drawable {
    
    
    private final int SPACE = 64;
    
    protected TrapHole trapHole;
    protected Image imgOpen;
    protected Image imgClosed;
    private int x;
    private int y;
    
    public TrapHoleView(TrapHole trapHole, int x, int y) {
        this.trapHole = trapHole;
        this.x = x * SPACE;
        this.y = y * SPACE;
    
        loadImages();
    }
    
    private void loadImages() {
        ImageRepository repo = ImageRepository.getInstance();
        this.imgOpen = repo.getHoleImage();
        this.imgClosed = repo.getFieldImage();
    }
    
    @Override
    public void draw(Graphics g) {
        System.out.println("drawing trapHole on " + "x-" + x + ", y-" + y);
        if(trapHole.getStatus()){
            g.drawImage(imgOpen, this.x, this.y, null);
        } else {
            g.drawImage(imgClosed, this.x, this.y, null);
            Pushable item = this.trapHole.getPushable();
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
}
