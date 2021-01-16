package Exercises.List_11.Task_4;

import java.util.concurrent.ThreadLocalRandom;

public class Philosopher extends Thread {
    private int id;
    private Fork forkLeft;
    private Fork forkRight;

    public Philosopher(int id, Fork forkLeft, Fork forkRight) {
        this.id = id;
        this.forkLeft = forkLeft;
        this.forkRight = forkRight;
    }

    @Override
    public void run() {
        while(true) {
            forkLeft.grab();
            System.out.format("Philosopher #%d grabbed left fork\n", id);
            forkRight.grab();
            System.out.format("Philosopher #%d grabbed right fork\n", id);

            eat(10, 1000);

            forkLeft.release();
            System.out.format("Philosopher #%d released left fork\n", id);
            forkRight.release();
            System.out.format("Philosopher #%d released right fork\n", id);

            System.out.format("Philosopher #%d thinks...\n", id);
        }
    }

    private void eat(int minLength, int maxLength) {
        // using a thread-safe pseudorandom generator (prevent having the same seed in different threads)
        int randomTime = ThreadLocalRandom.current().nextInt(maxLength - minLength + 1) + minLength;
        System.out.format("Philosopher #%d eats for %d\n", id, randomTime);

        try {
            Thread.sleep(randomTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
