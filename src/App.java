import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * App
 * Entry point of the application
 */
public class App {
    private static String[] options = {
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
            "5.4.13 Worker Pushes Crate Pushes Worker to a Wall",
            "5.4.14 Watcher Decrease Workers",
            "5.4.15 Watcher Decrease Crates",
            "5.4.16 Watcher Decrease GoalFields"
    };

    private static String mapLocationAndStub = "map/test";

    public static void main(String[] args) {

        printOptions();
        int choice = getInput();

        Game game = new Game();
        game.init(new File(mapLocationAndStub + choice));

    }

    private static int getInput() {

        String inputString = "Your choice (1-" + String.valueOf(options.length) + "): ";
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while(choice < 1 || choice > options.length) {
            System.out.print(inputString);
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                choice = -1;
            }
        }

        return choice;
    }

    private static void printOptions() {
        for (int i = 0; i < options.length; i++) {
            String index = String.valueOf(i + 1) + ". ";
            System.out.println( index + options[i]);
        }
    }
}