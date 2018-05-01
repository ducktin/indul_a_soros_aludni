package model;

public class GoalField extends Field {
    private Watcher watcher;
    
    private static int instances = 0;
    
    private static String nextName(){
        return "model.GoalField-" + instances++;
    }
    
    public GoalField(Pushable content) {
        this(content, nextName());
    }
    
    public GoalField(Pushable content, String name) {
        super(content, name);
        System.out.printf("model.GoalField, " + this.name + "constructor");
        this.watcher = Watcher.getInstance();
    }

    @Override
    public void removePushable() {
        super.removePushable();
        //never called if a crate is on it, because that crate give back false in his push function
    }

    @Override
    public void visit(Worker worker) {
        super.visit(worker);
    }

    @Override
    public void visit(Crate crate) {
        super.visit(crate);
        crate.getLastMovedBy().givePoint();
        crate.immobilise();
        watcher.decreaseGoalField();
    }

    @Override
    public String getOutPutString() {
        return "G";
    }
}
