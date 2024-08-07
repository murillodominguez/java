package mygame;

import javax.swing.*;
import mygame.Model.GamePanel;

public class Container extends JFrame {
    public Container(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("MyGame");
    }

    public static void main(String[] args) {
        String classpathStr = System.getProperty("java.class.path");
        System.out.print(classpathStr);

        Container window = new Container();
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);


        gamePanel.startGameThread();
    }
}