package co.com.system.invoice.utils;

public class StringUtils {

    public static boolean isEmpty(String value) {
        return !isNotEmpty(value);
    }


    public static boolean isNotEmpty(String value) {
        return value!=null && !value.equals("");
    }


}
