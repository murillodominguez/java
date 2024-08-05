package mygame.Model;

import javax.swing.*;
import java.util.List;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {
    //SCREEN
    static int originalTileSize = 16;
    static int scale = 3;

    static int tileSize = originalTileSize * scale;
    static int maxScreenCol = 16;
    static int maxScreenRow = 12;
    static int screenWidth = tileSize * maxScreenCol;
    static int screenHeight = tileSize * maxScreenRow;

    int FPS = 60;

    private KeyHandler keyH = new KeyHandler();
    private Thread gameThread;

    private Player player = new Player();
    private List<Enemy> enemies;
    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.addKeyListener(keyH);
        
        this.spawnEnemies();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval = 1000000000/60;
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread.isAlive()){

            update();
            
            repaint();
            
            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;
                if(remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
           
        }
    }
    
    public void spawnEnemies() {
    	int enemyCoordinates[] = new int[40];
    	enemies = new ArrayList<Enemy>();
    	for(int i = 0; i < enemyCoordinates.length; i++) {
    		int x = (int)(Math.random() *  (668-200+1))+200;
    		int y = (int)(Math.random() * 650 + 30);
    		enemies.add(new Enemy(x,y));
    	}
    }
    
    public void update(){
        player.update(keyH);
        for(int i = 0; i < enemies.size(); i++) {
        	Enemy enemy = enemies.get(i);
        	enemy.update(null);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
    	Toolkit.getDefaultToolkit().sync();
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.white);
        player.load(g2d);
        for(int i = 0; i < enemies.size(); i++) {
        	Enemy enemy = enemies.get(i);
    		System.out.println(enemies.get(i));
        		if(enemy.isOnScreen()) {
        			enemy.load(g2d);
        		}
        		else {
        			enemies.remove(i);
        		}
        }
//        g2d.drawImage(background, 0, 0, null);
//        g2d.drawImage(player.getSprite(), player.getX(), player.getY(), this);
        g2d.dispose();
    }
}