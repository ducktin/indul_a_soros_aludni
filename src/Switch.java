public class Switch extends Field {
    private TrapHole trapHole;
    private boolean isActivated;

    public TrapHole getTrapHole() {
        System.out.println("getTrapHole");
        return trapHole;
    }

    //change the trapHole to inactive
    @Override
    public void removePushable() {
        super.removePushable();

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
