package edu.isistan.solutions;

import edu.isistan.IProblemSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionSortSearch implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int target) {
        List<Pair> pair = new ArrayList<>();
        Arrays.sort(data);
        /*for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + ", ");
        }*/
        for(int i = 0; i < data.length - 1 && data[i] <= target; i++){
            int j = i + 1;
            while((j < data.length) && (data[i] + data[j] < target)){
                j++;
            }
            if(j < data.length){
                if(data[i] + data[j] == target) {
                    for (int k = j + 1; k < data.length && data[i] + data[k] == target; k++) {
                        pair.add((new Pair(data[i], data[k])));
                    }
                    pair.add((new Pair(data[i], data[j])));
                }
            }
        }

        return pair;
    }
}
