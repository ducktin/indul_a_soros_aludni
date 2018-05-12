package view;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HelpWindow {

    JFrame frame = new JFrame("Help");

    public HelpWindow(){
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new FileReader("help.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        String lines = "";
        while(fileScanner.hasNext()){
            lines += fileScanner.nextLine();
            lines += "\n";
        }

        frame.setSize(700, 700);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JTextArea textArea = new JTextArea(lines);
        textArea.setSize(500,400);

        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setVisible(true);

        JScrollPane scroll = new JScrollPane (textArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(scroll);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
