package edu.isistan.solutions;

import edu.isistan.IProblemSolver;

import java.util.*;

public class MapAndNaive implements IProblemSolver {
    @Override
    public List<Pair> isSumIn(int[] data, int target) {
        List<Pair> pairs = new ArrayList<>();

        Map<Integer, Integer> numbers = this.storeInMap(data);
        int[] optimizedData = numbers.keySet().stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < optimizedData.length; i++)
            for (int j = i + 1; j < optimizedData.length; j++) {
                if ((optimizedData[i] + optimizedData[j]) == target)
                    pairs.add(new Pair(optimizedData[i], optimizedData[j]));
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
}
