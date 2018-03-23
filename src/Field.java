

import java.util.EnumMap;

public class Field implements Visitable {

    protected Pushable content;
    protected EnumMap<Direction, Field> neighbors;
    protected String name;
    private int slipperiness = 0;

    public Field(Pushable content, String name) {
        System.out.println("Field, " + name + " constructor");
        this.content = content;
        neighbors = new EnumMap<>(Direction.class);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Field getNeighbor(Direction direction) {
        System.out.println("Field, " + this.name + ", getNeighbor");
        return neighbors.get(direction);
    }

    public void setNeighbor(Direction direction, Field field) {
        System.out.println("Field, " + this.name + ", setNeighbor");
        neighbors.put(direction, field);
    }

    public Pushable getPushable() {
        System.out.println("Field, " + this.name + ", getPushable");
        return content;
    }

    public void setContent(Pushable pushable) {
        if (pushable != null) {
            System.out.println("Field, " + this.name + ", setContent, content: " + pushable.getName());
        } else {
            System.out.println("Field, " + this.name + ", setContent, content: " + "NULL");
        }

        this.content = pushable;
    }

    public void removePushable() {
        System.out.println("Field, " + this.name + ", removePushable");
        content = null;
    }

    @Override
    public void visit(Worker worker) {
        System.out.println("Field, " + this.name + ", visit(Worker worker), object: " + worker.getName());
        this.setContent(worker);// The current worker is going to be the content.
        worker.setField(this);
    }

    @Override
    public void visit(Crate crate) {
        System.out.println("Field, " + this.name + ", visit(Crate crate), object: " + crate.getName());
        this.setContent(crate);// The current crate is going to be the content.
        crate.setField(this);
        crate.checkMovability();
    }

    public int getSlippiness() {
        System.out.println("Field, " + this.name + ", getSlippiness");
        return slipperiness;
    }

    public void makeSlippery() {
        System.out.println("Field, " + this.name + ", makeSlippery");
        this.slipperiness = -1;
    }

    public void makeSticky() {
        System.out.println("Field, " + this.name + ", makeSlippery");
        this.slipperiness = 1;
    }
}
