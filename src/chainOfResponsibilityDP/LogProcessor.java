package chainOfResponsibilityDP;

public abstract class LogProcessor {
    // static because these are common for all the instances of LogProcessor
    public static int INFO=1; // These are the log levels
    public static int DEBUG=2;
    public static int ERROR=3;

    LogProcessor nextLogProcessor;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLogProcessor = nextLogProcessor;
    }

    // This is the method that will be called by the client
    // This method will call the nextLogProcessor.log method
    public void log(int logLevel, String message){
        if (nextLogProcessor!=null){
            nextLogProcessor.log(logLevel, message);
        }
    }
}
