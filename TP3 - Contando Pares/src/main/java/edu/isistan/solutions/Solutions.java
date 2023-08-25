package edu.isistan.solutions;

import java.util.List;

import edu.isistan.IProblemSolver;
import edu.isistan.ProblemGen;

public class Solutions {

    public static void main(String[] args) {

        /*ProblemGen problemGen = new ProblemGen();

        IProblemSolver naive = new SolutionNaive();

        for (int i = 0; i < 20; i++) {
            problemGen.genRandomProblem(1000);
            System.out.println(Arrays.toString(problemGen.getData()));
            long start = System.currentTimeMillis();
            int target = (int) (Math.random() * 2 * Integer.MAX_VALUE + Integer.MIN_VALUE / 2);
            System.out.println(target);
            System.out.println(" -- Pairs: " + naive.isSumIn(problemGen.getData(), target).size());
            start = System.currentTimeMillis() - start;
            System.out.println(start);
        }*/

        ProblemGen problemGen = new ProblemGen();
        IProblemSolver solution = new MapAndNaive(); 
        
        int target = 4;
        int[] data = {1, 2, 3, 4, 5, 2, 0, 0, -1, 2};

        problemGen.setData(data);
        problemGen.setTarget(target);

        List<IProblemSolver.Pair> solutionPair = solution.isSumIn(problemGen.getData(), target);
        System.out.println("------- Pairs: " + solutionPair.size() + " -------");

        for(IProblemSolver.Pair pair: solutionPair){
            System.out.println("(" + pair.getI() + ", " + pair.getJ() + ")");
        }
    }
}
