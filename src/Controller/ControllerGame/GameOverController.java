package Controller.ControllerGame;

import Controller.ControllerMenu.MainMenuController;
import View.Game.CarGameView;
import View.Game.GameOverView;
import View.Game.SavePointView;
import View.ViewMenu.MainMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nguye
 */
public class GameOverController {
    private GameOverView overView;
    public GameOverController(GameOverView overView){
        this.overView = overView;
        overView.getjButton_PlayAgain().addActionListener(new PlayAgainListener());
        overView.getjButton_Home().addActionListener(new HomeButtonListener());
        overView.getjButton_SavePoint().addActionListener(new SaveButtonListener());
    }
    private class HomeButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
           overView.dispose();
           MainMenuView mainMenuView = new MainMenuView();
           new MainMenuController(mainMenuView);
           mainMenuView.showMainMenu();
        }
 
    }
    private class PlayAgainListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            overView.dispose();
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            CarGameView gameView = new CarGameView();
            CarController  carController = new CarController(gameView);
        }
        
    }
    private class SaveButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            overView.dispose();
            SavePointView saveView = new SavePointView();
            new SavePointController(saveView);
        }
        
    }
}
