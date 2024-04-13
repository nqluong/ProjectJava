/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.ViewMenu;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author nguye
 */
public class InstructionsView extends JFrame {
    private JPanel instructionsPanel;
    private JButton homeButton;
    public InstructionsView() {
        setTitle("Hướng dẫn");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(640, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        // Tạo một JPanel để chứa hình nền và nút trang chủ 
        instructionsPanel = new JPanel() {
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
        instructionsPanel.setLayout(null);

        // Tạo văn bản hướng dẫn
        JLabel instruction1Label = new JLabel("Dùng phím mũi tên để di chuyển");
        instruction1Label.setFont(new Font("Arial", Font.PLAIN, 16));
        instruction1Label.setForeground(Color.WHITE);
        instruction1Label.setBounds(220, 120, 260, 20);
        

        JLabel instruction2Label = new JLabel("Tránh chướng ngại vật");
        instruction2Label.setFont(new Font("Arial", Font.PLAIN, 16));
        instruction2Label.setForeground(Color.WHITE);
        instruction2Label.setBounds(260, 160, 180, 20);
        
        // Tạo nút trang chủ
        homeButton = createButton("Trang chủ", "Image/button.jpg");
        homeButton.setBounds(262, 260, 116, 40);

        instructionsPanel.add(homeButton);
        instructionsPanel.add(instruction2Label);
        instructionsPanel.add(instruction1Label);
//      Thêm JPanel vào JFrame
        add(instructionsPanel);
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
