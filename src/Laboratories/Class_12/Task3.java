package Laboratories.Class_12;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        // List extends Collection

        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        System.out.println(SumNumbers.sum(integerList));

        List<Float> floatList = new ArrayList<>();
        floatList.add(1.2f);
        floatList.add(2.521f);
        floatList.add(3.000001f);
        System.out.println(SumNumbers.sum(floatList));

        // 'mixed' type collection
        List<Number> numberList = new ArrayList<>();
        numberList.add(1.2f);
        numberList.add(100);
        numberList.add(30.1d);
        System.out.println(SumNumbers.sum(numberList));
    }
}
