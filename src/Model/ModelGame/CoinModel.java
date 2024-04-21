package Model.ModelGame;

import View.Game.CarGameView;
import static java.lang.Thread.sleep;
import java.util.Random;
import javax.swing.JLabel;

public class CoinModel extends Thread {
    private boolean paused = false, allRandom = true;
    private CarGameView view;
    private int roadspeed=2;
    private int pauseX, pauseY, y;

    public void setRoadspeed(int roadspeed) {
        this.roadspeed = roadspeed;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }
    private CarModel car;
    private int coin = 0 ;
    Random rd = new Random();
    public CoinModel(CarGameView view,CarModel car) {
        this.view=view;
        this.car=car;
        y = view.getjLabel_Coin().getY();
    }
 

   public void run() {
    while (true) {
        
        if(paused){
                try{
                    sleep(20);
                    continue;
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        int newY, x;
        if(allRandom){
            int index = rd.nextInt(4);
            x = index * 80 + 10;
        } else x = pauseX;
        boolean collisionChecked = false;
        
        
        while (view.getCoinY() < 700 && !paused) {
            newY = view.getCoinY() + roadspeed;
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
        
        if(!paused)view.getjLabel_Coin().setLocation(x, y);
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

    public void setPaused(boolean paused) {
        this.paused = paused;
    }
    public void pauseGame(){
        paused = true;
        pauseX = view.getjLabel_Coin().getX();
        pauseY = view.getjLabel_Coin().getY();
    }
    public void continueGame(){
        paused = false;
        allRandom = false;
        view.getjLabel_Coin().setLocation(pauseX, pauseY);
    }
}
