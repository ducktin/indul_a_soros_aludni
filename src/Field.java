import java.util.EnumMap;

public class Field implements Visitable {

    protected Pushable content;
    protected EnumMap<Direction, Field> neighbors;

    /*public Field getNeighbor(Direction direction){
        System.out.println("getNeighbor");
    }

    public Pushable getPushable(){
        System.out.println("getPushable");
    }*/

    public void setContent(){
        System.out.println("setContent");
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
