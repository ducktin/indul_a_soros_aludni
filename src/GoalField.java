public class GoalField extends Field {

    @Override
    public void removePushable() {
        super.removePushable();
        //do nothing if occupied by a crate
    }

    @Override
    public void visit(Worker worker) {
        super.visit(worker);
    }

    @Override
    public void visit(Crate crate) {
        super.visit(crate);
    }
}
