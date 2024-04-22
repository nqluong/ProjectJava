package View.ViewMenu;

import Controller.ControllerGame.*;
import Controller.ControllerMenu.*;
import Model.ModelGame.*;
import javax.swing.*;
import java.awt.*;
import View.Game.*;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class MainMenuView extends ImageFactory {

    private JFrame jFrame;
    private JPanel mainMenuPanel;
    public JButton highScoreButton;
    public JButton instructionsButton;
    private JButton startButton;
    private JButton soundButton;
    private JLabel titleLabel;
    private static Clip clip;
    private static long clipTimePosition;
    private MainMenuController mainMenuController;

    public MainMenuView() {
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

        mainMenuPanel = createImagePanel("Image/NenCar_01.png", 0, 0, 640, 700);
        
        titleLabel = createImageLabel("", "Image/title-Menu.png", 125, 30, 400, 150);
        startButton = createButton("Bắt đầu", "Image/Button_01.png", 245, 230, 150, 50);
        highScoreButton = createButton("Điểm cao", "Image/Button_01.png", 245, 310, 150, 50);
        instructionsButton = createButton("Hướng dẫn", "Image/Button_01.png", 245, 390, 150, 50);
        soundButton = createButton("Sound On", "Image/Button_01.png", 245, 470, 150, 50);
        
        mainMenuPanel.add(titleLabel);
        mainMenuPanel.add(startButton);
        mainMenuPanel.add(highScoreButton);
        mainMenuPanel.add(instructionsButton);
        mainMenuPanel.add(soundButton);
        jFrame.add(mainMenuPanel);
    }

    public void showGame() {
        jFrame.dispose();
        CarGameView view = new CarGameView();
        CarController carController = new CarController(view);
        CarGameController carGame = new CarGameController(view);
        view.startGame();
        view.setVisible(true);
    }

    //gọi giao diện điểm cao
    public void showHighScoreView() {
        jFrame.dispose();
        HighScoreView highview = new HighScoreView();
        //tạo controller điểm cao để xử lý các sự kiện trong giao diện điểm cao
        HighScoreController highScoreController = new HighScoreController(highview);
        highview.setVisible(true);
    }

    //gọi giao diện hướng dẫn
    public void showInstrctionsView() {
        InstructionsView instructionsView = new InstructionsView();
        new InstructionsController(instructionsView);
        instructionsView.setVisible(true);
    }
    
    
    public void showMainMenu() {
        jFrame.setVisible(true);
        mainMenuController = new MainMenuController(this);
        
    }
    
    public static void playSound(String soundFile) {
        try {
            File file = new File(soundFile);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void pauseSound() {
        if (clip != null && clip.isRunning()) {
            clipTimePosition = clip.getMicrosecondPosition(); // Lưu vị trí thời gian hiện tại của clip
            clip.stop(); // Dừng phát âm thanh
        }
    }

    public static void resumeSound() {
        if (clip != null) {
            clip.setMicrosecondPosition(clipTimePosition); // Đặt lại vị trí thời gian của clip
            clip.start(); // Tiếp tục phát âm thanh
        }
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

    //gọi giao diện menu

    public JPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public void setButtonText(JButton button, String text) {
        button.setText(text); // Đặt văn bản mới cho nút
    try {
        button.repaint(); // Vẽ lại nút để hiển thị văn bản mới
    } catch (Exception ex) {
        ex.printStackTrace(); // In ra stack trace của ngoại lệ nếu có lỗi
    }
}

    public void setStartButton(JButton startButton) {
        this.startButton = startButton;
    }

    
    public JButton getSoundButton() {
        return soundButton;
    }
   
    
    public void dispose() {
        jFrame.dispose();
    }

    public void setVisible() {
        jFrame.setVisible(true);
    }

  }
