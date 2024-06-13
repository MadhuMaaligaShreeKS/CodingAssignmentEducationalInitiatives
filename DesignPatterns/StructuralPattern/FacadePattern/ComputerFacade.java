package CodingAssignmentEducationalInitiatives.DesignPatterns.StructuralPattern.FacadePattern;

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private Storage storage;
    private Network network;

    public ComputerFacade(CPU cpu, Memory memory, Storage storage, Network network) {
        this.cpu = cpu;
        this.memory = memory;
        this.storage = storage;
        this.network = network;
    }

    public void start() {
        System.out.println("Starting computer...");
        cpu.boot();
        memory.load();
        storage.loadBootLoader();
        network.connect();
        System.out.println("Computer started successfully!");
    }
}
