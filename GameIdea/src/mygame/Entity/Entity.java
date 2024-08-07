package mygame.Entity;

import mygame.Model.GamePanel;
import mygame.Model.KeyHandler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    public GamePanel gp;
    public KeyHandler keyH;
    public int x, y, speed;
    public String direction;
    public BufferedImage spriteLeft1, spriteLeft2, spriteRight1, spriteRight2;
}
