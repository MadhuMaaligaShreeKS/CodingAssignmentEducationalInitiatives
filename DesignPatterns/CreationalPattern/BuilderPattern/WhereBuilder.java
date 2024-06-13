package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.BuilderPattern;

interface WhereBuilder {
    WhereBuilder addWhereCondition(String condition);
    SQLQuery build();
}
