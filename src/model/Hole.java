package model;

public class Hole extends Field {
    
    private static int instances = 0;
    
    private static String nextName() {
        return "model.Hole-" + instances++;
    }
    
    public Hole(Pushable content) {
        this(content, nextName());
    }
    
    public Hole(Pushable content, String name) {
        super(content, name);
    }
    
    //destroys things
    @Override
    public void setContent(Pushable pushable) {
        super.setContent(pushable);
    }
    
    @Override
    public void visit(Worker worker) {
        super.visit(worker);
        content.destroy();
        setContent(null);
    }
    
    @Override
    public void visit(Crate crate) {
        System.out.println("HOOOLE");
        super.visit(crate);
        content.destroy();
        setContent(null);
    }
    
    @Override
    public String getOutPutString() {
        return "H";
    }
    
    @Override
    //Hole doesnt have a slippiness
    public void makeSlippery() {
        return;
    }
    
    @Override
    //Hole doesnt have a slippiness
    public void makeSticky() {
        return;
    }
}
