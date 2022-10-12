/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import tictactoe.gui.controller.MenuScreenController;

/**
 *
 * @author Stegger
 */
public class GameBoard implements IGameModel
{

    private GameField[][] gameFields = GameField.newGameFields();
    private int currentPlayer=0;
    private  int winner =-1;

    private int difficulty = MenuScreenController.getDif();

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer()
    {
        return this.currentPlayer;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is succesfull the current player has ended his turn and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row)
    {
        /**
         * Check if field i taken.
         * If it is not taken, owner will be set to current player, and Taken will be set to true.
         * and then current player will swicht
         **/
        if(!gameFields[row][col].isTaken()){
            gameFields[row][col].setOwner(this.currentPlayer);
            this.currentPlayer = switchPlayer(this.currentPlayer);
            return true;
        }
        return false;
    }
    public boolean isGameOver() {
        boolean gameover = false;
        if(winner!= -1){return true;}
        //1
        //Horisontal
        if(gameFields[0][0].isTaken()){
            if(gameFields[0][1].getOwner()== gameFields[0][0].getOwner()) {
                if(gameFields[0][2].getOwner()== gameFields[0][0].getOwner()){
                    winner = gameFields[0][0].getOwner();
                    return true;
        }}}
        //Diagonaly
        if(gameFields[0][0].isTaken()){
            if(gameFields[1][1].getOwner()== gameFields[0][0].getOwner()) {
                if(gameFields[2][2].getOwner()== gameFields[0][0].getOwner()){
                    winner = gameFields[0][0].getOwner();
                    return true;
        }}}
        //Vertical
        if(gameFields[0][0].isTaken()){
            if(gameFields[1][0].getOwner()== gameFields[0][0].getOwner()) {
                if(gameFields[2][0].getOwner()== gameFields[0][0].getOwner()){
                    winner = gameFields[0][0].getOwner();
                    return true;
        }}}

        //2
        //Vertical
        if(gameFields[0][1].isTaken()){
            if(gameFields[1][1].getOwner()== gameFields[0][1].getOwner()) {
                if(gameFields[2][1].getOwner()== gameFields[0][1].getOwner()){
                    winner = gameFields[0][1].getOwner();
                    return true;
        }}}
        //3
        //Vertical
        if(gameFields[0][2].isTaken()){
            if(gameFields[1][2].getOwner()== gameFields[0][2].getOwner()) {
                if(gameFields[2][2].getOwner()== gameFields[0][2].getOwner()){
                    winner = gameFields[0][2].getOwner();
                    return true;
        }}}
        if(gameFields[0][2].isTaken()){
            if(gameFields[1][1].getOwner()== gameFields[0][2].getOwner()) {
                if(gameFields[2][0].getOwner()== gameFields[0][2].getOwner()){
                    winner = gameFields[0][2].getOwner();
                    return true;
        }}}
        //4
        if(gameFields[1][0].isTaken()){
            if(gameFields[1][1].getOwner()== gameFields[1][0].getOwner()) {
                if(gameFields[1][2].getOwner()== gameFields[1][0].getOwner()){
                    winner = gameFields[1][0].getOwner();
                    return true;
        }}}
        //7
        if(gameFields[2][0].isTaken()){
            if(gameFields[2][1].getOwner()== gameFields[2][0].getOwner()) {
                if(gameFields[2][2].getOwner()== gameFields[2][0].getOwner()){
                    winner = gameFields[2][0].getOwner();
                    return true;
        }}}

        /**
         * Check if all fields i taken. If all fields is not taken the game will continue
         */

            for (int r = 0; r < gameFields.length; r++) {
                for (int c = 0; c < gameFields[r].length; c++) {
                    if(!gameFields[r][c].isTaken()){return false;}

                }
            }


        return true;
    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner()
    {

        return winner;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame()
    {
        gameFields = GameField.newGameFields();
        currentPlayer = 0;
        winner = -1;
    }

    private int switchPlayer(int p){
        switch (p){
            case 0:
                return 1;
            case 1:
                return 0;
            default:
                return 0;
        }


    }

}
