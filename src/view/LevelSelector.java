package view;

import control.Game;
import model.MapList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class LevelSelector extends JFrame {
    
    List<JButton> levels;
    
    public LevelSelector() {
        
        this.setDefaultCloseOperation(LevelSelector.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(550, MapList.options.length * 40));
        this.setTitle("Level selector");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        JPanel buttonsPanel = new JPanel();
        JPanel labelPanel = new JPanel();
        
        this.add(buttonsPanel, BorderLayout.WEST);
        this.add(labelPanel, BorderLayout.EAST);
        
        buttonsPanel.setLayout(new GridLayout(MapList.options.length, 1, 5, 10));
        labelPanel.setLayout(new GridLayout(MapList.options.length, 1, 5, 10));
        
        levels = new ArrayList<>();
        
        for (int i = 0; i < MapList.options.length; i++) {
            JButton button = new JButton("Level " + i);
            buttonsPanel.add(button);
            labelPanel.add(new JLabel(MapList.options[i]));
            final String mapNumber = "" + (i + 1);
            button.addActionListener(e -> {
                Game.destroyGame();  // ha van valami Game akkor megöljük
                Game game = Game.getInstance();
                game.init(new java.io.File("map_" + mapNumber + ".txt"));
                
                GameFrame gameView = new GameFrame(game);
                gameView.setVisible(true);
                this.dispose();
            });
        }
        
    }
    
}
