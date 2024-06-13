package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.BuilderPattern;

import java.util.StringJoiner;

class SelectQueryBuilder implements SelectBuilder {
    private StringJoiner query;

    public SelectQueryBuilder() {
        this.query = new StringJoiner(", ", "SELECT ", "");
    }

    public SelectBuilder addSelectField(String field) {
        query.add(field);
        return this;
    }

    public SQLQuery build() {
        return new SQLQuery(query.toString());
    }
}
