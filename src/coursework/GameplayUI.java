package coursework;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameplayUI extends javax.swing.JFrame {
    JLabel userCar;
    private ImageIcon track;
    private JLabel label;
    public GameplayUI(){
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        track = new ImageIcon(getClass().getResource("Track 1 (Easy).png"));
        label = new JLabel(track);
        label.setBounds(100, 100, 100, 100);
        add(label);
    }
    
    public static void main(String[] args) {
        JFrame gameplay = new GameplayUI();
        gameplay.getContentPane().setBackground(Color.GREEN);
        gameplay.setUndecorated(true);
        gameplay.setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameplay.setSize(1366, 768);
        gameplay.setVisible(true);
    }
    
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
    }
}


