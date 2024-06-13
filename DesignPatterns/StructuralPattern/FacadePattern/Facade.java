package CodingAssignment__.DesignPatterns.StructuralPattern.FacadePattern;

public class Facade {
    public static void main(String[] args) {
        // Create instances of specific components
        CPU cpu = new IntelCPU();
        Memory memory = new DDR4Memory();
        Storage storage = new SSDStorage();
        Network network = new EthernetNetwork();

        // Create a ComputerFacade instance with specific components
        ComputerFacade computer = new ComputerFacade(cpu, memory, storage, network);

        // Start the computer using the facade
        computer.start();
    }
}
