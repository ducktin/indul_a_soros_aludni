import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private List<Worker> workers;
    private Field[][] fields;

    public void moveWorker(int id, Direction direction){
        System.out.println("Map, moveWorker, workerID: " + id);
            workers.get(id).move(direction);
    }

    Map(int mapWidth, int mapHeight){
        workers=new ArrayList<>();
        fields = new Field[mapWidth][mapHeight];
    }

    public void addWorker(Worker worker){
        System.out.println("Map, addWorker, worker: " + worker.getName());
            workers.add(worker);
    }

    public void addField(int xPos, int yPos, Field field){
        fields[xPos][yPos] = field;
        System.out.println("Map, addField, field: " + field.getName());

    }

    public Field[][] getFields() {
        return fields;
    }
}
