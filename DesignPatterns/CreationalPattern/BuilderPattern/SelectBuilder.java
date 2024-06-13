package CodingAssignmentEducationalInitiatives.DesignPatterns.CreationalPattern.BuilderPattern;

interface SelectBuilder {
    SelectBuilder addSelectField(String field);
    SQLQuery build();
}

