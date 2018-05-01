package model;

public class Switch extends Field {
    private TrapHole trapHole;
    private boolean isActivated;
    
    private static int instances = 0;
    
    private static String nextName(){
        return "model.Switch-" + instances++;
    }
    
    public Switch(Pushable content, TrapHole trapHole) {
        this(content, trapHole, nextName());
    }
    
    public Switch(Pushable content, TrapHole trapHole, String name) {
        super(content, name);
        this.trapHole=trapHole;
    }

    public TrapHole getTrapHole() {
        System.out.println("model.Switch, " + this.name + ", getTrapHole");
        return trapHole;
    }

    //change the trapHole to inactive
    @Override
    public void removePushable() {
        super.removePushable();
        trapHole.changeTrapStatus(false);
    }

    @Override
    public void visit(Worker worker) {
        super.visit(worker); // The content is the current worker, and nothing else happens.
    }

    @Override
    public void visit(Crate crate) {
        super.visit(crate);
        trapHole.changeTrapStatus(true);
    }

    @Override
    public String getOutPutString() {
        return "S";
    }
}
