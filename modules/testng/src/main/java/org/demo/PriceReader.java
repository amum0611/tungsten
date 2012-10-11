package org.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PriceReader {

    private Properties properties;
    /**
     * constructs a PriceReader instance
     * @param path the path of the property file
     * @exception IOException is thrown
     */
    public PriceReader(String path) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(path));
        
    }
    /**
     * returns the currency code
     * @param key the ISBN in the property file
     * @return Curreny Code
     */
    public String getCurrencyCode(String key) {
        String value = String.valueOf(properties.get(key));
        return value.split(" ")[0];
    }
    /**
     * returns the amount
     * @param key the ISBN in the property file
     * @return Amount
     */
    public long getAmount(String key) {
        return 0;
    }


}
