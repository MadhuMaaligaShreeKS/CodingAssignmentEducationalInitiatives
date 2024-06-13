package CodingAssignment__.DesignPatterns.BehavioralPattern.ObserverPattern;
import java.util.*;
class StockMarketTicker implements StockMarket {
    private Map<String, Double> stockPrices = new HashMap<>();
    private List<StockObserver> observers = new ArrayList<>();

    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void setStockPrice(String stock, double price) {
        stockPrices.put(stock, price);
        notifyObservers(stock, price);
    }

    private void notifyObservers(String stock, double price) {
        for (StockObserver observer : observers) {
            observer.update(stock, price);
        }
    }
}

