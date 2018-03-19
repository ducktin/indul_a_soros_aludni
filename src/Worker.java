public class Worker implements Squeezable, Pushable {
    private Field currentField;
    private int points;
    private Integer id;
    private Watcher watcher;
    protected String name;
    private boolean alive = true;

    public Worker(Field field, String name){
        System.out.println("Worker, " + name + ", constructor, " + field.getName());
        this.currentField=field;
        this.points=0;
        this.name = name;
        this.watcher=Watcher.getInstance();
    }

    public void move(Direction direction) {
        System.out.println("Worker, " + this.name + ", move, " + currentField.getName());
        Field nextField = currentField.getNeighbor(direction);
        Pushable neighbor = nextField.getPushable();
        if(neighbor==null){
            currentField.removePushable();
            nextField.visit(this);
        }
        else{
            boolean success = neighbor.push(this, direction);
            if(success){
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

    public void setField(Field nextField){
        System.out.println("Worker, " + this.name + ", setField from: " + currentField.getName() + " to: " + nextField.getName());
        this.currentField=nextField;
    }

    public Field getCurrentField() {
        System.out.println("Worker, " + this.name + ", getCurrentField, " + currentField.getName());
        return currentField;
    }


    @Override
    public boolean push(Worker worker, Direction direction) {
        System.out.println("Worker, " + this.name + ", push, " + currentField.getName());

        Field nextField = currentField.getNeighbor(direction);
        Pushable neighbor = nextField.getPushable();

        if(neighbor==null){
            currentField.removePushable();
            nextField.visit(this);
            return true;
        }else{
            boolean success = neighbor.push(worker, direction);
            if(success){
                currentField.removePushable();
                nextField.visit(this);
                return true;
            }else{
                //returns true, because the cornered worker was squeezed, so there's place now where things can be pushed to
                die();
                return true;
            }
        }
    }

    @Override
    public void destroy() {
        System.out.println("Worker, " + this.name + ", destroy, " + currentField.getName());
        watcher.decreaseWorkers();
        alive = false;
        currentField=null;
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
        alive= false;
    }
}
