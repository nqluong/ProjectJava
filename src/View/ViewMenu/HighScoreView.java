
package ProjectJava.src.View.ViewMenu;

import ProjectJava.src.Controller.ControllerMenu.HighScoreController;
import javax.swing.*;
import java.awt.*;
import ProjectJava.src.View.Game.*;

public class HighScoreView extends ImageFactory {
    private JFrame jFrame;
    private JPanel highScorePanel;
    private JButton homeButton;
    private JLabel playerLabel, scoreLabel;
    
    public HighScoreView() {
        this.init();
        jFrame.setVisible(true);
    }
    
    private void init(){
        jFrame = new JFrame();
        jFrame.setTitle("Điểm cao");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        
        highScorePanel = createImagePanel("ProjectJava/Image/NenCar_01.png", 0, 0, 640, 700);
        
        playerLabel = createImageLabel("Người chơi", "", 100, 100, 100, 30);
        scoreLabel = createImageLabel("Điểm số", "", 400, 100, 100, 30);
        homeButton = createButton("Trang chủ", "ProjectJava/Image/Button_01.png", 262, 260, 116, 40);
        
        highScorePanel.add(playerLabel);
        highScorePanel.add(scoreLabel);
        highScorePanel.add(homeButton);
        
        jFrame.add(highScorePanel);
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
    public static void main(String[] args) {
        new HighScoreView();
    }

    public void dispose() {
        jFrame.dispose();
    }
}

