package Model.ModelGame;

import View.Game.CarGameView;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;
import Model.ModelGame.Obstacle;
import View.Game.RoadLabel;

/**
 *
 * @author nguye
 */
public class Obstacles {

    private ArrayList<Obstacle> obstacles = new ArrayList<>();
    private CarGameView view;
    private CoinModel coin;
    private RoadLabel road;
    private int roadSpeed = 2;
    private volatile int score = 0;

    public Obstacles(CarGameView view, CarModel car, CoinModel coin, RoadLabel road) {
        this.view = view;
        this.coin = coin;
        this.road = road;
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Car(), roadSpeed, -200));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Three(), roadSpeed, -300));
        obstacles.add(new Obstacle(view.getjLabel_Barrier_Fence(), roadSpeed, -400));
        obstacles.add(new Obstacle(view.getjLabelObstacle_Two(), roadSpeed, -500));
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

    public void overGame() {
        coin.overGame();
        road.overGame();
        for (Obstacle obstacle : obstacles) {
            obstacle.overGame();
        }
        view.showGameOver();
    }

    public void pauseGame() {
        for (Obstacle obstacle : obstacles) {
            obstacle.pause();
        }
        coin.pauseGame();
        road.pauseAnimation();
    }

    public void continueGame() {
        for (Obstacle obstacle : obstacles) {
            obstacle.continueGame();
        }
        coin.continueGame();
        road.resumeAnimation();
    }

    public void increasescore() {
        score += 100;
        view.getjTextField_Point().setText(Integer.toString(score));
        if (score % 1500 == 0) {
            updateSpeed();
        }

    }

    public void setRoadSpeed(int roadSpeed) {
        this.roadSpeed = roadSpeed;
    }

    public void updateSpeed() {
        roadSpeed += 1;
        for (Obstacle obstacle : obstacles) {
            obstacle.setSpeed(roadSpeed);
        }
        coin.setRoadspeed(roadSpeed);
        road.setRoadSpeed(roadSpeed);
    }

    public void setScore(int score) {
        this.score = score;
    }
}
