/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe.bll;

import tictactoe.gui.controller.MenuScreenController;

/**
 * @author Gruppe 5
 */
public class GameBoard implements IGameModel {

    private GameField[][] gameFields = GameField.newGameFields();
    private int currentPlayer = 0;
    private int winner = -1;

    private int difficulty = MenuScreenController.getDif();

    public int getDifficulty() {
        return difficulty;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public GameField[][] getGameFields() {
        return gameFields;
    }

    /**
     * Returns 0 for player 0, 1 for player 1.
     *
     * @return int Id of the next player.
     */
    public int getNextPlayer() {
        return this.currentPlayer;
    }

    /**
     * Attempts to let the current player play at the given coordinates. It the
     * attempt is successful the current player has ended his turn, and it is the
     * next players turn.
     *
     * @param col column to place a marker in.
     * @param row row to place a marker in.
     * @return true if the move is accepted, otherwise false. If gameOver == true
     * this method will always return false.
     */
    public boolean play(int col, int row) {
        /**
         * Check if field is taken.
         * If it is not taken, owner will be set to current player, and Taken will be set to true.
         * and then current player will switch
         */
        if (!gameFields[row][col].isTaken()) {
            gameFields[row][col].setOwner(this.currentPlayer);
            this.currentPlayer = switchPlayer(this.currentPlayer);
            return true;
        }
        return false;
    }

    /**
     * Checks if there is a winner by checking all 8 winning combinations and returns true if there is.
     */
    public boolean isGameOver() {
        if (winner != -1) {
            return true;
        }
        //1
        //Horisontal
        if (gameFields[0][0].isTaken()) {
            if (gameFields[0][1].getOwner() == gameFields[0][0].getOwner()) {
                if (gameFields[0][2].getOwner() == gameFields[0][0].getOwner()) {
                    winner = gameFields[0][0].getOwner();
                    return true;
                }
            }
        }
        //Diagonaly
        if (gameFields[0][0].isTaken()) {
            if (gameFields[1][1].getOwner() == gameFields[0][0].getOwner()) {
                if (gameFields[2][2].getOwner() == gameFields[0][0].getOwner()) {
                    winner = gameFields[0][0].getOwner();
                    return true;
                }
            }
        }
        //Vertical
        if (gameFields[0][0].isTaken()) {
            if (gameFields[1][0].getOwner() == gameFields[0][0].getOwner()) {
                if (gameFields[2][0].getOwner() == gameFields[0][0].getOwner()) {
                    winner = gameFields[0][0].getOwner();
                    return true;
                }
            }
        }

        //2
        //Vertical
        if (gameFields[0][1].isTaken()) {
            if (gameFields[1][1].getOwner() == gameFields[0][1].getOwner()) {
                if (gameFields[2][1].getOwner() == gameFields[0][1].getOwner()) {
                    winner = gameFields[0][1].getOwner();
                    return true;
                }
            }
        }
        //3
        //Vertical
        if (gameFields[0][2].isTaken()) {
            if (gameFields[1][2].getOwner() == gameFields[0][2].getOwner()) {
                if (gameFields[2][2].getOwner() == gameFields[0][2].getOwner()) {
                    winner = gameFields[0][2].getOwner();
                    return true;
                }
            }
        }
        if (gameFields[0][2].isTaken()) {
            if (gameFields[1][1].getOwner() == gameFields[0][2].getOwner()) {
                if (gameFields[2][0].getOwner() == gameFields[0][2].getOwner()) {
                    winner = gameFields[0][2].getOwner();
                    return true;
                }
            }
        }
        //4
        if (gameFields[1][0].isTaken()) {
            if (gameFields[1][1].getOwner() == gameFields[1][0].getOwner()) {
                if (gameFields[1][2].getOwner() == gameFields[1][0].getOwner()) {
                    winner = gameFields[1][0].getOwner();
                    return true;
                }
            }
        }
        //7
        if (gameFields[2][0].isTaken()) {
            if (gameFields[2][1].getOwner() == gameFields[2][0].getOwner()) {
                if (gameFields[2][2].getOwner() == gameFields[2][0].getOwner()) {
                    winner = gameFields[2][0].getOwner();
                    return true;
                }
            }
        }

        /**
         * Check if all fields is taken. If all fields is not taken the game will continue
         */

        //Because human always start, computer can only make move 2,4,6,8 and there will always be an empty field.


        for (int r = 0; r < gameFields.length; r++) {
            for (int c = 0; c < gameFields[r].length; c++) {
                if (!gameFields[r][c].isTaken()) {
                    return false;
                }

            }
        }


        return true;
    }

    public void computerMove() {
        int[] move = ComputerMove.getComputerMove(difficulty, gameFields);
        play(move[1], move[0]);

    }

    /**
     * Gets the id of the winner, -1 if its a draw.
     *
     * @return int id of winner, or -1 if draw.
     */
    public int getWinner() {

        return winner;
    }

    /**
     * Resets the game to a new game state.
     */
    public void newGame() {
        gameFields = GameField.newGameFields();
        currentPlayer = 0;
        winner = -1;
    }

    /**
     * Changes the player from 1 to 0 or vise versa.
     */
    private int switchPlayer(int p) {
        switch (p) {
            case 0:
                return 1;
            case 1:
                return 0;
            default:
                return 0;
        }


    }

}
