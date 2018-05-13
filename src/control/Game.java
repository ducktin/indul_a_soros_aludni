package control;

import model.*;

import java.io.*;
import java.util.Scanner;

public class Game {
    private static Game instance = null;
    protected Map map;
    Watcher watcher;
    private boolean started = false;
    private int width = 0;
    private int height = 0;
    
    public boolean getStarted() {
        return started;
    }
    
    private Game() {
        //exists only to defeat instantiation
    }
    
    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }
    public static void destroyGame(){
        instance = null;
    }
    
    public void executeCommand(String command) {
        switch (command) {
            //Player No.1
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
            case "x":
                map.getWorkers().get(0).dropOil();
                break;
            case "y":
                map.getWorkers().get(0).dropHoney();
                break;
            //Player No.2
            case "i":
                map.moveWorker(1, Direction.UP);
                break;
            case "j":
                map.moveWorker(1, Direction.LEFT);
                break;
            case "l":
                map.moveWorker(1, Direction.RIGHT);
                break;
            case "k":
                map.moveWorker(1, Direction.DOWN);
                break;
            case "n":
                map.getWorkers().get(1).dropOil();
                break;
            case "m":
                map.getWorkers().get(1).dropHoney();
                break;
            case "^":
                map.moveWorker(2, Direction.UP);
                break;
            case "<-":
                map.moveWorker(2, Direction.LEFT);
                break;
            case "->":
                map.moveWorker(3, Direction.RIGHT);
                break;
            case "v":
                map.moveWorker(3, Direction.DOWN);
                break;
                
            default:
                break;
        }
        drawConsole();
    }
    
    private void readDimensions(Scanner in) {
        String[] line = in.nextLine().split(" ");
        width = Integer.parseInt(line[0]);
        height = Integer.parseInt(line[1]);
    }
    
    // void mert az model.App-nak nincs szüksége a model.Map-ra magán állítja be
    public void init(File inputFile) {
        System.out.println("Initializing: " + inputFile.getName());
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new FileReader(inputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
        
        // Preparing the map
        readDimensions(fileScanner);
        map = new Map(width, height);
        watcher = Watcher.getInstance();
        
        // Create filler Fields, will be replaced, if needed
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map.addField(i, j, new Field(null));
            }
        }
        
        int testLineCount = Integer.parseInt(fileScanner.nextLine());
        
        // Read next line, and create object accordingly
        for (int i = 0; i < testLineCount; i++) {
            String[] line = fileScanner.nextLine().split(" ");
            int x = Integer.parseInt(line[1]);
            int y = Integer.parseInt(line[2]);
            
            Field field = map.getFields()[x][y];
            Pushable content = map.getFields()[x][y].getPushable();
            
            switch (line[0]) {
                case "H":
                    //map.getFields()[x][y] = new Hole(content);
                    map.addField(x, y, new Hole(content));
                    break;
                case "S":
                    int trapX = Integer.parseInt(line[3]);
                    int trapY = Integer.parseInt(line[4]);
                    TrapHole th = new TrapHole(null);
                    map.addField(trapX, trapY, th);
                    map.addField(x, y, new Switch(content, th));
                    break;
                case "w":
                    field.setContent(new Wall());
                    break;
                case "C":
                    Crate crate = new Crate(field);
                    field.setContent(crate);
                    map.addCrate(crate);
                    watcher.increaseCrates();
                    break;
                case "W":
                    int strength = Integer.parseInt(line[3]);
                    Worker worker = new Worker(field, strength);
                    map.addWorker(worker);
                    field.setContent(worker);
                    watcher.increaseWorkers();
                    break;
                case "G":
                    map.addField(x, y, new GoalField(content));
                    watcher.increaseGoalField();
                    break;
                case "s":
                    //slipperiness x y value
                    field.setSlipperiness(Integer.parseInt(line[3]));
                    break;
                default:
                    break;
            }
        }
//Neighbours if there's only one line of fields
        if (width == 1) {
            //baloldali széle
            map.getFields()[0][0].setNeighbor(Direction.RIGHT, map.getFields()[0][1]);
            //jobboldali széle
            map.getFields()[0][height - 1].setNeighbor(Direction.LEFT, map.getFields()[0][height - 2]);
            //Kozepe
            for (int i = 1; i < height - 1; i++) {
                map.getFields()[0][i].setNeighbor(Direction.RIGHT, map.getFields()[0][i + 1]);
                map.getFields()[0][i].setNeighbor(Direction.LEFT, map.getFields()[0][i - 1]);
            }
        } else {
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    //bal felso sarok
                    if (i == 0 && j == 0) {
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                    }
                    //jobb felso sarok
                    if (i == 0 && j == height - 1) {
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                    }
                    //bal also sarok
                    if (i == width - 1 && j == 0) {
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                    }
                    //jobb also sarok
                    if (i == width - 1 && j == height - 1) {
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                    }
                    if (i == 0 && j < height - 1 && j >= 1) {
                        //Felso sor
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                    }
                    if (i == width - 1 && j >= 1 && j < height - 1) {
                        //also sor
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                    }
                    if (i >= 1 && i < width - 1 && j == height - 1) {
                        //Jobb oldali sor
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                    }
                    if (i >= 1 && i < width - 1 && j == 0) {
                        //bal oldali sor
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                    }
                    if (i < width - 1 && j < height - 1 && i >= 1 && j >= 1) {
                        //belso fieldek
                        map.getFields()[i][j].setNeighbor(Direction.RIGHT, map.getFields()[i][j + 1]);
                        map.getFields()[i][j].setNeighbor(Direction.UP, map.getFields()[i - 1][j]);
                        map.getFields()[i][j].setNeighbor(Direction.LEFT, map.getFields()[i][j - 1]);
                        map.getFields()[i][j].setNeighbor(Direction.DOWN, map.getFields()[i + 1][j]);
                    }
                }
            }
        }
        //CRATES MOVABITLIY CHECK TODO: REWORK TO RECURSION
        for (Crate crate : map.getCrates()) {
            crate.checkMovability();
            if (!crate.isMovable()) {
                watcher.decreaseCrates();
            }
        }
        this.startGame();
    }
    
    public void writeOutput(int testNumber) throws IOException {
        PrintWriter writer = new PrintWriter("testOutput_" + testNumber + ".txt", "UTF-8");
        writer.println(width + " " + height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
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
    
    public void drawConsole() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Field field = map.getFields()[i][j];
                if (field.getPushable() != null) {
                    System.out.print("[" + field.getPushable().getOutPutString() + "]" + "  ");
                }
                if (field.getPushable() == null) {
                    if (field.getOutPutString() != null) {
                        System.out.print("[" + field.getOutPutString() + "]" + "  ");
                    } else {
                        System.out.print("[" + " " + "]" + "  ");
                    }
                }
            }
            System.out.println();
        }
    }
    
    public void startGame() {
        System.out.println("Starting control.Game");
        
        started = true;
        
    }
    
    public void endGame() {
        System.out.println("control.Game Over");
        //writeOutput(number);
        started = false;
    }
    
    public Map getMap(){
        return map;
    }
    
}
