package co.com.system.invoice.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    private DateUtils() {

    }

    public static String convertDateToString(final LocalDate date, final String  format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static LocalDate convertStringToDate(final String input, final String  format) {
        return  LocalDate.parse(input, DateTimeFormatter.ofPattern(format));
    }

}
