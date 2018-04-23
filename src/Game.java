import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;
import java.util.Scanner;

public class Game {
    protected Map map;
    private int goalFields=0;
    private boolean started = false;
    private int xAxis = 0;
    private int yAxis = 0;

    public boolean getStarted() {
        return started;
    }

    public void moveThem(String order) {
        switch (order) {
            case "w":
                map.moveWorker(0, Direction.UP);
                break;
            case "a":
                map.moveWorker(0, Direction.LEFT);
                break;
            case "d":
                map.moveWorker(0, Direction.RIGHT);
                break;
            case "s":
                map.moveWorker(0, Direction.DOWN);
                break;
            case "i":
                map.moveWorker(1, Direction.UP);
                break;
            case "j":
                map.moveWorker(1, Direction.LEFT);
                break;
            case "k":
                map.moveWorker(1, Direction.RIGHT);
                break;
            case "l":
                map.moveWorker(1, Direction.DOWN);
                break;
            default:
                break;
        }
    }

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
        map = new Map(dimensions[0], dimensions[1]);

        //Making all of the Fields
        int nameCounter = 0;
        for (int i = 0; i < dimensions[0]; i++) {
            for (int j = 0; j < dimensions[1]; j++) {
                map.addField(i, j, new Field(null, "field" + nameCounter));
                nameCounter++;
            }
        }

        //lines in the input
        int inputLines = Integer.parseInt(in.nextLine());

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
                case "s":
                    //slipperiness x y value
                    map.getFields()[x][y].slipperiness = Integer.parseInt(line[3]);
                    break;
                default:
                    break;
            }
        }

        //Neighbours if there's only one line of fields
        if (xAxis == 1) {
            //baloldali széle
            map.getFields()[0][0].setNeighbor(Direction.RIGHT, map.getFields()[0][1]);
            //jobboldali széle
            map.getFields()[0][yAxis - 1].setNeighbor(Direction.LEFT, map.getFields()[0][yAxis - 2]);
            //Kozepe
            for (int i = 1; i < yAxis - 1; i++) {
                map.getFields()[0][i].setNeighbor(Direction.RIGHT, map.getFields()[0][i + 1]);
                map.getFields()[0][i].setNeighbor(Direction.LEFT, map.getFields()[0][i - 1]);
            }
        } else {
            for (int i = 0; i < xAxis; i++) {
                for (int j = 0; j < yAxis; j++) {
                    //bal felso sarok
                    if (i == 0 && j == 0) {
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                    }
                    //jobb felso sarok
                    if (i == 0 && j == yAxis - 1) {
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                    }
                    //bal also sarok
                    if (i == xAxis - 1 && j == 0) {
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                    }
                    //jobb also sarok
                    if (i == xAxis - 1 && j == yAxis - 1) {
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                    }
                    if (i == 0 && j < yAxis - 1 && j >= 1) {
                        //Felso sor
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                    }
                    if (i == xAxis - 1 && j >= 1 && j < yAxis - 1) {
                        //also sor
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                    }
                    if (i >= 1 && i < xAxis - 1 && j == yAxis - 1) {
                        //Jobb oldali sor
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                    }
                    if (i >= 1 && i < xAxis - 1 && j == 0) {
                        //bal oldali sor
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                    }
                    if (i < xAxis - 1 && j < yAxis - 1 && i >= 1 && j >= 1) {
                        //belso fieldek
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                    }
                }
            }
        }
    }

    public void writeToFile(int testNumber) throws IOException {
        PrintWriter writer = new PrintWriter("testoutput_" + testNumber + ".txt", "UTF-8");
        writer.println(xAxis + " " + yAxis);
        for (int i = 0; i < xAxis; i++) {
            for (int j = 0; j < yAxis; j++) {
                String line = null;
                Field field = map.getFields()[i][j];
                if (field.getOutPutString() != null) {
                    line = field.getOutPutString() + " " + i + " " + j;
                    writer.println(line);
                }
                if (field.getPushable() != null) {
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

    /*@Override
    public void keyTyped(KeyEvent e) {
        switch  (e.getKeyCode()){
            case KeyEvent.VK_D:
                map.moveWorker(0,Direction.RIGHT);
            default:
                break;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }*/
}
