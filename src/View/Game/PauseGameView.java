
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
    private JButton jButton_Resume, jButton_PlayAgain, jButton_Home;


    public PauseGameView(MainMenuView mainMenuView) {
        this.init();
    }

    public PauseGameView() {
        this.init();
    }
    
    private void init() {
        jFrame = new JFrame();
        jFrame.setTitle("Racing UTC");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        jPanel_PauseView = createImagePanel("Image/Background_02.png", 0, 0, 640, 700);

        JLabel titleLabel = new JLabel("Racing 2D");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(250, 30, 160, 30);  

        jButton_Resume = createButton("RESUME", "Image/Button_01.png", 262, 100, 116, 40);
        jButton_PlayAgain = createButton("PLAY AGAIN", "Image/Button_01.png", 262, 180, 116, 40);
        jButton_Home = createButton("HOME", "Image/Button_01.png", 262, 260, 116, 40);

        jPanel_PauseView.add(titleLabel);
        jPanel_PauseView.add(jButton_Resume);
        jPanel_PauseView.add(jButton_PlayAgain);
        jPanel_PauseView.add(jButton_Home);
        jFrame.add(jPanel_PauseView);
        jFrame.setVisible(true);
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
        PauseGameView pauseView = new PauseGameView();
        new PauseGameController(pauseView);
    }
}
