package edu.isistan.solutions;

import edu.isistan.IProblemSolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("unused")
public class QuickSortAndBinarySearch implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int target) {

        List<Pair> pairs = new ArrayList<>();
        Arrays.sort(data);

        int j = data.length - 1;
        for (int i = 0; i < data.length - 1; i++) {
            this.resolveProblem(pairs, data, data[i], i, i, j, target);
        }
        return pairs;
    }

    private void resolveProblem(List<Pair> pairs, int[] data, int element, int pos_elem, int begin, int end, int target) {
        int middle = (begin + end) / 2;
        int suma = element + data[middle];

        if (suma == target && middle != pos_elem) {
            if (begin < middle) {
                this.resolveProblem(pairs, data, element, pos_elem, begin, middle, target);
                pairs.add(new Pair(element, data[middle]));
                /*this.resolveProblem(pairs, data, element, pos_elem, middle + 1, end, target);
                if (middle + 2 == data.length - 1) {
                    suma = element + data[middle + 2];
                    if (suma == target) {
                        if (middle + 2 != pos_elem) {
                            pairs.add(new Pair(element, data[middle + 2]));
                        }
                    }
                }*/
            } else {
                pairs.add(new Pair(element, data[middle]));
            }
        } else {
            if (begin < middle) {
                if (suma < target) {
                    this.resolveProblem(pairs, data, element, pos_elem, begin, middle, target);
                    this.resolveProblem(pairs, data, element, pos_elem, middle + 1, end, target);
                    if (middle + 2 == data.length - 1) {
                        suma = element + data[middle + 2];
                        if (suma == target) {
                            if (middle + 2 != pos_elem) {
                                pairs.add(new Pair(element, data[middle + 2]));
                            }
                        }
                    }
                } else {
                    this.resolveProblem(pairs, data, element, pos_elem, begin, middle, target);
                }
            }
        }
    }
}


