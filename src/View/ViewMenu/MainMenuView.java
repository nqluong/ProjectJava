package View.ViewMenu;

import Controller.ControllerMenu.HighScoreController;
import Controller.ControllerMenu.InstructionsController;
import Controller.ControllerMenu.MainMenuController;
import javax.swing.*;
import java.awt.*;
import View.Game.CarGameView;

public class MainMenuView extends JFrame {

    private JPanel mainMenuPanel;
    private JButton highScoreButton;
    private JButton instructionsButton;
    private JButton startButton;

    public MainMenuView() {
        setTitle("Racing UTC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo giao diện trang chủ
        createMainMenuPanel();

        // Thêm giao diện trang chủ vào JFrame
        add(mainMenuPanel);

        // Đặt kích thước cửa sổ JFrame là 640, 340 (thêm 20 pixel chiều cao cho thanh tiêu đề)
        setSize(640, 700);
        setLocationRelativeTo(null);
        setVisible(true);

    }

    ;
    private void createMainMenuPanel() {
        mainMenuPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Vẽ hình nền

                ImageIcon icon = new ImageIcon("Image/background.jpg");
                if (icon.getImageLoadStatus() != java.awt.MediaTracker.ERRORED) {
                    g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.err.println("Error loading image: background.png");
                }
            }
        };

        JLabel titleLabel = new JLabel("Racing 2D");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(250, 30, 160, 30);

        // Tạo nút bắt đầu
        startButton = createButton("Bắt đầu", "Image/button.jpg");
        startButton.setBounds(262, 100, 116, 40);

        // Tạo nút điểm cao
        highScoreButton = createButton("Điểm cao", "Image/button.jpg");
        highScoreButton.setBounds(262, 180, 116, 40);

        // Tạo nút hướng dẫn
        instructionsButton = createButton("Hướng dẫn", "Image/button.jpg");
        instructionsButton.setBounds(262, 260, 116, 40);

        mainMenuPanel.setLayout(null);
        mainMenuPanel.add(titleLabel);
        mainMenuPanel.add(startButton);
        mainMenuPanel.add(highScoreButton);
        mainMenuPanel.add(instructionsButton);
    }

    private JButton createButton(String text, String imagePath) {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Vẽ hình ảnh nút
                ImageIcon icon = new ImageIcon(imagePath);
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                // Vẽ văn bản trên hình ảnh nút
                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 16));
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(text)) / 2;
                int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                g.drawString(text, x, y);
            }
        };
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        return button;
    }
    public void showGame(){
        dispose();
        CarGameView gameView = new CarGameView();
        gameView.setVisible(true);
    }
    //gọi giao diện điểm cao
    public void showHighScoreView() {
        dispose();
        HighScoreView highview = new HighScoreView();
        //tạo controller điểm cao để xử lý các sự kiện trong giao diện điểm cao
        HighScoreController highScoreController = new HighScoreController(highview);
        highview.setVisible(true);
    }
    //gọi giao diện hướng dẫn
    public void showInstrctionsView() {
        dispose();
        InstructionsView instructionsView = new InstructionsView();
        InstructionsController instructionsController = new InstructionsController(instructionsView);
        instructionsView.setVisible(true);
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
    public void showMainMenu() {
        setVisible(true);
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
    
}
