package Controller.ControllerMenu;

import View.ViewMenu.*;
import java.awt.event.*;
public class HighScoreController {
    private HighScoreView highView;
    public HighScoreController() {
    }

    public HighScoreController(HighScoreView highView) {
        this.highView = highView;
        //lấy sự kiện khi click ô homebutton
        highView.getHomeButton().addActionListener(new HomeButtonListener());
        
    }
    
    //class này để xử lý sự kiện
    private class HomeButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
                highView.dispose();
                MainMenuView mainMenuView = new MainMenuView();
                //tạo controller cho menu
                new MainMenuController(mainMenuView);
                mainMenuView.showMainMenu();
                
        }
        
    }

}
