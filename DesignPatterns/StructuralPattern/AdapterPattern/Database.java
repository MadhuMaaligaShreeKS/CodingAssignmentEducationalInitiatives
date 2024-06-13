package CodingAssignment__.DesignPatterns.StructuralPattern.AdapterPattern;

interface Database {
    void connect();
    void executeQuery(String sql);
    void disconnect();
}
