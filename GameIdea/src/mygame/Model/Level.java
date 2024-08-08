package mygame.Model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Level {
    Sound soundtrack;
    BufferedImage ground;
    int scenarioLength = 30;
    GamePanel gp;
    public int startPosition;

    public Level(GamePanel gp){
        this.gp = gp;
        this.startPosition = gp.tileSize*5;
    }

    public void draw(Graphics2D g2d){
        getScenarioSprite();
        int groundWidth = gp.tileSize*3;
        int groundNextPosition = 0;
        for(int i = 0; i < scenarioLength; i++){
            g2d.drawImage(ground, groundNextPosition, gp.screenHeight-gp.tileSize*5, groundWidth, gp.tileSize*5, null);
            groundNextPosition += gp.tileSize*3;
        }

    }

    public void getScenarioSprite(){
        ground = null;
        try{
            ground = ImageIO.read(getClass().getResource("/scenario/tiles/grass_1.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
