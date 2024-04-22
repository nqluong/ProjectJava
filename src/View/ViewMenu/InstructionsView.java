
package View.ViewMenu;

import Controller.ControllerMenu.InstructionsController;
import javax.swing.*;
import java.awt.*;
import View.Game.*;

public class InstructionsView extends ImageFactory {
    private JFrame jFrame;
    private JPanel instructionsPanel;
    private JLabel instruction1Label, instruction2Label, instruction3Label;
    private JButton homeButton;
    
     public InstructionsView() {
         this.init();
     }
             
    private void init(){
        jFrame = new JFrame();
        jFrame.setTitle("Điểm cao");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        
        instructionsPanel = createImagePanel("Image/NenCar_01.png", 0, 0, 640, 700);
        
        instruction1Label = createImageLabel("Dùng phím mũi tên hoặc hai nút A và D", "", 195, 140, 300, 30);
        instruction2Label = createImageLabel("Để di chuyển tránh chướng ngại vật", "", 195, 180, 300, 30);
        instruction3Label = createImageLabel("và ăn các đồng tiền", "", 235, 220, 170, 30);
        homeButton = createButton("Trang chủ", "Image/Button_01.png", 245, 500, 150, 50);
        
        instructionsPanel.add(instruction1Label);
        instructionsPanel.add(instruction2Label);
        instructionsPanel.add(instruction3Label);
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
