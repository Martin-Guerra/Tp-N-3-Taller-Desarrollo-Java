package edu.isistan.solutions;

import edu.isistan.IProblemSolver;

import java.util.*;

public class MapAndNaive implements IProblemSolver {
    @Override
    public List<Pair> isSumIn(int[] data, int target) {
        List<Pair> pairs = new ArrayList<>();

        Map<Integer, Integer> numbers = this.storeInMap(data);
        int[] optimizedData = numbers.keySet().stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < optimizedData.length; i++) {
            if(numbers.get(optimizedData[i]) > 1 && optimizedData[i]*2 == target){
                int valueMap = numbers.get(optimizedData[i]);
                while(valueMap > 1){
                    for (int k = 0; k < valueMap - 1; k++) {
                        pairs.add(new Pair(optimizedData[i], optimizedData[i]));
                    }
                    valueMap--;
                }
            } else {
                for (int j = i + 1; j < optimizedData.length; j++) {
                    if ((optimizedData[i] + optimizedData[j]) == target) {
                        for (int k = 0; k < numbers.get(optimizedData[i]); k++) {
                            pairs.add(new Pair(optimizedData[i], optimizedData[j]));
                        }
                    }
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
