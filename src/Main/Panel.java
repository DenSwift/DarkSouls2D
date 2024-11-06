package Main;

import Entitiy.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel implements Runnable {

    // Screen settings
    final int orgTileSize = 16; // 16x16 tile
    final int scale = 3;
    public final int tileSize = orgTileSize * scale; // 48x48 tile
    public int maxScreenCol = 16;
    public int maxScreenRow = 12;
    public int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public int screenHeight = tileSize * maxScreenRow; // 576 pixels
    int FPS = 60; // frame per second

    // World settings
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final  int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxScreenRow;

    TileManager tileM = new TileManager(this);
    Thread gameThread; // Thread is something you can start and stop and once a thread started, it keeps your program running until you stop it
    KeyHandler keyH = new KeyHandler();
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[20];
    public AssetSetter aSetter = new AssetSetter(this);

    public  Panel() {
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // enabling this can improve game's rendering performance.
        this.addKeyListener(keyH);
        this.setFocusable(true); // With this, this Main.Panel can be "focused" to receive key input.
    }

    public void setupGame() {

        aSetter.setObject();
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
        player.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g; // Change graphics g to 2D

        // Tile
        tileM.draw(g2);

        // Object
        for(int i = 0; i < obj.length; i++) {
           if(obj[i] != null) {
               obj[i].draw(g2, this);
           }
        }

        // Player
        player.draw(g2);
        g2.dispose(); // Dispose of this graphics context and release any system resources that it is using.

    }
}
