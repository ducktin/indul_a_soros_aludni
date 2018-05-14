package view;

import model.Worker;

import java.awt.*;

public class WorkerView implements Drawable {

    protected Worker worker;
    protected Image img;

    private int x;
    private int y;
    private int playerNum;

    public WorkerView(Worker worker, int x, int y, int playerNum) {
        this.worker = worker;
        this.x = x;
        this.y = y;
        this.playerNum = playerNum;
        loadImage();
    }

    private void loadImage() {
        if (playerNum == 1) {
            ImageRepository repo = ImageRepository.getInstance();
            this.img = repo.getWorkerImage();
        }
        if (playerNum == 2) {
            ImageRepository repo = ImageRepository.getInstance();
            this.img = repo.getWorkerImageRedDlc();
        }

    }

    @Override
    public void draw(Graphics g) {
        System.out.println("drawing WORKER on " + "x-" + x + ", y-" + y);
        g.drawImage(img, this.x, this.y, null);
    }
}
