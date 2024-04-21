package Controller.ControllerGame;

import Controller.ControllerMenu.MainMenuController;
import View.Game.CarGameView;
import View.Game.PauseGameView;
import View.ViewMenu.MainMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nguye
 */
public class PauseGameController {

    private PauseGameView pauseView;

    public PauseGameController(PauseGameView pauseView) {
        this.pauseView = pauseView;
        pauseView.getjButton_Home().addActionListener(new HomeButtonListener());
        pauseView.getjButton_PlayAgain().addActionListener(new PlayAgainListener());
    }

    private class PlayAgainListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            pauseView.dispose();
            CarGameView gameView = new CarGameView();
            CarController carController = new CarController(gameView);
        }

    }
       private class HomeButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
           pauseView.dispose();
           MainMenuView mainMenuView = new MainMenuView();
           new MainMenuController(mainMenuView);
           mainMenuView.showMainMenu();
        }
 
    }
}
