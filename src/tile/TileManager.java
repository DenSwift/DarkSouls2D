package tile;

import Main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TileManager {

    Panel p;
    Tile[] tile;
    int mapTileNum[][];

    public TileManager(Panel p) {
        this.p = p;

        tile = new Tile[10];
        mapTileNum = new int[p.maxWorldCol][p.maxWorldRow];

        getTileImage();
    }

    public  void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/tile1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
       public void draw(Graphics2D g2 ) {

        int worldCol = 0;
        int worldRow = 0;


        while(worldCol < p.maxWorldCol && worldRow < p.maxWorldRow) {
            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * p.tileSize;
            int worldY = worldRow * p.tileSize;
            int screenX = worldX - p.player.worldx + p.player.screenX;
            int screenY = worldY - p.player.worldy + p.player.screenY;

            g2.drawImage(tile[0].image, screenX, screenY, p.tileSize, p.tileSize, null);
            worldCol++;


            if(worldCol == p.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
        }
    }

