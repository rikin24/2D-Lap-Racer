/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.Thread.sleep;
import javax.swing.SwingUtilities;
/**
 *
 * @author Rikin
 */
public class TrackI extends javax.swing.JFrame {
    JLabel userCar;
    Graphics g;
    boolean intersects = false;
    static int ms = 0;
    static int s = 0;
    static int m = 0;
    static boolean state = true;
    
    public TrackI() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        purpleCar.setVisible(false);
        blueCar.setVisible(false);
        greenCar.setVisible(false);
        redCar.setVisible(false);
        orangeCar.setVisible(false);
        yellowCar.setVisible(false);
        whiteCar.setVisible(false);
        lightBlueCar.setVisible(false);
        pinkCar.setVisible(false);
        //Initially sets all cars to be invisible
        
        try(BufferedReader br = new BufferedReader(new FileReader("Car.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }   
        String car = sb.toString();
        //Reads the car text file and stores its contents in the string car
        
        if(car.contains("Purple Car")){
            userCar = purpleCar;
        }
        if(car.contains("Blue Car")){
            userCar = blueCar;
        }
        if(car.contains("Green Car")){
            userCar = greenCar;
        }
        if(car.contains("Red Car")){
            userCar = redCar;
        }
        if(car.contains("Orange Car")){
            userCar = orangeCar;
        }
        if(car.contains("Yellow Car")){
            userCar = yellowCar;
        }
        if(car.contains("White Car (Special)")){
            userCar = whiteCar;
        }
        if(car.contains("Light Blue Car (Special)")){
            userCar = lightBlueCar;
        }
        if(car.contains("Pink Car (Special)")){
            userCar = pinkCar;
        }
        //Sets the chosen car to be stored in the JLabel userCar
        
        userCar.setVisible(true);
        //Sets the user's chosen car to be visible
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TrackMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TrackMenuUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        userCar.setBounds(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight());
        
        minutes.setText("00");
        seconds.setText(". 00");
        milliseconds.setText(". 00");
        
        state = true;
        Thread t = new Thread(){
            //Creates new thread to run code simultaneously with rest of program
            public void run(){
                for(;;){
                    if(state==true){
                        try{
                            sleep(1);
                            //Thread sleeps to allow a millisecond to pass
                            if(ms>1000){
                                ms = 0;
                                s++;
                                //Converts 1000 milliseconds to 1 second
                            }
                            if(s>60){
                                ms = 0;
                                s = 0;
                                m++;
                                //Converts 60 seconds to 1 minute
                            }
                            milliseconds.setText(". " + ms);
                            ms++;
                            seconds.setText(". " + s);
                            minutes.setText("" + m);
                            //Displays time onto JLabels
                        }
                        catch(Exception e){ 
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        };
        t.start();
        
    }
    
    public Graphics2D paintComponent(Graphics2D g){
        Graphics2D g2d = (Graphics2D) g;
        //Calls in Graphics2D library
        g2d.rotate(Math.toRadians(10), userCar.getWidth()/2, userCar.getHeight()/2);
        super.paint(g);
        //Rotates the image clockwise by 10 degrees
        return g;
    }
    
    public boolean b1(JLabel userCar, JLabel barrier1){
        Rectangle rectB = barrier1.getBounds();
        //Creates a rectangle around the barrier to represent a hit box
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
        //Returns a result of collision where the 2 labels intersect
    }
    
    public boolean b2(JLabel userCar, JLabel barrier2){
        Rectangle rectB = barrier2.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b3(JLabel userCar, JLabel barrier3){
        Rectangle rectB = barrier3.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b4(JLabel userCar, JLabel barrier4){
        Rectangle rectB = barrier4.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b5(JLabel userCar, JLabel barrier5){
        Rectangle rectB = barrier5.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b6(JLabel userCar, JLabel barrier6){
        Rectangle rectB = barrier6.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b7(JLabel userCar, JLabel barrier7){
        Rectangle rectB = barrier7.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b8(JLabel userCar, JLabel barrier8){
        Rectangle rectB = barrier8.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b9(JLabel userCar, JLabel barrier9){
        Rectangle rectB = barrier9.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b10(JLabel userCar, JLabel barrier10){
        Rectangle rectB = barrier10.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b11(JLabel userCar, JLabel barrier11){
        Rectangle rectB = barrier11.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b12(JLabel userCar, JLabel barrier12){
        Rectangle rectB = barrier12.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b13(JLabel userCar, JLabel barrier13){
        Rectangle rectB = barrier13.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b14(JLabel userCar, JLabel barrier14){
        Rectangle rectB = barrier14.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b15(JLabel userCar, JLabel barrier15){
        Rectangle rectB = barrier15.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b16(JLabel userCar, JLabel barrier16){
        Rectangle rectB = barrier16.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b17(JLabel userCar, JLabel barrier17){
        Rectangle rectB = barrier17.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b18(JLabel userCar, JLabel barrier18){
        Rectangle rectB = barrier18.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b19(JLabel userCar, JLabel barrier19){
        Rectangle rectB = barrier19.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b20(JLabel userCar, JLabel barrier20){
        Rectangle rectB = barrier20.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b21(JLabel userCar, JLabel barrier21){
        Rectangle rectB = barrier21.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b22(JLabel userCar, JLabel barrier22){
        Rectangle rectB = barrier22.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b23(JLabel userCar, JLabel barrier23){
        Rectangle rectB = barrier23.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b24(JLabel userCar, JLabel barrier24){
        Rectangle rectB = barrier24.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b25(JLabel userCar, JLabel barrier25){
        Rectangle rectB = barrier25.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b26(JLabel userCar, JLabel barrier26){
        Rectangle rectB = barrier26.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean b27(JLabel userCar, JLabel barrier27){
        Rectangle rectB = barrier27.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    
    public boolean o1(JLabel userCar, JLabel obstacle1){
        Rectangle rectB = obstacle1.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean o2(JLabel userCar, JLabel obstacle2){
        Rectangle rectB = obstacle2.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    public boolean o3(JLabel userCar, JLabel obstacle3){
        Rectangle rectB = obstacle3.getBounds();
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
    }
    
    
    public boolean finish(JLabel userCar, JLabel finishLine){
        Rectangle rectB = finishLine.getBounds();
        //Creates a rectangle around the barrier to represent a hit box
        Rectangle result = SwingUtilities.computeIntersection(userCar.getX(), userCar.getY(), userCar.getWidth(), userCar.getHeight(), rectB);
        return (result.getWidth() > 0 && result.getHeight() > 0);
        //Returns a result of collision where the 2 labels intersect
    }
    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pinkCar = new javax.swing.JLabel();
        lightBlueCar = new javax.swing.JLabel();
        whiteCar = new javax.swing.JLabel();
        yellowCar = new javax.swing.JLabel();
        orangeCar = new javax.swing.JLabel();
        redCar = new javax.swing.JLabel();
        greenCar = new javax.swing.JLabel();
        blueCar = new javax.swing.JLabel();
        purpleCar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        finishLine = new javax.swing.JLabel();
        obstacle3 = new javax.swing.JLabel();
        obstacle2 = new javax.swing.JLabel();
        obstacle1 = new javax.swing.JLabel();
        barrier27 = new javax.swing.JLabel();
        barrier26 = new javax.swing.JLabel();
        barrier25 = new javax.swing.JLabel();
        barrier24 = new javax.swing.JLabel();
        barrier23 = new javax.swing.JLabel();
        barrier22 = new javax.swing.JLabel();
        barrier21 = new javax.swing.JLabel();
        barrier20 = new javax.swing.JLabel();
        barrier19 = new javax.swing.JLabel();
        barrier18 = new javax.swing.JLabel();
        barrier17 = new javax.swing.JLabel();
        barrier16 = new javax.swing.JLabel();
        barrier15 = new javax.swing.JLabel();
        barrier14 = new javax.swing.JLabel();
        barrier13 = new javax.swing.JLabel();
        barrier12 = new javax.swing.JLabel();
        barrier11 = new javax.swing.JLabel();
        barrier10 = new javax.swing.JLabel();
        barrier9 = new javax.swing.JLabel();
        barrier8 = new javax.swing.JLabel();
        barrier7 = new javax.swing.JLabel();
        barrier6 = new javax.swing.JLabel();
        barrier5 = new javax.swing.JLabel();
        barrier4 = new javax.swing.JLabel();
        barrier3 = new javax.swing.JLabel();
        barrier2 = new javax.swing.JLabel();
        barrier1 = new javax.swing.JLabel();
        milliseconds = new javax.swing.JLabel();
        minutes = new javax.swing.JLabel();
        seconds = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        pinkCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Pink Car (Special) 3.png"))); // NOI18N
        pinkCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(pinkCar);
        pinkCar.setBounds(540, 140, 50, 25);

        lightBlueCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Light Blue Car (Special) 3.png"))); // NOI18N
        lightBlueCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lightBlueCar);
        lightBlueCar.setBounds(540, 140, 50, 25);

        whiteCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/White Car (Special) 3.png"))); // NOI18N
        whiteCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(whiteCar);
        whiteCar.setBounds(540, 140, 50, 25);

        yellowCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Yellow Car 3.png"))); // NOI18N
        yellowCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(yellowCar);
        yellowCar.setBounds(540, 140, 50, 25);

        orangeCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Orange Car 3.png"))); // NOI18N
        orangeCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(orangeCar);
        orangeCar.setBounds(540, 140, 50, 25);

        redCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Red Car 3.png"))); // NOI18N
        redCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(redCar);
        redCar.setBounds(540, 140, 50, 25);

        greenCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Green Car 3.png"))); // NOI18N
        greenCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(greenCar);
        greenCar.setBounds(540, 140, 50, 25);

        blueCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Blue Car 3.png"))); // NOI18N
        blueCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(blueCar);
        blueCar.setBounds(540, 140, 50, 25);

        purpleCar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Purple Car 3.png"))); // NOI18N
        purpleCar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(purpleCar);
        purpleCar.setBounds(540, 140, 50, 25);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Start-Finish Line 2.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(530, 120, 50, 70);
        getContentPane().add(finishLine);
        finishLine.setBounds(520, 120, 10, 70);

        obstacle3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Traffic Cone 2.png"))); // NOI18N
        getContentPane().add(obstacle3);
        obstacle3.setBounds(310, 530, 30, 40);

        obstacle2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Pile of Tires 2.png"))); // NOI18N
        getContentPane().add(obstacle2);
        obstacle2.setBounds(870, 390, 50, 28);

        obstacle1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Oil Spill 2.png"))); // NOI18N
        getContentPane().add(obstacle1);
        obstacle1.setBounds(780, 160, 50, 30);
        getContentPane().add(barrier27);
        barrier27.setBounds(300, 100, 60, 40);
        getContentPane().add(barrier26);
        barrier26.setBounds(290, 140, 40, 40);
        getContentPane().add(barrier25);
        barrier25.setBounds(720, 380, 40, 40);
        getContentPane().add(barrier24);
        barrier24.setBounds(1090, 340, 40, 30);
        getContentPane().add(barrier23);
        barrier23.setBounds(780, 610, 40, 40);
        getContentPane().add(barrier22);
        barrier22.setBounds(750, 630, 40, 40);
        getContentPane().add(barrier21);
        barrier21.setBounds(800, 580, 40, 30);
        getContentPane().add(barrier20);
        barrier20.setBounds(1070, 370, 40, 40);
        getContentPane().add(barrier19);
        barrier19.setBounds(310, 590, 20, 50);
        getContentPane().add(barrier18);
        barrier18.setBounds(1040, 400, 40, 30);
        getContentPane().add(barrier17);
        barrier17.setBounds(1090, 160, 20, 40);
        getContentPane().add(barrier16);
        barrier16.setBounds(1070, 140, 30, 30);
        getContentPane().add(barrier15);
        barrier15.setBounds(730, 340, 60, 40);
        getContentPane().add(barrier14);
        barrier14.setBounds(1040, 120, 40, 20);
        getContentPane().add(barrier13);
        barrier13.setBounds(320, 630, 50, 30);
        getContentPane().add(barrier12);
        barrier12.setBounds(1100, 200, 20, 140);
        getContentPane().add(barrier11);
        barrier11.setBounds(830, 420, 210, 20);
        getContentPane().add(barrier10);
        barrier10.setBounds(810, 440, 20, 130);
        getContentPane().add(barrier9);
        barrier9.setBounds(360, 650, 390, 20);
        getContentPane().add(barrier8);
        barrier8.setBounds(290, 180, 20, 440);
        getContentPane().add(barrier7);
        barrier7.setBounds(720, 390, 20, 170);
        getContentPane().add(barrier6);
        barrier6.setBounds(390, 560, 340, 20);
        getContentPane().add(barrier5);
        barrier5.setBounds(770, 330, 240, 20);
        getContentPane().add(barrier4);
        barrier4.setBounds(380, 200, 20, 360);
        getContentPane().add(barrier3);
        barrier3.setBounds(1000, 200, 20, 140);
        getContentPane().add(barrier2);
        barrier2.setBounds(400, 190, 600, 20);
        getContentPane().add(barrier1);
        barrier1.setBounds(360, 100, 690, 20);

        milliseconds.setFont(new java.awt.Font("Terminator Two", 0, 26)); // NOI18N
        milliseconds.setForeground(new java.awt.Color(0, 54, 224));
        milliseconds.setText(". 00");
        getContentPane().add(milliseconds);
        milliseconds.setBounds(1250, 20, 110, 30);

        minutes.setFont(new java.awt.Font("Terminator Two", 0, 26)); // NOI18N
        minutes.setForeground(new java.awt.Color(0, 54, 224));
        minutes.setText("00");
        getContentPane().add(minutes);
        minutes.setBounds(1140, 20, 80, 30);

        seconds.setFont(new java.awt.Font("Terminator Two", 0, 26)); // NOI18N
        seconds.setForeground(new java.awt.Color(0, 54, 224));
        seconds.setText(". 00");
        getContentPane().add(seconds);
        seconds.setBounds(1180, 20, 80, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Track 1 (Easy).png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(230, 110, 920, 620);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Track Background.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        Graphics g = userCar.getGraphics();
        
        
        if(b1(userCar, barrier1)){
            userCar.setLocation(540, 140);
            //Teleports car back to start line
        }
        if(b2(userCar, barrier2)){
            userCar.setLocation(540, 140);
        }
        if(b3(userCar, barrier3)){
            userCar.setLocation(540, 140);
        }
        if(b4(userCar, barrier4)){
            userCar.setLocation(540, 140);
        }
        if(b5(userCar, barrier5)){
            userCar.setLocation(540, 140);
        }
        if(b6(userCar, barrier6)){
            userCar.setLocation(540, 140);
        }
        if(b7(userCar, barrier7)){
            userCar.setLocation(540, 140);
        }
        if(b8(userCar, barrier8)){
            userCar.setLocation(540, 140);
        }
        if(b9(userCar, barrier9)){
            userCar.setLocation(540, 140);
        }
        if(b10(userCar, barrier10)){
            userCar.setLocation(540, 140);
        }
        if(b11(userCar, barrier11)){
            userCar.setLocation(540, 140);
        }
        if(b12(userCar, barrier12)){
            userCar.setLocation(540, 140);
        }
        if(b13(userCar, barrier13)){
            userCar.setLocation(540, 140);
        }
        if(b14(userCar, barrier14)){
            userCar.setLocation(540, 140);
        }
        if(b15(userCar, barrier15)){
            userCar.setLocation(540, 140);
        }
        if(b16(userCar, barrier16)){
            userCar.setLocation(540, 140);
        }
        if(b17(userCar, barrier17)){
            userCar.setLocation(540, 140);
        }
        if(b18(userCar, barrier18)){
            userCar.setLocation(540, 140);
        }
        if(b19(userCar, barrier19)){
            userCar.setLocation(540, 140);
        }
        if(b20(userCar, barrier20)){
            userCar.setLocation(540, 140);
        }
        if(b21(userCar, barrier21)){
            userCar.setLocation(540, 140);
        }
        if(b22(userCar, barrier22)){
            userCar.setLocation(540, 140);
        }
        if(b23(userCar, barrier23)){
            userCar.setLocation(540, 140);
        }
        if(b24(userCar, barrier24)){
            userCar.setLocation(540, 140);
        }
        if(b25(userCar, barrier25)){
            userCar.setLocation(540, 140);
        }
        if(b26(userCar, barrier26)){
            userCar.setLocation(540, 140);
        }
        if(b27(userCar, barrier27)){
            userCar.setLocation(540, 140);
        }
        
        
        if(o1(userCar, obstacle1)){
            userCar.setLocation(540, 140);
        }
        if(o2(userCar, obstacle2)){
            userCar.setLocation(540, 140);
        }
        if(o3(userCar, obstacle3)){
            userCar.setLocation(540, 140);
        }
        
        
        if(finish(userCar, finishLine)){
            state = false;
            //Stops timer
            String mTime = minutes.getText();
            String sTime = seconds.getText();
            String msTime = milliseconds.getText();
            PrintWriter writer = null;
                try {
                    writer = new PrintWriter("LapTime.txt", "UTF-8");
                    writer.println(mTime + " " + sTime + " " + msTime);
                    writer.close();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(CarMenuUI.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedEncodingException ex) {
                    Logger.getLogger(CarMenuUI.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    writer.close();
                }
                //Writes lap time into text file
            try {
                new FinishedRace().setVisible(true);
                //Opens congratulations pop up screen
            } catch (IOException ex) {
                Logger.getLogger(TrackI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        int key = evt.getKeyCode();
        //Calls for code corresponding to each key on the keyboard
        
        switch(key){
            case KeyEvent.VK_UP:
                userCar.setLocation(userCar.getLocation().x, userCar.getLocation().y - 3);
                break;
                //Moves the car up
                
            case KeyEvent.VK_DOWN:
                userCar.setLocation(userCar.getLocation().x, userCar.getLocation().y + 3);
                break;
                //Moves the car down
                
            case KeyEvent.VK_LEFT:
                userCar.setLocation(userCar.getLocation().x - 3, userCar.getLocation().y);
                break;
                //Moves the car left
                
            case KeyEvent.VK_RIGHT:
                paintComponent((Graphics2D) g);
                break;
                //Rotates the car right
        }
        
    }//GEN-LAST:event_formKeyPressed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrackI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackI().setVisible(true);
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barrier1;
    private javax.swing.JLabel barrier10;
    private javax.swing.JLabel barrier11;
    private javax.swing.JLabel barrier12;
    private javax.swing.JLabel barrier13;
    private javax.swing.JLabel barrier14;
    private javax.swing.JLabel barrier15;
    private javax.swing.JLabel barrier16;
    private javax.swing.JLabel barrier17;
    private javax.swing.JLabel barrier18;
    private javax.swing.JLabel barrier19;
    private javax.swing.JLabel barrier2;
    private javax.swing.JLabel barrier20;
    private javax.swing.JLabel barrier21;
    private javax.swing.JLabel barrier22;
    private javax.swing.JLabel barrier23;
    private javax.swing.JLabel barrier24;
    private javax.swing.JLabel barrier25;
    private javax.swing.JLabel barrier26;
    private javax.swing.JLabel barrier27;
    private javax.swing.JLabel barrier3;
    private javax.swing.JLabel barrier4;
    private javax.swing.JLabel barrier5;
    private javax.swing.JLabel barrier6;
    private javax.swing.JLabel barrier7;
    private javax.swing.JLabel barrier8;
    private javax.swing.JLabel barrier9;
    private javax.swing.JLabel blueCar;
    private javax.swing.JLabel finishLine;
    private javax.swing.JLabel greenCar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lightBlueCar;
    private javax.swing.JLabel milliseconds;
    private javax.swing.JLabel minutes;
    private javax.swing.JLabel obstacle1;
    private javax.swing.JLabel obstacle2;
    private javax.swing.JLabel obstacle3;
    private javax.swing.JLabel orangeCar;
    private javax.swing.JLabel pinkCar;
    private javax.swing.JLabel purpleCar;
    private javax.swing.JLabel redCar;
    private javax.swing.JLabel seconds;
    private javax.swing.JLabel whiteCar;
    private javax.swing.JLabel yellowCar;
    // End of variables declaration//GEN-END:variables
}
