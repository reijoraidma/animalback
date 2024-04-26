package util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimestampConverter {

    public static String localDateTimeToString(LocalDateTime localDateTime) {
        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM");
        // Format the LocalDateTime object using the formatter
        return localDateTime.format(formatter);
    }
}
