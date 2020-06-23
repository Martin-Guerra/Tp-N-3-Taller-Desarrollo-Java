package edu.isistan.solutions;

import edu.isistan.IProblemSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSortAndBinarySearch implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int target) {
        List<Pair> pairs = new ArrayList<>();
        Arrays.sort(data);

        int j = data.length - 1;
        for (int i = 0; i < data.length; i++){
            this.resolveProblem(pairs, data, data[i], i, i, j, target);
        }
        return pairs;
    }

    private void resolveProblem(List<Pair> pairs, int[] data, int element, int pos_elem, int begin, int end, int target) {
        int middle = (end - begin) / 2;
        int suma = element + data[middle];

        if (suma < target && begin < middle) {
            this.resolveProblem(pairs, data, element, pos_elem, begin, middle, target);
            middle += 1;
            this.resolveProblem(pairs, data, element, pos_elem, middle, end, target);
        } else if (suma == target) {
            if (begin != pos_elem) {
                pairs.add(new Pair(element, data[begin]));
            }
        }
    }
}
