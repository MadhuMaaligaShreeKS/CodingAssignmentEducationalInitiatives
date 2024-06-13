package CodingAssignmentEducationalInitiatives.DesignPatterns.StructuralPattern.FacadePattern;

class SSDStorage implements Storage {
    @Override
    public void loadBootLoader() {
        System.out.println("SSD Storage: Loading boot loader...");
    }
}