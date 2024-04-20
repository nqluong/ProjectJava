package View.Game;

import Controller.ControllerGame.CarController;
import Model.ModelGame.Obstacle;
import Model.ModelGame.CarModel;
import Model.ModelGame.CoinModel;
import Model.ModelGame.Obstacles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import Model.ModelGame.CoinModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import View.Game.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

public class CarGameView extends ImageFactory {

    private CarModel carModel;
    private CoinModel coinModel;
    private JFrame jFrame;
    private JPanel jPanel_Center, jPanel_Left, jPanel_Right;
    private JButton jButton_Pause;
    private JLabel jLabelObstacle_Two, jLabelObstacle_Three, jLabel_IconCoin, jLabel_Car, jLabel_Coin, jLabel_Barrier_Car, jLabel_Barrier_Fence;
    private JTextField jTextField_Point, jTextField_Coin;
    private RoadLabel jLabel_Road;
 
    public CarGameView() {
        this.init();
        carModel = new CarModel(jLabel_Car);
        
         Obstacles obstacles = new Obstacles(this, carModel);
         coinModel=new CoinModel(this,carModel);
        coinModel.start();
        
        jFrame.setVisible(true);
//        Obstacle carController = new Obstacle(jLabel_Road);
//        carController.startAnimation();
    }

    public void init() {
        jFrame = new JFrame();

        jFrame.setTitle("Car Game");
        jFrame.setSize(640, 700);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setLayout(null);

//	Car, Barrier : 25; 88; 183; 247 Coin: 30; 94; 192; 255
        jPanel_Center = createImagePanel("", 160, 0, 320, 700);
        jLabel_Road = new RoadLabel("Image/Road.png");
        jLabel_Road.setSize(320, 700);
        jLabel_Road.setLayout(null);
        jLabel_Car = createImageLabel("", "Image/Car_01.png", 10, 530, 60, 80);

        jLabel_Coin = createImageLabel("", "Image/Coin.png", 94, 50, 35, 35);
           //vật cản
        jLabel_Barrier_Car = createImageLabel("", "Image/Barrier_Car_01.png", 10, 200, 60, 80);
        jLabel_Barrier_Fence = createImageLabel("", "Image/Barrier_Fence.png", 10, 200, 60, 30);
        jLabelObstacle_Two = createImageLabel("", "Image/Barrier_Car_02.png", 10, 500, 60, 80);
        jLabelObstacle_Three = createImageLabel("", "Image/Barrier_Car_03.png", 10, -100, 60, 80);

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
        jLabel_IconCoin = createImageLabel("", "Image/IconCoin.png", 173, 46, 17, 17);
        jPanel_Right.add(jTextField_Point);
        jPanel_Right.add(jLabel_IconCoin);
        jPanel_Right.add(jTextField_Coin);
        
        jFrame.add(jPanel_Center);
        jFrame.add(jPanel_Left);
        jFrame.add(jPanel_Right);
        KeyListener kl = new CarController(this);
        jFrame.setFocusable(true);
        jFrame.addKeyListener(kl);
    }

    ;

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
//    public JLabel getjLabel_Coin() {
//        return jLabel_Coin;
//    }
    public int getCarY() {
        return jLabel_Car.getY();
    }

    public int getCoinY() {
        return jLabel_Coin.getY();
    }

    public void setVisible(boolean b) {
        jFrame.setVisible(true);
    }

    public void moveLeft() {
        this.carModel.moveLeft();
    }

    public void moveRight() {
        this.carModel.moveRight();
    }

    public static void main(String[] args) {
        CarGameView view = new CarGameView();
        CarController carController = new CarController(view);
        
       
//        Scanner sc = new Scanner(System.in);
//        if(sc.nextInt() == 1) obstacles.stopGame();
//      
    }
}
