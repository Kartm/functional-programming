package Exercises.List_11.Task_2;

public class UnsynchronizedAccount {
    private int balance = 0;

    public UnsynchronizedAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void income(int change) {
        this.balance += change;
    }

    public void outcome(int change)  {
        this.balance -= change;
    }

    public int getBalance() {
        return this.balance;
    }
}
