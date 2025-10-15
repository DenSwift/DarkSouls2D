package Main;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setTitle("DarkSouls2D");
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Panel gamePanel = new Panel();
        window.add(gamePanel);
        window.pack(); // Causes this window to be sized to fit the preferred size and layouts of its subcomponents (Main.Panel).

        window.setLocationRelativeTo(null); // displays window at the center of the screen
        window.setVisible(true);

        gamePanel.setupGame();
        gamePanel.startGameThread();
    }
}