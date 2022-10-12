package tictactoe.gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import javafx.stage.Window;
import tictactoe.gui.Menuscreen;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;

public class MenuScreenController {
    public Button singlePlayer;
    public Button multiPlayer;
    public Button quitGame;
    public Button options;
    public RadioButton hardMode;
    public RadioButton intermediateMode;
    public RadioButton easyMode;
    private static int dif = 0;

    public void difficulty() {
        if (hardMode.isSelected()) {
            dif = 3;
        } else if (intermediateMode.isSelected()) {
            dif = 2;
        } else dif = 1;
    }

    public static int getDif()
    {
        return dif;
    }

    public void singlePlayerBtn(ActionEvent actionEvent) throws IOException {
        difficulty();
        Parent root = FXMLLoader.load(getClass().getResource("/views/TicTacView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("TicTacToe Single Player");
        stage.centerOnScreen();
        stage.show();
        Node n = (Node) actionEvent.getSource();
        Stage menu = (Stage) n.getScene().getWindow();
        menu.close();


    }

    @FXML
    private void multiPlayerBtn(ActionEvent actionEvent) throws IOException {
        dif = 0;
        Parent root = FXMLLoader.load(getClass().getResource("/views/TicTacView.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("TicTacToe Multiplayer");
        stage.centerOnScreen();
        stage.show();
        Node n = (Node) actionEvent.getSource();
        Stage menu = (Stage) n.getScene().getWindow();
        menu.close();


    }


    public void quitGameBtn(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void optionsBtn(ActionEvent actionEvent) throws IOException {

        try {
            Desktop desktop = java.awt.Desktop.getDesktop();
            URI oURL = new URI("https://www.youtube.com/watch?v=wpV-gGA4PSk");
            desktop.browse(oURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void easyModeChoice(ActionEvent actionEvent) {

    }

    public void hardModeChoice(ActionEvent actionEvent) {
    }

    public void intermediateModeChoice(ActionEvent actionEvent) {
    }
}
