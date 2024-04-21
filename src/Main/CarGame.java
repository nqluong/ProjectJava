package Main;

import Controller.ControllerMenu.*;
import View.ViewMenu.*;

public class CarGame {

    public static void main(String[] args) {
        MainMenuView mainMenuView = new MainMenuView();
        MainMenuController mainMenuController = new MainMenuController(mainMenuView);

    }
}
