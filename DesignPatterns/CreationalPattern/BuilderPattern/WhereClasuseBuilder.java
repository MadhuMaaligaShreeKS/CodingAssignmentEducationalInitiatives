package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.BuilderPattern;
import java.util.StringJoiner;
class WhereClauseBuilder implements WhereBuilder {
    private StringJoiner query;

    public WhereClauseBuilder() {
        this.query = new StringJoiner(" AND ", " WHERE ", "");
    }

    public WhereBuilder addWhereCondition(String condition) {
        query.add(condition);
        return this;
    }

    public SQLQuery build() {
        return new SQLQuery(query.toString());
    }
}
