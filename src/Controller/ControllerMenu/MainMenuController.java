/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller.ControllerMenu;

import View.ViewMenu.MainMenuView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author nguye
 */
public class MainMenuController extends JPanel {
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
            view.dispose();
            view.showHighScoreView();
            
        }
    }
    
    public class InstructionsButtonListener implements ActionListener{

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