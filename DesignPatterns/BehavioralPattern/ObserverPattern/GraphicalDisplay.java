package CodingAssignment__.DesignPatterns.BehavioralPattern.ObserverPattern;

class GraphicalDisplay implements StockObserver {
    @Override
    public void update(String stock, double price) {
        System.out.println("Graphical Display: " + stock + " is now $" + price);
    }
}

