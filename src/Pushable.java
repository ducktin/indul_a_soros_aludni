public interface Pushable {
    public boolean push(Worker worker, Direction direction, int neededStrength);
    public void destroy();
    boolean isMovable();
    String getName();
}
