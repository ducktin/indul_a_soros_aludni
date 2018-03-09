public class Worker implements Squeezable, Pushable {
    private Field currentField;
    private int points;
    private int id;
    private Watcher watcher;

    public void move(Direction direction) {
        System.out.printf("move");
    }

    public int getPoints() {
        System.out.println("getPoint");
        return points;
    }

    public void givePoint() {
        System.out.println("givePoints");
    }

    @Override
    public boolean push(Worker worker, Direction direction) {
        System.out.println("push");
        return false;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    @Override
    public void die() {
        System.out.println("die");
    }
}
