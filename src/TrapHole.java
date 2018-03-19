public class TrapHole extends Hole {

    private boolean status;

    public TrapHole(Pushable content, String name) {
        super(content, name);
    }

    public boolean getStatus(){
        System.out.println("TrapHole, " + this.name + ", getStatus");
        return status;
    }

    public void changeTrapStatus(boolean value){
        if(value){System.out.println("TrapHole, " + this.name + ", changeTrapStatus, new status: true");}
        else{System.out.println("TrapHole, " + this.name + ", changeTrapStatus, new status: false");}
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
        worker.setField(this);
        if(status){
            worker.destroy();
            worker.setField(null);
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
