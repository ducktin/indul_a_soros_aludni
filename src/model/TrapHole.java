package model;

public class TrapHole extends Hole {

    private boolean status;
    
    private static int instances = 0;
    
    private static String nextName(){
        return "model.TrapHole-" + instances++;
    }
    
    public TrapHole(Pushable content) {
        this(content, nextName());
    }

    public TrapHole(Pushable content, String name) {
        super(content, name);
    }

    public boolean getStatus(){
        System.out.println("model.TrapHole, " + this.name + ", getStatus");
        return status;
    }

    public void changeTrapStatus(boolean value){
        if(value){System.out.println("model.TrapHole, " + this.name + ", changeTrapStatus, new status: true");}
        else{System.out.println("model.TrapHole, " + this.name + ", changeTrapStatus, new status: false");}
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
        //System.out.printf(this.name+" Visit worker");
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

    @Override
    public String getOutPutString() {
        return "T";
    }
}
