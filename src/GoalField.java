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
        this.setContent(worker); // The content is the current worker, but nothing happens.
    }

    @Override
    public void visit(Crate crate) {
        super.visit(crate);
        //TODO:setContent(crate), give point to the worker, call immobilise on crate, decrease the number of the crates.
        // ??? How do we know here, who pushed it? the crate got it, but didn't passed
        this.setContent(crate);

    }
}
