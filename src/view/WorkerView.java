package view;

import model.Worker;

import java.awt.*;

public class WorkerView implements Drawable {
    
    protected Worker worker;
    protected Image img;
    
    private int x;
    private int y;
    
    public WorkerView(Worker worker, int x, int y) {
        this.worker = worker;
        this.x = x;
        this.y = y;
        loadImage();
    }
    
    private void loadImage() {
        ImageRepository repo = ImageRepository.getInstance();
        this.img = repo.getWorkerImage();
    }
    
    @Override
    public void draw(Graphics g) {
        System.out.println("drawing WORKER on " + "x-" + x + ", y-" + y);
        g.drawImage(img, this.x, this.y, null);
    }
}
