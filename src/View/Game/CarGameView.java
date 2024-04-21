package ProjectJava.src.View.Game;

import ProjectJava.src.Controller.ControllerGame.CarController;
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
import ProjectJava.src.View.Game.*;

public class CarGameView extends ProjectJava.src.View.Game.ImageFactory {

    private JFrame jFrame;
    private JPanel jPanel_Center, jPanel_Left, jPanel_Right;
    private JButton jButton_Pause;
    private JLabel jLabel_IconCoin, jLabel_Car, jLabel_Coin, jLabel_Barrier_Car, jLabel_Barrier_Fence;
    private JTextField jTextField_Point, jTextField_Coin;
    private RoadLabel jLabel_Road;

    public CarGameView() {
        this.init();
        jFrame.setVisible(true);
//        CarController carController = new CarController(jLabel_Road);
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
        jLabel_Road = new RoadLabel("ProjectJava/Image/Road.png");
        jLabel_Road.setSize(320, 700);
        jLabel_Road.setLayout(null);
        jLabel_Car = createImageLabel("", "ProjectJava/Image/Car_01.png", 25, 530, 50, 80);
        jLabel_Coin = createImageLabel("", "ProjectJava/Image/Coin.png", 94, 50, 35, 35);
        jLabel_Barrier_Car = createImageLabel("", "ProjectJava/Image/Barrier_Car_01.png", 183, 200, 50, 80);
        jLabel_Barrier_Fence = createImageLabel("", "ProjectJava/Image/Barrier_Fence.png", 247, 200, 50, 30);
        
        jPanel_Center.add(jLabel_Car);
        jPanel_Center.add(jLabel_Coin);
        jPanel_Center.add(jLabel_Barrier_Car);
        jPanel_Center.add(jLabel_Barrier_Fence);
        jPanel_Center.add(jLabel_Road);

        jPanel_Left = createImagePanel("ProjectJava/Image/Roadside_Left.png", 0, 0, 160, 700);
	jButton_Pause = createButton("PAUSE", "ProjectJava/Image/Button_01.png", 5, 5, 80, 30);
	jPanel_Left.add(jButton_Pause);

        jPanel_Right = createImagePanel("ProjectJava/Image/Roadside_Right.png", 480, 0, 160, 700);
	jTextField_Point = createTextField("0", "ProjectJava/Image/Button_01.png", 65, 5, 80, 30);
	jTextField_Coin = createTextField("0", "ProjectJava/Image/Button_01.png", 65, 40, 80, 30);
	jLabel_IconCoin = createImageLabel("", "ProjectJava/Image/IconCoin.png", 73, 46, 17, 17);
	jPanel_Right.add(jTextField_Point);
	jPanel_Right.add(jLabel_IconCoin);
	jPanel_Right.add(jTextField_Coin);
        
        jFrame.add(jPanel_Center);
        jFrame.add(jPanel_Left);
        jFrame.add(jPanel_Right);

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

    public void setVisible(boolean b) {
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        CarGameView view = new CarGameView();
        CarController carController = new CarController(view);
        carController.start();
    }
}