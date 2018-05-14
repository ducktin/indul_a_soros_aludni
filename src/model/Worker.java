package model;

public class Worker implements Squeezable, Pushable {
    private Field currentField;
    private int points;
    private Watcher watcher;
    protected String name;
    private boolean alive = true;
    private int strength;
    private int honeyBombs = 3;
    private int oilBarrels = 3;
    private int playerNum =1;
    private static int globPlayNum=1;
    private static int instances = 0;

    private static String nextName() {
        return "model.Worker-" + instances++;
    }

    public Worker(Field field, int strength) {
        this(field, strength, nextName());
    }

    public Worker(Field field, int strength, String name) {
        this.currentField = field;
        this.points = 0;
        this.name = name;
        this.watcher = Watcher.getInstance();
        this.strength = strength;
        this.playerNum =globPlayNum;
        globPlayNum++;
    }

    public int getPlayerNum(){
     return playerNum;
    }

    public void move(Direction direction) {
        System.out.println("model.Worker, " + this.name + ", move, " + currentField.getName());
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
        return points;
    }

    public void givePoint() {
        points++;
    }

    public void setField(Field nextField) {
        this.currentField = nextField;
    }

    public Field getCurrentField() {
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
        } else {
            return false;
        }
    }

    @Override
    public void destroy() {
        watcher.decreaseWorkers();
        alive = false;
        currentField = null;
    }

    @Override
    public boolean isMovable() {
        return true;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void die() {
        watcher.decreaseWorkers();
        currentField.removePushable();
        alive = false;
    }

    public void dropOil() {
        if (oilBarrels > 0) {
            this.currentField.makeSlippery();
            this.oilBarrels--;
        }

    }

    public void dropHoney() {
        if (honeyBombs > 0) {
            this.currentField.makeSticky();
            this.honeyBombs--;
        }

    }

    @Override
    public String getOutPutString() {
        return "W";
    }
}
