package view;

import model.Crate;

import java.awt.*;

public class CrateView implements Drawable {
    
    protected Crate crate;
    protected Image img;
    
    private int x;
    private int y;
    
    public CrateView(Crate crate, int x, int y) {
        this.crate = crate;
        this.x = x;
        this.y = y;
        loadImage();
    }
    
    private void loadImage() {
        ImageRepository repo = ImageRepository.getInstance();
        this.img = repo.getCrateImage();
    }
    
    @Override
    public void draw(Graphics g) {
        System.out.println("drawing CRATE on " + "x-" + x + ", y-" + y);
        g.drawImage(img, this.x, this.y, null);
    }
}
