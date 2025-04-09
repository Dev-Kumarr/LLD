import Loggers.DebugLogger;
import Loggers.ErrorLogger;
import Loggers.InfoLogger;
import Loggers.LoggingObject;

public class Main {
    public static void main(String[] args) {
        LoggingObject logger = new InfoLogger(new DebugLogger(new ErrorLogger(null)));
        logger.Log("DEBUG", "This is a debug log");
        logger.Log("ERROR", "This is a error log");
        logger.Log("INFO", "This is a info log");
    }
}
