package c21394693;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
 * This class creates a "dude" sprite (still trying to figure out image loading)
 * and runs a background image to make it look like hes moving through a town
 * Background image isn't working here but was on my local files will be looking into that
 * dude can jump and we have a "lamp" which will eventually be a streetlamp that moves across the screen to simulate movment
 * Hopefully I can replace with a scrolling background
 * Music to be added and other events to make it actually fun to watch
 * Jump works pretty well though
 */

public class longWalkHome extends JFrame {

    private static final int WINDOW_WIDTH = 1200; // Width of game window
    private static final int WINDOW_HEIGHT = 600; // Height of game window
    private static final int GROUND_HEIGHT = 50; // Height of the ground

    private boolean isJumping = false;
    private int dudeY = WINDOW_HEIGHT - GROUND_HEIGHT - 100; // Y-coordinate of the dude
    private int dudeYSpeed = 0; // Vertical speed of the dude
    private int lampX = WINDOW_WIDTH; // X-coordinate of the lamp
    Image backgroundImage;
    Image dudeImage;
    Image streetLampImage;

    public longWalkHome() {
        setTitle("Long Walk Home");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                backgroundImage = new ImageIcon("Shapes_and_Sprites/street.png").getImage();
                dudeImage = new ImageIcon("Shapes_and_Sprites/dude.png").getImage();
                

                Graphics2D g2D = (Graphics2D) g;
                // background town image
                g2D.drawImage(backgroundImage, 0, 0, null);

                // Draw ground
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(0, WINDOW_HEIGHT - GROUND_HEIGHT, WINDOW_WIDTH, GROUND_HEIGHT);

                // Draw dude
                //g.setColor(Color.BLACK);
                //g.fillRect(100, dudeY, 50, 50);
                g2D.drawImage(dudeImage, 100, dudeY, null);

                // Draw "lamp"
                g.setColor(Color.GRAY);
                g.fillRect(lampX, WINDOW_HEIGHT - GROUND_HEIGHT - 50, 20, 100);

            }
        };

        panel.setFocusable(true);
        panel.requestFocus();
        panel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE && !isJumping) {
                    // Space key is pressed and dude is not already jumping
                    isJumping = true;
                    dudeYSpeed = -10; // Set vertical speed to negative value to make the dude jump
                }
            }
        });

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update dudes position
                dudeY += dudeYSpeed;
                dudeYSpeed += 1; // Apply gravity
                if (dudeY > WINDOW_HEIGHT - GROUND_HEIGHT - 50) {
                    // dude has landed on the ground
                    dudeY = WINDOW_HEIGHT - GROUND_HEIGHT - 50;
                    dudeYSpeed = 0;
                    isJumping = false;
                }

                // Update lamps position
                lampX -= 5; // Move lamp towards left
                if (lampX < -50) {
                    // lamp has moved outside of the game window
                    lampX = WINDOW_WIDTH; // Reset lamps position to the right edge of the window
                }
                panel.repaint(); // Repaint the panel to update the game graphics
            }
        });

        timer.start();
        add(panel); // Add the panel to the JFrame
        setVisible(true); // Set JFrame visible
    }

}
