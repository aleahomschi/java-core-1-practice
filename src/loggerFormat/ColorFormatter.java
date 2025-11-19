package loggerFormat;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ColorFormatter extends Formatter {

    private static final String RESET = "\u001B[0m";
    private static final String RED = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN = "\u001B[32m";

    @Override
    public String format(LogRecord record) {
        String color = switch (record.getLevel().getName()) {
            case "SEVERE" -> RED;
            case "WARNING" -> YELLOW;
            case "INFO" -> GREEN;
            default -> RESET;
        };

        return String.format(
                "%s[%s] %s%s%n",
                color,
                record.getLevel().getLocalizedName(),
                record.getMessage(),
                RESET
        );
    }
}
