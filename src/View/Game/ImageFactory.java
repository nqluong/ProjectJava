package View.Game;

import javax.swing.*;
import java.awt.*;

public class ImageFactory {

    protected JPanel createImagePanel(String imagePath, int x, int y, int width, int height) {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(imagePath);
                Image image = imageIcon.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setBounds(x, y, width, height);
        panel.setLayout(null);
        return panel;
    }

    protected JLabel createImageLabel(String text, String imagePath, int x, int y, int width, int height) {
        JLabel label = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(imagePath);
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);

                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.ITALIC, 16));
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(text)) / 2;
                int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                g.drawString(text, x, y);
            }
        };
        label.setBounds(x, y, width, height);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        label.setOpaque(false);
        return label;
    }

    protected JButton createButton(String text, String imagePath, int x, int y, int width, int height) {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon imageIcon = new ImageIcon(imagePath);
                g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);

                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.ITALIC, 16));
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(text)) / 2;
                int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                g.drawString(text, x, y);
            }
        };
        button.setBounds(x, y, width, height);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        return button;
    }

    protected JTextField createTextField(String text, String imagePath, int x, int y, int width, int height) {
        JTextField textField = new JTextField() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon(imagePath);
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), this);

                g.setColor(Color.WHITE);
                g.setFont(new Font("Arial", Font.BOLD, 16));
                FontMetrics fm = g.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(text)) / 3;
                int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                g.drawString(text, getWidth() - x, y);
            }
        };
        textField.setBounds(x, y, width, height);
        textField.setBorder(null);
        textField.setOpaque(false);
        return textField;
    }
}
