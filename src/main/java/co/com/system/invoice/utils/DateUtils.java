package co.com.system.invoice.utils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtils {

    private static final String COLOMBIAN_ZONE = "America/Bogota";

    private DateUtils() {

    }

    public static String convertDateToString(final LocalDate date, final String  format) {
        return date.format(DateTimeFormatter.ofPattern(format));
    }

    public static LocalDate convertStringToDate(final String input, final String  format) {
        return  LocalDate.parse(input, DateTimeFormatter.ofPattern(format));
    }

    public static LocalDate getColombianDate(){
        Instant instantOfNow = Instant.now();
        ZoneId zoneId = ZoneId.of(COLOMBIAN_ZONE);
        return  instantOfNow.atZone(zoneId).toLocalDate();
    }

}
