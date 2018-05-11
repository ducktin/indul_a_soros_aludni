package model;

import control.Game;
import view.Menu;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * model.App
 * Entry point of the application
 */
public class App {
    private static Menu menu;
    public static void main(String[] args) {

        menu = new Menu();
        menu.setVisible(true);

        /*Scanner console = new Scanner(System.in);

        MapList.printOptions();
        int choice = getInput(console);
        while (choice != 100) {

            int mapNumber = choice;

            Game game = new Game();
            Watcher watcher = Watcher.getInstance();
            watcher.game = game;

            game.init(new java.io.File("map_" + mapNumber + ".txt"));

            game.startGame();

            System.out.println("Type in command keys, or type 'quit' to end the game");

            String command = console.nextLine().toLowerCase();

            while (!command.equals("quit") && game.getStarted()) {
                game.executeCommand(command);
                command = console.nextLine().toLowerCase();
            }
            choice = getInput(console);
            try {
                game.writeOutput(mapNumber);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }

    private static int getInput(Scanner console) {
        String[] options = MapList.options;
        System.out.println("Input:\nmove: wasd/ijkl, x/m dropHoney, y/n dropOil");
        String inputString = "model.Map to run (1-" + String.valueOf(options.length) + ")";

        int choice = -1;
        while (choice < 1 || choice > options.length) {
            System.out.print(inputString);
            try {
                choice = console.nextInt();
                if (choice == 100)
                    break;
            } catch (InputMismatchException e) {
                choice = -1;
                console.nextLine();
            }
        }

        return choice;
    }

}
