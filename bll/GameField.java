package tictactoe.bll;

public class GameField {
    private  int owner = -1;
    private  boolean isTaken = false;

    GameField(){
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getOwner(){
        return owner;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public  String getLabel(){
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
}
