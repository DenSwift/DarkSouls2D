package Entitiy;

import Main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
public class Boss extends  Entity {
    public Boss(Panel p) {
        super(p);
        direction = "left";
        speed = 1;

        solidArea = new Rectangle(p.tileSize*40,p.tileSize*4,48*2,48*3);
        solidAreaDefaultX = 0;
        solidAreaDefaultY = 0;
        getBossImage();
    }

    public void getBossImage() {
        double scaleFactor = 1.0;

        try {
            // Load original images
            BufferedImage originalLeft1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/boss/demon_cleave_8.png")));
            BufferedImage originalLeft2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/boss/demon_cleave_10.png")));

            // Scale images
            left1 = scaleImage(originalLeft1, scaleFactor);
            left2 = scaleImage(originalLeft2, scaleFactor);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to scale an image by a given factor
    private BufferedImage scaleImage(BufferedImage originalImage, double scaleFactor) {
        int newWidth = (int)(originalImage.getWidth() * scaleFactor);
        int newHeight = (int)(originalImage.getHeight() * scaleFactor);

        // Create a new buffered image with the new dimensions
        BufferedImage scaledImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
        Graphics2D g2 = scaledImage.createGraphics();

        // Draw the original image scaled to the new size
        g2.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
        g2.dispose();

        return scaledImage;
    }

    public void setAction() {
        actionLockCounter++;

        if (actionLockCounter == 120) {
            direction = "left";
            actionLockCounter = 0;
        }
    }
}
