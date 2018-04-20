public class Switch extends Field {
    private TrapHole trapHole;
    private boolean isActivated;

    public Switch(Pushable content, TrapHole trapHole, String name) {
        super(content, name);
        this.trapHole=trapHole;
    }

    public TrapHole getTrapHole() {
        System.out.println("Switch, " + this.name + ", getTrapHole");
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
