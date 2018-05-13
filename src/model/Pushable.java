package model;

public interface Pushable {
    boolean push(Worker worker, Direction direction, int neededStrength);
    
    void destroy();
    
    boolean isMovable();
    
    String getName();
    
    String getOutPutString();
}
