package Exercises.List_11.Task_4;

public class Problem {
    public static void main(String[] args) {
        int n = 5;

        Fork[] forks = new Fork[n];
        Philosopher[] philosophers = new Philosopher[n];

        for(int i = 0; i < n; i++) {
            forks[i] = new Fork();
        }

        for(int i = 0; i < n; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i+1)%n];

            if(i != n - 1) {
                philosophers[i] = new Philosopher(i, leftFork, rightFork);
            } else {
                // avoid the situation where all philosophers
                // picked up the left fork and put it down simultaneously

                // so the last philosopher holds them in a opposite way

                /*
                F1 F2 F3 F4 F5
                P1 P2 P3 P4 P5
                 */
                philosophers[i] = new Philosopher(i, rightFork, leftFork);
            }

            philosophers[i].start(); // make thread ready to run
        }

        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
