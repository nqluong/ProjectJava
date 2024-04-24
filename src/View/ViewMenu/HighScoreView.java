package View.ViewMenu;

import Controller.ControllerMenu.HighScoreController;
import javax.swing.*;
import java.awt.*;
import View.Game.*;
import com.sun.jdi.connect.spi.Connection;

public class HighScoreView extends ImageFactory {

    private JFrame jFrame;
    private JPanel highScorePanel;
    private JButton homeButton;
    private JLabel playerLabel, scoreLabel;

    public HighScoreView() {
        this.init();
    }

    private void init() {
        jFrame = new JFrame();
        jFrame.setTitle("High Score");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        highScorePanel = createImagePanel("Image/NenCar_01.png", 0, 0, 640, 700);

        playerLabel = createImageLabel("Player", "", 120, 150, 80, 30);
        scoreLabel = createImageLabel("Score", "", 445, 150, 70, 30);
        homeButton = createButton("HOME", "Image/Button_01.png", 245, 500, 150, 50);

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

    public void dispose() {
        jFrame.dispose();
    }

//    private void displayHighScores() {
//        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "root")) {
//            String sql = "SELECT user_name, point FROM users ORDER BY point DESC LIMIT 5";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                ResultSet resultSet = statement.executeQuery();
//
//                int posY = 150; // Vị trí y ban đầu của label điểm cao
//                int labelCount = 0; // Đếm số lượng label đã tạo
//
//                while (resultSet.next()) {
//                    String userName = resultSet.getString("user_name");
//                    int point = resultSet.getInt("point");
//
//                    // Hiển thị thông tin người chơi trên giao diện
//                    JLabel playerNameLabel = createImageLabel(userName, "", 100, posY, 200, 30);
//                    JLabel playerScoreLabel = createImageLabel(String.valueOf(point), "", 400, posY, 100, 30);
//
//                    highScorePanel.add(playerNameLabel);
//                    highScorePanel.add(playerScoreLabel);
//
//                    posY += 40; // Tăng vị trí y cho label tiếp theo
//                    labelCount++; // Tăng biến đếm
//
//                    // Nếu đã hiển thị đủ 5 người chơi, thoát vòng lặp
//                    if (labelCount >= 5) {
//                        break;
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Không thể kết nối đến cơ sở dữ liệu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
//        }
//    }
}
