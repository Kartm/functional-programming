package Laboratories.Class_13;

//MERGE-SORT (T, p, r):
//     IF p <r:
//         q → (p + r) / 2
//         MERGE-SORT  (T, p, q)
//         MERGE-SORT  (T, q + 1, r)
//         MERGE (T, p, q, r)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Sorter extends Thread {
    int[] internal;

    public Sorter(int[] array) {
        this.internal = array;
    }

    public void run() {
        mergeSort(internal);
    }

    public int[] getResult() {
        return internal;
    }

    public void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    public int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    public int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    public void merge(int[] result, int[] left, int[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }

        this.internal = result;
    }
}

public class MergeSortMultithreaded {
    int threads = Runtime.getRuntime().availableProcessors();

    public static int[] finalMerge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int r = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[r] = a[i];
                i++;
                r++;
            } else {
                result[r] = b[j];
                j++;
                r++;
            }
            if (i == a.length) {
                while (j < b.length) {
                    result[r] = b[j];
                    r++;
                    j++;
                }
            }
            if (j == b.length) {
                while (i < a.length) {
                    result[r] = a[i];
                    r++;
                    i++;
                }
            }
        }

        return result;
    }

    private static int[][] splitIntoSubarrays(int[] originalArray, int subarrays) {
        int[][] result = new int[subarrays][];
        int subarraySize = (int) Math.ceil((double)originalArray.length / subarrays);

        for (int i = 0; i < subarrays; i++) {
            result[i] = Arrays.copyOfRange(originalArray, i * subarraySize, Math.min(i * subarraySize + subarraySize, originalArray.length));
        }

        return result;
    }

    private static int[] mergeSort(int[] originalArray) throws InterruptedException {
        int[][] subarrays = splitIntoSubarrays(originalArray, 2);
        Sorter sorter1 = new Sorter(subarrays[0]);
        Sorter sorter2 = new Sorter(subarrays[1]);

        sorter1.start();
        sorter2.start();

        // wait until finish
        sorter1.join();
        sorter2.join();

        return finalMerge(sorter1.getResult(), sorter2.getResult());
    }

    // pass threads as parameter
    public static void main(String[] args) throws InterruptedException {
        int[] unsortedArray = new int[]{10, -9, 20, 100, 50};

        System.out.println(Arrays.toString(mergeSort(unsortedArray)));

        assert (mergeSort(new int[]{10, -9, 20, 100, 50}) == new int[]{-9, 1, 20, 50, 100});
        assert (mergeSort(new int[]{}) == new int[]{});
        assert (mergeSort(new int[]{1, 2, 3, 4, 5, 6}) == new int[]{1, 2, 3, 4, 5, 6});
    }
}
