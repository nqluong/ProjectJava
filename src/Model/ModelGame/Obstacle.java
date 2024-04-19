package Model.ModelGame;

import View.Game.CarGameView;
import java.util.Random;
import javax.swing.*;

public class Obstacle extends Thread {
    private Obstacles obstacles;
    private JLabel label;
    private int y, speed;
    private boolean running = true;
    Random rd = new Random();
    private CarModel car ;
    private int score=0;
    private boolean crossed = false; 
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
                if(judgeStop()){
                    obstacles.stopGame();
                    return;
                }
                if (!crossed && label.getY() > car.getY() + car.getCarLabel().getHeight()) {
                crossed = true;
                obstacles.increasescore();
            }
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

    }
    
    public void setCar(CarModel car){
        this.car = car;
    }
    public boolean judgeStop(){
        boolean flag = false;
        int carRight = car.getX() + car.getCarLabel().getWidth();
        int carBottom = car.getY() + car.getCarLabel().getHeight();
        int obstacleRight = label.getX() + label.getWidth();
        int obstacleBottom = label.getY() + label.getHeight();
        if(car.getX() < obstacleRight && carRight > label.getX() && car.getY() < obstacleBottom && carBottom > label.getY()){
            flag = true;
        }
        return flag;
    }
    public boolean collision() {
         boolean flag = false;
        if(car.getCarLabel().getHeight() <= label.getHeight()){
            flag = true;
        }
        return flag;
    }
    public void setObstacles(Obstacles obstacles) {
        this.obstacles = obstacles;
    }
    
}
