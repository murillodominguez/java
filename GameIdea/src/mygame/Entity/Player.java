package mygame.Entity;

import mygame.Model.GamePanel;
import mygame.Model.KeyHandler;
import mygame.Model.Level;
import mygame.Model.Sound;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Objects;

public class Player extends Entity {
    public int height, width;
    public Sound[] soundEffects = new Sound[2];
    public int jumpTimeCounter = 0;
    public int jumpAcceleration = 0;
    public Player(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        this.width = gp.tileSize;
        this.height = gp.tileSize;
        setDefaultValues();
        getPlayerSprite();
    }

    public void setDefaultValues(){
        this.x = 0;
        this.velocityY = 6;
        this.speedX = 4;
        this.speedY = 0;
        this.direction = "rightIdle";
        soundEffects[0] = new Sound(1);
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
        if(this.y == 0) this.y = gp.tileManager.findTileForSpawnPosition(this.x, width, height);
        System.out.println(gp.tileManager.findTileForSpawnPosition(this.x, width, height));
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
        }

        g2d.drawImage(image, this.x, this.y, this.width, this.height, null);
    }

    public void animate(){
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
    }
    int jumpSpeed = 15;
    int jumpHeight, jumpCounter;
    public void jumpAcceleration(){
        jumpTimeCounter++;
        if(jumpTimeCounter >= 30){
            this.jumpSpeed = 0;
        }
        else if(jumpTimeCounter >= 5){
            jumpAcceleration = 3;
            if(jumpTimeCounter > 5 && jumpTimeCounter % 5 == 0) {
                this.jumpSpeed -= jumpAcceleration;
            }
                y -= this.jumpSpeed;
        }
    }

    public void jump(){
        if(jumpHeight > 0) {
            jumpCounter = jumpHeight/speedY;
            this.y += jumpCounter;
        }
        jumpHeight -= jumpCounter;
    }

    int gravityApplyCounter = 0;
    public void gravity() {
        this.speedY = velocityY;
        if (gravityApplyCounter > 16 && gravityApplyCounter % 16 == 0) {
            this.speedY += velocityY;
        }
        if (gravityApplyCounter > 60) {
            gravityApplyCounter = 0;
        }
        this.y += this.speedY;
        gravityApplyCounter++;
    }
    Sound jumpSFX;
    int counter = 0;
    public void update(KeyHandler keyH) {
        jump();
        jumpSFX = new Sound(1);
        if(!keyH.jumpPressed) {
            counter = 0;
            jumpTimeCounter = 0;
            jumpSpeed = 15;
        }
        if(!gp.checkPlayerCollision(x,y, width, height)) gravity();
        if (anyMoveKeyIsPressed(keyH)) {
            if (keyH.leftPressed) {
                this.direction = "left";
                this.x -= speedX;
            }
            if (keyH.rightPressed) {
                this.direction = "right";
                this.x += speedX;
            }
            if(keyH.jumpPressed) {
                this.direction = "right";
                jumpHeight = 15;
                if(counter == 0) {
                    jumpSFX.play();
                    counter++;
                }
                jumpAcceleration();
            }
            animate();
        } else {
            if(keyH.lastKeyPressed.equals("left")) {
                this.direction = "idleleft";
            }
            else if(keyH.lastKeyPressed.equals("right")){
                this.direction = "idleright";
            }
        }
        this.x = Math.max(this.x, 0);
        this.x = Math.min(this.x, gp.screenWidth-width);
    }


}
