package mygame.Model;

import java.awt.*;

public class Enemy implements ObjectBeing{
    private int x;
    private int y;
    private final int speed = 4;
    private boolean onScreen;

    public Enemy(int dx, int dy){
    	this.x = dx;
    	this.y = dy;
    }

    @Override
    public void update(KeyHandler keyH) {
        this.x -= speed;
    }

    @Override
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
