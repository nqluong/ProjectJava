
package View.Game;
import javax.swing.*;
import java.awt.*;
import View.Game.ImageFactory;

public class GameOverView extends ImageFactory{
    private JFrame jFrame;
    private JPanel jPanel_GameOverView;
    private JButton jButton_PlayAgain, jButton_Home;
    private JLabel titleLabel;

    public GameOverView() {
        this.init();
        jFrame.setVisible(true);
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
        jButton_PlayAgain = createButton("PLAY AGAIN", "Image/Button_01.png", 262, 180, 116, 40);
        jButton_Home = createButton("HOME", "Image/Button_01.png", 262, 260, 116, 40);

        jPanel_GameOverView.add(titleLabel);
        jPanel_GameOverView.add(jButton_PlayAgain);
        jPanel_GameOverView.add(jButton_Home);
        jFrame.add(jPanel_GameOverView);
    }
   
    public void setVisible(boolean b) {
        jFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new GameOverView();
    }
}
