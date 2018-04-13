public class Worker implements Squeezable, Pushable {
    private Field currentField;
    private int points;
    private Integer id;
    private Watcher watcher;
    protected String name;
    private boolean alive = true;
    private int strength;
    private int honeyBombs = 3;
    private int oilBarrels = 3;

    public Worker(Field field, String name ,int strength) {
        System.out.println("Worker, " + name + ", constructor, " + field.getName());
        this.currentField = field;
        this.points = 0;
        this.name = name;
        this.watcher = Watcher.getInstance();
        this.strength = strength;
    }


    public void move(Direction direction) {
        System.out.println("Worker, " + this.name + ", move, " + currentField.getName());
        Field nextField = currentField.getNeighbor(direction);
        Pushable neighbor = nextField.getPushable();
        int neededStrength = 0;
        if (neighbor == null) {
            currentField.removePushable();
            nextField.visit(this);
        } else {
            boolean success = neighbor.push(this, direction, neededStrength);
            if (success) {
                currentField.removePushable();
                nextField.visit(this);
            }
        }
    }

    public int getPoints() {
        System.out.println("Worker, " + this.name + ", getPoints, " + currentField.getName());
        return points;
    }

    public void givePoint() {
        System.out.println("Worker, " + this.name + ", givePoint, " + currentField.getName());
        points++;
    }

    public void setField(Field nextField) {
        System.out.println("Worker, " + this.name + ", setField from: " + currentField.getName() + " to: " + nextField.getName());
        this.currentField = nextField;
    }

    public Field getCurrentField() {
        System.out.println("Worker, " + this.name + ", getCurrentField, " + currentField.getName());
        return currentField;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public boolean push(Worker worker, Direction direction, int neededStrength) {
        System.out.println("Worker, " + this.name + ", push, " + currentField.getName());

        //Add the current field slippiness to the needed Strength to push the chain
        neededStrength += this.getCurrentField().getSlipperiness();

        Field nextField = currentField.getNeighbor(direction);
        Pushable neighbor = nextField.getPushable();



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
                    //returns true, because the cornered worker was squeezed, so there's place now where things can be pushed to
                    die();
                    return true;
                }
            }
        }
        else{
            return false;
        }
    }

    @Override
    public void destroy() {
        System.out.println("Worker, " + this.name + ", destroy, " + currentField.getName());
        watcher.decreaseWorkers();
        alive = false;
        currentField = null;
    }

    @Override
    public boolean isMovable() {
        System.out.println("Worker, " + this.name + ", isMovable, " + currentField.getName());
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void die() {
        System.out.println("Worker, " + this.name + ", die, " + currentField.getName());
        watcher.decreaseWorkers();
        currentField.removePushable();
        alive = false;
    }

    public void dropOil() {
        System.out.println("Worker, " + this.name + ", dropOil, " + currentField.getName());
        this.currentField.makeSlippery();
    }

    public void dropHoney() {
        System.out.println("Worker, " + this.name + ", dropHoney, " + currentField.getName());
        this.currentField.makeSticky();
    }
}
