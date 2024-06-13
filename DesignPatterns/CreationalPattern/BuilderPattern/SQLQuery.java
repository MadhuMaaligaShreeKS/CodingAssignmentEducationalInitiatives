package CodingAssignment__.DesignPatterns.CreationalPattern.BuilderPattern;

// SQLQuery.java
public class SQLQuery {
    private String queryString;

    public SQLQuery(String queryString) {
        this.queryString = queryString;
    }

    public String getQueryString() {
        return queryString;
    }
}
