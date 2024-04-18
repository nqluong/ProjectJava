
package View.ViewMenu;

import Controller.ControllerMenu.HighScoreController;
import javax.swing.*;
import java.awt.*;
import View.Game.*;

public class HighScoreView extends ImageFactory {
    private JFrame jFrame;
    private JPanel highScorePanel;
    private JButton homeButton;
    private JLabel playerLabel, scoreLabel;
    
    public HighScoreView() {
        this.init();
    }
    
    private void init(){
        jFrame = new JFrame();
        jFrame.setTitle("Điểm cao");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        
        highScorePanel = createImagePanel("Image/NenCar_01.png", 0, 0, 640, 700);
        
        playerLabel = createImageLabel("Người chơi", "", 120, 150, 80, 30);
        scoreLabel = createImageLabel("Điểm số", "", 445, 150, 70, 30);
        homeButton = createButton("Trang chủ", "Image/Button_01.png", 245, 300, 150, 50);
        
        highScorePanel.add(playerLabel);
        highScorePanel.add(scoreLabel);
        highScorePanel.add(homeButton);
        
        jFrame.add(highScorePanel);
    }
    
    public void showHighScoreView() {
        jFrame.dispose();
        HighScoreView highview = new HighScoreView();
        HighScoreController highScoreController = new HighScoreController(highview);
        highview.setVisible(true);
    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public void setHomeButton(JButton homeButton) {
        this.homeButton = homeButton;
    }
    
    public void setVisible(boolean b) {
        jFrame.setVisible(true);
    } 

    public void dispose() {
        jFrame.dispose();
    }
}

