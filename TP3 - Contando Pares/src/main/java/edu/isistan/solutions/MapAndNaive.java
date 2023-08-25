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
            for (int j = i; j < optimizedData.length; j++) {
                if ((optimizedData[i] + optimizedData[j]) == target) {
                    int quantity = numbers.get(optimizedData[i]);

                    while (quantity >= 1) {
                        pairs.add(new Pair(optimizedData[i], optimizedData[j]));
                        quantity--;
                    }
                }
            }

        return pairs;
    }

    private Map<Integer, Integer> storeInMap(int[] data) {
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < data.length; i++) {
            if (numbers.containsKey(data[i])) {
                int oldValue = numbers.get(data[i]);
                numbers.replace(data[i], oldValue, oldValue + 1);
            } else {
                numbers.put(data[i], 1);
            }
        }

        return numbers;
    }
}
