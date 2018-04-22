import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * App
 * Entry point of the application
 */
public class App {

    public static void main(String[] args){

        Game game = new Game();

        int choice = -1;
        while (choice != 100) {
            Prototype.printOptions();
            choice = getInput();
            //Prototype.invoke(choice);
            game.init(new java.io.File("testInput_" + choice + ".txt"));
            game.map.moveWorker(0,Direction.RIGHT);
            try{
                game.writeToFile(choice);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        System.out.println("Thanks for using the program!");

    }

    private static int getInput() {
        String[] options = Prototype.options;
        String inputString = "Test case to run (1-" + String.valueOf(options.length) + "), enter 100 to quit: ";

        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice < 1 || choice > options.length) {
            System.out.print(inputString);
            try {
                choice = scanner.nextInt();
                if (choice == 100)
                    break;
            } catch (InputMismatchException e) {
                choice = -1;
                scanner.nextLine();
            }
        }

        return choice;
    }

}
