public class GoalField extends Field {
    private Watcher watcher;

    public GoalField(Pushable content /*Watcher watcher*/) {
        super(content);
        System.out.printf("GoalField contructor");
        // watcher = watcher; TODO: add watcher
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


    }
}
