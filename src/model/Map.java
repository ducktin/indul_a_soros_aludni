package model;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private List<Worker> workers;
    private List<Crate> crates;
    private Field[][] fields;

    public void moveWorker(int id, Direction direction) {
        //System.out.println("model.Map, moveWorker, workerID: " + id);
        workers.get(id).move(direction);
    }

    public Map(int mapWidth, int mapHeight) {
        workers = new ArrayList<>();
        crates = new ArrayList<>();
        fields = new Field[mapWidth][mapHeight];
    }

    public void addWorker(Worker worker) {
        //System.out.println("model.Map, addWorker, worker: " + worker.getName());
        workers.add(worker);
    }

    public void addCrate(Crate crate) {
        crates.add(crate);
    }

    public void addField(int xPos, int yPos, Field field) {
        fields[xPos][yPos] = field;
        //System.out.println("model.Map, addField, field: " + field.getName());
    }

    public Field[][] getFields() {
        return fields;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public List<Crate> getCrates() {
        return crates;
    }
}
