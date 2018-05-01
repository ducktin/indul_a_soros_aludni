package model;

import java.util.EnumMap;

public class Field implements Visitable {


    protected Pushable content;
    protected EnumMap<Direction, Field> neighbors;
    protected String name;
    protected int slipperiness = 1;
    private static int instances = 0;

    private static String nextName() {
        return "model.Field-" + instances++;
    }

    public Field(Pushable content) {
        this(content, nextName());
    }

    public Field(Pushable content, String name) {
        System.out.println("model.Field, " + name + " constructor");
        this.content = content;
        neighbors = new EnumMap<>(Direction.class);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Field getNeighbor(Direction direction) {
        System.out.println("model.Field, " + this.name + ", getNeighbor");
        return neighbors.get(direction);
    }

    public void setNeighbor(Direction direction, Field field) {
        System.out.println("model.Field, " + this.name + ", setNeighbor");
        neighbors.put(direction, field);
    }

    public Pushable getPushable() {
        //System.out.println("model.Field, " + this.name + ", getPushable");
        return content;
    }

    public void setContent(Pushable pushable) {
        if (pushable != null) {
            System.out.println("model.Field, " + this.name + ", setContent, content: " + pushable.getName());
        } else {
            System.out.println("model.Field, " + this.name + ", setContent, content: " + "NULL");
        }

        this.content = pushable;
    }

    public void removePushable() {
        System.out.println("model.Field, " + this.name + ", removePushable");
        content = null;
    }

    @Override
    public void visit(Worker worker) {
        System.out.println("model.Field, " + this.name + ", visit(model.Worker worker), object: " + worker.getName());
        this.setContent(worker);// The current worker is going to be the content.
        worker.setField(this);
    }

    @Override
    public void visit(Crate crate) {
        System.out.println("model.Field, " + this.name + ", visit(model.Crate crate), object: " + crate.getName());
        this.setContent(crate);// The current crate is going to be the content.
        crate.setField(this);
        crate.checkMovability();
    }

    public int getSlipperiness() {
        System.out.println("model.Field, " + this.name + ", getSlipperiness");
        return slipperiness;
    }

    public void setSlipperiness(int slipperiness){
        this.slipperiness=slipperiness;
    }

    public void makeSlippery() {
        System.out.println("model.Field, " + this.name + ", makeSlippery");
        if (slipperiness >= 1) {
            this.slipperiness--;
        }
    }

    public void makeSticky() {
        System.out.println("model.Field, " + this.name + ", makeSlippery");
        if (slipperiness <= 1) {
            this.slipperiness++;
        }
    }

    public String getOutPutString() {
        return null;
    }
}
