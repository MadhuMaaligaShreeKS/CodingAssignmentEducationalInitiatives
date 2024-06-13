package CodingAssignmentEducationalInitiatives.DesignPatterns.StructuralPattern.FacadePattern;

class AMDCPU implements CPU {
    @Override
    public void boot() {
        System.out.println("AMD CPU: Booting up...");
    }
}
