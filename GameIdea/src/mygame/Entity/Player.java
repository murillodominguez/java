package mygame.Entity;

import mygame.Model.GamePanel;
import mygame.Model.KeyHandler;
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
        this.width = gp.tileSize;
        this.height = gp.tileSize;
        setDefaultValues();
    }

    public void setDefaultValues(){
        this.x = 100;
        this.y = 100;
        this.speed = 4;
        this.direction = "right";
    }

    public void getPlayerSprite(){
        try{
            this.spriteLeft1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_l1.png"));
            this.spriteRight1 = ImageIO.read(getClass().getResourceAsStream("/player/sprite_r1.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d){
        BufferedImage image = switch (this.direction) {
            case "left" -> this.spriteLeft1;
            case "right" -> this.spriteRight1;
            default -> null;
        };

        g2d.drawImage(image, this.x, this.y, this.width, this.height, null);
    }

    public void update(KeyHandler keyH){
        if (keyH.isUpPressed()){
            this.y -= speed;
        }
        if (keyH.isDownPressed()){
            this.y += speed;
        }
        if (keyH.isLeftPressed()){
            this.direction = "left";
            this.x -= speed;
        }
        if (keyH.isRightPressed()){
            this.direction = "right";
            this.x += speed;
        }
    }
}
