public class TrapHole extends Hole {

    private boolean status;

    public TrapHole(Pushable content, String name) {
        super(content, name);
    }

    public boolean getStatus(){
        System.out.println("getStatus of"+this.name);
        return status;
    }

    public void changeTrapStatus(boolean value){
        System.out.println("changeTrapStatus "+this.name);
        status=value;
        if(status){                 // If activated, then checks the content.
            if(content!=null) {     // If there is content, then it destroys it.
                content.destroy();
                setContent(null);
            }
        }
    }


    @Override
    public void visit(Worker worker) {
        System.out.printf(this.name+" Visit worker");
        setContent(worker);
        if(status){
            worker.destroy();
            setContent(null);
        }
    }

    @Override
    public void visit(Crate crate) {
        System.out.printf(this.name+" Visit crate");
        setContent(crate);
        if(status){
            crate.destroy();
            setContent(null);
        }
    }
}
