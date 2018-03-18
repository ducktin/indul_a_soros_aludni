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
        //TODO: decrease the number of the workers
        this.setContent(worker);
        content.destroy();
    }

    @Override
    public void visit(Crate crate) {
        super.visit(crate);
        //TODO: decrease the nuber of the crates
        this.setContent(crate);
        content.destroy();
    }
}
