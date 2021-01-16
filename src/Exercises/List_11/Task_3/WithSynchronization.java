package Exercises.List_11.Task_3;

public class WithSynchronization {
    public static void main(String[] args) {
        SynchronizedAccount accountA = new SynchronizedAccount(50);

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

        /* The final balance is always "50".
         The execution takes a bit longer (compared to task 2) probably due to synchronization.

         There is NO such situation:
         income#31 adds 1 to balance 30, new balance is 31
         outcome#31 removes 1 from balance 30, new balance is 29

         because "synchronized" keyword uses a Lock, outcome#31 waits until income#31 is finished,
         so they always "cancel out"
         therefore the final balance is always correct
        */
    }
}
