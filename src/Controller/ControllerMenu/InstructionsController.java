package ProjectJava.src.Controller.ControllerMenu;

import ProjectJava.src.View.ViewMenu.*;
import java.awt.event.*;

public class InstructionsController {

    private InstructionsView instructionsView;

    public InstructionsController(InstructionsView instructionsView) {
        this.instructionsView = instructionsView;
        instructionsView.getHomeButton().addActionListener(new HomeButtonlistener());

    }

    private class HomeButtonlistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            instructionsView.dispose();
            MainMenuView mainMenuView = new MainMenuView();
            new MainMenuController(mainMenuView);
            mainMenuView.showMainMenu();
        }

    }
}
