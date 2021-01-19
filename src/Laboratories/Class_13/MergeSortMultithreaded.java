package Laboratories.Class_13;

import java.util.Arrays;

class Sorter extends Thread {
    int[] result;

    public Sorter(int[] originalArray) {
        this.result = originalArray;
    }

    public void run() {
        mergeSort(result);
    }

    public int[] getResult() {
        return result;
    }

    public void mergeSort(int[] array) {
        if (array.length > 1) {
            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            mergeHalves(array, left, right);
        }
    }

    public int[] leftHalf(int[] wholeArray) {
        int leftSize = wholeArray.length / 2;

        int[] left = new int[leftSize];

        for (int i = 0; i < leftSize; i++) {
            left[i] = wholeArray[i];
        }

        return left;
    }

    public int[] rightHalf(int[] wholeArray) {
        int leftSize = wholeArray.length / 2;
        int rightSize = wholeArray.length - leftSize;
        int[] right = new int[rightSize];

        for (int i = 0; i < rightSize; i++) {
            right[i] = wholeArray[i + leftSize];
        }

        return right;
    }

    public void mergeHalves(int[] resultArray, int[] leftArray, int[] rightArray) {
        int iLeft = 0;
        int iRight = 0;

        for (int i = 0; i < resultArray.length; i++) {
            if (iRight >= rightArray.length || (iLeft < leftArray.length && leftArray[iLeft] <= rightArray[iRight])) {
                resultArray[i] = leftArray[iLeft];
                iLeft++;
            } else {
                resultArray[i] = rightArray[iRight];
                iRight++;
            }
        }

        this.result = resultArray;
    }
}

public class MergeSortMultithreaded {
    public static int[] mergeResults(int[] leftArray, int[] rightArray) {
        if(leftArray.length == 0) {
            return rightArray;
        } else if (rightArray.length == 0) {
            return leftArray;
        }

        int[] resultArray = new int[leftArray.length + rightArray.length];
        int iLeft = 0, iRight = 0, iResult = 0;

        while (iLeft < leftArray.length && iRight < rightArray.length) {
            if (leftArray[iLeft] <= rightArray[iRight]) {
                resultArray[iResult] = leftArray[iLeft];
                iLeft++;
            } else {
                resultArray[iResult] = rightArray[iRight];
                iRight++;
            }
            iResult++;

            // edge case, we've reached the end of the array
            if (iLeft == leftArray.length) {
                while (iRight < rightArray.length) {
                    resultArray[iResult] = rightArray[iRight];
                    iResult++;
                    iRight++;
                }
            }
            if (iRight == rightArray.length) {
                while (iLeft < leftArray.length) {
                    resultArray[iResult] = leftArray[iLeft];
                    iResult++;
                    iLeft++;
                }
            }
        }

        return resultArray;
    }

    private static int[][] splitIntoSubarrays(int[] originalArray, int subarrays) {
        int[][] result = new int[subarrays][];
        // round up
        int subarraySize = (int) Math.ceil((double)originalArray.length / subarrays);

        for (int i = 0; i < subarrays; i++) {
            result[i] = Arrays.copyOfRange(
                    originalArray,
                    Math.min(i * subarraySize, originalArray.length),
                    Math.min(i * subarraySize + subarraySize, originalArray.length)
            );
        }

        return result;
    }

    private static int[] mergeSort(int[] originalArray, int threads) throws InterruptedException {
        int[][] subarrays = splitIntoSubarrays(originalArray, threads);

        Sorter[] sorters = new Sorter[threads];
        for(int i = 0; i < threads; i++) {
            sorters[i] = new Sorter(subarrays[i]);
            sorters[i].start();

            // wait until finish
            sorters[i].join();
        }

        // assumption there's at least one thread
        int[] result = sorters[0].getResult();

        for(int i = 1; i < threads; i++) {
            result = mergeResults(result, sorters[i].getResult());
        }

        return result;
    }

    public static void main(String[] args) throws InterruptedException {
        int threads = Runtime.getRuntime().availableProcessors();

        int[] unsortedArray = new int[]{10, -9, 20, 100, 50};

        System.out.println(Arrays.toString(unsortedArray));
        System.out.printf("Sorting using %s threads. \n", threads);
        System.out.println(Arrays.toString(mergeSort(unsortedArray, threads)));

        assert (mergeSort(new int[]{10, -9, 20, 100, 50}, 4) == new int[]{-9, 1, 20, 50, 100});
        assert (mergeSort(new int[]{}, 4) == new int[]{});
        assert (mergeSort(new int[]{1, 2, 3, 4, 5, 6}, 4) == new int[]{1, 2, 3, 4, 5, 6});

        assert (mergeSort(new int[]{10, -9, 20, 100, 50}, 3) == new int[]{-9, 1, 20, 50, 100});
        assert (mergeSort(new int[]{}, 3) == new int[]{});
        assert (mergeSort(new int[]{1, 2, 3, 4, 5, 6}, 3) == new int[]{1, 2, 3, 4, 5, 6});

        assert (mergeSort(new int[]{10, -9, 20, 100, 50}, 2) == new int[]{-9, 1, 20, 50, 100});
        assert (mergeSort(new int[]{}, 2) == new int[]{});
        assert (mergeSort(new int[]{1, 2, 3, 4, 5, 6}, 2) == new int[]{1, 2, 3, 4, 5, 6});

        assert (mergeSort(new int[]{10, -9, 20, 100, 50}, 1) == new int[]{-9, 1, 20, 50, 100});
        assert (mergeSort(new int[]{}, 1) == new int[]{});
        assert (mergeSort(new int[]{1, 2, 3, 4, 5, 6}, 1) == new int[]{1, 2, 3, 4, 5, 6});
    }
}
