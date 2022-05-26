package coursework;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JFrame;

public class LapRacerGameBeta extends JFrame {
    int x = 0, y = 0, velx =0, vely =0;
    private int frameWidth = 1920, frameHeight = 1080;
    private Image image = new ImageIcon("C:\\Users\\Rikin\\Documents\\Homework\\Year 12\\Computer Science\\Computing Java Projects\\Coursework\\Coursework\\src\\coursework\\Red Car.png").getImage();
    private double a;
    
    public LapRacerGameBeta() {
        int mx,my;
        int i;
        boolean display_angle = false;
        int px[]={240,240,300};
        int py[]={160,240,200};
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D graphics2D = (Graphics2D)g.create();
        
        g.setColor(Color.green);
        g.fillRect(0, 0, frameWidth, frameHeight);
        
        g.setColor(Color.gray);
        g.fillRect(600, 0, 200, frameHeight);
        
        g.drawImage(image, x, y, null);
        
        g.setColor(Color.black);
        g.drawString("Lap 1: ", 20, 50);
        
        graphics2D.dispose();
    }
    
    public static void main(String[] args) {
        new LapRacerGameBeta();
	JFrame f = new JFrame();
	LapRacerGameBeta s = new LapRacerGameBeta();
	f.add(s);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setSize(1920,1080);
	f.setVisible(true);
    }
    
}