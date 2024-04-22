package View.Game;

import Controller.ControllerGame.*;
import Model.ModelGame.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyListener;

public class CarGameView extends ImageFactory {

    private Obstacles obstacles;
    private CarModel carModel;
    private CoinModel coinModel;
    private JFrame jFrame;
    private JPanel jPanel_Center, jPanel_Left, jPanel_Right;
    private JButton jButton_Pause;
    private JLabel jLabelObstacle_Two, jLabelObstacle_Three, jLabel_IconCoin, jLabel_Car, jLabel_Coin, jLabel_Barrier_Car, jLabel_Barrier_Fence;
    private JTextField jTextField_Point, jTextField_Coin;
    private RoadLabel jLabel_Road;
    private boolean check = false;

    public CarGameView() {
        this.init();
        carModel = new CarModel(jLabel_Car);
        coinModel = new CoinModel(this, carModel, -100);
        obstacles = new Obstacles(this, carModel, coinModel, jLabel_Road);
        jFrame.setVisible(true);
        
    }

    public void init() {
        jFrame = new JFrame();
        jFrame.setTitle("Game");
        jFrame.setSize(640, 700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

        jPanel_Center = createImagePanel("", 160, 0, 320, 700);
        jLabel_Road = new RoadLabel("Image/Road.png");
        jLabel_Road.setSize(320, 700);
        jLabel_Road.setLayout(null);
        jLabel_Car = createImageLabel("", "Image/Car_01.png", 5, 530, 75, 75);

        jLabel_Coin = createImageLabel("", "Image/Coin.png", 25, -50, 35, 35);
        //vật cản
        jLabel_Barrier_Car = createImageLabel("", "Image/Barrier_Car_01.png", 10, -200, 60, 80);
        jLabel_Barrier_Fence = createImageLabel("", "Image/Barrier_Fence.png", 10, -300, 60, 30);
        jLabelObstacle_Two = createImageLabel("", "Image/Barrier_Car_02.png", 10, -400, 60, 80);
        jLabelObstacle_Three = createImageLabel("", "Image/Barrier_Car_03.png", 10, -500, 60, 80);

        jPanel_Center.add(jLabel_Car);
        jPanel_Center.add(jLabel_Coin);
        jPanel_Center.add(jLabel_Barrier_Car);
        jPanel_Center.add(jLabel_Barrier_Fence);
        jPanel_Center.add(jLabelObstacle_Two);
        jPanel_Center.add(jLabelObstacle_Three);
        jPanel_Center.add(jLabel_Road);

        jPanel_Left = createImagePanel("Image/Roadside_Left.png", 0, 0, 160, 700);
        jButton_Pause = createButton("PAUSE", "Image/Button_01.png", 5, 5, 80, 30);
        jPanel_Left.add(jButton_Pause);

        jPanel_Right = createImagePanel("Image/Roadside_Right.png", 480, 0, 160, 700);
        jTextField_Point = createTextField("0", "Image/Button_01.png", 65, 5, 80, 30);
        jTextField_Coin = createTextField("0", "Image/Button_01.png", 65, 40, 80, 30);
        jPanel_Right.add(jTextField_Point);
        jPanel_Right.add(jTextField_Coin);

        jFrame.add(jPanel_Center);
        jFrame.add(jPanel_Left);
        jFrame.add(jPanel_Right);
        KeyListener kl = new CarController(this);
        jFrame.setFocusable(true);
        jFrame.addKeyListener(kl);
    }

    public void startGame() {
        jFrame.setVisible(true);
        coinModel.start();
    }

    public JTextField getjTextField_Coin() {
        return jTextField_Coin;
    }

    public JTextField getjTextField_Point() {
        return jTextField_Point;
    }

    public JLabel getjLabel_Coin() {
        return jLabel_Coin;
    }

    public JLabel getjLabel_Barrier_Car() {
        return jLabel_Barrier_Car;
    }

    public JLabel getjLabelObstacle_Two() {
        return jLabelObstacle_Two;
    }

    public JLabel getjLabelObstacle_Three() {
        return jLabelObstacle_Three;
    }

    public JLabel getjLabel_Barrier_Fence() {
        return jLabel_Barrier_Fence;
    }

    public int getCarY() {
        return jLabel_Car.getY();
    }

    public int getCoinY() {
        return jLabel_Coin.getY();
    }
    
    public int getBarrier_CarY() {
        return jLabel_Barrier_Car.getY();
    }
    
    public int getObstacle_TwoY() {
        return jLabelObstacle_Two.getY();
    }
    
    public int getObstacle_ThreeY() {
        return jLabelObstacle_Three.getY();
    }
    
    public int getBarrier_FenceY() {
        return jLabel_Barrier_Fence.getY();
    }
    

    public void setVisible(boolean b) {
        jFrame.setVisible(b);
    }

    public void moveLeft() {
        this.carModel.moveLeft();
    }

    public JButton getjButton_Pause() {
        return jButton_Pause;
    }

    public void moveRight() {
        this.carModel.moveRight();
    }

    public void showGameOver() {
        jFrame.dispose();
        GameOverView gameOver = new GameOverView(this);
        new GameOverController(gameOver);
    }

    public void showPauseGame() {
        jFrame.setVisible(false);
        PauseGameView pauseView = new PauseGameView(this);
        new PauseGameController(pauseView, this);
        pauseGame();
    }

    public void resumeGame() {
        jFrame.setVisible(true);
        new CarController(this);
        jFrame.requestFocusInWindow();
        continueGame();
    }

    public void dispose() {
        jFrame.dispose();
    }

    public void showGame() {
        jFrame.setVisible(true);
    }

    public void pauseGame() {
        obstacles.pauseGame();
    }

    public void continueGame() {
        coinModel.continueGame();
        obstacles.continueGame();
    }

}
