public interface Pushable {
    public boolean push(Worker worker, Direction direction);
    public void destroy();
}
