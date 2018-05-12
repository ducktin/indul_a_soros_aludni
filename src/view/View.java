package view;

import control.Controller;
import control.Game;

import javax.swing.*;
import java.io.Console;
import java.util.List;

public class View extends JFrame{

    protected JPanel jPanel;

    private List<Drawable> drawables;

    public void drawAll(){

    }
    
    View (){
        addKeyListener(new Controller());
        System.out.println(Game.getInstance());
    }

}
