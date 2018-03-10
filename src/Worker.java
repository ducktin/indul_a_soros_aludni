public class Worker implements Squeezable, Pushable {
    private Field currentField;
    private int points;
    private Integer id;
    private Watcher watcher;

    public Worker(Field field,int id, Watcher watcher){
        System.out.printf("Worker contructor");
        this.currentField=field;
        this.points=0;
        this.id = id;
        //this.watcher=watcher;
    }

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

    public Field getCurrentField() {
        System.out.println("getCurrentField");
        return currentField;
    }

    public Integer getId(){
        System.out.printf("getId");
        return id;
    }

    @Override
    public boolean push(Worker worker, Direction direction) { //test commit changes
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

    /*@Override
    public String toString() {
        return "Worker{" +
                "currentField=" + currentField +
                ", id=" + id +
                '}';
    }*/
}
