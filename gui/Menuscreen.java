package tictactoe.gui;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Menuscreen extends Application {


    @Override
    public void start(Stage stage) throws Exception {


        Parent root = FXMLLoader.load(getClass().getResource("/views/Menuscreen.fxml"));

        Scene scene = new Scene(root);


        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("TicTacToe Menu");
        stage.centerOnScreen();


        stage.show();
    }

    public static void main(String[] args) { launch(args); }


}