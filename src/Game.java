import java.io.*;
import java.util.Scanner;

public class Game {
    private Map map;
    private int goalFields;
    private boolean started = false;
    private int xAxis=0;
    private int yAxis=0;

    private int[] readDimensions(Scanner in) {
        int[] dimensions = new int[2];

        String line = in.nextLine();
        String[] tmp = line.split(" ");
        dimensions[0] = Integer.parseInt(tmp[0]);
        dimensions[1] = Integer.parseInt(tmp[1]);
        xAxis = dimensions[0];
        yAxis = dimensions[1];
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
            int x = Integer.parseInt(line[1]);
            int y = Integer.parseInt(line[2]);
            switch (line[0]) {

                case "F":
                    //No Fs in the input tests
                    break;
                case "H":
                    map.getFields()[x][y] = new Hole(map.getFields()[x][y].getPushable(), "Hole-" + holeNameNumber++);
                    break;
                case "T":
                    //USELESS, All TrapHoles are created in the Switch's line
                    //map.getFields()[x][y] = new TrapHole(map.getFields()[x][y].getPushable(), "trapHole-" + trapHoleNameNumber++);
                    break;
                case "S":
                    //Erre majd nézzen rá tintin, jó e kasztolás,vagyis működni fog-e
                    int xTrap = Integer.parseInt(line[3]);
                    int yTrap = Integer.parseInt(line[4]);
                    map.getFields()[xTrap][yTrap] = new TrapHole(null, "trapHole-" + trapHoleNameNumber++);
                    map.getFields()[x][y] = new Switch(map.getFields()[x][y].getPushable(), (TrapHole) map.getFields()[xTrap][yTrap], "Switch-" + switchNameNumber++);
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

    public void writeToFile(int testNumber) throws IOException {
        PrintWriter writer = new PrintWriter("testoutput_" + testNumber + ".txt", "UTF-8");
        writer.println(xAxis + " " + yAxis);
        for (int i = 0; i < xAxis; i++) {
            for (int j = 0; j < yAxis; j++) {
                String line=null;
                Field field = map.getFields()[i][j];
                if(field.getOutPutString()!=null){
                    line = field.getOutPutString() + " " + i + " " + j;
                    writer.println(line);
                }
                if(field.getPushable()!=null){
                    line = field.getPushable().getOutPutString() + " " + i + " " + j;
                    writer.println(line);
                }
            }
        }
        writer.close();
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
