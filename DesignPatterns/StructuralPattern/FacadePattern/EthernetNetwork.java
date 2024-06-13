package CodingAssignment__.DesignPatterns.StructuralPattern.FacadePattern;

class EthernetNetwork implements Network {
    @Override
    public void connect() {
        System.out.println("Ethernet Network: Connecting to the internet...");
    }
}