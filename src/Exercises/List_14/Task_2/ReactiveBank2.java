package Exercises.List_14.Task_2;


import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.atomic.AtomicInteger;

// There are two bank accounts. This time reactive streams represent current value of
// money on the account ($1000, $200, $1600). Using reactive programming write a code
// which provide sum of both accounts on each change.

public class ReactiveBank2 {
    public static void main(String[] args) {
        AtomicInteger lastA = new AtomicInteger();
        AtomicInteger lastB = new AtomicInteger();

        Observable.just(1000, 200, 1600).subscribe(newTotal -> {
            lastA.set(newTotal);
            System.out.printf("New total on account A: %d. Sum of both accounts: %d\n", newTotal, lastA.get() + lastB.get());
        });

        Observable.just(240, 250, 2800).subscribe(newTotal -> {
            lastB.set(newTotal);
            System.out.printf("New total on account B: %d. Sum of both accounts: %d\n", newTotal, lastA.get() + lastB.get());
        });
    }
}
