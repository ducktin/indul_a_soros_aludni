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
    }
}
