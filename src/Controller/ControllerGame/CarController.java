package Controller.ControllerGame;

import View.Game.CarGameView;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CarController implements KeyListener {
    private CarGameView view;
    public CarController(CarGameView view) {
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
     }

    @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) 
                { 
                    view.moveLeft();}
                if(keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) 
                { 
                    view.moveRight();
                }
            }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
