import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Game {
    private Map map;
    private int goalFields;
    private boolean started = false;

    private int[] readDimensions(Scanner in) {
        int[] dimensions = new int[2];

        String line = in.nextLine();
        String[] tmp = line.split(" ");
        dimensions[0] = Integer.parseInt(tmp[0]);
        dimensions[1] = Integer.parseInt(tmp[1]);
        return dimensions;
    }

    // void mert az App-nak nincs szüksége a Map-ra magán állítja be
    public void init(File input) {
        System.out.println("Initializing: " + input.getName());
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(input));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //making the map
        int[] dimensions = readDimensions(in);
        Map map = new Map(dimensions[0], dimensions[1]);

        //Making all of the Fields
        //Field[][] fields = map.getFields();
        int nameCounter = 0;
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                map.addField(i, j, new Field(null, "field" + nameCounter));
                nameCounter++;
            }
        }



        //lines in the input
        int inputLines = in.nextInt();

        //name increments
        int crateNameNumber = 0;
        int workerNameNumber = 0;
        int trapHoleNameNumber = 0;
        int holeNameNumber = 0;
        int switchNameNumber = 0;
        int goalFieldNameNumber = 0;

        //next line reading and creating objects
        for (int i = 0; i < inputLines; i++) {
            String[] line = in.nextLine().split(" ");
            int x = Integer.parseInt(line[1])+1;
            int y = Integer.parseInt(line[2])+1;
            switch (line[0]) {
                //No Fs in the input tests
                case "F":

                    break;
                case "H":
                    map.getFields()[x][y] = new Hole(map.getFields()[x][y].getPushable(), "Hole-" + holeNameNumber++);
                    break;
                case "T":
                    map.getFields()[x][y] = new TrapHole(map.getFields()[x][y].getPushable(), "trapHole-" + trapHoleNameNumber++);
                    break;
                case "S":
                    //TODO: Finally do how the Swicth acquires its traphole
                    int xTrap = Integer.parseInt(line[3])+1;
                    int yTrap = Integer.parseInt(line[4])+1;
                    //Field trapHole = new TrapHole(null);
                    //map.getFields()[x][y] = new Switch(map.getFields()[x][y].getPushable(), trapHole, "Switch-" + switchNameNumber++);
                    break;
                case "w":
                    map.getFields()[x][y].setContent(new Wall());
                    break;
                case "C":
                    Crate crate = new Crate(map.getFields()[x][y], "Crate-" + crateNameNumber++);
                    map.getFields()[x][y].setContent(crate);
                    break;
                case "W":
                    int strength = Integer.parseInt(line[3]);
                    Worker worker = new Worker(map.getFields()[x][y], "worker-" + workerNameNumber++, strength);
                    map.addWorker(worker);
                    map.getFields()[x][y].setContent(worker);
                    break;
                case "G":
                    map.getFields()[x][y] = new GoalField(map.getFields()[x][y].getPushable(), "goalField-" + goalFieldNameNumber++);
                    goalFields++;
                    break;
                default:
                    break;
            }
        }
    }

    public void startGame() {
        System.out.println("starting Game");
        started = true;
    }

    public void endGame() {
        System.out.println("ending Game");
        started = false;
    }
}
