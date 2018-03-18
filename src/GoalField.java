public class GoalField extends Field {

    public GoalField(Pushable content) {
        super(content);
        System.out.printf("GoalField contructor");
    }

    @Override
    public void removePushable() {
        super.removePushable();
        //never called if a crate is on it, because that crate give back false in his push function
    }

    @Override
    public void visit(Worker worker) {
        super.visit(worker);
        //TODO:setContent(worker), and do nothing
    }

    @Override
    public void visit(Crate crate) {
        super.visit(crate);
        //TODO:setContent(crate), and give point to the worker, call immobilise on crate
        // ??? How do we know here, who pushed it? the crate got it, but didn't passed
    }
}
