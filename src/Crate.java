import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Crate implements Pushable {
    private Field currentField;
    private boolean movable;
    private Watcher watcher;

    public Field getCurrentField() {
        return currentField;
    }

    public boolean isMovable() {
        System.out.println("isMovable");
        return movable;
    }

    public void immobilise(){
        System.out.println("immobilise");
    }

    public boolean checkMovability(){
        System.out.println("checkMovability");
        return true;
    }

    @Override
    public boolean push(Worker worker, Direction direction) {
        System.out.printf("push");
        return false;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
