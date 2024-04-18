
package View.ViewMenu;

import Controller.ControllerMenu.InstructionsController;
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
     }
             
    private void init(){
        jFrame = new JFrame();
        jFrame.setTitle("Điểm cao");
        jFrame.setSize(640, 700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        
        instructionsPanel = createImagePanel("Image/NenCar_01.png", 0, 0, 640, 700);
        
        instruction1Label = createImageLabel("Dùng phím mũi tên để di chuyển", "", 195, 140, 250, 30);
        instruction2Label = createImageLabel("Tránh chướng ngại vật", "", 235, 180, 170, 30);
        homeButton = createButton("Trang chủ", "Image/Button_01.png", 245, 300, 150, 50);
        
        instructionsPanel.add(instruction1Label);
        instructionsPanel.add(instruction2Label);
        instructionsPanel.add(homeButton);
        
        jFrame.add(instructionsPanel);
    }
    
    public void showInstrctionsView() {
        jFrame.dispose();
        InstructionsView instructionsView = new InstructionsView();
        InstructionsController instructionsController = new InstructionsController(instructionsView);
        instructionsView.setVisible(true);
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
