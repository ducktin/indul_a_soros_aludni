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
        System.out.printf("Visit worker");
        setContent(worker);
        if(status){
            worker.destroy();
            setContent(null);
        }
    }

    @Override
    public void visit(Crate crate) {
        System.out.printf("Visit crate");
        setContent(crate);
        if(status){
            crate.destroy();
            setContent(null);
        }
    }
}
