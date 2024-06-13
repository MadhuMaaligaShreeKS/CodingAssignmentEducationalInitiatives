package CodingAssignment__.DesignPatterns.StructuralPattern.AdapterPattern;
import java.util.logging.Logger;

class NewDatabase implements Database {
    private static final Logger logger = Logger.getLogger(NewDatabase.class.getName());

    @Override
    public void connect() {
        logger.info("Connecting to NewDB...");
        // Implementation details for connecting to new database
    }

    @Override
    public void executeQuery(String sql) {
        logger.info("Executing query in NewDB: " + sql);
        // Implementation details for executing query in new database
    }

    @Override
    public void disconnect() {
        logger.info("Disconnecting from NewDB...");
        // Implementation details for disconnecting from new database
    }
}
