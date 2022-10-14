package tictactoe.bll;
/**
 *
 * @author Gruppe 5
 */
public class GameField {
    private  int owner =-1;

    public void setOwner(int o) {
        this.owner = o;
    }

    public int getOwner(){
        return this.owner;
    }

    public boolean isTaken() {
        return owner!=-1;
    }

    /**
     * Creates a multidimensional array which is used as coordinates for the gameboard.
     */
    public static GameField[][] newGameFields(){
        GameField[][] output = new GameField[3][3];
        for (int r = 0; r < output.length; r++){
            for(int c = 0 ;c < output[r].length; c++){
                output[r][c]= new GameField();
            }
        }
        return output;
    }
}
