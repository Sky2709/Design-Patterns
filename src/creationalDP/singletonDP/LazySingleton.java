package creationalDP.singletonDP;

public class LazySingleton {
    // private constructor to prevent instantiation
    private LazySingleton(){}

    private static class SingletonHelper{
        // inner class to hold the instance of the class
        private static final LazySingleton INSTANCE=new LazySingleton();
    }

    public static LazySingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
    //here the instance is created only when the getInstance() method is called
    //and lazy initialization is achieved by the inner class
    //Pros: Lazy-loaded, efficient, no synchronization overhead.
    //Cons: Slightly more complex to understand.
}

class Main2{
    public static void main(String[] args) {
        LazySingleton lazySingleton1=LazySingleton.getInstance();
        LazySingleton lazySingleton2=LazySingleton.getInstance();

        System.out.println(lazySingleton1==lazySingleton2);
    }
}
