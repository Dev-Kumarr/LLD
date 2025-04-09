package Loggers;

import Enums.LogLevel;

public class ErrorLogger extends LoggingObject {

    public ErrorLogger(LoggingObject nextLogger) {
        super(nextLogger);
        this.logLevel = LogLevel.ERROR.toString();
    }

    @Override
    public void Log(String logLevel, String message) {
        if (this.logLevel == logLevel) {
            System.out.println("ERROR : " + message);
        } else {
            super.CallNextLogger(logLevel, message);
        }
    }

}
