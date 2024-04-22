
package View.Game;
import javax.swing.*;
import java.awt.*;
import View.Game.*;
import View.ViewMenu.*;
import Controller.ControllerGame.*;
import Model.ModelGame.Obstacles;

public class PauseGameView extends ImageFactory{
    private CarGameView carGameView;
    private CarController carController;
    private JFrame jFrame;
    private JPanel jPanel_PauseView;
    private JLabel titleLabel;
    private JButton jButton_Resume, jButton_PlayAgain, jButton_Home;

    public PauseGameView() {
        this.init();
        jFrame.setVisible(true);
    }
    
    private void init() {
        jFrame = new JFrame();
        jFrame.setTitle("Racing UTC");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        jPanel_PauseView = createImagePanel("Image/Background_02.png", 0, 0, 640, 700);

        titleLabel = createImageLabel("", "Image/title-PauseGame.png", 125, 30, 400, 150);
        jButton_Resume = createButton("RESUME", "Image/Button_01.png", 262, 200, 150, 50);
        jButton_PlayAgain = createButton("PLAY AGAIN", "Image/Button_01.png", 262, 300, 150, 50);
        jButton_Home = createButton("HOME", "Image/Button_01.png", 262, 400, 150, 50);

        jPanel_PauseView.add(titleLabel);
        jPanel_PauseView.add(jButton_Resume);
        jPanel_PauseView.add(jButton_PlayAgain);
        jPanel_PauseView.add(jButton_Home);
        jFrame.add(jPanel_PauseView);
    }

    public void setVisible() {
        jFrame.setVisible(true);
    }

    public JButton getjButton_Resume() {
        return jButton_Resume;
    }

    public void setjButton_Resume(JButton jButton_Resume) {
        this.jButton_Resume = jButton_Resume;
    }

    public JButton getjButton_PlayAgain() {
        return jButton_PlayAgain;
    }

    public void setjButton_PlayAgain(JButton jButton_PlayAgain) {
        this.jButton_PlayAgain = jButton_PlayAgain;
    }

    public JButton getjButton_Home() {
        return jButton_Home;
    }

    public void setjButton_Home(JButton jButton_Home) {
        this.jButton_Home = jButton_Home;
    }
    
    public void dispose() {
        jFrame.dispose();
    }
    
    public static void main(String[] args) {
        new PauseGameView();
    }

}
