package Exercises.List_11.Task_1;

public class Main {

    public static void main(String[] args) {
        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        };
        task.run(); // run from main thread
        Thread thread = new Thread(task);
        thread.start(); // in runnable state, but the scheduler hasn't selected it to be the running thread YET
        System.out.println("Done!"); // main thread
    }
}
