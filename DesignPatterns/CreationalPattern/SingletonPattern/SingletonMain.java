package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.SingletonPattern;

public class SingletonMain {
    public static void main(String[] args) {
        // Example of using the Logger singleton with threads
        Thread thread1 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Thread 1 started.");
            logger.log("Thread 1 executing.");
            logger.log("Thread 1 finished.");
        });

        Thread thread2 = new Thread(() -> {
            Logger logger = Logger.getInstance();
            logger.log("Thread 2 started.");
            logger.log("Thread 2 executing.");
            logger.log("Thread 2 finished.");
        });

        // Start threads
        thread1.start();
        thread2.start();
    }
}
