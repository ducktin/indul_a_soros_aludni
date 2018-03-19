public class Watcher {

    private static Watcher instance = null;
    private Game game;
    private int livingWorkers;
    private int pushableCrates;
    private int freeGoalFields;

    private Watcher() {
        //exists only to defeat instantiation
    }

    public static Watcher getInstance() {
        System.out.println("Witcher, getInstance");
        if (instance == null) {
            instance = new Watcher();
        }
        return instance;
    }

    public void decreaseWorkers(){
        System.out.println("Watcher, decreaseWorkers");
        livingWorkers--;
    }

    public void decreaseCrates(){
        System.out.println("Watcher, decreaseCrates");
        pushableCrates--;
    }

    public void decreaseGoalField(){
        System.out.println("Watcher, decreaseGoalField");
        freeGoalFields--;
    }
}
