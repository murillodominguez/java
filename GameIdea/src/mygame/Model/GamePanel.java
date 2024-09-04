package mygame.Model;

import Tile.TileManager;
import mygame.Entity.Enemy;
import mygame.Entity.Player;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
    //SCREEN
    static int originalTileSize = 16;
    static int scale = 3;

    public int tileSize = originalTileSize * scale;
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;
    public int screenWidth = tileSize * maxScreenCol;
    public int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    private final KeyHandler keyH = new KeyHandler();
    private Thread gameThread;

    public TileManager tileManager = new TileManager(this);
    private Player player = new Player(this, keyH);
    private List<Enemy> enemies;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(100,150,255));
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyH);
        this.spawnEnemies();
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double drawInterval = 1000000000 / FPS;
        long timePassed;
        long timer = 0;
        double delta = 0;
        int drawCount = 0;
        while (gameThread.isAlive()) {
            timePassed = System.nanoTime();
            delta += (timePassed - lastTime) / drawInterval;
            timer += timePassed - lastTime;
            lastTime = timePassed;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
//                System.out.println("FPS: " + drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void spawnEnemies() {
        int enemyCoordinates[] = new int[40];
        enemies = new ArrayList<Enemy>();
        for (int i = 0; i < enemyCoordinates.length; i++) {
            int x = (int) (Math.random() * (668 - 200 + 1)) + 200;
            int y = (int) (Math.random() * 650 + 30);
            enemies.add(new Enemy(this, keyH));
        }
    }

    public void update() {
        player.update(keyH);
//        for(int i = 0; i < enemies.size(); i++) {
//        	Enemy enemy = enemies.get(i);
//        	enemy.update(null);
//        }
    }

    @Override
    public void paintComponent(Graphics g) {
//    	Toolkit.getDefaultToolkit().sync();
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        tileManager.draw(g2d);
        player.draw(g2d);
//        for(int i = 0; i < enemies.size(); i++) {
//        	Enemy enemy = enemies.get(i);
//        		if(enemy.isOnScreen()) {
//        			enemy.load(g2d);
//        		}
//        		else {
//        			enemies.remove(i);
//        		}
        g2d.drawRect(0,0, 16, 16);
        g2d.dispose();
    }
//        g2d.drawImage(background, 0, 0, null);
//        g2d.drawImage(player.getSprite(), player.getX(), player.getY(), this)
}