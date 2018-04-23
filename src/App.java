import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.security.Key;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 * App
 * Entry point of the application
 */
public class App{

    public static void main(String[] args){

        Game game = new Game();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 100) {
            Prototype.printOptions();
            choice = getInput();
            int testNumber = choice;
            //Prototype.invoke(choice);
            game.init(new java.io.File("testInput_" + choice + ".txt"));
            game.startGame();
            String order = scanner.nextLine();
            //Key key = new KeyEvent(Key);
            while (!order.equals("quit")){
                game.moveThem(order);
                System.out.println("type quit if you are done with the test");
                order = scanner.nextLine();
            }
            choice = getInput();
            try{
                game.writeToFile(testNumber);
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
