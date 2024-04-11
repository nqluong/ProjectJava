import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CarGame extends JFrame {
    private JPanel mainMenuPanel;
    
    public CarGame() {
        setTitle("Racing UTC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Tạo giao diện trang chủ
        createMainMenuPanel();

        // Thêm giao diện trang chủ vào JFrame
        add(mainMenuPanel);

        // Đặt kích thước cửa sổ JFrame là 640, 340 (thêm 20 pixel chiều cao cho thanh tiêu đề)
        setSize(640, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

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
        mainMenuPanel.setLayout(null);

        JLabel titleLabel = new JLabel("Racing 2D");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(250, 30, 160, 30);
        mainMenuPanel.add(titleLabel);

        // Tạo nút bắt đầu
        JButton startButton = createButton("Bắt đầu", "Image/button.jpg");
        startButton.setBounds(262, 100, 116, 40);
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Xử lý sự kiện khi nhấp vào nút "Bắt đầu"
            }
        });
        mainMenuPanel.add(startButton);

        // Tạo nút điểm cao
        JButton highScoreButton = createButton("Điểm cao", "Image/button.jpg");
        highScoreButton.setBounds(262, 180, 116, 40);
        highScoreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hiển thị giao diện điểm cao
                showHighScorePanel();
            }
        });
        mainMenuPanel.add(highScoreButton);

        // Tạo nút hướng dẫn
        JButton instructionsButton = createButton("Hướng dẫn", "Image/button.jpg");
        instructionsButton.setBounds(262, 260, 116, 40);
        instructionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Hiển thị giao diện hướng dẫn
                showInstructionsPanel();
            }
        });
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
    private void showInstructionsPanel() {
        // Tạo và hiển thị giao diện hướng dẫn
        InstructionsPanel instructionsPanel = new InstructionsPanel();
        instructionsPanel.setVisible(true);
    }

    private void showHighScorePanel() {
        // Tạo và hiển thị giao diện điểm cao
        HighScorePanel highScorePanel = new HighScorePanel();
        highScorePanel.setVisible(true);
    }

    private class InstructionsPanel extends JFrame {
        public InstructionsPanel() {
            setTitle("Hướng dẫn");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(640, 500);
            setResizable(false);
            setLocationRelativeTo(null);

            // Tạo một JPanel để chứa hình nền và nút trang chủ
            JPanel instructionsPanel = new JPanel() {
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
        instructionsPanel.add(instruction1Label);

        JLabel instruction2Label = new JLabel("Tránh chướng ngại vật");
        instruction2Label.setFont(new Font("Arial", Font.PLAIN, 16));
        instruction2Label.setForeground(Color.WHITE);
        instruction2Label.setBounds(260, 160, 180, 20);
        instructionsPanel.add(instruction2Label);
            // Tạo nút trang chủ
            JButton homeButton = createButton("Trang chủ", "Image/button.jpg");
            homeButton.setBounds(262, 260, 116, 40);
            homeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                   
                    // Đóng giao diện hướng dẫn và hiển thị lại giao diện trang chủ
                    dispose();
                    
                }
            });
            instructionsPanel.add(homeButton);

            // Thêm JPanel vào JFrame
            add(instructionsPanel);
        }
    }

    private class HighScorePanel extends JFrame {
        public HighScorePanel() {
            setTitle("Điểm cao");
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            setSize(640, 500);
            setResizable(false);
            setLocationRelativeTo(null);

            // Tạo một JPanel để chứa hình nền và văn bản điểm cao
            JPanel highScorePanel = new JPanel() {
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
            highScorePanel.add(playerLabel);

            // Tạo văn bản điểm số
            JLabel scoreLabel = new JLabel("Điểm số");
            scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
            scoreLabel.setForeground(Color.WHITE);
            scoreLabel.setBounds(400, 100, 100, 30);
            highScorePanel.add(scoreLabel);

            // Tạo nút trang chủ
            JButton homeButton = createButton("Trang chủ", "Image/button.jpg");
            homeButton.setBounds(262, 260, 116, 40);
            homeButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Đóng giao diện điểm cao và hiển thị lại giao diện trang chủ
                   
                    dispose();
                }
            });
            highScorePanel.add(homeButton);

            // Thêm JPanel vào JFrame
            add(highScorePanel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CarGame());
    }
}
