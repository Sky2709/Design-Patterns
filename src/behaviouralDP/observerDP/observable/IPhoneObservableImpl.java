package behaviouralDP.observerDP.observable;

import behaviouralDP.observerDP.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObservableImpl implements StocksObservable{
    public List<NotificationAlertObserver> observerList= new ArrayList<>();
    public int stockCount=0;

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer: observerList){
            observer.update();
        }
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void setStockCount(int newStockCount) {
        stockCount=newStockCount;
        notifyObservers();
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}
