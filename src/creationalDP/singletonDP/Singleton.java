package creationalDP.singletonDP;

// basic Singleton implementation with thread safety and lazy instantiation:
public class Singleton {
    // Singleton class is a class that can have only one object (an instance of the class) at a time.
    private static Singleton instance; // static so that it is shared among all instances of the class

    private Singleton() {
        if (instance!=null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    // synchronized so that only one thread can execute this method at a time
    public static synchronized Singleton getInstance(){
        if (instance==null){
            instance=new Singleton();
        }
        return instance;
    }
}

class Main{
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();

        System.out.println(singleton1==singleton2);
    }
}
