package Exercises.List_14.Task_3;

// Write observable which emit next natural number every 20 seconds (start from 1) For
// this observable write a method which return factorial for current value. Try to optimize
// this code as much as you can (hint: you can use operators).

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class ReactiveFactorial {
    public static void main(String[] args) throws InterruptedException {
        Observable.interval(1, TimeUnit.SECONDS)
                .skip(1) // skip "0"
                .scan(1, (total, next) -> Math.toIntExact(total * next))
                .subscribe(s -> System.out.println(s));

        Thread.sleep(20000);
    }
}
