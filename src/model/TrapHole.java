package model;

public class TrapHole extends Hole {

    private boolean status;
    
    private static int instances = 0;
    
    private static String nextName() {
        return "model.TrapHole-" + instances++;
    }
    
    public TrapHole(Pushable content) {
        this(content, nextName());
    }

    public TrapHole(Pushable content, String name) {
        super(content, name);
    }

    public boolean getStatus() {
        return status;
    }

    public void changeTrapStatus(boolean value) {
        status = value;
        if (status) {                 // If activated, then checks the content.
            if (content != null) {// If there is content, then it destroys it.
                content.destroy();
                setContent(null);
            }
        }
    }


    @Override
    public void visit(Worker worker) {
        setContent(worker);
        worker.setField(this);
        if (status) {
            worker.destroy();
            worker.setField(null);
            setContent(null);
        }
    }

    @Override
    public void visit(Crate crate) {
        setContent(crate);
        if (status) {
            crate.destroy();
            crate.setField(null);
            setContent(null);
        }
    }

    @Override
    public String getOutPutString() {
        return "T";
    }
}
