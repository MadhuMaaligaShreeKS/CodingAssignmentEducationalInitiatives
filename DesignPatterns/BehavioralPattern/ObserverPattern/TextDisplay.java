package CodingAssignmentEducationalInitiatives.DesignPatterns.BehavioralPattern.ObserverPattern;

class TextDisplay implements StockObserver {
    @Override
    public void update(String stock, double price) {
        System.out.println("Text Display: " + stock + " is now $" + price);
    }
}

