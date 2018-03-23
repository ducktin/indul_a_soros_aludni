import java.util.Scanner;

public class Skeleton {
    public static String[] options = {
            "5.4.1 Worker Moves to Empty Field",
            "5.4.2 Worker Moves towards Wall",
            "5.4.3 Worker Moves into Hole",
            "5.4.4 Worker Moves onto Switch",
            "5.4.5 Worker Moves onto GoalField",
            "5.4.6 Worker Pushes Crate to Empty Field",
            "5.4.7 Worker Pushes two Crates to an Empty Field",
            "5.4.8 Worker Pushes Crate to a Hole",
            "5.4.9 Worker Pushes Crate to Wall",
            "5.4.10 Worker Pushes Crate on a Switch",
            "5.4.11 Worker Pushes Crate onto a GoalField",
            "5.4.12 Worker Pushes Worker to an Empty Field",
            "5.4.13 Worker Pushes Crate Pushes Worker to a Wall"
    };

    private static Scanner in = new Scanner(System.in);

    private static void waitInput(String wait){
        String typed = "";
        while(!typed.equalsIgnoreCase(wait)){
            System.out.print("Type \""+wait+"\": ");
            typed = in.nextLine();
        }

    }

    public static void printOptions() {
        for (int i = 0; i < Skeleton.options.length; i++) {
            // String index = String.valueOf(i + 1) + ". ";
            System.out.println(Skeleton.options[i]);
        }
    }

    public static void invoke(int choice) {
        switch (choice) {
            case 1:
                workerMovesToEmptyField();
                break;
            case 2:
                workerMovesTowardsWall();
                break;
            case 3:
                workerMovesIntoHole();
                break;
            case 4:
                WorkerMovesOntoSwitch();
                break;
            case 5:
                WorkerMovesOntoGoalField();
                break;
            case 6:
                WorkerPushesCrateToEmptyField();
                break;
            case 7:
                WorkerPushesTwoCrateToEmptyField();
                break;
            case 8:
                WorkerPushesCrateIntoHole();
                break;
            case 9:
                WorkerPushesCrateToWall();
                break;
            case 10:
                WorkerPushesCrateOnSwitch();
                break;
            case 11:
                WorkerPushesCrateOntoGoalField();
                break;
            case 12:
                WorkerPushesWorkerToEmptyField();
                break;
            case 13:
                WorkerPushesCratePushesWorkerToWall();
                break;
            default:
                return;
        }
    }

    private static void workerMovesToEmptyField() {
        System.out.println("Setting up workerMovesToEmptyField");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        Field workerNeighbourField = new Field(null, "workerNeighbourField");
        workerField.setNeighbor(Direction.RIGHT, workerNeighbourField);
        workerNeighbourField.setNeighbor(Direction.LEFT, workerField);

        // Worker setup
        Worker w = new Worker(workerField, "w");
        workerField.setContent(w);

        // Map setup
        Map map = new Map(2,1);
        map.addField(0,0, workerField);
        map.addField(0,1,workerNeighbourField);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);

        System.out.println("End of workerMovesToEmptyField");
        in.nextLine();
    }

    private static void workerMovesTowardsWall() {
        System.out.println("Setting up workerMovesTowardsWall");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        Field wallField = new Field(null, "wallField");
        workerField.setNeighbor(Direction.RIGHT, wallField);
        wallField.setNeighbor(Direction.LEFT, workerField);

        // Worker setup
        Worker w = new Worker(workerField, "w");
        workerField.setContent(w);

        // Wall setup
        Wall wall = new Wall();
        wallField.setContent(wall);

        // Map setup
        Map map = new Map(2,1);
        map.addField(0,0, workerField);
        map.addField(0,1,wallField);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);

        System.out.println("End of workerMovesTowardsWall");
        in.nextLine();
    }

    private static void workerMovesIntoHole() {
        System.out.println("Setting up workerMovesIntoHole");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        Hole hole = new Hole(null, "hole");
        workerField.setNeighbor(Direction.RIGHT, hole);
        hole.setNeighbor(Direction.LEFT, workerField);

        // Worker setup
        Worker w = new Worker(workerField, "w");
        workerField.setContent(w);

        // Map setup
        Map map = new Map(2,1);
        map.addField(0,0, workerField);
        map.addField(0,1, hole);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);

        System.out.println("End of workerMovesIntoHole");
        in.nextLine();
    }

    private static void WorkerMovesOntoSwitch() {
        System.out.println("Setting up WorkerMovesOntoSwitch");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        TrapHole traphole = new TrapHole(null, "traphole");
        Switch swch = new Switch(null, traphole, "swich");
        workerField.setNeighbor(Direction.RIGHT, swch);
        swch.setNeighbor(Direction.LEFT, workerField);
        swch.setNeighbor(Direction.RIGHT, traphole);
        traphole.setNeighbor(Direction.LEFT, swch);

        // Worker setup
        Worker w = new Worker(workerField, "w");
        workerField.setContent(w);

        // Map setup
        Map map = new Map(3,1);
        map.addField(0,0, workerField);
        map.addField(0,1, swch);
        map.addField(0,2, traphole);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);

        System.out.println("End of WorkerMovesOntoSwitch");
        in.nextLine();
    }

    private static void WorkerMovesOntoGoalField(){
        System.out.println("Setting up WorkerMovesOntoGoalField");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        GoalField goalField = new GoalField(null, "goalField");
        workerField.setNeighbor(Direction.RIGHT, goalField);
        goalField.setNeighbor(Direction.LEFT, workerField);

        // Worker setup
        Worker w = new Worker(workerField, "w");
        workerField.setContent(w);

        // Map setup
        Map map = new Map(2,1);
        map.addField(0,0, workerField);
        map.addField(0,1, goalField);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);


        System.out.println("End of WorkerMovesOntoGoalField");
        in.nextLine();
    }

    private static void WorkerPushesCrateToEmptyField(){
        System.out.println("Setting up WorkerPushesCrateToEmptyField");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        Field crateField = new Field(null, "crateField");
        Field crateNeighbourField = new Field(null, "crateNeighbourField");
        workerField.setNeighbor(Direction.RIGHT, crateField);
        crateField.setNeighbor(Direction.LEFT, workerField);
        crateField.setNeighbor(Direction.RIGHT, crateNeighbourField);
        crateNeighbourField.setNeighbor(Direction.LEFT, crateField);

        // Worker setup
        Worker w = new Worker(workerField, "worker");
        workerField.setContent(w);

        // Crate setup
        Crate c = new Crate(crateField, "crate");
        crateField.setContent(c);

        // Map setup
        Map map = new Map(3,1);
        map.addField(0,0, workerField);
        map.addField(0,1,crateField);
        map.addField(0,2,crateNeighbourField);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);

        System.out.println("End of WorkerPushesCrateToEmptyField");
        in.nextLine();
    }

    private static void WorkerPushesTwoCrateToEmptyField(){
        System.out.println("Setting up WorkerPushesTwoCrateToEmptyField");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        Field crateField1 = new Field(null, "crateField1");
        Field crateField2 = new Field(null, "crateField2");
        Field EmptyField = new Field(null, "EmptyField");
        workerField.setNeighbor(Direction.RIGHT, crateField1);
        crateField1.setNeighbor(Direction.LEFT, workerField);
        crateField1.setNeighbor(Direction.RIGHT, crateField2);
        crateField2.setNeighbor(Direction.LEFT, crateField1);
        crateField2.setNeighbor(Direction.RIGHT, EmptyField);
        EmptyField.setNeighbor(Direction.LEFT, crateField2);

        // Worker setup
        Worker w = new Worker(workerField, "worker");
        workerField.setContent(w);

        // Crates setup
        Crate c1 = new Crate(crateField1, "crate1");
        crateField1.setContent(c1);
        Crate c2 = new Crate(crateField2, "crate2");
        crateField2.setContent(c2);

        // Map setup
        Map map = new Map(4,1);
        map.addField(0,0, workerField);
        map.addField(0,1,crateField1);
        map.addField(0,2,crateField2);
        map.addField(0,3,EmptyField);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);

        System.out.println("End of WorkerPushesTwoCrateToEmptyField");
        in.nextLine();
    }

    private static void WorkerPushesCrateIntoHole(){
        System.out.println("Setting up WorkerPushesCrateIntoHole");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        Field crateField = new Field(null, "crateField");
        Field hole = new Field(null, "hole");
        workerField.setNeighbor(Direction.RIGHT, crateField);
        crateField.setNeighbor(Direction.LEFT, workerField);
        crateField.setNeighbor(Direction.RIGHT, hole);
        hole.setNeighbor(Direction.LEFT, crateField);

        // Worker setup
        Worker w = new Worker(workerField, "worker");
        workerField.setContent(w);

        // Crates setup
        Crate c = new Crate(crateField, "crate1");
        crateField.setContent(c);

        // Map setup
        Map map = new Map(3,1);
        map.addField(0,0, workerField);
        map.addField(0,1,crateField);
        map.addField(0,2,hole);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);

        System.out.println("End of WorkerPushesCrateIntoHole");
        in.nextLine();
    }

    private static void WorkerPushesCrateToWall(){
        System.out.println("Setting up WorkerPushesCrateToWall");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        Field crateField = new Field(null, "crateField");
        Field wallField = new Field(null, "wallField");
        workerField.setNeighbor(Direction.RIGHT, crateField);
        crateField.setNeighbor(Direction.LEFT, workerField);
        crateField.setNeighbor(Direction.RIGHT, wallField);
        wallField.setNeighbor(Direction.LEFT, crateField);

        // Worker setup
        Worker w = new Worker(workerField, "worker");
        workerField.setContent(w);

        // Crates setup
        Crate c = new Crate(crateField, "crate1");
        crateField.setContent(c);

        // Wall setup
        Wall wall = new Wall();
        wallField.setContent(wall);

        // Map setup
        Map map = new Map(3,1);
        map.addField(0,0, workerField);
        map.addField(0,1,crateField);
        map.addField(0,2,wallField);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);


        System.out.println("End of WorkerPushesCrateToWall");
        in.nextLine();
    }

    private static void WorkerPushesCrateOnSwitch(){
        System.out.println("Setting up WorkerPushesCrateOnSwitch");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        Field crateField = new Field(null, "crateField");
        TrapHole traphole = new TrapHole(null, "traphole");
        Field swch = new Switch(null, traphole, "swch");
        workerField.setNeighbor(Direction.RIGHT, crateField);
        crateField.setNeighbor(Direction.LEFT, workerField);
        crateField.setNeighbor(Direction.RIGHT, swch);
        swch.setNeighbor(Direction.LEFT, crateField);
        swch.setNeighbor(Direction.RIGHT, traphole);
        traphole.setNeighbor(Direction.LEFT, swch);

        // Worker setup
        Worker w = new Worker(workerField, "worker");
        workerField.setContent(w);

        // Crates setup
        Crate c = new Crate(crateField, "crate");
        crateField.setContent(c);

        // Map setup
        Map map = new Map(4,1);
        map.addField(0,0, workerField);
        map.addField(0,1,crateField);
        map.addField(0,2,swch);
        map.addField(0,3,traphole);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);

        System.out.println("End of WorkerPushesCrateOnSwitch");
        in.nextLine();
    }

    private static void WorkerPushesCrateOntoGoalField(){
        System.out.println("Setting up WorkerPushesCrateOntoGoalField");

        // Fields setup
        Field workerField = new Field(null, "workerField");
        Field crateField = new Field(null, "crateField");
        Field goalField = new GoalField(null, "goalField");
        workerField.setNeighbor(Direction.RIGHT, crateField);
        crateField.setNeighbor(Direction.LEFT, workerField);
        crateField.setNeighbor(Direction.RIGHT, goalField);
        goalField.setNeighbor(Direction.LEFT, crateField);

        // Worker setup
        Worker w = new Worker(workerField, "worker");
        workerField.setContent(w);

        // Crates setup
        Crate c = new Crate(crateField, "crate");
        crateField.setContent(c);

        // Map setup
        Map map = new Map(3,1);
        map.addField(0,0, workerField);
        map.addField(0,1,crateField);
        map.addField(0,2,goalField);
        map.addWorker(w);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);


        System.out.println("End of WorkerPushesCrateOntoGoalField");
        in.nextLine();
    }

    private static void WorkerPushesWorkerToEmptyField(){
        System.out.println("Setting up WorkerPushesWorkerToEmptyField");

        // Fields setup
        Field worker1Field = new Field(null, "worker1Field");
        Field worker2Field = new Field(null, "worker2Field");
        Field worker2NeighbourField = new Field(null, "worker2NeighbourField");
        worker1Field.setNeighbor(Direction.RIGHT, worker2Field);
        worker2Field.setNeighbor(Direction.LEFT, worker1Field);
        worker2Field.setNeighbor(Direction.RIGHT, worker2NeighbourField);
        worker2NeighbourField.setNeighbor(Direction.LEFT, worker2Field);

        // Worker setup
        Worker w1 = new Worker(worker1Field, "worker1");
        worker1Field.setContent(w1);
        Worker w2 = new Worker(worker1Field, "worker2");
        worker1Field.setContent(w2);

        // Map setup
        Map map = new Map(3,1);
        map.addField(0,0, worker1Field);
        map.addField(0,1,worker2Field);
        map.addField(0,2,worker2NeighbourField);
        map.addWorker(w1);
        map.addWorker(w2);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);

        System.out.println("End of WorkerPushesWorkerToEmptyField");
        in.nextLine();
    }

    private static void WorkerPushesCratePushesWorkerToWall(){
        System.out.println("Setting up WorkerPushesCratePushesWorkerToWall");

        // Fields setup
        Field worker1Field = new Field(null, "worker1Field");
        Field crateField = new Field(null, "crateField");
        Field worker2Field = new Field(null, "worker2Field");
        Field wallField = new Field(null, "wallField");
        worker1Field.setNeighbor(Direction.RIGHT, crateField);
        crateField.setNeighbor(Direction.LEFT, worker1Field);
        crateField.setNeighbor(Direction.RIGHT, worker2Field);
        worker2Field.setNeighbor(Direction.LEFT, crateField);
        worker2Field.setNeighbor(Direction.RIGHT, wallField);
        wallField.setNeighbor(Direction.LEFT, worker2Field);

        // Worker setup
        Worker w1 = new Worker(worker1Field, "worker1");
        worker1Field.setContent(w1);
        Worker w2 = new Worker(worker2Field, "worker2");
        worker2Field.setContent(w2);

        //Wall setup
        Wall wall = new Wall();
        wallField.setContent(wall);

        // Crates setup
        Crate c = new Crate(crateField, "crate");
        crateField.setContent(c);

        // Map setup
        Map map = new Map(4,1);
        map.addField(0,0, worker1Field);
        map.addField(0,1,crateField);
        map.addField(0,2,worker2Field);
        map.addField(0,3,wallField);
        map.addWorker(w1);
        map.addWorker(w2);

        waitInput("D");
        map.moveWorker(0, Direction.RIGHT);


        System.out.println("End of WorkerPushesCratePushesWorkerToWall");
        in.nextLine();
    }
}
