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
    private boolean allRandom = true;
    Random rd = new Random();
    private CarModel car;
    private int score = 0;
    private boolean crossed = false;
    private boolean isSound = true;
    public Obstacle(JLabel label, int speed, int y) {
        this.label = label;
        this.speed = speed;
        this.y = y;
    }

    public void run() {
        while (running) {
            if (paused) {
                try {
                    sleep(10);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (allRandom) {
                int index = rd.nextInt(4);
                x = index * 80 + 10;
            } else {
                x = pauseX;
            }
            allRandom = true;
            while (label.getY() < 700 && !paused && running) {
                int newY = label.getY() + speed;
                label.setLocation(x, newY);
                if (judgeStop()) {
                    obstacles.overGame();
                }
                if (!crossed && label.getY() > car.getY() + car.getCarLabel().getHeight()) {
                    crossed = true;
                    if(isSound){
                        obstacles.playSound("Sound/VuotVatCan.wav");
                    }
                    obstacles.increasescore();
                }
                try {
                    sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            crossed = false;
            if (!paused) {
                label.setLocation(x, y);
            }
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

    public void overGame() {
        running = false;
    }

    public void pause() {
        paused = true;
        pauseX = label.getX();
        pauseY = label.getY();
    }

    public void setCar(CarModel car) {
        this.car = car;
    }

    public void continueGame() {
        paused = false;
        allRandom = false;
        label.setLocation(pauseX, pauseY);
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

    public boolean collision() {
        boolean flag = false;
        if (car.getCarLabel().getHeight() <= label.getHeight()) {
            flag = true;
        }
        return flag;
    }

    public void setObstacles(Obstacles obstacles) {
        this.obstacles = obstacles;
    }

    public int getScore() {
        return score;
    }

    public void setIsSound(boolean isSound) {
        this.isSound = isSound;
    }
    
}