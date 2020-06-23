package edu.isistan.solutions;

import edu.isistan.IProblemSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveSolution implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int target) {
        List<Pair> pair = new ArrayList<>();
        Arrays.sort(data);
        int j = data.length;
        for(int i = 0; data[i] < target; i++){
            this.resolveProblem(pair, data, data[i], i,  i, j, target);
        }
        return pair;
    }

    private void resolveProblem(List<Pair> pair, int[] data, int element, int pos_elem, int begin, int end, int target) {
        if(begin < end){
            int middle = (end - begin) / 2;
                if (element + data[middle] <= target) {
                    this.resolveProblem(pair, data, element, pos_elem, begin, middle, target);
                    this.resolveProblem(pair, data, element, pos_elem, middle + 1, end, target);
                } else {
                    this.resolveProblem(pair, data, element, pos_elem, begin, middle, target);
                }
        }
        else{
            if(begin != pos_elem) {
                if (element + data[begin] == target) {
                    pair.add(new Pair(element, data[begin]));
                }
            }
        }
    }
}
