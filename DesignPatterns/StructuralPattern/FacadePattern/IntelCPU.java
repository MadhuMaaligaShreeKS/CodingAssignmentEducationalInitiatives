package CodingAssignment__.DesignPatterns.StructuralPattern.FacadePattern;

class IntelCPU implements CPU {
    @Override
    public void boot() {
        System.out.println("Intel CPU: Booting up...");
    }
}
