package view;

import control.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
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
        Image img = imageMap.get("field");
        if(img == null){
            try {
                URL url = getClass().getResource("pics/Ground.png");
                img = ImageIO.read(new File(url.getPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageMap.put("field", img);
        }
        return img;
    }
}
