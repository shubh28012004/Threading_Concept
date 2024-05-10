// Thread creation and methods example
class MyThread extends Thread {
    // Constructor to give a name to the thread
    public MyThread(String name) {
        super(name);
    }

    // Run method that contains the code to be executed by the thread
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running.");
        try {
            // Sleep for 1 second
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted.");
        }
        System.out.println("Thread " + Thread.currentThread().getName() + " has finished running.");
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a new thread
        MyThread thread1 = new MyThread("Thread-1");
        // Start the thread
        thread1.start();

        // Check if the thread is alive
        System.out.println("Is thread1 alive? " + thread1.isAlive());

        try {
            // Wait for the thread to finish
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted.");
        }

        // Check if the thread is alive after joining
        System.out.println("Is thread1 alive after joining? " + thread1.isAlive());

        // Get the thread priority
        System.out.println("Thread1 priority: " + thread1.getPriority());

        // Set the thread priority
        thread1.setPriority(Thread.MAX_PRIORITY);
        System.out.println("Thread1 new priority: " + thread1.getPriority());

        // Check if the thread is a daemon thread
        System.out.println("Is thread1 a daemon thread? " + thread1.isDaemon());

        // Set thread1 as a daemon thread
        thread1.setDaemon(true);
        System.out.println("Is thread1 a daemon thread after setting? " + thread1.isDaemon());
    }
}
