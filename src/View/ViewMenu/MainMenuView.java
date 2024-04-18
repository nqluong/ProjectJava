package View.ViewMenu;

import Controller.ControllerGame.*;
import Controller.ControllerMenu.*;
import Model.ModelGame.*;
import javax.swing.*;
import java.awt.*;
import View.Game.*;

public class MainMenuView extends ImageFactory {

    private JFrame jFrame;
    private JPanel mainMenuPanel;
    private JButton highScoreButton, instructionsButton, startButton;

    public MainMenuView() {
        this.init();
        jFrame.setVisible(true);
    };
    
    private void init() {
        jFrame = new JFrame();
        jFrame.setTitle("Racing UTC");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        
        mainMenuPanel = createImagePanel("Image/NenCar_01.png", 0, 0, 640, 700);

        JLabel titleLabel = new JLabel("Racing 2D");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(260, 50, 150, 50);
        
        startButton = createButton("Bắt đầu", "Image/Button_01.png", 245, 195, 150, 50);
        highScoreButton = createButton("Điểm cao", "Image/Button_01.png", 245, 275, 150, 50);
        instructionsButton = createButton("Hướng dẫn", "Image/Button_01.png", 245, 355, 150, 50);

        mainMenuPanel.add(titleLabel);
        mainMenuPanel.add(startButton);
        mainMenuPanel.add(highScoreButton);
        mainMenuPanel.add(instructionsButton);
        jFrame.add(mainMenuPanel);
    }

    public void showGame(){
        jFrame.dispose();
        CarGameView view = new CarGameView();
        CarController carController = new CarController(view);
        Obstacles obstacles = new Obstacles(view);
        CarGameController carGameController = new CarGameController(view);
        view.setVisible(true);
    }
    
    public void showInstrctionsView() {
        jFrame.dispose();
        InstructionsView instructionsView = new InstructionsView();
        new InstructionsController(instructionsView);
        instructionsView.setVisible(true);
    }
    
    public void showHighScoreView() {
        jFrame.dispose();
        HighScoreView highview = new HighScoreView();
        new HighScoreController(highview);
        highview.setVisible(true);
    }
    
    public void showMainMenu() {
        new MainMenuController(this);
        jFrame.setVisible(true);
    }
    
    public JButton getHighScoreButton() {
        return highScoreButton;
    }

    public void setHighScoreButton(JButton highScoreButton) {
        this.highScoreButton = highScoreButton;
    }

    public JButton getInstructionsButton() {
        return instructionsButton;
    }

    public void setInstructionsButton(JButton instructionsButton) {
        this.instructionsButton = instructionsButton;
    }

    public JPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }
    public void dispose() {
        jFrame.dispose();
    }
    
}
