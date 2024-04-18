package Model.ModelGame;

import View.Game.CarGameView;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import Model.ModelGame.Obstacle;
import View.Game.PauseGameView;


public class Obstacles {
    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private CarGameView view;
    private int roadSpeed = 2;
    Random random = new Random();

    public Obstacles(CarGameView view) {
        this.view = view;
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Car(), roadSpeed,view.getBarrier_CarY()));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Three(), roadSpeed,view.getObstacle_ThreeY()));
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Fence(), roadSpeed,view.getBarrier_FenceY()));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Two(), roadSpeed,view.getObstacle_TwoY()));
        startGame();
    }
    public void startGame(){
        for (Obstacle obstacle : obstacles) {
            obstacle.start();
        }
    }
    public void stopGame(){
        for (Obstacle obstacle : obstacles) {
            obstacle.stopRunning();
        }
    }
    public void continueGame(){
        for (Obstacle obstacle : obstacles) {
            obstacle.countinueRunning();
        }
    }
}
