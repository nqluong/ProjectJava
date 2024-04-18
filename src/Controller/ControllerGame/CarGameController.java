package Controller.ControllerGame;
import View.Game.*;
import Model.ModelGame.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarGameController {
    private CarGameView carGameView;
    
    public CarGameController(CarGameView carGameView){
        this.carGameView = carGameView;
        carGameView.getjButton_Pause().addActionListener(new PauseGameButtonListener());
        
    }
    
    public class PauseGameButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
//            CarGameView carGameView = new CarGameView();
//            CarGameController controller = new CarGameController(carGameView);
            CarController carController = new CarController(carGameView);
            Obstacles obstacles = new Obstacles(carGameView);
            obstacles.stopGame();
            carGameView.showPauseGameView();
        }
    }
    
    
    
}
