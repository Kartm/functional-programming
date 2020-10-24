package Exercises.List_1_2;

public class SumArray {
    private static int Sum(int[] array) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(Sum(new int[]{0, 0, 1, 2, 3, 4}));
    }
}
