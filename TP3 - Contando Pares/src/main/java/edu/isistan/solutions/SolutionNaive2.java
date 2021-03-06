package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import edu.isistan.IProblemSolver;

@SuppressWarnings("unused")
public class SolutionNaive2 implements IProblemSolver {

    public List<Pair> isSumIn(int[] data, int target) {

        List<Pair> pairs = new ArrayList<>();

        IntStream.range(0, data.length)
                .forEach(i -> IntStream.range(i + 1, data.length)
                        .filter(j -> i != j && data[i] + data[j] == target)
                        .forEach(j -> pairs.add(new Pair(data[i], data[j])))
                );

        return pairs;
    }

}