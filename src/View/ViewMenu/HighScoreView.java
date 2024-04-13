/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.ViewMenu;

import Controller.ControllerMenu.HighScoreController;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author nguye
 */
public class HighScoreView extends JFrame {
    private JPanel highScorePanel;
    private JButton homeButton;
    
    public HighScoreView() {
        setTitle("Điểm cao");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(640, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        
        // Tạo một JPanel để chứa hình nền và văn bản điểm cao
        highScorePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Vẽ hình nền
                ImageIcon icon = new ImageIcon("Image/background.jpg");
                if (icon.getImageLoadStatus() != java.awt.MediaTracker.ERRORED) {
                    g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), this);
                } else {
                    System.err.println("Error loading image: background");
                }
            }
        };
        highScorePanel.setLayout(null);

        // Tạo văn bản người chơi
        JLabel playerLabel = new JLabel("Người chơi");
        playerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        playerLabel.setForeground(Color.WHITE);
        playerLabel.setBounds(100, 100, 100, 30);
        

        // Tạo văn bản điểm số
        JLabel scoreLabel = new JLabel("Điểm số");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(400, 100, 100, 30);
        
        // Tạo nút trang chủ
        homeButton = createButton("Trang chủ", "Image/button.jpg");
        homeButton.setBounds(262, 260, 116, 40);
        
        highScorePanel.add(playerLabel);
        highScorePanel.add(scoreLabel);
        highScorePanel.add(homeButton);
        
        add(highScorePanel);
        
    }

    private JButton createButton(String text, String imagebuttonjpg) {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Vẽ hình ảnh nút
                ImageIcon icon = new ImageIcon(imagebuttonjpg);
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

    public JButton getHomeButton() {
        return homeButton;
    }

    public void setHomeButton(JButton homeButton) {
        this.homeButton = homeButton;
    }

}

