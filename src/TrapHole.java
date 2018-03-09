public class TrapHole extends Hole {

    private boolean status;

    public boolean getStatus(){
        System.out.println("getStatus");
        return false;
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
