package edu.isistan.solutions;

import edu.isistan.IProblemSolver;

import java.util.*;

public class MapAndBinarySearch implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int target) {
        List<Pair> pairs = new ArrayList<>();

        Map<Integer, Integer> numbers = this.storeInMap(data);
        int[] optimizedData = numbers.keySet().stream().mapToInt(Integer::intValue).toArray();

        int j = data.length - 1;
        for (int i = 0; i < optimizedData.length; i++) {
            this.resolveProblem(pairs, optimizedData, optimizedData[i], i, i, j, target);
        }
        return pairs;
    }

    private Map<Integer, Integer> storeInMap(int[] data) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            if (!numbers.containsKey(data[i])) {
                int ocurrencias = 0;

                for (int j = i; j < data.length; j++) {
                    if (data[j] == data[i])
                        ocurrencias++;
                }

                numbers.put(data[i], ocurrencias);
            }
        }

        return numbers;
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
