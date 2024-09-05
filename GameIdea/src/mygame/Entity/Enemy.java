package mygame.Entity;

import mygame.Model.GamePanel;
import mygame.Model.KeyHandler;

import java.awt.*;

public class Enemy extends Entity {

    private boolean onScreen;

    public Enemy(GamePanel gp, KeyHandler keyH){
        this.gp = gp;
        this.keyH = keyH;
        setDefaultValues();
    }

    public void setDefaultValues(){
        this.x = 500;
        this.y = 500;
        this.speedX = 4;
    }

    public void update(KeyHandler keyH) {
        this.x -= speedX;
    }

    public void load(Graphics2D g2d) {
        g2d.fillRect(this.x, this.y, gp.tileSize, gp.tileSize);
    }
    
    public boolean isOnScreen() {
    	if(this.x > gp.screenWidth || this.x < -(gp.tileSize)) {
    		this.onScreen = false;
    		return false;
    	}
    	else {
    		this.onScreen = true;
    		return true;
    	}
    }
}
