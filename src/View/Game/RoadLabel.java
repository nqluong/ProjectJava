package View.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoadLabel extends JLabel implements ActionListener {
    private Image roadImage;
    private int roadY = 0; // Vị trí của ảnh đường theo trục Y
    private int roadSpeed = 4; // Tốc độ di chuyển của đường
    private Timer timer;

    public RoadLabel(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        roadImage = icon.getImage();
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        
        // Khởi tạo và bắt đầu Timer để cập nhật vị trí của ảnh
        timer = new Timer(20, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ ảnh đường tại vị trí hiện tại
        g.drawImage(roadImage, 0, roadY, getWidth(), getHeight(), this);
        // Vẽ lại ảnh đường ở phía trên để tạo hiệu ứng lặp lại
        g.drawImage(roadImage, 0, roadY - getHeight(), getWidth(), getHeight(), this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Cập nhật vị trí của đường
        roadY += roadSpeed;
        // Nếu ảnh đường di chuyển ra khỏi phía dưới của JLabel, đặt lại vị trí
        if (roadY >= getHeight()) {
            roadY = 0;
        }
        // Yêu cầu vẽ lại JLabel để cập nhật hiển thị
        repaint();
    }
}
