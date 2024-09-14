package singletonDP;

public class DoubleCheckedLockingSingleton {
    private static volatile DoubleCheckedLockingSingleton instance;

    public DoubleCheckedLockingSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static DoubleCheckedLockingSingleton getInstance(){
        if (instance==null){
            synchronized (DoubleCheckedLockingSingleton.class){
                if (instance== null){
                    instance=new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }

    //Pros: Performance optimized, thread-safe.
    //Cons: Can be complex and overkill in simpler cases.
    //Note: The volatile keyword ensures that multiple threads
    //handle the instance variable correctly when it is being initialized to the Singleton instance.
    //here we are using double-checked locking to reduce the use of synchronization in getInstance() method.
}

class Main3{
    public static void main(String[] args) {
        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton1=DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton doubleCheckedLockingSingleton2=DoubleCheckedLockingSingleton.getInstance();

        System.out.println(doubleCheckedLockingSingleton1==doubleCheckedLockingSingleton2);
    }
}


