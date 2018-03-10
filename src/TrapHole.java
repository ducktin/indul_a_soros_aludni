public class TrapHole extends Hole {

    private boolean status;

    public TrapHole(Pushable content) {
        super(content);
    }

    public boolean getStatus(){
        System.out.println("getStatus");
        return status;
    }

    public void changeTrapStatus(boolean value){
        System.out.println("changeTrapStatus");
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
