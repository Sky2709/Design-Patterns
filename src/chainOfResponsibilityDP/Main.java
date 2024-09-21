package chainOfResponsibilityDP;

public class Main {
    public static void main(String[] args) {
        LogProcessor logObject=new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logObject.log(LogProcessor.INFO, "This is an information message");
        logObject.log(LogProcessor.DEBUG, "This is a debug message");
        logObject.log(LogProcessor.ERROR, "This is an error message");

    }
}
