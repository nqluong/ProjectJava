package Controller.ControllerGame;

import View.Game.CarGameView;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author nguye
 */
public class CarController implements KeyListener {
    private CarGameView view;
    public CarController(CarGameView view) {
        this.view = view;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
