package CodingAssignment__.DesignPatterns.CreationalPattern.SingletonPattern;

import java.util.logging.*;

public class Logger {
    // ThreadLocal variable to hold the singleton instance of Logger for each thread
    private static final ThreadLocal<Logger> threadLocalInstance = ThreadLocal.withInitial(Logger::new);

    // Java's built-in logger
    private java.util.logging.Logger logger;

    // Private constructor to prevent instantiation from outside
    private Logger() {
        // Initialize Java's built-in logger
        logger = java.util.logging.Logger.getLogger(Logger.class.getName());
        logger.setLevel(Level.INFO);  // Set default logging level
        logger.addHandler(new ConsoleHandler());  // Add console handler
        logger.info("Logger initialized.");  // Log initialization
    }

    // Get the singleton instance of Logger for the current thread
    public static Logger getInstance() {
        return threadLocalInstance.get();
    }

    // Log a message at INFO level
    public void log(String message) {
        logger.info(message);
    }

    // Example of logging an exception
    public void logException(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }
}
