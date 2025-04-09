package Loggers;

import Enums.LogLevel;

public class InfoLogger extends LoggingObject {

    public InfoLogger(LoggingObject nextLogger) {
        super(nextLogger);
        this.logLevel = LogLevel.INFO.toString();
    }

    @Override
    public void Log(String logLevel, String message) {
        if (logLevel == this.logLevel) {
            System.out.println("INFO : " + message);
        } else {
            super.CallNextLogger(logLevel, message);
        }
    }

}
