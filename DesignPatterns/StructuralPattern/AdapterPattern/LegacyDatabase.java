package CodingAssignment__.DesignPatterns.StructuralPattern.AdapterPattern;

import java.util.logging.Logger;

class LegacyDatabase implements Database {
    private static final Logger logger = Logger.getLogger(LegacyDatabase.class.getName());

    @Override
    public void connect() {
        logger.info("Connecting to LegacyDB...");
        // Implementation details for connecting to legacy database
    }

    @Override
    public void executeQuery(String sql) {
        logger.info("Executing query in LegacyDB: " + sql);
        // Implementation details for executing query in legacy database
    }

    @Override
    public void disconnect() {
        logger.info("Disconnecting from LegacyDB...");
        // Implementation details for disconnecting from legacy database
    }
}

