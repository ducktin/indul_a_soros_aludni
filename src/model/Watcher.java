package model;

import control.Game;

public class Watcher {

    private static Watcher instance = null;
    protected Game game;
    private static int livingWorkers;
    private static int pushableCrates;
    private static int freeGoalFields;

    private Watcher() {
        //exists only to defeat instantiation
    }

    public static Watcher getInstance() {
        System.out.println("Witcher, getInstance");
        if (instance == null) {
            instance = new Watcher();
            livingWorkers=0;
            pushableCrates=0;
            freeGoalFields=0;
        }
        return instance;
    }

    public void increaseWorkers(){
        System.out.println("model.Watcher, decreaseWorkers");
        livingWorkers++;
    }

    public void increaseCrates(){
        System.out.println("model.Watcher, decreaseCrates");
        pushableCrates++;
    }

    public void increaseGoalField(){
        System.out.println("model.Watcher, decreaseGoalField");
        freeGoalFields++;
    }

    public void decreaseWorkers(){
        System.out.println("model.Watcher, decreaseWorkers");
        livingWorkers--;
        if(livingWorkers<=0){
            game.endGame();
            //TODO:end the game
        }
    }

    public void decreaseCrates(){
        System.out.println("model.Watcher, decreaseCrates");
        pushableCrates--;
        if(pushableCrates<=0){
            //TODO:end the game
            game.endGame();
        }
    }

    public void decreaseGoalField(){
        System.out.println("model.Watcher, decreaseGoalField");
        freeGoalFields--;
        if(freeGoalFields<=0){
            game.endGame();
            //TODO:end the game
        }
    }
}
