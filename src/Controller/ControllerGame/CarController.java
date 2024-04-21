package ProjectJava.src.Controller.ControllerGame;

<<<<<<< HEAD
import ProjectJava.src.View.Game.CarGameView;
import java.util.Random;
import javax.swing.*;
=======
import View.Game.CarGameView;
import View.Game.PauseGameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
>>>>>>> 59989e474245ec33b1f4bbd1b04eac37f4ff5957

/**
 *
 * @author nguye
 */
public class CarController implements KeyListener {
    private CarGameView view;
    public CarController(CarGameView view) {
        this.view = view;
        view.getjButton_Pause().addActionListener(new PauseButtonListener());
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
    
    private class PauseButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            view.dispose();
            PauseGameView pauseView = new PauseGameView();
            new PauseGameController(pauseView);
        }
        
    }

}
