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
        this.content = content;
        neighbors = new EnumMap<>(Direction.class);
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    public Field getNeighbor(Direction direction) {
        return neighbors.get(direction);
    }
    
    public void setNeighbor(Direction direction, Field field) {
        neighbors.put(direction, field);
    }
    
    public Pushable getPushable() {
        return content;
    }
    
    public void setContent(Pushable pushable) {
        this.content = pushable;
    }
    
    public void removePushable() {
        content = null;
    }
    
    @Override
    public void visit(Worker worker) {
        this.setContent(worker);// The current worker is going to be the content.
        worker.setField(this);
    }
    
    @Override
    public void visit(Crate crate) {
        this.setContent(crate);// The current crate is going to be the content.
        crate.setField(this);
        crate.checkMovability();
    }
    
    public int getSlipperiness() {
        return slipperiness;
    }
    
    public void setSlipperiness(int slipperiness) {
        this.slipperiness = slipperiness;
    }
    
    public void makeSlippery() {
        if (slipperiness >= 1) {
            this.slipperiness--;
        }
    }
    
    public void makeSticky() {
        if (slipperiness <= 1) {
            this.slipperiness++;
        }
    }
    
    public String getOutPutString() {
        return null;
    }
}
