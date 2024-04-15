package Controller.ControllerGame;

import View.Game.CarGameView;
import java.util.Random;
import javax.swing.*;

public class CarController extends Thread {
    private JLabel barrierCar, barrierFence;
    private CarGameView view;
    private int roadSpeed = 3;
    Random random = new Random();
    public CarController(CarGameView view){
        this.view = view;
    }
    public void run(){
        while(true){
            int barrierCar = -100;
            int barrierFence = -100;
            
            while(barrierCar < view.getPanelHeight() || barrierFence < view.getPanelHeight()){
                barrierCar += roadSpeed;
                barrierFence += roadSpeed;
                view.setBarrierCarLocation(barrierCar);
                view.setBarrierFenceLocation(barrierFence);
                try{
                    sleep(20);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
