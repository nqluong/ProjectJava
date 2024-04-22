package Main;

//import static View.ViewMenu.MainMenuView.playSound;
import Controller.ControllerMenu.*;
import View.ViewMenu.*;

public class CarGame {

    public static void main(String[] args) {
          MainMenuView mainMenuView = new MainMenuView();
          mainMenuView.setVisible();
          MainMenuController mainMenuController =  new MainMenuController(mainMenuView);
          mainMenuView.playSound("Sound/NhacNen.wav");
    }
}
