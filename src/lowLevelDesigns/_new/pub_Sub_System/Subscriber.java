package lowLevelDesigns._new.pub_Sub_System;

public interface Subscriber {
    void onMessage(Message message); // function of this interface is to receive the message
}
