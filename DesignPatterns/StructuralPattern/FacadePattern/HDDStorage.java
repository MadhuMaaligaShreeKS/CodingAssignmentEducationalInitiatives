package CodingAssignment__.DesignPatterns.StructuralPattern.FacadePattern;

class HDDStorage implements Storage {
    @Override
    public void loadBootLoader() {
        System.out.println("HDD Storage: Loading boot loader...");
    }
}