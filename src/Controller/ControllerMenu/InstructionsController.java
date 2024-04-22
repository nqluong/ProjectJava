package Controller.ControllerMenu;

import View.ViewMenu.*;
import java.awt.event.*;

public class InstructionsController {

    private InstructionsView instructionsView;
    private MainMenuView viewMenu;
    public InstructionsController(InstructionsView instructionsView, MainMenuView viewMenu) {
        this.instructionsView = instructionsView;
        this.viewMenu = viewMenu;
        instructionsView.getHomeButton().addActionListener(new HomeButtonlistener());
    }

    private class HomeButtonlistener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            instructionsView.dispose();
        }

    }
}
