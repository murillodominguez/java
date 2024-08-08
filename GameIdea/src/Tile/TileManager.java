package Tile;

import mygame.Model.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class TileManager {
    GamePanel gp;
    Tile[] tile;
    int[][] mapTileNum;

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
            tile[0].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));

            tile[1] = new Tile();
            tile[1].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt1.png"));

            tile[2] = new Tile();
            tile[2].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt2.png"));

            tile[3] = new Tile();
            tile[3].sprite = ImageIO.read(getClass().getResourceAsStream("/tiles/dirt3.png"));

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

            while(row < 5){
                String line = br.readLine();
                System.out.println(line);
                while(col < gp.maxScreenCol) {
                    String[] split = line.split(" ");

                    int num = Integer.parseInt(split[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if(col == gp.maxScreenCol){
                    col = 0;
                    row++;
                }
            }
            br.close();
            System.out.println(mapTileNum[0][4]);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2d) {
        int col = 0;
        int row = 0;
        int x = 0;
        int y = gp.screenHeight - gp.tileSize*5;
        while (row < 5) {
            int tileNum = mapTileNum[col][row];
            g2d.drawImage(tile[tileNum].sprite, x, y, gp.tileSize, gp.tileSize, null);
            col++;
            x += gp.tileSize;

            if(col == gp.maxScreenCol){
                col = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }
}