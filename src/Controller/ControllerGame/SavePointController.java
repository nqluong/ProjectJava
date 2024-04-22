package Controller.ControllerGame;

import View.Game.GameOverView;
import View.Game.SavePointView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SavePointController {

    private SavePointView saveView;
    public SavePointController(SavePointView saveView){
        this.saveView = saveView;
        saveView.getjButtonSave().addActionListener(new SaveButtonListener());
    }
    //class xử lý sự kiện khi ấn Lưu
    private class SaveButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            saveView.dispose();
            GameOverView gameOver = new GameOverView();
            new GameOverController(gameOver);
            gameOver.showGameOver();
        }
        
    }
}
