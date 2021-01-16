package Exercises.List_11.Task_2;

import java.util.Random;

public class WithoutSynchronization {
    public static void main(String[] args) {
        UnsynchronizedAccount accountA = new UnsynchronizedAccount(50);

        Thread incomeOperations = new Thread(() -> {
            for(int i = 0; i < 500; i++) {
                accountA.income(1);
                System.out.println("Balance after income: " + accountA.getBalance());

                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread outcomeOperations = new Thread(() -> {
            for(int i = 0; i < 500; i++) {
                accountA.outcome(1);
                System.out.println("Balance after outcome: " + accountA.getBalance());

                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        incomeOperations.start();
        outcomeOperations.start();

        try {
            incomeOperations.join();
            outcomeOperations.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final balance: " + accountA.getBalance());

        /* I observed that the final balance is rarely "50".
         This is probably due to the lack of synchronization, for example:

         income#31 adds 1 to balance 30, new balance is 31
         outcome#31 removes 1 from balance 30, new balance is 29

         so they don't always "cancel out", resulting in final balance not being always 50
         therefore the final balance depends on the thread availability
        */
    }
}
