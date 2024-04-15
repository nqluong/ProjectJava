package View.Game;

import Controller.ControllerGame.CarController;
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
public class CarGameView extends JFrame {

    private JPanel jPanel_Center, jPanel_Left, jPanel_Right;
    private JButton jButton_Pause;
    private JLabel jLabel_IconCoin, jLabel_Car, jLabel_Coin, jLabel_Barrier_Car, jLabel_Barrier_Fence;
    private JTextField jTextField_Point, jTextField_Coin;
    private RoadLabel jLabel_Road;

    public CarGameView() {
        this.init();
//        CarController carController = new CarController(jLabel_Road);
//        carController.startAnimation();
    }

    private void init() {
        this.setTitle("Car Game");
        this.setSize(640, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        jPanel_Center = new JPanel();
//        {
//            @Override
//            protected void paintComponent(Graphics g) {
//                super.paintComponent(g);
//                ImageIcon imageIcon_Road = new ImageIcon("Image/Road.png");
//                Image image_Road = imageIcon_Road.getImage();
//                g.drawImage(image_Road, 0, 0, getWidth(), getHeight(), this);
//            }
//        };
        jPanel_Center.setBounds(160, 0, 320, 700);
        jPanel_Center.setLayout(null);
        jPanel_Center.setBackground(Color.BLUE);
        jLabel_Road = new RoadLabel("Image/Road.png");
        jLabel_Road.setSize(320, 700);
        jLabel_Road.setBackground(Color.red);
        jLabel_Road.setLayout(null);
//		Car, Barrier : 25; 88; 183; 247 Coin: 30; 94; 192; 255
        jLabel_Car = new CarView();
        
        jLabel_Coin = new JLabel(new ImageIcon("Image/coinn.png"));
        jLabel_Coin.setOpaque(false);
        jLabel_Coin.setBackground(Color.BLUE);
        jLabel_Coin.setBounds(94, 50, 35, 35);

        jLabel_Barrier_Car = new JLabel(new ImageIcon("Image/Car_02.png"));
        jLabel_Barrier_Car.setOpaque(false);
        jLabel_Barrier_Car.setBackground(Color.BLUE);
        jLabel_Barrier_Car.setBounds(183, 200, 50, 80);

        jLabel_Barrier_Fence = new JLabel(new ImageIcon("Image/Barrier_Fence.png"));
        jLabel_Barrier_Fence.setOpaque(false);
//		jLabel_Barrier_Fence.setBackground(Color.BLUE);
        jLabel_Barrier_Fence.setBounds(247, 200, 50, 30);

        jLabel_Road.add(jLabel_Car);
        jLabel_Road.add(jLabel_Coin);
        jLabel_Road.add(jLabel_Barrier_Car);
        jLabel_Road.add(jLabel_Barrier_Fence);

        jPanel_Left = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon_Roadside_Left = new ImageIcon("Image/Roadside_Left.png");
                Image image_Roadside_Left = imageIcon_Roadside_Left.getImage();
                g.drawImage(image_Roadside_Left, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel_Left.setBounds(0, 0, 160, 700);
        jPanel_Left.setLayout(null);
        jButton_Pause = new JButton("PAUSE");
        jButton_Pause.setBounds(5, 5, 80, 30);
        jPanel_Left.add(jButton_Pause);

        jPanel_Right = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon("Image/Roadside_Right.png");
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        jPanel_Right.setBounds(480, 0, 160, 700);
        jPanel_Right.setLayout(null);
        jTextField_Point = new JTextField();
        jTextField_Point.setBounds(80, 0, 80, 30);
        jPanel_Right.add(jTextField_Point);

        jTextField_Coin = new JTextField();
        jTextField_Coin.setBounds(100, 40, 60, 30);
        jPanel_Right.add(jTextField_Coin);
        jLabel_IconCoin = new JLabel(new ImageIcon("Image/Coin.png"));
        jLabel_IconCoin.setBounds(60, 40, 30, 30);
        jLabel_Coin.setOpaque(false);
        jPanel_Right.add(jLabel_IconCoin);
        jPanel_Center.add(jLabel_Road);
        this.add(jPanel_Center);
        this.add(jPanel_Left);
        this.add(jPanel_Right);

        //this.setVisible(true);
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

    public class CarView extends JLabel {

        public CarView() {
            super(new ImageIcon("Image/Car_01.png"));
            setOpaque(true);
            setBackground(Color.BLUE);
            setBounds(25, 530, 50, 80);
            setOpaque(false);
        }
    }

    public static void main(String[] args) {
        CarGameView view = new CarGameView();
        CarController  carController = new CarController(view);
        view.setVisible(true);
        carController.start();
    }
}
