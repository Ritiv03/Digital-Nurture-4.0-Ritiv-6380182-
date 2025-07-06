package ObserverPattern;


import java.util.ArrayList;
import java.util.List;

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void setStock(String name, double price) {
        this.stockName = name;
        this.stockPrice = price;
        notifyObservers();
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }
}
interface Observer {
    void update(String stockName, double stockPrice);
}
class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    public void update(String stockName, double stockPrice) {
        System.out.println("MobileApp [" + name + "] - Stock: " + stockName + " Price: Rs." + stockPrice);
    }
}

class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    public void update(String stockName, double stockPrice) {
        System.out.println("WebApp [" + name + "] - Stock: " + stockName + " Price: Rs." + stockPrice);
    }
}
public class Main {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileUser = new MobileApp("Ritiv");
        Observer webUser = new WebApp("Best-in-vest");

        market.register(mobileUser);
        market.register(webUser);

        market.setStock("Cognizant", 372500.50);  // All observers will be notified

        market.deregister(mobileUser);

        market.setStock("Cognizant", 754800.90); // Only WebApp will be notified
    }
}
