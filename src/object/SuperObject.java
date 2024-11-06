package object;

import Main.Panel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperObject {
    public BufferedImage image;
    public  String name;
    public boolean collision = false;
    public int worldX, worldY;

    public void draw(Graphics2D g2, Panel p) {

        int screenX = worldX - p.player.worldx + p.player.screenX;
        int screenY = worldY - p.player.worldy + p.player.screenY;

        g2.drawImage(image, screenX, screenY, p.tileSize, p.tileSize, null);

    }
}
