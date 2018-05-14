package view;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ImageRepository {
    
    Map<String, Image> imageMap;
    static ImageRepository instance;
    
    private ImageRepository(){
        imageMap = new HashMap<>();
    }
    
    public static ImageRepository getInstance() {
        if (instance == null) {
            instance = new ImageRepository();
        }
        return instance;
    }
    
    public Image getFieldImage(){
        Image img = getImage("pics/Ground.png", "field");
        return img;
    }
    
    public Image getOilImage(){
        Image img = getImage("pics/Oil.png", "oil");
        return img;
    }
    
    public Image getHoneyImage(){
        Image img = getImage("pics/HoneyHD.png", "honey");
        return img;
    }
    
    public Image getCrateImage(){
        Image img = getImage("pics/Crate.png", "crate");
        return img;
    }
    
    public Image getGoalFieldImage(){
        Image img = getImage("pics/GoalField.png", "goalField");
        return img;
    }
    
    public Image getHoleImage(){
        Image img = getImage("pics/Hole.png", "hole");
        return img;
    }
    
    public Image getSwitchOnImage(){
        Image img = getImage("pics/Switch_HD_GREEN.png", "switchOn");
        return img;
    }
    
    public Image getSwitchOffImage(){
        Image img = getImage("pics/Switch_HD_RED.png", "switchOff");
        return img;
    }
    
    public Image getWallImage(){
        Image img = getImage("pics/Wall.png", "wall");
        return img;
    }
    
    public Image getWorkerImage(){
        Image img = getImage("pics/HD_WORKER_DLC.png", "worker");
        return img;
    }

    public Image getWorkerImageRedDlc(){
        Image img = getImage("pics/HD_WORKER_2_DLC.png", "workerDlc");
        return img;
    }
    
    private Image getImage(String imagePath, String mapPath) {
        Image img = imageMap.get(mapPath);
        if(img == null){
            try {
                URL url = getClass().getResource(imagePath);
                img = ImageIO.read(new File(url.getPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageMap.put(mapPath, img);
        }
        return img;
    }
}
