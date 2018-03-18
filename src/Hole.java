public class Hole extends Field {


    public Hole(Pushable content) {
        super(content);
    }

    //destroys things
    @Override
    public void setContent(Pushable pushable) {
        super.setContent(pushable);
    }

    @Override
    public void visit(Worker worker) {
        super.visit(worker);
        content.destroy();
        setContent(null);
    }

    @Override
    public void visit(Crate crate) {
        super.visit(crate);
        content.destroy();
        setContent(null);
    }
}
