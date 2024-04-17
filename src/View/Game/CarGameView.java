package View.Game;

import Controller.ControllerGame.CarController;
import Model.ModelGame.Obstacle;
import Model.ModelGame.CarModel;
import Model.ModelGame.Obstacles;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

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

public class CarGameView extends ImageFactory {
    private CarModel carModel;
    private JFrame jFrame;
    private JPanel jPanel_Center, jPanel_Left, jPanel_Right;
    private JButton jButton_Pause;
    private JLabel jLabel_IconCoin, jLabel_Car, jLabel_Coin, jLabel_Barrier_Car, jLabel_Barrier_Fence;
    private JTextField jTextField_Point, jTextField_Coin;
    private RoadLabel jLabel_Road;

    public CarGameView() {
        this.init();
         carModel = new CarModel(jLabel_Car);
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
        jLabel_Car = createImageLabel("", "Image/Car_01.png", 10, 530, 50, 80);
  
        jLabel_Coin = createImageLabel("", "Image/Coin.png", 94, 50, 35, 35);
        jLabel_Barrier_Car = createImageLabel("", "Image/Barrier_Car_01.png", 183, 200, 50, 80);
        jLabel_Barrier_Fence = createImageLabel("", "Image/Barrier_Fence.png", 247, 200, 50, 30);
        
        jPanel_Center.add(jLabel_Car);
        jPanel_Center.add(jLabel_Coin);
        jPanel_Center.add(jLabel_Barrier_Car);
        jPanel_Center.add(jLabel_Barrier_Fence);
        jPanel_Center.add(jLabel_Road);

        jPanel_Left = createImagePanel("Image/Roadside_Left.png", 0, 0, 160, 700);
	jButton_Pause = createButton("PAUSE", "Image/Button_01.png", 5, 5, 80, 30);
	jPanel_Left.add(jButton_Pause);

        jPanel_Right = createImagePanel("Image/Roadside_Right.png", 480, 0, 160, 700);
	jTextField_Point = createTextField("0", "Image/Button_01.png", 65, 5, 80, 30);
	jTextField_Coin = createTextField("0", "Image/Button_01.png", 65, 40, 80, 30);
	jLabel_IconCoin = createImageLabel("", "Image/IconCoin.png", 73, 46, 17, 17);
	jPanel_Right.add(jTextField_Point);
	jPanel_Right.add(jLabel_IconCoin);
	jPanel_Right.add(jTextField_Coin);
        
        jFrame.add(jPanel_Center);
        jFrame.add(jPanel_Left);
        jFrame.add(jPanel_Right);
        KeyListener kl = new CarController(this);
        jFrame.setFocusable(true);
        jFrame.addKeyListener(kl);
                };

    public JLabel getjLabel_Coin() {
        return jLabel_Coin;
    }

    public JLabel getjLabel_Barrier_Car() {
        return jLabel_Barrier_Car;
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

    public int getBarrierCarY() {
        return jLabel_Barrier_Car.getY();
    }

    public int getBarrierFenceY() {
        return jLabel_Barrier_Fence.getY();
    }

    public int getPanelHeight() {
        return jPanel_Center.getHeight();
    }

    public void setCarLocation(int y) {
        jLabel_Car.setLocation(jLabel_Car.getX(), y);
    }

    public void setCoinLocation(int y) {
        jLabel_Coin.setLocation(jLabel_Coin.getX(), y);
    }

    public void setBarrierCarLocation(int y) {
        jLabel_Barrier_Car.setLocation(jLabel_Barrier_Car.getX(), y);
    }

    public void setBarrierFenceLocation(int y) {
        jLabel_Barrier_Fence.setLocation(jLabel_Barrier_Fence.getX(), y);
    }
    public void setObstacleLocation(JLabel jLabel, int x,int y){
        jLabel.setLocation(x, y);
    }
    public void setVisible(boolean b) {
        jFrame.setVisible(true);
    }
    
    public int getCarX(){
        return jLabel_Car.getX();
    }
    public void moveLeft(){
        this.carModel.moveLeft();
    }
    public void moveRight(){
        this.carModel.moveRight();
    }
    

    
    

    public static void main(String[] args) {
        CarGameView view = new CarGameView();
        CarController carController = new CarController(view);
        Obstacles obstacles = new Obstacles(view);
        obstacles.start();
    }
}