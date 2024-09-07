package observerDP.observer;

import observerDP.observable.StocksObservable;

public class MobileAlertObserver implements NotificationAlertObserver {
    String mobileNumber;
    StocksObservable observable;
    public MobileAlertObserver(String mobileNumber, StocksObservable observable){
        this.mobileNumber=mobileNumber;
        this.observable=observable;
    }
    @Override
    public void update() {
        sendSMS(mobileNumber, "iPhone is now available");
    }

    private void sendSMS(String mobileNumber, String msg) {
        System.out.println("SMS sent to "+mobileNumber+" with message: "+msg);
    }
}
