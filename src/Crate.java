
public class Crate implements Pushable {
    private Field currentField;
    private boolean movable;
    private Watcher watcher;
    private Worker lastMovedBy;
    private String name;

    public Crate(Field field, String name /*,Watcher watcher*/){
        System.out.println("Crate constructor");
        this.currentField=field;
        movable=true;
        name = name;
        //this.watcher=watcher;
    }

    public void setField(Field field){
        this.currentField=field;
    }

    public Field getCurrentField() {
        System.out.println("getCurrentField of "+this.name);
        return currentField;
    }

    public boolean isMovable() {
        System.out.println(this.name+" isMovable?");
        return movable;
    }

    public void immobilise(){
        System.out.println("immobilise "+this.name);
        movable=false;
        watcher.decreaseCrates();
    }

    public void checkMovability(){
        System.out.println("checkMovability of "+this.name);
        int notMovableAround =0;
        boolean upperMovable=true;
        boolean righterMovable=true;
        boolean lefterMovable=true;
        boolean downerMovable=true;

        Pushable neighbor = currentField.getNeighbor(Direction.UP).getPushable();
        if(neighbor!=null){
            if(!neighbor.isMovable()){
                notMovableAround++;
                upperMovable=false;
            }
        }

        neighbor = currentField.getNeighbor(Direction.RIGHT).getPushable();
        if(neighbor!=null){
            if(!neighbor.isMovable()){
                notMovableAround++;
                righterMovable=false;
            }
        }
        neighbor = currentField.getNeighbor(Direction.LEFT).getPushable();
        if(neighbor!=null){
            if(!neighbor.isMovable()){
                notMovableAround++;
                lefterMovable=false;
            }
        }
        neighbor = currentField.getNeighbor(Direction.DOWN).getPushable();
        if(neighbor!=null){
            if(!neighbor.isMovable()){
                notMovableAround++;
                downerMovable=false;
            }
        }
        if(notMovableAround>=3){
            immobilise();
        }
        if(upperMovable && (righterMovable || lefterMovable)){
            immobilise();
        }
        if(downerMovable && (righterMovable || lefterMovable)){
            immobilise();
        }
    }

    @Override
    public boolean push(Worker worker, Direction direction) {
        System.out.printf("push "+this.name);
        Field nextField = currentField.getNeighbor(direction);
        Pushable neighbor = nextField.getPushable();
        lastMovedBy = worker;

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
                //returns false, it cant be moved in that direction
                return false;
            }
        }
    }

    public Worker getLastMovedBy(){
        System.out.println("Get last moved by of "+this.name);
        return this.lastMovedBy;

    }

    @Override
    public void destroy() {
        System.out.println("destroy "+this.name);
        watcher.decreaseCrates();
        setField(null);
    }
}
