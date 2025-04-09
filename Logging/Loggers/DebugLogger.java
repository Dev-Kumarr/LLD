package Loggers;

import Enums.LogLevel;

public class DebugLogger extends LoggingObject {

    public DebugLogger(LoggingObject nextLogger) {
        super(nextLogger);
        this.logLevel = LogLevel.DEBUG.toString();
    }

    @Override
    public void Log(String logLevel, String message) {
        if (this.logLevel == logLevel) {
            System.out.println("DEBUG : " + message);
        } else {
            super.CallNextLogger(logLevel, message);
        }
    }

}
