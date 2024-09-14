package singletonDP;

public class EagerSingleton {
    private static final EagerSingleton instance= new EagerSingleton(); // eager initialization

    private EagerSingleton(){

    }

    public static EagerSingleton getInstance(){
        return instance;
    }
}

//Pros: Simple, thread-safe without synchronization.
//Cons: Instance is created even if it’s not used, leading to resource consumption.

class Main1 {
    public static void main(String[] args) {
        EagerSingleton eSingleton1=EagerSingleton.getInstance();
        EagerSingleton eSingleton2=EagerSingleton.getInstance();

        System.out.println(eSingleton1==eSingleton2);
    }
}
