package lowLevelDesigns._new.pub_Sub_System;

public class PrintSubscriber implements Subscriber{
    private String name;

    public PrintSubscriber(String name) {
        this.name = name;
    }
    @Override
    public void onMessage(Message message) {
        System.out.println("Subscriber: "+name+" received message: "+message.getContent());
    }
}
