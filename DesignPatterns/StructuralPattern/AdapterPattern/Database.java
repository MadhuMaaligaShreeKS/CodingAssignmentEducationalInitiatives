package CodingAssignmentEducationalInitiatives.DesignPatterns.StructuralPattern.AdapterPattern;

interface Database {
    void connect();
    void executeQuery(String sql);
    void disconnect();
}
