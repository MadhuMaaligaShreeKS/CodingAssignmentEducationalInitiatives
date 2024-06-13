package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.BuilderPattern;

public class BuilderMain {
    public static void main(String[] args) {
        SelectBuilder selectBuilder = new SelectQueryBuilder();
        WhereBuilder whereBuilder = new WhereClauseBuilder();

        SQLQuery selectQuery = selectBuilder
                .addSelectField("name")
                .addSelectField("age")
                .build();

        SQLQuery whereQuery = whereBuilder
                .addWhereCondition("age > 18")
                .build();

        System.out.println("Select Query: " + selectQuery.getQueryString());
        System.out.println("Where Query: " + whereQuery.getQueryString());
    }
}
