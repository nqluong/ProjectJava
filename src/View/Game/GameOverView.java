package View.Game;

import Controller.ControllerGame.GameOverController;
import Controller.ControllerGame.SavePointController;
import javax.swing.*;
import java.awt.*;


public class GameOverView extends ImageFactory {
    private CarGameView view;
    private JFrame jFrame;
    private JLabel titleLabel;
    private JPanel jPanel_GameOverView;
    private JButton jButton_PlayAgain, jButton_Home, jButton_SavePoint;

    public GameOverView() {
        this.init();
    }
    
    public GameOverView(CarGameView view) {
        this.view = view;
        this.init();
        
    }

    private void init(){
        jFrame = new JFrame();
        jFrame.setTitle("Racing UTC");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        
        jPanel_GameOverView = createImagePanel("Image/Background_02.png", 0, 0, 640, 700);

        titleLabel = createImageLabel("", "Image/title-GameOver.png", 125, 30, 400, 150);
        jButton_SavePoint = createButton("LƯU ĐIỂM", "Image/Button_01.png", 262, 260, 116, 40);
        jButton_PlayAgain = createButton("PLAY AGAIN", "Image/Button_01.png", 262, 180, 116, 40);
        jButton_Home = createButton("HOME", "Image/Button_01.png", 262, 340, 116, 40);

        jPanel_GameOverView.add(titleLabel);
        jPanel_GameOverView.add(jButton_SavePoint);
        jPanel_GameOverView.add(jButton_PlayAgain);
        jPanel_GameOverView.add(jButton_Home);
        jFrame.add(jPanel_GameOverView);
        setVisible(true);
    }

    public JButton getjButton_PlayAgain() {
        return jButton_PlayAgain;
    }

    public JButton getjButton_Home() {
        return jButton_Home;
    }

    public JButton getjButton_SavePoint() {
        return jButton_SavePoint;
    }

    public void setVisible(boolean b) {
        jFrame.setVisible(true);
    }
    public void showSave(){
        SavePointView viewSave = new SavePointView(view);
        new SavePointController(viewSave);
    }

    public void dispose() {
        jFrame.dispose();
    }
    public void showGameOver(){
        jFrame.setVisible(true);
    }
}
