package Model.ModelGame;

import View.Game.CarGameView;
import java.util.Random;
import javax.swing.*;

public class Obstacle extends Thread {

    private Obstacles obstacles;
    private JLabel label;
    private int x, y, speed;
    private int pauseX, pauseY;
    private boolean running = true;
    private boolean paused = false;
    Random rd = new Random();
    private CarModel car;

    public Obstacle(JLabel label, int speed, int x, int y) {
        this.label = label;
        this.speed = speed;
        this.x = x;
        this.y = y;
    }

    public void run() {
        //int preIndex = -1;
        while (running) {
            int index;
            index = rd.nextInt(4);

            int newY;

            int x = index * 80 + 10;

            while (paused) {
                try {
                    synchronized (this) {
                        wait();
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            label.setLocation(x, y);
            while (label.getY() < 700 && !paused) {
                newY = label.getY() + speed;
                label.setLocation(x, newY);
                if (judgeStop()) {
                    obstacles.stopGame();
                    return;
                }
                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //label.setLocation(x, y);
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

    public void pause() {
        paused = true;
    }
    public void resumed(){
        paused = false;
        synchronized (this) {
            notify();
        }
    }
    public void setCar(CarModel car) {
        this.car = car;
    }

    public boolean judgeStop() {
        boolean flag = false;
        int carRight = car.getX() + car.getCarLabel().getWidth();
        int carBottom = car.getY() + car.getCarLabel().getHeight();
        int obstacleRight = label.getX() + label.getWidth();
        int obstacleBottom = label.getY() + label.getHeight();
        if (car.getX() < obstacleRight && carRight > label.getX() && car.getY() < obstacleBottom && carBottom > label.getY()) {
            flag = true;
        }
        return flag;
    }

    public void setObstacles(Obstacles obstacles) {
        this.obstacles = obstacles;
    }

}
