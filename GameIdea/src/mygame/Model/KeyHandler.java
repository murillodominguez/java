package mygame.Model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed, jumpPressed;
    public String lastKeyPressed = "right";
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_W:
                this.upPressed = true;
                break;
            case KeyEvent.VK_S:
                this.downPressed = true;
                break;
            case KeyEvent.VK_A:
                this.leftPressed = true;
                break;
            case KeyEvent.VK_D:
                this.rightPressed = true;
                break;
            case KeyEvent.VK_SPACE:
                this.jumpPressed = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        switch(code){
            case KeyEvent.VK_W:
                this.upPressed = false;
                this.lastKeyPressed = "up";
                break;
            case KeyEvent.VK_S:
                this.downPressed = false;
                this.lastKeyPressed = "down";
                break;
            case KeyEvent.VK_A:
                this.leftPressed = false;
                this.lastKeyPressed = "left";
                break;
            case KeyEvent.VK_D:
                this.rightPressed = false;
                this.lastKeyPressed = "right";
                break;
            case KeyEvent.VK_SPACE:
                this.jumpPressed = false;
                this.lastKeyPressed = "jump";
        }
    }
}
