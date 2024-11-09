package Main;

import Entitiy.Entity;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;
public class GameOverScreen {

    public static void showGameOverScreen() {
        JFrame frame = new JFrame("Game Over");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(Color.BLACK);

        JLabel label = new JLabel("YOU DIED", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 100));
        label.setForeground(Color.RED);

        frame.add(label);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}




