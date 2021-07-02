package co.com.system.invoice.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private DateUtils() {

    }

    public static String convertDateToString(final Date date, final String  format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.format(date);
        }catch(Exception ex) {
            return null;
        }
    }

    public static Date convertStringToDate(final String input, final String  format) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            return simpleDateFormat.parse(input);
        }catch (Exception e) {
            return null;
        }
    }

}
