package CodingAssignmentEducationalInitiatives.DesignPatterns.StructuralPattern.ProxyPattern;
import java.util.HashMap;
import java.util.Map;

class CachedDatabaseQuery implements DatabaseQuery {
    private RealDatabaseQuery realDatabaseQuery;
    private Map<String, String> cache;

    public CachedDatabaseQuery() {
        this.realDatabaseQuery = new RealDatabaseQuery();
        this.cache = new HashMap<>();
    }

    @Override
    public String execute(String query) {
        if (cache.containsKey(query)) {
            System.out.println("Returning cached result for query: " + query);
            return cache.get(query);
        } else {
            String result = realDatabaseQuery.execute(query);
            cache.put(query, result);
            return result;
        }
    }
}
