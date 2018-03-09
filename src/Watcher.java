public class Watcher {

    private static Watcher instance = null;
    private Game game;
    private int livingWorkers;
    private int pushableCrates;
    private int freeGoalFields;

    protected Watcher() {
        //exists only to defeat instantiation
    }

    public static Watcher getInstance() {
        System.out.println("getInstance");
        if (instance == null) {
            instance = new Watcher();
        }
        return instance;
    }

    public void decreaseWorkers(){
        System.out.printf("decreaseWorkers");
    }

    public void decreaseCrates(){
        System.out.printf("decreaseCrates");
    }

    public void decreaseGoalField(){
        System.out.printf("decreaseGoalField");
    }
}
