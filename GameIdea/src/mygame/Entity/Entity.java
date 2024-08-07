package mygame.Entity;

import mygame.Model.GamePanel;
import mygame.Model.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public GamePanel gp;
    public KeyHandler keyH;
    public int x, y, speed;
    public String direction;
    public BufferedImage spriteIdleLeft, spriteIdleRight, spriteWalkLeft1, spriteWalkLeft2, spriteWalkRight1, spriteWalkRight2;
    public int spriteNum;

    public boolean anyMoveKeyIsPressed(KeyHandler keyH){
        return keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed;
    }
}
