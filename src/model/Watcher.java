package model;

import control.Game;

public class Watcher {

    private static Watcher instance = null;
    private Game game;
    private int livingWorkers;
    private int pushableCrates;
    private int freeGoalFields;

    //TODO:Initialize the attributes-->make them static?

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
        System.out.println("model.Watcher, decreaseWorkers");
        livingWorkers--;
    }

    public void decreaseCrates(){
        System.out.println("model.Watcher, decreaseCrates");
        pushableCrates--;
    }

    public void decreaseGoalField(){
        System.out.println("model.Watcher, decreaseGoalField");
        freeGoalFields--;
    }
}
