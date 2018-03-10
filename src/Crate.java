import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Crate implements Pushable {
    private Field currentField;
    private boolean movable;
    private Watcher watcher;

    public Crate(Field field,Watcher watcher){
        System.out.println("Crate constructor");
        this.currentField=field;
        movable=true;
        //this.watcher=watcher;
    }

    public Field getCurrentField() {
        System.out.println("getCurrentField");
        return currentField;
    }

    public boolean isMovable() {
        System.out.println("isMovable");
        return movable;
    }

    public void immobilise(){
        System.out.println("immobilise");
        movable=false;
    }

    public boolean checkMovability(){
        System.out.println("checkMovability");
        return true;
    }

    @Override
    public boolean push(Worker worker, Direction direction) {
        System.out.printf("push");
        //TODO: ezt így kellene? Itt kellene megkérdezni a felhasználót, hogy van, e valami a következp field-en? Akkor is kell ide egy if

        //currentField.getNeighbor(direction).getPushable();
        return true;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }

    /*@Override
    public String toString() {
        return "Crate{" +
                "currentField=" + currentField +
                ", movable=" + movable +
                '}';
    }*/
}
