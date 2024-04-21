
package View.ViewMenu;

import javax.swing.*;
import java.awt.*;
import View.Game.*;

public class InstructionsView extends ImageFactory {
    private JFrame jFrame;
    private JPanel instructionsPanel;
    private JLabel instruction1Label, instruction2Label;
    private JButton homeButton;
    
     public InstructionsView() {
         this.init();
         jFrame.setVisible(true);
     }
             
    private void init(){
        jFrame = new JFrame();
        jFrame.setTitle("Điểm cao");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        
        instructionsPanel = createImagePanel("Image/NenCar_01.png", 0, 0, 640, 700);
        
        instruction1Label = createImageLabel("Dùng phím mũi tên để di chuyển", "", 220, 120, 260, 20);
        instruction2Label = createImageLabel("Tránh chướng ngại vật", "", 260, 160, 180, 20);
        homeButton = createButton("Trang chủ", "Image/Button_01.png", 262, 260, 116, 40);
        
        instructionsPanel.add(instruction1Label);
        instructionsPanel.add(instruction2Label);
        instructionsPanel.add(homeButton);
        
        jFrame.add(instructionsPanel);
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
    
}
