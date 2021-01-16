package Exercises.List_11.Task_3;

public class SynchronizedAccount {
    private int balance = 0;

    public SynchronizedAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void income(int change) {
        this.balance += change;
    }

    public synchronized void outcome(int change)  {
        this.balance -= change;
    }

    public int getBalance() {
        return this.balance;
    }
}
