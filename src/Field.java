import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.util.EnumMap;

public class Field implements Visitable {

    protected Pushable content;
    protected EnumMap<Direction, Field> neighbors;

    public Field(Pushable content){

        this.content=content;
        neighbors=new EnumMap<Direction, Field>(Direction.class);
    }

    public Field getNeighbor(Direction direction){
        System.out.println("getNeighbor");
        return neighbors.get(direction);
    }

    public Pushable getPushable(){
        System.out.println("getPushable");
        return content;
    }

    public void setContent(Pushable pushable){
        System.out.println("setContent");
        this.content=pushable;
    }

    public void removePushable(){
        System.out.println("removePushable");
    }

    @Override
    public void visit(Worker worker) {
        System.out.println("visit(Worker worker)");
    }

    @Override
    public void visit(Crate crate) {
        System.out.println("visit(Crate crate");
    }


}
