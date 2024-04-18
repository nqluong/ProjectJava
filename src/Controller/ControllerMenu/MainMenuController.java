
package Controller.ControllerMenu;

import View.ViewMenu.MainMenuView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenuController {
    private MainMenuView view;
    public MainMenuController(){
        
    }
    public MainMenuController(MainMenuView view){
        this.view = view;
        view.getHighScoreButton().addActionListener(new HighScoreButtonListener());
        view.getInstructionsButton().addActionListener(new InstructionsButtonListener());
        view.getStartButton().addActionListener(new StartButtonListener());
    }

            
    public class HighScoreButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            view.showHighScoreView();
        }
    }
    
    public class InstructionsButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.showInstrctionsView();
        }
    }
    
    public class StartButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            view.showGame();
        }
    }
}    