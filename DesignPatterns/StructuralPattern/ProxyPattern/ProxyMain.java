package CodingAssignment__.DesignPatterns.StructuralPattern.ProxyPattern;

public class ProxyMain {
    public static void main(String[] args) {
        DatabaseQuery queryProxy = new CachedDatabaseQuery();

        // First execution, query will be executed on the database
        System.out.println(queryProxy.execute("SELECT * FROM users"));
        // Second execution, query result will be returned from cache
        System.out.println(queryProxy.execute("SELECT * FROM users"));

        // New query execution, will be executed on the database
        System.out.println(queryProxy.execute("SELECT * FROM orders"));
        // Second execution, query result will be returned from cache
        System.out.println(queryProxy.execute("SELECT * FROM orders"));
    }
}
