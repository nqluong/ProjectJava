package Model.ModelGame;

import View.Game.CarGameView;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JLabel;

public class CoinModel extends Thread {
   
    private CarGameView view;
    private int roadspeed=2;
    private int y=500;
    private CarModel car;
    private int coin=0;
    Random rd = new Random();
    public CoinModel(CarGameView view,CarModel car) {
        this.view=view;
        this.car=car;
    }
 

   public void run() {
    while (true) {
        int index = rd.nextInt(4);
        int newY = -y;
        int x = index * 80 + 10;
        boolean collisionChecked = false;
        while (view.getCoinY() < 700) {
            newY += roadspeed;
            view.getjLabel_Coin().setLocation(x, newY);
            if(!collisionChecked && collision()) {
                this.tang();
                collisionChecked = true; 
                run();
            }
            try {
                
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        view.getjLabel_Coin().setLocation(x, y);
    }
}

    
    public JLabel getLabel() {
        return view.getjLabel_Coin();
    }

    public int getSpeed() {
        return roadspeed;
    }

    public void setSpeed(int speed) {
        this.roadspeed = speed;
    }
     public boolean collision(){
        boolean flag = false;
        int carRight = car.getX() + car.getCarLabel().getWidth();
        int carBottom = car.getY() + car.getCarLabel().getHeight();
        int coinRight = view.getjLabel_Coin().getX() + view.getjLabel_Coin().getWidth();
        int coinBottom = view.getjLabel_Coin().getY() + view.getjLabel_Coin().getHeight();
        if(car.getX() < coinRight && carRight > view.getjLabel_Coin().getX() && car.getY() < coinBottom && carBottom > view.getjLabel_Coin().getY()){
            flag = true;
            
        }
        return flag;
    }

    public int getCoin() {
        return coin;
    }
    public void tang(){
        coin ++;
        view.getjTextField_Coin().setText(Integer.toString(coin));
       
    }
    


}
