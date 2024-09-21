package chainOfResponsibilityDP;

public class DebugLogProcessor extends LogProcessor {
    DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor); // This is calling the constructor of the parent class
    }

    public void log(int logLevel, String message) {
        if (logLevel == DEBUG) {
            System.out.println("DEBUG: " + message);
        } else {
            super.log(logLevel, message);
        }
    }
}
