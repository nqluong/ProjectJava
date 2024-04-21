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

    public Obstacles(CarGameView view, CarModel car) {
        this.view = view;
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Car(), roadSpeed));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Three(), roadSpeed));
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Fence(), roadSpeed ));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Two(), roadSpeed));
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

           // obstacle.interrupt();
          obstacle.stopRunning();
        }
        //view.showGameOver();

    }
    
    public void pauseGame(){
        for (Obstacle obstacle : obstacles) {
            obstacle.pause();
        }
    }
    public void continueGame(){
        for (Obstacle obstacle : obstacles) {
            obstacle.continueGame();
        }}
    public void increasescore() {
        score += 100; 
        view.getjTextField_Point().setText(Integer.toString(score));
    }
//    public void continueGame(){
//        for (Obstacle obstacle : obstacles) {
//            obstacle.countinueRunning();
//        }
//    }

    public void setRoadSpeed(int roadSpeed) {
        this.roadSpeed = roadSpeed;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
