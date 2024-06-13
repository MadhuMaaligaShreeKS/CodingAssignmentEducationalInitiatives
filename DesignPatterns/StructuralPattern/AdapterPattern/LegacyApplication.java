package CodingAssignmentEducationalInitiatives.DesignPatterns.StructuralPattern.AdapterPattern;
import java.util.logging.Logger;

public class LegacyApplication {
    private static final Logger logger = Logger.getLogger(LegacyApplication.class.getName());
    public static void main(String[] args) {
        // Dependency injection with LegacyDatabase
        Database legacyDatabase = new LegacyDatabase();
        Database adapter = new LegacyToNewDatabaseAdapter(legacyDatabase);

        try {
            adapter.connect();
            adapter.executeQuery("SELECT * FROM table");
        } catch (Exception e) {
            logger.severe("Error executing query: " + e.getMessage());
        } finally {
            adapter.disconnect();
        }
    }
}
