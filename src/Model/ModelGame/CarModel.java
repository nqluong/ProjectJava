package Model.ModelGame;

import javax.swing.JLabel;

/**
 *
 * @author nguye
 */
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public JLabel getCarLabel() {
        return carLabel;
    }
    
}
