package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class MenuScreenController {
    public Button singlePlayer;
    public Button multiPlayer;
    public Button quitGame;
    public Button options;
    public ToggleGroup difToggle;
    public RadioButton hardMode;
    public RadioButton easyMode;
    public RadioButton intermediateMode;

    private int difficulty;

    public void difficultyForSinglePlayer() {
        if (hardMode.isSelected()) {
            difficulty = 3;
        } else if (intermediateMode.isSelected()) {
            difficulty = 2;
        } else
            difficulty = 1;
    }


    public void singlePlayerBtn(ActionEvent actionEvent) {

    }

    public void multiPlayerBtn(ActionEvent actionEvent) {
    }

    public void quitGameBtn(ActionEvent actionEvent) {
    }

    public void optionsBtn(ActionEvent actionEvent) {
    }


}
