package Model.ModelGame;

import View.Game.CarGameView;
import java.util.Random;
import javax.swing.*;

public class Obstacle extends Thread {

    private JLabel label;
    private int y, speed;
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

            label.setLocation(x, y);
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
        label.setLocation(label.getX(),label.getY());
    }
    public void countinueRunning(){
        this.running = true;
        label.setLocation(label.getX(), label.getY());
    }
}
