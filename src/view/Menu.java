package view;

import control.Game;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Menu extends JFrame {


    //protected JPanel jPanel;
    //protected Game game;


    public Menu() {
        //jPanel = new JPanel();

        JButton helpButton = new JButton("Help");
        JButton levelSelectorButton = new JButton("Select level");
        JButton exitButton = new JButton("Exit");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(400, 100));
        this.setTitle("SOK VOLT MÁN");
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        JPanel buttonContainer = new JPanel();

        this.add(buttonContainer);

        buttonContainer.setLayout(new GridLayout(1, 3, 5, 5));

        buttonContainer.setBorder(new EmptyBorder(15, 15, 15, 15));

        buttonContainer.add(helpButton);
        buttonContainer.add(levelSelectorButton);
        buttonContainer.add(exitButton);

        helpButton.addActionListener(e -> {
            HelpWindow helpWindow = new HelpWindow();
            helpWindow.frame.setVisible(true);
        });

        //Action listener for exitButton button
        exitButton.addActionListener(e -> System.exit(0));

        //Action listener for levelSelectorButton button
        levelSelectorButton.addActionListener(e -> {
            LevelSelector levelSelector = new LevelSelector();
            levelSelector.setVisible(true);
        });
    }
}
