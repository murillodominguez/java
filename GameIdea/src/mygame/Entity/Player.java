package mygame.Entity;

import mygame.Model.GamePanel;
import mygame.Model.KeyHandler;
import mygame.Model.Level;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity {
    public int height, width;
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        this.width = gp.tileSize * 2;
        this.height = gp.tileSize * 2;
        setDefaultValues();
        getPlayerSprite();
    }

    public void setDefaultValues(){
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        this.direction = "rightIdle";
    }

    public void getPlayerSprite(){
        try{
            this.spriteIdleLeft = ImageIO.read(getClass().getResourceAsStream("/player/sprite_idle_l.png"));
            this.spriteIdleRight = ImageIO.read(getClass().getResourceAsStream("/player/sprite_idle_r.png"));
            this.spriteWalkLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_walk_l1.png"));
            this.spriteWalkLeft2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_walk_l2.png"));
            this.spriteWalkRight1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_walk_r1.png"));
            this.spriteWalkRight2 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_walk_r2.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        BufferedImage image = null;
        switch (this.direction) {
            case "left":
                if(spriteNum == 1){
                    image = spriteWalkLeft1;
                }
                if(spriteNum == 2){
                    image = spriteWalkLeft2;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = spriteWalkRight1;
                }
                if(spriteNum == 2){
                    image = spriteWalkRight2;
                }
                break;
            case "idleleft":
                image = spriteIdleLeft;
                break;
            case "idleright":
                image = spriteIdleRight;
                break;
        };

        g2d.drawImage(image, this.x, this.y, this.width, this.height, null);
    }

    public void update(KeyHandler keyH) {
        if (anyMoveKeyIsPressed(keyH)) {
            if (keyH.upPressed) {
            }
            if (keyH.downPressed) {
            }
            if (keyH.leftPressed) {
                this.direction = "left";
                this.x -= speed;
            }
            if (keyH.rightPressed) {
                this.direction = "right";
                this.x += speed;
            }
            ++spriteCounter;
            if(spriteCounter >= 16){
                if(spriteNum == 1){
                    spriteNum = 2;
                }
                else if (spriteNum == 2){
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        } else {
            if(keyH.lastKeyPressed.equals("left")) {
                this.direction = "idleleft";
            }
            else{
                this.direction = "idleright";
            }
        }
    }


}
