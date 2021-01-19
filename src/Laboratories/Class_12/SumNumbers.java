package Laboratories.Class_12;

import java.util.Collection;

public class SumNumbers {
    public static double sum(Collection<? extends Number> collection) {
        double sum = 0;
        for (Number num : collection) {
            sum += num.doubleValue();
        }
        return sum;
    }
}
