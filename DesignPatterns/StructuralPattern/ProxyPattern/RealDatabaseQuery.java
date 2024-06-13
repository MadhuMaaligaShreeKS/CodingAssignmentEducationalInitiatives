package CodingAssignment__.DesignPatterns.StructuralPattern.ProxyPattern;

class RealDatabaseQuery implements DatabaseQuery {
    @Override
    public String execute(String query) {
        System.out.println("Executing query on the database: " + query);
        // Simulate database access delay
        try {
            Thread.sleep(1000); // Simulate time taken to execute the query
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Result of " + query;
    }
}
