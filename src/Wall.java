public class Wall implements Pushable{

    public Wall(){
        System.out.println("Wall constructor");
    }

    public boolean isMovable() {
        System.out.println("isMovable");
        return false;
    }

    //always false
    @Override
    public boolean push(Worker worker, Direction direction) {
        System.out.println("push");
        return false;
    }

    @Override
    public void destroy() {
        //never called
        System.out.println("destroy");
    }
}
