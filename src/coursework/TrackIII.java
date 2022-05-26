/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Rikin
 */
public class TrackIII extends javax.swing.JFrame {
    JLabel userCar;
    Graphics g;
    boolean intersects = false;
    static int ms = 0;
    static int s = 0;
    static int m = 0;
    static boolean state = true;
    /**
     * Creates new form TrackIII
     */
    public TrackIII() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        jLabel19.setVisible(false);
        jLabel18.setVisible(false);
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
        jLabel14.setVisible(false);
        jLabel15.setVisible(false);
        jLabel16.setVisible(false);
        jLabel17.setVisible(false);
                
        try(BufferedReader br = new BufferedReader(new FileReader("Car.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }   
        String car = sb.toString();
        
        if(car.contains("Purple Car")){
            userCar = jLabel9;
        }
        if(car.contains("Blue Car")){
            userCar = jLabel18;
        }
        if(car.contains("Green Car")){
            userCar = jLabel11;
        }
        if(car.contains("Red Car")){
            userCar = jLabel12;
        }
        if(car.contains("Orange Car")){
            userCar = jLabel13;
        }
        if(car.contains("Yellow Car")){
            userCar = jLabel14;
        }
        if(car.contains("White Car (Special)")){
            userCar = jLabel15;
        }
        if(car.contains("Light Blue Car (Special)")){
            userCar = jLabel16;
        }
        if(car.contains("Pink Car (Special)")){
            userCar = jLabel17;
        }
        
        userCar.setVisible(true);
        
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

        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        finishLine = new javax.swing.JLabel();
        minutes = new javax.swing.JLabel();
        seconds = new javax.swing.JLabel();
        milliseconds = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Pink Car (Special) 3.png"))); // NOI18N
        getContentPane().add(jLabel17);
        jLabel17.setBounds(540, 220, 50, 25);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Light Blue Car (Special) 3.png"))); // NOI18N
        getContentPane().add(jLabel16);
        jLabel16.setBounds(540, 220, 50, 25);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/White Car (Special) 3.png"))); // NOI18N
        getContentPane().add(jLabel15);
        jLabel15.setBounds(540, 220, 50, 25);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Yellow Car 3.png"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(540, 220, 50, 25);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Orange Car 3.png"))); // NOI18N
        getContentPane().add(jLabel13);
        jLabel13.setBounds(540, 220, 50, 25);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Red Car 3.png"))); // NOI18N
        getContentPane().add(jLabel12);
        jLabel12.setBounds(540, 220, 50, 25);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Green Car 3.png"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(540, 220, 50, 25);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Blue Car 3.png"))); // NOI18N
        getContentPane().add(jLabel18);
        jLabel18.setBounds(540, 220, 50, 25);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Purple Car 3.png"))); // NOI18N
        getContentPane().add(jLabel19);
        jLabel19.setBounds(540, 220, 50, 25);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Pile of Tires 3.png"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(310, 460, 30, 10);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Pile of Tires 3.png"))); // NOI18N
        getContentPane().add(jLabel9);
        jLabel9.setBounds(945, 390, 25, 20);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Pile of Tires 3.png"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(680, 470, 30, 20);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Oil Spill 3.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(460, 640, 30, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Oil Spill 3.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(910, 560, 30, 20);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Oil Spill 3.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(730, 240, 30, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Traffic Cone 3.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(232, 240, 20, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Start-Finish Line 3.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(530, 200, 40, 60);
        getContentPane().add(finishLine);
        finishLine.setBounds(520, 210, 10, 50);

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

        milliseconds.setFont(new java.awt.Font("Terminator Two", 0, 26)); // NOI18N
        milliseconds.setForeground(new java.awt.Color(0, 54, 224));
        milliseconds.setText(". 00");
        getContentPane().add(milliseconds);
        milliseconds.setBounds(1250, 20, 110, 30);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Track 3 (Medium).png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 100, 920, 730);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coursework/Track Background.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1370, 770);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        Graphics g = userCar.getGraphics();
        
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
            java.util.logging.Logger.getLogger(TrackIII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrackIII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrackIII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrackIII.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrackIII().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel finishLine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel milliseconds;
    private javax.swing.JLabel minutes;
    private javax.swing.JLabel seconds;
    // End of variables declaration//GEN-END:variables
}
