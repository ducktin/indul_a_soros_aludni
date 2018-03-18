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
        livingWorkers--;
    }

    public void decreaseCrates(){
        System.out.printf("decreaseCrates");
        pushableCrates--;
    }

    public void decreaseGoalField(){
        System.out.printf("decreaseGoalField");
        freeGoalFields--;
    }
}
