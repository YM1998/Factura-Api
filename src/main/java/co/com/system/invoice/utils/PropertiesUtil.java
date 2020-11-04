package co.com.system.invoice.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {


    public  String getPropValues(String fileName, String code)  {
        String result = "";
        InputStream inputStream=null;

        try {
            Properties prop = new Properties();
            inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            prop.load(inputStream);
            result  = prop.getProperty(code);
        } catch (Exception e) {
        } finally {
            if(inputStream!=null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
        }
        return result;
    }


}