package CodingAssignment__.DesignPatterns.StructuralPattern.AdapterPattern;

class LegacyToNewDatabaseAdapter implements Database {
    private final Database legacyDatabase;

    public LegacyToNewDatabaseAdapter(Database legacyDatabase) {
        this.legacyDatabase = legacyDatabase;
    }

    @Override
    public void connect() {
        legacyDatabase.connect();
    }

    @Override
    public void executeQuery(String sql) {
        legacyDatabase.executeQuery(sql);
    }

    @Override
    public void disconnect() {
        legacyDatabase.disconnect();
    }
}

