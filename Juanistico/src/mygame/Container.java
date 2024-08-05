package mygame;

import javax.swing.*;
import javax.swing.border.Border;

import mygame.Model.Fase;
import mygame.Model.TextMessage;

import java.awt.*;

public class Container extends JFrame {

    public Container(){
        add(new Fase());
//        add (new TextMessage("Em memória de Juan...\nNunca mais seremos os mesmos."), BorderLayout.WEST);
        setTitle("MyGame");
        setSize(1024,728);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Container();
    }
}