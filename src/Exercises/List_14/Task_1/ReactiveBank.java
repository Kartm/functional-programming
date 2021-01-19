package Exercises.List_14.Task_1;


import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.atomic.AtomicInteger;

// There are two bank accounts. Each is represented by stream of changes ( +$100, -$200
// etc.). Using reactive programming write a code which provide sum of both accounts on
// each change. Remember initial value of money on both accounts is $0.

public class ReactiveBank {
    public static void main(String[] args) {
        AtomicInteger aTotal = new AtomicInteger();
        AtomicInteger bTotal = new AtomicInteger();

        Observable.just(100, -200, 500).subscribe(change -> {
            aTotal.addAndGet(change);
            System.out.printf("Operation on account A: %d. Sum of both accounts: %d\n", change, aTotal.get() + bTotal.get());
        });
        Observable.just(50, -10, 230).subscribe(change -> {
            bTotal.addAndGet(change);
            System.out.printf("Operation on account B: %d. Sum of both accounts: %d\n", change, aTotal.get() + bTotal.get());
        });
    }
}
