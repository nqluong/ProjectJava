package Main;

//import static View.ViewMenu.MainMenuView.playSound;
import Controller.ControllerMenu.*;
import View.ViewMenu.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CarGame {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/projectjava";
        String user = "root";
        String password = "nqluong1405";

        try {
            // Kết nối đến cơ sở dữ liệu
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");


            // đóng kết nối sau khi hoàn thành
            connection.close();
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại!");
            e.printStackTrace();
        }
          MainMenuView mainMenuView = new MainMenuView();
          mainMenuView.setVisible();
          MainMenuController mainMenuController =  new MainMenuController(mainMenuView);
          mainMenuView.playSound("Sound/NhacNen.wav");
         
    }
}
