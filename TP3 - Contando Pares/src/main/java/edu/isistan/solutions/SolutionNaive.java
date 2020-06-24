package edu.isistan.solutions;

import java.util.ArrayList;
import java.util.List;

import edu.isistan.IProblemSolver;

@SuppressWarnings("unused")
public class SolutionNaive implements IProblemSolver {

    public List<Pair> isSumIn(int[] data, int target) {

        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < data.length; i++)
            for (int j = i + 1; j < data.length; j++)
                if ((data[i] + data[j]) == target)
                    pairs.add(new Pair(data[i], data[j]));

        return pairs;
    }

}
