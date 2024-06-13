package CodingAssignmentEducationalInitiatives.DesignPatterns.StructuralPattern.FacadePattern;

class DDR4Memory implements Memory {
    @Override
    public void load() {
        System.out.println("DDR4 Memory: Loading system files...");
    }
}