/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProjectJava.src.Main;

import ProjectJava.src.Controller.ControllerMenu.*;
import ProjectJava.src.View.ViewMenu.*;

/**
 *
 * @author nguye
 */
public class CarGame {
    public static void main(String[] args) {
          MainMenuView mainMenuView = new MainMenuView();
          MainMenuController mainMenuController =  new MainMenuController(mainMenuView);
         
    }
}
