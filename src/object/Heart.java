package object;

import Main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Heart extends SuperObject {
    Panel p;
    public Heart(Panel p) {
        this.p = p;
        name = "Heart";
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/res/tiles/heart_full.png"));
            image2 = ImageIO.read(getClass().getResourceAsStream("/res/tiles/heart_half.png"));
            image3 = ImageIO.read(getClass().getResourceAsStream("/res/tiles/heart_blank.png"));
            int scaledWidth = p.tileSize;  // Set desired width, e.g., panel's tile size
            int scaledHeight = p.tileSize; // Set desired height

            image = scaleImage(image, scaledWidth, scaledHeight);
            image2 = scaleImage(image2, scaledWidth, scaledHeight);
            image3 = scaleImage(image3, scaledWidth, scaledHeight);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to scale a BufferedImage
    private BufferedImage scaleImage(BufferedImage originalImage, int width, int height) {
        Image scaledImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage bufferedScaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Draw the scaled image onto a BufferedImage
        Graphics2D g2d = bufferedScaledImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();

        return bufferedScaledImage;
    }
}
