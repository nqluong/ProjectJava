package View.Game;

import java.awt.Color;
import java.awt.Font;
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
