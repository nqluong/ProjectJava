
package View.Game;
import javax.swing.*;
import java.awt.*;
import View.Game.*;
import View.ViewMenu.*;
import Controller.ControllerGame.*;
import Model.ModelGame.Obstacles;

public class PauseGameView extends ImageFactory{
    private CarGameView view;
    private CarController carController;
    private JFrame jFrame;
    private JLabel titleLabel;
    private JPanel jPanel_PauseView;
    private JButton jButton_Resume, jButton_PlayAgain, jButton_Home;

    public PauseGameView(CarGameView view) {
        this.init();
        this.view = view;
    }
    
        private void init() {
        jFrame = new JFrame();
        jFrame.setTitle("Pause Game");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        jPanel_PauseView = createImagePanel("Image/Background_02.png", 0, 0, 640, 700);

        titleLabel = createImageLabel("", "Image/title-PauseGame.png", 125, 30, 400, 150);
        jButton_Resume = createButton("RESUME", "Image/Button_01.png", 245, 200, 150, 50);
        jButton_PlayAgain = createButton("PLAY AGAIN", "Image/Button_01.png", 245, 280, 150, 50);
        jButton_Home = createButton("HOME", "Image/Button_01.png", 245, 360, 150, 50);

        jPanel_PauseView.add(titleLabel);
        jPanel_PauseView.add(jButton_Resume);
        jPanel_PauseView.add(jButton_PlayAgain);
        jPanel_PauseView.add(jButton_Home);
        jFrame.add(jPanel_PauseView);
            setVisible(true);
    }
    public void setVisible(boolean a){
        jFrame.setVisible(a);
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
}
