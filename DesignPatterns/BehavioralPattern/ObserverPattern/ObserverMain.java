package CodingAssignment__.DesignPatterns.BehavioralPattern.ObserverPattern;

public class ObserverMain {
    public static void main(String[] args) {
        StockMarketTicker stockMarketTicker = new StockMarketTicker();

        StockObserver textDisplay = new TextDisplay();
        StockObserver graphicalDisplay = new GraphicalDisplay();
        StockObserver mobileAppDisplay = new MobileAppDisplay();

        stockMarketTicker.registerObserver(textDisplay);
        stockMarketTicker.registerObserver(graphicalDisplay);
        stockMarketTicker.registerObserver(mobileAppDisplay);

        stockMarketTicker.setStockPrice("AAPL", 150.00);
        stockMarketTicker.setStockPrice("GOOGL", 2700.00);
    }
}
