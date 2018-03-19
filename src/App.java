import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * App
 * Entry point of the application
 */
public class App {

    public static void main(String[] args) {

        int choice = -1;
        while (choice != 100) {
            Skeleton.printOptions();
            choice = getInput();
            Skeleton.invoke(choice);
        }
        System.out.println("Thanks for using the program!");

    }

    private static int getInput() {
        String[] options = Skeleton.options;
        String inputString = "Test case to run (1-" + String.valueOf(options.length) + "), enter 100 to quit: ";

        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while(choice < 1 || choice > options.length) {
            System.out.print(inputString);
            try {
                choice = scanner.nextInt();
                if(choice == 100)
                    break;
            } catch (InputMismatchException e) {
                choice = -1;
            }
        }

        return choice;
    }

}