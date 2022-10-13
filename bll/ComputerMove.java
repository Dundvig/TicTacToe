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
        switch (level){
            case 1:
                return level1(emptyFields);
            case 2:
                return level2(emptyFields);
            default:
                return level3(emptyFields, gameFields);
        }
    }

    private static int[] level1(ArrayList<int[]> emptyFilds){
        Collections.shuffle(emptyFilds);
       return emptyFilds.get(0);
    }

    private static int[] level2(ArrayList<int[]> emptyFilds){
        ArrayList<int[]> prio1 = new ArrayList<>();
        prio1.add(new int[]{1,1});

        ArrayList<int[]> prio2 = new ArrayList<>();
        prio2.add(new int[]{0,0});
        prio2.add(new int[]{2,0});
        prio2.add(new int[]{0,2});
        prio2.add(new int[]{2,2});
        Collections.shuffle(prio2);

        ArrayList<int[]> prio3 = new ArrayList<>();
        prio3.add(new int[]{1,2});
        prio3.add(new int[]{1,0});
        prio3.add(new int[]{2,1});
        prio3.add(new int[]{0,1});
        Collections.shuffle(prio3);

        if(emptyFilds.contains(prio1.get(0))){
            return prio1.get(0);
        }

        for (int i = 0; i < prio2.size();i++){
            if (emptyFilds.contains(prio2.get(i))){
                return prio2.get(i);
            }
        }

        for (int i = 0; i < prio3.size();i++){
            if (emptyFilds.contains(prio3.get(i))){
                return prio3.get(i);
            }
        }

        return new int[0];
    }

    private static int[] level3(ArrayList<int[]> emptyFilds, GameField[][] gameFields){

        //Check for winning move

        //Check for blok playerwin

        //
        return new int[0];
    }



}
