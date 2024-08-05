package mygame.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.EventListener;

public class Player implements ObjectBeing {

    public int x,y;
    public int speed = 4;
    private int dx,dy;
    private Image sprite;
    private int height, width;

    public Player(){
        this.x = 100;
        this.y = 100;
    }

    @Override
    public void load(Graphics2D g2d){
        g2d.fillRect(this.x, this.y, 48, 48);
    }

    @Override
    public void update(KeyHandler keyH){
        if (keyH.isUpPressed()){
            this.y -= speed;
        }
        if (keyH.isDownPressed()){
            this.y += speed;
        }
        if (keyH.isLeftPressed()){
            this.x -= speed;
        }
        if (keyH.isRightPressed()){
            this.x += speed;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getSprite() {
        return sprite;
    }

}
