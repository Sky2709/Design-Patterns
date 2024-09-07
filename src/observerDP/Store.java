package observerDP;

import observerDP.observable.IPhoneObservableImpl;
import observerDP.observable.StocksObservable;
import observerDP.observer.EMailAlertObserver;
import observerDP.observer.MobileAlertObserver;
import observerDP.observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable iphoneStockObservable = new IPhoneObservableImpl();
        NotificationAlertObserver observer1 = new EMailAlertObserver("xyz@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EMailAlertObserver("abc@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserver("9685743610", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
    }
}
