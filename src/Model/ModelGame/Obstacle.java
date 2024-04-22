package Model.ModelGame;

import View.Game.CarGameView;
import java.util.Random;
import javax.swing.*;

public class Obstacle extends Thread {

    private JLabel label;
    private int y, speed;
    private int x, newY;
    private volatile boolean running = true;
    Random rd = new Random();

    public Obstacle(JLabel label, int speed, int y, int x) {
        this.label = label;
        this.speed = speed;
        this.newY = -y;
        this.x = x * rd.nextInt(4) * 80 +10;
    }

    public void run() {
        //int preIndex = -1;
        while (running) {
            if(running==true){
                System.out.println("Model");
            }
            while (label.getY() < 700 && running) {
                newY += speed;
                label.setLocation(x, newY);
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            if(running == true){
                System.out.println("Model.ModelGame.Obstacle.run()");
            }
            
            if(label.getY() >= 700 && true){
                newY = -y;
                x = x* rd.nextInt(4) * 80 + 10;
            }
//            startX = x;
//            startY = newY;
//        
//            label.setLocation(startX, startY);
        }
    }

    public JLabel getLabel() {
        return label;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void stopRunning(){
        running = false;
    }
    public void countinueRunning(){
        this.running = true;
        label.setLocation(x, newY);
    }
}
