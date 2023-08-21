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
        for (int i = 0; i < data.length; i++) {
            this.resolveProblem(pairs, data, data[i], i, i, j, target);
        }
        return pairs;
    }

    public void resolveProblem(List<Pair> pairs, int[] data, int element, int pos_elem, int begin, int end, int target) {
        int middle = (begin + end) / 2;
        int suma = element + data[middle];

        if (begin > end)
            return;
        else {
            if (suma == target) {
                pairs.add(new Pair(element, data[middle]));
            } else if (suma < target)
                this.resolveProblem(pairs, data, element, pos_elem, middle + 1, end, target);
            else
                this.resolveProblem(pairs, data, element, pos_elem, begin, middle - 1, target);
        }
    }
}
