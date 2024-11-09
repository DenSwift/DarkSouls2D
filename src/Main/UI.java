package Main;

import object.Heart;
import object.SuperObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    Panel p;
    BufferedImage heart_full, heart_half, heart_blank;

    public UI(Panel p) {
        this.p = p;

        SuperObject heart = new Heart(p);
        heart_full = heart.image;
        heart_half = heart.image2;
        heart_blank = heart.image3;
    }

    public void draw(Graphics2D g2) {
        drawPlayerLife(g2);
    }

    public void drawPlayerLife(Graphics2D g2) {
        int x = p.tileSize/2;
        int y = p.tileSize/2;
        int i = 0;

        // Draw max life
        while(i < p.player.maxLife/2) {
            g2.drawImage(heart_blank, x, y, null);
            i++;
            x += p.tileSize;
        }

         x = p.tileSize/2;
         y = p.tileSize/2;
         i = 0;

         // Draw current life
        while(i < p.player.life) {
            g2.drawImage(heart_half,x,y,null);
            i++;
            if(i < p.player.life) {
                g2.drawImage(heart_full,x,y, null);
            }
            i++;
            x += p.tileSize;
        }
    }
}
