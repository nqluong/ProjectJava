package View.Game;

import com.sun.jdi.connect.spi.Connection;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
public class SavePointView extends ImageFactory{
    private JFrame jFrame;
    private CarGameView view;
    private JPanel jPanel_SavePointView;
    private JLabel jLabelPoint, titleLabel;
    private JButton jButtonSave;
    private JTextField jText;
    public SavePointView(CarGameView view){
        this.view = view;
        this.init();
        jFrame.setVisible(true);
    }
    private void init(){
        jFrame = new JFrame();
        jFrame.setTitle("Save Point");
        jFrame.setSize(640,700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setResizable(true);
        
        jPanel_SavePointView = createImagePanel("Image/nenCar_02.jpg", 0 ,0 , 640, 700);
        
        titleLabel = createImageLabel("", "Image/title-SavePoints.png", 70, 10, 500, 170);
        jText = createTextField("", "Image/UserGame (2).png", 240, 270, 160, 70);
        jButtonSave = createButton("Lưu", "Image/Button_01.png", 245, 450, 150, 50);
        jLabelPoint = createImageLabel(view.getjTextField_Point().getText(), "Image/Point_1.png", 250, 120, 140, 130);
        
        
        jPanel_SavePointView.add(jLabelPoint);
        jPanel_SavePointView.add(jText);
        jPanel_SavePointView.add(jButtonSave);
        jPanel_SavePointView.add(titleLabel);
        jFrame.add(jPanel_SavePointView);
        setVisible(true);
    }
//    private void savePlayer() {
//        String userName = jText.getText(); // Lấy tên người chơi từ trường văn bản
//        int score = Integer.parseInt(view.getjTextField_Point().getText()); // Lấy điểm số từ CarGameView
//        int coins = Integer.parseInt(view.getjTextField_Coin().getText()); // Bạn cần cung cấp giá trị số coin tương ứng
//
//        try (Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/user", "root", "root")) {
//            String sql = "INSERT INTO users (user_name, point, coin) VALUES (?, ?, ?)";
//            try (PreparedStatement statement = connection.prepareStatement(sql)) {
//                // Đặt các tham số trong câu lệnh SQL
//                statement.setString(1, userName);
//                statement.setInt(2, score);
//                statement.setInt(3, coins);
//
//                // Thực thi câu lệnh SQL
//                int rowsAffected = statement.executeUpdate();
//                if (rowsAffected > 0) {
//                    System.out.println("Dữ liệu của người chơi đã được lưu vào cơ sở dữ liệu.");
//                } else {
//                    System.out.println("Lưu dữ liệu của người chơi không thành công!");
//                }
//            }
//        } catch (SQLException e) {
//            System.out.println("Lưu dữ liệu của người chơi thất bại!");
//            e.printStackTrace();
//        }
//        dispose();
//    }
    public JButton getjButtonSave() {
        return jButtonSave;
    }

    public JTextField getjText() {
        return jText;
    }
    

    public void setVisible(boolean b) {
        jFrame.setVisible(b);
    }
    public void dispose(){
        jFrame.dispose();
    }
    
}
