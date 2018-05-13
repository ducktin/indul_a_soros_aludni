package view;

import java.awt.*;

import model.Crate;
import model.Wall;

public class WallView implements Drawable {
    
    protected Wall wall;
    protected Image img;
    
    private int x;
    private int y;
    
    public WallView(Wall wall, int x, int y) {
        this.wall = wall;
        this.x = x;
        this.y = y;
        loadImage();
    }
    
    private void loadImage() {
        ImageRepository repo = ImageRepository.getInstance();
        this.img = repo.getWallImage();
    }
    
    
    @Override
    public void draw(Graphics g) {
//        System.out.println("drawing wall on " + "x-" + x + ", y-" + y);
        g.drawImage(img, this.x, this.y, null);
    }
}
