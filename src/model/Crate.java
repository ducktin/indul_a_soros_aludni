package model;

public class Crate implements Pushable {

    private static int instances = 0;
    
    private Field currentField;
    private boolean movable;
    private Watcher watcher;
    private Worker lastMovedBy;
    private String name;

    private static String nextName(){
        return "model.Crate-" + instances++;
    }
    
    public Crate(Field field) {
        this(field, nextName());
    }
    
    public Crate(Field field, String name) {
        System.out.println("model.Crate " + name + " constructor " + field.getName());
        this.currentField = field;
        this.movable = true;
        this.name = name;
        this.watcher = Watcher.getInstance();
    }

    public String getName() {
        // System.out.println("model.Crate " + "getName" + this.name);
        return this.name;
    }

    public void setField(Field field) {
        //System.out.println("model.Crate, " + this.name + ", setField, New field: " + field.getName());
        this.currentField = field;
    }

    public Field getCurrentField() {
        //System.out.println("model.Crate, " + this.name + ", getCurrentField,  CurrentField:" + currentField.getName());
        return currentField;
    }

    public boolean isMovable() {
        //System.out.println("model.Crate, " + this.name + ", isMovable?, CurrentField:" + currentField.getName());
        return movable;
    }

    public void immobilise() {
        System.out.println("model.Crate, " + this.name + ", immobilise, CurrentField:" + currentField.getName());
        movable = false;
        watcher.decreaseCrates();
    }

    public void checkMovability() {
        System.out.println("BEGIN/////checkMovability of " + this.name + "/////BEGIN");
        int notMovableAround = 0;
        boolean upperMovable = true;
        boolean righterMovable = true;
        boolean lefterMovable = true;
        boolean downerMovable = true;

        if (currentField.getNeighbor(Direction.UP) != null) {
            Pushable neighbor = currentField.getNeighbor(Direction.UP).getPushable();
            if (neighbor != null) {
                if (!neighbor.isMovable()) {
                    notMovableAround++;
                    upperMovable = false;
                }
            }
        }

        if (currentField.getNeighbor(Direction.RIGHT) != null) {
            Pushable neighbor = currentField.getNeighbor(Direction.RIGHT).getPushable();
            if (neighbor != null) {
                if (!neighbor.isMovable()) {
                    notMovableAround++;
                    righterMovable = false;
                }
            }
        }
        if (currentField.getNeighbor(Direction.LEFT) != null) {
            Pushable neighbor = currentField.getNeighbor(Direction.LEFT).getPushable();
            if (neighbor != null) {
                if (!neighbor.isMovable()) {
                    notMovableAround++;
                    lefterMovable = false;
                }
            }
        }
        if (currentField.getNeighbor(Direction.DOWN) != null) {
            Pushable neighbor = currentField.getNeighbor(Direction.DOWN).getPushable();
            if (neighbor != null) {
                if (!neighbor.isMovable()) {
                    notMovableAround++;
                    downerMovable = false;
                }
            }
        }
        if (notMovableAround >= 3) {
            immobilise();
        }
        if (!upperMovable && (!righterMovable || !lefterMovable)) {
            immobilise();
        }
        if (!downerMovable && (!righterMovable || !lefterMovable)) {
            immobilise();
        }
        System.out.println("END/////checkMovability" + this.name + "/////END");
    }

    @Override
    public boolean push(Worker worker, Direction direction, int neededStrength) {
        System.out.println("model.Crate, " + this.name + ", push, CurrentField:" + currentField.getName());

        if(!movable){
            return false;
        }

        neededStrength += this.getCurrentField().getSlipperiness();

        Field nextField = currentField.getNeighbor(direction);
        Pushable neighbor = nextField.getPushable();


        lastMovedBy = worker;
        if (neededStrength <= worker.getStrength()) {
            if (neighbor == null) {
                currentField.removePushable();
                nextField.visit(this);
                return true;
            } else {
                boolean success = neighbor.push(worker, direction, neededStrength);
                if (success) {
                    currentField.removePushable();
                    nextField.visit(this);
                    return true;
                } else {
                    //returns false, it cant be moved in that direction
                    return false;
                }
            }
        }
        else{
            return false;
        }
    }

    public Worker getLastMovedBy() {
        System.out.println("model.Crate, " + this.name + ", getLastMovedBy, CurrentField:" + currentField.getName());
        return this.lastMovedBy;
    }

    @Override
    public void destroy() {
        System.out.println("model.Crate, " + this.name + ", destroy, CurrentField:" + currentField.getName());
        watcher.decreaseCrates();
        setField(null);
    }

    @Override
    public String getOutPutString() {
        return "C";
    }
}
