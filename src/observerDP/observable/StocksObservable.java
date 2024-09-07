package observerDP.observable;

import observerDP.observer.NotificationAlertObserver;

public interface StocksObservable {
    public void add(NotificationAlertObserver observer);
    public void remove(NotificationAlertObserver observer);
    public void notifyObservers();
    public void setStockCount(int newStockCount);
    public int getStockCount();
}
