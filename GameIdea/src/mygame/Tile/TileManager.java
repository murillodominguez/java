package mygame.Tile;

import mygame.Model.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int[][] mapTileNum;

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];
        getTileSprite();
        mapTileNum = new int[gp.tileSize*5][gp.maxScreenRow];
        loadMap();
    }

    public void getTileSprite() {
        try {
            tile[0] = new Tile();
            tile[0].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/sky.png"));
            tile[0].attribute = "sky";

            tile[1] = new Tile();
            tile[1].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
            tile[1].attribute = "ground";

            tile[2] = new Tile();
            tile[2].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt1.png"));
            tile[2].attribute = "ground";

            tile[3] = new Tile();
            tile[3].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt2.png"));
            tile[3].attribute = "ground";

            BufferedImage reversedirt3 = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt3.png"));
            AffineTransform at = new AffineTransform();
            at = AffineTransform.getScaleInstance(-1, 1);
            at.translate(-reversedirt3.getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(at, null);
            reversedirt3 = op.filter(reversedirt3, null);

            tile[4] = new Tile();
            tile[4].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt3.png"));
            tile[4].attribute = "ground";

            tile[5] = new Tile();
            tile[5].sprite = reversedirt3;
            tile[5].attribute = "ground";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(){
        try{
            InputStream is = getClass().getResourceAsStream("/maps/groundmap01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;

            while(row < gp.maxScreenRow && col <= gp.maxScreenCol){
                String line = br.readLine();
                System.out.println(line);
                while(col < gp.maxScreenCol) {

                    String[] split = line.split(" ");

                    int num = Integer.parseInt(split[col]);
                    mapTileNum[col][row] = num;
                    System.out.println(mapTileNum[col][row]);
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    int printtimes = 0;
    public void draw(Graphics2D g2d) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (row < gp.maxScreenRow && col < gp.maxScreenCol) {
            int tileNum = mapTileNum[col][row];
            if (printtimes < 1) {
                System.out.println(tileNum);
            }
            g2d.drawImage(tile[tileNum].sprite, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){
                col = 0;
                row++;
                y += gp.tileSize;
                x= 0;
            }
        }
        printtimes++;
    }

    public int findTileForSpawnPosition(int playerSpawnX, int playerWidth, int playerHeight){
        for(int i = 0; i < mapTileNum.length; i++) {
            for (int j = 0; j < mapTileNum[i].length; j++) {
                if (tile[mapTileNum[i][j]].attribute.equals("ground") && (i*gp.tileSize == playerSpawnX / 16 * 16 || (i == 0 && playerSpawnX / 16 <= 0))) {
                    return j*gp.tileSize-playerHeight;
                }
            }
        }
        return playerSpawnX / 16 * 16;
    }

}