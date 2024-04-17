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
    Random random = new Random();

    public Obstacles(CarGameView view) {
        this.view = view;
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Car(), roadSpeed,0));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Three(), roadSpeed,100));
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Fence(), roadSpeed,200));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Two(), roadSpeed,300));
        startGame();
    }
    public void startGame(){
        for (Obstacle obstacle : obstacles) {
            obstacle.start();
        }
    }
}
