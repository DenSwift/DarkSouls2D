package Entitiy;

import Main.GameOverScreen;
import Main.Panel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    Panel p;
    public int worldx, worldy;
    public int speed;
    public int attack;
    public BufferedImage up1, up2, down1, down2, left1, left2,  right1, right2;
 //   public BufferedImage attack1, attack2, attack3, attack4, attack5, attack6, attack7, attack8, attack9, attack10, attack11, attack12, attack13, attack14, attack15;
    public String direction;
    public int maxLife;
    public int life;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter;

    public Entity(Panel p) {
        this.p = p;
    }

    public void setAction() { }

    public void update() {
        setAction();

        collisionOn = false;
       if(p.cChecker.checkPlayer(this)) {
           p.player.life = 0;
           // If player's life reaches zero, display the Game Over screen
           if (p.player.life <= 0) {
               showGameOverScreen();
               p.gameThread = null;
           }
       }
        if (!collisionOn) {
            if (direction.equals("left")) {
                worldx -= speed;
            }
        }

        spriteCounter++;
        if (spriteCounter > 12) {
            spriteNum = (spriteNum == 1) ? 2 : 1;
            spriteCounter = 0;
        }
    }
    private void showGameOverScreen() {
        GameOverScreen.showGameOverScreen();
    }
    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldx - p.player.worldx + p.player.screenX;
        int screenY = worldy - p.player.worldy + p.player.screenY;

        switch (direction) {
            case "left":
                image = (spriteNum == 1) ? left1 : left2;
                break;
        }

        if (image != null) {
            g2.drawImage(image, screenX, screenY, image.getWidth(), image.getHeight(), null);
        }
    }
}

