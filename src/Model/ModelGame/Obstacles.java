package Model.ModelGame;

import View.Game.CarGameView;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import Model.ModelGame.Obstacle;

/**
 *
 * @author nguye
 */
public class Obstacles {

    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private CarGameView view;
    private int roadSpeed = 2;
    private volatile int score=0;
    Random random = new Random();

    public Obstacles(CarGameView view, CarModel car) {
        this.view = view;
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Car(), roadSpeed, view.getjLabel_Barrier_Car().getX(),0));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Three(), roadSpeed,view.getjLabelObstacle_Three().getX(), -100));
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Fence(), roadSpeed,view.getjLabel_Barrier_Fence().getX(), -200));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Two(), roadSpeed, view.getjLabelObstacle_Two().getX(),-300));
        for (Obstacle obstacle : obstacles) {
            obstacle.setCar(car);
            obstacle.setObstacles(this);
        }
        startGame();
    }

    public void startGame() {
        for (Obstacle obstacle : obstacles) {
            obstacle.start();
        }
    }

    public void stopGame() {
        for (Obstacle obstacle : obstacles) {
            int x = obstacle.getLabel().getX();
            int y = obstacle.getLabel().getY();
            //obstacle.stopRunning();
//            obstacle.getLabel().setLocation(x, y);
        }
        view.showGameOver();

    }
    
    public void pauseGame(){
        for (Obstacle obstacle : obstacles) {
            obstacle.pause();
        }
    }
    public void increasescore() {
        score += 100; 
        view.getjTextField_Point().setText(Integer.toString(score));
    }
//    public void continueGame(){
//        for (Obstacle obstacle : obstacles) {
//            obstacle.countinueRunning();
//        }
//    }
}
