package Model.ModelGame;

import View.Game.CarGameView;
import java.util.Random;
import javax.swing.*;

public class Obstacle extends Thread {

    private JLabel label;
    private int y, speed, startX, startY;
    private boolean running = true;
    Random rd = new Random();

    public Obstacle(JLabel label, int speed, int y) {
        this.label = label;
        this.speed = speed;
        this.y = y;
    }

    public void run() {
        //int preIndex = -1;
        while (running) {
            int index;
            index = rd.nextInt(4);

            int newY = -y;
            int x = index * 80 + 10;

            while (label.getY() < 700 && running) {
                newY += speed;
                label.setLocation(x, newY);
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
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
        label.setLocation(startX, startY);
    }
}
