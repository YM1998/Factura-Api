package co.com.system.invoice.utils;

public class SecurityUtils {

    private static final String SEPARATOR = "-";
    private static final Integer DEFAULT_COMPANY = 0;
    private static final Integer ONE = 1;

    public static String getUserName(String userName){
        String arrayData[] = userName.split(SEPARATOR);
        return arrayData[0];
    }

    public static Integer getSellingPoint(String userName){
        String arrayData[] = userName.split(SEPARATOR);
        if(arrayData.length > ONE) {
            return Integer.valueOf(arrayData[1]);
        }
        return DEFAULT_COMPANY;
    }



}
