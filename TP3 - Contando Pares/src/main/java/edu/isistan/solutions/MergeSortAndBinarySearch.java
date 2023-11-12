package edu.isistan.solutions;

import edu.isistan.IProblemSolver;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"DuplicatedCode", "unused"})
public class MergeSortAndBinarySearch implements IProblemSolver {

    @Override
    public List<Pair> isSumIn(int[] data, int target) {
        List<Pair> pairs = new ArrayList<>();

        this.mergeSort(data, 0, data.length - 1);

        int j = data.length - 1;
        for (int i = 0; i < data.length; i++) {
            this.resolveProblem(pairs, data, data[i], i, i, j, target);
        }
        return pairs;
    }

    private void resolveProblem(List<Pair> pairs, int[] data, int element, int pos_elem, int begin, int end, int target) {
        int middle = (end + begin) / 2;
        int suma = element + data[middle];

        if (begin > end)
            return;
        else {
            if (suma == target) {
                if (middle != pos_elem)
                    pairs.add(new Pair(element, data[middle]));

                this.resolveProblem(pairs, data, element, pos_elem, middle + 1, end, target);
                this.resolveProblem(pairs, data, element, pos_elem, begin, middle - 1, target);
            } else if (suma < target)
                this.resolveProblem(pairs, data, element, pos_elem, middle + 1, end, target);
            else
                this.resolveProblem(pairs, data, element, pos_elem, begin, middle - 1, target);
        }
    }

    private void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int m = left + (right - left) / 2;

            mergeSort(data, left, m);
            mergeSort(data, m + 1, right);

            merge(data, left, m, right);
        }
    }

    private void merge(int[] data, int l, int m, int r) {
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        //Divido el arreglo entrante, cargando las partes izquierda y derecha.
        for (i = 0; i < n1; i++)
            leftArray[i] = data[l + i];
        for (j = 0; j < n2; j++)
            rightArray[j] = data[m + 1 + j];

        //Hago el merge.
        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                data[k] = leftArray[i];
                i++;
            } else {
                data[k] = rightArray[j];
                j++;
            }
            k++;
        }

        //Si sucede que una de las dos partes tiene mas elementos que la otra, debo cargarlos en el arreglo resultante del merge.
        while (i < n1) {
            data[k] = leftArray[i];
            i++;
            k++;
        }
    }

}
