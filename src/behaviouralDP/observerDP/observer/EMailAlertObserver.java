package behaviouralDP.observerDP.observer;

import behaviouralDP.observerDP.observable.StocksObservable;

public class EMailAlertObserver implements NotificationAlertObserver {
    String email;
    StocksObservable observable;
    public EMailAlertObserver(String email, StocksObservable observable){
        this.email=email;
        this.observable=observable;
    }
    @Override
    public void update() {
        sendEmail(email, "iPhone is now available");
    }

    private void sendEmail(String email, String msg) {
        System.out.println("mail sent to "+email+" with message: "+msg);
    }
}
