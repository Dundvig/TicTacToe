package tictactoe.bll;
import java.util.ArrayList;
import java.util.Collections;

public class ComputerMove {

    public static int[] getComputerMove(int level, GameField[][] gameFields ){

        //Find all free fields
        ArrayList<int[]> emptyFields = new ArrayList<>();
        for(int r = 0; r < gameFields.length; r++){
            for(int c =0; c < gameFields[r].length; c++){
                if(!gameFields[r][c].isTaken()){
                    emptyFields.add(new int[]{r,c});
                }
            }
        }

        //Decide what logic to use
        switch (level){
            case 1:
                return level1(emptyFields);
            case 2:
                return level2(emptyFields);
            default:
                return level3(emptyFields, gameFields);
        }
    }


    private static int[] level1(ArrayList<int[]> emptyFields){
        //Shuffle the list of empty fields and the take the first field in the list
        Collections.shuffle(emptyFields);
        return emptyFields.get(0);
    }

    private static int[] level2(ArrayList<int[]> emptyFields){
        //create 3 prio lists.
        ArrayList<int[]> prio1 = new ArrayList<>();
        prio1.add(new int[]{1,1});

        ArrayList<int[]> prio2 = new ArrayList<>();
        prio2.add(new int[]{0,0});
        prio2.add(new int[]{2,0});
        prio2.add(new int[]{0,2});
        prio2.add(new int[]{2,2});
        //randomize the list so we will get a random field order. All fields in the list has even priority
        Collections.shuffle(prio2);

        ArrayList<int[]> prio3 = new ArrayList<>();
        prio3.add(new int[]{1,2});
        prio3.add(new int[]{1,0});
        prio3.add(new int[]{2,1});
        prio3.add(new int[]{0,1});
        //randomize the list so we will get a random field order. All fields in the list has even priority
        Collections.shuffle(prio3);

        //Check if a field from empty fields matches a field from prio1. Return first match
        for(int i = 0; i < emptyFields.size(); i++){
            if(prio1.get(0)[0] == emptyFields.get(i)[0] && prio1.get(0)[1] == emptyFields.get(i)[1]){
                return emptyFields.get(i);
            }
        }

        //Check if a field from empty fields matches a field from prio2. Return first match
        for (int i = 0; i < prio2.size();i++){
            for (int j = 0; j < emptyFields.size(); j++){
                if(prio2.get(i)[0] == emptyFields.get(j)[0] && prio2.get(i)[1] == emptyFields.get(j)[1]){
                        return  emptyFields.get(j);
                }
            }
        }

        //Check if a field from empty fields matches a field from prio3. Return first match
        for (int i = 0; i < prio3.size();i++){
            for (int j = 0; j < emptyFields.size(); j++){
                if(prio3.get(i)[0] == emptyFields.get(j)[0] && prio3.get(i)[1] == emptyFields.get(j)[1]){
                    return  emptyFields.get(j);
                }
            }
        }

        return new int[0];
    }

    private static int[] level3(ArrayList<int[]> emptyFields, GameField[][] gameFields){

        //Check for winning move. Computer is always player 1
        for(int i = 0; i< emptyFields.size();i++){
            if (emptyFields.get(i)[0] == 0 && emptyFields.get(i)[1] == 0){
                if(gameFields[0][1].getOwner() == 1 && gameFields[0][2].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[1][1].getOwner() == 1 && gameFields[2][2].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[1][0].getOwner() == 1 && gameFields[2][0].getOwner() == 1){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 0 && emptyFields.get(i)[1] == 1){
                if(gameFields[1][1].getOwner() == 1 && gameFields[2][1].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[0][0].getOwner() == 1 && gameFields[0][2].getOwner() == 1){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 0 && emptyFields.get(i)[1] == 2){
                if(gameFields[0][0].getOwner() == 1 && gameFields[0][1].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[1][2].getOwner() == 1 && gameFields[2][2].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[2][0].getOwner() == 1 && gameFields[1][1].getOwner() == 1){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 1 && emptyFields.get(i)[1] == 0){
                if(gameFields[0][0].getOwner() == 1 && gameFields[2][0].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[1][1].getOwner() == 1 && gameFields[1][2].getOwner() == 1){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 1 && emptyFields.get(i)[1] == 1){
                if(gameFields[0][0].getOwner() == 1 && gameFields[2][2].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[2][0].getOwner() == 1 && gameFields[0][2].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[1][0].getOwner() == 1 && gameFields[1][2].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[0][1].getOwner() == 1 && gameFields[2][1].getOwner() == 1){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 1 && emptyFields.get(i)[1] == 2){
                if(gameFields[0][2].getOwner() == 1 && gameFields[2][2].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[1][0].getOwner() == 1 && gameFields[1][1].getOwner() == 1){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 2 && emptyFields.get(i)[1] == 0){
                if(gameFields[1][1].getOwner() == 1 && gameFields[0][2].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[0][0].getOwner() == 1 && gameFields[1][0].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[2][1].getOwner() == 1 && gameFields[2][2].getOwner() == 1){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 2 && emptyFields.get(i)[1] == 1){
                if(gameFields[2][0].getOwner() == 1 && gameFields[2][2].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[0][1].getOwner() == 1 && gameFields[1][1].getOwner() == 1){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 2 && emptyFields.get(i)[1] == 2){
                if(gameFields[1][1].getOwner() == 1 && gameFields[0][0].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[2][1].getOwner() == 1 && gameFields[2][0].getOwner() == 1){ return emptyFields.get(i);}
                if(gameFields[0][2].getOwner() == 1 && gameFields[1][2].getOwner() == 1){ return emptyFields.get(i);}
            }
        }

        //Check for block player wins. Player is always 0
        for(int i = 0; i< emptyFields.size();i++) {
            if (emptyFields.get(i)[0] == 0 && emptyFields.get(i)[1] == 0){
                if(gameFields[0][1].getOwner() == 0 && gameFields[0][2].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[1][1].getOwner() == 0 && gameFields[2][2].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[1][0].getOwner() == 0 && gameFields[2][0].getOwner() == 0){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 0 && emptyFields.get(i)[1] == 1){
                if(gameFields[1][1].getOwner() == 0 && gameFields[2][1].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[0][0].getOwner() == 0 && gameFields[0][2].getOwner() == 0){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 0 && emptyFields.get(i)[1] == 2){
                if(gameFields[0][0].getOwner() == 0 && gameFields[0][1].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[1][2].getOwner() == 0 && gameFields[2][2].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[2][0].getOwner() == 0 && gameFields[1][1].getOwner() == 0){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 1 && emptyFields.get(i)[1] == 0){
                if(gameFields[0][0].getOwner() == 0 && gameFields[2][0].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[1][1].getOwner() == 0 && gameFields[1][2].getOwner() == 0){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 1 && emptyFields.get(i)[1] == 1){
                if(gameFields[0][0].getOwner() == 0 && gameFields[2][2].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[2][0].getOwner() == 0 && gameFields[0][2].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[1][0].getOwner() == 0 && gameFields[1][2].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[0][1].getOwner() == 0 && gameFields[2][1].getOwner() == 0){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 1 && emptyFields.get(i)[1] == 2){
                if(gameFields[0][2].getOwner() == 0 && gameFields[2][2].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[1][0].getOwner() == 0 && gameFields[1][1].getOwner() == 0){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 2 && emptyFields.get(i)[1] == 0){
                if(gameFields[1][1].getOwner() == 0 && gameFields[0][2].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[0][0].getOwner() == 0 && gameFields[1][0].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[2][1].getOwner() == 0 && gameFields[2][2].getOwner() == 0){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 2 && emptyFields.get(i)[1] == 1){
                if(gameFields[2][0].getOwner() == 0 && gameFields[2][2].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[0][1].getOwner() == 0 && gameFields[1][1].getOwner() == 0){ return emptyFields.get(i);}
            }
            else if (emptyFields.get(i)[0] == 2 && emptyFields.get(i)[1] == 2){
                if(gameFields[1][1].getOwner() == 0 && gameFields[0][0].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[2][1].getOwner() == 0 && gameFields[2][0].getOwner() == 0){ return emptyFields.get(i);}
                if(gameFields[0][2].getOwner() == 0 && gameFields[1][2].getOwner() == 0){ return emptyFields.get(i);}
            }
        }
        //If we cant make or block a winning move, we are going to use the prios from level 2.
        return level2(emptyFields);
    }
}
