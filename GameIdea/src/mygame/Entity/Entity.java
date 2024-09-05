package mygame.Entity;

import mygame.Model.GamePanel;
import mygame.Model.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public GamePanel gp;
    public KeyHandler keyH;
    public int x, y, speedX, speedY, velocityY, velocityX;
    public String direction;
    public BufferedImage spriteIdleLeft, spriteIdleRight, spriteWalkLeft1, spriteWalkLeft2, spriteWalkRight1, spriteWalkRight2;
    public int spriteNum = 1;
    public int spriteCounter = 0;

    public boolean anyMoveKeyIsPressed(KeyHandler keyH){
        return keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.jumpPressed;
    }

    public int getSpriteNum() {
        return spriteNum;
    }

    public void setSpriteNum(int spriteNum) {
        this.spriteNum = spriteNum;
    }
}
