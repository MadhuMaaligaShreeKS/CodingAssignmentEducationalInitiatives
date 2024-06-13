package CodingAssignment__.DesignPatterns.BehavioralPattern.ObserverPattern;

class MobileAppDisplay implements StockObserver {
    @Override
    public void update(String stock, double price) {
        System.out.println("Mobile App Display: " + stock + " is now $" + price);
    }
}