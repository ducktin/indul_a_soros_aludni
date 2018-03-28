public class Wall implements Pushable{

    public Wall(){
        System.out.println("Wall constructor");
    }

    public boolean isMovable() {
        System.out.println("Wall, isMovable");
        return false;
    }

    @Override
    public String getName() {
        return null;
    }

    //always false
    @Override
    public boolean push(Worker worker, Direction direction, int neededStrength) {
        System.out.println("Wall, push");
        return false;
    }

    @Override
    public void destroy() {
        //never called
        System.out.println("Wall, destroy");
    }
}
