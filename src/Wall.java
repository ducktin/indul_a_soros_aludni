public class Wall implements Pushable{

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
