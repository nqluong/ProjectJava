package View.Game;

/**
 *
 * @author nguye
 */

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
public class SavePointView extends ImageFactory{
    private JFrame jFrame;
    private JPanel jPanel_SavePointView;
    private JLabel jLabelSave, jLabelPoint;
    private JButton jButtonSave;
    private JTextField jText;
    public SavePointView(){
        this.init();
    }
    private void init(){
        jFrame = new JFrame();
        jFrame.setTitle("Save Point");
        jFrame.setSize(640,500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setResizable(true);
        
        jPanel_SavePointView = createImagePanel("Image/nenCar_02.jpg", 0 ,0 , 640, 500);
        
        JLabel titleLabel = new JLabel("Racing 2D");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBounds(250, 30, 160, 30);
        
        jLabelSave = createImageLabel("Nhập tên của bạn:", "Image/Button_01.png", 50, 180, 200, 40);
        //nhập tên và lưu tên đã nhập
        jText = new JTextField();
        jText.setBounds(280, 180, 200, 40);
        jButtonSave = createButton("Lưu", "Image/Button_01.png", 260, 240, 120, 40);
        //hiện số điểm đạt được
        jLabelPoint = createImageLabel("Số điểm đạt được: "+10, "Image/Button_01.png", 200, 100, 240, 40);
        
        
        jPanel_SavePointView.add(jLabelPoint);
        jPanel_SavePointView.add(jText);
        jPanel_SavePointView.add(jButtonSave);
        jPanel_SavePointView.add(jLabelSave);
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
