/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.gui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tictactoe.bll.ComputerMove;
import tictactoe.bll.GameBoard;
import tictactoe.bll.GameField;
import tictactoe.bll.IGameModel;

/**
 *
 * @author Gruppe 5
 */
public class TicTacViewController implements Initializable
{

    @FXML
    private Label lblPlayer;

    @FXML
    private GridPane gridPane;
    
    private static final String TXT_PLAYER = "Player: ";
    private IGameModel game;

    /**
     * Places an X or an O depending on whose turn it is.
     */
    @FXML
    private void handleButtonAction(ActionEvent event)
    {

        try
        {
            Integer row = GridPane.getRowIndex((Node) event.getSource());
            Integer col = GridPane.getColumnIndex((Node) event.getSource());
            int r = (row == null) ? 0 : row;
            int c = (col == null) ? 0 : col;

            if (game.play(c, r) && game.getWinner() ==-1)
            {
                Button btn = (Button) event.getSource();

                if (game.isGameOver())
                {
                    int winner = game.getWinner();
                    displayWinner(winner);
                    btn.setText(getLabel(game.getNextPlayer()));
                }
                else
                {
                    btn.setText(getLabel(game.getNextPlayer()));
                    setPlayer();
                }

            }
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        /**
         * We check if player is set to 1 (Computer player) and gamedifficulty is not 0 ( 0 => multiplayer).
         */
        if(game.getDifficulty() !=0 && game.getCurrentPlayer() == 1){
            //Initialize an empty button to use later
            Button btn = new Button();

            //Call the computer move logic to get the computers move
            int[] computerMove = ComputerMove.getComputerMove(game.getDifficulty(),game.getGameFields());

            //failsafe to break out if there is no computermove.
            if(computerMove.length == 0){return;}

            //Execute the play method with the computermove
            if (game.play(computerMove[1],computerMove[0]) && game.getWinner() ==-1){

                //Find the button in the gridpane, so the text label can be changed.
                for(Node node:gridPane.getChildren()){
                    if(GridPane.getRowIndex(node) == computerMove[0] && GridPane.getColumnIndex(node) == computerMove[1]){
                        btn = (Button) node;

                    }
                }
            }
            //Check for winner
            if (game.isGameOver())
                {
                    int winner = game.getWinner();
                    displayWinner(winner);
                    btn.setText("X");
                }
                else
                {
                    btn.setText("X");
                    setPlayer();
                }
        }

    }
    /**
    * Getter method for the label which is used to place the X or O in fields the player clicks on.
    */
    public String getLabel(int owner){
        switch (owner){
            case 0:
                return "X";
            case 1:
                return "O";
            case  -1:
                return "";
            default:
                return "Error";

        }
    }

    /**
     * Initializes a new game when the button "New game" is pressed.
     */
    @FXML
    private void handleNewGame(ActionEvent event)
    {
        game.newGame();
        setPlayer();
        clearBoard();
    }
    /**
     * Initializes a new game when the window opens.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        game = new GameBoard();
        setPlayer();
    }

    /**
     * Changes the top label to indicate who's move it is.
     */
    private void setPlayer()
    {
        lblPlayer.setText(TXT_PLAYER + game.getNextPlayer());
    }
    /**
     * Changes the top label to indicate who won or if it was a draw.
     */
    private void displayWinner(int winner)
    {
        String message = "";
        switch (winner)
        {
            case -1:
                message = "It's a draw :-(";
                break;
            default:
                message = "Player " + winner + " wins!!!";
                break;
        }
        lblPlayer.setText(message);
    }

    /**
     * Removes all X & O on the board.
     */
    private void clearBoard()
    {
        for(Node n : gridPane.getChildren())
        {
            Button btn = (Button) n;
            btn.setText("");
        }
    }

    /**
     *  Returns you to the Main Menu and closes the Game board.
     */
    public void handleMainMenu(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/views/Menuscreen.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setTitle("TicTacToe Menu");
        stage.centerOnScreen();
        stage.show();
        Node n = (Node) actionEvent.getSource();
        Stage menu = (Stage) n.getScene().getWindow();
        menu.close();
    }
}
