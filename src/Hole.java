public class Hole extends Field {
    
    private static int instances = 0;
    
    private static String nextName(){
        return "Hole-" + instances++;
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
        super.visit(crate);
        content.destroy();
        setContent(null);
    }

    @Override
    public String getOutPutString() {
        return "H";
    }
}
