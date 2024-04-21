package View.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoadLabel extends JLabel {

    private Image roadImage;
    private int roadY = 0;
    private int roadSpeed = 2;
    private Thread animationThread;
    private boolean paused = false, running = true;

    public RoadLabel(String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        roadImage = icon.getImage();
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));

        animationThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (running) {
                    if (!paused) {
                        roadY += roadSpeed;
                        if (roadY >= getHeight()) {
                            roadY = 0;
                        }
                        // Yêu cầu vẽ lại JLabel để cập nhật hiển thị
                        repaint();
                    }

                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        animationThread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Vẽ ảnh đường tại vị trí hiện tại
        g.drawImage(roadImage, 0, roadY, getWidth(), getHeight(), this);
        // Vẽ lại ảnh đường ở phía trên để tạo hiệu ứng lặp lại
        g.drawImage(roadImage, 0, roadY - getHeight(), getWidth(), getHeight(), this);
    }
    public void pauseAnimation(){
        paused = true;
    }
    public void resumeAnimation(){
        paused = false;
    }
    public void overGame(){
        running = false;
    }

    public int getRoadSpeed() {
        return roadSpeed;
    }

    public void setRoadSpeed(int roadSpeed) {
        this.roadSpeed = roadSpeed;
    }
    
}
