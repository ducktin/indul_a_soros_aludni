import java.util.EnumMap;

public class Field implements Visitable {

    protected Pushable content;
    protected EnumMap<Direction, Field> neighbors;

    public Field(Pushable content){
        this.content=content;
        neighbors=new EnumMap<Direction, Field>(Direction.class);
    }
    public Field(){
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
        content=null;
    }

    @Override
    public void visit(Worker worker) {
        System.out.println("visit(Worker worker)");
        this.setContent(worker); // The current worker is going to be the content.
    }

    @Override
    public void visit(Crate crate) {
        System.out.println("visit(Crate crate");
        this.setContent(crate); // The current crate is going to be the content.
    }


}
