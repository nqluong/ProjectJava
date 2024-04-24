package Controller.ControllerMenu;

import View.ViewMenu.MainMenuView;
import static View.ViewMenu.MainMenuView.playSound;
import static View.ViewMenu.MainMenuView.pauseSound;
import static View.ViewMenu.MainMenuView.resumeSound;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;

public class MainMenuController {

    public boolean isIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(boolean isPlaying) {
        this.isPlaying = isPlaying;
    }
    private MainMenuView view;
    private boolean isPlaying = true;
    private JButton soundButton;

    public MainMenuController() {

    }

    public MainMenuController(MainMenuView view) {
        this.view = view;
        view.getHighScoreButton().addActionListener(new HighScoreButtonListener());
        view.getInstructionsButton().addActionListener(new InstructionsButtonListener());
        view.getSoundButton().addActionListener(new SoundButtonListener());
        view.getStartButton().addActionListener(new StartButtonListener());
    }

    public class HighScoreButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.showHighScoreView();
        }
    }

    public class InstructionsButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.showInstrctionsView();
        }
    }

    public class StartButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            view.showGame();
        }
    }

    public class SoundButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isPlaying) {
                pauseSound();
                view.setButtonText(view.getSoundButton(), "SOUND OFF");
                isPlaying = false;
            } else {
                resumeSound();
                view.setButtonText(view.getSoundButton(), "SOUND ON");
                isPlaying = true;
            }
        }
    }
}
