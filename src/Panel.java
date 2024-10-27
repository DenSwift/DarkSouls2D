import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {

    // Screen settings
    final int orgTileSize = 16; // 16x16 tile
    final int scale = 3;
    final int tileSize = orgTileSize * scale; // 48x48 tile
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 576 pixels
    int FPS = 60; // frame per second

    Thread gameThread; // Thread is something you can start and stop and once a thread started, it keeps your program running until you stop it
    KeyHandler keyH = new KeyHandler();

    // Set player's def settings
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 5; // pixels


    public  Panel() {
       this.setPreferredSize(new Dimension(screenWidth,screenHeight));
       this.setBackground(Color.black);
       this.setDoubleBuffered(true); // enabling this can improve game's rendering performance.
        this.addKeyListener(keyH);
        this.setFocusable(true); // With this, this Panel can be "focused" to receive key input.
    }

    public  void startGameThread() {
      gameThread = new Thread(this);
      gameThread.start();
    }

    @Override
    public void run() { // Game Loop

        double drawInterval = 1000000000/FPS; // 1 second / FPS (0.016666 sec)
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null) {

            long currentTime = System.nanoTime();

          // UPDATE: info such as character positions
            update();
          // DRAW: draw the screen with the updated info
            repaint(); // paintComponent()

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void update() {
        // In Java the upper left corner is X:0 V:0
        if (keyH.up) { // X values increases to the right
            playerY -= playerSpeed; // Y values increases as they go down
        } else if (keyH.down) {
            playerY += playerSpeed;
        } else if (keyH.left) {
            playerX -= playerSpeed;
        } else if (keyH.right) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; // Change graphics g to 2D
        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);
        g2.dispose(); // Dispose of this graphics context and release any system resources that it is using.

    }
}
