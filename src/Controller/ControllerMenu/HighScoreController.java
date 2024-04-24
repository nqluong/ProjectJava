package Controller.ControllerMenu;

import View.ViewMenu.*;
import java.awt.event.*;
public class HighScoreController {
    private HighScoreView highView;
    public HighScoreController() {
    }

    public HighScoreController(HighScoreView highView) {
        this.highView = highView;
        highView.getHomeButton().addActionListener(new HomeButtonListener());
        
    }
    
    private class HomeButtonListener implements ActionListener{
        @Override
                public void actionPerformed(ActionEvent e) {
                highView.dispose();
        } 
    }
}
