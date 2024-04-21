package Controller.ControllerGame;

import View.Game.CarGameView;
import View.Game.PauseGameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarGameController {

    private CarGameView view;

    public CarGameController(CarGameView view) {
        this.view = view;
        view.getjButton_Pause().addActionListener(new PauseButtonListener());
    }

    private class PauseButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           view.showPauseGame();
        }

    }
}
