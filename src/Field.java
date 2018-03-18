

import java.util.EnumMap;

public class Field implements Visitable {

    protected Pushable content;
    protected EnumMap<Direction, Field> neighbors;
    protected String name;

    public Field(Pushable content, String name){
        this.content=content;
        neighbors=new EnumMap<Direction, Field>(Direction.class);
        name = name;
    }

    public Field getNeighbor(Direction direction){
        System.out.println("getNeighbor of "+this.name);
        return neighbors.get(direction);
    }

    public Pushable getPushable(){
        System.out.println("getPushable "+this.name);
        return content;
    }

    public void setContent(Pushable pushable){
        System.out.println("setContent of "+this.name);
        this.content=pushable;
    }

    public void removePushable(){
        System.out.println("removePushable of "+this.name);
        content=null;
    }

    @Override
    public void visit(Worker worker) {
        System.out.println("visit(Worker worker) "+this.name);
        this.setContent(worker); // The current worker is going to be the content.
    }

    @Override
    public void visit(Crate crate) {
        System.out.println("visit(Crate crate) "+this.name);
        this.setContent(crate); // The current crate is going to be the content.
        crate.checkMovability();
    }


}
