package mygame.Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {

    private int x,y;
    private int dx,dy;
    private Image sprite;
    private int height, width;
    Animate animation = new Animate();

    public Player(){
        this.x = 0;
        this.y = 100;
    }

    public void load(){
        ImageIcon spriteref = new ImageIcon("src/rsc/img/sprite_l.png");
        sprite = spriteref.getImage();
        width = sprite.getWidth(null);
        height = sprite.getHeight(null);
        System.out.println(height);
        System.out.println(width);
    }

    public void update(){
        x += dx;
        y += dy;
    }

    public void keyPressed(KeyEvent key){
        int keycode = key.getKeyCode();

        if(keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP){
            dy = -3;
        }
        if(keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN){
            dy = 3;
        }
        if(keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT){
            dx = -3;
            animation.change("sideleft");
        }
        if(keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT){
            dx = 3;
            animation.change("sideright");
        }
    }

    public void keyReleased(KeyEvent key){
        int keycode = key.getKeyCode();

        if(keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP){
            dy = 0;
        }
        if(keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN){
            dy = 0;
        }
        if(keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT){
            dx = 0;
        }
        if(keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT){
            dx = 0;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getSprite() {
        return sprite;
    }

    private class Animate{

        public String spriteurl;

        public void change(String position){
            if(position.equals("sideleft")){
                spriteurl = "src/rsc/img/sprite_l.png";
            }
            if(position.equals("sideright")){
                spriteurl = "src/rsc/img/sprite_r.png";
            }
        }
    }
}
