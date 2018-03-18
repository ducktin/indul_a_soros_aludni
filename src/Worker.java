public class Worker implements Squeezable, Pushable {
    private Field currentField;
    private int points;
    private Integer id;
    private Watcher watcher;
    protected String name;

    public Worker(Field field, String name/*, int id, Watcher watcher*/){
        System.out.println("Worker constructor");
        this.currentField=field;
        this.points=0;
        this.name = name;
        //this.id = id;
        //this.watcher=watcher;
    }

    public void move(Direction direction) {
        System.out.println("move "+this.name);
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
        System.out.println("getPoint of"+this.name);
        return points;
    }

    public void givePoint() {
        System.out.println("givePoints to "+this.name);
        points++;
    }

    public void setField(Field nextField){
        System.out.println("setField of "+this.name);
        this.currentField=nextField;
    }

    public Field getCurrentField() {
        System.out.println("getCurrentField of "+this.name);
        return currentField;
    }

    /*public Integer getId(){
        System.out.printf("getId");
        return id;
    }*/

    @Override
    public boolean push(Worker worker, Direction direction) {
        System.out.println("push "+this.name);

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
        System.out.println("destroy "+this.name);
        watcher.decreaseWorkers();
        //TODO:disappear and be nothing, but do not delete from map workers list
        //Maybe put them on a field, which is outside of the map and not shown? AND disable input
    }

    @Override
    public boolean isMovable() {
        System.out.println("isMovable "+this.name);
        return true;
    }

    @Override
    public void die() {
        System.out.println("die "+this.name);
        watcher.decreaseWorkers();
        currentField.removePushable();
        //TODO:disappear and be nothing, but do not delete from map workers list
        //Maybe put them on a field, which is outside of the map and not shown? AND disable input
    }
}
