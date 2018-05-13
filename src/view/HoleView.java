package view;

import model.Hole;

import java.awt.*;

public class HoleView implements Drawable {
    
    private final int SPACE = 64;
    
    protected Hole hole;
    protected Image img;
    private int x;
    private int y;
    
    public HoleView(Hole hole, int x, int y) {
        this.hole = hole;
        this.x = x * SPACE;
        this.y = y * SPACE;
        loadImage();
    }
    
    private void loadImage() {
        ImageRepository repo = ImageRepository.getInstance();
        this.img = repo.getHoleImage();
    }
    
    @Override
    public void draw(Graphics g) {
        g.drawImage(img, this.x, this.y, null);
    }
}
