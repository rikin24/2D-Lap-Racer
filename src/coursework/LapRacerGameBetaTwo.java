package coursework;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JFrame;

public class LapRacerGameBetaTwo extends JFrame {
    private int frameWidth = 1920, frameHeight = 1080;
    
    public LapRacerGameBetaTwo() {
        setBounds(0,0, frameWidth, frameHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g.create();
        
        g.setColor(Color.green);
        g.fillRect(0, 0, frameWidth, frameHeight);
        
        g.setColor(Color.gray);
        g.fillRect(600, 0, 200, frameHeight);
        

        
        g.setColor(Color.black);
        g.drawString("Lap 1: ", 20, 50);
        
        graphics2D.dispose();
    }

    public static void main(String[] args) {
        new LapRacerGameBetaTwo().setVisible(true);
    }
    
}
