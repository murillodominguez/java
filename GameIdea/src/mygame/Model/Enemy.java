package mygame.Model;

import java.awt.*;

public class Enemy implements ObjectBeing{
    private int x;
    private int y;
    private final int speed = 4;

    public Enemy(){
        this.x = 500;
        this.y = 200;
    }

    @Override
    public void update(KeyHandler keyH) {
        this.x -= speed;
    }

    @Override
    public void load(Graphics2D g2d) {
        g2d.fillRect(this.x, this.y, 48, 48);
    }
}
