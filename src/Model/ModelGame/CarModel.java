package Model.ModelGame;

import javax.swing.JLabel;


public class CarModel {

    private JLabel carLabel;
    private int x, y;

    public CarModel(JLabel carLabel) {
        this.carLabel = carLabel;
        this.x = carLabel.getX();
        this.y = carLabel.getY();
    }
    
    public void moveLeft(){
        if(x >= 80) {
            carLabel.setLocation(x -= 80, y);
        }
    }
    public void moveRight(){
        if(x < 240) {
            carLabel.setLocation(x += 80, y);
        }
    }
  
}
