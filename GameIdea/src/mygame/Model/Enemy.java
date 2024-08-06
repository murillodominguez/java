package mygame.Model;

import java.awt.*;

public class Enemy extends Entity{
    private boolean onScreen;

    public Enemy(){

    }

    public void update(KeyHandler keyH) {
        this.x -= speed;
    }

    public void load(Graphics2D g2d) {
        g2d.fillRect(this.x, this.y, GamePanel.tileSize, GamePanel.tileSize);
    }
    
    public boolean isOnScreen() {
    	if(this.x > GamePanel.screenWidth || this.x < -(GamePanel.tileSize)) {
    		this.onScreen = false;
    		return false;
    	}
    	else {
    		this.onScreen = true;
    		return true;
    	}
    }
}
