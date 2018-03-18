import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Game {
    private Map map;
    private int goalFields;
    private boolean started = false;

    private int[] readDimensions(Scanner in){
        int[] dimensions = new int[2];

        String line = in.nextLine();
        String[] tmp = line.split("*");
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

        int[] dimensions = readDimensions(in);
        Map map = new Map(dimensions[0], dimensions[1]);

        // Minden soron
        for (int y = 0; y < dimensions[1]; y++) {
            String[] line = in.nextLine().split("");
            // Minden oszlopon
            for (int x = 0; x < dimensions[0]; x++) {
                Field f = parseChar(line[x]);
            }
        }

    }

    private Field parseChar(String f) {
        Field field = null;
        switch (f) {
            case " ": field = new Field(null,""); // TODO: naming
        }

        return field;
    }

    public void startGame(){
        System.out.println("starting Game");
        started = true;
    }

    public void endGame(){
        System.out.println("ending Game");
        started = false;
    }
}
