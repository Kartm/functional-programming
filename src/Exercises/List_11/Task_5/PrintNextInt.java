package Exercises.List_11.Task_5;

import java.util.concurrent.*;

public class PrintNextInt {
    public static void main(String[] args) throws InterruptedException {
        // it's best to use ExecutorService
        // because it doesn't run periodically nor with a delay
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable task = () -> {
            for(int i = 0; i < 30; i++) {
                System.out.println(i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Future<?> future = executor.submit(task);

        executor.shutdown();
    }
}
