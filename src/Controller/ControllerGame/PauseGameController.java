
package Controller.ControllerGame;
import Controller.ControllerMenu.MainMenuController;
import Model.ModelGame.Obstacles;
import View.Game.*;
import View.ViewMenu.MainMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import Model.ModelGame.*;

public class PauseGameController {
    private PauseGameView pauseGameView;
    private CarGameView carGameView;


    public PauseGameController(PauseGameView pauseGameView) {
        this.pauseGameView = pauseGameView;
        pauseGameView.getjButton_Resume().addActionListener(new ResumeGameButtonListener());
        pauseGameView.getjButton_PlayAgain().addActionListener(new PlayAgainGameButtonListener());
        pauseGameView.getjButton_Home().addActionListener(new HomeGameButtonListener());
    }
    
    public class ResumeGameButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            pauseGameView.dispose();
            CarGameView carGameView = new CarGameView();
            new CarGameController(carGameView);
//            CarController carController = new CarController(carGameView);
            
            Obstacles obstacles = new Obstacles(carGameView);
            obstacles.continueGame();
            carGameView.setVisible(true);
        }
    }
    
    public class PlayAgainGameButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            pauseGameView.dispose();
            CarGameView carGameView = new CarGameView();
            new CarGameController(carGameView);
            CarController carController = new CarController(carGameView);
            Obstacles obstacles = new Obstacles(carGameView);
            carGameView.setVisible(true);
        }
    }
    
    public class HomeGameButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            pauseGameView.dispose();
            MainMenuView mainMenuView = new MainMenuView();
            new MainMenuController(mainMenuView);
            mainMenuView.showMainMenu();
        }
    }
}
