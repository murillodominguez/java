package mygame;

import javax.swing.*;
import javax.swing.border.Border;

import mygame.Model.GamePanel;
import mygame.Model.TextMessage;

import java.awt.*;

public class Container extends JFrame {
    public Container(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("MyGame");
    }

    public static void main(String[] args) {
        Container window = new Container();
        window.add(new GamePanel());
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        GamePanel gamePanel = new GamePanel();

        gamePanel.startGameThread();
    }
}