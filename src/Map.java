import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private List<Worker> workers;
    private Field[][] fields;
    //private List<Field> fields;

    public void moveWorker(int id, Direction direction){
        System.out.printf("moveWorker");
            workers.get(id).move(direction);
    }

    Map(int mapHeight, int mapWidth){
        workers=new ArrayList<>();
        fields = new Field[mapHeight][mapWidth];
    }

    public void addWorker(Worker worker){
        System.out.printf("addWorker");
            workers.add(worker);
    }

    public void addField(int xPos, int yPos){
        System.out.println("addField");
        //TODO: figure out which is the x and y axis in the fields[][]
    }
}
