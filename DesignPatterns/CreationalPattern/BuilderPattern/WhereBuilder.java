package CodingAssignment__.DesignPatterns.CreationalPattern.BuilderPattern;

interface WhereBuilder {
    WhereBuilder addWhereCondition(String condition);
    SQLQuery build();
}
