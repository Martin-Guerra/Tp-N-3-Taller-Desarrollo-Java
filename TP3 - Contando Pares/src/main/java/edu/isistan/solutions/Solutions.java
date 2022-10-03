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
        IProblemSolver solution = new QuickSortAndBinarySearch(); //Casi anda, 6/7
        //IProblemSolver solution = new SolutionNaive(); Anda 7/7
        //IProblemSolver solution = new SolutionNaive2(); => Anda, 7/7
        int target = 4;
        int[] data = new int[10];
        data[0] = 1;
        data[1] = 2;
        data[2] = 3;
        data[3] = 4;
        data[4] = 5;
        data[5] = 2;
        data[6] = 0;
        data[7] = 0;
        data[8] = -1;
        data[9] = 2;
        problemGen.setData(data);
        problemGen.setTarget(target);
        System.out.print(problemGen.getData());
        List<IProblemSolver.Pair> solutionPair = solution.isSumIn(problemGen.getData(), target);
        System.out.println(" -- Pairs: " + solutionPair.size());
        for(IProblemSolver.Pair pair: solutionPair){
            System.out.println("(" + pair.getI() + ", " + pair.getJ() + ")");
        }
    }
}
