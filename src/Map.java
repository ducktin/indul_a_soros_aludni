import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private List<Worker> workers;
    private Field[][] fields;

    public void moveWorker(int id, Direction direction){
        System.out.printf("moveWorker");
        workers.get(id).move(direction);
    }

    /*    x0 x1       x2        x3 x4        x5        x6 x7
       y0                                fields[5][0]
       y1
       y2
       y3
       y4
       y5         fields[2][5]
       y6
       y7
        */
    Map(int mapWidth, int mapHeight){
        workers=new ArrayList<>();
        fields = new Field[mapWidth][mapHeight];
    }

    public void addWorker(Worker worker){
        System.out.printf("addWorker");
        workers.add(worker);
    }

    public void addField(int xPos, int yPos, Field field){
        System.out.println("Adding Field ");

    }
}
