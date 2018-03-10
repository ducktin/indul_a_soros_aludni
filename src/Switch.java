public class Switch extends Field {
    private TrapHole trapHole;
    private boolean isActivated;

    public Switch(Pushable content, TrapHole trapHole) {
        super(content);
        this.trapHole=trapHole;
    }

    public TrapHole getTrapHole() {
        System.out.println("getTrapHole");
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
        super.visit(worker);
    }

    @Override
    public void visit(Crate crate) {
        super.visit(crate);
    }
}
