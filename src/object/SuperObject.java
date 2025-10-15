package object;

import Main.Panel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image, image2, image3;
    public  String name;
    public boolean collision = false;
    public int worldX, worldY;
    public  Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX = 0;
    public int solidAreaDefaultY = 0;

    public void draw(Graphics2D g2, Panel p) {
        int screenX = worldX - p.player.worldx + p.player.screenX;
        int screenY = worldY - p.player.worldy + p.player.screenY;

        g2.drawImage(image, screenX, screenY, p.tileSize, p.tileSize, null);
    }
}
