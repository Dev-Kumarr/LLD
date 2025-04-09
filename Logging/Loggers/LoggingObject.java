package Loggers;

public abstract class LoggingObject {
    private LoggingObject nextLogger;
    protected String logLevel;

    public LoggingObject(LoggingObject nextLogger) {
        this.nextLogger = nextLogger;
    }

    public abstract void Log(String logLevel, String message);

    public void CallNextLogger(String logLevel, String message) {
        nextLogger.Log(logLevel, message);
    }
}
